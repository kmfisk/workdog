package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.BostonTerrierEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public abstract class BostonTerrierModel extends WorkDogModel<BostonTerrierEntity> {
    public static ModelLayerLocation ADULT_LAYER = new ModelLayerLocation(new ResourceLocation(WorkDog.MOD_ID, "boston_terrier"), "adult");
    public static ModelLayerLocation EQUIPMENT_LAYER = new ModelLayerLocation(new ResourceLocation(WorkDog.MOD_ID, "boston_terrier"), "equipment");
    public static ModelLayerLocation BABY_LAYER = new ModelLayerLocation(new ResourceLocation(WorkDog.MOD_ID, "boston_terrier"), "baby");
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
        
        public Adult(ModelPart root) {
            this.Chest = root.getChild("Chest");
            this.ArmBaseLeft = this.Chest.getChild("ArmBaseLeft");
            this.ArmLeft = this.ArmBaseLeft.getChild("ArmLeft");
            this.ForearmLeft = this.ArmLeft.getChild("ForearmLeft");
            this.HandLeft = this.ForearmLeft.getChild("HandLeft");

            this.Body = this.Chest.getChild("Body");
            this.Hips = this.Body.getChild("Hips");
            this.ThighRight = this.Hips.getChild("ThighRight");
            this.UpperLegRight = this.ThighRight.getChild("UpperLegRight");
            this.LowerLegRight = this.UpperLegRight.getChild("LowerLegRight");
            this.FootRight = this.LowerLegRight.getChild("FootRight");

            this.ThighLeft = this.Hips.getChild("ThighLeft");
            this.UpperLegLeft = this.ThighLeft.getChild("UpperLegLeft");
            this.LowerLegLeft = this.UpperLegLeft.getChild("LowerLegLeft");
            this.FootLeft = this.LowerLegLeft.getChild("FootLeft");

            this.Neck = this.Chest.getChild("Neck");
            this.NeckLower = this.Neck.getChild("NeckLower");

            this.Head = this.Neck.getChild("Head");
            this.MuzzleLeft = this.Head.getChild("MuzzleLeft");
            this.MuzzleRight = this.MuzzleLeft.getChild("MuzzleRight");

            this.Snout = this.Head.getChild("Snout");
            this.TopSnout = this.Snout.getChild("TopSnout");

            this.Mouth = this.Snout.getChild("Mouth");

            this.EarLeft = this.Head.getChild("EarLeft");

            this.EarRight = this.Head.getChild("EarRight");

            this.CollarLeft = this.Neck.getChild("CollarLeft");
            this.CollarRight = this.CollarLeft.getChild("CollarRight");

            this.ArmBaseRight = this.Chest.getChild("ArmBaseRight");
            this.ArmRight = this.ArmBaseRight.getChild("ArmRight");
            this.ForearmRight = this.ArmRight.getChild("ForearmRight");
            this.HandRight = this.ForearmRight.getChild("HandRight");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshDefinition = new MeshDefinition();
            PartDefinition partDefinition = meshDefinition.getRoot();

            PartDefinition Chest = partDefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4), PartPose.offsetAndRotation(0.0F, 15.6F, -3.7F, -0.1153662635568252F, 0.0F, 0.0F));
            PartDefinition Body = Chest.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 10).addBox(-2.5F, 0.0F, 0.0F, 5, 6, 5), PartPose.offsetAndRotation(0.0F, -3.0F, 1.7F, 0.045553093477052F, 0.0F, 0.0F));
            PartDefinition Hips = Body.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(0, 21).addBox(-3.0F, 0.0F, 0.0F, 6, 6, 3), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition ThighRight = Hips.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(33, 19).mirror(true).addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3), PartPose.offsetAndRotation(-2.1F, 2.5F, 1.6F, 0.136659280431156F, 0.0F, 0.0F));
            PartDefinition UpperLegRight = ThighRight.addOrReplaceChild("UpperLegRight", CubeListBuilder.create().texOffs(35, 26).mirror(true).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 2), PartPose.offsetAndRotation(0.1F, 3.7F, -1.2F, 0.6373942428283291F, 0.0F, 0.0F));
            PartDefinition ArmBaseLeft = Chest.addOrReplaceChild("ArmBaseLeft", CubeListBuilder.create().texOffs(20, 0).addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3), PartPose.offsetAndRotation(2.0F, 0.5F, 0.2F, 0.136659280431156F, 0.0F, 0.0F));
            PartDefinition ArmLeft = ArmBaseLeft.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(22, 7).addBox(-1.0F, -0.2F, -2.0F, 2, 2, 2), PartPose.offset(0.0F, 4.0F, 1.0F));
            PartDefinition ForearmLeft = ArmLeft.addOrReplaceChild("ForearmLeft", CubeListBuilder.create().texOffs(22, 11).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(0.0F, 1.6F, -2.0F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition HandLeft = ForearmLeft.addOrReplaceChild("HandLeft", CubeListBuilder.create().texOffs(22, 15).addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2), PartPose.offset(-0.1F, 1.3F, 1.4F));
            PartDefinition ArmBaseRight = Chest.addOrReplaceChild("ArmBaseRight", CubeListBuilder.create().texOffs(32, 0).mirror(true).addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3), PartPose.offsetAndRotation(-2.0F, 0.5F, 0.2F, 0.136659280431156F, 0.0F, 0.0F));
            PartDefinition ArmRight = ArmBaseRight.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(34, 7).mirror(true).addBox(-1.0F, -0.2F, -2.0F, 2, 2, 2), PartPose.offset(0.0F, 4.0F, 1.0F));
            PartDefinition ForearmRight = ArmRight.addOrReplaceChild("ForearmRight", CubeListBuilder.create().texOffs(34, 11).mirror(true).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(0.0F, 1.6F, -2.0F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 30).addBox(-2.0F, -4.0F, -2.0F, 4, 5, 4), PartPose.offsetAndRotation(0.0F, -1.1F, -1.5F, 0.6829473363053812F, 0.0F, 0.0F));
            PartDefinition NeckLower = Neck.addOrReplaceChild("NeckLower", CubeListBuilder.create().texOffs(16, 31).addBox(-1.5F, 0.0F, 0.0F, 3, 6, 2), PartPose.offsetAndRotation(0.0F, -3.8F, -2.1F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 39).addBox(-2.5F, -2.5F, -2.5F, 5, 6, 5), PartPose.offsetAndRotation(0.0F, -3.3F, -0.6F, -0.40980330836826856F, 0.0F, 0.0F));
            PartDefinition MuzzleLeft = Head.addOrReplaceChild("MuzzleLeft", CubeListBuilder.create().texOffs(23, 48).addBox(-1.9F, 0.0F, 0.0F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, 0.1F, -5.4F, 0.091106186954104F, 0.0F, 0.0F));
            PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 50).addBox(-2.0F, 0.0F, 0.0F, 4, 3, 2), PartPose.offsetAndRotation(0.0F, 0.1F, -3.5F, -0.136659280431156F, 0.0F, 0.0F));
            PartDefinition TopSnout = Snout.addOrReplaceChild("TopSnout", CubeListBuilder.create().texOffs(0, 55).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(0.0F, 0.0F, -0.4F, 0.31869712141416456F, 0.0F, 0.0F));
            PartDefinition ThighLeft = Hips.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(21, 19).addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3), PartPose.offsetAndRotation(2.1F, 2.5F, 1.6F, 0.136659280431156F, 0.0F, 0.0F));
            PartDefinition UpperLegLeft = ThighLeft.addOrReplaceChild("UpperLegLeft", CubeListBuilder.create().texOffs(25, 26).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 2), PartPose.offsetAndRotation(-0.1F, 3.7F, -1.2F, 0.6373942428283291F, 0.0F, 0.0F));
            PartDefinition MuzzleRight = MuzzleLeft.addOrReplaceChild("MuzzleRight", CubeListBuilder.create().texOffs(23, 48).addBox(-2.1F, 0.0F, 0.0F, 4, 4, 4), PartPose.offset(0.0F, 0.0F, 0.0F));
            PartDefinition EarLeft = Head.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(20, 43).addBox(-1.0F, -2.5F, -0.5F, 3, 4, 1), PartPose.offsetAndRotation(1.2F, -2.4F, 1.4F, 0.136659280431156F, 0.0F, 0.22759093446006054F));
            PartDefinition LowerLegLeft = UpperLegLeft.addOrReplaceChild("LowerLegLeft", CubeListBuilder.create().texOffs(27, 31).addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2), PartPose.offsetAndRotation(0.0F, 3.0F, 2.0F, -0.5918411493512771F, 0.0F, 0.0F));
            PartDefinition Mouth = Snout.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(12, 50).addBox(-1.5F, 0.0F, -2.0F, 3, 1, 2), PartPose.offsetAndRotation(0.0F, 2.4F, 2.3F, -0.136659280431156F, 0.0F, 0.0F));
            PartDefinition FootLeft = LowerLegLeft.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(27, 36).addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2), PartPose.offset(-0.1F, 2.2F, -0.7F));
            PartDefinition CollarLeft = Neck.addOrReplaceChild("CollarLeft", CubeListBuilder.create().texOffs(40, 50).addBox(-2.5F, 0.0F, 0.0F, 5, 1, 5), PartPose.offsetAndRotation(0.1F, 0.2F, -3.1F, 0.18203784098300857F, 0.0F, 0.0F));
            PartDefinition LowerLegRight = UpperLegRight.addOrReplaceChild("LowerLegRight", CubeListBuilder.create().texOffs(35, 31).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2), PartPose.offsetAndRotation(0.0F, 3.0F, 2.0F, -0.5918411493512771F, 0.0F, 0.0F));
            PartDefinition FootRight = LowerLegRight.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(35, 36).mirror(true).addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2), PartPose.offset(0.1F, 2.2F, -0.7F));
            PartDefinition EarRight = Head.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(28, 43).mirror(true).addBox(-2.0F, -2.5F, -0.5F, 3, 4, 1), PartPose.offsetAndRotation(-1.2F, -2.4F, 1.4F, 0.136659280431156F, 0.0F, -0.22759093446006054F));
            PartDefinition HandRight = ForearmRight.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(34, 15).mirror(true).addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2), PartPose.offset(0.1F, 1.3F, 1.4F));
            PartDefinition CollarRight = CollarLeft.addOrReplaceChild("CollarRight", CubeListBuilder.create().texOffs(40, 50).addBox(-2.5F, 0.0F, 0.0F, 5, 1, 5), PartPose.offset(-0.2F, 0.0F, 0.0F));

            return LayerDefinition.create(meshDefinition, 64, 64);
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

        public Baby(ModelPart root) {
            this.Chest = root.getChild("Chest");
            this.Neck = this.Chest.getChild("Neck");
            this.Head = this.Neck.getChild("Head");
            this.EarLeft = this.Head.getChild("EarLeft");
            this.EarFlapLeft = this.EarLeft.getChild("EarFlapLeft");

            this.EarRight = this.Head.getChild("EarRight");
            this.EarFlapRight = this.EarRight.getChild("EarFlapRight");

            this.Snout = this.Head.getChild("Snout");
            this.TopSnout = this.Snout.getChild("TopSnout");

            this.Mouth = this.Snout.getChild("Mouth");

            this.ArmRight = this.Chest.getChild("ArmRight");
            this.HandRight = this.ArmRight.getChild("HandRight");

            this.ArmLeft = this.Chest.getChild("ArmLeft");
            this.HandLeft = this.ArmLeft.getChild("HandLeft");

            this.Body = this.Chest.getChild("Body");
            this.ThighRight = this.Body.getChild("ThighRight");
            this.LegRight = this.ThighRight.getChild("LegRight");
            this.FootRight = this.LegRight.getChild("FootRight");

            this.ThighLeft = this.Body.getChild("ThighLeft");
            this.LegLeft = this.ThighLeft.getChild("LegLeft");
            this.FootLeft = this.LegLeft.getChild("FootLeft");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshDefinition = new MeshDefinition();
            PartDefinition partDefinition = meshDefinition.getRoot();

            PartDefinition Chest = partDefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -2.0F, 5, 5, 4), PartPose.offsetAndRotation(0.0F, 19.5F, -2.0F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition Body = Chest.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, 0.0F, 0.0F, 4, 5, 4), PartPose.offset(0.0F, -2.5F, 2.0F));
            PartDefinition ThighRight = Body.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(44, 0).mirror(true).addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3), PartPose.offset(-1.7F, 0.9F, 2.7F));
            PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, -2.7F, -2.1F, 3, 4, 4), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, 0.7285004297824331F, 0.0F, 0.0F));
            PartDefinition ArmRight = Chest.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(32, 15).mirror(true).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(-1.7F, 0.7F, -0.5F, 0.136659280431156F, 0.0F, 0.0F));
            PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, -2.1F, -0.2F, -0.6373942428283291F, 0.0F, 0.0F));
            PartDefinition EarLeft = Head.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(10, 9).addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1), PartPose.offsetAndRotation(1.1F, -0.7F, 0.4F, 0.136659280431156F, -0.091106186954104F, 0.31869712141416456F));
            PartDefinition EarRight = Head.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(14, 12).mirror(true).addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1), PartPose.offsetAndRotation(-1.1F, -0.7F, 0.4F, 0.136659280431156F, 0.091106186954104F, -0.31869712141416456F));
            PartDefinition EarFlapRight = EarRight.addOrReplaceChild("EarFlapRight", CubeListBuilder.create().texOffs(20, 12).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, 0.0F, -2.0F, 3, 2, 2), PartPose.offsetAndRotation(0.0F, 0.5F, -0.5F, -0.18203784098300857F, 0.0F, 0.0F));
            PartDefinition TopSnout = Snout.addOrReplaceChild("TopSnout", CubeListBuilder.create().texOffs(8, 28).addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2), PartPose.offsetAndRotation(0.0F, -0.4F, -0.1F, 0.091106186954104F, 0.0F, 0.0F));
            PartDefinition Mouth = Snout.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(10, 25).addBox(-1.0F, -1.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, 2.1F, 0.2F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition HandRight = ArmRight.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(32, 20).mirror(true).addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.1F, 3.5F, 0.6F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition ArmLeft = Chest.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(24, 15).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(1.7F, 0.7F, -0.5F, 0.136659280431156F, 0.0F, 0.0F));
            PartDefinition HandLeft = ArmLeft.addOrReplaceChild("HandLeft", CubeListBuilder.create().texOffs(24, 20).addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(-0.1F, 3.5F, 0.6F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition ThighLeft = Body.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3), PartPose.offset(1.7F, 0.9F, 2.7F));
            PartDefinition LegLeft = ThighLeft.addOrReplaceChild("LegLeft", CubeListBuilder.create().texOffs(34, 7).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(-0.1F, 4.0F, -1.1F, 0.4553564018453205F, 0.0F, 0.0F));
            PartDefinition LegRight = ThighRight.addOrReplaceChild("LegRight", CubeListBuilder.create().texOffs(45, 7).mirror(true).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(0.1F, 4.0F, -1.1F, 0.4553564018453205F, 0.0F, 0.0F));
            PartDefinition FootRight = LegRight.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(45, 11).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.1F, 2.0F, 2.0F, -0.40980330836826856F, 0.0F, 0.0F));
            PartDefinition EarFlapLeft = EarLeft.addOrReplaceChild("EarFlapLeft", CubeListBuilder.create().texOffs(16, 9).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition FootLeft = LegLeft.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(34, 11).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(-0.1F, 2.0F, 2.0F, -0.40980330836826856F, 0.0F, 0.0F));

            return LayerDefinition.create(meshDefinition, 64, 32);
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
