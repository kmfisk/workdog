package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.ToyDogEntity;
import com.github.kmfisk.workdog.item.DogEquipmentItem;
import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BostonTerrierEntity extends ToyDogEntity {
    public BostonTerrierEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.128F).add(Attributes.MAX_HEALTH, 6.0F).add(Attributes.ATTACK_DAMAGE, 1.0F);
    }

    @Override
    public Size getSize() {
        return Size.TOY;
    }

    @Override
    public float sprintPredisposition() {
        return 1.6F;
    }

    @Override
    public Weather getWeatherType() {
        return Weather.TEMPERATE;
    }

    @Override
    public int getVariantCount() {
        return 8;
    }

    @Override
    public String getVariantName() {
        return BostonTerrierVariant.fromOrdinal(getVariant()).name().toLowerCase();
    }

    @Override
    public int getCarriedVariant(int variant) {
        int size = BostonTerrierVariant.getCarriedVariants(variant).size();
        return BostonTerrierVariant.getCarriedVariants(variant).get(random.nextInt(size));
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
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
        return WorkDogEntities.BOSTON_TERRIER.get().create(world);
    }

    public enum BostonTerrierVariant {
        BLACK(Arrays.asList(5, 3)),
        BLACK_AND_WHITE(Arrays.asList(5, 0)),
        BLUE(Arrays.asList(0, 6)),
        BRINDLE(Arrays.asList(0, 4)),
        BROWN(Arrays.asList(6, 7)),
        JADE_BLACK(Arrays.asList(0, 7)),
        LILAC(Arrays.asList(2, 7)),
        WHITE(Collections.singletonList(7)),
        ALBINISTIC(Collections.singletonList(7)),
        MELANISTIC(Collections.singletonList(0));

        private final List<Integer> carries;

        BostonTerrierVariant(List<Integer> carries) {
            this.carries = carries;
        }

        public static List<Integer> getCarriedVariants(int variant) {
            return BostonTerrierVariant.values()[variant].carries;
        }

        public static BostonTerrierVariant fromOrdinal(int ordinal) {
            return switch (ordinal) {
                case 0 -> BLACK;
                case 1 -> BLACK_AND_WHITE;
                case 2 -> BLUE;
                case 3 -> BRINDLE;
                case 4 -> BROWN;
                case 5 -> JADE_BLACK;
                case 6 -> LILAC;
                case 7 -> WHITE;
                case 8 -> ALBINISTIC;
                case 9 -> MELANISTIC;
                default -> throw new IllegalStateException("Unexpected value: " + ordinal);
            };
        }
    }

    @Override
    public boolean canEquipSaddlebag() {
        return false;
    }

    @Override
    public boolean canWearDogEquipmentType(DogEquipmentType dogEquipmentType) {
        switch (dogEquipmentType) {
            case COLLAR, HARNESS, VEST -> {
                return true;
            }
            case MUZZLE -> {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean canWearDogEquipment(ItemStack stack) {
        if (stack.getItem() instanceof DogEquipmentItem dogEquipmentItem) {
            return dogEquipmentItem.getDogEquipmentType() != DogEquipmentType.VEST || stack.is(WorkDogItems.SWEATER.get());
        }
        return true;
    }
}
