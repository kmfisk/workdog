package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.ProtectionDogEntity;
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

public class GermanShepherdEntity extends ProtectionDogEntity {
    public GermanShepherdEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.25F).add(Attributes.MAX_HEALTH, 18.0F).add(Attributes.ATTACK_DAMAGE, 5.0F);
    }

    @Override
    public Size getSize() {
        return Size.LARGE;
    }

    @Override
    public Weather getWeatherType() {
        return isLonghair() ? Weather.COLD : Weather.TEMPERATE;
    }

    @Override
    public int getVariantCount() {
        return 11;
    }

    @Override
    public String getVariantName() {
        return GermanShepherdVariant.fromOrdinal(getVariant()).name().toLowerCase();
    }

    @Override
    public int getCarriedVariant(int variant) {
        int size = GermanShepherdVariant.getCarriedVariants(variant).size();
        return GermanShepherdVariant.getCarriedVariants(variant).get(random.nextInt(size));
    }

    @Override
    public boolean hasLonghairVariants() {
        return true;
    }

    @Override
    public float getLonghairChance() {
        return 0.08F;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
        return WorkDogEntities.GERMAN_SHEPHERD.get().create(world);
    }

    public enum GermanShepherdVariant {
        BLACK(Arrays.asList(1, 4)),
        BLACK_AND_RED(Arrays.asList(4, 3)),
        BLACK_AND_SILVER(Arrays.asList(6, 1)),
        BLACK_AND_TAN(Arrays.asList(8, 2)),
        RED_SABLE(Arrays.asList(5, 9)),
        RED_SADDLEBACK(Arrays.asList(1, 9)),
        SILVER_SABLE(Arrays.asList(9, 7)),
        SILVER_SADDLEBACK(Arrays.asList(2, 9)),
        TAN_SABLE(Arrays.asList(9, 7)),
        TAN_SADDLEBACK(Arrays.asList(3, 5)),
        WHITE(Collections.singletonList(10)),
        ALBINISTIC(Collections.singletonList(10)),
        MELANISTIC(Collections.singletonList(0));

        private final List<Integer> carries;

        GermanShepherdVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(int variant) {
            return GermanShepherdVariant.values()[variant].carries;
        }

        public static GermanShepherdVariant fromOrdinal(int ordinal) {
            return switch (ordinal) {
                case 0 -> BLACK;
                case 1 -> BLACK_AND_RED;
                case 2 -> BLACK_AND_SILVER;
                case 3 -> BLACK_AND_TAN;
                case 4 -> RED_SABLE;
                case 5 -> RED_SADDLEBACK;
                case 6 -> SILVER_SABLE;
                case 7 -> SILVER_SADDLEBACK;
                case 8 -> TAN_SABLE;
                case 9 -> TAN_SADDLEBACK;
                case 10 -> WHITE;
                case 11 -> ALBINISTIC;
                case 12 -> MELANISTIC;
                default -> throw new IllegalStateException("Unexpected value: " + ordinal);
            };
        }
    }

    @Override
    public boolean canWearDogEquipmentType(DogEquipmentType dogEquipmentType) {
        return true;
    }
}
