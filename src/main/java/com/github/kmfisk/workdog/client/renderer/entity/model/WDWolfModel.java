package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.entity.WDWolfEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public abstract class WDWolfModel extends WorkDogModel<WDWolfEntity> {
    public ModelRenderer Chest;
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer ThighRight;
    public ModelRenderer ThighLeft;
    public ModelRenderer FootRight;
    public ModelRenderer FootLeft;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer EarLeft;
    public ModelRenderer EarRight;
    public ModelRenderer TopSnout;
    public ModelRenderer Mouth;
    public ModelRenderer ArmLeft;
    public ModelRenderer HandLeft;
    public ModelRenderer ArmRight;
    public ModelRenderer HandRight;
    private Iterable<ModelRenderer> parts;

    @Override
    public Iterable<ModelRenderer> parts() {
        if (parts == null)
            parts = ImmutableList.of(Chest);

        return parts;
    }

    public static class Adult extends WDWolfModel {
        public ModelRenderer ArmBaseLeft;
        public ModelRenderer ArmBaseRight;
        public ModelRenderer Hips;
        public ModelRenderer Tail1;
        public ModelRenderer Tail2;
        public ModelRenderer UpperLegRight;
        public ModelRenderer LowerLegRight;
        public ModelRenderer UpperLegLeft;
        public ModelRenderer LowerLegLeft;
        public ModelRenderer NeckLower;
        public ModelRenderer Collar;
        public ModelRenderer NeckFur2Left;
        public ModelRenderer NeckFur2Right;
        public ModelRenderer NeckFur2;
        public ModelRenderer FaceFurLeft;
        public ModelRenderer FaceFurRight;
        public ModelRenderer Muzzle;
        public ModelRenderer Tongue;
        public ModelRenderer ForearmLeft;
        public ModelRenderer ForearmRight;

        public Adult() {
            this.texWidth = 64;
            this.texHeight = 128;
            this.ThighLeft = new ModelRenderer(this, 2, 63);
            this.ThighLeft.setPos(2.2F, 1.9F, 2.4F);
            this.ThighLeft.addBox(-2.0F, 0.0F, -2.5F, 4, 6, 5, 0.0F);
            this.setRotateAngle(ThighLeft, 0.18203784098300857F, 0.0F, 0.0F);
            this.UpperLegRight = new ModelRenderer(this, 18, 74);
            this.UpperLegRight.mirror = true;
            this.UpperLegRight.setPos(0.0F, 6.0F, -2.4F);
            this.UpperLegRight.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
            this.setRotateAngle(UpperLegRight, 0.40980330836826856F, 0.0F, 0.0F);
            this.Chest = new ModelRenderer(this, 0, 0);
            this.Chest.setPos(0.0F, 11.4F, -5.7F);
            this.Chest.addBox(-3.5F, -4.0F, -2.5F, 7, 9, 5, 0.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.NeckFur2 = new ModelRenderer(this, 50, 54);
            this.NeckFur2.setPos(0.0F, -1.9F, -5.0F);
            this.NeckFur2.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
            this.setRotateAngle(NeckFur2, -0.27314402793711257F, 0.0F, 0.0F);
            this.ArmLeft = new ModelRenderer(this, 32, 37);
            this.ArmLeft.setPos(0.0F, 5.0F, 1.5F);
            this.ArmLeft.addBox(-1.5F, 0.0F, -3.0F, 3, 3, 3, 0.0F);
            this.setRotateAngle(ArmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.Tail1 = new ModelRenderer(this, 26, 12);
            this.Tail1.setPos(0.0F, 1.2F, 4.1F);
            this.Tail1.addBox(-1.5F, 0.0F, -1.8F, 3, 4, 3, 0.0F);
            this.setRotateAngle(Tail1, 0.5462880558742251F, 0.0F, 0.0F);
            this.ForearmLeft = new ModelRenderer(this, 34, 43);
            this.ForearmLeft.setPos(-0.1F, 2.5F, -3.0F);
            this.ForearmLeft.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
            this.setRotateAngle(ForearmLeft, -0.136659280431156F, 0.0F, 0.0F);
            this.Neck = new ModelRenderer(this, 0, 46);
            this.Neck.setPos(0.0F, -0.4F, 0.5F);
            this.Neck.addBox(-2.5F, -6.3F, -2.7F, 5, 9, 5, 0.0F);
            this.setRotateAngle(Neck, 0.8196066167365371F, 0.0F, 0.0F);
            this.FaceFurLeft = new ModelRenderer(this, 30, 20);
            this.FaceFurLeft.setPos(-0.5F, 0.0F, -2.3F);
            this.FaceFurLeft.addBox(0.9F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
            this.setRotateAngle(FaceFurLeft, -0.22759093446006054F, 0.0F, 0.0F);
            this.ArmBaseRight = new ModelRenderer(this, 46, 28);
            this.ArmBaseRight.mirror = true;
            this.ArmBaseRight.setPos(-1.9F, 1.0F, -0.1F);
            this.ArmBaseRight.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.0F, 0.0F);
            this.Muzzle = new ModelRenderer(this, 38, 104);
            this.Muzzle.setPos(0.0F, -1.0F, -6.6F);
            this.Muzzle.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 5, 0.0F);
            this.LowerLegRight = new ModelRenderer(this, 17, 82);
            this.LowerLegRight.mirror = true;
            this.LowerLegRight.setPos(0.1F, 4.0F, 3.5F);
            this.LowerLegRight.addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
            this.setRotateAngle(LowerLegRight, -0.36425021489121656F, 0.0F, 0.0F);
            this.NeckLower = new ModelRenderer(this, 20, 46);
            this.NeckLower.setPos(0.0F, -5.8F, -4.1F);
            this.NeckLower.addBox(-2.0F, 0.0F, 0.0F, 4, 8, 3, 0.0F);
            this.setRotateAngle(NeckLower, -0.091106186954104F, 0.0F, 0.0F);
            this.Tongue = new ModelRenderer(this, 46, 6);
            this.Tongue.setPos(0.0F, 0.0F, 1.5F);
            this.Tongue.addBox(-1.0F, 0.0F, -4.0F, 2, 0, 4, 0.0F);
            this.setRotateAngle(Tongue, -0.045553093477052F, 0.0F, 0.0F);
            this.FootRight = new ModelRenderer(this, 18, 89);
            this.FootRight.mirror = true;
            this.FootRight.setPos(0.1F, 4.0F, -0.9F);
            this.FootRight.addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3, 0.0F);
            this.FootLeft = new ModelRenderer(this, 6, 89);
            this.FootLeft.setPos(-0.1F, 4.0F, -0.9F);
            this.FootLeft.addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3, 0.0F);
            this.HandLeft = new ModelRenderer(this, 34, 49);
            this.HandLeft.setPos(-0.1F, 3.0F, 2.4F);
            this.HandLeft.addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3, 0.0F);
            this.setRotateAngle(HandLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.Tail2 = new ModelRenderer(this, 38, 12);
            this.Tail2.setPos(0.0F, 4.0F, -1.8F);
            this.Tail2.addBox(-1.5F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
            this.setRotateAngle(Tail2, 0.18203784098300857F, 0.0F, 0.003490658503988659F);
            this.Hips = new ModelRenderer(this, 0, 32);
            this.Hips.setPos(0.0F, 0.0F, 9.0F);
            this.Hips.addBox(-3.5F, 0.0F, 0.0F, 7, 9, 5, 0.0F);
            this.setRotateAngle(Hips, -0.18203784098300857F, 0.0F, 0.0F);
            this.LowerLegLeft = new ModelRenderer(this, 5, 82);
            this.LowerLegLeft.setPos(-0.1F, 4.0F, 3.5F);
            this.LowerLegLeft.addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
            this.setRotateAngle(LowerLegLeft, -0.36425021489121656F, 0.0F, 0.0F);
            this.HandRight = new ModelRenderer(this, 46, 49);
            this.HandRight.mirror = true;
            this.HandRight.setPos(0.1F, 3.0F, 2.4F);
            this.HandRight.addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3, 0.0F);
            this.setRotateAngle(HandRight, 0.091106186954104F, 0.0F, 0.0F);
            this.FaceFurRight = new ModelRenderer(this, 44, 20);
            this.FaceFurRight.mirror = true;
            this.FaceFurRight.setPos(-2.5F, 0.0F, -2.3F);
            this.FaceFurRight.addBox(-0.9F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
            this.setRotateAngle(FaceFurRight, -0.22759093446006054F, 0.0F, 0.0F);
            this.ArmBaseLeft = new ModelRenderer(this, 30, 28);
            this.ArmBaseLeft.setPos(1.9F, 1.0F, -0.1F);
            this.ArmBaseLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
            this.setRotateAngle(ArmBaseLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.Collar = new ModelRenderer(this, 32, 76);
            this.Collar.setPos(0.0F, -3.3F, -1.6F);
            this.Collar.addBox(-3.0F, 0.0F, -3.0F, 6, 1, 7, 0.0F);
            this.setRotateAngle(Collar, 0.136659280431156F, 0.0F, 0.0F);
            this.EarLeft = new ModelRenderer(this, 58, 0);
            this.EarLeft.setPos(1.9F, -2.8F, 0.0F);
            this.EarLeft.addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1, 0.0F);
            this.setRotateAngle(EarLeft, 0.4553564018453205F, 0.091106186954104F, 0.22759093446006054F);
            this.TopSnout = new ModelRenderer(this, 50, 8);
            this.TopSnout.setPos(0.0F, 0.0F, -3.1F);
            this.TopSnout.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 4, 0.0F);
            this.setRotateAngle(TopSnout, 0.136659280431156F, 0.0F, 0.0F);
            this.ForearmRight = new ModelRenderer(this, 46, 43);
            this.ForearmRight.mirror = true;
            this.ForearmRight.setPos(0.1F, 2.5F, -3.0F);
            this.ForearmRight.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
            this.setRotateAngle(ForearmRight, -0.136659280431156F, 0.0F, 0.0F);
            this.ThighRight = new ModelRenderer(this, 20, 63);
            this.ThighRight.mirror = true;
            this.ThighRight.setPos(-2.2F, 1.9F, 2.4F);
            this.ThighRight.addBox(-2.0F, 0.0F, -2.5F, 4, 6, 5, 0.0F);
            this.setRotateAngle(ThighRight, 0.18203784098300857F, 0.0F, 0.0F);
            this.NeckFur2Left = new ModelRenderer(this, 34, 54);
            this.NeckFur2Left.setPos(0.3F, -4.4F, -4.2F);
            this.NeckFur2Left.addBox(-2.5F, 0.0F, 0.0F, 5, 4, 3, 0.0F);
            this.setRotateAngle(NeckFur2Left, -0.40980330836826856F, 0.18203784098300857F, 0.0F);
            this.Head = new ModelRenderer(this, 26, 0);
            this.Head.setPos(0.0F, -5.9F, -1.1F);
            this.Head.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
            this.setRotateAngle(Head, -0.5918411493512771F, 0.0F, 0.0F);
            this.ArmRight = new ModelRenderer(this, 44, 37);
            this.ArmRight.mirror = true;
            this.ArmRight.setPos(0.0F, 5.0F, 1.5F);
            this.ArmRight.addBox(-1.5F, 0.0F, -3.0F, 3, 3, 3, 0.0F);
            this.setRotateAngle(ArmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.UpperLegLeft = new ModelRenderer(this, 4, 74);
            this.UpperLegLeft.setPos(0.0F, 6.0F, -2.4F);
            this.UpperLegLeft.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
            this.setRotateAngle(UpperLegLeft, 0.40980330836826856F, 0.0F, 0.0F);
            this.NeckFur2Right = new ModelRenderer(this, 34, 61);
            this.NeckFur2Right.mirror = true;
            this.NeckFur2Right.setPos(-0.3F, -4.4F, -4.2F);
            this.NeckFur2Right.addBox(-2.5F, 0.0F, 0.0F, 5, 4, 3, 0.0F);
            this.setRotateAngle(NeckFur2Right, -0.40980330836826856F, -0.18203784098300857F, 0.0F);
            this.Snout = new ModelRenderer(this, 44, 0);
            this.Snout.setPos(0.0F, -0.7F, -3.0F);
            this.Snout.addBox(-2.0F, 0.0F, -2.8F, 4, 3, 3, 0.0F);
            this.setRotateAngle(Snout, -0.045553093477052F, 0.0F, 0.0F);
            this.Mouth = new ModelRenderer(this, 52, 14);
            this.Mouth.setPos(0.0F, 2.5F, 0.0F);
            this.Mouth.addBox(-1.5F, 0.0F, -2.45F, 3, 1, 3, 0.0F);
            this.setRotateAngle(Mouth, -0.045553093477052F, 0.0F, 0.0F);
            this.EarRight = new ModelRenderer(this, 58, 4);
            this.EarRight.mirror = true;
            this.EarRight.setPos(-1.9F, -2.8F, 0.0F);
            this.EarRight.addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1, 0.0F);
            this.setRotateAngle(EarRight, 0.5009094953223726F, 0.091106186954104F, -0.22759093446006054F);
            this.Body = new ModelRenderer(this, 0, 14);
            this.Body.setPos(0.0F, -3.7F, 2.0F);
            this.Body.addBox(-3.0F, 0.0F, 0.0F, 6, 9, 9, 0.0F);
            this.Hips.addChild(this.ThighLeft);
            this.ThighRight.addChild(this.UpperLegRight);
            this.Neck.addChild(this.NeckFur2);
            this.ArmBaseLeft.addChild(this.ArmLeft);
            this.Hips.addChild(this.Tail1);
            this.ArmLeft.addChild(this.ForearmLeft);
            this.Chest.addChild(this.Neck);
            this.Head.addChild(this.FaceFurLeft);
            this.Chest.addChild(this.ArmBaseRight);
            this.Head.addChild(this.Muzzle);
            this.UpperLegRight.addChild(this.LowerLegRight);
            this.Neck.addChild(this.NeckLower);
            this.Mouth.addChild(this.Tongue);
            this.LowerLegRight.addChild(this.FootRight);
            this.LowerLegLeft.addChild(this.FootLeft);
            this.ForearmLeft.addChild(this.HandLeft);
            this.Tail1.addChild(this.Tail2);
            this.Body.addChild(this.Hips);
            this.UpperLegLeft.addChild(this.LowerLegLeft);
            this.ForearmRight.addChild(this.HandRight);
            this.Head.addChild(this.FaceFurRight);
            this.Chest.addChild(this.ArmBaseLeft);
            this.Neck.addChild(this.Collar);
            this.Head.addChild(this.EarLeft);
            this.Snout.addChild(this.TopSnout);
            this.ArmRight.addChild(this.ForearmRight);
            this.Hips.addChild(this.ThighRight);
            this.Neck.addChild(this.NeckFur2Left);
            this.Neck.addChild(this.Head);
            this.ArmBaseRight.addChild(this.ArmRight);
            this.ThighLeft.addChild(this.UpperLegLeft);
            this.Neck.addChild(this.NeckFur2Right);
            this.Head.addChild(this.Snout);
            this.Snout.addChild(this.Mouth);
            this.Head.addChild(this.EarRight);
            this.Chest.addChild(this.Body);
        }

        @Override
        public void playIdleAnimation(WDWolfEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = MathHelper.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + 0.7F;
            this.Head.xRot = MathHelper.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.55F;
            this.Tail1.xRot = MathHelper.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 1.2F;
            this.Tail1.yRot = MathHelper.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
            this.Tail2.zRot = MathHelper.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F;
        }

        @Override
        public void playMovementAnimation(WDWolfEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.5f;
            float degree = 0.6f;

            if (entity.isSprinting()) {
                this.ArmBaseLeft.xRot = MathHelper.cos((limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 4.0F) * limbSwingAmount * 0.5F + -0.1F;
                this.ArmLeft.xRot = MathHelper.cos(4.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F + -0.4F;
                this.ForearmLeft.xRot = MathHelper.cos(5.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 4.0F) * limbSwingAmount * 0.5F + 0.3F;
                this.HandLeft.xRot = MathHelper.cos(5.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F;
//                this.ArmBaseLeft.y = MathHelper.cos(5.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.4F) * limbSwingAmount * 0.5F;
//                this.ArmBaseLeft.z = MathHelper.cos(1.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F;
                this.ArmBaseRight.xRot = MathHelper.cos(1.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 4.0F) * limbSwingAmount * 0.5F;
                this.ArmRight.xRot = MathHelper.cos(5.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F + -0.4F;
                this.ForearmRight.xRot = MathHelper.cos(6.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 4.0F) * limbSwingAmount * 0.5F + 0.3F;
                this.HandRight.xRot = MathHelper.cos(6.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F;
//                this.ArmBaseRight.y = MathHelper.cos(6.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.4F) * limbSwingAmount * 0.5F;
//                this.ArmBaseRight.z = MathHelper.cos(2.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F;
                this.ThighLeft.xRot = MathHelper.cos(2.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -4.0F) * limbSwingAmount * 0.5F + 0.2F;
                this.UpperLegLeft.xRot = MathHelper.cos((limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -4.0F) * limbSwingAmount * 0.5F + 0.75F;
                this.LowerLegLeft.xRot = MathHelper.cos(5.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 4.0F) * limbSwingAmount * 0.5F + -0.7F;
                this.FootLeft.xRot = MathHelper.cos((limbSwing * speed * 0.0F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F;
//                this.ThighLeft.y = MathHelper.cos(4.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.8F) * limbSwingAmount * 0.5F + 0.01F;
                this.ThighRight.xRot = MathHelper.cos(2.5F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -4.0F) * limbSwingAmount * 0.5F + 0.2F;
                this.UpperLegRight.xRot = MathHelper.cos(0.5F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -4.0F) * limbSwingAmount * 0.5F + 0.75F;
                this.LowerLegRight.xRot = MathHelper.cos(5.5F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 4.0F) * limbSwingAmount * 0.5F + -0.7F;
                this.FootRight.xRot = MathHelper.cos(0.5F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F;
//                this.ThighRight.y = MathHelper.cos(4.5F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.8F) * limbSwingAmount * 0.5F + 0.01F;
                this.Chest.xRot = MathHelper.cos(4.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + 0.11F;
                this.Body.xRot = MathHelper.cos(6.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.8F) * limbSwingAmount * 0.5F + -0.05F;
                this.Hips.xRot = MathHelper.cos(3.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -1.5F) * limbSwingAmount * 0.5F + -0.2F;
                this.Neck.xRot = MathHelper.cos(1.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -1.2F) * limbSwingAmount * 0.5F + 0.95F;
                this.Head.xRot = MathHelper.cos(5.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 0.5F) * limbSwingAmount * 0.5F + -0.9F;
//                this.Neck.z = MathHelper.cos(1.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F;
//                this.Neck.y = MathHelper.cos((limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.02F;
//                this.Head.y = MathHelper.cos((limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + -0.035F;
                this.Tail1.xRot = MathHelper.cos(2.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 1.5F;
                this.Mouth.xRot = MathHelper.cos(1.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + 0.5F;
//                this.Tongue.z = MathHelper.cos((limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 0.0F) * limbSwingAmount * 0.5F + -0.05F;
//                this.Chest.y = MathHelper.cos(4.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F;

            } else {
                this.ArmBaseLeft.xRot = MathHelper.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.2F;
                this.ArmLeft.xRot = MathHelper.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.5F) * limbSwingAmount * 0.5F + -0.33F;
                this.ForearmLeft.xRot = MathHelper.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 3.0F) * limbSwingAmount * 0.5F + 0.2F;
                this.HandLeft.xRot = MathHelper.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.2F;
                this.ArmBaseRight.xRot = MathHelper.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.2F;
                this.ArmRight.xRot = MathHelper.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.5F) * limbSwingAmount * 0.5F + -0.33F;
                this.ForearmRight.xRot = MathHelper.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F + 0.2F;
                this.HandRight.xRot = MathHelper.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.2F;
//                this.ArmBaseLeft.z = MathHelper.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F;
//                this.ArmBaseRight.z = MathHelper.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F;
                this.Neck.xRot = MathHelper.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 1.0F;
                this.Head.xRot = MathHelper.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + -0.8F;
                this.ThighLeft.xRot = MathHelper.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.2F;
                this.UpperLegLeft.xRot = MathHelper.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.6F;
                this.LowerLegLeft.xRot = MathHelper.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + -0.85F;
                this.FootLeft.xRot = MathHelper.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.1F;
//            this.ThighLeft.y = MathHelper.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F;
//                this.ThighLeft.z = MathHelper.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + 0.03F;
                this.ThighRight.xRot = MathHelper.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.2F;
                this.UpperLegRight.xRot = MathHelper.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.6F;
                this.LowerLegRight.xRot = MathHelper.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + -0.85F;
                this.FootRight.xRot = MathHelper.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.1F;
//            this.ThighRight.y = MathHelper.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F;
//                this.ThighRight.z = MathHelper.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 0.03F;
                this.Chest.xRot = MathHelper.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.05F) * limbSwingAmount * 0.5F + -0.05F;
                this.Body.xRot = MathHelper.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 0.04F;
                this.Hips.xRot = MathHelper.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + -0.15F;
//                this.Neck.z = MathHelper.cos(5.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.07F) * limbSwingAmount * 0.5F;
                this.Tail1.xRot = MathHelper.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.5F) * limbSwingAmount * 0.5F + 1.3F;
                this.Tail1.yRot = MathHelper.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
//            this.Chest.y = MathHelper.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.09F) * limbSwingAmount * 0.5F;
            }
        }

        @Override
        public void prepareMobModel(WDWolfEntity entity, float speed, float walkSpeed, float partialTick) {
            if (entity.isInSittingPose()) {
                this.Body.setPos(0.0F, -2.8F, 2.3F);
                this.FootLeft.setPos(-0.1F, 3.0F, -0.9F);
                this.FootRight.setPos(0.1F, 3.0F, -0.9F);
                this.LowerLegLeft.setPos(-0.2F, 4.0F, 2.3F);
                this.LowerLegRight.setPos(0.2F, 4.0F, 2.3F);
                this.setRotateAngle(ArmBaseLeft, 0.36425021489121656F, 0.0F, 0.0F);
                this.setRotateAngle(ArmBaseRight, 0.36425021489121656F, 0.0F, 0.0F);
                this.setRotateAngle(Body, -0.40980330836826856F, 0.0F, 0.0F);
                this.setRotateAngle(Chest, -0.27314402793711257F, 0.0F, 0.0F);
                this.setRotateAngle(FootLeft, 1.5025539530419183F, 0.0F, 0.0F);
                this.setRotateAngle(FootRight, 1.5025539530419183F, 0.0F, 0.0F);
                this.setRotateAngle(Head, -0.4553564018453205F, 0.0F, 0.0F);
                this.setRotateAngle(Hips, -0.4553564018453205F, 0.0F, 0.0F);
                this.setRotateAngle(LowerLegLeft, -1.4570008595648662F, 0.0F, 0.0F);
                this.setRotateAngle(LowerLegRight, -1.4570008595648662F, 0.0F, 0.0F);
                this.setRotateAngle(Tail1, 1.9123572614101867F, -0.5009094953223726F, 0.0F);
                this.setRotateAngle(Tail2, 0.31869712141416456F, -0.5918411493512771F, 0.5009094953223726F);
                this.setRotateAngle(ThighLeft, -1.0016444577195458F, -0.136659280431156F, -0.27314402793711257F);
                this.setRotateAngle(ThighRight, -1.0016444577195458F, 0.136659280431156F, 0.27314402793711257F);
                this.setRotateAngle(UpperLegLeft, 2.1399481958702475F, 0.0F, 0.0F);
                this.setRotateAngle(UpperLegRight, 2.1399481958702475F, 0.0F, 0.0F);
                this.Tail1.setPos(0.0F, 2.2F, 5.1F);
                this.ThighLeft.setPos(2.2F, 2.9F, 6.4F);
                this.ThighRight.setPos(-2.2F, 2.9F, 6.4F);
                this.UpperLegLeft.setPos(0.0F, 5.8F, 1.6F);
                this.UpperLegRight.setPos(0.0F, 5.8F, 1.6F);

            } else {
                this.Body.setPos(0.0F, -3.7F, 2.0F);
                this.FootLeft.setPos(-0.1F, 4.0F, -0.9F);
                this.FootRight.setPos(0.1F, 4.0F, -0.9F);
                this.LowerLegLeft.setPos(-0.1F, 4.0F, 3.5F);
                this.LowerLegRight.setPos(0.1F, 4.0F, 3.5F);
                this.setRotateAngle(ArmBaseLeft, 0.136659280431156F, 0.0F, 0.0F);
                this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.0F, 0.0F);
                this.setRotateAngle(Body, 0.0F, 0.0F, 0.0F);
                this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
                this.setRotateAngle(FootLeft, 0.0F, 0.0F, 0.0F);
                this.setRotateAngle(FootRight, 0.0F, 0.0F, 0.0F);
                this.setRotateAngle(Head, -0.5918411493512771F, 0.0F, 0.0F);
                this.setRotateAngle(Hips, -0.18203784098300857F, 0.0F, 0.0F);
                this.setRotateAngle(LowerLegLeft, -0.36425021489121656F, 0.0F, 0.0F);
                this.setRotateAngle(LowerLegRight, -0.36425021489121656F, 0.0F, 0.0F);
                this.setRotateAngle(Tail1, 0.5462880558742251F, 0.0F, 0.0F);
                this.setRotateAngle(Tail2, 0.18203784098300857F, 0.0F, 0.003490658503988659F);
                this.setRotateAngle(ThighLeft, 0.18203784098300857F, 0.0F, 0.0F);
                this.setRotateAngle(ThighRight, 0.18203784098300857F, 0.0F, 0.0F);
                this.setRotateAngle(UpperLegLeft, 0.40980330836826856F, 0.0F, 0.0F);
                this.setRotateAngle(UpperLegRight, 0.40980330836826856F, 0.0F, 0.0F);
                this.Tail1.setPos(0.0F, 1.2F, 4.1F);
                this.ThighLeft.setPos(2.2F, 1.9F, 2.4F);
                this.ThighRight.setPos(-2.2F, 1.9F, 2.4F);
                this.UpperLegLeft.setPos(0.0F, 6.0F, -2.4F);
                this.UpperLegRight.setPos(0.0F, 6.0F, -2.4F);
            }
        }
    }

    public static class Baby extends WDWolfModel {
        public ModelRenderer Tail;
        public ModelRenderer LegLeft;
        public ModelRenderer LegRight;

        public Baby() {
            this.texWidth = 64;
            this.texHeight = 32;
            this.FootRight = new ModelRenderer(this, 45, 11);
            this.FootRight.mirror = true;
            this.FootRight.setPos(0.1F, 2.0F, 2.0F);
            this.FootRight.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(FootRight, -0.40980330836826856F, 0.0F, 0.0F);
            this.Neck = new ModelRenderer(this, 0, 9);
            this.Neck.setPos(0.0F, -1.1F, -1.1F);
            this.Neck.addBox(-1.5F, -2.7F, -2.1F, 3, 4, 4, 0.0F);
            this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
            this.LegRight = new ModelRenderer(this, 45, 7);
            this.LegRight.mirror = true;
            this.LegRight.setPos(0.1F, 4.0F, -1.1F);
            this.LegRight.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(LegRight, 0.4553564018453205F, 0.0F, 0.0F);
            this.TopSnout = new ModelRenderer(this, 8, 28);
            this.TopSnout.setPos(0.0F, -0.4F, -0.1F);
            this.TopSnout.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(TopSnout, 0.091106186954104F, 0.0F, 0.0F);
            this.EarLeft = new ModelRenderer(this, 10, 9);
            this.EarLeft.setPos(1.1F, -1.2F, 0.4F);
            this.EarLeft.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
            this.setRotateAngle(EarLeft, 0.136659280431156F, -0.091106186954104F, 0.31869712141416456F);
            this.EarRight = new ModelRenderer(this, 14, 12);
            this.EarRight.mirror = true;
            this.EarRight.setPos(-1.1F, -1.2F, 0.4F);
            this.EarRight.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
            this.setRotateAngle(EarRight, 0.136659280431156F, 0.091106186954104F, -0.31869712141416456F);
            this.Chest = new ModelRenderer(this, 0, 0);
            this.Chest.setPos(0.0F, 18.8F, -2.0F);
            this.Chest.addBox(-2.5F, -2.5F, -2.0F, 5, 5, 4, 0.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.Head = new ModelRenderer(this, 0, 17);
            this.Head.setPos(0.0F, -2.1F, -0.2F);
            this.Head.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
            this.setRotateAngle(Head, -0.6373942428283291F, 0.0F, 0.0F);
            this.HandLeft = new ModelRenderer(this, 24, 20);
            this.HandLeft.setPos(-0.1F, 3.5F, 0.6F);
            this.HandLeft.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(HandLeft, -0.091106186954104F, 0.0F, 0.0F);
            this.ArmRight = new ModelRenderer(this, 32, 15);
            this.ArmRight.mirror = true;
            this.ArmRight.setPos(-1.7F, 1.3F, -0.5F);
            this.ArmRight.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
            this.Mouth = new ModelRenderer(this, 10, 25);
            this.Mouth.setPos(0.0F, 2.1F, 0.2F);
            this.Mouth.addBox(-1.0F, -1.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(Mouth, -0.045553093477052F, 0.0F, 0.0F);
            this.LegLeft = new ModelRenderer(this, 34, 7);
            this.LegLeft.setPos(-0.1F, 4.0F, -1.1F);
            this.LegLeft.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(LegLeft, 0.4553564018453205F, 0.0F, 0.0F);
            this.FootLeft = new ModelRenderer(this, 34, 11);
            this.FootLeft.setPos(-0.1F, 2.0F, 2.0F);
            this.FootLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(FootLeft, -0.40980330836826856F, 0.0F, 0.0F);
            this.ArmLeft = new ModelRenderer(this, 24, 15);
            this.ArmLeft.setPos(1.7F, 1.3F, -0.5F);
            this.ArmLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.ThighLeft = new ModelRenderer(this, 34, 0);
            this.ThighLeft.setPos(1.7F, 1.5F, 2.7F);
            this.ThighLeft.addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3, 0.0F);
            this.ThighRight = new ModelRenderer(this, 44, 0);
            this.ThighRight.mirror = true;
            this.ThighRight.setPos(-1.7F, 1.5F, 2.7F);
            this.ThighRight.addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3, 0.0F);
            this.HandRight = new ModelRenderer(this, 32, 20);
            this.HandRight.mirror = true;
            this.HandRight.setPos(0.1F, 3.5F, 0.6F);
            this.HandRight.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(HandRight, -0.091106186954104F, 0.0F, 0.0F);
            this.Body = new ModelRenderer(this, 18, 0);
            this.Body.setPos(0.0F, -2.5F, 2.0F);
            this.Body.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 4, 0.0F);
            this.Snout = new ModelRenderer(this, 0, 25);
            this.Snout.setPos(0.0F, 0.4F, -1.3F);
            this.Snout.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 2, 0.0F);
            this.Tail = new ModelRenderer(this, 27, 24);
            this.Tail.setPos(0.0F, 0.4F, 4.0F);
            this.Tail.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 4, 0.0F);
            this.setRotateAngle(Tail, -1.0471975511965976F, 0.0F, 0.0F);
            this.LegRight.addChild(this.FootRight);
            this.Chest.addChild(this.Neck);
            this.ThighRight.addChild(this.LegRight);
            this.Snout.addChild(this.TopSnout);
            this.Head.addChild(this.EarLeft);
            this.Head.addChild(this.EarRight);
            this.Neck.addChild(this.Head);
            this.ArmLeft.addChild(this.HandLeft);
            this.Chest.addChild(this.ArmRight);
            this.Snout.addChild(this.Mouth);
            this.ThighLeft.addChild(this.LegLeft);
            this.LegLeft.addChild(this.FootLeft);
            this.Chest.addChild(this.ArmLeft);
            this.Body.addChild(this.ThighLeft);
            this.Body.addChild(this.ThighRight);
            this.ArmRight.addChild(this.HandRight);
            this.Chest.addChild(this.Body);
            this.Head.addChild(this.Snout);
            this.Body.addChild(this.Tail);
        }

        @Override
        public void playIdleAnimation(WDWolfEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }

        @Override
        public void playMovementAnimation(WDWolfEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.ArmLeft.xRot = MathHelper.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 3.0F) * limbSwingAmount * 0.5F;
            this.ArmRight.xRot = MathHelper.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F;
            this.ThighLeft.xRot = MathHelper.cos(1.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + -0.05F;
            this.LegLeft.xRot = MathHelper.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * -1.5F) * limbSwingAmount * 0.5F + 0.6F;
            this.ThighRight.xRot = MathHelper.cos(1.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + -0.05F;
            this.LegRight.xRot = MathHelper.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 1.5F) * limbSwingAmount * 0.5F + 0.6F;
            this.Neck.xRot = MathHelper.cos(4.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + 0.8F;
            this.Head.xRot = MathHelper.cos(2.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.6F;
            this.Chest.xRot = MathHelper.cos(3.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.07F) * limbSwingAmount * 0.5F + -0.03F;
            this.Body.xRot = MathHelper.cos(2.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.025F;
//            this.Chest.y = MathHelper.cos(4.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.03F) * limbSwingAmount * 0.5F;
            this.Tail.zRot = MathHelper.cos(2.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F;
        }

        @Override
        public void prepareMobModel(WDWolfEntity entity, float speed, float walkSpeed, float partialTick) {
            if (entity.isInSittingPose()) {
                this.ArmLeft.setPos(1.3F, 1.2F, 0.2F);
                this.ArmRight.setPos(-1.3F, 1.2F, 0.2F);
                this.Neck.setPos(0.0F, -0.8F, -1.5F);
                this.setRotateAngle(ArmLeft, 0.7740535232594852F, 0.0F, 0.0F);
                this.setRotateAngle(ArmRight, 0.7740535232594852F, 0.0F, 0.0F);
                this.setRotateAngle(Body, -0.31869712141416456F, 0.0F, 0.0F);
                this.setRotateAngle(Chest, -0.7285004297824331F, 0.0F, 0.0F);
                this.setRotateAngle(Head, -0.4553564018453205F, 0.0F, 0.0F);
                this.setRotateAngle(Neck, 1.2292353921796064F, 0.0F, 0.0F);
                this.setRotateAngle(Tail, 1.0016444577195458F, 0.40980330836826856F, 0.5918411493512771F);
                this.setRotateAngle(ThighLeft, -0.5462880558742251F, -0.36425021489121656F, 0.0F);
                this.setRotateAngle(ThighRight, -0.5462880558742251F, 0.36425021489121656F, 0.0F);
                this.Tail.setPos(-0.3F, 1.0F, 3.2F);
                this.ThighLeft.setPos(1.7F, 1.3F, 4.4F);
                this.ThighRight.setPos(-1.7F, 1.3F, 4.4F);

            } else {
                this.ArmLeft.setPos(1.7F, 1.3F, -0.5F);
                this.ArmRight.setPos(-1.7F, 1.3F, -0.5F);
                this.Neck.setPos(0.0F, -1.1F, -1.1F);
                this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
                this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
                this.setRotateAngle(Body, 0.0F, 0.0F, 0.0F);
                this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
                this.setRotateAngle(Head, -0.6373942428283291F, 0.0F, 0.0F);
                this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
                this.setRotateAngle(Tail, -1.0471975511965976F, 0.0F, 0.0F);
                this.setRotateAngle(ThighLeft, 0.0F, 0.0F, 0.0F);
                this.setRotateAngle(ThighRight, 0.0F, 0.0F, 0.0F);
                this.Tail.setPos(0.0F, 0.4F, 4.0F);
                this.ThighLeft.setPos(1.7F, 1.5F, 2.7F);
                this.ThighRight.setPos(-1.7F, 1.5F, 2.7F);
            }
        }
    }
}
