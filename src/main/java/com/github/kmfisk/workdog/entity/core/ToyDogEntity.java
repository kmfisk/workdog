package com.github.kmfisk.workdog.entity.core;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

import static com.github.kmfisk.workdog.tags.WorkDogTags.TOY_DOGS;

public abstract class ToyDogEntity extends WorkDogEntity {
    public ToyDogEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    @Override
    public TagKey<EntityType<?>> getWorkGroupTag() {
        return TOY_DOGS;
    }
}
