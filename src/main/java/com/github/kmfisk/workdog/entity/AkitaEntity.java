package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.HuntingDogEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AkitaEntity extends HuntingDogEntity {
    public AkitaEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.25F).add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.ATTACK_DAMAGE, 5.0F);
    }

    @Override
    public Size getSize() {
        return Size.LARGE;
    }

    @Override
    public Weather getWeatherType() {
        return Weather.COLD;
    }

    @Override
    public int getVariantCount() {
        return 21;
    }

    @Override
    public String getVariantName() {
        return AkitaVariant.fromOrdinal(getVariant()).name().toLowerCase();
    }

    @Override
    public int getCarriedVariant(int variant) {
        int size = AkitaVariant.getCarriedVariants(variant).size();
        return AkitaVariant.getCarriedVariants(variant).get(random.nextInt(size));
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
        return WorkDogEntities.AKITA.get().create(world);
    }

    @Override
    public int getLootingLevel() {
        return 2;
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
        WHITE(Collections.singletonList(20)),
        ALBINISTIC(Collections.singletonList(20)),
        MELANISTIC(Collections.singletonList(0));

        private final List<Integer> carries;

        AkitaVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(int variant) {
            return AkitaVariant.values()[variant].carries;
        }

        public static AkitaVariant fromOrdinal(int ordinal) {
            return switch (ordinal) {
                case 0 -> BLACK;
                case 1 -> BLACK_WHITE_SOCKS;
                case 2 -> BLACK_PINTO;
                case 3 -> BLACK_BROWN_PINTO;
                case 4 -> BLACK_TAN_PINTO;
                case 5 -> BLACK_BRINDLE;
                case 6 -> BROWN_BRINDLE;
                case 7 -> BROWN_PINTO;
                case 8 -> FAWN;
                case 9 -> FAWN_BRINDLE;
                case 10 -> FAWN_PINTO;
                case 11 -> GRAY_BRINDLE;
                case 12 -> GRAY_PINTO;
                case 13 -> SILVER_BRINDLE;
                case 14 -> SILVER_PINTO;
                case 15 -> TAN_BRINDLE;
                case 16 -> TAN_PINTO;
                case 17 -> TIGER_BRINDLE;
                case 18 -> RED_SESAME;
                case 19 -> GOLD_SESAME;
                case 20 -> WHITE;
                case 21 -> ALBINISTIC;
                case 22 -> MELANISTIC;
                default -> throw new IllegalStateException("Unexpected value: " + ordinal);
            };
        }
    }

    @Override
    public boolean canWearDogEquipmentType(DogEquipmentType dogEquipmentType) {
        return true;
    }
}
