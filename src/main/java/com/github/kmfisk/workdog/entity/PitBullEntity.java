package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.HuntingDogEntity;
import com.github.kmfisk.workdog.entity.core.WorkingDogEntity;
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
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.30F).add(Attributes.MAX_HEALTH, 18.0F).add(Attributes.ATTACK_DAMAGE, 6.0F);
    }

    @Override
    public int getVariantCount() {
        return 15;
    }

    @Override
    public String getVariantName() {
        switch (getVariant()) {
            case 0:
                return PitBullVariant.BLACK.name();
            case 1:
                return PitBullVariant.BLACK_PINTO.name();
            case 2:
                return PitBullVariant.BLUE_BRINDLE.name();
            case 3:
                return PitBullVariant.BLUE_PINTO.name();
            case 4:
                return PitBullVariant.BROWN_BRINDLE.name();
            case 5:
                return PitBullVariant.BROWN_PINTO.name();
            case 6:
                return PitBullVariant.DARK_BLUE.name();
            case 7:
                return PitBullVariant.DARK_BROWN.name();
            case 8:
                return PitBullVariant.DARK_RED.name();
            case 9:
                return PitBullVariant.FAWN.name();
            case 10:
                return PitBullVariant.LIGHT_BLUE.name();
            case 11:
                return PitBullVariant.LIGHT_BROWN.name();
            case 12:
                return PitBullVariant.LIGHT_RED.name();
            case 13:
                return PitBullVariant.RED_PINTO.name();
            case 14:
                return PitBullVariant.WHITE.name();
            default:
                throw new IllegalStateException("Unexpected Pit Bull variant, value of: " + getVariant());
        }
    }

    @Override
    public int getCarriedVariant(String name) {
        int size = PitBullVariant.getCarriedVariants(name).size();
        return PitBullVariant.getCarriedVariants(name).get(random.nextInt(size));
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
            WorkingDogEntity baby = WorkDogEntities.PIT_BULL.create(world);
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

            return baby;
        }

        return null;
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
        DARK_RED(Arrays.asList(11, 5)),
        FAWN(Arrays.asList(12, 13)),
        LIGHT_BLUE(Arrays.asList(6, 3)),
        LIGHT_BROWN(Arrays.asList(7, 5)),
        LIGHT_RED(Arrays.asList(9, 8)),
        RED_PINTO(Arrays.asList(8, 14)),
        WHITE(Collections.singletonList(14));

        private final List<Integer> carries;

        PitBullVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(String name) {
            return PitBullEntity.PitBullVariant.valueOf(name).carries;
        }
    }
}
