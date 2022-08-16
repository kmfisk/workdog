package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.entity.WDWolfEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;

public abstract class WDWolfModel extends WorkDogModel<WDWolfEntity> {
    public ModelRenderer Chest;
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer ArmBaseLeft;
    public ModelRenderer ArmBaseRight;
    public ModelRenderer Hips;
    public ModelRenderer Tail1;
    public ModelRenderer ThighRight;
    public ModelRenderer ThighLeft;
    public ModelRenderer Tail2;
    public ModelRenderer UpperLegRight;
    public ModelRenderer LowerLegLeft;
    public ModelRenderer FootLeft;
    public ModelRenderer UpperLegLeft;
    public ModelRenderer LowerLegLeft_1;
    public ModelRenderer FootLeft_1;
    public ModelRenderer NeckLower;
    public ModelRenderer Head;
    public ModelRenderer Collar;
    public ModelRenderer NeckFur2Left;
    public ModelRenderer NeckFur2Right;
    public ModelRenderer NeckFur2;
    public ModelRenderer Snout;
    public ModelRenderer EarLeft;
    public ModelRenderer EarRight;
    public ModelRenderer FaceFurLeft;
    public ModelRenderer FaceFurRight;
    public ModelRenderer Muzzle;
    public ModelRenderer TopSnout;
    public ModelRenderer Mouth;
    public ModelRenderer Tongue;
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

