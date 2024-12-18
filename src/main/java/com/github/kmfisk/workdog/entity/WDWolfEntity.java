package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.github.kmfisk.workdog.entity.goal.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.Tags;

import javax.annotation.Nullable;
import java.util.*;

public class WDWolfEntity extends WorkDogEntity {
    public WDWolfEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.25F).add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.ATTACK_DAMAGE, 5.0F);
    }

    @Override
    public Tags.IOptionalNamedTag<EntityType<?>> getWorkGroupTag() {
        return null;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(1, new SitGoal(this));
        this.goalSelector.addGoal(2, new DogBirthGoal(this));
        this.goalSelector.addGoal(3, new DogTemptGoal(this, 0.6D));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.5D, true));
        this.goalSelector.addGoal(6, new FollowMotherGoal(this, 1.1D));
        this.goalSelector.addGoal(9, new DogBreedGoal(this, 1.2D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new WolfTargetNearestGoal<>(this, LivingEntity.class, true,
                (entity) -> WorkDogConfig.wolfPreyList.get().contains(Objects.requireNonNull(entity.getType().getRegistryName()).toString())));
        this.targetSelector.addGoal(3, new AttackableTargetRangedGoal<>(this, LivingEntity.class, true, false, 8.0D,
                (entity) -> entity instanceof IMob));
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        if (spawnData == null) {
            if (!WorkDogConfig.pedigreeMode.get()) spawnData = new AgeableData(0.1F);
            else spawnData = new AgeableData(false);
        }
        spawnData = super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
        Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(RegistryKey.create(Registry.BIOME_REGISTRY, world.getLevel().getBiome(blockPosition()).getRegistryName()));
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
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        if (entity instanceof WorkDogEntity) {
            WorkDogEntity baby = WorkDogEntities.WOLF.create(world);
            if (random.nextFloat() <= 0.05F) {
                Biome biome = level.getBiome(blockPosition());
                Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(RegistryKey.create(Registry.BIOME_REGISTRY, biome.getRegistryName()));
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

    public static boolean checkWolfSpawnRules(EntityType<? extends WDWolfEntity> entityType, IServerWorld world, SpawnReason spawnReason, BlockPos pos, Random random) {
        BlockState blockState = world.getBlockState(pos.below());
        return (blockState.is(Blocks.GRASS_BLOCK) || blockState.is(Blocks.SNOW) || blockState.is(BlockTags.ICE)
                || Tags.Blocks.SAND.contains(blockState.getBlock()) || Tags.Blocks.DIRT.contains(blockState.getBlock()))
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
