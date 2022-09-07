package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.WorkingDogEntity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.BiomeDictionary;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class WDWolfEntity extends WorkingDogEntity {
    public WDWolfEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.30F).add(Attributes.MAX_HEALTH, 18.0F).add(Attributes.ATTACK_DAMAGE, 6.0F);
    }

    @Override
    public int getVariantCount() {
        return 4;
    }

    public String getVariantName() {
        switch (getVariant()) {
            case 0:
                return Variant.BLACK.name();
            case 1:
                return Variant.BROWN.name();
            case 2:
                return Variant.GRAY.name();
            case 3:
                return Variant.WHITE.name();
            default:
                throw new IllegalStateException("Unexpected Wolf variant, value of: " + getVariant());
        }
    }

    public int getCarriedVariant(String name) {
        int size = Variant.getCarriedVariants(name).size();
        return Variant.getCarriedVariants(name).get(random.nextInt(size));
    }

    @Override
    public boolean hasLonghair() {
        return false;
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        if (entity instanceof WorkingDogEntity) {
            WorkingDogEntity partner = (WorkingDogEntity) entity;
            WorkingDogEntity baby = null;
            if (random.nextBoolean()) {
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
                if (baby != null) {
                    int variant;
                    if (getType() == partner.getType()) {
                        if (random.nextBoolean()) {
                            if (random.nextFloat() <= 0.6F) variant = partner.getVariant();
                            else variant = getCarriedVariant(partner.getVariantName());
                        } else {
                            if (random.nextFloat() <= 0.6F) variant = getVariant();
                            else variant = getCarriedVariant(getVariantName());
                        }

                    } else {
                        if (random.nextFloat() <= 0.6F) variant = getVariant();
                        else variant = getCarriedVariant(getVariantName());
                    }
                    baby.setVariant(variant);
                }
            }

            return baby;
        }

        return null;
    }

    public enum Variant {
        BLACK(Collections.singletonList(2)),
        BROWN(Collections.singletonList(2)),
        GRAY(Collections.singletonList(1)),
        WHITE(Collections.singletonList(3));

        private final List<Integer> carries;

        Variant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(String name) {
            return Variant.valueOf(name).carries;
        }
    }
}
