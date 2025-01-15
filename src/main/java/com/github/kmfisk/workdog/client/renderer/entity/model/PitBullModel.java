package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.PitBullEntity;
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

public abstract class PitBullModel extends WorkDogModel<PitBullEntity> {
    public static ModelLayerLocation ADULT_LAYER = new ModelLayerLocation(new ResourceLocation(WorkDog.MOD_ID, "pit_bull"), "adult");
    public static ModelLayerLocation BABY_LAYER = new ModelLayerLocation(new ResourceLocation(WorkDog.MOD_ID, "pit_bull"), "baby");
    public ModelPart Chest;
    public ModelPart Body;
    public ModelPart Neck;
    public ModelPart ThighLeft;
    public ModelPart ThighRight;
    public ModelPart Tail1;
    public ModelPart UpperLegLeft;
    public ModelPart FootLeft;
    public ModelPart UpperLegRight;
    public ModelPart FootRight;
    public ModelPart Head;
    public ModelPart EarLeft;
    public ModelPart Snout;
    public ModelPart EarRight;
    public ModelPart EarFlapLeft;
    public ModelPart TopSnout;
    public ModelPart Mouth;
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

    public static class Adult extends PitBullModel {
        public ModelPart ArmBaseLeft;
        public ModelPart ArmBaseRight;
        public ModelPart Hips;
        public ModelPart Saddlebag;
        public ModelPart shape42;
        public ModelPart Tail2;
        public ModelPart LowerLegLeft;
        public ModelPart LowerLegRight;
        public ModelPart SaddlebagLatchL;
        public ModelPart SaddlebagLatchR;
        public ModelPart NeckLower;
        public ModelPart Collar;
        public ModelPart Muzzle;
        public ModelPart Tongue;
        public ModelPart ForearmLeft;
        public ModelPart ForearmRight;
        
