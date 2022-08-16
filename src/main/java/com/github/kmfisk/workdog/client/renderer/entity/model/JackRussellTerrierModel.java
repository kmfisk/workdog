package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.entity.JackRussellTerrierEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;

public abstract class JackRussellTerrierModel extends WorkDogModel<JackRussellTerrierEntity> {
    public ModelRenderer Chest;
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer ArmBaseLeft;
    public ModelRenderer ArmBaseRight;
    public ModelRenderer ChestFur;
    public ModelRenderer Hips;
    public ModelRenderer BodyFur;
    public ModelRenderer handle;
    public ModelRenderer Saddlebag;
    public ModelRenderer ThighLeft;
    public ModelRenderer ThighRight;
    public ModelRenderer Tail1;
    public ModelRenderer UpperLegLeft;
    public ModelRenderer LowerLegLeft;
    public ModelRenderer FootLeft;
    public ModelRenderer UpperLegRight;
    public ModelRenderer LowerLegRight;
    public ModelRenderer FootRight;
    public ModelRenderer Tail2;
    public ModelRenderer SaddlebagLatchL;
    public ModelRenderer SaddlebagLatchR;
    public ModelRenderer Head;
    public ModelRenderer NeckLower;
    public ModelRenderer Collar;
    public ModelRenderer Snout;
    public ModelRenderer EarLeft;
    public ModelRenderer EarRight;
    public ModelRenderer EyebrowLeft;
    public ModelRenderer EyebrowLeft_1;
    public ModelRenderer Muzzle;
    public ModelRenderer TopSnout;
    public ModelRenderer Mouth;
    public ModelRenderer MoustacheLeft;
    public ModelRenderer MoustacheRight;
    public ModelRenderer Beard;
    public ModelRenderer Tongue;
    public ModelRenderer EarFlapLeft;
    public ModelRenderer EarFlapRight;
    public ModelRenderer ArmLeft;
    public ModelRenderer ForearmLeft;
    public ModelRenderer HandLeft;
    public ModelRenderer ArmRight;
    public ModelRenderer ForearmRight;
    public ModelRenderer HandRight;
    private Iterable<ModelRenderer> parts; // todo: child

    @Override
    public Iterable<ModelRenderer> parts() {
        if (parts == null)
            parts = ImmutableList.of(Chest);

        return parts;
    }