    public static class Adult extends WDWolfModel {
        public Adult() {
            this.texWidth = 64;
            this.texHeight = 128;
            this.Chest = new ModelRenderer(this, 0, 0);
            this.Chest.setPos(0.0F, 11.4F, -5.7F);
            this.Chest.addBox(-3.5F, -4.0F, -2.5F, 7, 9, 5, 0.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.ThighLeft = new ModelRenderer(this, 2, 63);
            this.ThighLeft.setPos(2.2F, 1.9F, 2.4F);
            this.ThighLeft.addBox(-2.0F, 0.0F, -2.5F, 4, 6, 5, 0.0F);
            this.setRotateAngle(ThighLeft, 0.18203784098300857F, 0.0F, 0.0F);
            this.LowerLegLeft_1 = new ModelRenderer(this, 5, 82);
            this.LowerLegLeft_1.setPos(-0.1F, 4.0F, 3.5F);
            this.LowerLegLeft_1.addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
            this.setRotateAngle(LowerLegLeft_1, -0.36425021489121656F, 0.0F, 0.0F);
            this.ArmRight = new ModelRenderer(this, 44, 37);
            this.ArmRight.mirror = true;
            this.ArmRight.setPos(0.0F, 5.0F, 1.5F);
            this.ArmRight.addBox(-1.5F, 0.0F, -3.0F, 3, 3, 3, 0.0F);
            this.setRotateAngle(ArmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.TopSnout = new ModelRenderer(this, 50, 8);
            this.TopSnout.setPos(0.0F, 0.0F, -3.1F);
            this.TopSnout.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 4, 0.0F);
            this.setRotateAngle(TopSnout, 0.136659280431156F, 0.0F, 0.0F);
            this.FootLeft = new ModelRenderer(this, 18, 89);
            this.FootLeft.mirror = true;
            this.FootLeft.setPos(0.1F, 4.0F, -0.9F);
            this.FootLeft.addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3, 0.0F);
            this.HandLeft = new ModelRenderer(this, 34, 49);
            this.HandLeft.setPos(-0.1F, 3.0F, 2.4F);
            this.HandLeft.addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3, 0.0F);
            this.setRotateAngle(HandLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.Tail1 = new ModelRenderer(this, 26, 12);
            this.Tail1.setPos(0.0F, 1.2F, 4.1F);
            this.Tail1.addBox(-1.5F, 0.0F, -1.8F, 3, 4, 3, 0.0F);
            this.setRotateAngle(Tail1, 0.5462880558742251F, 0.0F, 0.0F);
            this.Mouth = new ModelRenderer(this, 52, 14);
            this.Mouth.setPos(0.0F, 2.5F, 0.0F);
            this.Mouth.addBox(-1.5F, 0.0F, -2.45F, 3, 1, 3, 0.0F);
            this.setRotateAngle(Mouth, -0.045553093477052F, 0.0F, 0.0F);
            this.ArmLeft = new ModelRenderer(this, 32, 37);
            this.ArmLeft.setPos(0.0F, 5.0F, 1.5F);
            this.ArmLeft.addBox(-1.5F, 0.0F, -3.0F, 3, 3, 3, 0.0F);
            this.setRotateAngle(ArmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.ForearmRight = new ModelRenderer(this, 46, 43);
            this.ForearmRight.mirror = true;
            this.ForearmRight.setPos(0.1F, 2.5F, -3.0F);
            this.ForearmRight.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
            this.setRotateAngle(ForearmRight, -0.136659280431156F, 0.0F, 0.0F);
            this.EarRight = new ModelRenderer(this, 58, 4);
            this.EarRight.mirror = true;
            this.EarRight.setPos(-1.9F, -2.8F, 0.0F);
            this.EarRight.addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1, 0.0F);
            this.setRotateAngle(EarRight, 0.5009094953223726F, 0.091106186954104F, -0.22759093446006054F);
            this.NeckLower = new ModelRenderer(this, 20, 46);
            this.NeckLower.setPos(0.0F, -5.8F, -4.1F);
            this.NeckLower.addBox(-2.0F, 0.0F, 0.0F, 4, 8, 3, 0.0F);
            this.setRotateAngle(NeckLower, -0.091106186954104F, 0.0F, 0.0F);
            this.NeckFur2Left = new ModelRenderer(this, 34, 54);
            this.NeckFur2Left.setPos(0.3F, -4.4F, -4.2F);
            this.NeckFur2Left.addBox(-2.5F, 0.0F, 0.0F, 5, 4, 3, 0.0F);
            this.setRotateAngle(NeckFur2Left, -0.40980330836826856F, 0.18203784098300857F, 0.0F);
            this.LowerLegLeft = new ModelRenderer(this, 17, 82);
            this.LowerLegLeft.mirror = true;
            this.LowerLegLeft.setPos(0.1F, 4.0F, 3.5F);
            this.LowerLegLeft.addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
            this.setRotateAngle(LowerLegLeft, -0.36425021489121656F, 0.0F, 0.0F);
            this.EarLeft = new ModelRenderer(this, 58, 0);
            this.EarLeft.setPos(1.9F, -2.8F, 0.0F);
            this.EarLeft.addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1, 0.0F);
            this.setRotateAngle(EarLeft, 0.4553564018453205F, 0.091106186954104F, 0.22759093446006054F);
            this.HandRight = new ModelRenderer(this, 46, 49);
            this.HandRight.mirror = true;
            this.HandRight.setPos(0.1F, 3.0F, 2.4F);
            this.HandRight.addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3, 0.0F);
            this.setRotateAngle(HandRight, 0.091106186954104F, 0.0F, 0.0F);
            this.UpperLegRight = new ModelRenderer(this, 18, 74);
            this.UpperLegRight.mirror = true;
            this.UpperLegRight.setPos(0.0F, 6.0F, -2.4F);
            this.UpperLegRight.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
            this.setRotateAngle(UpperLegRight, 0.40980330836826856F, 0.0F, 0.0F);
            this.ThighRight = new ModelRenderer(this, 20, 63);
            this.ThighRight.mirror = true;
            this.ThighRight.setPos(-2.2F, 1.9F, 2.4F);
            this.ThighRight.addBox(-2.0F, 0.0F, -2.5F, 4, 6, 5, 0.0F);
            this.setRotateAngle(ThighRight, 0.18203784098300857F, 0.0F, 0.0F);
            this.FaceFurRight = new ModelRenderer(this, 44, 20);
            this.FaceFurRight.mirror = true;
            this.FaceFurRight.setPos(-2.5F, 0.0F, -2.3F);
            this.FaceFurRight.addBox(-0.9F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
            this.setRotateAngle(FaceFurRight, -0.22759093446006054F, 0.0F, 0.0F);
            this.UpperLegLeft = new ModelRenderer(this, 4, 74);
            this.UpperLegLeft.setPos(0.0F, 6.0F, -2.4F);
            this.UpperLegLeft.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
            this.setRotateAngle(UpperLegLeft, 0.40980330836826856F, 0.0F, 0.0F);
            this.Tongue = new ModelRenderer(this, 46, 6);
            this.Tongue.setPos(0.0F, 0.0F, 1.5F);
            this.Tongue.addBox(-1.0F, 0.0F, -4.0F, 2, 0, 4, 0.0F);
            this.setRotateAngle(Tongue, -0.045553093477052F, 0.0F, 0.0F);
            this.Snout = new ModelRenderer(this, 44, 0);
            this.Snout.setPos(0.0F, -0.7F, -3.0F);
            this.Snout.addBox(-2.0F, 0.0F, -2.8F, 4, 3, 3, 0.0F);
            this.setRotateAngle(Snout, -0.045553093477052F, 0.0F, 0.0F);
            this.FaceFurLeft = new ModelRenderer(this, 30, 20);
            this.FaceFurLeft.setPos(-0.5F, 0.0F, -2.3F);
            this.FaceFurLeft.addBox(0.9F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
            this.setRotateAngle(FaceFurLeft, -0.22759093446006054F, 0.0F, 0.0F);
            this.NeckFur2Right = new ModelRenderer(this, 34, 61);
            this.NeckFur2Right.mirror = true;
            this.NeckFur2Right.setPos(-0.3F, -4.4F, -4.2F);
            this.NeckFur2Right.addBox(-2.5F, 0.0F, 0.0F, 5, 4, 3, 0.0F);
            this.setRotateAngle(NeckFur2Right, -0.40980330836826856F, -0.18203784098300857F, 0.0F);
            this.Muzzle = new ModelRenderer(this, 38, 104);
            this.Muzzle.setPos(0.0F, -1.0F, -6.6F);
            this.Muzzle.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 5, 0.0F);
            this.Neck = new ModelRenderer(this, 0, 46);
            this.Neck.setPos(0.0F, -0.4F, 0.5F);
            this.Neck.addBox(-2.5F, -6.3F, -2.7F, 5, 9, 5, 0.0F);
            this.setRotateAngle(Neck, 0.8196066167365371F, 0.0F, 0.0F);
            this.Head = new ModelRenderer(this, 26, 0);
            this.Head.setPos(0.0F, -5.9F, -1.1F);
            this.Head.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
            this.setRotateAngle(Head, -0.5918411493512771F, 0.0F, 0.0F);
            this.ArmBaseRight = new ModelRenderer(this, 46, 28);
            this.ArmBaseRight.mirror = true;
            this.ArmBaseRight.setPos(-1.9F, 1.0F, -0.1F);
            this.ArmBaseRight.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.0F, 0.0F);
            this.NeckFur2 = new ModelRenderer(this, 50, 54);
            this.NeckFur2.setPos(0.0F, -1.9F, -5.0F);
            this.NeckFur2.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
            this.setRotateAngle(NeckFur2, -0.27314402793711257F, 0.0F, 0.0F);
            this.Tail2 = new ModelRenderer(this, 38, 12);
            this.Tail2.setPos(0.0F, 4.0F, -1.8F);
            this.Tail2.addBox(-1.5F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
            this.setRotateAngle(Tail2, 0.18203784098300857F, 0.0F, 0.003490658503988659F);
            this.Hips = new ModelRenderer(this, 0, 32);
            this.Hips.setPos(0.0F, 0.0F, 9.0F);
            this.Hips.addBox(-3.5F, 0.0F, 0.0F, 7, 9, 5, 0.0F);
            this.setRotateAngle(Hips, -0.18203784098300857F, 0.0F, 0.0F);
            this.ForearmLeft = new ModelRenderer(this, 34, 43);
            this.ForearmLeft.setPos(-0.1F, 2.5F, -3.0F);
            this.ForearmLeft.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
            this.setRotateAngle(ForearmLeft, -0.136659280431156F, 0.0F, 0.0F);
            this.FootLeft_1 = new ModelRenderer(this, 6, 89);
            this.FootLeft_1.setPos(-0.1F, 4.0F, -0.9F);
            this.FootLeft_1.addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3, 0.0F);
            this.Collar = new ModelRenderer(this, 32, 76);
            this.Collar.setPos(0.0F, -3.3F, -1.6F);
            this.Collar.addBox(-3.0F, 0.0F, -3.0F, 6, 1, 7, 0.0F);
            this.setRotateAngle(Collar, 0.136659280431156F, 0.0F, 0.0F);
            this.Body = new ModelRenderer(this, 0, 14);
            this.Body.setPos(0.0F, -3.7F, 2.0F);
            this.Body.addBox(-3.0F, 0.0F, 0.0F, 6, 9, 9, 0.0F);
            this.ArmBaseLeft = new ModelRenderer(this, 30, 28);
            this.ArmBaseLeft.setPos(1.9F, 1.0F, -0.1F);
            this.ArmBaseLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
            this.setRotateAngle(ArmBaseLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.Hips.addChild(this.ThighLeft);
            this.UpperLegLeft.addChild(this.LowerLegLeft_1);
            this.ArmBaseRight.addChild(this.ArmRight);
            this.Snout.addChild(this.TopSnout);
            this.LowerLegLeft.addChild(this.FootLeft);
            this.ForearmLeft.addChild(this.HandLeft);
            this.Hips.addChild(this.Tail1);
            this.Snout.addChild(this.Mouth);
            this.ArmBaseLeft.addChild(this.ArmLeft);
            this.ArmRight.addChild(this.ForearmRight);
            this.Head.addChild(this.EarRight);
            this.Neck.addChild(this.NeckLower);
            this.Neck.addChild(this.NeckFur2Left);
            this.UpperLegRight.addChild(this.LowerLegLeft);
            this.Head.addChild(this.EarLeft);
            this.ForearmRight.addChild(this.HandRight);
            this.ThighRight.addChild(this.UpperLegRight);
            this.Hips.addChild(this.ThighRight);
            this.Head.addChild(this.FaceFurRight);
            this.ThighLeft.addChild(this.UpperLegLeft);
            this.Mouth.addChild(this.Tongue);
            this.Head.addChild(this.Snout);
            this.Head.addChild(this.FaceFurLeft);
            this.Neck.addChild(this.NeckFur2Right);
            this.Head.addChild(this.Muzzle);
            this.Chest.addChild(this.Neck);
            this.Neck.addChild(this.Head);
            this.Chest.addChild(this.ArmBaseRight);
            this.Neck.addChild(this.NeckFur2);
            this.Tail1.addChild(this.Tail2);
            this.Body.addChild(this.Hips);
            this.ArmLeft.addChild(this.ForearmLeft);
            this.LowerLegLeft_1.addChild(this.FootLeft_1);
            this.Neck.addChild(this.Collar);
            this.Chest.addChild(this.Body);
            this.Chest.addChild(this.ArmBaseLeft);
        }

        @Override
        public void setupAnim(WDWolfEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }
    }

    public static class Child extends WDWolfModel {
        public Child() {
        }

        @Override
        public void setupAnim(WDWolfEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }
    }
}
