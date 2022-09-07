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

public class AkitaEntity extends HuntingDogEntity {
    public AkitaEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.30F).add(Attributes.MAX_HEALTH, 18.0F).add(Attributes.ATTACK_DAMAGE, 6.0F);
    }

    @Override
    public int getVariantCount() {
        return 21;
    }

    @Override
    public String getVariantName() {
        switch (getVariant()) {
            case 0:
                return AkitaVariant.BLACK.name();
            case 1:
                return AkitaVariant.BLACK_WHITE_SOCKS.name();
            case 2:
                return AkitaVariant.BLACK_PINTO.name();
            case 3:
                return AkitaVariant.BLACK_BROWN_PINTO.name();
            case 4:
                return AkitaVariant.BLACK_TAN_PINTO.name();
            case 5:
                return AkitaVariant.BLACK_BRINDLE.name();
            case 6:
                return AkitaVariant.BROWN_BRINDLE.name();
            case 7:
                return AkitaVariant.BROWN_PINTO.name();
            case 8:
                return AkitaVariant.FAWN.name();
            case 9:
                return AkitaVariant.FAWN_BRINDLE.name();
            case 10:
                return AkitaVariant.FAWN_PINTO.name();
            case 11:
                return AkitaVariant.GRAY_BRINDLE.name();
            case 12:
                return AkitaVariant.GRAY_PINTO.name();
            case 13:
                return AkitaVariant.SILVER_BRINDLE.name();
            case 14:
                return AkitaVariant.SILVER_PINTO.name();
            case 15:
                return AkitaVariant.TAN_BRINDLE.name();
            case 16:
                return AkitaVariant.TAN_PINTO.name();
            case 17:
                return AkitaVariant.TIGER_BRINDLE.name();
            case 18:
                return AkitaVariant.RED_SESAME.name();
            case 19:
                return AkitaVariant.GOLD_SESAME.name();
            case 20:
                return AkitaVariant.WHITE.name();

            default:
                throw new IllegalStateException("Unexpected Akita variant, value of: " + getVariant());
        }
    }

    @Override
    public int getCarriedVariant(String name) {
        int size = AkitaVariant.getCarriedVariants(name).size();
        return AkitaVariant.getCarriedVariants(name).get(random.nextInt(size));
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
            WorkingDogEntity baby = WorkDogEntities.AKITA.create(world);
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

    public enum AkitaVariant {
        BLACK(Arrays.asList(2, 5)),
        BLACK_WHITE_SOCKS(Arrays.asList(2, 3)),
        BLACK_PINTO(Arrays.asList(1, 4)),
        BLACK_BROWN_PINTO(Arrays.asList(4, 6)),
        BLACK_TAN_PINTO(Arrays.asList(8, 12)),
        BLACK_BRINDLE(Arrays.asList(0, 11)),
        BROWN_BRINDLE(Arrays.asList(17, 7)),
        BROWN_PINTO(Arrays.asList(3, 2)),
        FAWN(Arrays.asList(9, 10)),
        FAWN_BRINDLE(Arrays.asList(10, 15)),
        FAWN_PINTO(Arrays.asList(4, 16)),
        GRAY_BRINDLE(Arrays.asList(13, 17)),
        GRAY_PINTO(Collections.singletonList(11)),
        SILVER_BRINDLE(Arrays.asList(14, 15)),
        SILVER_PINTO(Arrays.asList(20, 10)),
        TAN_BRINDLE(Arrays.asList(18, 19)),
        TAN_PINTO(Arrays.asList(4, 3)),
        TIGER_BRINDLE(Arrays.asList(11, 15)),
        RED_SESAME(Arrays.asList(19, 17)),
        GOLD_SESAME(Arrays.asList(18, 16)),
        WHITE(Collections.singletonList(14));

        private final List<Integer> carries;

        AkitaVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(String name) {
            return AkitaVariant.valueOf(name).carries;
        }
    }
}
