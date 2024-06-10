package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.ToyDogEntity;
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

public class BostonTerrierEntity extends ToyDogEntity {
    public BostonTerrierEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.175F).add(Attributes.MAX_HEALTH, 6.0F).add(Attributes.ATTACK_DAMAGE, 1.0F);
    }

    @Override
    public int getVariantCount() {
        return 8;
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
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        return WorkDogEntities.BOSTON_TERRIER.create(world);
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
    }
}
