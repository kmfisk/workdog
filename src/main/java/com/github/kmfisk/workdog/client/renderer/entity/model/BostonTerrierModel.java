package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.entity.BostonTerrierEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public abstract class BostonTerrierModel extends WorkDogModel<BostonTerrierEntity> {
    public ModelPart Chest;
    public ModelPart Body;
    public ModelPart Neck;
    public ModelPart ThighLeft;
    public ModelPart ThighRight;
    public ModelPart FootLeft;
    public ModelPart FootRight;
    public ModelPart Head;
    public ModelPart TopSnout;
    public ModelPart EarLeft;
    public ModelPart EarRight;
    public ModelPart Snout;
    public ModelPart Mouth;
    public ModelPart ArmLeft;
    public ModelPart HandLeft;
    public ModelPart ArmRight;
    public ModelPart HandRight;
    private Iterable<ModelPart> parts;

    @Override
    public Iterable<ModelPart> parts() {
        if (parts == null)
            parts = ImmutableList.of(Chest);

        return parts;
    }

    public static class Adult extends BostonTerrierModel {
        public ModelPart ArmBaseLeft;
        public ModelPart ArmBaseRight;
        public ModelPart Hips;
        public ModelPart UpperLegLeft;
        public ModelPart LowerLegLeft;
        public ModelPart UpperLegRight;
        public ModelPart LowerLegRight;
        public ModelPart NeckLower;
        public ModelPart CollarLeft;
        public ModelPart MuzzleLeft;
        public ModelPart MuzzleRight;
        public ModelPart CollarRight;
        public ModelPart ForearmLeft;
        public ModelPart ForearmRight;
        
        public Adult() {
            this.texWidth = 64;
            this.texHeight = 64;
            this.UpperLegRight = new ModelPart(this, 35, 26);
            this.UpperLegRight.mirror = true;
            this.UpperLegRight.setPos(0.1F, 3.7F, -1.2F);
            this.UpperLegRight.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
            this.setRotateAngle(UpperLegRight, 0.6373942428283291F, 0.0F, 0.0F);
            this.HandLeft = new ModelPart(this, 22, 15);
            this.HandLeft.setPos(-0.1F, 1.3F, 1.4F);
            this.HandLeft.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.ForearmRight = new ModelPart(this, 34, 11);
            this.ForearmRight.mirror = true;
            this.ForearmRight.setPos(0.0F, 1.6F, -2.0F);
            this.ForearmRight.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(ForearmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.ArmLeft = new ModelPart(this, 22, 7);
            this.ArmLeft.setPos(0.0F, 4.0F, 1.0F);
            this.ArmLeft.addBox(-1.0F, -0.2F, -2.0F, 2, 2, 2, 0.0F);
            this.ArmRight = new ModelPart(this, 34, 7);
            this.ArmRight.mirror = true;
            this.ArmRight.setPos(0.0F, 4.0F, 1.0F);
            this.ArmRight.addBox(-1.0F, -0.2F, -2.0F, 2, 2, 2, 0.0F);
            this.Chest = new ModelPart(this, 0, 0);
            this.Chest.setPos(0.0F, 15.6F, -3.7F);
            this.Chest.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4, 0.0F);
            this.setRotateAngle(Chest, -0.1153662635568252F, 0.0F, 0.0F);
            this.ArmBaseLeft = new ModelPart(this, 20, 0);
            this.ArmBaseLeft.setPos(2.0F, 0.5F, 0.2F);
            this.ArmBaseLeft.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
            this.setRotateAngle(ArmBaseLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.NeckLower = new ModelPart(this, 16, 31);
            this.NeckLower.setPos(0.0F, -3.8F, -2.1F);
            this.NeckLower.addBox(-1.5F, 0.0F, 0.0F, 3, 6, 2, 0.0F);
            this.setRotateAngle(NeckLower, -0.045553093477052F, 0.0F, 0.0F);
            this.ForearmLeft = new ModelPart(this, 22, 11);
            this.ForearmLeft.setPos(0.0F, 1.6F, -2.0F);
            this.ForearmLeft.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(ForearmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.MuzzleLeft = new ModelPart(this, 23, 48);
            this.MuzzleLeft.setPos(0.0F, 0.1F, -5.4F);
            this.MuzzleLeft.addBox(-1.9F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
            this.setRotateAngle(MuzzleLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.TopSnout = new ModelPart(this, 0, 55);
            this.TopSnout.setPos(0.0F, 0.0F, -0.4F);
            this.TopSnout.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(TopSnout, 0.31869712141416456F, 0.0F, 0.0F);
            this.Body = new ModelPart(this, 0, 10);
            this.Body.setPos(0.0F, -3.0F, 1.7F);
            this.Body.addBox(-2.5F, 0.0F, 0.0F, 5, 6, 5, 0.0F);
            this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
            this.ThighRight = new ModelPart(this, 33, 19);
            this.ThighRight.mirror = true;
            this.ThighRight.setPos(-2.1F, 2.5F, 1.6F);
            this.ThighRight.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
            this.setRotateAngle(ThighRight, 0.136659280431156F, 0.0F, 0.0F);
            this.UpperLegLeft = new ModelPart(this, 25, 26);
            this.UpperLegLeft.setPos(-0.1F, 3.7F, -1.2F);
            this.UpperLegLeft.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
            this.setRotateAngle(UpperLegLeft, 0.6373942428283291F, 0.0F, 0.0F);
            this.Head = new ModelPart(this, 0, 39);
            this.Head.setPos(0.0F, -3.3F, -0.6F);
            this.Head.addBox(-2.5F, -2.5F, -2.5F, 5, 6, 5, 0.0F);
            this.setRotateAngle(Head, -0.40980330836826856F, 0.0F, 0.0F);
            this.Snout = new ModelPart(this, 0, 50);
            this.Snout.setPos(0.0F, 0.1F, -3.5F);
            this.Snout.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 2, 0.0F);
            this.setRotateAngle(Snout, -0.136659280431156F, 0.0F, 0.0F);
            this.MuzzleRight = new ModelPart(this, 23, 48);
            this.MuzzleRight.setPos(0.0F, 0.0F, 0.0F);
            this.MuzzleRight.addBox(-2.1F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
            this.EarLeft = new ModelPart(this, 20, 43);
            this.EarLeft.setPos(1.2F, -2.4F, 1.4F);
            this.EarLeft.addBox(-1.0F, -2.5F, -0.5F, 3, 4, 1, 0.0F);
            this.setRotateAngle(EarLeft, 0.136659280431156F, 0.0F, 0.22759093446006054F);
            this.LowerLegLeft = new ModelPart(this, 27, 31);
            this.LowerLegLeft.setPos(0.0F, 3.0F, 2.0F);
            this.LowerLegLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(LowerLegLeft, -0.5918411493512771F, 0.0F, 0.0F);
            this.Mouth = new ModelPart(this, 12, 50);
            this.Mouth.setPos(0.0F, 2.4F, 2.3F);
            this.Mouth.addBox(-1.5F, 0.0F, -2.0F, 3, 1, 2, 0.0F);
            this.setRotateAngle(Mouth, -0.136659280431156F, 0.0F, 0.0F);
            this.FootLeft = new ModelPart(this, 27, 36);
            this.FootLeft.setPos(-0.1F, 2.2F, -0.7F);
            this.FootLeft.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.CollarLeft = new ModelPart(this, 40, 50);
            this.CollarLeft.setPos(0.1F, 0.2F, -3.1F);
            this.CollarLeft.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
            this.setRotateAngle(CollarLeft, 0.18203784098300857F, 0.0F, 0.0F);
            this.FootRight = new ModelPart(this, 35, 36);
            this.FootRight.mirror = true;
            this.FootRight.setPos(0.1F, 2.2F, -0.7F);
            this.FootRight.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.LowerLegRight = new ModelPart(this, 35, 31);
            this.LowerLegRight.mirror = true;
            this.LowerLegRight.setPos(0.0F, 3.0F, 2.0F);
            this.LowerLegRight.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(LowerLegRight, -0.5918411493512771F, 0.0F, 0.0F);
            this.EarRight = new ModelPart(this, 28, 43);
            this.EarRight.mirror = true;
            this.EarRight.setPos(-1.2F, -2.4F, 1.4F);
            this.EarRight.addBox(-2.0F, -2.5F, -0.5F, 3, 4, 1, 0.0F);
            this.setRotateAngle(EarRight, 0.136659280431156F, 0.0F, -0.22759093446006054F);
            this.HandRight = new ModelPart(this, 34, 15);
            this.HandRight.mirror = true;
            this.HandRight.setPos(0.1F, 1.3F, 1.4F);
            this.HandRight.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.CollarRight = new ModelPart(this, 40, 50);
            this.CollarRight.setPos(-0.2F, 0.0F, 0.0F);
            this.CollarRight.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
            this.Hips = new ModelPart(this, 0, 21);
            this.Hips.setPos(0.0F, 0.0F, 5.0F);
            this.Hips.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 3, 0.0F);
            this.setRotateAngle(Hips, -0.091106186954104F, 0.0F, 0.0F);
            this.ThighLeft = new ModelPart(this, 21, 19);
            this.ThighLeft.setPos(2.1F, 2.5F, 1.6F);
            this.ThighLeft.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
            this.setRotateAngle(ThighLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.Neck = new ModelPart(this, 0, 30);
            this.Neck.setPos(0.0F, -1.1F, -1.5F);
            this.Neck.addBox(-2.0F, -4.0F, -2.0F, 4, 5, 4, 0.0F);
            this.setRotateAngle(Neck, 0.6829473363053812F, 0.0F, 0.0F);
            this.ArmBaseRight = new ModelPart(this, 32, 0);
            this.ArmBaseRight.mirror = true;
            this.ArmBaseRight.setPos(-2.0F, 0.5F, 0.2F);
            this.ArmBaseRight.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.0F, 0.0F);
            this.ThighRight.addChild(this.UpperLegRight);
            this.ForearmLeft.addChild(this.HandLeft);
            this.ArmRight.addChild(this.ForearmRight);
            this.ArmBaseLeft.addChild(this.ArmLeft);
            this.ArmBaseRight.addChild(this.ArmRight);
            this.Chest.addChild(this.ArmBaseLeft);
            this.Neck.addChild(this.NeckLower);
            this.ArmLeft.addChild(this.ForearmLeft);
            this.Head.addChild(this.MuzzleLeft);
            this.Snout.addChild(this.TopSnout);
            this.Chest.addChild(this.Body);
            this.Hips.addChild(this.ThighRight);
            this.ThighLeft.addChild(this.UpperLegLeft);
            this.Neck.addChild(this.Head);
            this.Head.addChild(this.Snout);
            this.MuzzleLeft.addChild(this.MuzzleRight);
            this.Head.addChild(this.EarLeft);
            this.UpperLegLeft.addChild(this.LowerLegLeft);
            this.Snout.addChild(this.Mouth);
            this.LowerLegLeft.addChild(this.FootLeft);
            this.Neck.addChild(this.CollarLeft);
            this.LowerLegRight.addChild(this.FootRight);
            this.UpperLegRight.addChild(this.LowerLegRight);
            this.Head.addChild(this.EarRight);
            this.ForearmRight.addChild(this.HandRight);
            this.CollarLeft.addChild(this.CollarRight);
            this.Body.addChild(this.Hips);
            this.Hips.addChild(this.ThighLeft);
            this.Chest.addChild(this.Neck);
            this.Chest.addChild(this.ArmBaseRight);
        }

        @Override
        public void playIdleAnimation(BostonTerrierEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? 1.0F : 0.68F);
            this.Head.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.40F;
        }

        @Override
        public void playMovementAnimation(BostonTerrierEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 2.5f;
            float degree = 0.8f;

            if (entity.isSprinting()) {
                this.ArmBaseLeft.xRot = Mth.cos((limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 4.0F) * limbSwingAmount * 0.5F + -0.1F;
                this.ArmLeft.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F + -0.4F;
                this.ForearmLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 4.0F) * limbSwingAmount * 0.5F + 0.3F;
                this.HandLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F;
//                this.ArmBaseLeft.y = MathHelper.cos(5.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.4F) * limbSwingAmount * 0.5F;
//                this.ArmBaseLeft.z = MathHelper.cos(1.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F;
                this.ArmBaseRight.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 4.0F) * limbSwingAmount * 0.5F;
                this.ArmRight.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F + -0.4F;
                this.ForearmRight.xRot = Mth.cos(6.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 4.0F) * limbSwingAmount * 0.5F + 0.3F;
                this.HandRight.xRot = Mth.cos(6.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F;
//                this.ArmBaseRight.y = MathHelper.cos(6.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.4F) * limbSwingAmount * 0.5F;
//                this.ArmBaseRight.z = MathHelper.cos(2.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F;
                this.ThighLeft.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -4.0F) * limbSwingAmount * 0.5F + 0.2F;
                this.UpperLegLeft.xRot = Mth.cos((limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -4.0F) * limbSwingAmount * 0.5F + 0.75F;
                this.LowerLegLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 4.0F) * limbSwingAmount * 0.5F + -0.7F;
                this.FootLeft.xRot = Mth.cos((limbSwing * speed * 0.0F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F;
//                this.ThighLeft.y = MathHelper.cos(4.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.8F) * limbSwingAmount * 0.5F + 0.01F;
                this.ThighRight.xRot = Mth.cos(2.5F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -4.0F) * limbSwingAmount * 0.5F + 0.2F;
                this.UpperLegRight.xRot = Mth.cos(0.5F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -4.0F) * limbSwingAmount * 0.5F + 0.75F;
                this.LowerLegRight.xRot = Mth.cos(5.5F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 4.0F) * limbSwingAmount * 0.5F + -0.7F;
                this.FootRight.xRot = Mth.cos(0.5F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F;
//                this.ThighRight.y = MathHelper.cos(4.5F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.8F) * limbSwingAmount * 0.5F + 0.01F;
                this.Chest.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + 0.11F;
                this.Body.xRot = Mth.cos(6.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.8F) * limbSwingAmount * 0.5F + -0.05F;
                this.Hips.xRot = Mth.cos(3.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -1.5F) * limbSwingAmount * 0.5F + -0.2F;
                this.Neck.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -1.2F) * limbSwingAmount * 0.5F + 0.95F;
                this.Head.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 0.5F) * limbSwingAmount * 0.5F + -0.9F;
//                this.Neck.z = MathHelper.cos(1.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F;
//                this.Neck.y = MathHelper.cos((limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.02F;
//                this.Head.y = MathHelper.cos((limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + -0.035F;
                this.Mouth.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + 0.5F;
//                this.Tongue.z = MathHelper.cos((limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 0.0F) * limbSwingAmount * 0.5F + -0.05F;
//                this.Chest.y = MathHelper.cos(4.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F;

            } else {
                this.ArmBaseLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.13F;
                this.ArmLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.5F) * limbSwingAmount * 0.5F + -0.04F;
                this.HandLeft.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.09F;
                this.ArmBaseRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.13F;
                this.ArmRight.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.5F) * limbSwingAmount * 0.5F + -0.04F;
                this.HandRight.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.09F;
                this.ArmBaseLeft.z = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + 0.2F;
                this.ArmBaseRight.z = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + 0.2F;
                this.Neck.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 0.68F;
                this.Head.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + -0.40F;
                this.ThighLeft.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.18F;
                this.UpperLegLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + 0.63F;
                this.LowerLegLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + -0.68F;
                this.FootLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F;
                this.ThighLeft.y = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 2.5F;
                this.ThighLeft.z = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + 1.6F;
                this.ThighRight.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.18F;
                this.UpperLegRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + 0.63F;
                this.LowerLegRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + -0.68F;
                this.FootRight.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F;
                this.ThighRight.y = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 2.5F;
                this.ThighRight.z = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 1.6F;
                this.Chest.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.05F) * limbSwingAmount * 0.5F + -0.12F;
                this.Body.xRot = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 0.05F;
                this.Hips.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + -0.09F;
                this.Neck.z = Mth.cos(5.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.07F) * limbSwingAmount * 0.5F + -1.5F;
                this.Chest.y = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.09F) * limbSwingAmount * 0.5F + 15.6F;
            }
        }

        @Override
        public void setSittingPose(BostonTerrierEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmBaseLeft.setPos(1.6F, 0.1F, -0.9F);
            this.ArmBaseRight.setPos(-1.6F, 0.2F, -0.9F);
            this.Body.setPos(0.0F, -2.6F, 1.7F);
            this.Chest.setPos(0.0F, 16.6F, -1.7F);
            this.LowerLegLeft.setPos(0.55F, 3.0F, 2.1F);
            this.LowerLegRight.setPos(-0.55F, 3.0F, 2.1F);
            this.setRotateAngle(ArmBaseLeft, 0.5918411493512771F, 0.0F, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.5918411493512771F, 0.0F, 0.0F);
            this.setRotateAngle(Body, -0.36425021489121656F, 0.0F, 0.0F);
            this.setRotateAngle(Chest, -0.5009094953223726F, 0.0F, 0.0F);
            this.setRotateAngle(FootLeft, 1.593485607070823F, 0.0F, 0.0F);
            this.setRotateAngle(FootRight, 1.593485607070823F, 0.0F, 0.0F);
            this.setRotateAngle(Hips, -0.5918411493512771F, 0.0F, 0.0F);
            this.setRotateAngle(LowerLegLeft, -1.1383037381507017F, 0.0F, 0.0F);
            this.setRotateAngle(LowerLegRight, -1.1383037381507017F, 0.0F, 0.0F);
            this.setRotateAngle(Neck, 1.0016444577195458F, 0.0F, 0.0F);
            this.setRotateAngle(ThighLeft, -1.1383037381507017F, -0.091106186954104F, -0.136659280431156F);
            this.setRotateAngle(ThighRight, -1.1383037381507017F, 0.091106186954104F, 0.136659280431156F);
            this.setRotateAngle(UpperLegLeft, 2.1855012893472994F, 0.0F, 0.0F);
            this.setRotateAngle(UpperLegRight, 2.1855012893472994F, 0.0F, 0.0F);
            this.ThighLeft.setPos(2.1F, 1.1F, 4.4F);
            this.ThighRight.setPos(-2.1F, 1.1F, 4.4F);
            this.UpperLegLeft.setPos(-0.1F, 4.0F, 0.8F);
            this.UpperLegRight.setPos(0.1F, 4.0F, 0.8F);

        }

        @Override
        public void setLyingPose(BostonTerrierEntity entity, float speed, float walkSpeed, float partialTick) {
            this.LowerLegRight.setPos(0.0F, 3.0F, 2.0F);
            this.setRotateAngle(LowerLegRight, -0.5918411493512771F, 0.0F, 0.0F);
            this.LowerLegLeft.setPos(0.0F, 3.0F, 2.0F);
            this.setRotateAngle(LowerLegLeft, -0.5918411493512771F, 0.0F, 0.0F);
            this.CollarRight.setPos(-0.2F, 0.0F, 0.0F);
            this.ForearmRight.setPos(0.0F, 1.6F, -2.0F);
            this.setRotateAngle(ForearmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.FootLeft.setPos(-0.1F, 2.2F, -0.7F);
            this.Body.setPos(0.0F, -3.0F, 1.7F);
            this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
            this.NeckLower.setPos(0.0F, -3.8F, -2.1F);
            this.setRotateAngle(NeckLower, -0.045553093477052F, 0.0F, 0.0F);
            this.TopSnout.setPos(0.0F, 0.0F, -0.4F);
            this.setRotateAngle(TopSnout, 0.31869712141416456F, 0.0F, 0.0F);
            this.ForearmLeft.setPos(0.0F, 1.6F, -2.0F);
            this.setRotateAngle(ForearmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.ThighLeft.setPos(1.0F, 3.9F, 1.0F);
            this.setRotateAngle(ThighLeft, 0.8651597102135892F, -0.045553093477052F, -1.5481070465189704F);
            this.Hips.setPos(0.0F, 0.0F, 5.0F);
            this.setRotateAngle(Hips, -0.091106186954104F, 0.0F, 0.0F);
            this.MuzzleRight.setPos(0.0F, 0.0F, 0.0F);
            this.Chest.setPos(0.0F, 21.6F, -3.7F);
            this.UpperLegRight.setPos(0.1F, 3.7F, -1.2F);
            this.setRotateAngle(UpperLegRight, 1.0471975511965976F, 0.0F, 0.0F);
            this.EarRight.setPos(-1.2F, -2.4F, 1.4F);
            this.setRotateAngle(EarRight, 0.136659280431156F, 0.6373942428283291F, -0.5462880558742251F);
            this.Neck.setPos(0.0F, -1.1F, -1.5F);
            this.setRotateAngle(Neck, 1.3658946726107624F, 0.0F, 0.0F);
            this.EarLeft.setPos(1.2F, -2.4F, 1.4F);
            this.setRotateAngle(EarLeft, 0.136659280431156F, -0.40980330836826856F, 0.6829473363053812F);
            this.MuzzleLeft.setPos(0.0F, 0.1F, -5.4F);
            this.setRotateAngle(MuzzleLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.Head.setPos(0.0F, -3.5F, -0.4F);
            this.setRotateAngle(Head, -1.1838568316277536F, 0.0F, 0.0F);
            this.Mouth.setPos(0.0F, 2.4F, 2.3F);
            this.setRotateAngle(Mouth, -0.136659280431156F, 0.0F, 0.0F);
            this.ArmLeft.setPos(0.0F, 4.0F, 1.0F);
            this.ThighRight.setPos(-1.0F, 3.9F, 1.0F);
            this.setRotateAngle(ThighRight, 0.8651597102135892F, 0.045553093477052F, 1.5481070465189704F);
            this.ArmBaseLeft.setPos(2.0F, 1.4F, 0.2F);
            this.setRotateAngle(ArmBaseLeft, -1.5481070465189704F, -0.31869712141416456F, 0.0F);
            this.CollarLeft.setPos(0.1F, 0.2F, -3.1F);
            this.setRotateAngle(CollarLeft, -0.36425021489121656F, 0.0F, 0.0F);
            this.UpperLegLeft.setPos(-0.1F, 3.9F, -1.2F);
            this.setRotateAngle(UpperLegLeft, 1.0471975511965976F, 0.0F, 0.0F);
            this.ArmRight.setPos(0.0F, 4.0F, 1.0F);
            this.FootRight.setPos(0.1F, 2.2F, -0.7F);
            this.ArmBaseRight.setPos(-2.0F, 1.1F, 0.2F);
            this.setRotateAngle(ArmBaseRight, -1.5025539530419183F, 0.31869712141416456F, 0.0F);
            this.Snout.setPos(0.0F, 0.1F, -3.5F);
            this.setRotateAngle(Snout, -0.136659280431156F, 0.0F, 0.0F);
            this.HandRight.setPos(0.1F, 1.3F, 1.4F);
            this.setRotateAngle(HandRight, 0.7740535232594852F, 0.0F, 0.0F);
            this.HandLeft.setPos(-0.1F, 1.3F, 1.4F);
            this.setRotateAngle(HandLeft, 0.8651597102135892F, 0.0F, 0.0F);
        }

        @Override
        public void resetPose(BostonTerrierEntity entity, float speed, float walkSpeed, float partialTick) {
            this.UpperLegRight.setPos(0.1F, 3.7F, -1.2F);
            this.setRotateAngle(UpperLegRight, 0.6373942428283291F, 0.0F, 0.0F);
            this.HandLeft.setPos(-0.1F, 1.3F, 1.4F);
            this.setRotateAngle(HandLeft, 0F, 0F, 0F);
            this.ForearmRight.setPos(0.0F, 1.6F, -2.0F);
            this.setRotateAngle(ForearmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.ArmLeft.setPos(0.0F, 4.0F, 1.0F);
            this.setRotateAngle(ArmLeft, 0F, 0F, 0F);
            this.ArmRight.setPos(0.0F, 4.0F, 1.0F);
            this.setRotateAngle(ArmRight, 0F, 0F, 0F);
            this.Chest.setPos(0.0F, 15.6F, -3.7F);
            this.setRotateAngle(Chest, -0.1153662635568252F, 0.0F, 0.0F);
            this.ArmBaseLeft.setPos(2.0F, 0.5F, 0.2F);
            this.setRotateAngle(ArmBaseLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.NeckLower.setPos(0.0F, -3.8F, -2.1F);
            this.setRotateAngle(NeckLower, -0.045553093477052F, 0.0F, 0.0F);
            this.ForearmLeft.setPos(0.0F, 1.6F, -2.0F);
            this.setRotateAngle(ForearmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.MuzzleLeft.setPos(0.0F, 0.1F, -5.4F);
            this.setRotateAngle(MuzzleLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.TopSnout.setPos(0.0F, 0.0F, -0.4F);
            this.setRotateAngle(TopSnout, 0.31869712141416456F, 0.0F, 0.0F);
            this.Body.setPos(0.0F, -3.0F, 1.7F);
            this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
            this.ThighRight.setPos(-2.1F, 2.5F, 1.6F);
            this.setRotateAngle(ThighRight, 0.136659280431156F, 0.0F, 0.0F);
            this.UpperLegLeft.setPos(-0.1F, 3.7F, -1.2F);
            this.setRotateAngle(UpperLegLeft, 0.6373942428283291F, 0.0F, 0.0F);
            this.Head.setPos(0.0F, -3.3F, -0.6F);
            this.setRotateAngle(Head, -0.40980330836826856F, 0.0F, 0.0F);
            this.Snout.setPos(0.0F, 0.1F, -3.5F);
            this.setRotateAngle(Snout, -0.136659280431156F, 0.0F, 0.0F);
            this.MuzzleRight.setPos(0.0F, 0.0F, 0.0F);
            this.EarLeft.setPos(1.2F, -2.4F, 1.4F);
            this.setRotateAngle(EarLeft, 0.136659280431156F, 0.0F, 0.22759093446006054F);
            this.LowerLegLeft.setPos(0.0F, 3.0F, 2.0F);
            this.setRotateAngle(LowerLegLeft, -0.5918411493512771F, 0.0F, 0.0F);
            this.Mouth.setPos(0.0F, 2.4F, 2.3F);
            this.setRotateAngle(Mouth, -0.136659280431156F, 0.0F, 0.0F);
            this.FootLeft.setPos(-0.1F, 2.2F, -0.7F);
            this.setRotateAngle(FootLeft, 0F, 0F, 0F);
            this.CollarLeft.setPos(0.1F, 0.2F, -3.1F);
            this.setRotateAngle(CollarLeft, 0.18203784098300857F, 0.0F, 0.0F);
            this.FootRight.setPos(0.1F, 2.2F, -0.7F);
            this.setRotateAngle(FootRight, 0F, 0F, 0F);
            this.LowerLegRight.setPos(0.0F, 3.0F, 2.0F);
            this.setRotateAngle(LowerLegRight, -0.5918411493512771F, 0.0F, 0.0F);
            this.EarRight.setPos(-1.2F, -2.4F, 1.4F);
            this.setRotateAngle(EarRight, 0.136659280431156F, 0.0F, -0.22759093446006054F);
            this.HandRight.setPos(0.1F, 1.3F, 1.4F);
            this.setRotateAngle(HandRight, 0F, 0F, 0F);
            this.CollarRight.setPos(-0.2F, 0.0F, 0.0F);
            this.Hips.setPos(0.0F, 0.0F, 5.0F);
            this.setRotateAngle(Hips, -0.091106186954104F, 0.0F, 0.0F);
            this.ThighLeft.setPos(2.1F, 2.5F, 1.6F);
            this.setRotateAngle(ThighLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.Neck.setPos(0.0F, -1.1F, -1.5F);
            this.setRotateAngle(Neck, 0.6829473363053812F, 0.0F, 0.0F);
            this.ArmBaseRight.setPos(-2.0F, 0.5F, 0.2F);
            this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.0F, 0.0F);
        }
    }

    public static class Baby extends BostonTerrierModel {
        public ModelPart EarFlapLeft;
        public ModelPart EarFlapRight;
        public ModelPart LegLeft;
        public ModelPart LegRight;

        public Baby() {
            this.texWidth = 64;
            this.texHeight = 32;
            this.EarLeft = new ModelPart(this, 10, 9);
            this.EarLeft.setPos(1.1F, -0.7F, 0.4F);
            this.EarLeft.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
            this.setRotateAngle(EarLeft, 0.136659280431156F, -0.091106186954104F, 0.31869712141416456F);
            this.EarRight = new ModelPart(this, 14, 12);
            this.EarRight.mirror = true;
            this.EarRight.setPos(-1.1F, -0.7F, 0.4F);
            this.EarRight.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
            this.setRotateAngle(EarRight, 0.136659280431156F, 0.091106186954104F, -0.31869712141416456F);
            this.ThighRight = new ModelPart(this, 44, 0);
            this.ThighRight.mirror = true;
            this.ThighRight.setPos(-1.7F, 0.9F, 2.7F);
            this.ThighRight.addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3, 0.0F);
            this.HandLeft = new ModelPart(this, 24, 20);
            this.HandLeft.setPos(-0.1F, 3.5F, 0.6F);
            this.HandLeft.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(HandLeft, -0.091106186954104F, 0.0F, 0.0F);
            this.Neck = new ModelPart(this, 0, 9);
            this.Neck.setPos(0.0F, -1.0F, -1.0F);
            this.Neck.addBox(-1.5F, -2.7F, -2.1F, 3, 4, 4, 0.0F);
            this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
            this.TopSnout = new ModelPart(this, 8, 28);
            this.TopSnout.setPos(0.0F, -0.4F, -0.1F);
            this.TopSnout.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(TopSnout, 0.091106186954104F, 0.0F, 0.0F);
            this.EarFlapRight = new ModelPart(this, 20, 12);
            this.EarFlapRight.mirror = true;
            this.EarFlapRight.setPos(0.0F, -2.0F, 1.0F);
            this.EarFlapRight.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(EarFlapRight, -0.091106186954104F, 0.0F, 0.0F);
            this.ArmRight = new ModelPart(this, 32, 15);
            this.ArmRight.mirror = true;
            this.ArmRight.setPos(-1.7F, 0.7F, -0.5F);
            this.ArmRight.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
            this.Head = new ModelPart(this, 0, 17);
            this.Head.setPos(0.0F, -2.1F, -0.2F);
            this.Head.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
            this.setRotateAngle(Head, -0.6373942428283291F, 0.0F, 0.0F);
            this.Snout = new ModelPart(this, 0, 25);
            this.Snout.setPos(0.0F, 0.5F, -0.5F);
            this.Snout.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 2, 0.0F);
            this.setRotateAngle(Snout, -0.18203784098300857F, 0.0F, 0.0F);
            this.Mouth = new ModelPart(this, 10, 25);
            this.Mouth.setPos(0.0F, 2.1F, 0.2F);
            this.Mouth.addBox(-1.0F, -1.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(Mouth, -0.045553093477052F, 0.0F, 0.0F);
            this.HandRight = new ModelPart(this, 32, 20);
            this.HandRight.mirror = true;
            this.HandRight.setPos(0.1F, 3.5F, 0.6F);
            this.HandRight.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(HandRight, -0.091106186954104F, 0.0F, 0.0F);
            this.ArmLeft = new ModelPart(this, 24, 15);
            this.ArmLeft.setPos(1.7F, 0.7F, -0.5F);
            this.ArmLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.FootRight = new ModelPart(this, 45, 11);
            this.FootRight.mirror = true;
            this.FootRight.setPos(0.1F, 2.0F, 2.0F);
            this.FootRight.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(FootRight, -0.40980330836826856F, 0.0F, 0.0F);
            this.LegLeft = new ModelPart(this, 34, 7);
            this.LegLeft.setPos(-0.1F, 4.0F, -1.1F);
            this.LegLeft.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(LegLeft, 0.4553564018453205F, 0.0F, 0.0F);
            this.ThighLeft = new ModelPart(this, 34, 0);
            this.ThighLeft.setPos(1.7F, 0.9F, 2.7F);
            this.ThighLeft.addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3, 0.0F);
            this.LegRight = new ModelPart(this, 45, 7);
            this.LegRight.mirror = true;
            this.LegRight.setPos(0.1F, 4.0F, -1.1F);
            this.LegRight.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(LegRight, 0.4553564018453205F, 0.0F, 0.0F);
            this.Body = new ModelPart(this, 18, 0);
            this.Body.setPos(0.0F, -2.5F, 2.0F);
            this.Body.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 4, 0.0F);
            this.EarFlapLeft = new ModelPart(this, 16, 9);
            this.EarFlapLeft.setPos(0.0F, -2.0F, 1.0F);
            this.EarFlapLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(EarFlapLeft, -0.091106186954104F, 0.0F, 0.0F);
            this.FootLeft = new ModelPart(this, 34, 11);
            this.FootLeft.setPos(-0.1F, 2.0F, 2.0F);
            this.FootLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(FootLeft, -0.40980330836826856F, 0.0F, 0.0F);
            this.Chest = new ModelPart(this, 0, 0);
            this.Chest.setPos(0.0F, 19.5F, -2.0F);
            this.Chest.addBox(-2.5F, -2.5F, -2.0F, 5, 5, 4, 0.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.Head.addChild(this.EarLeft);
            this.Head.addChild(this.EarRight);
            this.Body.addChild(this.ThighRight);
            this.ArmLeft.addChild(this.HandLeft);
            this.Chest.addChild(this.Neck);
            this.Snout.addChild(this.TopSnout);
            this.EarRight.addChild(this.EarFlapRight);
            this.Chest.addChild(this.ArmRight);
            this.Neck.addChild(this.Head);
            this.Head.addChild(this.Snout);
            this.Snout.addChild(this.Mouth);
            this.ArmRight.addChild(this.HandRight);
            this.Chest.addChild(this.ArmLeft);
            this.LegRight.addChild(this.FootRight);
            this.ThighLeft.addChild(this.LegLeft);
            this.Body.addChild(this.ThighLeft);
            this.ThighRight.addChild(this.LegRight);
            this.Chest.addChild(this.Body);
            this.EarLeft.addChild(this.EarFlapLeft);
            this.LegLeft.addChild(this.FootLeft);
        }

        @Override
        public void playIdleAnimation(BostonTerrierEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? 1.23F : 0.72F);
            this.Head.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? -0.45F : -0.63F);
        }

        @Override
        public void playMovementAnimation(BostonTerrierEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.4f;
            float degree = 0.5f;
            this.ArmLeft.xRot = Mth.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 3.0F) * limbSwingAmount * 0.5F;
            this.ArmRight.xRot = Mth.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F;
            this.ThighLeft.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + -0.05F;
            this.LegLeft.xRot = Mth.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * -1.5F) * limbSwingAmount * 0.5F + 0.6F;
            this.ThighRight.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + -0.05F;
            this.LegRight.xRot = Mth.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 1.5F) * limbSwingAmount * 0.5F + 0.6F;
            this.Neck.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + 0.72F;
            this.Head.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.63F;
            this.Chest.xRot = Mth.cos(3.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.07F) * limbSwingAmount * 0.5F + -0.03F;
            this.Body.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.025F;
            this.Chest.y = Mth.cos(4.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.03F) * limbSwingAmount * 0.5F + 19.5F;
        }

        @Override
        public void setSittingPose(BostonTerrierEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmLeft.setPos(1.3F, 1.2F, 0.2F);
            this.ArmRight.setPos(-1.3F, 1.2F, 0.2F);
            this.Neck.setPos(0.0F, -0.8F, -1.5F);
            this.setRotateAngle(ArmLeft, 0.7740535232594852F, 0.0F, 0.0F);
            this.setRotateAngle(ArmRight, 0.7740535232594852F, 0.0F, 0.0F);
            this.setRotateAngle(Body, -0.31869712141416456F, 0.0F, 0.0F);
            this.setRotateAngle(Chest, -0.7285004297824331F, 0.0F, 0.0F);
            this.setRotateAngle(Head, -0.4553564018453205F, 0.0F, 0.0F);
            this.setRotateAngle(Neck, 1.2292353921796064F, 0.0F, 0.0F);
            this.setRotateAngle(ThighLeft, -0.5462880558742251F, -0.36425021489121656F, 0.0F);
            this.setRotateAngle(ThighRight, -0.5462880558742251F, 0.36425021489121656F, 0.0F);
            this.ThighLeft.setPos(1.7F, 1.3F, 4.4F);
            this.ThighRight.setPos(-1.7F, 1.3F, 4.4F);

        }

        @Override
        public void setLyingPose(BostonTerrierEntity entity, float speed, float walkSpeed, float partialTick) {

        }

        @Override
        public void resetPose(BostonTerrierEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmLeft.setPos(1.7F, 0.7F, -0.5F);
            this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.ArmRight.setPos(-1.7F, 0.7F, -0.5F);
            this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
            this.Neck.setPos(0.0F, -1.0F, -1.0F);
            this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
            this.setRotateAngle(Body, 0.0F, 0.0F, 0.0F);
            this.Chest.setPos(0.0F, 19.5F, -2.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.setRotateAngle(Head, -0.6373942428283291F, 0.0F, 0.0F);
            this.ThighLeft.setPos(1.7F, 0.9F, 2.7F);
            this.setRotateAngle(ThighLeft, 0.0F, 0.0F, 0.0F);
            this.ThighRight.setPos(-1.7F, 0.9F, 2.7F);
            this.setRotateAngle(ThighRight, 0.0F, 0.0F, 0.0F);
            this.LegRight.setPos(0.1F, 4.0F, -1.1F);
            this.setRotateAngle(LegRight, 0.4553564018453205F, 0.0F, 0.0F);
            this.LegLeft.setPos(-0.1F, 4.0F, -1.1F);
            this.setRotateAngle(LegLeft, 0.4553564018453205F, 0.0F, 0.0F);
        }
    }
}
