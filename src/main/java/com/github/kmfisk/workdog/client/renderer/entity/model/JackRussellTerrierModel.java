package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.entity.JackRussellTerrierEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public abstract class JackRussellTerrierModel extends WorkDogModel<JackRussellTerrierEntity> {
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

    public static class Adult extends JackRussellTerrierModel {
        public ModelPart ArmBaseLeft;
        public ModelPart ArmBaseRight;
        public ModelPart ChestFur;
        public ModelPart Hips;
        public ModelPart BodyFur;
        public ModelPart handle;
        public ModelPart Saddlebag;
        public ModelPart UpperLegLeft;
        public ModelPart LowerLegLeft;
        public ModelPart UpperLegRight;
        public ModelPart LowerLegRight;
        public ModelPart Tail2;
        public ModelPart SaddlebagLatchL;
        public ModelPart SaddlebagLatchR;
        public ModelPart NeckLower;
        public ModelPart Collar;
        public ModelPart EyebrowLeft;
        public ModelPart EyebrowLeft_1;
        public ModelPart Muzzle;
        public ModelPart MoustacheLeft;
        public ModelPart MoustacheRight;
        public ModelPart Beard;
        public ModelPart Tongue;
        public ModelPart ForearmLeft;
        public ModelPart ForearmRight;
        
        public Adult(ModelPart root) {
            this.Chest = root.getChild("Chest");
            this.Body = this.Chest.getChild("Body");
            this.Tail1 = this.Hips.getChild("Tail1");
            this.LowerLegLeft = this.UpperLegLeft.getChild("LowerLegLeft");
            this.handle = this.Body.getChild("handle");
            this.ThighRight = this.Hips.getChild("ThighRight");
            this.Beard = this.Mouth.getChild("Beard");
            this.LowerLegRight = this.UpperLegRight.getChild("LowerLegRight");
            this.EyebrowLeft_1 = this.Head.getChild("EyebrowLeft_1");
            this.Tongue = this.Mouth.getChild("Tongue");
            this.ThighLeft = this.Hips.getChild("ThighLeft");
            this.HandRight = this.ForearmRight.getChild("HandRight");
            this.ArmRight = this.ArmBaseRight.getChild("ArmRight");
            this.Snout = this.Head.getChild("Snout");
            this.HandLeft = this.ForearmLeft.getChild("HandLeft");
            this.EarFlapLeft = this.EarLeft.getChild("EarFlapLeft");
            this.TopSnout = this.Snout.getChild("TopSnout");
            this.MoustacheLeft = this.Snout.getChild("MoustacheLeft");
            this.FootRight = this.LowerLegRight.getChild("FootRight");
            this.UpperLegLeft = this.ThighLeft.getChild("UpperLegLeft");
            this.EyebrowLeft = this.Head.getChild("EyebrowLeft");
            this.ArmBaseLeft = this.Chest.getChild("ArmBaseLeft");
            this.EarRight = this.Head.getChild("EarRight");
            this.NeckLower = this.Neck.getChild("NeckLower");
            this.UpperLegRight = this.ThighRight.getChild("UpperLegRight");
            this.Saddlebag = this.Body.getChild("Saddlebag");
            this.EarLeft = this.Head.getChild("EarLeft");
            this.SaddlebagLatchR = this.Saddlebag.getChild("SaddlebagLatchR");
            this.ArmLeft = this.ArmBaseLeft.getChild("ArmLeft");
            this.Neck = this.Chest.getChild("Neck");
            this.SaddlebagLatchL = this.Saddlebag.getChild("SaddlebagLatchL");
            this.Hips = this.Body.getChild("Hips");
            this.Tail2 = this.Tail1.getChild("Tail2");
            this.ForearmLeft = this.ArmLeft.getChild("ForearmLeft");
            this.BodyFur = this.Body.getChild("BodyFur");
            this.Head = this.Neck.getChild("Head");
            this.MoustacheRight = this.Snout.getChild("MoustacheRight");
            this.Mouth = this.Snout.getChild("Mouth");
            this.ForearmRight = this.ArmRight.getChild("ForearmRight");
            this.FootLeft = this.LowerLegLeft.getChild("FootLeft");
            this.ArmBaseRight = this.Chest.getChild("ArmBaseRight");
            this.ChestFur = this.Chest.getChild("ChestFur");
            this.Collar = this.Neck.getChild("Collar");
            this.Muzzle = this.Head.getChild("Muzzle");
            this.EarFlapRight = this.EarRight.getChild("EarFlapRight");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshDefinition = new MeshDefinition();
            PartDefinition partDefinition = meshDefinition.getRoot();

            partDefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 10).addBox(-2.5F, 0.0F, 0.0F, 5, 6, 5), PartPose.offsetAndRotation(0.0F, -3.0F, 1.7F, 0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(45, 0).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(0.0F, 1.2F, 2.0F, 1.0016444577195458F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("LowerLegLeft", CubeListBuilder.create().texOffs(28, 34).addBox(-1.0F, 0.0F, -2.0F, 2, 4, 2), PartPose.offsetAndRotation(0.0F, 3.0F, 2.5F, -0.6829473363053812F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(50, 24).addBox(-2.5F, -2.0F, 0.0F, 5, 2, 1), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.22759093446006054F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(34, 19).mirror(true).addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4), PartPose.offsetAndRotation(-1.9F, 1.3F, 1.1F, 0.18203784098300857F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Beard", CubeListBuilder.create().texOffs(0, 59).addBox(-1.0F, 0.0F, 0.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, 0.2F, -2.5F, 0.22759093446006054F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("LowerLegRight", CubeListBuilder.create().texOffs(36, 34).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 4, 2), PartPose.offsetAndRotation(0.0F, 3.0F, 2.5F, -0.6829473363053812F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EyebrowLeft_1", CubeListBuilder.create().texOffs(8, 58).addBox(-1.5F, -1.0F, 0.0F, 3, 1, 2), PartPose.offsetAndRotation(-1.9F, -1.2F, -2.7F, -0.045553093477052F, 0.27314402793711257F, -0.091106186954104F));
            partDefinition.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(15, 58).addBox(-1.0F, 0.0F, -3.0F, 2, 0, 3), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(20, 19).addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4), PartPose.offsetAndRotation(1.9F, 1.3F, 1.1F, 0.18203784098300857F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(34, 15).mirror(true).addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2), PartPose.offsetAndRotation(0.1F, 1.8F, 1.3F, 0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(34, 6).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 3, 2), PartPose.offsetAndRotation(0.0F, 3.0F, 1.0F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 49).addBox(-1.5F, 0.0F, -2.7F, 3, 2, 3), PartPose.offset(0.0F, 0.0F, -2.0F));
            partDefinition.addOrReplaceChild("HandLeft", CubeListBuilder.create().texOffs(22, 15).addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2), PartPose.offsetAndRotation(-0.1F, 1.8F, 1.3F, 0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarFlapLeft", CubeListBuilder.create().texOffs(20, 43).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.36425021489121656F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("TopSnout", CubeListBuilder.create().texOffs(0, 54).addBox(-1.0F, 0.0F, -2.7F, 2, 2, 3), PartPose.offsetAndRotation(0.0F, -0.5F, -0.2F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("MoustacheLeft", CubeListBuilder.create().texOffs(10, 53).addBox(-1.5F, 0.0F, 0.0F, 3, 2, 3), PartPose.offsetAndRotation(0.1F, 0.8F, -3.0F, 0.136659280431156F, 0.0F, -0.136659280431156F));
            partDefinition.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(42, 40).addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2), PartPose.offset(0.1F, 4.0F, -0.5F));
            partDefinition.addOrReplaceChild("UpperLegLeft", CubeListBuilder.create().texOffs(26, 28).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3), PartPose.offsetAndRotation(-0.1F, 5.0F, -1.5F, 0.6373942428283291F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EyebrowLeft", CubeListBuilder.create().texOffs(8, 58).mirror(true).addBox(-1.5F, -1.0F, 0.0F, 3, 1, 2), PartPose.offsetAndRotation(1.9F, -1.2F, -2.7F, -0.045553093477052F, -0.27314402793711257F, 0.091106186954104F));
            partDefinition.addOrReplaceChild("ArmBaseLeft", CubeListBuilder.create().texOffs(20, 0).addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3), PartPose.offsetAndRotation(1.7F, 1.0F, -0.1F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4), PartPose.offsetAndRotation(0.0F, 14.7F, -3.2F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(21, 39).mirror(true).addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1), PartPose.offsetAndRotation(-1.8F, -1.6F, 0.4F, 0.31869712141416456F, 0.0F, -0.18203784098300857F));
            partDefinition.addOrReplaceChild("NeckLower", CubeListBuilder.create().texOffs(16, 31).addBox(-1.5F, 0.0F, 0.0F, 3, 6, 2), PartPose.offsetAndRotation(0.0F, -3.8F, -1.8F, -0.22759093446006054F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("UpperLegRight", CubeListBuilder.create().texOffs(38, 28).mirror(true).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3), PartPose.offsetAndRotation(0.1F, 5.0F, -1.5F, 0.6373942428283291F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Saddlebag", CubeListBuilder.create().texOffs(22, 56).addBox(-3.5F, -2.0F, -2.0F, 7, 4, 4), PartPose.offset(0.0F, 1.5F, 5.0F));
            partDefinition.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(15, 39).addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1), PartPose.offsetAndRotation(1.8F, -1.6F, 0.4F, 0.31869712141416456F, 0.0F, 0.18203784098300857F));
            partDefinition.addOrReplaceChild("SaddlebagLatchR", CubeListBuilder.create().texOffs(18, 61).addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1), PartPose.offset(-3.5F, -1.0F, 0.0F));
            partDefinition.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(21, 6).addBox(-1.0F, 0.0F, -2.0F, 2, 3, 2), PartPose.offsetAndRotation(0.0F, 3.0F, 1.0F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 30).addBox(-2.0F, -4.0F, -2.0F, 4, 5, 4), PartPose.offsetAndRotation(0.0F, -1.0F, -0.5F, 0.6373942428283291F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("SaddlebagLatchL", CubeListBuilder.create().texOffs(18, 61).addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1), PartPose.offset(3.5F, -1.0F, 0.0F));
            partDefinition.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(0, 21).addBox(-3.0F, 0.0F, 0.0F, 6, 6, 3), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, -0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(53, 0).addBox(-1.0F, 0.0F, 0.0F, 2, 3, 2), PartPose.offsetAndRotation(0.0F, 2.5F, -1.0F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ForearmLeft", CubeListBuilder.create().texOffs(22, 11).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(-0.1F, 2.6F, -2.0F, -0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("BodyFur", CubeListBuilder.create().texOffs(44, 6).addBox(-2.0F, 0.0F, 0.0F, 4, 2, 5), PartPose.offsetAndRotation(0.0F, 5.5F, -1.0F, 0.22759093446006054F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 39).addBox(-2.5F, -2.5F, -2.5F, 5, 5, 5), PartPose.offsetAndRotation(0.0F, -3.7F, 0.0F, -0.5462880558742251F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("MoustacheRight", CubeListBuilder.create().texOffs(10, 53).mirror(true).addBox(-1.5F, 0.0F, 0.0F, 3, 2, 3), PartPose.offsetAndRotation(-0.1F, 0.8F, -3.0F, 0.136659280431156F, 0.0F, 0.136659280431156F));
            partDefinition.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(12, 49).addBox(-1.0F, -1.0F, -2.4F, 2, 1, 3), PartPose.offsetAndRotation(0.0F, 2.6F, 0.0F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ForearmRight", CubeListBuilder.create().texOffs(34, 11).mirror(true).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(0.1F, 2.6F, -2.0F, -0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(34, 40).addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2), PartPose.offset(-0.1F, 4.0F, -0.5F));
            partDefinition.addOrReplaceChild("ArmBaseRight", CubeListBuilder.create().texOffs(32, 0).mirror(true).addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3), PartPose.offsetAndRotation(-1.7F, 1.0F, -0.1F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ChestFur", CubeListBuilder.create().texOffs(47, 13).addBox(-1.5F, 0.0F, 0.0F, 3, 2, 3), PartPose.offsetAndRotation(0.0F, 2.4F, -1.7F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Collar", CubeListBuilder.create().texOffs(40, 50).addBox(-2.5F, 0.0F, 0.0F, 5, 1, 5), PartPose.offset(0.0F, -1.5F, -2.7F));
            partDefinition.addOrReplaceChild("Muzzle", CubeListBuilder.create().texOffs(23, 48).addBox(-2.0F, 0.0F, 0.0F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, -0.6F, -5.4F, 0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarFlapRight", CubeListBuilder.create().texOffs(28, 43).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.36425021489121656F, 0.0F, 0.0F));

            return LayerDefinition.create(meshDefinition, 64, 64);
        }

        @Override
        public void playIdleAnimation(JackRussellTerrierEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? 1.09F : 0.63F);
            this.Head.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.54F;
            if (!entity.isInSittingPose() && !entity.isLying()) {
                this.Tail1.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 1.0F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
                this.Tail2.zRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F;
            }
        }

        @Override
        public void playMovementAnimation(JackRussellTerrierEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.8f;
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
                this.ArmBaseLeft.z = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + -0.1F;
                this.ArmBaseRight.z = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + -0.1F;
                this.Neck.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 0.63F;
                this.Head.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + -0.54F;
                this.ThighLeft.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.18F;
                this.UpperLegLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + 0.63F;
                this.LowerLegLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + -0.68F;
                this.FootLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F;
                this.ThighLeft.y = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 1.3F;
                this.ThighLeft.z = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + 1.1F;
                this.ThighRight.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.18F;
                this.UpperLegRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + 0.63F;
                this.LowerLegRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + -0.68F;
                this.FootRight.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F;
                this.ThighRight.y = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 1.3F;
                this.ThighRight.z = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 1.1F;
                this.Chest.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.05F) * limbSwingAmount * 0.5F + -0.05F;
                this.Body.xRot = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 0.04F;
                this.Hips.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + -0.15F;
                this.Neck.z = Mth.cos(5.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.07F) * limbSwingAmount * 0.5F + -0.5F;
                this.Tail1.xRot = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.5F) * limbSwingAmount * 0.5F + 1.0F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
                this.Chest.y = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.09F) * limbSwingAmount * 0.5F + 14.7F;
            }
        }

        @Override
        public void setSittingPose(JackRussellTerrierEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmBaseLeft.setPos(1.7F, 0.3F, -0.5F);
            this.ArmBaseRight.setPos(-1.7F, 0.3F, -0.5F);
            this.Body.setPos(0.0F, -2.5F, 1.7F);
            this.Chest.setPos(0.0F, 15.7F, -3.2F);
            this.FootLeft.setPos(-0.1F, 3.8F, -1.0F);
            this.FootRight.setPos(0.1F, 3.8F, -1.0F);
            this.ForearmLeft.setPos(0.0F, 2.6F, -2.0F);
            this.ForearmRight.setPos(0.0F, 2.6F, -2.0F);
            this.LowerLegLeft.setPos(0.5F, 4.0F, 2.5F);
            this.LowerLegRight.setPos(-0.5F, 4.0F, 2.5F);
            this.setRotateAngle(ArmBaseLeft, 0.7285004297824331F, 0.0F, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.7285004297824331F, 0.0F, 0.0F);
            this.setRotateAngle(Body, -0.045553093477052F, 0.0F, 0.0F);
            this.setRotateAngle(Chest, -0.5918411493512771F, 0.0F, 0.0F);
            this.setRotateAngle(FootLeft, 1.6845917940249266F, 0.0F, 0.0F);
            this.setRotateAngle(FootRight, 1.6845917940249266F, 0.0F, 0.0F);
            this.setRotateAngle(Hips, -0.27314402793711257F, 0.0F, 0.0F);
            this.setRotateAngle(LowerLegLeft, -1.730144887501979F, -0.136659280431156F, 0.0F);
            this.setRotateAngle(LowerLegRight, -1.730144887501979F, 0.136659280431156F, 0.0F);
            this.setRotateAngle(Neck, 1.0927506446736497F, 0.0F, 0.0F);
            this.setRotateAngle(Tail1, 2.231054382824351F, 0.0F, 0.0F);
            this.setRotateAngle(ThighLeft, -1.2747884856566583F, -0.136659280431156F, 0.0F);
            this.setRotateAngle(ThighRight, -1.2747884856566583F, 0.136659280431156F, 0.0F);
            this.setRotateAngle(UpperLegLeft, 2.276432943376204F, 0.0F, 0.0F);
            this.setRotateAngle(UpperLegRight, 2.276432943376204F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 3.1F, 3.0F);
            this.ThighLeft.setPos(1.9F, 2.9F, 3.7F);
            this.ThighRight.setPos(-1.9F, 2.9F, 3.7F);
            this.UpperLegLeft.setPos(-0.1F, 4.9F, 1.5F);
            this.UpperLegRight.setPos(0.1F, 4.9F, 1.5F);

        }

        @Override
        public void setLyingPose(JackRussellTerrierEntity entity, float speed, float walkSpeed, float partialTick) {
            this.FootRight.setPos(0.1F, 4.0F, -0.5F);
            this.setRotateAngle(FootRight, 1.8212510744560826F, 0.0F, 0.0F);
            this.MoustacheLeft.setPos(0.1F, 0.8F, -3.0F);
            this.setRotateAngle(MoustacheLeft, 0.136659280431156F, 0.0F, -0.136659280431156F);
            this.SaddlebagLatchL.setPos(3.5F, -1.0F, 0.0F);
            this.ForearmRight.setPos(0.1F, 2.6F, -2.0F);
            this.setRotateAngle(ForearmRight, 0.5918411493512771F, 0.0F, 0.0F);
            this.Hips.setPos(0.0F, 0.0F, 3.9F);
            this.setRotateAngle(Hips, 0.18203784098300857F, 0.0F, 0.0F);
            this.Saddlebag.setPos(0.0F, 1.5F, 5.0F);
            this.setRotateAngle(Saddlebag, 0.045553093477052F, 0.0F, 0.0F);
            this.ForearmLeft.setPos(-0.1F, 3.0F, -2.0F);
            this.setRotateAngle(ForearmLeft, 0.5009094953223726F, 0.0F, 0.0F);
            this.Snout.setPos(0.0F, 0.0F, -2.0F);
            this.EyebrowLeft_1.setPos(-1.9F, -1.2F, -2.7F);
            this.setRotateAngle(EyebrowLeft_1, -0.045553093477052F, 0.27314402793711257F, -0.091106186954104F);
            this.Tail1.setPos(0.0F, 1.2F, 2.0F);
            this.setRotateAngle(Tail1, 1.0016444577195458F, -0.40980330836826856F, 0.0F);
            this.ArmLeft.setPos(0.0F, 4.7F, 1.0F);
            this.setRotateAngle(ArmLeft, -1.4570008595648662F, 0.0F, 0.0F);
            this.ChestFur.setPos(0.0F, 2.4F, -1.7F);
            this.setRotateAngle(ChestFur, 0.136659280431156F, 0.0F, 0.0F);
            this.Chest.setPos(0.0F, 21.7F, -3.2F);
            this.setRotateAngle(Chest, 0.0F, 0.0F, -1.593485607070823F);
            this.Beard.setPos(0.0F, 0.2F, -2.5F);
            this.setRotateAngle(Beard, 0.22759093446006054F, 0.0F, 0.0F);
            this.EarRight.setPos(-1.8F, -1.6F, 0.4F);
            this.setRotateAngle(EarRight, 0.31869712141416456F, -0.045553093477052F, 0.18203784098300857F);
            this.TopSnout.setPos(0.0F, -0.5F, -0.2F);
            this.setRotateAngle(TopSnout, 0.136659280431156F, 0.0F, 0.0F);
            this.NeckLower.setPos(0.0F, -3.8F, -1.8F);
            this.setRotateAngle(NeckLower, -0.22759093446006054F, 0.0F, 0.0F);
            this.EarLeft.setPos(1.2F, -2.2F, 0.3F);
            this.setRotateAngle(EarLeft, 0.31869712141416456F, 0.27314402793711257F, -0.22759093446006054F);
            this.EarFlapLeft.setPos(0.0F, -2.0F, 1.0F);
            this.setRotateAngle(EarFlapLeft, -0.36425021489121656F, 0.0F, 0.0F);
            this.LowerLegLeft.setPos(0.0F, 3.0F, 2.5F);
            this.setRotateAngle(LowerLegLeft, -1.1383037381507017F, 0.0F, 0.0F);
            this.HandRight.setPos(0.1F, 1.8F, 1.3F);
            this.setRotateAngle(HandRight, 1.0927506446736497F, 0.0F, 0.0F);
            this.Body.setPos(0.0F, -3.0F, 1.1F);
            this.setRotateAngle(Body, 0.136659280431156F, 0.0F, 0.0F);
            this.Neck.setPos(0.0F, -1.0F, -0.5F);
            this.setRotateAngle(Neck, 0.6373942428283291F, 0.0F, 0.0F);
            this.ArmBaseLeft.setPos(1.7F, 1.0F, -0.1F);
            this.setRotateAngle(ArmBaseLeft, 0.091106186954104F, 0.045553093477052F, 0.5009094953223726F);
            this.FootLeft.setPos(-0.1F, 4.0F, -0.5F);
            this.setRotateAngle(FootLeft, 0.8651597102135892F, 0.0F, 0.0F);
            this.HandLeft.setPos(-0.1F, 1.8F, 1.3F);
            this.setRotateAngle(HandLeft, 1.730144887501979F, 0.0F, 0.0F);
            this.ThighLeft.setPos(2.4F, 2.4F, 1.0F);
            this.setRotateAngle(ThighLeft, 0.31869712141416456F, 0.045553093477052F, 0.22759093446006054F);
            this.LowerLegRight.setPos(0.0F, 3.0F, 2.5F);
            this.setRotateAngle(LowerLegRight, -1.2747884856566583F, 0.0F, 0.0F);
            this.handle.setPos(0.0F, 0.0F, 1.0F);
            this.setRotateAngle(handle, -0.22759093446006054F, 0.0F, 0.0F);
            this.Tail2.setPos(0.0F, 2.5F, -1.0F);
            this.setRotateAngle(Tail2, 0.136659280431156F, 0.0F, 0.0F);
            this.Collar.setPos(0.0F, -1.5F, -2.7F);
            this.EyebrowLeft.setPos(1.9F, -1.2F, -2.7F);
            this.setRotateAngle(EyebrowLeft, -0.045553093477052F, -0.27314402793711257F, 0.091106186954104F);
            this.UpperLegRight.setPos(0.1F, 5.0F, -1.5F);
            this.setRotateAngle(UpperLegRight, 0.8651597102135892F, 0.0F, 0.0F);
            this.Tongue.setPos(0.0F, -1.0F, 1.0F);
            this.setRotateAngle(Tongue, -0.091106186954104F, 0.0F, 0.0F);
            this.EarFlapRight.setPos(0.0F, -2.0F, 1.0F);
            this.setRotateAngle(EarFlapRight, -1.0927506446736497F, 0.0F, 0.0F);
            this.BodyFur.setPos(0.0F, 5.5F, -1.0F);
            this.setRotateAngle(BodyFur, 0.22759093446006054F, 0.0F, 0.0F);
            this.Head.setPos(0.0F, -3.7F, 0.0F);
            this.setRotateAngle(Head, -0.5462880558742251F, 0.0F, 0.0F);
            this.SaddlebagLatchR.setPos(-3.5F, -1.0F, 0.0F);
            this.Muzzle.setPos(0.0F, -0.6F, -5.4F);
            this.setRotateAngle(Muzzle, 0.091106186954104F, 0.0F, 0.0F);
            this.MoustacheRight.setPos(-0.1F, 0.8F, -3.0F);
            this.setRotateAngle(MoustacheRight, 0.136659280431156F, 0.0F, 0.136659280431156F);
            this.ArmRight.setPos(0.0F, 3.0F, 1.0F);
            this.setRotateAngle(ArmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.ArmBaseRight.setPos(-1.7F, 1.0F, -0.1F);
            this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.0F, 0.0F);
            this.ThighRight.setPos(-1.9F, 1.3F, 1.1F);
            this.setRotateAngle(ThighRight, 0.36425021489121656F, 0.0F, 0.0F);
            this.UpperLegLeft.setPos(-0.1F, 4.7F, -2.2F);
            this.setRotateAngle(UpperLegLeft, 1.2292353921796064F, -0.22759093446006054F, 0.0F);
            this.Mouth.setPos(0.0F, 2.6F, 0.0F);
            this.setRotateAngle(Mouth, -0.045553093477052F, 0.0F, 0.0F);
        }

        @Override
        public void resetPose(JackRussellTerrierEntity entity, float speed, float walkSpeed, float partialTick) {
            this.Body.setPos(0.0F, -3.0F, 1.7F);
            this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 1.2F, 2.0F);
            this.setRotateAngle(Tail1, 1.0016444577195458F, 0.0F, 0.0F);
            this.LowerLegLeft.setPos(0.0F, 3.0F, 2.5F);
            this.setRotateAngle(LowerLegLeft, -0.6829473363053812F, 0.0F, 0.0F);
            this.handle.setPos(0.0F, 0.0F, 1.0F);
            this.setRotateAngle(handle, -0.22759093446006054F, 0.0F, 0.0F);
            this.ThighRight.setPos(-1.9F, 1.3F, 1.1F);
            this.setRotateAngle(ThighRight, 0.18203784098300857F, 0.0F, 0.0F);
            this.Beard.setPos(0.0F, 0.2F, -2.5F);
            this.setRotateAngle(Beard, 0.22759093446006054F, 0.0F, 0.0F);
            this.LowerLegRight.setPos(0.0F, 3.0F, 2.5F);
            this.setRotateAngle(LowerLegRight, -0.6829473363053812F, 0.0F, 0.0F);
            this.EyebrowLeft_1.setPos(-1.9F, -1.2F, -2.7F);
            this.setRotateAngle(EyebrowLeft_1, -0.045553093477052F, 0.27314402793711257F, -0.091106186954104F);
            this.Tongue.setPos(0.0F, -1.0F, 1.0F);
            this.setRotateAngle(Tongue, -0.091106186954104F, 0.0F, 0.0F);
            this.ThighLeft.setPos(1.9F, 1.3F, 1.1F);
            this.setRotateAngle(ThighLeft, 0.18203784098300857F, 0.0F, 0.0F);
            this.HandRight.setPos(0.1F, 1.8F, 1.3F);
            this.setRotateAngle(HandRight, 0.091106186954104F, 0.0F, 0.0F);
            this.ArmRight.setPos(0.0F, 3.0F, 1.0F);
            this.setRotateAngle(ArmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.Snout.setPos(0.0F, 0.0F, -2.0F);
            this.HandLeft.setPos(-0.1F, 1.8F, 1.3F);
            this.setRotateAngle(HandLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.EarFlapLeft.setPos(0.0F, -2.0F, 1.0F);
            this.setRotateAngle(EarFlapLeft, -0.36425021489121656F, 0.0F, 0.0F);
            this.TopSnout.setPos(0.0F, -0.5F, -0.2F);
            this.setRotateAngle(TopSnout, 0.136659280431156F, 0.0F, 0.0F);
            this.MoustacheLeft.setPos(0.1F, 0.8F, -3.0F);
            this.setRotateAngle(MoustacheLeft, 0.136659280431156F, 0.0F, -0.136659280431156F);
            this.FootRight.setPos(0.1F, 4.0F, -0.5F);
            this.setRotateAngle(FootRight, 0F, 0F, 0F);
            this.UpperLegLeft.setPos(-0.1F, 5.0F, -1.5F);
            this.setRotateAngle(UpperLegLeft, 0.6373942428283291F, 0.0F, 0.0F);
            this.EyebrowLeft.setPos(1.9F, -1.2F, -2.7F);
            this.setRotateAngle(EyebrowLeft, -0.045553093477052F, -0.27314402793711257F, 0.091106186954104F);
            this.ArmBaseLeft.setPos(1.7F, 1.0F, -0.1F);
            this.setRotateAngle(ArmBaseLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.Chest.setPos(0.0F, 14.7F, -3.2F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.EarRight.setPos(-1.8F, -1.6F, 0.4F);
            this.setRotateAngle(EarRight, 0.31869712141416456F, 0.0F, -0.18203784098300857F);
            this.NeckLower.setPos(0.0F, -3.8F, -1.8F);
            this.setRotateAngle(NeckLower, -0.22759093446006054F, 0.0F, 0.0F);
            this.UpperLegRight.setPos(0.1F, 5.0F, -1.5F);
            this.setRotateAngle(UpperLegRight, 0.6373942428283291F, 0.0F, 0.0F);
            this.Saddlebag.setPos(0.0F, 1.5F, 5.0F);
            this.EarLeft.setPos(1.8F, -1.6F, 0.4F);
            this.setRotateAngle(EarLeft, 0.31869712141416456F, 0.0F, 0.18203784098300857F);
            this.SaddlebagLatchR.setPos(-3.5F, -1.0F, 0.0F);
            this.ArmLeft.setPos(0.0F, 3.0F, 1.0F);
            this.setRotateAngle(ArmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.Neck.setPos(0.0F, -1.0F, -0.5F);
            this.setRotateAngle(Neck, 0.6373942428283291F, 0.0F, 0.0F);
            this.SaddlebagLatchL.setPos(3.5F, -1.0F, 0.0F);
            this.Hips.setPos(0.0F, 0.0F, 5.0F);
            this.setRotateAngle(Hips, -0.136659280431156F, 0.0F, 0.0F);
            this.Tail2.setPos(0.0F, 2.5F, -1.0F);
            this.setRotateAngle(Tail2, 0.136659280431156F, 0.0F, 0.0F);
            this.ForearmLeft.setPos(-0.1F, 2.6F, -2.0F);
            this.setRotateAngle(ForearmLeft, -0.136659280431156F, 0.0F, 0.0F);
            this.BodyFur.setPos(0.0F, 5.5F, -1.0F);
            this.setRotateAngle(BodyFur, 0.22759093446006054F, 0.0F, 0.0F);
            this.Head.setPos(0.0F, -3.7F, 0.0F);
            this.setRotateAngle(Head, -0.5462880558742251F, 0.0F, 0.0F);
            this.MoustacheRight.setPos(-0.1F, 0.8F, -3.0F);
            this.setRotateAngle(MoustacheRight, 0.136659280431156F, 0.0F, 0.136659280431156F);
            this.Mouth.setPos(0.0F, 2.6F, 0.0F);
            this.setRotateAngle(Mouth, -0.045553093477052F, 0.0F, 0.0F);
            this.ForearmRight.setPos(0.1F, 2.6F, -2.0F);
            this.setRotateAngle(ForearmRight, -0.136659280431156F, 0.0F, 0.0F);
            this.FootLeft.setPos(-0.1F, 4.0F, -0.5F);
            this.setRotateAngle(FootLeft, 0F, 0F, 0F);
            this.ArmBaseRight.setPos(-1.7F, 1.0F, -0.1F);
            this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.0F, 0.0F);
            this.ChestFur.setPos(0.0F, 2.4F, -1.7F);
            this.setRotateAngle(ChestFur, 0.136659280431156F, 0.0F, 0.0F);
            this.Collar.setPos(0.0F, -1.5F, -2.7F);
            this.Muzzle.setPos(0.0F, -0.6F, -5.4F);
            this.setRotateAngle(Muzzle, 0.091106186954104F, 0.0F, 0.0F);
            this.EarFlapRight.setPos(0.0F, -2.0F, 1.0F);
            this.setRotateAngle(EarFlapRight, -0.36425021489121656F, 0.0F, 0.0F);
        }
    }

    public static class Baby extends JackRussellTerrierModel {
        public ModelPart LegLeft;
        public ModelPart LegRight;

        public Baby(ModelPart root) {
            this.Chest = root.getChild("Chest");
            this.ThighLeft = this.Body.getChild("ThighLeft");
            this.EarRight = this.Head.getChild("EarRight");
            this.Body = this.Chest.getChild("Body");
            this.ArmRight = this.Chest.getChild("ArmRight");
            this.Head = this.Neck.getChild("Head");
            this.EarLeft = this.Head.getChild("EarLeft");
            this.ArmLeft = this.Chest.getChild("ArmLeft");
            this.HandRight = this.ArmRight.getChild("HandRight");
            this.Snout = this.Head.getChild("Snout");
            this.LegRight = this.ThighRight.getChild("LegRight");
            this.LegLeft = this.ThighLeft.getChild("LegLeft");
            this.FootRight = this.LegRight.getChild("FootRight");
            this.TopSnout = this.Snout.getChild("TopSnout");
            this.EarFlapLeft = this.EarLeft.getChild("EarFlapLeft");
            this.Tail1 = this.Body.getChild("Tail1");
            this.EarFlapRight = this.EarRight.getChild("EarFlapRight");
            this.Mouth = this.Snout.getChild("Mouth");
            this.HandLeft = this.ArmLeft.getChild("HandLeft");
            this.Neck = this.Chest.getChild("Neck");
            this.ThighRight = this.Body.getChild("ThighRight");
            this.FootLeft = this.LegLeft.getChild("FootLeft");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshDefinition = new MeshDefinition();
            PartDefinition partDefinition = meshDefinition.getRoot();

            partDefinition.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3), PartPose.offset(1.7F, 0.9F, 2.7F));
            partDefinition.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(14, 12).mirror(true).addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1), PartPose.offsetAndRotation(-0.9F, -0.9F, 0.4F, 0.136659280431156F, 0.091106186954104F, -0.31869712141416456F));
            partDefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, 0.0F, 0.0F, 4, 5, 4), PartPose.offset(0.0F, -2.5F, 2.0F));
            partDefinition.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(32, 15).mirror(true).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(-1.7F, 0.7F, -0.5F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, -1.8F, -0.2F, -0.6373942428283291F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(10, 9).addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1), PartPose.offsetAndRotation(0.9F, -0.9F, 0.4F, 0.136659280431156F, -0.091106186954104F, 0.31869712141416456F));
            partDefinition.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(24, 15).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(1.7F, 0.7F, -0.5F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(32, 20).mirror(true).addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.1F, 3.5F, 0.6F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, 0.0F, -2.0F, 3, 2, 2), PartPose.offset(0.0F, 0.2F, -1.3F));
            partDefinition.addOrReplaceChild("LegRight", CubeListBuilder.create().texOffs(45, 7).mirror(true).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(0.1F, 4.0F, -1.1F, 0.4553564018453205F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -2.0F, 5, 5, 4), PartPose.offsetAndRotation(0.0F, 19.5F, -2.0F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("LegLeft", CubeListBuilder.create().texOffs(34, 7).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(-0.1F, 4.0F, -1.1F, 0.4553564018453205F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(45, 11).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.1F, 2.0F, 2.0F, -0.40980330836826856F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("TopSnout", CubeListBuilder.create().texOffs(8, 28).addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2), PartPose.offsetAndRotation(0.0F, -0.4F, -0.1F, 0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarFlapLeft", CubeListBuilder.create().texOffs(16, 9).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(27, 24).addBox(-1.0F, -1.0F, -1.0F, 2, 2, 3), PartPose.offsetAndRotation(0.0F, 0.0F, 3.3F, 1.3203415791337103F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarFlapRight", CubeListBuilder.create().texOffs(20, 12).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(10, 25).addBox(-1.0F, -1.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, 2.1F, 0.2F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("HandLeft", CubeListBuilder.create().texOffs(24, 20).addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(-0.1F, 3.5F, 0.6F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, -2.4F, -2.0F, 3, 4, 4), PartPose.offsetAndRotation(0.0F, -1.5F, -1.1F, 0.7285004297824331F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(44, 0).mirror(true).addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3), PartPose.offset(-1.7F, 0.9F, 2.7F));
            partDefinition.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(34, 11).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(-0.1F, 2.0F, 2.0F, -0.40980330836826856F, 0.0F, 0.0F));

            return LayerDefinition.create(meshDefinition, 64, 32);
        }

        @Override
        public void playIdleAnimation(JackRussellTerrierEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? 1.23F : 0.72F);
            this.Head.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? -0.45F : -0.63F);
            if (!entity.isInSittingPose() && !entity.isLying()) {
                this.Tail1.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 1.32F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
            }
        }

        @Override
        public void playMovementAnimation(JackRussellTerrierEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
        public void setSittingPose(JackRussellTerrierEntity entity, float speed, float walkSpeed, float partialTick) {
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
        public void setLyingPose(JackRussellTerrierEntity entity, float speed, float walkSpeed, float partialTick) {

        }

        @Override
        public void resetPose(JackRussellTerrierEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmLeft.setPos(1.7F, 0.7F, -0.5F);
            this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.ArmRight.setPos(-1.7F, 0.7F, -0.5F);
            this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
            this.Neck.setPos(0.0F, -1.5F, -1.1F);
            this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
            this.setRotateAngle(Body, 0.0F, 0.0F, 0.0F);
            this.Chest.setPos(0.0F, 19.5F, -2.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.setRotateAngle(Head, -0.6373942428283291F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 0.0F, 3.3F);
            this.setRotateAngle(Tail1, 1.3203415791337103F, 0.0F, 0.0F);
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
