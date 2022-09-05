package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.entity.BostonTerrierEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;

public abstract class BostonTerrierModel extends WorkDogModel<BostonTerrierEntity> {
    public ModelRenderer Chest;
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer ThighLeft;
    public ModelRenderer ThighRight;
    public ModelRenderer FootLeft;
    public ModelRenderer FootRight;
    public ModelRenderer Head;
    public ModelRenderer TopSnout;
    public ModelRenderer EarLeft;
    public ModelRenderer EarRight;
    public ModelRenderer Snout;
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

    public static class Adult extends BostonTerrierModel {
        public ModelRenderer ArmBaseLeft;
        public ModelRenderer ArmBaseRight;
        public ModelRenderer Hips;
        public ModelRenderer UpperLegLeft;
        public ModelRenderer LowerLegLeft;
        public ModelRenderer UpperLegRight;
        public ModelRenderer LowerLegRight;
        public ModelRenderer NeckLower;
        public ModelRenderer CollarLeft;
        public ModelRenderer MuzzleLeft;
        public ModelRenderer MuzzleRight;
        public ModelRenderer CollarRight;
        public ModelRenderer ForearmLeft;
        public ModelRenderer ForearmRight;
        
        public Adult() {
            this.texWidth = 64;
            this.texHeight = 64;
            this.UpperLegRight = new ModelRenderer(this, 35, 26);
            this.UpperLegRight.mirror = true;
            this.UpperLegRight.setPos(0.1F, 3.7F, -1.2F);
            this.UpperLegRight.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
            this.setRotateAngle(UpperLegRight, 0.6373942428283291F, 0.0F, 0.0F);
            this.HandLeft = new ModelRenderer(this, 22, 15);
            this.HandLeft.setPos(-0.1F, 1.3F, 1.4F);
            this.HandLeft.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.ForearmRight = new ModelRenderer(this, 34, 11);
            this.ForearmRight.mirror = true;
            this.ForearmRight.setPos(0.0F, 1.6F, -2.0F);
            this.ForearmRight.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(ForearmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.ArmLeft = new ModelRenderer(this, 22, 7);
            this.ArmLeft.setPos(0.0F, 4.0F, 1.0F);
            this.ArmLeft.addBox(-1.0F, -0.2F, -2.0F, 2, 2, 2, 0.0F);
            this.ArmRight = new ModelRenderer(this, 34, 7);
            this.ArmRight.mirror = true;
            this.ArmRight.setPos(0.0F, 4.0F, 1.0F);
            this.ArmRight.addBox(-1.0F, -0.2F, -2.0F, 2, 2, 2, 0.0F);
            this.Chest = new ModelRenderer(this, 0, 0);
            this.Chest.setPos(0.0F, 15.6F, -3.7F);
            this.Chest.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4, 0.0F);
            this.setRotateAngle(Chest, -0.1153662635568252F, 0.0F, 0.0F);
            this.ArmBaseLeft = new ModelRenderer(this, 20, 0);
            this.ArmBaseLeft.setPos(2.0F, 0.5F, 0.2F);
            this.ArmBaseLeft.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
            this.setRotateAngle(ArmBaseLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.NeckLower = new ModelRenderer(this, 16, 31);
            this.NeckLower.setPos(0.0F, -3.8F, -2.1F);
            this.NeckLower.addBox(-1.5F, 0.0F, 0.0F, 3, 6, 2, 0.0F);
            this.setRotateAngle(NeckLower, -0.045553093477052F, 0.0F, 0.0F);
            this.ForearmLeft = new ModelRenderer(this, 22, 11);
            this.ForearmLeft.setPos(0.0F, 1.6F, -2.0F);
            this.ForearmLeft.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(ForearmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.MuzzleLeft = new ModelRenderer(this, 23, 48);
            this.MuzzleLeft.setPos(0.0F, 0.1F, -5.4F);
            this.MuzzleLeft.addBox(-1.9F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
            this.setRotateAngle(MuzzleLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.TopSnout = new ModelRenderer(this, 0, 55);
            this.TopSnout.setPos(0.0F, 0.0F, -0.4F);
            this.TopSnout.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(TopSnout, 0.31869712141416456F, 0.0F, 0.0F);
            this.Body = new ModelRenderer(this, 0, 10);
            this.Body.setPos(0.0F, -3.0F, 1.7F);
            this.Body.addBox(-2.5F, 0.0F, 0.0F, 5, 6, 5, 0.0F);
            this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
            this.ThighRight = new ModelRenderer(this, 33, 19);
            this.ThighRight.mirror = true;
            this.ThighRight.setPos(-2.1F, 2.5F, 1.6F);
            this.ThighRight.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
            this.setRotateAngle(ThighRight, 0.136659280431156F, 0.0F, 0.0F);
            this.UpperLegLeft = new ModelRenderer(this, 25, 26);
            this.UpperLegLeft.setPos(-0.1F, 3.7F, -1.2F);
            this.UpperLegLeft.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
            this.setRotateAngle(UpperLegLeft, 0.6373942428283291F, 0.0F, 0.0F);
            this.Head = new ModelRenderer(this, 0, 39);
            this.Head.setPos(0.0F, -3.3F, -0.6F);
            this.Head.addBox(-2.5F, -2.5F, -2.5F, 5, 6, 5, 0.0F);
            this.setRotateAngle(Head, -0.40980330836826856F, 0.0F, 0.0F);
            this.Snout = new ModelRenderer(this, 0, 50);
            this.Snout.setPos(0.0F, 0.1F, -3.5F);
            this.Snout.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 2, 0.0F);
            this.setRotateAngle(Snout, -0.136659280431156F, 0.0F, 0.0F);
            this.MuzzleRight = new ModelRenderer(this, 23, 48);
            this.MuzzleRight.setPos(0.0F, 0.0F, 0.0F);
            this.MuzzleRight.addBox(-2.1F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
            this.EarLeft = new ModelRenderer(this, 20, 43);
            this.EarLeft.setPos(1.2F, -2.4F, 1.4F);
            this.EarLeft.addBox(-1.0F, -2.5F, -0.5F, 3, 4, 1, 0.0F);
            this.setRotateAngle(EarLeft, 0.136659280431156F, 0.0F, 0.22759093446006054F);
            this.LowerLegLeft = new ModelRenderer(this, 27, 31);
            this.LowerLegLeft.setPos(0.0F, 3.0F, 2.0F);
            this.LowerLegLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(LowerLegLeft, -0.5918411493512771F, 0.0F, 0.0F);
            this.Mouth = new ModelRenderer(this, 12, 50);
            this.Mouth.setPos(0.0F, 2.4F, 2.3F);
            this.Mouth.addBox(-1.5F, 0.0F, -2.0F, 3, 1, 2, 0.0F);
            this.setRotateAngle(Mouth, -0.136659280431156F, 0.0F, 0.0F);
            this.FootLeft = new ModelRenderer(this, 27, 36);
            this.FootLeft.setPos(-0.1F, 2.2F, -0.7F);
            this.FootLeft.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.CollarLeft = new ModelRenderer(this, 40, 50);
            this.CollarLeft.setPos(0.1F, 0.2F, -3.1F);
            this.CollarLeft.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
            this.setRotateAngle(CollarLeft, 0.18203784098300857F, 0.0F, 0.0F);
            this.FootRight = new ModelRenderer(this, 35, 36);
            this.FootRight.mirror = true;
            this.FootRight.setPos(0.1F, 2.2F, -0.7F);
            this.FootRight.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.LowerLegRight = new ModelRenderer(this, 35, 31);
            this.LowerLegRight.mirror = true;
            this.LowerLegRight.setPos(0.0F, 3.0F, 2.0F);
            this.LowerLegRight.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(LowerLegRight, -0.5918411493512771F, 0.0F, 0.0F);
            this.EarRight = new ModelRenderer(this, 28, 43);
            this.EarRight.mirror = true;
            this.EarRight.setPos(-1.2F, -2.4F, 1.4F);
            this.EarRight.addBox(-2.0F, -2.5F, -0.5F, 3, 4, 1, 0.0F);
            this.setRotateAngle(EarRight, 0.136659280431156F, 0.0F, -0.22759093446006054F);
            this.HandRight = new ModelRenderer(this, 34, 15);
            this.HandRight.mirror = true;
            this.HandRight.setPos(0.1F, 1.3F, 1.4F);
            this.HandRight.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.CollarRight = new ModelRenderer(this, 40, 50);
            this.CollarRight.setPos(-0.2F, 0.0F, 0.0F);
            this.CollarRight.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
            this.Hips = new ModelRenderer(this, 0, 21);
            this.Hips.setPos(0.0F, 0.0F, 5.0F);
            this.Hips.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 3, 0.0F);
            this.setRotateAngle(Hips, -0.091106186954104F, 0.0F, 0.0F);
            this.ThighLeft = new ModelRenderer(this, 21, 19);
            this.ThighLeft.setPos(2.1F, 2.5F, 1.6F);
            this.ThighLeft.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
            this.setRotateAngle(ThighLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.Neck = new ModelRenderer(this, 0, 30);
            this.Neck.setPos(0.0F, -1.1F, -1.5F);
            this.Neck.addBox(-2.0F, -4.0F, -2.0F, 4, 5, 4, 0.0F);
            this.setRotateAngle(Neck, 0.6829473363053812F, 0.0F, 0.0F);
            this.ArmBaseRight = new ModelRenderer(this, 32, 0);
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
        public void setupAnim(BostonTerrierEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }

        @Override
        public void prepareMobModel(BostonTerrierEntity entity, float speed, float walkSpeed, float partialTick) {
            if (entity.isInSittingPose()) {
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

            } else {
                this.ArmBaseLeft.setPos(2.0F, 0.5F, 0.2F);
                this.ArmBaseRight.setPos(-2.0F, 0.5F, 0.2F);
                this.Body.setPos(0.0F, -3.0F, 1.7F);
                this.Chest.setPos(0.0F, 15.6F, -3.7F);
                this.LowerLegLeft.setPos(0.0F, 3.0F, 2.0F);
                this.LowerLegRight.setPos(0.0F, 3.0F, 2.0F);
                this.setRotateAngle(ArmBaseLeft, 0.136659280431156F, 0.0F, 0.0F);
                this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.0F, 0.0F);
                this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
                this.setRotateAngle(Chest, -0.1153662635568252F, 0.0F, 0.0F);
                this.setRotateAngle(FootLeft, 0.0F, 0.0F, 0.0F);
                this.setRotateAngle(FootRight, 0.0F, 0.0F, 0.0F);
                this.setRotateAngle(Hips, -0.091106186954104F, 0.0F, 0.0F);
                this.setRotateAngle(LowerLegLeft, -0.5918411493512771F, 0.0F, 0.0F);
                this.setRotateAngle(LowerLegRight, -0.5918411493512771F, 0.0F, 0.0F);
                this.setRotateAngle(Neck, 0.6829473363053812F, 0.0F, 0.0F);
                this.setRotateAngle(ThighLeft, 0.136659280431156F, 0.0F, 0.0F);
                this.setRotateAngle(ThighRight, 0.136659280431156F, 0.0F, 0.0F);
                this.setRotateAngle(UpperLegLeft, 0.6373942428283291F, 0.0F, 0.0F);
                this.setRotateAngle(UpperLegRight, 0.6373942428283291F, 0.0F, 0.0F);
                this.ThighLeft.setPos(2.1F, 2.5F, 1.6F);
                this.ThighRight.setPos(-2.1F, 2.5F, 1.6F);
                this.UpperLegLeft.setPos(-0.1F, 3.7F, -1.2F);
                this.UpperLegRight.setPos(0.1F, 3.7F, -1.2F);
            }
        }
    }

    public static class Baby extends BostonTerrierModel {
        public ModelRenderer EarFlapLeft;
        public ModelRenderer EarFlapRight;
        public ModelRenderer LegLeft;
        public ModelRenderer LegRight;

        public Baby() {
            this.texWidth = 64;
            this.texHeight = 32;
            this.EarLeft = new ModelRenderer(this, 10, 9);
            this.EarLeft.setPos(1.1F, -0.7F, 0.4F);
            this.EarLeft.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
            this.setRotateAngle(EarLeft, 0.136659280431156F, -0.091106186954104F, 0.31869712141416456F);
            this.EarRight = new ModelRenderer(this, 14, 12);
            this.EarRight.mirror = true;
            this.EarRight.setPos(-1.1F, -0.7F, 0.4F);
            this.EarRight.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
            this.setRotateAngle(EarRight, 0.136659280431156F, 0.091106186954104F, -0.31869712141416456F);
            this.ThighRight = new ModelRenderer(this, 44, 0);
            this.ThighRight.mirror = true;
            this.ThighRight.setPos(-1.7F, 0.9F, 2.7F);
            this.ThighRight.addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3, 0.0F);
            this.HandLeft = new ModelRenderer(this, 24, 20);
            this.HandLeft.setPos(-0.1F, 3.5F, 0.6F);
            this.HandLeft.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(HandLeft, -0.091106186954104F, 0.0F, 0.0F);
            this.Neck = new ModelRenderer(this, 0, 9);
            this.Neck.setPos(0.0F, -1.0F, -1.0F);
            this.Neck.addBox(-1.5F, -2.7F, -2.1F, 3, 4, 4, 0.0F);
            this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
            this.TopSnout = new ModelRenderer(this, 8, 28);
            this.TopSnout.setPos(0.0F, -0.4F, -0.1F);
            this.TopSnout.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(TopSnout, 0.091106186954104F, 0.0F, 0.0F);
            this.EarFlapRight = new ModelRenderer(this, 20, 12);
            this.EarFlapRight.mirror = true;
            this.EarFlapRight.setPos(0.0F, -2.0F, 1.0F);
            this.EarFlapRight.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(EarFlapRight, -0.091106186954104F, 0.0F, 0.0F);
            this.ArmRight = new ModelRenderer(this, 32, 15);
            this.ArmRight.mirror = true;
            this.ArmRight.setPos(-1.7F, 0.7F, -0.5F);
            this.ArmRight.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
            this.Head = new ModelRenderer(this, 0, 17);
            this.Head.setPos(0.0F, -2.1F, -0.2F);
            this.Head.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
            this.setRotateAngle(Head, -0.6373942428283291F, 0.0F, 0.0F);
            this.Snout = new ModelRenderer(this, 0, 25);
            this.Snout.setPos(0.0F, 0.5F, -0.5F);
            this.Snout.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 2, 0.0F);
            this.setRotateAngle(Snout, -0.18203784098300857F, 0.0F, 0.0F);
            this.Mouth = new ModelRenderer(this, 10, 25);
            this.Mouth.setPos(0.0F, 2.1F, 0.2F);
            this.Mouth.addBox(-1.0F, -1.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(Mouth, -0.045553093477052F, 0.0F, 0.0F);
            this.HandRight = new ModelRenderer(this, 32, 20);
            this.HandRight.mirror = true;
            this.HandRight.setPos(0.1F, 3.5F, 0.6F);
            this.HandRight.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(HandRight, -0.091106186954104F, 0.0F, 0.0F);
            this.ArmLeft = new ModelRenderer(this, 24, 15);
            this.ArmLeft.setPos(1.7F, 0.7F, -0.5F);
            this.ArmLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.FootRight = new ModelRenderer(this, 45, 11);
            this.FootRight.mirror = true;
            this.FootRight.setPos(0.1F, 2.0F, 2.0F);
            this.FootRight.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(FootRight, -0.40980330836826856F, 0.0F, 0.0F);
            this.LegLeft = new ModelRenderer(this, 34, 7);
            this.LegLeft.setPos(-0.1F, 4.0F, -1.1F);
            this.LegLeft.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(LegLeft, 0.4553564018453205F, 0.0F, 0.0F);
            this.ThighLeft = new ModelRenderer(this, 34, 0);
            this.ThighLeft.setPos(1.7F, 0.9F, 2.7F);
            this.ThighLeft.addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3, 0.0F);
            this.LegRight = new ModelRenderer(this, 45, 7);
            this.LegRight.mirror = true;
            this.LegRight.setPos(0.1F, 4.0F, -1.1F);
            this.LegRight.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(LegRight, 0.4553564018453205F, 0.0F, 0.0F);
            this.Body = new ModelRenderer(this, 18, 0);
            this.Body.setPos(0.0F, -2.5F, 2.0F);
            this.Body.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 4, 0.0F);
            this.EarFlapLeft = new ModelRenderer(this, 16, 9);
            this.EarFlapLeft.setPos(0.0F, -2.0F, 1.0F);
            this.EarFlapLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(EarFlapLeft, -0.091106186954104F, 0.0F, 0.0F);
            this.FootLeft = new ModelRenderer(this, 34, 11);
            this.FootLeft.setPos(-0.1F, 2.0F, 2.0F);
            this.FootLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(FootLeft, -0.40980330836826856F, 0.0F, 0.0F);
            this.Chest = new ModelRenderer(this, 0, 0);
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
        public void setupAnim(BostonTerrierEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }

        @Override
        public void prepareMobModel(BostonTerrierEntity entity, float speed, float walkSpeed, float partialTick) {
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
                this.setRotateAngle(ThighLeft, -0.5462880558742251F, -0.36425021489121656F, 0.0F);
                this.setRotateAngle(ThighRight, -0.5462880558742251F, 0.36425021489121656F, 0.0F);
                this.ThighLeft.setPos(1.7F, 1.3F, 4.4F);
                this.ThighRight.setPos(-1.7F, 1.3F, 4.4F);

            } else {
                this.ArmLeft.setPos(1.7F, 0.7F, -0.5F);
                this.ArmRight.setPos(-1.7F, 0.7F, -0.5F);
                this.Neck.setPos(0.0F, -1.0F, -1.0F);
                this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
                this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
                this.setRotateAngle(Body, 0.0F, 0.0F, 0.0F);
                this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
                this.setRotateAngle(Head, -0.6373942428283291F, 0.0F, 0.0F);
                this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
                this.setRotateAngle(ThighLeft, 0.0F, 0.0F, 0.0F);
                this.setRotateAngle(ThighRight, 0.0F, 0.0F, 0.0F);
                this.ThighLeft.setPos(1.7F, 0.9F, 2.7F);
                this.ThighRight.setPos(-1.7F, 0.9F, 2.7F);
            }
        }
    }
}
