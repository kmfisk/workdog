package com.github.kmfisk.workdog.client.model.entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.entity.Entity;

public abstract class PuppyModel<E extends Entity> extends CompositeEntityModel<E> {
    @Override
    public abstract Iterable<ModelPart> getParts();

    @Override
    public void setAngles(E entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
