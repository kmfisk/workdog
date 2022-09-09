package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.HerdingDogEntity;
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

public class BorderCollieEntity extends HerdingDogEntity {
    public BorderCollieEntity(EntityType<? extends TameableEntity> type, World world) {
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
                return BorderCollieVariant.BLACK.name();
            case 1:
                return BorderCollieVariant.BLACK_SKIM.name();
            case 2:
                return BorderCollieVariant.BLACK_LIGHT.name();
            case 3:
                return BorderCollieVariant.BLACK_HEAVY.name();
            case 4:
                return BorderCollieVariant.BLACK_TRI.name();
            case 5:
                return BorderCollieVariant.BLUE_SKIM.name();
            case 6:
                return BorderCollieVariant.BLUE_LIGHT.name();
            case 7:
                return BorderCollieVariant.BLUE_HEAVY.name();
            case 8:
                return BorderCollieVariant.BLUE_MERLE.name();
            case 9:
                return BorderCollieVariant.CHOCOLATE_SKIM.name();
            case 10:
                return BorderCollieVariant.CHOCOLATE_LIGHT.name();
            case 11:
                return BorderCollieVariant.CHOCOLATE_HEAVY.name();
            case 12:
                return BorderCollieVariant.RED_MERLE.name();
            case 13:
                return BorderCollieVariant.TAN.name();
            case 14:
                return BorderCollieVariant.WHITE.name();
            default:
                throw new IllegalStateException("Unexpected Border Collie variant, value of: " + getVariant());
        }
    }

    @Override
    public int getCarriedVariant(String name) {
        int size = BorderCollieVariant.getCarriedVariants(name).size();
        return BorderCollieVariant.getCarriedVariants(name).get(random.nextInt(size));
    }

    @Override
    public boolean hasLonghair() {
        return true;
    }

    @Override
    public float getLonghairChance() {
        return 0.08F;
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        if (entity instanceof WorkingDogEntity) {
            WorkingDogEntity partner = (WorkingDogEntity) entity;
            WorkingDogEntity baby = WorkDogEntities.BORDER_COLLIE.create(world);
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

    public enum BorderCollieVariant {
        BLACK(Arrays.asList(3, 4)),
        BLACK_SKIM(Arrays.asList(14, 2)),
        BLACK_LIGHT(Arrays.asList(1, 5)),
        BLACK_HEAVY(Arrays.asList(0, 4)),
        BLACK_TRI(Arrays.asList(3, 8)),
        BLUE_SKIM(Arrays.asList(14, 6)),
        BLUE_LIGHT(Arrays.asList(5, 9)),
        BLUE_HEAVY(Arrays.asList(8, 3)),
        BLUE_MERLE(Arrays.asList(7, 12)),
        CHOCOLATE_SKIM(Arrays.asList(14, 10)),
        CHOCOLATE_LIGHT(Arrays.asList(9, 13)),
        CHOCOLATE_HEAVY(Arrays.asList(12, 7)),
        RED_MERLE(Arrays.asList(11, 13)),
        TAN(Arrays.asList(14, 12)),
        WHITE(Collections.singletonList(14));

        private final List<Integer> carries;

        BorderCollieVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(String name) {
            return BorderCollieVariant.valueOf(name).carries;
        }
    }
}
