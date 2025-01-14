package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.entity.BorderCollieEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public abstract class BorderCollieModel extends WorkDogModel<BorderCollieEntity> {
    public ModelPart Chest;
    public ModelPart Body;
    public ModelPart Neck;
    public ModelPart ThighLeft;
    public ModelPart ThighRight;
    public ModelPart Tail1;
    public ModelPart FootLeft;
    public ModelPart FootRight;
    public ModelPart Head;
    public ModelPart Snout;
    public ModelPart EarLeft;
    public ModelPart EarRight;
    public ModelPart TopSnout;
    public ModelPart Mouth;
    public ModelPart EarFlapLeft;
    public ModelPart EarFlapRight;
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

    public static class Adult extends BorderCollieModel {
        public ModelPart ArmBaseLeft;
        public ModelPart ArmBaseRight;
        public ModelPart ChestFur;
        public ModelPart Hips;
        public ModelPart BellyFur;
        public ModelPart HarnessHandle;
        public ModelPart Saddlebag;
        public ModelPart UpperLegLeft;
        public ModelPart LowerLegLeft;
        public ModelPart UpperLegRight;
        public ModelPart LowerLegRight;
        public ModelPart Tail2;
        public ModelPart TailFur1;
        public ModelPart TailFur2;
        public ModelPart SaddlebagLatchL;
        public ModelPart SaddlebagLatchR;
        public ModelPart NeckLower;
        public ModelPart Collar;
        public ModelPart NeckFurLeft;
        public ModelPart NeckFurRight;
        public ModelPart NeckFur2;
        public ModelPart FaceFurLeft;
        public ModelPart FaceFurRight;
        public ModelPart Muzzle;
        public ModelPart Tongue;
        public ModelPart ArmFurLeft;
        public ModelPart ForearmLeft;
        public ModelPart ArmFurRight;
        public ModelPart ForearmRight;

        public Adult(ModelPart root) {
            this.Chest = root.getChild("Chest");
            this.FootLeft = this.LowerLegLeft.getChild("FootLeft");
            this.UpperLegLeft = this.ThighLeft.getChild("UpperLegLeft");
            this.FaceFurRight = this.Head.getChild("FaceFurRight");
            this.HandRight = this.ForearmRight.getChild("HandRight");
            this.ForearmLeft = this.ArmLeft.getChild("ForearmLeft");
            this.HandLeft = this.ForearmLeft.getChild("HandLeft");
            this.ArmFurLeft = this.ArmBaseLeft.getChild("ArmFurLeft");
            this.NeckFur2 = this.Neck.getChild("NeckFur2");
            this.TopSnout = this.Snout.getChild("TopSnout");
            this.FootRight = this.LowerLegRight.getChild("FootRight");
            this.ChestFur = this.Chest.getChild("ChestFur");
            this.SaddlebagLatchR = this.Saddlebag.getChild("SaddlebagLatchR");
            this.Body = this.Chest.getChild("Body");
            this.LowerLegLeft = this.UpperLegLeft.getChild("LowerLegLeft");
            this.ThighLeft = this.Hips.getChild("ThighLeft");
            this.EarFlapRight = this.EarRight.getChild("EarFlapRight");
            this.NeckFurLeft = this.Neck.getChild("NeckFurLeft");
            this.NeckFurRight = this.Neck.getChild("NeckFurRight");
            this.Collar = this.Neck.getChild("Collar");
            this.Muzzle = this.Snout.getChild("Muzzle");
            this.ArmFurRight = this.ArmBaseRight.getChild("ArmFurRight");
            this.Hips = this.Body.getChild("Hips");
            this.Tongue = this.Mouth.getChild("Tongue");
            this.SaddlebagLatchL = this.Saddlebag.getChild("SaddlebagLatchL");
            this.EarLeft = this.Head.getChild("EarLeft");
            this.ArmBaseLeft = this.Chest.getChild("ArmBaseLeft");
            this.Mouth = this.Snout.getChild("Mouth");
            this.Head = this.Neck.getChild("Head");
            this.ThighRight = this.Hips.getChild("ThighRight");
            this.TailFur1 = this.Tail1.getChild("TailFur1");
            this.Tail1 = this.Hips.getChild("Tail1");
            this.NeckLower = this.Neck.getChild("NeckLower");
            this.BellyFur = this.Body.getChild("BellyFur");
            this.EarRight = this.Head.getChild("EarRight");
            this.EarFlapLeft = this.EarLeft.getChild("EarFlapLeft");
            this.Tail2 = this.Tail1.getChild("Tail2");
            this.Snout = this.Head.getChild("Snout");
            this.ArmRight = this.ArmBaseRight.getChild("ArmRight");
            this.Saddlebag = this.Body.getChild("Saddlebag");
            this.ArmBaseRight = this.Chest.getChild("ArmBaseRight");
            this.UpperLegRight = this.ThighRight.getChild("UpperLegRight");
            this.Neck = this.Chest.getChild("Neck");
            this.HarnessHandle = this.Body.getChild("HarnessHandle");
            this.TailFur2 = this.Tail2.getChild("TailFur2");
            this.ArmLeft = this.ArmBaseLeft.getChild("ArmLeft");
            this.LowerLegRight = this.UpperLegRight.getChild("LowerLegRight");
            this.ForearmRight = this.ArmRight.getChild("ForearmRight");
            this.FaceFurLeft = this.Head.getChild("FaceFurLeft");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshDefinition = new MeshDefinition();
            PartDefinition partDefinition = meshDefinition.getRoot();

            partDefinition.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(36, 52).addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2), PartPose.offset(-0.1F, 4.0F, -0.9F));
            partDefinition.addOrReplaceChild("UpperLegLeft", CubeListBuilder.create().texOffs(29, 39).addBox(-1.5F, 0.0F, 0.0F, 3, 4, 3), PartPose.offsetAndRotation(0.0F, 6.0F, -1.8F, 0.6373942428283291F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("FaceFurRight", CubeListBuilder.create().texOffs(46, 79).mirror(true).addBox(-1.5F, 0.0F, -2.0F, 3, 3, 4), PartPose.offsetAndRotation(-1.6F, 0.4F, -0.9F, 0.136659280431156F, -0.18203784098300857F, 0.0F));
            partDefinition.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(38, 16).mirror(true).addBox(-1.0F, -1.0F, -3.0F, 2, 2, 2), PartPose.offsetAndRotation(-0.1F, 2.0F, 2.4F, 0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ForearmLeft", CubeListBuilder.create().texOffs(28, 12).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(-0.1F, 2.6F, -2.0F, -0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("HandLeft", CubeListBuilder.create().texOffs(28, 16).addBox(-1.0F, -1.0F, -3.0F, 2, 2, 2), PartPose.offsetAndRotation(-0.1F, 2.0F, 2.4F, 0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ArmFurLeft", CubeListBuilder.create().texOffs(26, 20).addBox(-1.5F, -1.0F, 0.0F, 3, 5, 3), PartPose.offsetAndRotation(-0.3F, 1.6F, -0.6F, 0.22759093446006054F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("NeckFur2", CubeListBuilder.create().texOffs(41, 95).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3), PartPose.offsetAndRotation(0.0F, -0.5F, -5.0F, -0.4553564018453205F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("TopSnout", CubeListBuilder.create().texOffs(12, 58).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 3), PartPose.offsetAndRotation(0.0F, -0.3F, -3.0F, 0.18203784098300857F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(48, 52).mirror(true).addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2), PartPose.offset(0.1F, 4.0F, -0.9F));
            partDefinition.addOrReplaceChild("ChestFur", CubeListBuilder.create().texOffs(13, 76).addBox(-2.5F, 0.0F, 0.0F, 5, 3, 4), PartPose.offsetAndRotation(0.0F, 3.3F, -2.5F, 0.31869712141416456F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("SaddlebagLatchR", CubeListBuilder.create().texOffs(0, 88).addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1), PartPose.offset(-3.4F, -2.0F, 0.0F));
            partDefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, 0.0F, 0.0F, 6, 7, 7), PartPose.offsetAndRotation(0.0F, -3.5F, 1.9F, 0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("LowerLegLeft", CubeListBuilder.create().texOffs(32, 46).addBox(-1.0F, 0.0F, -2.0F, 2, 4, 2), PartPose.offsetAndRotation(0.0F, 4.0F, 2.7F, -0.6829473363053812F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(28, 29).addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4), PartPose.offsetAndRotation(1.9F, 1.7F, 1.9F, 0.18203784098300857F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarFlapRight", CubeListBuilder.create().texOffs(28, 53).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -3.0F, 1.0F, -0.27314402793711257F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("NeckFurLeft", CubeListBuilder.create().texOffs(32, 86).addBox(-1.5F, 0.0F, 0.0F, 3, 4, 4), PartPose.offsetAndRotation(0.4F, -4.2F, -3.2F, -0.5918411493512771F, 0.136659280431156F, 0.0F));
            partDefinition.addOrReplaceChild("NeckFurRight", CubeListBuilder.create().texOffs(47, 86).mirror(true).addBox(-1.5F, 0.0F, 0.0F, 3, 4, 4), PartPose.offsetAndRotation(-0.4F, -4.2F, -3.2F, -0.5918411493512771F, -0.136659280431156F, 0.0F));
            partDefinition.addOrReplaceChild("Collar", CubeListBuilder.create().texOffs(0, 63).addBox(-2.5F, 0.0F, -2.5F, 5, 1, 6), PartPose.offset(0.0F, -2.7F, -0.8F));
            partDefinition.addOrReplaceChild("Muzzle", CubeListBuilder.create().texOffs(0, 70).addBox(-2.0F, 0.0F, -3.3F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ArmFurRight", CubeListBuilder.create().texOffs(38, 20).mirror(true).addBox(-1.5F, -1.0F, 0.0F, 3, 5, 3), PartPose.offsetAndRotation(0.4F, 1.6F, -0.6F, 0.22759093446006054F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(0, 26).addBox(-3.5F, 0.0F, 0.0F, 7, 7, 4), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(-3, 49).addBox(-1.0F, 0.0F, -3.0F, 2, 0, 3), PartPose.offsetAndRotation(0.0F, -1.0F, 0.8F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("SaddlebagLatchL", CubeListBuilder.create().texOffs(0, 88).addBox(0.0F, 0.0F, -0.5F, 1, 2, 1), PartPose.offset(3.4F, -2.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(15, 48).addBox(-1.0F, -3.0F, 0.0F, 2, 4, 1), PartPose.offsetAndRotation(1.7F, -0.7F, 0.0F, 0.0F, -0.31869712141416456F, 0.22759093446006054F));
            partDefinition.addOrReplaceChild("ArmBaseLeft", CubeListBuilder.create().texOffs(24, 0).addBox(-1.5F, 0.0F, -2.0F, 3, 4, 3), PartPose.offsetAndRotation(2.2F, 1.3F, 0.0F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(22, 59).addBox(-1.0F, -1.0F, -2.5F, 2, 1, 3), PartPose.offset(0.0F, 2.4F, 0.0F));
            partDefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 48).addBox(-2.5F, -2.5F, -2.5F, 5, 5, 5), PartPose.offsetAndRotation(0.0F, -5.2F, -0.2F, -0.5918411493512771F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(44, 29).mirror(true).addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4), PartPose.offsetAndRotation(-1.9F, 1.7F, 1.9F, 0.18203784098300857F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("TailFur1", CubeListBuilder.create().texOffs(44, 57).addBox(-2.0F, 0.0F, -3.0F, 4, 4, 4), PartPose.offset(0.0F, 0.0F, -1.4F));
            partDefinition.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(49, 0).addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2), PartPose.offsetAndRotation(0.0F, 1.5F, 3.5F, 1.2747884856566583F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("NeckLower", CubeListBuilder.create().texOffs(18, 40).addBox(-1.5F, 0.0F, 0.0F, 3, 6, 2), PartPose.offsetAndRotation(0.0F, -4.8F, -2.8F, -0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("BellyFur", CubeListBuilder.create().texOffs(17, 64).addBox(-2.5F, 0.0F, 0.0F, 5, 3, 8), PartPose.offsetAndRotation(0.0F, 6.6F, -1.0F, 0.18203784098300857F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -3.5F, -2.5F, 7, 7, 5), PartPose.offsetAndRotation(0.0F, 13.0F, -4.0F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(21, 48).mirror(true).addBox(-1.0F, -3.0F, 0.0F, 2, 4, 1), PartPose.offsetAndRotation(-1.7F, -0.7F, 0.0F, 0.0F, 0.31869712141416456F, -0.22759093446006054F));
            partDefinition.addOrReplaceChild("EarFlapLeft", CubeListBuilder.create().texOffs(20, 53).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -3.0F, 1.0F, -0.27314402793711257F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(49, 7).addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2), PartPose.offsetAndRotation(0.0F, 4.0F, -1.0F, 0.27314402793711257F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 58).addBox(-1.5F, 0.0F, -2.7F, 3, 2, 3), PartPose.offsetAndRotation(0.0F, 0.0F, -2.5F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(38, 7).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 3, 2), PartPose.offsetAndRotation(0.0F, 3.8F, 0.5F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Saddlebag", CubeListBuilder.create().texOffs(0, 87).addBox(-4.0F, -2.5F, -2.5F, 8, 5, 5), PartPose.offset(0.0F, 2.0F, 7.0F));
            partDefinition.addOrReplaceChild("ArmBaseRight", CubeListBuilder.create().texOffs(36, 0).mirror(true).addBox(-1.5F, 0.0F, -2.0F, 3, 4, 3), PartPose.offsetAndRotation(-2.2F, 1.3F, 0.0F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("UpperLegRight", CubeListBuilder.create().texOffs(46, 39).mirror(true).addBox(-1.5F, 0.0F, 0.0F, 3, 4, 3), PartPose.offsetAndRotation(0.0F, 6.0F, -1.8F, 0.6373942428283291F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 37).addBox(-2.0F, -5.0F, -2.5F, 4, 6, 5), PartPose.offsetAndRotation(0.0F, -0.9F, -0.3F, 0.7285004297824331F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("HarnessHandle", CubeListBuilder.create().texOffs(0, 81).addBox(-2.5F, 0.0F, 0.0F, 5, 3, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.5F, -0.27314402793711257F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("TailFur2", CubeListBuilder.create().texOffs(44, 66).addBox(-1.5F, -1.0F, -2.5F, 3, 8, 4), PartPose.offset(0.0F, 0.0F, 0.2F));
            partDefinition.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(27, 7).addBox(-1.0F, 0.0F, -2.0F, 2, 3, 2), PartPose.offsetAndRotation(0.0F, 3.8F, 0.5F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("LowerLegRight", CubeListBuilder.create().texOffs(48, 46).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 4, 2), PartPose.offsetAndRotation(0.0F, 4.0F, 2.7F, -0.6829473363053812F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ForearmRight", CubeListBuilder.create().texOffs(38, 12).mirror(true).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(0.1F, 2.6F, -2.0F, -0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("FaceFurLeft", CubeListBuilder.create().texOffs(32, 79).addBox(-1.5F, 0.0F, -2.0F, 3, 3, 4), PartPose.offsetAndRotation(1.6F, 0.4F, -0.9F, 0.136659280431156F, 0.18203784098300857F, 0.0F));

            return LayerDefinition.create(meshDefinition, 64, 128);
        }

        @Override
        public void playIdleAnimation(BorderCollieEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? 1.18F : 0.72F);
            this.Head.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.59F;
            if (!entity.isInSittingPose() && !entity.isLying()) {
                this.Tail1.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 1.27F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
                this.Tail2.zRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F;
            }
        }

        @Override
        public void playMovementAnimation(BorderCollieEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.7f;
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
                this.Tail1.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 1.5F;
                this.Mouth.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + 0.5F;
//                this.Tongue.z = MathHelper.cos((limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * 0.0F) * limbSwingAmount * 0.5F + -0.05F;
//                this.Chest.y = MathHelper.cos(4.0F + (limbSwing * speed * 0.4F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F;

            } else {
                this.ArmBaseLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.13F;
                this.ArmLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F + -0.04F;
                this.HandLeft.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.09F;
                this.ArmBaseRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.13F;
                this.ArmRight.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.5F) * limbSwingAmount * 0.5F + -0.04F;
                this.HandRight.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.09F;
                this.ArmBaseLeft.z = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F;
                this.ArmBaseRight.z = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F;
                this.Neck.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 0.72F;
                this.Head.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + -0.59F;
                this.ThighLeft.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.18F;
                this.UpperLegLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + 0.63F;
                this.LowerLegLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + -0.68F;
                this.FootLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F;
                this.ThighLeft.y = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 1.7F;
                this.ThighLeft.z = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + 1.9F;
                this.ThighRight.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.18F;
                this.UpperLegRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + 0.63F;
                this.LowerLegRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + -0.68F;
                this.FootRight.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F;
                this.ThighRight.y = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 1.7F;
                this.ThighRight.z = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 1.9F;
                this.Chest.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.05F) * limbSwingAmount * 0.5F + -0.05F;
                this.Body.xRot = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 0.04F;
                this.Hips.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + -0.15F;
                this.Neck.z = Mth.cos(5.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.07F) * limbSwingAmount * 0.5F + -0.3F;
                this.Tail1.xRot = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.5F) * limbSwingAmount * 0.5F + 1.27F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
                this.Chest.y = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.09F) * limbSwingAmount * 0.5F + 13.0F;
            }
        }

        @Override
        public void setSittingPose(BorderCollieEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmBaseLeft.setPos(2.2F, 2.2F, -0.6F);
            this.ArmBaseRight.setPos(-2.2F, 2.2F, -0.6F);
            this.BellyFur.setPos(0.0F, 6.6F, 0.5F);
            this.Body.setPos(0.0F, -3.2F, 1.9F);
            this.Chest.setPos(0.0F, 13.1F, -4.0F);
            this.ChestFur.setPos(0.0F, 3.3F, -2.7F);
            this.FootLeft.setPos(-0.1F, 3.7F, -0.9F);
            this.FootRight.setPos(0.1F, 3.7F, -0.9F);
            this.LowerLegLeft.setPos(0.55F, 4.7F, 2.7F);
            this.LowerLegRight.setPos(-0.55F, 4.7F, 2.7F);
            this.setRotateAngle(ArmBaseLeft, 0.6829473363053812F, 0.0F, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.6829473363053812F, 0.0F, 0.0F);
            this.setRotateAngle(Body, -0.5009094953223726F, 0.0F, 0.0F);
            this.setRotateAngle(Chest, -0.5918411493512771F, 0.0F, 0.0F);
            this.setRotateAngle(FootLeft, 1.6390387005478748F, 0.0F, 0.0F);
            this.setRotateAngle(FootRight, 1.6390387005478748F, 0.0F, 0.0F);
            this.setRotateAngle(LowerLegLeft, -1.6390387005478748F, 0.0F, 0.0F);
            this.setRotateAngle(LowerLegRight, -1.6390387005478748F, 0.0F, 0.0F);
            this.setRotateAngle(Neck, 1.1838568316277536F, 0.0F, 0.0F);
            this.setRotateAngle(Tail1, 2.367539130330308F, 0.0F, 0.0F);
            this.setRotateAngle(Tail2, 0.40980330836826856F, 0.0F, 0.0F);
            this.setRotateAngle(ThighLeft, -1.0016444577195458F, -0.045553093477052F, -0.091106186954104F);
            this.setRotateAngle(ThighRight, -1.0016444577195458F, 0.045553093477052F, 0.091106186954104F);
            this.setRotateAngle(UpperLegLeft, 2.41309222380736F, 0.0F, 0.0F);
            this.setRotateAngle(UpperLegRight, 2.41309222380736F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 2.1F, 3.5F);
            this.ThighLeft.setPos(2.6F, 1.8F, 4.6F);
            this.ThighRight.setPos(-2.6F, 1.8F, 4.6F);
            this.UpperLegLeft.setPos(0.4F, 5.9F, 1.2F);
            this.UpperLegRight.setPos(-0.4F, 5.9F, 1.2F);

        }

        @Override
        public void setLyingPose(BorderCollieEntity entity, float speed, float walkSpeed, float partialTick) {
            this.Neck.setPos(0.0F, -0.9F, -0.3F);
            this.setRotateAngle(Neck, 0.8196066167365371F, 0.0F, 0.0F);
            this.Muzzle.setPos(0.0F, -1.0F, 0.0F);
            this.setRotateAngle(Muzzle, 0.091106186954104F, 0.0F, 0.0F);
            this.ArmBaseLeft.setPos(2.5F, -0.7F, 0.0F);
            this.setRotateAngle(ArmBaseLeft, 0.136659280431156F, -0.22759093446006054F, 0.0F);
            this.ArmLeft.setPos(0.0F, 5.8F, 0.5F);
            this.setRotateAngle(ArmLeft, -1.6845917940249266F, 0.0F, 0.0F);
            this.Snout.setPos(0.0F, 0.0F, -2.5F);
            this.setRotateAngle(Snout, -0.045553093477052F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 2.7F, 3.5F);
            this.setRotateAngle(Tail1, 1.2747884856566583F, 0.36425021489121656F, 0.0F);
            this.Saddlebag.setPos(0.0F, 2.0F, 7.0F);
            this.ArmFurLeft.setPos(-1.1F, 2.6F, -0.6F);
            this.setRotateAngle(ArmFurLeft, 0.22759093446006054F, 0.0F, 0.0F);
            this.Hips.setPos(0.0F, 0.0F, 7.0F);
            this.setRotateAngle(Hips, -0.22759093446006054F, 0.0F, 0.0F);
            this.Chest.setPos(0.0F, 19.0F, -4.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.LowerLegLeft.setPos(0.6F, 4.9F, 1.7F);
            this.setRotateAngle(LowerLegLeft, -1.9123572614101867F, 0.0F, 0.0F);
            this.Tail2.setPos(0.0F, 4.0F, -1.0F);
            this.setRotateAngle(Tail2, 0.27314402793711257F, 0.5009094953223726F, -0.27314402793711257F);
            this.Mouth.setPos(0.0F, 2.4F, 0.0F);
            this.UpperLegRight.setPos(0.0F, 5.7F, 1.3F);
            this.setRotateAngle(UpperLegRight, 2.4586453172844123F, 0.0F, 0.0F);
            this.SaddlebagLatchR.setPos(-3.4F, -2.0F, 0.0F);
            this.TopSnout.setPos(0.0F, -0.3F, -3.0F);
            this.setRotateAngle(TopSnout, 0.18203784098300857F, 0.0F, 0.0F);
            this.ArmBaseRight.setPos(-2.2F, -0.7F, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.31869712141416456F, 0.0F);
            this.UpperLegLeft.setPos(0.0F, 5.7F, 1.3F);
            this.setRotateAngle(UpperLegLeft, 2.4586453172844123F, 0.0F, 0.0F);
            this.NeckFurRight.setPos(-0.4F, -4.2F, -3.2F);
            this.setRotateAngle(NeckFurRight, -0.5918411493512771F, -0.136659280431156F, 0.0F);
            this.EarFlapLeft.setPos(0.0F, -3.0F, 1.0F);
            this.setRotateAngle(EarFlapLeft, -0.27314402793711257F, 0.0F, 0.0F);
            this.LowerLegRight.setPos(-0.6F, 4.9F, 1.7F);
            this.setRotateAngle(LowerLegRight, -1.9123572614101867F, 0.0F, 0.0F);
            this.NeckFurLeft.setPos(0.4F, -4.2F, -3.2F);
            this.setRotateAngle(NeckFurLeft, -0.5918411493512771F, 0.136659280431156F, 0.0F);
            this.Head.setPos(0.0F, -5.2F, -0.5F);
            this.setRotateAngle(Head, -0.5918411493512771F, 0.0F, 0.0F);
            this.EarRight.setPos(-1.7F, -0.7F, 0.0F);
            this.setRotateAngle(EarRight, 0.0F, 0.31869712141416456F, -0.22759093446006054F);
            this.Tongue.setPos(0.0F, -1.0F, 0.8F);
            this.setRotateAngle(Tongue, -0.045553093477052F, 0.0F, 0.0F);
            this.EarLeft.setPos(1.7F, -0.7F, 0.0F);
            this.setRotateAngle(EarLeft, 0.0F, -0.31869712141416456F, 0.22759093446006054F);
            this.FaceFurLeft.setPos(1.6F, 0.4F, -0.9F);
            this.setRotateAngle(FaceFurLeft, 0.136659280431156F, 0.18203784098300857F, 0.0F);
            this.FaceFurRight.setPos(-1.6F, 0.4F, -0.9F);
            this.setRotateAngle(FaceFurRight, 0.136659280431156F, -0.18203784098300857F, 0.0F);
            this.ArmFurRight.setPos(0.4F, 1.6F, -0.6F);
            this.setRotateAngle(ArmFurRight, 0.22759093446006054F, 0.0F, 0.0F);
            this.Collar.setPos(0.0F, -2.7F, -0.8F);
            this.ChestFur.setPos(0.0F, 3.3F, -2.5F);
            this.setRotateAngle(ChestFur, 0.31869712141416456F, 0.0F, 0.0F);
            this.Body.setPos(0.0F, -3.5F, 1.9F);
            this.setRotateAngle(Body, -0.045553093477052F, 0.0F, 0.0F);
            this.TailFur2.setPos(0.0F, 0.0F, 0.2F);
            this.FootRight.setPos(0.1F, 4.0F, -0.9F);
            this.setRotateAngle(FootRight, 1.4570008595648662F, 0.0F, 0.0F);
            this.NeckLower.setPos(0.0F, -4.8F, -2.8F);
            this.setRotateAngle(NeckLower, -0.136659280431156F, 0.0F, 0.0F);
            this.NeckFur2.setPos(0.0F, -0.5F, -5.0F);
            this.setRotateAngle(NeckFur2, -0.4553564018453205F, 0.0F, 0.0F);
            this.ThighRight.setPos(-2.9F, 4.7F, 3.9F);
            this.setRotateAngle(ThighRight, -1.730144887501979F, 0.0F, 0.0F);
            this.ThighLeft.setPos(2.9F, 4.7F, 3.9F);
            this.setRotateAngle(ThighLeft, -1.730144887501979F, 0.0F, 0.0F);
            this.HandRight.setPos(-0.1F, 0.9F, 1.0F);
            this.setRotateAngle(HandRight, 1.6390387005478748F, 0.0F, 0.0F);
            this.FootLeft.setPos(-0.1F, 4.0F, -0.9F);
            this.setRotateAngle(FootLeft, 1.4570008595648662F, 0.0F, 0.0F);
            this.TailFur1.setPos(0.0F, 0.0F, -1.4F);
            this.HarnessHandle.setPos(0.0F, -2.0F, 1.5F);
            this.setRotateAngle(HarnessHandle, -0.27314402793711257F, 0.0F, 0.0F);
            this.ArmRight.setPos(0.0F, 5.8F, 0.5F);
            this.setRotateAngle(ArmRight, -1.593485607070823F, 0.0F, 0.0F);
            this.ForearmLeft.setPos(-0.1F, 2.6F, -2.0F);
            this.setRotateAngle(ForearmLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.HandLeft.setPos(-0.1F, 1.0F, 1.1F);
            this.setRotateAngle(HandLeft, 1.5481070465189704F, 0.0F, 0.0F);
            this.EarFlapRight.setPos(0.0F, -3.0F, 1.0F);
            this.setRotateAngle(EarFlapRight, -0.27314402793711257F, 0.0F, 0.0F);
            this.SaddlebagLatchL.setPos(3.4F, -2.0F, 0.0F);
            this.BellyFur.setPos(0.0F, 6.6F, -1.0F);
            this.setRotateAngle(BellyFur, 0.18203784098300857F, 0.0F, 0.0F);
            this.ForearmRight.setPos(0.1F, 2.6F, -2.0F);
            this.setRotateAngle(ForearmRight, -0.136659280431156F, 0.0F, 0.0F);
        }

        @Override
        public void resetPose(BorderCollieEntity entity, float speed, float walkSpeed, float partialTick) {
            this.FootLeft.setPos(-0.1F, 4.0F, -0.9F);
            this.setRotateAngle(FootLeft, 0F, 0F, 0F);
            this.UpperLegLeft.setPos(0.0F, 6.0F, -1.8F);
            this.setRotateAngle(UpperLegLeft, 0.6373942428283291F, 0.0F, 0.0F);
            this.FaceFurRight.setPos(-1.6F, 0.4F, -0.9F);
            this.setRotateAngle(FaceFurRight, 0.136659280431156F, -0.18203784098300857F, 0.0F);
            this.HandRight.setPos(-0.1F, 2.0F, 2.4F);
            this.setRotateAngle(HandRight, 0.091106186954104F, 0.0F, 0.0F);
            this.ForearmLeft.setPos(-0.1F, 2.6F, -2.0F);
            this.setRotateAngle(ForearmLeft, -0.136659280431156F, 0.0F, 0.0F);
            this.HandLeft.setPos(-0.1F, 2.0F, 2.4F);
            this.setRotateAngle(HandLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.ArmFurLeft.setPos(-0.3F, 1.6F, -0.6F);
            this.setRotateAngle(ArmFurLeft, 0.22759093446006054F, 0.0F, 0.0F);
            this.NeckFur2.setPos(0.0F, -0.5F, -5.0F);
            this.setRotateAngle(NeckFur2, -0.4553564018453205F, 0.0F, 0.0F);
            this.TopSnout.setPos(0.0F, -0.3F, -3.0F);
            this.setRotateAngle(TopSnout, 0.18203784098300857F, 0.0F, 0.0F);
            this.FootRight.setPos(0.1F, 4.0F, -0.9F);
            this.setRotateAngle(FootRight, 0F, 0F, 0F);
            this.ChestFur.setPos(0.0F, 3.3F, -2.5F);
            this.setRotateAngle(ChestFur, 0.31869712141416456F, 0.0F, 0.0F);
            this.SaddlebagLatchR.setPos(-3.4F, -2.0F, 0.0F);
            this.Body.setPos(0.0F, -3.5F, 1.9F);
            this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
            this.LowerLegLeft.setPos(0.0F, 4.0F, 2.7F);
            this.setRotateAngle(LowerLegLeft, -0.6829473363053812F, 0.0F, 0.0F);
            this.ThighLeft.setPos(1.9F, 1.7F, 1.9F);
            this.setRotateAngle(ThighLeft, 0.18203784098300857F, 0.0F, 0.0F);
            this.EarFlapRight.setPos(0.0F, -3.0F, 1.0F);
            this.setRotateAngle(EarFlapRight, -0.27314402793711257F, 0.0F, 0.0F);
            this.NeckFurLeft.setPos(0.4F, -4.2F, -3.2F);
            this.setRotateAngle(NeckFurLeft, -0.5918411493512771F, 0.136659280431156F, 0.0F);
            this.NeckFurRight.setPos(-0.4F, -4.2F, -3.2F);
            this.setRotateAngle(NeckFurRight, -0.5918411493512771F, -0.136659280431156F, 0.0F);
            this.Collar.setPos(0.0F, -2.7F, -0.8F);
            this.Muzzle.setPos(0.0F, -1.0F, 0.0F);
            this.setRotateAngle(Muzzle, 0.091106186954104F, 0.0F, 0.0F);
            this.ArmFurRight.setPos(0.4F, 1.6F, -0.6F);
            this.setRotateAngle(ArmFurRight, 0.22759093446006054F, 0.0F, 0.0F);
            this.Hips.setPos(0.0F, 0.0F, 7.0F);
            this.setRotateAngle(Hips, -0.136659280431156F, 0.0F, 0.0F);
            this.Tongue.setPos(0.0F, -1.0F, 0.8F);
            this.setRotateAngle(Tongue, -0.045553093477052F, 0.0F, 0.0F);
            this.SaddlebagLatchL.setPos(3.4F, -2.0F, 0.0F);
            this.EarLeft.setPos(1.7F, -0.7F, 0.0F);
            this.setRotateAngle(EarLeft, 0.0F, -0.31869712141416456F, 0.22759093446006054F);
            this.ArmBaseLeft.setPos(2.2F, 1.3F, 0.0F);
            this.setRotateAngle(ArmBaseLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.Mouth.setPos(0.0F, 2.4F, 0.0F);
            this.Head.setPos(0.0F, -5.2F, -0.2F);
            this.setRotateAngle(Head, -0.5918411493512771F, 0.0F, 0.0F);
            this.ThighRight.setPos(-1.9F, 1.7F, 1.9F);
            this.setRotateAngle(ThighRight, 0.18203784098300857F, 0.0F, 0.0F);
            this.TailFur1.setPos(0.0F, 0.0F, -1.4F);
            this.Tail1.setPos(0.0F, 1.5F, 3.5F);
            this.setRotateAngle(Tail1, 1.2747884856566583F, 0.0F, 0.0F);
            this.NeckLower.setPos(0.0F, -4.8F, -2.8F);
            this.setRotateAngle(NeckLower, -0.136659280431156F, 0.0F, 0.0F);
            this.BellyFur.setPos(0.0F, 6.6F, -1.0F);
            this.setRotateAngle(BellyFur, 0.18203784098300857F, 0.0F, 0.0F);
            this.Chest.setPos(0.0F, 13.0F, -4.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.EarRight.setPos(-1.7F, -0.7F, 0.0F);
            this.setRotateAngle(EarRight, 0.0F, 0.31869712141416456F, -0.22759093446006054F);
            this.EarFlapLeft.setPos(0.0F, -3.0F, 1.0F);
            this.setRotateAngle(EarFlapLeft, -0.27314402793711257F, 0.0F, 0.0F);
            this.Tail2.setPos(0.0F, 4.0F, -1.0F);
            this.setRotateAngle(Tail2, 0.27314402793711257F, 0.0F, 0.0F);
            this.Snout.setPos(0.0F, 0.0F, -2.5F);
            this.setRotateAngle(Snout, -0.045553093477052F, 0.0F, 0.0F);
            this.ArmRight.setPos(0.0F, 3.8F, 0.5F);
            this.setRotateAngle(ArmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.Saddlebag.setPos(0.0F, 2.0F, 7.0F);
            this.ArmBaseRight.setPos(-2.2F, 1.3F, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.0F, 0.0F);
            this.UpperLegRight.setPos(0.0F, 6.0F, -1.8F);
            this.setRotateAngle(UpperLegRight, 0.6373942428283291F, 0.0F, 0.0F);
            this.Neck.setPos(0.0F, -0.9F, -0.3F);
            this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
            this.HarnessHandle.setPos(0.0F, -2.0F, 1.5F);
            this.setRotateAngle(HarnessHandle, -0.27314402793711257F, 0.0F, 0.0F);
            this.TailFur2.setPos(0.0F, 0.0F, 0.2F);
            this.ArmLeft.setPos(0.0F, 3.8F, 0.5F);
            this.setRotateAngle(ArmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.LowerLegRight.setPos(0.0F, 4.0F, 2.7F);
            this.setRotateAngle(LowerLegRight, -0.6829473363053812F, 0.0F, 0.0F);
            this.ForearmRight.setPos(0.1F, 2.6F, -2.0F);
            this.setRotateAngle(ForearmRight, -0.136659280431156F, 0.0F, 0.0F);
            this.FaceFurLeft.setPos(1.6F, 0.4F, -0.9F);
            this.setRotateAngle(FaceFurLeft, 0.136659280431156F, 0.18203784098300857F, 0.0F);
        }
    }

    public static class Baby extends BorderCollieModel {
        public ModelPart LegLeft;
        public ModelPart LegRight;

        public Baby(ModelPart root) {
            this.Chest = root.getChild("Chest");
            this.ArmLeft = this.Chest.getChild("ArmLeft");
            this.Mouth = this.Snout.getChild("Mouth");
            this.Body = this.Chest.getChild("Body");
            this.ThighLeft = this.Body.getChild("ThighLeft");
            this.EarFlapRight = this.EarRight.getChild("EarFlapRight");
            this.Tail1 = this.Body.getChild("Tail1");
            this.FootLeft = this.LegLeft.getChild("FootLeft");
            this.Snout = this.Head.getChild("Snout");
            this.LegLeft = this.ThighLeft.getChild("LegLeft");
            this.EarFlapLeft = this.EarLeft.getChild("EarFlapLeft");
            this.HandLeft = this.ArmLeft.getChild("HandLeft");
            this.TopSnout = this.Snout.getChild("TopSnout");
            this.EarLeft = this.Head.getChild("EarLeft");
            this.FootRight = this.LegRight.getChild("FootRight");
            this.HandRight = this.ArmRight.getChild("HandRight");
            this.ArmRight = this.Chest.getChild("ArmRight");
            this.Neck = this.Chest.getChild("Neck");
            this.LegRight = this.ThighRight.getChild("LegRight");
            this.EarRight = this.Head.getChild("EarRight");
            this.ThighRight = this.Body.getChild("ThighRight");
            this.Head = this.Neck.getChild("Head");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshDefinition = new MeshDefinition();
            PartDefinition partDefinition = meshDefinition.getRoot();

            partDefinition.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(24, 15).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(1.7F, 0.7F, -0.5F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(10, 25).addBox(-1.0F, -1.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, 2.1F, 0.2F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, 0.0F, 0.0F, 4, 5, 4), PartPose.offset(0.0F, -2.5F, 2.0F));
            partDefinition.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3), PartPose.offset(1.7F, 0.9F, 2.7F));
            partDefinition.addOrReplaceChild("EarFlapRight", CubeListBuilder.create().texOffs(20, 12).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(27, 24).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 4), PartPose.offsetAndRotation(0.0F, 0.4F, 4.0F, -0.7285004297824331F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(34, 11).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(-0.1F, 2.0F, 2.0F, -0.40980330836826856F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, 0.0F, -2.0F, 3, 2, 2), PartPose.offset(0.0F, 0.1F, -1.3F));
            partDefinition.addOrReplaceChild("LegLeft", CubeListBuilder.create().texOffs(34, 7).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(-0.1F, 4.0F, -1.1F, 0.4553564018453205F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarFlapLeft", CubeListBuilder.create().texOffs(16, 9).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("HandLeft", CubeListBuilder.create().texOffs(24, 20).addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(-0.1F, 3.5F, 0.6F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("TopSnout", CubeListBuilder.create().texOffs(8, 28).addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2), PartPose.offsetAndRotation(0.0F, -0.4F, -0.1F, 0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(10, 9).addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1), PartPose.offsetAndRotation(1.1F, -0.7F, 0.4F, 0.136659280431156F, -0.091106186954104F, 0.31869712141416456F));
            partDefinition.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(45, 11).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.1F, 2.0F, 2.0F, -0.40980330836826856F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(32, 20).mirror(true).addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.1F, 3.5F, 0.6F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(32, 15).mirror(true).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(-1.7F, 0.7F, -0.5F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, -2.7F, -2.1F, 3, 4, 4), PartPose.offsetAndRotation(0.0F, -1.3F, -0.7F, 0.7285004297824331F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("LegRight", CubeListBuilder.create().texOffs(45, 7).mirror(true).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(0.1F, 4.0F, -1.1F, 0.4553564018453205F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(14, 12).mirror(true).addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1), PartPose.offsetAndRotation(-1.1F, -0.2F, 0.4F, 0.136659280431156F, 0.091106186954104F, -0.31869712141416456F));
            partDefinition.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(44, 0).mirror(true).addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3), PartPose.offset(-1.7F, 0.9F, 2.7F));
            partDefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -2.0F, 5, 5, 4), PartPose.offsetAndRotation(0.0F, 19.5F, -2.0F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, -2.1F, -0.2F, -0.6373942428283291F, 0.0F, 0.0F));

            return LayerDefinition.create(meshDefinition, 64, 32);
        }

        @Override
        public void playIdleAnimation(BorderCollieEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? 1.23F : 0.72F);
            this.Head.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? -0.45F : -0.63F);
            if (!entity.isInSittingPose() && !entity.isLying()) {
                this.Tail1.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + -0.82F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
            }
        }

        @Override
        public void playMovementAnimation(BorderCollieEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 0.8f;
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
            this.Tail1.zRot = Mth.cos(2.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F;
        }

        @Override
        public void setSittingPose(BorderCollieEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmLeft.setPos(1.3F, 1.2F, 0.2F);
            this.ArmRight.setPos(-1.3F, 1.2F, 0.2F);
            this.Neck.setPos(0.0F, -0.8F, -1.5F);
            this.setRotateAngle(ArmLeft, 0.7740535232594852F, 0.0F, 0.0F);
            this.setRotateAngle(ArmRight, 0.7740535232594852F, 0.0F, 0.0F);
            this.setRotateAngle(Body, -0.31869712141416456F, 0.0F, 0.0F);
            this.setRotateAngle(Chest, -0.7285004297824331F, 0.0F, 0.0F);
            this.setRotateAngle(Head, -0.4553564018453205F, 0.0F, 0.0F);
            this.setRotateAngle(Neck, 1.2292353921796064F, 0.0F, 0.0F);
            this.setRotateAngle(Tail1, 1.0016444577195458F, 0.40980330836826856F, 0.5918411493512771F);
            this.setRotateAngle(ThighLeft, -0.5462880558742251F, -0.36425021489121656F, 0.0F);
            this.setRotateAngle(ThighRight, -0.5462880558742251F, 0.36425021489121656F, 0.0F);
            this.Tail1.setPos(-0.3F, 1.0F, 3.2F);
            this.ThighLeft.setPos(1.7F, 1.3F, 4.4F);
            this.ThighRight.setPos(-1.7F, 1.3F, 4.4F);

        }

        @Override
        public void setLyingPose(BorderCollieEntity entity, float speed, float walkSpeed, float partialTick) {

        }

        @Override
        public void resetPose(BorderCollieEntity entity, float speed, float walkSpeed, float partialTick) {
            this.Chest.setPos(0.0F, 19.5F, -2.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.ArmLeft.setPos(1.7F, 0.7F, -0.5F);
            this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.ArmRight.setPos(-1.7F, 0.7F, -0.5F);
            this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
            this.Neck.setPos(0.0F, -1.3F, -0.7F);
            this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
            this.setRotateAngle(Body, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(Head, -0.6373942428283291F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 0.4F, 4.0F);
            this.setRotateAngle(Tail1, -0.7285004297824331F, 0.0F, 0.0F);
            this.ThighLeft.setPos(1.7F, 0.9F, 2.7F);
            this.setRotateAngle(ThighLeft, 0.0F, 0.0F, 0.0F);
            this.ThighRight.setPos(-1.7F, 0.9F, 2.7F);
            this.setRotateAngle(ThighRight, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(LegLeft, 0.4553564018453205F, 0.0F, 0.0F);
            this.setRotateAngle(LegRight, 0.4553564018453205F, 0.0F, 0.0F);
        }
    }
}
