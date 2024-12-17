package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.HuntingDogEntity;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PitBullEntity extends HuntingDogEntity {
    public PitBullEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.175F).add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.ATTACK_DAMAGE, 6.0F);
    }

    @Override
    public int getVariantCount() {
        return 15;
    }

    @Override
    public int getCarriedVariant(int variant) {
        int size = PitBullVariant.getCarriedVariants(variant).size();
        return PitBullVariant.getCarriedVariants(variant).get(random.nextInt(size));
    }

    @Override
    public boolean hasLonghairVariants() {
        return false;
    }

    @Override
    public float getLonghairChance() {
        return 0F;
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        return WorkDogEntities.PIT_BULL.create(world);
    }

    @Override
    public int getLootingLevel() {
        return 1;
    }

    public enum PitBullVariant {
        BLACK(Arrays.asList(1, 6)),
        BLACK_PINTO(Arrays.asList(0, 3)),
        BLUE_BRINDLE(Arrays.asList(6, 3)),
        BLUE_PINTO(Arrays.asList(10, 14)),
        BROWN_BRINDLE(Arrays.asList(7, 5)),
        BROWN_PINTO(Arrays.asList(11, 14)),
        DARK_BLUE(Arrays.asList(10, 3)),
        DARK_BROWN(Arrays.asList(11, 5)),
        DARK_RED(Arrays.asList(12, 13)),
        FAWN(Arrays.asList(12, 13)),
        LIGHT_BLUE(Arrays.asList(6, 3)),
        LIGHT_BROWN(Arrays.asList(7, 5)),
        LIGHT_RED(Arrays.asList(9, 8)),
        RED_PINTO(Arrays.asList(8, 14)),
        WHITE(Collections.singletonList(14)),
        ALBINISTIC(Collections.singletonList(14)),
        MELANISTIC(Collections.singletonList(0));

        private final List<Integer> carries;

        PitBullVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(int variant) {
            return PitBullVariant.values()[variant].carries;
        }
    }
}
