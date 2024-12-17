package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.ProtectionDogEntity;
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

public class GermanShepherdEntity extends ProtectionDogEntity {
    public GermanShepherdEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.25F).add(Attributes.MAX_HEALTH, 18.0F).add(Attributes.ATTACK_DAMAGE, 5.0F);
    }

    @Override
    public int getVariantCount() {
        return 11;
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
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        return WorkDogEntities.GERMAN_SHEPHERD.create(world);
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
    }
}
