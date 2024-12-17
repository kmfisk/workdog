package com.github.kmfisk.workdog.entity.core;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;

import static com.github.kmfisk.workdog.tags.WorkDogTags.TOY_DOGS;

public abstract class ToyDogEntity extends WorkDogEntity {
    public ToyDogEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    @Override
    public Tags.IOptionalNamedTag<EntityType<?>> getWorkGroupTag() {
        return TOY_DOGS;
    }
}
