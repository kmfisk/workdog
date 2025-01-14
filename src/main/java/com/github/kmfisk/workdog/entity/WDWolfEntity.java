package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.github.kmfisk.workdog.entity.goal.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.BiomeDictionary;

import javax.annotation.Nullable;
import java.util.*;

public class WDWolfEntity extends WorkDogEntity {
    public WDWolfEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.25F).add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.ATTACK_DAMAGE, 5.0F);
    }

    @Override
    public TagKey<EntityType<?>> getWorkGroupTag() {
        return null;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new DogBirthGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new DogTemptGoal(this, 0.6D));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.5D, true));
        this.goalSelector.addGoal(6, new FollowMotherGoal(this, 1.1D));
        this.goalSelector.addGoal(9, new DogBreedGoal(this, 1.2D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new WolfTargetNearestGoal<>(this, LivingEntity.class, true,
                (entity) -> WorkDogConfig.wolfPreyList.get().contains(Objects.requireNonNull(entity.getType().getRegistryName()).toString())));
        this.targetSelector.addGoal(3, new AttackableTargetRangedGoal<>(this, LivingEntity.class, true, false, 8.0D,
                (entity) -> entity instanceof Enemy));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        if (spawnData == null) {
            if (!WorkDogConfig.pedigreeMode.get()) spawnData = new AgeableMobGroupData(0.1F);
            else spawnData = new AgeableMobGroupData(false);
        }
        spawnData = super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
        Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(ResourceKey.create(Registry.BIOME_REGISTRY, world.getLevel().getBiome(blockPosition()).value().getRegistryName()));
        if (biomeTypes.contains(BiomeDictionary.Type.SNOWY))
            setVariant(dataTag != null && dataTag.contains("Variant") ? dataTag.getInt("Variant") : 3);
        return spawnData;
    }

    @Override
    public int getVariantCount() {
        return 4;
    }

    public int getCarriedVariant(int variant) {
        int size = WolfVariant.getCarriedVariants(variant).size();
        return WolfVariant.getCarriedVariants(variant).get(random.nextInt(size));
    }

    @Override
    public boolean hasLonghairVariants() {
        return false;
    }

    @Override
    public float getLonghairChance() {
        return 1.0F;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
        if (entity instanceof WorkDogEntity) {
            WorkDogEntity baby = WorkDogEntities.WOLF.create(world);
            if (random.nextFloat() <= 0.05F) {
                Biome biome = level.getBiome(blockPosition()).value();
                Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(ResourceKey.create(Registry.BIOME_REGISTRY, biome.getRegistryName()));
                if (biomeTypes.contains(BiomeDictionary.Type.PLAINS) && !biomeTypes.contains(BiomeDictionary.Type.HOT) && !biomeTypes.contains(BiomeDictionary.Type.COLD)) {
                    baby = WorkDogEntities.PIT_BULL.create(world);
                }

                if ((biomeTypes.contains(BiomeDictionary.Type.CONIFEROUS) && biomeTypes.contains(BiomeDictionary.Type.FOREST)) ||
                        (biomeTypes.contains(BiomeDictionary.Type.MOUNTAIN) && !biomeTypes.contains(BiomeDictionary.Type.HOT) && !biomeTypes.contains(BiomeDictionary.Type.FOREST))) {
                    baby = WorkDogEntities.AKITA.create(world);
                }
            }

            return baby;
        }

        return null;
    }

    public static boolean checkWolfSpawnRules(EntityType<? extends WDWolfEntity> entityType, ServerLevelAccessor world, MobSpawnType spawnReason, BlockPos pos, Random random) {
        BlockState blockState = world.getBlockState(pos.below());
        return (blockState.is(Blocks.GRASS_BLOCK) || blockState.is(Blocks.SNOW) || blockState.is(BlockTags.ICE)
                || blockState.is(BlockTags.SAND) || blockState.is(BlockTags.DIRT))
                && world.getRawBrightness(pos, 0) < 13;
    }

    public enum WolfVariant {
        BLACK(Collections.singletonList(2)),
        BROWN(Collections.singletonList(2)),
        GRAY(Collections.singletonList(1)),
        WHITE(Collections.singletonList(3)),
        ALBINISTIC(Collections.singletonList(3)),
        MELANISTIC(Collections.singletonList(0));

        private final List<Integer> carries;

        WolfVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(int variant) {
            return WolfVariant.values()[variant].carries;
        }
    }
}