        public Adult(ModelPart root) {
            this.Chest = root.getChild("Chest");
            this.ArmBaseRight = this.Chest.getChild("ArmBaseRight");
            this.ArmRight = this.ArmBaseRight.getChild("ArmRight");
            this.ForearmRight = this.ArmRight.getChild("ForearmRight");
            this.HandRight = this.ForearmRight.getChild("HandRight");

            this.ArmBaseLeft = this.Chest.getChild("ArmBaseLeft");
            this.ArmLeft = this.ArmBaseLeft.getChild("ArmLeft");
            this.ForearmLeft = this.ArmLeft.getChild("ForearmLeft");
            this.HandLeft = this.ForearmLeft.getChild("HandLeft");

            this.Neck = this.Chest.getChild("Neck");
            this.Collar = this.Neck.getChild("Collar");

            this.Head = this.Neck.getChild("Head");
            this.EarLeft = this.Head.getChild("EarLeft");
            this.EarFlapLeft = this.EarLeft.getChild("EarFlapLeft");

            this.EarRight = this.Head.getChild("EarRight");
            this.EarFlapRight = this.EarRight.getChild("EarFlapRight");

            this.Snout = this.Head.getChild("Snout");
            this.Mouth = this.Snout.getChild("Mouth");
            this.Tongue = this.Mouth.getChild("Tongue");

            this.Muzzle = this.Snout.getChild("Muzzle");

            this.TopSnout = this.Snout.getChild("TopSnout");

            this.NeckLower = this.Neck.getChild("NeckLower");

            this.Body = this.Chest.getChild("Body");
            this.Hips = this.Body.getChild("Hips");
            this.ThighLeft = this.Hips.getChild("ThighLeft");
            this.UpperLegLeft = this.ThighLeft.getChild("UpperLegLeft");
            this.LowerLegLeft = this.UpperLegLeft.getChild("LowerLegLeft");
            this.FootLeft = this.LowerLegLeft.getChild("FootLeft");

            this.Tail1 = this.Hips.getChild("Tail1");
            this.Tail2 = this.Tail1.getChild("Tail2");

            this.ThighRight = this.Hips.getChild("ThighRight");
            this.UpperLegRight = this.ThighRight.getChild("UpperLegRight");
            this.LowerLegRight = this.UpperLegRight.getChild("LowerLegRight");
            this.FootRight = this.LowerLegRight.getChild("FootRight");

            this.Saddlebag = this.Body.getChild("Saddlebag");
            this.SaddlebagLatchL = this.Saddlebag.getChild("SaddlebagLatchL");

            this.SaddlebagLatchR = this.Saddlebag.getChild("SaddlebagLatchR");

            this.shape42 = this.Body.getChild("shape42");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshDefinition = new MeshDefinition();
            PartDefinition partDefinition = meshDefinition.getRoot();

            PartDefinition Chest = partDefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.5F, -3.0F, 8, 9, 6), PartPose.offsetAndRotation(0.0F, 12.1F, -4.7F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition Body = Chest.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 15).addBox(-3.5F, 0.0F, 1.0F, 7, 9, 8), PartPose.offsetAndRotation(0.0F, -4.4F, 1.5F, 0.045553093477052F, 0.0F, 0.0F));
            PartDefinition Hips = Body.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 0.0F, 0.0F, 8, 8, 4), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.18203784098300857F, 0.0F, 0.0F));
            PartDefinition ArmBaseLeft = Chest.addOrReplaceChild("ArmBaseLeft", CubeListBuilder.create().texOffs(30, 0).addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4), PartPose.offsetAndRotation(2.4F, 1.2F, -0.7F, 0.22759093446006054F, 0.0F, 0.0F));
            PartDefinition ArmLeft = ArmBaseLeft.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(33, 9).addBox(-1.5F, 0.0F, -3.0F, 3, 3, 3), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 44).addBox(-2.5F, -5.0F, -2.5F, 5, 7, 5), PartPose.offsetAndRotation(0.0F, -2.2F, -1.3F, 0.7285004297824331F, 0.0F, 0.0F));
            PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 56).addBox(-3.0F, -3.0F, -3.0F, 6, 6, 5), PartPose.offsetAndRotation(0.0F, -3.5F, -0.6F, -0.5462880558742251F, 0.0F, 0.0F));
            PartDefinition EarRight = Head.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(22, 58).mirror(true).addBox(-1.0F, -1.5F, -0.5F, 2, 3, 1), PartPose.offsetAndRotation(-2.1F, -2.1F, 0.4F, 0.0F, 0.18203784098300857F, -0.18203784098300857F));
            PartDefinition EarFlapRight = EarRight.addOrReplaceChild("EarFlapRight", CubeListBuilder.create().texOffs(28, 58).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offset(0.0F, -2.0F, 0.5F));
            PartDefinition ThighRight = Hips.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(46, 27).mirror(true).addBox(-2.0F, 0.0F, -2.5F, 4, 6, 5), PartPose.offsetAndRotation(-2.9F, 2.9F, 0.9F, 0.27314402793711257F, 0.0F, 0.0F));
            PartDefinition UpperLegRight = ThighRight.addOrReplaceChild("UpperLegRight", CubeListBuilder.create().texOffs(50, 38).mirror(true).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 4), PartPose.offsetAndRotation(0.0F, 6.0F, -2.0F, 0.27314402793711257F, 0.0F, 0.0F));
            PartDefinition ArmBaseRight = Chest.addOrReplaceChild("ArmBaseRight", CubeListBuilder.create().texOffs(46, 0).mirror(true).addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4), PartPose.offsetAndRotation(-2.3F, 1.2F, -0.7F, 0.22759093446006054F, 0.0F, 0.0F));
            PartDefinition ArmRight = ArmBaseRight.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(45, 9).mirror(true).addBox(-1.5F, 0.0F, -3.0F, 3, 3, 3), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition ForearmRight = ArmRight.addOrReplaceChild("ForearmRight", CubeListBuilder.create().texOffs(45, 15).mirror(true).addBox(-1.5F, 0.0F, 0.0F, 3, 2, 3), PartPose.offsetAndRotation(-0.01F, 2.6F, -3.0F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 68).addBox(-2.0F, 0.0F, -4.4F, 4, 3, 3), PartPose.offset(0.0F, -0.7F, -1.4F));
            PartDefinition Mouth = Snout.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(0, 80).addBox(-1.5F, 0.0F, -2.4F, 3, 1, 3), PartPose.offsetAndRotation(0.0F, 2.6F, -1.5F, -0.136659280431156F, 0.0F, 0.0F));
            PartDefinition ThighLeft = Hips.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(28, 27).addBox(-2.0F, 0.0F, -2.5F, 4, 6, 5), PartPose.offsetAndRotation(2.9F, 2.9F, 0.9F, 0.31869712141416456F, 0.0F, 0.0F));
            PartDefinition UpperLegLeft = ThighLeft.addOrReplaceChild("UpperLegLeft", CubeListBuilder.create().texOffs(36, 38).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 4), PartPose.offsetAndRotation(0.0F, 6.0F, -2.0F, 0.27314402793711257F, 0.0F, 0.0F));
            PartDefinition LowerLegLeft = UpperLegLeft.addOrReplaceChild("LowerLegLeft", CubeListBuilder.create().texOffs(36, 45).addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3), PartPose.offsetAndRotation(-0.03F, 2.9F, 3.4F, -0.36425021489121656F, 0.0F, 0.0F));
            PartDefinition FootLeft = LowerLegLeft.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(36, 52).addBox(-1.5F, -1.0F, -3.2F, 3, 2, 3), PartPose.offsetAndRotation(-0.1F, 4.0F, -0.7F, 0.045553093477052F, 0.0F, 0.0F));
            PartDefinition Tongue = Mouth.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(8, 74).addBox(-1.0F, 0.0F, -3.0F, 2, 0, 3), PartPose.offsetAndRotation(0.0F, 0.0F, 0.8F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition Muzzle = Snout.addOrReplaceChild("Muzzle", CubeListBuilder.create().texOffs(38, 57).addBox(-2.5F, 0.0F, 0.0F, 5, 5, 4), PartPose.offset(0.0F, -0.8F, -5.1F));
            PartDefinition LowerLegRight = UpperLegRight.addOrReplaceChild("LowerLegRight", CubeListBuilder.create().texOffs(48, 45).mirror(true).addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3), PartPose.offsetAndRotation(0.03F, 2.9F, 3.4F, -0.36425021489121656F, 0.0F, 0.0F));
            PartDefinition Saddlebag = Body.addOrReplaceChild("Saddlebag", CubeListBuilder.create().texOffs(24, 66).addBox(-4.5F, 0.0F, -3.0F, 9, 5, 6), PartPose.offset(0.0F, -0.7F, 7.9F));
            PartDefinition Tail1 = Hips.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 84).addBox(-1.0F, -1.0F, 0.0F, 2, 2, 5), PartPose.offsetAndRotation(0.0F, 1.5F, 3.0F, -0.9560913642424937F, 0.0F, 0.0F));
            PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 91).addBox(-1.0F, -2.5F, 0.0F, 2, 2, 5), PartPose.offsetAndRotation(0.0F, 1.5F, 5.0F, 0.18203784098300857F, 0.0F, 0.0F));
            PartDefinition Collar = Neck.addOrReplaceChild("Collar", CubeListBuilder.create().texOffs(26, 77).addBox(-3.0F, 0.0F, -3.0F, 6, 1, 7), PartPose.offsetAndRotation(0.0F, -1.3F, -1.3F, 0.18203784098300857F, 0.0F, 0.0F));
            PartDefinition ForearmLeft = ArmLeft.addOrReplaceChild("ForearmLeft", CubeListBuilder.create().texOffs(33, 15).addBox(-1.5F, 0.0F, 0.0F, 3, 2, 3), PartPose.offsetAndRotation(-0.01F, 2.6F, -3.0F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition HandLeft = ForearmLeft.addOrReplaceChild("HandLeft", CubeListBuilder.create().texOffs(33, 20).addBox(-1.5F, -0.7F, -3.4F, 3, 2, 3), PartPose.offset(0.1F, 1.9F, 2.6F));
            PartDefinition SaddlebagLatchL = Saddlebag.addOrReplaceChild("SaddlebagLatchL", CubeListBuilder.create().texOffs(38, 58).addBox(0.0F, 0.0F, -0.5F, 1, 2, 1), PartPose.offset(4.0F, 0.5F, 0.0F));
            PartDefinition EarLeft = Head.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(20, 54).addBox(-1.0F, -1.5F, -0.5F, 2, 3, 1), PartPose.offsetAndRotation(2.1F, -2.1F, 0.4F, 0.0F, -0.18203784098300857F, 0.18203784098300857F));
            PartDefinition NeckLower = Neck.addOrReplaceChild("NeckLower", CubeListBuilder.create().texOffs(20, 42).addBox(-2.0F, 0.0F, -1.0F, 4, 8, 4), PartPose.offsetAndRotation(0.0F, -3.4F, -2.4F, -0.136659280431156F, 0.0F, 0.0F));
            PartDefinition SaddlebagLatchR = Saddlebag.addOrReplaceChild("SaddlebagLatchR", CubeListBuilder.create().texOffs(38, 58).mirror(true).addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1), PartPose.offset(-4.0F, 0.5F, 0.0F));
            PartDefinition EarFlapLeft = EarLeft.addOrReplaceChild("EarFlapLeft", CubeListBuilder.create().texOffs(26, 55).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offset(0.0F, -2.0F, 0.5F));
            PartDefinition TopSnout = Snout.addOrReplaceChild("TopSnout", CubeListBuilder.create().texOffs(0, 74).addBox(-1.5F, 0.0F, 0.0F, 3, 2, 4), PartPose.offsetAndRotation(0.0F, -0.1F, -4.7F, 0.18203784098300857F, 0.0F, 0.0F));
            PartDefinition HandRight = ForearmRight.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(45, 20).mirror(true).addBox(-1.5F, -0.7F, -3.4F, 3, 2, 3), PartPose.offset(-0.1F, 1.9F, 2.6F));
            PartDefinition shape42 = Body.addOrReplaceChild("shape42", CubeListBuilder.create().texOffs(44, 67).addBox(-3.0F, 0.0F, 0.0F, 6, 3, 2), PartPose.offsetAndRotation(0.0F, -2.6F, 2.0F, -0.36425021489121656F, 0.0F, 0.0F));
            PartDefinition FootRight = LowerLegRight.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(48, 52).mirror(true).addBox(-1.5F, -1.0F, -3.2F, 3, 2, 3), PartPose.offsetAndRotation(0.1F, 4.0F, -0.7F, 0.045553093477052F, 0.0F, 0.0F));

            return LayerDefinition.create(meshDefinition, 64, 128);
        }

        @Override
        public void playIdleAnimation(PitBullEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? 0.86F : 0.72F);
            this.Head.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + (entity.isInSittingPose()? -0.45F : -0.54F);
            if (!entity.isInSittingPose() && !entity.isLying()) {
                this.Tail1.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + -0.95F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
                this.Tail2.zRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F;
            }
        }

        @Override
        public void playMovementAnimation(PitBullEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 3.0f;
            float degree = 1.2f;

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
                this.ArmBaseLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.14F;
                this.ArmLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F + -0.04F;
                this.HandLeft.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.09F;
                this.ArmBaseRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.14F;
                this.ArmRight.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.5F) * limbSwingAmount * 0.5F + -0.04F;
                this.HandRight.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.09F;
                this.ArmBaseLeft.z = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + -0.7F;
                this.ArmBaseRight.z = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + -0.7F;
                this.Neck.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 0.72F;
                this.Head.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + -0.54F;
                this.ThighLeft.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.27F;
                this.UpperLegLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + 0.27F;
                this.LowerLegLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + -0.36F;
                this.FootLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.05F;
                this.ThighLeft.y = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 2.9F;
                this.ThighLeft.z = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + 0.9F;
                this.ThighRight.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.27F;
                this.UpperLegRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + 0.27F;
                this.LowerLegRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + -0.36F;
                this.FootRight.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.05F;
                this.ThighRight.y = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 2.9F;
                this.ThighRight.z = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 0.9F;
                this.Chest.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.05F) * limbSwingAmount * 0.5F + -0.09F;
                this.Body.xRot = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 0.05F;
                this.Hips.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + -0.18F;
                this.Neck.z = Mth.cos(5.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.07F) * limbSwingAmount * 0.5F + -1.3F;
                this.Tail1.xRot = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.5F) * limbSwingAmount * 0.5F + -0.95F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
                this.Chest.y = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.09F) * limbSwingAmount * 0.5F + 12.1F;
            }
        }

        @Override
        public void setSittingPose(PitBullEntity entity, float speed, float walkSpeed, float partialTick) {
            this.Body.setPos(0.0F, -3.7F, 1.9F);
            this.FootLeft.setPos(-0.1F, 2.9F, -1.0F);
            this.FootRight.setPos(0.1F, 2.9F, -1.0F);
            this.Head.setPos(0.0F, -3.8F, -0.4F);
            this.UpperLegLeft.setPos(0.0F, 6.0F, 2.0F);
            this.UpperLegRight.setPos(0.0F, 6.0F, 2.0F);
            this.LowerLegLeft.setPos(0.17F, 3.9F, 2.4F);
            this.LowerLegRight.setPos(0.03F, 3.9F, 2.4F);
            this.setRotateAngle(ArmBaseLeft, 0.4553564018453205F, 0.0F, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.4553564018453205F, 0.0F, 0.0F);
            this.setRotateAngle(Body, -0.40980330836826856F, 0.0F, 0.0F);
            this.setRotateAngle(Chest, -0.31869712141416456F, 0.0F, 0.0F);
            this.setRotateAngle(FootLeft, 1.730144887501979F, 0.0F, 0.0F);
            this.setRotateAngle(FootRight, 1.730144887501979F, 0.0F, 0.0F);
            this.setRotateAngle(Head, -0.4553564018453205F, 0.0F, 0.0F);
            this.setRotateAngle(UpperLegLeft, 2.1855012893472994F, 0.0F, 0.0F);
            this.setRotateAngle(UpperLegRight, 2.1855012893472994F, 0.0F, 0.0F);
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
        }

        @Override
        public void setLyingPose(PitBullEntity entity, float speed, float walkSpeed, float partialTick) {
            this.Chest.setPos(0.0F, 22.1F, -4.7F);
            this.setRotateAngle(Chest, 0.045553093477052F, 0.0F, 3.141592653589793F);
            this.FootLeft.setPos(-0.1F, 3.0F, -1.7F);
            this.setRotateAngle(FootLeft, 2.1855012893472994F, 0.0F, 0.0F);
            this.HandLeft.setPos(0.1F, 1.5F, 0.2F);
            this.setRotateAngle(HandLeft, 2.231054382824351F, 0.0F, 0.0F);
            this.FootRight.setPos(0.1F, 3.0F, -1.7F);
            this.setRotateAngle(FootRight, 1.8668041679331349F, 0.0F, 0.0F);
            this.SaddlebagLatchR.setPos(-4.0F, 0.5F, 0.0F);
            this.NeckLower.setPos(0.0F, -3.4F, -2.4F);
            this.setRotateAngle(NeckLower, -0.136659280431156F, 0.0F, 0.0F);
            this.HandRight.setPos(-0.1F, 1.2F, 0.4F);
            this.setRotateAngle(HandRight, 2.231054382824351F, 0.0F, 0.0F);
            this.ThighRight.setPos(-2.9F, 2.9F, 0.9F);
            this.setRotateAngle(ThighRight, -0.136659280431156F, -0.17020509857014457F, 0.40980330836826856F);
            this.Muzzle.setPos(0.0F, -0.8F, -5.1F);
            this.SaddlebagLatchL.setPos(4.0F, 0.5F, 0.0F);
            this.Tail1.setPos(0.0F, 3.1F, 3.0F);
            this.setRotateAngle(Tail1, 0.18203784098300857F, 0.0F, 0.0F);
            this.Mouth.setPos(0.0F, 2.6F, -1.5F);
            this.setRotateAngle(Mouth, -0.136659280431156F, 0.0F, 0.0F);
            this.LowerLegRight.setPos(0.03F, 2.9F, 3.4F);
            this.setRotateAngle(LowerLegRight, -1.2292353921796064F, 0.0F, 0.0F);
            this.shape42.setPos(0.0F, -2.6F, 2.0F);
            this.setRotateAngle(shape42, -0.36425021489121656F, 0.0F, 0.0F);
            this.UpperLegLeft.setPos(0.0F, 6.0F, 0.0F);
            this.setRotateAngle(UpperLegLeft, 1.2747884856566583F, 0.0F, 0.0F);
            this.ArmBaseLeft.setPos(2.4F, 1.2F, -0.7F);
            this.setRotateAngle(ArmBaseLeft, 0.7740535232594852F, 0.0F, 0.0F);
            this.ForearmLeft.setPos(-0.01F, 2.6F, -3.0F);
            this.setRotateAngle(ForearmLeft, 0.9560913642424937F, -0.27314402793711257F, 0.0F);
            this.ForearmRight.setPos(-0.01F, 2.6F, -3.0F);
            this.setRotateAngle(ForearmRight, 0.7740535232594852F, 0.0F, 0.0F);
            this.ArmRight.setPos(0.0F, 5.0F, 1.5F);
            this.setRotateAngle(ArmRight, -0.9105382707654417F, 0.0F, 0.0F);
            this.EarLeft.setPos(2.1F, -2.1F, 0.4F);
            this.setRotateAngle(EarLeft, 0.0F, -0.18203784098300857F, 0.18203784098300857F);
            this.LowerLegLeft.setPos(-0.03F, 2.9F, 3.4F);
            this.setRotateAngle(LowerLegLeft, -1.2747884856566583F, 0.0F, 0.0F);
            this.EarRight.setPos(-2.1F, -2.1F, 0.4F);
            this.setRotateAngle(EarRight, 0.0F, 0.18203784098300857F, -0.18203784098300857F);
            this.ArmLeft.setPos(0.0F, 5.0F, 1.5F);
            this.setRotateAngle(ArmLeft, -0.8651597102135892F, 0.0F, 0.0F);
            this.Tongue.setPos(0.0F, 0.0F, 0.8F);
            this.setRotateAngle(Tongue, -0.045553093477052F, 0.0F, 0.0F);
            this.Snout.setPos(0.0F, -0.7F, -1.4F);
            this.Tail2.setPos(0.0F, 1.5F, 5.0F);
            this.setRotateAngle(Tail2, 0.18203784098300857F, 0.0F, 0.0F);
            this.ArmBaseRight.setPos(-2.3F, 1.2F, -0.7F);
            this.setRotateAngle(ArmBaseRight, 0.6829473363053812F, 0.0F, 0.0F);
            this.TopSnout.setPos(0.0F, -0.1F, -4.7F);
            this.setRotateAngle(TopSnout, 0.18203784098300857F, 0.0F, 0.0F);
            this.EarFlapRight.setPos(0.0F, -2.0F, 0.5F);
            this.Neck.setPos(0.0F, -0.2F, -3.3F);
            this.setRotateAngle(Neck, 1.730144887501979F, 0.0F, 0.0F);
            this.Collar.setPos(0.0F, -1.3F, -1.3F);
            this.setRotateAngle(Collar, 0.18203784098300857F, 0.0F, 0.0F);
            this.EarFlapLeft.setPos(0.0F, -2.0F, 0.5F);
            this.Body.setPos(0.0F, -4.7F, 1.1F);
            this.setRotateAngle(Body, -0.045553093477052F, 0.31869712141416456F, 0.0F);
            this.UpperLegRight.setPos(0.0F, 6.1F, 0.0F);
            this.setRotateAngle(UpperLegRight, 1.5481070465189704F, 0.0F, 0.0F);
            this.Hips.setPos(0.0F, 0.0F, 9.0F);
            this.setRotateAngle(Hips, -0.18203784098300857F, 0.27314402793711257F, 0.0F);
            this.Head.setPos(-0.3F, -3.5F, -0.6F);
            this.setRotateAngle(Head, -1.2292353921796064F, -0.4553564018453205F, 0.0F);
            this.Saddlebag.setPos(0.0F, -0.7F, 7.9F);
            this.ThighLeft.setPos(2.9F, 2.9F, 0.9F);
            this.setRotateAngle(ThighLeft, 0.31869712141416456F, 0.045553093477052F, -0.36425021489121656F);
        }

        @Override
        public void resetPose(PitBullEntity entity, float speed, float walkSpeed, float partialTick) {
            this.Hips.setPos(0.0F, 0.0F, 9.0F);
            this.setRotateAngle(Hips, -0.18203784098300857F, 0.0F, 0.0F);
            this.ArmLeft.setPos(0.0F, 5.0F, 1.5F);
            this.setRotateAngle(ArmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.EarFlapRight.setPos(0.0F, -2.0F, 0.5F);
            this.UpperLegRight.setPos(0.0F, 6.0F, -2.0F);
            this.setRotateAngle(UpperLegRight, 0.27314402793711257F, 0.0F, 0.0F);
            this.ForearmRight.setPos(-0.01F, 2.6F, -3.0F);
            this.setRotateAngle(ForearmRight, -0.091106186954104F, 0.0F, 0.0F);
            this.Mouth.setPos(0.0F, 2.6F, -1.5F);
            this.setRotateAngle(Mouth, -0.136659280431156F, 0.0F, 0.0F);
            this.ArmBaseRight.setPos(-2.3F, 1.2F, -0.7F);
            this.setRotateAngle(ArmBaseRight, 0.22759093446006054F, 0.0F, 0.0F);
            this.FootLeft.setPos(-0.1F, 4.0F, -0.7F);
            this.setRotateAngle(FootLeft, 0.045553093477052F, 0.0F, 0.0F);
            this.Tongue.setPos(0.0F, 0.0F, 0.8F);
            this.setRotateAngle(Tongue, -0.045553093477052F, 0.0F, 0.0F);
            this.LowerLegRight.setPos(0.03F, 2.9F, 3.4F);
            this.setRotateAngle(LowerLegRight, -0.36425021489121656F, 0.0F, 0.0F);
            this.ArmBaseLeft.setPos(2.4F, 1.2F, -0.7F);
            this.setRotateAngle(ArmBaseLeft, 0.22759093446006054F, 0.0F, 0.0F);
            this.Tail2.setPos(0.0F, 1.5F, 5.0F);
            this.setRotateAngle(Tail2, 0.18203784098300857F, 0.0F, 0.0F);
            this.ThighLeft.setPos(2.9F, 2.9F, 0.9F);
            this.setRotateAngle(ThighLeft, 0.31869712141416456F, 0.0F, 0.0F);
            this.Head.setPos(0.0F, -3.5F, -0.6F);
            this.setRotateAngle(Head, -0.5462880558742251F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 1.5F, 3.0F);
            this.setRotateAngle(Tail1, -0.9560913642424937F, 0.0F, 0.0F);
            this.HandLeft.setPos(0.1F, 1.9F, 2.6F);
            this.setRotateAngle(HandLeft, 0F, 0F, 0F);
            this.UpperLegLeft.setPos(0.0F, 6.0F, -2.0F);
            this.setRotateAngle(UpperLegLeft, 0.27314402793711257F, 0.0F, 0.0F);
            this.LowerLegLeft.setPos(-0.03F, 2.9F, 3.4F);
            this.setRotateAngle(LowerLegLeft, -0.36425021489121656F, 0.0F, 0.0F);
            this.Chest.setPos(0.0F, 12.1F, -4.7F);
            this.setRotateAngle(Chest, -0.091106186954104F, 0.0F, 0.0F);
            this.EarLeft.setPos(2.1F, -2.1F, 0.4F);
            this.setRotateAngle(EarLeft, 0.0F, -0.18203784098300857F, 0.18203784098300857F);
            this.ForearmLeft.setPos(-0.01F, 2.6F, -3.0F);
            this.setRotateAngle(ForearmLeft, -0.091106186954104F, 0.0F, 0.0F);
            this.NeckLower.setPos(0.0F, -3.4F, -2.4F);
            this.setRotateAngle(NeckLower, -0.136659280431156F, 0.0F, 0.0F);
            this.ArmRight.setPos(0.0F, 5.0F, 1.5F);
            this.setRotateAngle(ArmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.EarFlapLeft.setPos(0.0F, -2.0F, 0.5F);
            this.TopSnout.setPos(0.0F, -0.1F, -4.7F);
            this.setRotateAngle(TopSnout, 0.18203784098300857F, 0.0F, 0.0F);
            this.HandRight.setPos(-0.1F, 1.9F, 2.6F);
            this.setRotateAngle(HandRight, 0F, 0F, 0F);
            this.EarRight.setPos(-2.1F, -2.1F, 0.4F);
            this.setRotateAngle(EarRight, 0.0F, 0.18203784098300857F, -0.18203784098300857F);
            this.Neck.setPos(0.0F, -2.2F, -1.3F);
            this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
            this.shape42.setPos(0.0F, -2.6F, 2.0F);
            this.setRotateAngle(shape42, -0.36425021489121656F, 0.0F, 0.0F);
            this.Snout.setPos(0.0F, -0.7F, -1.4F);
            this.Body.setPos(0.0F, -4.4F, 1.5F);
            this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
            this.ThighRight.setPos(-2.9F, 2.9F, 0.9F);
            this.setRotateAngle(ThighRight, 0.27314402793711257F, 0.0F, 0.0F);
            this.FootRight.setPos(0.1F, 4.0F, -0.7F);
            this.setRotateAngle(FootRight, 0.045553093477052F, 0.0F, 0.0F);
        }
    }

    public static class Baby extends PitBullModel {
        public Baby(ModelPart root) {
            this.Chest = root.getChild("Chest");
            this.Body = this.Chest.getChild("Body");
            this.ThighRight = this.Body.getChild("ThighRight");
            this.UpperLegRight = this.ThighRight.getChild("UpperLegRight");
            this.FootRight = this.UpperLegRight.getChild("FootRight");

            this.ThighLeft = this.Body.getChild("ThighLeft");
            this.UpperLegLeft = this.ThighLeft.getChild("UpperLegLeft");
            this.FootLeft = this.UpperLegLeft.getChild("FootLeft");

            this.Tail1 = this.Body.getChild("Tail1");

            this.Neck = this.Chest.getChild("Neck");
            this.Head = this.Neck.getChild("Head");
            this.EarRight = this.Head.getChild("EarRight");
            this.EarFlapRight = this.EarRight.getChild("EarFlapRight");

            this.Snout = this.Head.getChild("Snout");
            this.TopSnout = this.Snout.getChild("TopSnout");

            this.Mouth = this.Snout.getChild("Mouth");

            this.EarLeft = this.Head.getChild("EarLeft");
            this.EarFlapLeft = this.EarLeft.getChild("EarFlapLeft");

            this.ArmRight = this.Chest.getChild("ArmRight");
            this.HandRight = this.ArmRight.getChild("HandRight");

            this.ArmLeft = this.Chest.getChild("ArmLeft");
            this.HandLeft = this.ArmLeft.getChild("HandLeft");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshDefinition = new MeshDefinition();
            PartDefinition partDefinition = meshDefinition.getRoot();

            PartDefinition Chest = partDefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -2.0F, 5, 5, 4), PartPose.offsetAndRotation(0.0F, 19.5F, -2.0F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, -2.7F, -2.1F, 3, 4, 4), PartPose.offsetAndRotation(0.0F, -1.3F, -0.7F, 0.7285004297824331F, 0.0F, 0.0F));
            PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, -2.1F, -0.2F, -0.6373942428283291F, 0.0F, 0.0F));
            PartDefinition Body = Chest.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, 0.0F, 0.0F, 4, 5, 4), PartPose.offset(0.0F, -2.5F, 2.0F));
            PartDefinition ThighRight = Body.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(44, 0).mirror(true).addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3), PartPose.offset(-1.7F, 0.9F, 2.7F));
            PartDefinition EarRight = Head.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(14, 12).mirror(true).addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1), PartPose.offsetAndRotation(-1.1F, -0.6F, 0.4F, 0.136659280431156F, 0.091106186954104F, -0.31869712141416456F));
            PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, 0.0F, -2.0F, 3, 2, 2), PartPose.offsetAndRotation(0.0F, 0.2F, -1.3F, 0.27314402793711257F, 0.0F, 0.0F));
            PartDefinition TopSnout = Snout.addOrReplaceChild("TopSnout", CubeListBuilder.create().texOffs(8, 28).addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2), PartPose.offsetAndRotation(0.0F, -0.4F, -0.1F, 0.091106186954104F, 0.0F, 0.0F));
            PartDefinition ThighLeft = Body.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3), PartPose.offset(1.7F, 0.9F, 2.7F));
            PartDefinition EarFlapRight = EarRight.addOrReplaceChild("EarFlapRight", CubeListBuilder.create().texOffs(20, 12).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition UpperLegLeft = ThighLeft.addOrReplaceChild("UpperLegLeft", CubeListBuilder.create().texOffs(34, 7).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(-0.1F, 4.0F, -1.1F, 0.4553564018453205F, 0.0F, 0.0F));
            PartDefinition Mouth = Snout.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(10, 25).addBox(-1.0F, -1.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, 2.1F, 0.2F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(28, 25).addBox(-0.5F, 0.0F, 0.0F, 1, 1, 3), PartPose.offsetAndRotation(0.0F, 0.4F, 4.0F, -0.7285004297824331F, 0.0F, 0.0F));
            PartDefinition UpperLegRight = ThighRight.addOrReplaceChild("UpperLegRight", CubeListBuilder.create().texOffs(45, 7).mirror(true).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(0.1F, 4.0F, -1.1F, 0.4553564018453205F, 0.0F, 0.0F));
            PartDefinition ArmRight = Chest.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(32, 15).mirror(true).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(-1.7F, 0.7F, -0.5F, 0.136659280431156F, 0.0F, 0.0F));
            PartDefinition EarLeft = Head.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(10, 9).addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1), PartPose.offsetAndRotation(1.0F, -0.6F, 0.4F, 0.136659280431156F, -0.091106186954104F, 0.31869712141416456F));
            PartDefinition EarFlapLeft = EarLeft.addOrReplaceChild("EarFlapLeft", CubeListBuilder.create().texOffs(16, 9).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition ArmLeft = Chest.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(24, 15).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(1.7F, 0.7F, -0.5F, 0.136659280431156F, 0.0F, 0.0F));
            PartDefinition HandLeft = ArmLeft.addOrReplaceChild("HandLeft", CubeListBuilder.create().texOffs(24, 20).addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(-0.1F, 3.5F, 0.6F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition HandRight = ArmRight.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(32, 20).mirror(true).addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.1F, 3.5F, 0.6F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition FootRight = UpperLegRight.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(45, 11).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.1F, 2.0F, 2.0F, -0.40980330836826856F, 0.0F, 0.0F));
            PartDefinition FootLeft = UpperLegLeft.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(34, 11).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(-0.1F, 2.0F, 2.0F, -0.40980330836826856F, 0.0F, 0.0F));

            return LayerDefinition.create(meshDefinition, 64, 32);
        }

        @Override
        public void playIdleAnimation(PitBullEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? 1.23F : 0.72F);
            this.Head.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.63F;
            if (!entity.isInSittingPose() && !entity.isLying()) {
                this.Tail1.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + -0.82F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
            }
        }

        @Override
        public void playMovementAnimation(PitBullEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 0.8f;
            this.ArmLeft.xRot = Mth.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 3.0F) * limbSwingAmount * 0.5F;
            this.ArmRight.xRot = Mth.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F;
            this.ThighLeft.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + -0.05F;
            this.UpperLegLeft.xRot = Mth.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * -1.5F) * limbSwingAmount * 0.5F + 0.6F;
            this.ThighRight.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + -0.05F;
            this.UpperLegRight.xRot = Mth.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 1.5F) * limbSwingAmount * 0.5F + 0.6F;
            this.Neck.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + 0.72F;
            this.Head.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.63F;
            this.Chest.xRot = Mth.cos(3.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.07F) * limbSwingAmount * 0.5F + -0.03F;
            this.Body.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.025F;
            this.Chest.y = Mth.cos(4.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.03F) * limbSwingAmount * 0.5F + 19.5F;
            this.Tail1.zRot = Mth.cos(2.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F;
        }

        @Override
        public void setSittingPose(PitBullEntity entity, float speed, float walkSpeed, float partialTick) {
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
        public void setLyingPose(PitBullEntity entity, float speed, float walkSpeed, float partialTick) {

        }

        @Override
        public void resetPose(PitBullEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmLeft.setPos(1.7F, 0.7F, -0.5F);
            this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.ArmRight.setPos(-1.7F, 0.7F, -0.5F);
            this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
            this.Neck.setPos(0.0F, -1.3F, -0.7F);
            this.setRotateAngle(Neck, 0.7285004297824331F, 0.0F, 0.0F);
            this.setRotateAngle(Body, 0.0F, 0.0F, 0.0F);
            this.Chest.setPos(0.0F, 19.5F, -2.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.setRotateAngle(Head, -0.6373942428283291F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 0.4F, 4.0F);
            this.setRotateAngle(Tail1, -0.7285004297824331F, 0.0F, 0.0F);
            this.ThighLeft.setPos(1.7F, 0.9F, 2.7F);
            this.setRotateAngle(ThighLeft, 0.0F, 0.0F, 0.0F);
            this.ThighRight.setPos(-1.7F, 0.9F, 2.7F);
            this.setRotateAngle(ThighRight, 0.0F, 0.0F, 0.0F);
            this.UpperLegLeft.setPos(-0.1F, 4.0F, -1.1F);
            this.setRotateAngle(UpperLegLeft, 0.4553564018453205F, 0.0F, 0.0F);
            this.UpperLegRight.setPos(0.1F, 4.0F, -1.1F);
            this.setRotateAngle(UpperLegRight, 0.4553564018453205F, 0.0F, 0.0F);
        }
    }
}
