package com.github.kmfisk.workdog.entity.core;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;

public abstract class ToyDogEntity extends WorkingDogEntity {
    public ToyDogEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }
}
