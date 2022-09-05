package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.entity.PitBullEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;

public abstract class PitBullModel extends WorkDogModel<PitBullEntity> {
    public ModelRenderer Chest;
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer ThighLeft;
    public ModelRenderer ThighRight;
    public ModelRenderer LegLeft;
    public ModelRenderer FootLeft;
    public ModelRenderer LegRight;
    public ModelRenderer FootRight;
    public ModelRenderer Head;
    public ModelRenderer EarLeft;
    public ModelRenderer Snout;
    public ModelRenderer EarRight;
    public ModelRenderer EarFlapLeft;
    public ModelRenderer TopSnout;
    public ModelRenderer Mouth;
    public ModelRenderer EarFlapRight;
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

    public static class Adult extends PitBullModel {
        public ModelRenderer ArmBaseLeft;
        public ModelRenderer ArmBaseRight;
        public ModelRenderer Hips;
        public ModelRenderer Saddlebag;
        public ModelRenderer shape42;
        public ModelRenderer Tail1;
        public ModelRenderer Tail2;
        public ModelRenderer LowerLegLeft;
        public ModelRenderer LowerLegRight;
        public ModelRenderer SaddlebagLatchL;
        public ModelRenderer SaddlebagLatchR;
        public ModelRenderer NeckLower;
        public ModelRenderer Collar;
        public ModelRenderer Muzzle;
        public ModelRenderer Tongue;
        public ModelRenderer ForearmLeft;
        public ModelRenderer ForearmRight;
        
