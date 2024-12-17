package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public abstract class WorkDogModel<E extends WorkDogEntity> extends SegmentedModel<E> {
    @Override
    public void prepareMobModel(E entity, float speed, float walkSpeed, float partialTick) {
        resetPose(entity, speed, walkSpeed, partialTick);
        if (entity.isInSittingPose()) setSittingPose(entity, speed, walkSpeed, partialTick);
        else if (entity.isLying()) setLyingPose(entity, speed, walkSpeed, partialTick);
    }

    public abstract void setSittingPose(E entity, float speed, float walkSpeed, float partialTick);

    public abstract void setLyingPose(E entity, float speed, float walkSpeed, float partialTick);

    public abstract void resetPose(E entity, float speed, float walkSpeed, float partialTick);

    @Override
    public void setupAnim(E entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//        this.playMovementAnimation(entity, entity.tickCount, 0.3F, ageInTicks, netHeadYaw, headPitch);
        if ((limbSwingAmount <= 0.05F && !entity.isInWater()))
            playIdleAnimation(entity, entity.tickCount, 0.3F, ageInTicks, netHeadYaw, headPitch);
        else if (!entity.isInSittingPose() && !entity.isLying())
            playMovementAnimation(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }

    public abstract void playIdleAnimation(E entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch);

    public abstract void playMovementAnimation(E entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch);

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
