package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.HerdingDogEntity;
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
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.25F).add(Attributes.MAX_HEALTH, 10.0F).add(Attributes.ATTACK_DAMAGE, 3.0F);
    }

    @Override
    public int getVariantCount() {
        return 15;
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
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        return WorkDogEntities.BORDER_COLLIE.create(world);
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
    }
}
