package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.TerrierDogEntity;
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

public class JackRussellTerrierEntity extends TerrierDogEntity {
    public JackRussellTerrierEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.31F).add(Attributes.MAX_HEALTH, 10.0F).add(Attributes.ATTACK_DAMAGE, 3.0F);
    }

    @Override
    public Size getSize() {
        return Size.SMALL;
    }

    @Override
    public float sprintPredisposition() {
        return 2.0F;
    }

    @Override
    public Weather getWeatherType() {
        return isLonghair() ? Weather.TEMPERATE : Weather.HOT;
    }

    @Override
    public int getVariantCount() {
        return 9;
    }

    @Override
    public String getVariantName() {
        return JackRussellTerrierVariant.fromOrdinal(getVariant()).name().toLowerCase();
    }

    @Override
    public int getCarriedVariant(int variant) {
        int size = JackRussellTerrierVariant.getCarriedVariants(variant).size();
        return JackRussellTerrierVariant.getCarriedVariants(variant).get(random.nextInt(size));
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
        return WorkDogEntities.JACK_RUSSELL_TERRIER.get().create(world);
    }

    public enum JackRussellTerrierVariant {
        BLACK(Collections.singletonList(1)),
        BLACK_AND_TAN(Arrays.asList(0, 5)),
        BROWN_EARS(Arrays.asList(3, 4)),
        BROWN_FACE(Arrays.asList(2, 7)),
        BROWN_SADDLE(Arrays.asList(5, 7)),
        HEAVY_TRI(Arrays.asList(1, 7)),
        MID_TRI(Arrays.asList(5, 7)),
        LIGHT_TRI(Arrays.asList(8, 5)),
        WHITE(Collections.singletonList(8)),
        ALBINISTIC(Collections.singletonList(8)),
        MELANISTIC(Collections.singletonList(0));

        private final List<Integer> carries;

        JackRussellTerrierVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(int variant) {
            return JackRussellTerrierVariant.values()[variant].carries;
        }

        public static JackRussellTerrierVariant fromOrdinal(int ordinal) {
            return switch (ordinal) {
                case 0 -> BLACK;
                case 1 -> BLACK_AND_TAN;
                case 2 -> BROWN_EARS;
                case 3 -> BROWN_FACE;
                case 4 -> BROWN_SADDLE;
                case 5 -> HEAVY_TRI;
                case 6 -> MID_TRI;
                case 7 -> LIGHT_TRI;
                case 8 -> WHITE;
                case 9 -> ALBINISTIC;
                case 10 -> MELANISTIC;
                default -> throw new IllegalStateException("Unexpected value: " + ordinal);
            };
        }
    }

    @Override
    public boolean canWearDogEquipmentType(DogEquipmentType dogEquipmentType) {
        return true;
    }
}
