package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.ToyDogEntity;
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

public class BostonTerrierEntity extends ToyDogEntity {
    public BostonTerrierEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.MAX_HEALTH, 6.0F).add(Attributes.ATTACK_DAMAGE, 1.0F);
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
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
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
