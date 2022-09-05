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

public class BostonTerrierEntity extends ToyDogEntity {
    public BostonTerrierEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.30F).add(Attributes.MAX_HEALTH, 18.0F).add(Attributes.ATTACK_DAMAGE, 6.0F);
    }

    @Override
    public int getVariantCount() {
        return 8;
    }

    @Override
    public boolean hasLonghair() {
        return false;
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        return WorkDogEntities.BOSTON_TERRIER.create(world);
    }
}