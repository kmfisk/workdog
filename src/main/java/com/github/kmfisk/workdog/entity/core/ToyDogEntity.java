package com.github.kmfisk.workdog.entity.core;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public abstract class ToyDogEntity extends WorkDogEntity {
    public ToyDogEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    @Override
    public WorkGroup getWorkGroup() {
        return WorkGroup.TOY;
    }
}
