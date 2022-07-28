package com.github.kmfisk.workdog.entity.core;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;

public abstract class HuntingDogEntity extends WorkingDogEntity {
    public HuntingDogEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }
}
