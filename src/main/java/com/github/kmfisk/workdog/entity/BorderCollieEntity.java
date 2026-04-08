package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.HerdingDogEntity;
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

public class BorderCollieEntity extends HerdingDogEntity {
    public BorderCollieEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.25F).add(Attributes.MAX_HEALTH, 10.0F).add(Attributes.ATTACK_DAMAGE, 3.0F);
    }

    @Override
    public int getVariantCount() {
        return 15;
    }

    @Override
    public String getVariantName() {
        return BorderCollieVariant.fromOrdinal(getVariant()).name().toLowerCase();
    }

    @Override
    public int getCarriedVariant(int variant) {
        int size = BorderCollieVariant.getCarriedVariants(variant).size();
        return BorderCollieVariant.getCarriedVariants(variant).get(random.nextInt(size));
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
        return WorkDogEntities.BORDER_COLLIE.get().create(world);
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
        WHITE(Collections.singletonList(14)),
        ALBINISTIC(Collections.singletonList(14)),
        MELANISTIC(Collections.singletonList(0));

        private final List<Integer> carries;

        BorderCollieVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(int variant) {
            return BorderCollieVariant.values()[variant].carries;
        }

        public static BorderCollieVariant fromOrdinal(int ordinal) {
            return switch (ordinal) {
                case 0 -> BLACK;
                case 1 -> BLACK_SKIM;
                case 2 -> BLACK_LIGHT;
                case 3 -> BLACK_HEAVY;
                case 4 -> BLACK_TRI;
                case 5 -> BLUE_SKIM;
                case 6 -> BLUE_LIGHT;
                case 7 -> BLUE_HEAVY;
                case 8 -> BLUE_MERLE;
                case 9 -> CHOCOLATE_SKIM;
                case 10 -> CHOCOLATE_LIGHT;
                case 11 -> CHOCOLATE_HEAVY;
                case 12 -> RED_MERLE;
                case 13 -> TAN;
                case 14 -> WHITE;
                case 15 -> ALBINISTIC;
                case 16 -> MELANISTIC;
                default -> throw new IllegalStateException("Unexpected value: " + ordinal);
            };
        }
    }

    @Override
    public int getInventoryColumns() {
        return 6; // todo (large= 27, 9 columns; medium= 18, 6 columns; small= 9, 3 columns)
    }

    @Override
    public boolean canWearDogEquipmentType(DogEquipmentType dogEquipmentType) {
        return true;
    }
}
