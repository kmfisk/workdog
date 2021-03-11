package com.github.kmfisk.workdog.client.model.entity;

import com.github.kmfisk.workdog.entity.BorderCollieEntity;
import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;

/**
 * BorderColliePuppy - fisk
 * Created using Tabula 7.1.0
 */
@Environment(EnvType.CLIENT)
public class BorderColliePuppyModel<T extends BorderCollieEntity> extends PuppyModel<T> {
    private final ModelPart Chest;
    private final ModelPart Neck;
    private final ModelPart Body;
    private final ModelPart ArmLeft;
    private final ModelPart ArmRight;
    private final ModelPart Head;
    private final ModelPart Snout;
    private final ModelPart EarLeft;
    private final ModelPart EarRight;
    private final ModelPart Mouth;
    private final ModelPart TopSnout;
    private final ModelPart EarFlapLeft;
    private final ModelPart EarFlapRight;
    private final ModelPart ThighLeft;
    private final ModelPart ThighRight;
    private final ModelPart Tail;
    private final ModelPart LegLeft;
    private final ModelPart FootLeft;
    private final ModelPart LegRight;
    private final ModelPart FootRight;
    private final ModelPart HandLeft;
    private final ModelPart HandRight;

    public BorderColliePuppyModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.ArmLeft = new ModelPart(this, 24, 15);
        this.ArmLeft.setPivot(1.7F, 0.7F, -0.5F);
        this.ArmLeft.addCuboid(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
        this.Mouth = new ModelPart(this, 10, 25);
        this.Mouth.setPivot(0.0F, 2.1F, 0.2F);
        this.Mouth.addCuboid(-1.0F, -1.0F, -2.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Mouth, -0.045553093477052F, 0.0F, 0.0F);
        this.Body = new ModelPart(this, 18, 0);
        this.Body.setPivot(0.0F, -2.5F, 2.0F);
        this.Body.addCuboid(-2.0F, 0.0F, 0.0F, 4, 5, 4, 0.0F);
        this.ThighLeft = new ModelPart(this, 34, 0);
        this.ThighLeft.setPivot(1.7F, 0.9F, 2.7F);
        this.ThighLeft.addCuboid(-1.0F, 0.0F, -1.5F, 2, 4, 3, 0.0F);
        this.EarFlapRight = new ModelPart(this, 20, 12);
        this.EarFlapRight.mirror = true;
        this.EarFlapRight.setPivot(0.0F, -2.0F, 1.0F);
        this.EarFlapRight.addCuboid(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(EarFlapRight, -0.091106186954104F, 0.0F, 0.0F);
        this.Tail = new ModelPart(this, 27, 24);
        this.Tail.setPivot(0.0F, 0.4F, 4.0F);
        this.Tail.addCuboid(-1.0F, 0.0F, 0.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(Tail, -0.7285004297824331F, 0.0F, 0.0F);
        this.FootLeft = new ModelPart(this, 34, 11);
        this.FootLeft.setPivot(-0.1F, 2.0F, 2.0F);
        this.FootLeft.addCuboid(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(FootLeft, -0.40980330836826856F, 0.0F, 0.0F);
        this.Snout = new ModelPart(this, 0, 25);
        this.Snout.setPivot(0.0F, 0.1F, -1.3F);
        this.Snout.addCuboid(-1.5F, 0.0F, -2.0F, 3, 2, 2, 0.0F);
        this.LegLeft = new ModelPart(this, 34, 7);
        this.LegLeft.setPivot(-0.1F, 4.0F, -1.1F);
        this.LegLeft.addCuboid(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(LegLeft, 0.4553564018453205F, 0.0F, 0.0F);
        this.EarFlapLeft = new ModelPart(this, 16, 9);
        this.EarFlapLeft.setPivot(0.0F, -2.0F, 1.0F);
        this.EarFlapLeft.addCuboid(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(EarFlapLeft, -0.091106186954104F, 0.0F, 0.0F);
        this.HandLeft = new ModelPart(this, 24, 20);
        this.HandLeft.setPivot(-0.1F, 3.5F, 0.6F);
        this.HandLeft.addCuboid(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(HandLeft, -0.091106186954104F, 0.0F, 0.0F);
        this.TopSnout = new ModelPart(this, 8, 28);
        this.TopSnout.setPivot(0.0F, -0.4F, -0.1F);
        this.TopSnout.addCuboid(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(TopSnout, 0.091106186954104F, 0.0F, 0.0F);
        this.EarLeft = new ModelPart(this, 10, 9);
        this.EarLeft.setPivot(1.1F, -0.7F, 0.4F);
        this.EarLeft.addCuboid(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(EarLeft, 0.136659280431156F, -0.091106186954104F, 0.31869712141416456F);
        this.FootRight = new ModelPart(this, 45, 11);
        this.FootRight.mirror = true;
        this.FootRight.setPivot(0.1F, 2.0F, 2.0F);
        this.FootRight.addCuboid(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(FootRight, -0.40980330836826856F, 0.0F, 0.0F);
        this.HandRight = new ModelPart(this, 32, 20);
        this.HandRight.mirror = true;
        this.HandRight.setPivot(0.1F, 3.5F, 0.6F);
        this.HandRight.addCuboid(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(HandRight, -0.091106186954104F, 0.0F, 0.0F);
        this.ArmRight = new ModelPart(this, 32, 15);
        this.ArmRight.mirror = true;
        this.ArmRight.setPivot(-1.7F, 0.7F, -0.5F);
        this.ArmRight.addCuboid(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
        this.Neck = new ModelPart(this, 0, 9);
        this.Neck.setPivot(0.0F, -1.3F, -0.7F);
        this.Neck.addCuboid(-1.5F, -2.7F, -2.1F, 3, 4, 4, 0.0F);
        this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
        this.LegRight = new ModelPart(this, 45, 7);
        this.LegRight.mirror = true;
        this.LegRight.setPivot(0.1F, 4.0F, -1.1F);
        this.LegRight.addCuboid(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(LegRight, 0.4553564018453205F, 0.0F, 0.0F);
        this.EarRight = new ModelPart(this, 14, 12);
        this.EarRight.mirror = true;
        this.EarRight.setPivot(-1.1F, -0.2F, 0.4F);
        this.EarRight.addCuboid(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(EarRight, 0.136659280431156F, 0.091106186954104F, -0.31869712141416456F);
        this.ThighRight = new ModelPart(this, 44, 0);
        this.ThighRight.mirror = true;
        this.ThighRight.setPivot(-1.7F, 0.9F, 2.7F);
        this.ThighRight.addCuboid(-1.0F, 0.0F, -1.5F, 2, 4, 3, 0.0F);
        this.Chest = new ModelPart(this, 0, 0);
        this.Chest.setPivot(0.0F, 19.5F, -2.0F);
        this.Chest.addCuboid(-2.5F, -2.5F, -2.0F, 5, 5, 4, 0.0F);
        this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
        this.Head = new ModelPart(this, 0, 17);
        this.Head.setPivot(0.0F, -2.1F, -0.2F);
        this.Head.addCuboid(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(Head, -0.6373942428283291F, 0.0F, 0.0F);
        this.Chest.addChild(this.ArmLeft);
        this.Snout.addChild(this.Mouth);
        this.Chest.addChild(this.Body);
        this.Body.addChild(this.ThighLeft);
        this.EarRight.addChild(this.EarFlapRight);
        this.Body.addChild(this.Tail);
        this.LegLeft.addChild(this.FootLeft);
        this.Head.addChild(this.Snout);
        this.ThighLeft.addChild(this.LegLeft);
        this.EarLeft.addChild(this.EarFlapLeft);
        this.ArmLeft.addChild(this.HandLeft);
        this.Snout.addChild(this.TopSnout);
        this.Head.addChild(this.EarLeft);
        this.LegRight.addChild(this.FootRight);
        this.ArmRight.addChild(this.HandRight);
        this.Chest.addChild(this.ArmRight);
        this.Chest.addChild(this.Neck);
        this.ThighRight.addChild(this.LegRight);
        this.Head.addChild(this.EarRight);
        this.Body.addChild(this.ThighRight);
        this.Neck.addChild(this.Head);
    }

    @Override
    public Iterable<ModelPart> getParts() {
        return ImmutableList.of(this.Chest);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    private void setRotateAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.pitch = x;
        modelRenderer.yaw = y;
        modelRenderer.roll = z;
    }
}