    public static class Adult extends JackRussellTerrierModel {
        public Adult() {
            this.texWidth = 64;
            this.texHeight = 64;
            this.Body = new ModelRenderer(this, 0, 10);
            this.Body.setPos(0.0F, -3.0F, 1.7F);
            this.Body.addBox(-2.5F, 0.0F, 0.0F, 5, 6, 5, 0.0F);
            this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
            this.Tail1 = new ModelRenderer(this, 45, 0);
            this.Tail1.setPos(0.0F, 1.2F, 2.0F);
            this.Tail1.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(Tail1, 1.0016444577195458F, 0.0F, 0.0F);
            this.LowerLegLeft = new ModelRenderer(this, 28, 34);
            this.LowerLegLeft.setPos(0.0F, 3.0F, 2.5F);
            this.LowerLegLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
            this.setRotateAngle(LowerLegLeft, -0.6829473363053812F, 0.0F, 0.0F);
            this.handle = new ModelRenderer(this, 50, 24);
            this.handle.setPos(0.0F, 0.0F, 1.0F);
            this.handle.addBox(-2.5F, -2.0F, 0.0F, 5, 2, 1, 0.0F);
            this.setRotateAngle(handle, -0.22759093446006054F, 0.0F, 0.0F);
            this.ThighRight = new ModelRenderer(this, 34, 19);
            this.ThighRight.mirror = true;
            this.ThighRight.setPos(-1.9F, 1.3F, 1.1F);
            this.ThighRight.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, 0.0F);
            this.setRotateAngle(ThighRight, 0.18203784098300857F, 0.0F, 0.0F);
            this.Beard = new ModelRenderer(this, 0, 59);
            this.Beard.setPos(0.0F, 0.2F, -2.5F);
            this.Beard.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(Beard, 0.22759093446006054F, 0.0F, 0.0F);
            this.LowerLegRight = new ModelRenderer(this, 36, 34);
            this.LowerLegRight.mirror = true;
            this.LowerLegRight.setPos(0.0F, 3.0F, 2.5F);
            this.LowerLegRight.addBox(-1.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
            this.setRotateAngle(LowerLegRight, -0.6829473363053812F, 0.0F, 0.0F);
            this.EyebrowLeft_1 = new ModelRenderer(this, 8, 58);
            this.EyebrowLeft_1.setPos(-1.9F, -1.2F, -2.7F);
            this.EyebrowLeft_1.addBox(-1.5F, -1.0F, 0.0F, 3, 1, 2, 0.0F);
            this.setRotateAngle(EyebrowLeft_1, -0.045553093477052F, 0.27314402793711257F, -0.091106186954104F);
            this.Tongue = new ModelRenderer(this, 15, 58);
            this.Tongue.setPos(0.0F, -1.0F, 1.0F);
            this.Tongue.addBox(-1.0F, 0.0F, -3.0F, 2, 0, 3, 0.0F);
            this.setRotateAngle(Tongue, -0.091106186954104F, 0.0F, 0.0F);
            this.ThighLeft = new ModelRenderer(this, 20, 19);
            this.ThighLeft.setPos(1.9F, 1.3F, 1.1F);
            this.ThighLeft.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, 0.0F);
            this.setRotateAngle(ThighLeft, 0.18203784098300857F, 0.0F, 0.0F);
            this.HandRight = new ModelRenderer(this, 34, 15);
            this.HandRight.mirror = true;
            this.HandRight.setPos(0.1F, 1.8F, 1.3F);
            this.HandRight.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(HandRight, 0.091106186954104F, 0.0F, 0.0F);
            this.ArmRight = new ModelRenderer(this, 34, 6);
            this.ArmRight.mirror = true;
            this.ArmRight.setPos(0.0F, 3.0F, 1.0F);
            this.ArmRight.addBox(-1.0F, 0.0F, -2.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(ArmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.Snout = new ModelRenderer(this, 0, 49);
            this.Snout.setPos(0.0F, 0.0F, -2.0F);
            this.Snout.addBox(-1.5F, 0.0F, -2.7F, 3, 2, 3, 0.0F);
            this.HandLeft = new ModelRenderer(this, 22, 15);
            this.HandLeft.setPos(-0.1F, 1.8F, 1.3F);
            this.HandLeft.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(HandLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.EarFlapLeft = new ModelRenderer(this, 20, 43);
            this.EarFlapLeft.setPos(0.0F, -2.0F, 1.0F);
            this.EarFlapLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(EarFlapLeft, -0.36425021489121656F, 0.0F, 0.0F);
            this.TopSnout = new ModelRenderer(this, 0, 54);
            this.TopSnout.setPos(0.0F, -0.5F, -0.2F);
            this.TopSnout.addBox(-1.0F, 0.0F, -2.7F, 2, 2, 3, 0.0F);
            this.setRotateAngle(TopSnout, 0.136659280431156F, 0.0F, 0.0F);
            this.MoustacheLeft = new ModelRenderer(this, 10, 53);
            this.MoustacheLeft.setPos(0.1F, 0.8F, -3.0F);
            this.MoustacheLeft.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
            this.setRotateAngle(MoustacheLeft, 0.136659280431156F, 0.0F, -0.136659280431156F);
            this.FootRight = new ModelRenderer(this, 42, 40);
            this.FootRight.setPos(0.1F, 4.0F, -0.5F);
            this.FootRight.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.UpperLegLeft = new ModelRenderer(this, 26, 28);
            this.UpperLegLeft.setPos(-0.1F, 5.0F, -1.5F);
            this.UpperLegLeft.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
            this.setRotateAngle(UpperLegLeft, 0.6373942428283291F, 0.0F, 0.0F);
            this.EyebrowLeft = new ModelRenderer(this, 8, 58);
            this.EyebrowLeft.mirror = true;
            this.EyebrowLeft.setPos(1.9F, -1.2F, -2.7F);
            this.EyebrowLeft.addBox(-1.5F, -1.0F, 0.0F, 3, 1, 2, 0.0F);
            this.setRotateAngle(EyebrowLeft, -0.045553093477052F, -0.27314402793711257F, 0.091106186954104F);
            this.ArmBaseLeft = new ModelRenderer(this, 20, 0);
            this.ArmBaseLeft.setPos(1.7F, 1.0F, -0.1F);
            this.ArmBaseLeft.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
            this.setRotateAngle(ArmBaseLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.Chest = new ModelRenderer(this, 0, 0);
            this.Chest.setPos(0.0F, 14.7F, -3.2F);
            this.Chest.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4, 0.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.EarRight = new ModelRenderer(this, 21, 39);
            this.EarRight.mirror = true;
            this.EarRight.setPos(-1.8F, -1.6F, 0.4F);
            this.EarRight.addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1, 0.0F);
            this.setRotateAngle(EarRight, 0.31869712141416456F, 0.0F, -0.18203784098300857F);
            this.NeckLower = new ModelRenderer(this, 16, 31);
            this.NeckLower.setPos(0.0F, -3.8F, -1.8F);
            this.NeckLower.addBox(-1.5F, 0.0F, 0.0F, 3, 6, 2, 0.0F);
            this.setRotateAngle(NeckLower, -0.22759093446006054F, 0.0F, 0.0F);
            this.UpperLegRight = new ModelRenderer(this, 38, 28);
            this.UpperLegRight.mirror = true;
            this.UpperLegRight.setPos(0.1F, 5.0F, -1.5F);
            this.UpperLegRight.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
            this.setRotateAngle(UpperLegRight, 0.6373942428283291F, 0.0F, 0.0F);
            this.Saddlebag = new ModelRenderer(this, 22, 56);
            this.Saddlebag.setPos(0.0F, 1.5F, 5.0F);
            this.Saddlebag.addBox(-3.5F, -2.0F, -2.0F, 7, 4, 4, 0.0F);
            this.EarLeft = new ModelRenderer(this, 15, 39);
            this.EarLeft.setPos(1.8F, -1.6F, 0.4F);
            this.EarLeft.addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1, 0.0F);
            this.setRotateAngle(EarLeft, 0.31869712141416456F, 0.0F, 0.18203784098300857F);
            this.SaddlebagLatchR = new ModelRenderer(this, 18, 61);
            this.SaddlebagLatchR.setPos(-3.5F, -1.0F, 0.0F);
            this.SaddlebagLatchR.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
            this.ArmLeft = new ModelRenderer(this, 21, 6);
            this.ArmLeft.setPos(0.0F, 3.0F, 1.0F);
            this.ArmLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(ArmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.Neck = new ModelRenderer(this, 0, 30);
            this.Neck.setPos(0.0F, -1.0F, -0.5F);
            this.Neck.addBox(-2.0F, -4.0F, -2.0F, 4, 5, 4, 0.0F);
            this.setRotateAngle(Neck, 0.6373942428283291F, 0.0F, 0.0F);
            this.SaddlebagLatchL = new ModelRenderer(this, 18, 61);
            this.SaddlebagLatchL.setPos(3.5F, -1.0F, 0.0F);
            this.SaddlebagLatchL.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
            this.Hips = new ModelRenderer(this, 0, 21);
            this.Hips.setPos(0.0F, 0.0F, 5.0F);
            this.Hips.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 3, 0.0F);
            this.setRotateAngle(Hips, -0.136659280431156F, 0.0F, 0.0F);
            this.Tail2 = new ModelRenderer(this, 53, 0);
            this.Tail2.setPos(0.0F, 2.5F, -1.0F);
            this.Tail2.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(Tail2, 0.136659280431156F, 0.0F, 0.0F);
            this.ForearmLeft = new ModelRenderer(this, 22, 11);
            this.ForearmLeft.setPos(-0.1F, 2.6F, -2.0F);
            this.ForearmLeft.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(ForearmLeft, -0.136659280431156F, 0.0F, 0.0F);
            this.BodyFur = new ModelRenderer(this, 44, 6);
            this.BodyFur.setPos(0.0F, 5.5F, -1.0F);
            this.BodyFur.addBox(-2.0F, 0.0F, 0.0F, 4, 2, 5, 0.0F);
            this.setRotateAngle(BodyFur, 0.22759093446006054F, 0.0F, 0.0F);
            this.Head = new ModelRenderer(this, 0, 39);
            this.Head.setPos(0.0F, -3.7F, 0.0F);
            this.Head.addBox(-2.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
            this.setRotateAngle(Head, -0.5462880558742251F, 0.0F, 0.0F);
            this.MoustacheRight = new ModelRenderer(this, 10, 53);
            this.MoustacheRight.mirror = true;
            this.MoustacheRight.setPos(-0.1F, 0.8F, -3.0F);
            this.MoustacheRight.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
            this.setRotateAngle(MoustacheRight, 0.136659280431156F, 0.0F, 0.136659280431156F);
            this.Mouth = new ModelRenderer(this, 12, 49);
            this.Mouth.setPos(0.0F, 2.6F, 0.0F);
            this.Mouth.addBox(-1.0F, -1.0F, -2.4F, 2, 1, 3, 0.0F);
            this.setRotateAngle(Mouth, -0.045553093477052F, 0.0F, 0.0F);
            this.ForearmRight = new ModelRenderer(this, 34, 11);
            this.ForearmRight.mirror = true;
            this.ForearmRight.setPos(0.1F, 2.6F, -2.0F);
            this.ForearmRight.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(ForearmRight, -0.136659280431156F, 0.0F, 0.0F);
            this.FootLeft = new ModelRenderer(this, 34, 40);
            this.FootLeft.setPos(-0.1F, 4.0F, -0.5F);
            this.FootLeft.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.ArmBaseRight = new ModelRenderer(this, 32, 0);
            this.ArmBaseRight.mirror = true;
            this.ArmBaseRight.setPos(-1.7F, 1.0F, -0.1F);
            this.ArmBaseRight.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.0F, 0.0F);
            this.ChestFur = new ModelRenderer(this, 47, 13);
            this.ChestFur.setPos(0.0F, 2.4F, -1.7F);
            this.ChestFur.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
            this.setRotateAngle(ChestFur, 0.136659280431156F, 0.0F, 0.0F);
            this.Collar = new ModelRenderer(this, 40, 50);
            this.Collar.setPos(0.0F, -1.5F, -2.7F);
            this.Collar.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
            this.Muzzle = new ModelRenderer(this, 23, 48);
            this.Muzzle.setPos(0.0F, -0.6F, -5.4F);
            this.Muzzle.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
            this.setRotateAngle(Muzzle, 0.091106186954104F, 0.0F, 0.0F);
            this.EarFlapRight = new ModelRenderer(this, 28, 43);
            this.EarFlapRight.mirror = true;
            this.EarFlapRight.setPos(0.0F, -2.0F, 1.0F);
            this.EarFlapRight.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(EarFlapRight, -0.36425021489121656F, 0.0F, 0.0F);
            this.Chest.addChild(this.Body);
            this.Hips.addChild(this.Tail1);
            this.UpperLegLeft.addChild(this.LowerLegLeft);
            this.Body.addChild(this.handle);
            this.Hips.addChild(this.ThighRight);
            this.Mouth.addChild(this.Beard);
            this.UpperLegRight.addChild(this.LowerLegRight);
            this.Head.addChild(this.EyebrowLeft_1);
            this.Mouth.addChild(this.Tongue);
            this.Hips.addChild(this.ThighLeft);
            this.ForearmRight.addChild(this.HandRight);
            this.ArmBaseRight.addChild(this.ArmRight);
            this.Head.addChild(this.Snout);
            this.ForearmLeft.addChild(this.HandLeft);
            this.EarLeft.addChild(this.EarFlapLeft);
            this.Snout.addChild(this.TopSnout);
            this.Snout.addChild(this.MoustacheLeft);
            this.LowerLegRight.addChild(this.FootRight);
            this.ThighLeft.addChild(this.UpperLegLeft);
            this.Head.addChild(this.EyebrowLeft);
            this.Chest.addChild(this.ArmBaseLeft);
            this.Head.addChild(this.EarRight);
            this.Neck.addChild(this.NeckLower);
            this.ThighRight.addChild(this.UpperLegRight);
            this.Body.addChild(this.Saddlebag);
            this.Head.addChild(this.EarLeft);
            this.Saddlebag.addChild(this.SaddlebagLatchR);
            this.ArmBaseLeft.addChild(this.ArmLeft);
            this.Chest.addChild(this.Neck);
            this.Saddlebag.addChild(this.SaddlebagLatchL);
            this.Body.addChild(this.Hips);
            this.Tail1.addChild(this.Tail2);
            this.ArmLeft.addChild(this.ForearmLeft);
            this.Body.addChild(this.BodyFur);
            this.Neck.addChild(this.Head);
            this.Snout.addChild(this.MoustacheRight);
            this.Snout.addChild(this.Mouth);
            this.ArmRight.addChild(this.ForearmRight);
            this.LowerLegLeft.addChild(this.FootLeft);
            this.Chest.addChild(this.ArmBaseRight);
            this.Chest.addChild(this.ChestFur);
            this.Neck.addChild(this.Collar);
            this.Head.addChild(this.Muzzle);
            this.EarRight.addChild(this.EarFlapRight);
        }

        @Override
        public void setupAnim(JackRussellTerrierEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }
    }

    public static class Baby extends JackRussellTerrierModel {
        public Baby() {
        }

        @Override
        public void setupAnim(JackRussellTerrierEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }
    }
}