        public Adult() {
            this.texWidth = 64;
            this.texHeight = 128;
            this.Hips = new ModelRenderer(this, 0, 32);
            this.Hips.setPos(0.0F, 0.0F, 9.0F);
            this.Hips.addBox(-4.0F, 0.0F, 0.0F, 8, 8, 4, 0.0F);
            this.setRotateAngle(Hips, -0.18203784098300857F, 0.0F, 0.0F);
            this.ArmLeft = new ModelRenderer(this, 33, 9);
            this.ArmLeft.setPos(0.0F, 5.0F, 1.5F);
            this.ArmLeft.addBox(-1.5F, 0.0F, -3.0F, 3, 3, 3, 0.0F);
            this.setRotateAngle(ArmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.EarFlapRight = new ModelRenderer(this, 28, 58);
            this.EarFlapRight.mirror = true;
            this.EarFlapRight.setPos(0.0F, -2.0F, 0.5F);
            this.EarFlapRight.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.LegRight = new ModelRenderer(this, 50, 38);
            this.LegRight.mirror = true;
            this.LegRight.setPos(0.0F, 6.0F, -2.0F);
            this.LegRight.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
            this.setRotateAngle(LegRight, 0.27314402793711257F, 0.0F, 0.0F);
            this.ForearmRight = new ModelRenderer(this, 45, 15);
            this.ForearmRight.mirror = true;
            this.ForearmRight.setPos(-0.01F, 2.6F, -3.0F);
            this.ForearmRight.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
            this.setRotateAngle(ForearmRight, -0.091106186954104F, 0.0F, 0.0F);
            this.Mouth = new ModelRenderer(this, 0, 80);
            this.Mouth.setPos(0.0F, 2.6F, -1.5F);
            this.Mouth.addBox(-1.5F, 0.0F, -2.4F, 3, 1, 3, 0.0F);
            this.setRotateAngle(Mouth, -0.136659280431156F, 0.0F, 0.0F);
            this.ArmBaseRight = new ModelRenderer(this, 46, 0);
            this.ArmBaseRight.mirror = true;
            this.ArmBaseRight.setPos(-2.3F, 1.2F, -0.7F);
            this.ArmBaseRight.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.22759093446006054F, 0.0F, 0.0F);
            this.FootLeft = new ModelRenderer(this, 36, 52);
            this.FootLeft.setPos(-0.1F, 4.0F, -0.7F);
            this.FootLeft.addBox(-1.5F, -1.0F, -3.2F, 3, 2, 3, 0.0F);
            this.setRotateAngle(FootLeft, 0.045553093477052F, 0.0F, 0.0F);
            this.Tongue = new ModelRenderer(this, 8, 74);
            this.Tongue.setPos(0.0F, 0.0F, 0.8F);
            this.Tongue.addBox(-1.0F, 0.0F, -3.0F, 2, 0, 3, 0.0F);
            this.setRotateAngle(Tongue, -0.045553093477052F, 0.0F, 0.0F);
            this.Muzzle = new ModelRenderer(this, 38, 57);
            this.Muzzle.setPos(0.0F, -0.8F, -5.1F);
            this.Muzzle.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 4, 0.0F);
            this.LowerLegRight = new ModelRenderer(this, 48, 45);
            this.LowerLegRight.mirror = true;
            this.LowerLegRight.setPos(0.03F, 2.9F, 3.4F);
            this.LowerLegRight.addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
            this.setRotateAngle(LowerLegRight, -0.36425021489121656F, 0.0F, 0.0F);
            this.ArmBaseLeft = new ModelRenderer(this, 30, 0);
            this.ArmBaseLeft.setPos(2.4F, 1.2F, -0.7F);
            this.ArmBaseLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
            this.setRotateAngle(ArmBaseLeft, 0.22759093446006054F, 0.0F, 0.0F);
            this.Saddlebag = new ModelRenderer(this, 24, 66);
            this.Saddlebag.setPos(0.0F, -0.7F, 7.9F);
            this.Saddlebag.addBox(-4.5F, 0.0F, -3.0F, 9, 5, 6, 0.0F);
            this.Tail2 = new ModelRenderer(this, 0, 91);
            this.Tail2.setPos(0.0F, 1.5F, 5.0F);
            this.Tail2.addBox(-1.0F, -2.5F, 0.0F, 2, 2, 5, 0.0F);
            this.setRotateAngle(Tail2, 0.18203784098300857F, 0.0F, 0.0F);
            this.Collar = new ModelRenderer(this, 26, 77);
            this.Collar.setPos(0.0F, -1.3F, -1.3F);
            this.Collar.addBox(-3.0F, 0.0F, -3.0F, 6, 1, 7, 0.0F);
            this.setRotateAngle(Collar, 0.18203784098300857F, 0.0F, 0.0F);
            this.ThighLeft = new ModelRenderer(this, 28, 27);
            this.ThighLeft.setPos(2.9F, 2.9F, 0.9F);
            this.ThighLeft.addBox(-2.0F, 0.0F, -2.5F, 4, 6, 5, 0.0F);
            this.setRotateAngle(ThighLeft, 0.31869712141416456F, 0.0F, 0.0F);
            this.Head = new ModelRenderer(this, 0, 56);
            this.Head.setPos(0.0F, -3.5F, -0.6F);
            this.Head.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 5, 0.0F);
            this.setRotateAngle(Head, -0.5462880558742251F, 0.0F, 0.0F);
            this.Tail1 = new ModelRenderer(this, 0, 84);
            this.Tail1.setPos(0.0F, 1.5F, 3.0F);
            this.Tail1.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F);
            this.setRotateAngle(Tail1, -0.9560913642424937F, 0.0F, 0.0F);
            this.HandLeft = new ModelRenderer(this, 33, 20);
            this.HandLeft.setPos(0.1F, 1.9F, 2.6F);
            this.HandLeft.addBox(-1.5F, -0.7F, -3.4F, 3, 2, 3, 0.0F);
            this.LegLeft = new ModelRenderer(this, 36, 38);
            this.LegLeft.setPos(0.0F, 6.0F, -2.0F);
            this.LegLeft.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
            this.setRotateAngle(LegLeft, 0.27314402793711257F, 0.0F, 0.0F);
            this.LowerLegLeft = new ModelRenderer(this, 36, 45);
            this.LowerLegLeft.setPos(-0.03F, 2.9F, 3.4F);
            this.LowerLegLeft.addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
            this.setRotateAngle(LowerLegLeft, -0.36425021489121656F, 0.0F, 0.0F);
            this.Chest = new ModelRenderer(this, 0, 0);
            this.Chest.setPos(0.0F, 12.1F, -4.7F);
            this.Chest.addBox(-4.0F, -4.5F, -3.0F, 8, 9, 6, 0.0F);
            this.setRotateAngle(Chest, -0.091106186954104F, 0.0F, 0.0F);
            this.SaddlebagLatchL = new ModelRenderer(this, 38, 58);
            this.SaddlebagLatchL.setPos(4.0F, 0.5F, 0.0F);
            this.SaddlebagLatchL.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
            this.EarLeft = new ModelRenderer(this, 20, 54);
            this.EarLeft.setPos(2.1F, -2.1F, 0.4F);
            this.EarLeft.addBox(-1.0F, -1.5F, -0.5F, 2, 3, 1, 0.0F);
            this.setRotateAngle(EarLeft, 0.0F, -0.18203784098300857F, 0.18203784098300857F);
            this.ForearmLeft = new ModelRenderer(this, 33, 15);
            this.ForearmLeft.setPos(-0.01F, 2.6F, -3.0F);
            this.ForearmLeft.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
            this.setRotateAngle(ForearmLeft, -0.091106186954104F, 0.0F, 0.0F);
            this.NeckLower = new ModelRenderer(this, 20, 42);
            this.NeckLower.setPos(0.0F, -3.4F, -2.4F);
            this.NeckLower.addBox(-2.0F, 0.0F, -1.0F, 4, 8, 4, 0.0F);
            this.setRotateAngle(NeckLower, -0.136659280431156F, 0.0F, 0.0F);
            this.ArmRight = new ModelRenderer(this, 45, 9);
            this.ArmRight.mirror = true;
            this.ArmRight.setPos(0.0F, 5.0F, 1.5F);
            this.ArmRight.addBox(-1.5F, 0.0F, -3.0F, 3, 3, 3, 0.0F);
            this.setRotateAngle(ArmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.SaddlebagLatchR = new ModelRenderer(this, 38, 58);
            this.SaddlebagLatchR.mirror = true;
            this.SaddlebagLatchR.setPos(-4.0F, 0.5F, 0.0F);
            this.SaddlebagLatchR.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
            this.EarFlapLeft = new ModelRenderer(this, 26, 55);
            this.EarFlapLeft.setPos(0.0F, -2.0F, 0.5F);
            this.EarFlapLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.TopSnout = new ModelRenderer(this, 0, 74);
            this.TopSnout.setPos(0.0F, -0.1F, -4.7F);
            this.TopSnout.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 4, 0.0F);
            this.setRotateAngle(TopSnout, 0.18203784098300857F, 0.0F, 0.0F);
            this.HandRight = new ModelRenderer(this, 45, 20);
            this.HandRight.mirror = true;
            this.HandRight.setPos(-0.1F, 1.9F, 2.6F);
            this.HandRight.addBox(-1.5F, -0.7F, -3.4F, 3, 2, 3, 0.0F);
            this.EarRight = new ModelRenderer(this, 22, 58);
            this.EarRight.mirror = true;
            this.EarRight.setPos(-2.1F, -2.1F, 0.4F);
            this.EarRight.addBox(-1.0F, -1.5F, -0.5F, 2, 3, 1, 0.0F);
            this.setRotateAngle(EarRight, 0.0F, 0.18203784098300857F, -0.18203784098300857F);
            this.Neck = new ModelRenderer(this, 0, 44);
            this.Neck.setPos(0.0F, -2.2F, -1.3F);
            this.Neck.addBox(-2.5F, -5.0F, -2.5F, 5, 7, 5, 0.0F);
            this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
            this.shape42 = new ModelRenderer(this, 44, 67);
            this.shape42.setPos(0.0F, -2.6F, 2.0F);
            this.shape42.addBox(-3.0F, 0.0F, 0.0F, 6, 3, 2, 0.0F);
            this.setRotateAngle(shape42, -0.36425021489121656F, 0.0F, 0.0F);
            this.Snout = new ModelRenderer(this, 0, 68);
            this.Snout.setPos(0.0F, -0.7F, -1.4F);
            this.Snout.addBox(-2.0F, 0.0F, -4.4F, 4, 3, 3, 0.0F);
            this.Body = new ModelRenderer(this, 0, 15);
            this.Body.setPos(0.0F, -4.4F, 1.5F);
            this.Body.addBox(-3.5F, 0.0F, 1.0F, 7, 9, 8, 0.0F);
            this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
            this.ThighRight = new ModelRenderer(this, 46, 27);
            this.ThighRight.mirror = true;
            this.ThighRight.setPos(-2.9F, 2.9F, 0.9F);
            this.ThighRight.addBox(-2.0F, 0.0F, -2.5F, 4, 6, 5, 0.0F);
            this.setRotateAngle(ThighRight, 0.27314402793711257F, 0.0F, 0.0F);
            this.FootRight = new ModelRenderer(this, 48, 52);
            this.FootRight.mirror = true;
            this.FootRight.setPos(0.1F, 4.0F, -0.7F);
            this.FootRight.addBox(-1.5F, -1.0F, -3.2F, 3, 2, 3, 0.0F);
            this.setRotateAngle(FootRight, 0.045553093477052F, 0.0F, 0.0F);
            this.Body.addChild(this.Hips);
            this.ArmBaseLeft.addChild(this.ArmLeft);
            this.EarRight.addChild(this.EarFlapRight);
            this.ThighRight.addChild(this.LegRight);
            this.ArmRight.addChild(this.ForearmRight);
            this.Snout.addChild(this.Mouth);
            this.Chest.addChild(this.ArmBaseRight);
            this.LowerLegLeft.addChild(this.FootLeft);
            this.Mouth.addChild(this.Tongue);
            this.Snout.addChild(this.Muzzle);
            this.LegRight.addChild(this.LowerLegRight);
            this.Chest.addChild(this.ArmBaseLeft);
            this.Body.addChild(this.Saddlebag);
            this.Tail1.addChild(this.Tail2);
            this.Neck.addChild(this.Collar);
            this.Hips.addChild(this.ThighLeft);
            this.Neck.addChild(this.Head);
            this.Hips.addChild(this.Tail1);
            this.ForearmLeft.addChild(this.HandLeft);
            this.ThighLeft.addChild(this.LegLeft);
            this.LegLeft.addChild(this.LowerLegLeft);
            this.Saddlebag.addChild(this.SaddlebagLatchL);
            this.Head.addChild(this.EarLeft);
            this.ArmLeft.addChild(this.ForearmLeft);
            this.Neck.addChild(this.NeckLower);
            this.ArmBaseRight.addChild(this.ArmRight);
            this.Saddlebag.addChild(this.SaddlebagLatchR);
            this.EarLeft.addChild(this.EarFlapLeft);
            this.Snout.addChild(this.TopSnout);
            this.ForearmRight.addChild(this.HandRight);
            this.Head.addChild(this.EarRight);
            this.Chest.addChild(this.Neck);
            this.Body.addChild(this.shape42);
            this.Head.addChild(this.Snout);
            this.Chest.addChild(this.Body);
            this.Hips.addChild(this.ThighRight);
            this.LowerLegRight.addChild(this.FootRight);
        }

        @Override
        public void setupAnim(PitBullEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }

        @Override
        public void prepareMobModel(PitBullEntity entity, float speed, float walkSpeed, float partialTick) {
            if (entity.isInSittingPose()) {
                this.Body.setPos(0.0F, -3.7F, 1.9F);
                this.FootLeft.setPos(-0.1F, 2.9F, -1.0F);
                this.FootRight.setPos(0.1F, 2.9F, -1.0F);
                this.Head.setPos(0.0F, -3.8F, -0.4F);
                this.LegLeft.setPos(0.0F, 6.0F, 2.0F);
                this.LegRight.setPos(0.0F, 6.0F, 2.0F);
                this.LowerLegLeft.setPos(0.17F, 3.9F, 2.4F);
                this.LowerLegRight.setPos(0.03F, 3.9F, 2.4F);
                this.setRotateAngle(ArmBaseLeft, 0.4553564018453205F, 0.0F, 0.0F);
                this.setRotateAngle(ArmBaseRight, 0.4553564018453205F, 0.0F, 0.0F);
                this.setRotateAngle(Body, -0.40980330836826856F, 0.0F, 0.0F);
                this.setRotateAngle(Chest, -0.31869712141416456F, 0.0F, 0.0F);
                this.setRotateAngle(FootLeft, 1.730144887501979F, 0.0F, 0.0F);
                this.setRotateAngle(FootRight, 1.730144887501979F, 0.0F, 0.0F);
                this.setRotateAngle(Head, -0.4553564018453205F, 0.0F, 0.0F);
                this.setRotateAngle(LegLeft, 2.1855012893472994F, 0.0F, 0.0F);
                this.setRotateAngle(LegRight, 2.1855012893472994F, 0.0F, 0.0F);
                this.setRotateAngle(LowerLegLeft, -1.8668041679331349F, 0.0F, 0.0F);
                this.setRotateAngle(LowerLegRight, -1.8668041679331349F, 0.0F, 0.0F);
                this.setRotateAngle(Neck, 0.8651597102135892F, 0.0F, 0.0F);
                this.setRotateAngle(Tail1, -0.136659280431156F, 0.36425021489121656F, 0.0F);
                this.setRotateAngle(Tail2, 0.36425021489121656F, 0.8651597102135892F, 0.0F);
                this.setRotateAngle(ThighLeft, -1.0927506446736497F, -0.18203784098300857F, 0.0F);
                this.setRotateAngle(ThighRight, -1.0927506446736497F, 0.18203784098300857F, 0.0F);
                this.Tail1.setPos(-0.1F, 1.4F, 3.0F);
                this.ThighLeft.setPos(2.9F, 2.9F, 5.9F);
                this.ThighRight.setPos(-2.9F, 2.9F, 5.9F);

            } else {
                this.Body.setPos(0.0F, -4.4F, 1.5F);
                this.FootLeft.setPos(-0.1F, 4.0F, -0.7F);
                this.FootRight.setPos(0.1F, 4.0F, -0.7F);
                this.Head.setPos(0.0F, -3.5F, -0.6F);
                this.LegLeft.setPos(0.0F, 6.0F, -2.0F);
                this.LegRight.setPos(0.0F, 6.0F, -2.0F);
                this.LowerLegLeft.setPos(-0.03F, 2.9F, 3.4F);
                this.LowerLegRight.setPos(0.03F, 2.9F, 3.4F);
                this.setRotateAngle(ArmBaseLeft, 0.22759093446006054F, 0.0F, 0.0F);
                this.setRotateAngle(ArmBaseRight, 0.22759093446006054F, 0.0F, 0.0F);
                this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
                this.setRotateAngle(Chest, -0.091106186954104F, 0.0F, 0.0F);
                this.setRotateAngle(FootLeft, 0.045553093477052F, 0.0F, 0.0F);
                this.setRotateAngle(FootRight, 0.045553093477052F, 0.0F, 0.0F);
                this.setRotateAngle(Head, -0.5462880558742251F, 0.0F, 0.0F);
                this.setRotateAngle(LegLeft, 0.27314402793711257F, 0.0F, 0.0F);
                this.setRotateAngle(LegRight, 0.27314402793711257F, 0.0F, 0.0F);
                this.setRotateAngle(LowerLegLeft, -0.36425021489121656F, 0.0F, 0.0F);
                this.setRotateAngle(LowerLegRight, -0.36425021489121656F, 0.0F, 0.0F);
                this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
                this.setRotateAngle(Tail1, -0.9560913642424937F, 0.0F, 0.0F);
                this.setRotateAngle(Tail2, 0.18203784098300857F, 0.0F, 0.0F);
                this.setRotateAngle(ThighLeft, 0.31869712141416456F, 0.0F, 0.0F);
                this.setRotateAngle(ThighRight, 0.27314402793711257F, 0.0F, 0.0F);
                this.Tail1.setPos(0.0F, 1.5F, 3.0F);
                this.ThighLeft.setPos(2.9F, 2.9F, 0.9F);
                this.ThighRight.setPos(-2.9F, 2.9F, 0.9F);
            }
        }
    }

    public static class Baby extends PitBullModel {
        public ModelRenderer Tail;

        public Baby() {
            this.texWidth = 64;
            this.texHeight = 32;
            this.HandLeft = new ModelRenderer(this, 24, 20);
            this.HandLeft.setPos(-0.1F, 3.5F, 0.6F);
            this.HandLeft.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(HandLeft, -0.091106186954104F, 0.0F, 0.0F);
            this.FootLeft = new ModelRenderer(this, 34, 11);
            this.FootLeft.setPos(-0.1F, 2.0F, 2.0F);
            this.FootLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(FootLeft, -0.40980330836826856F, 0.0F, 0.0F);
            this.FootRight = new ModelRenderer(this, 45, 11);
            this.FootRight.mirror = true;
            this.FootRight.setPos(0.1F, 2.0F, 2.0F);
            this.FootRight.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(FootRight, -0.40980330836826856F, 0.0F, 0.0F);
            this.HandRight = new ModelRenderer(this, 32, 20);
            this.HandRight.mirror = true;
            this.HandRight.setPos(0.1F, 3.5F, 0.6F);
            this.HandRight.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(HandRight, -0.091106186954104F, 0.0F, 0.0F);
            this.Body = new ModelRenderer(this, 18, 0);
            this.Body.setPos(0.0F, -2.5F, 2.0F);
            this.Body.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 4, 0.0F);
            this.ThighRight = new ModelRenderer(this, 44, 0);
            this.ThighRight.mirror = true;
            this.ThighRight.setPos(-1.7F, 0.9F, 2.7F);
            this.ThighRight.addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3, 0.0F);
            this.EarRight = new ModelRenderer(this, 14, 12);
            this.EarRight.mirror = true;
            this.EarRight.setPos(-1.1F, -0.6F, 0.4F);
            this.EarRight.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
            this.setRotateAngle(EarRight, 0.136659280431156F, 0.091106186954104F, -0.31869712141416456F);
            this.Neck = new ModelRenderer(this, 0, 9);
            this.Neck.setPos(0.0F, -1.3F, -0.7F);
            this.Neck.addBox(-1.5F, -2.7F, -2.1F, 3, 4, 4, 0.0F);
            this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
            this.TopSnout = new ModelRenderer(this, 8, 28);
            this.TopSnout.setPos(0.0F, -0.4F, -0.1F);
            this.TopSnout.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(TopSnout, 0.091106186954104F, 0.0F, 0.0F);
            this.ThighLeft = new ModelRenderer(this, 34, 0);
            this.ThighLeft.setPos(1.7F, 0.9F, 2.7F);
            this.ThighLeft.addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3, 0.0F);
            this.EarFlapRight = new ModelRenderer(this, 20, 12);
            this.EarFlapRight.mirror = true;
            this.EarFlapRight.setPos(0.0F, -2.0F, 1.0F);
            this.EarFlapRight.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(EarFlapRight, -0.091106186954104F, 0.0F, 0.0F);
            this.LegLeft = new ModelRenderer(this, 34, 7);
            this.LegLeft.setPos(-0.1F, 4.0F, -1.1F);
            this.LegLeft.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(LegLeft, 0.4553564018453205F, 0.0F, 0.0F);
            this.Mouth = new ModelRenderer(this, 10, 25);
            this.Mouth.setPos(0.0F, 2.1F, 0.2F);
            this.Mouth.addBox(-1.0F, -1.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(Mouth, -0.045553093477052F, 0.0F, 0.0F);
            this.Tail = new ModelRenderer(this, 28, 25);
            this.Tail.setPos(0.0F, 0.4F, 4.0F);
            this.Tail.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
            this.setRotateAngle(Tail, -0.7285004297824331F, 0.0F, 0.0F);
            this.LegRight = new ModelRenderer(this, 45, 7);
            this.LegRight.mirror = true;
            this.LegRight.setPos(0.1F, 4.0F, -1.1F);
            this.LegRight.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(LegRight, 0.4553564018453205F, 0.0F, 0.0F);
            this.ArmRight = new ModelRenderer(this, 32, 15);
            this.ArmRight.mirror = true;
            this.ArmRight.setPos(-1.7F, 0.7F, -0.5F);
            this.ArmRight.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
            this.Snout = new ModelRenderer(this, 0, 25);
            this.Snout.setPos(0.0F, 0.2F, -1.3F);
            this.Snout.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 2, 0.0F);
            this.setRotateAngle(Snout, 0.27314402793711257F, 0.0F, 0.0F);
            this.EarLeft = new ModelRenderer(this, 10, 9);
            this.EarLeft.setPos(1.0F, -0.6F, 0.4F);
            this.EarLeft.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
            this.setRotateAngle(EarLeft, 0.136659280431156F, -0.091106186954104F, 0.31869712141416456F);
            this.EarFlapLeft = new ModelRenderer(this, 16, 9);
            this.EarFlapLeft.setPos(0.0F, -2.0F, 1.0F);
            this.EarFlapLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(EarFlapLeft, -0.091106186954104F, 0.0F, 0.0F);
            this.ArmLeft = new ModelRenderer(this, 24, 15);
            this.ArmLeft.setPos(1.7F, 0.7F, -0.5F);
            this.ArmLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.Chest = new ModelRenderer(this, 0, 0);
            this.Chest.setPos(0.0F, 19.5F, -2.0F);
            this.Chest.addBox(-2.5F, -2.5F, -2.0F, 5, 5, 4, 0.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.Head = new ModelRenderer(this, 0, 17);
            this.Head.setPos(0.0F, -2.1F, -0.2F);
            this.Head.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
            this.setRotateAngle(Head, -0.6373942428283291F, 0.0F, 0.0F);
            this.ArmLeft.addChild(this.HandLeft);
            this.LegLeft.addChild(this.FootLeft);
            this.LegRight.addChild(this.FootRight);
            this.ArmRight.addChild(this.HandRight);
            this.Chest.addChild(this.Body);
            this.Body.addChild(this.ThighRight);
            this.Head.addChild(this.EarRight);
            this.Chest.addChild(this.Neck);
            this.Snout.addChild(this.TopSnout);
            this.Body.addChild(this.ThighLeft);
            this.EarRight.addChild(this.EarFlapRight);
            this.ThighLeft.addChild(this.LegLeft);
            this.Snout.addChild(this.Mouth);
            this.Body.addChild(this.Tail);
            this.ThighRight.addChild(this.LegRight);
            this.Chest.addChild(this.ArmRight);
            this.Head.addChild(this.Snout);
            this.Head.addChild(this.EarLeft);
            this.EarLeft.addChild(this.EarFlapLeft);
            this.Chest.addChild(this.ArmLeft);
            this.Neck.addChild(this.Head);
        }

        @Override
        public void setupAnim(PitBullEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }

        @Override
        public void prepareMobModel(PitBullEntity entity, float speed, float walkSpeed, float partialTick) {
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
                this.ArmLeft.setPos(1.7F, 0.7F, -0.5F);
                this.ArmRight.setPos(-1.7F, 0.7F, -0.5F);
                this.Neck.setPos(0.0F, -1.3F, -0.7F);
                this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
                this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
                this.setRotateAngle(Body, 0.0F, 0.0F, 0.0F);
                this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
                this.setRotateAngle(Head, -0.6373942428283291F, 0.0F, 0.0F);
                this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
                this.setRotateAngle(Tail, -0.7285004297824331F, 0.0F, 0.0F);
                this.setRotateAngle(ThighLeft, 0.0F, 0.0F, 0.0F);
                this.setRotateAngle(ThighRight, 0.0F, 0.0F, 0.0F);
                this.Tail.setPos(0.0F, 0.4F, 4.0F);
                this.ThighLeft.setPos(1.7F, 0.9F, 2.7F);
                this.ThighRight.setPos(-1.7F, 0.9F, 2.7F);
            }
        }
    }
}
