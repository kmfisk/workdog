package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
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
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class WDWolfEntity extends WorkDogEntity {
    public WDWolfEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.ATTACK_DAMAGE, 5.0F);
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        if (spawnData == null) {
            if (!WorkDogConfig.pedigreeMode.get()) spawnData = new AgeableData(0.1F);
            else spawnData = new AgeableData(false);
        }
        return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
    }

    @Override
    public int getVariantCount() {
        return 4;
    }

    public String getVariantName() {
        switch (getVariant()) {
            case 0:
                return WolfVariant.BLACK.name();
            case 1:
                return WolfVariant.BROWN.name();
            case 2:
                return WolfVariant.GRAY.name();
            case 3:
                return WolfVariant.WHITE.name();
            default:
                throw new IllegalStateException("Unexpected Wolf variant, value of: " + getVariant());
        }
    }

    public int getCarriedVariant(String name) {
        int size = WolfVariant.getCarriedVariants(name).size();
        return WolfVariant.getCarriedVariants(name).get(random.nextInt(size));
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
            WorkDogEntity partner = (WorkDogEntity) entity;
            WorkDogEntity baby = null;
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

                if (baby != null) baby.setVariant(random.nextInt(baby.getVariantCount()));
            }

            if (baby == null) {
                baby = WorkDogEntities.WOLF.create(world);
                if (baby != null) baby.setupChildVariant(this, partner);
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
        WHITE(Collections.singletonList(3));

        private final List<Integer> carries;

        WolfVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(String name) {
            return WolfVariant.valueOf(name).carries;
        }
    }
}
