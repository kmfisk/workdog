package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.AkitaEntity;
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

public abstract class AkitaModel extends WorkDogModel<AkitaEntity> {
    public static ModelLayerLocation ADULT_LAYER = new ModelLayerLocation(new ResourceLocation(WorkDog.MOD_ID, "akita"), "adult");
    public static ModelLayerLocation BABY_LAYER = new ModelLayerLocation(new ResourceLocation(WorkDog.MOD_ID, "akita"), "baby");
    public ModelPart Chest;
    public ModelPart Body;
    public ModelPart Neck;
    public ModelPart ThighLeft;
    public ModelPart ThighRight;
    public ModelPart Tail1;
    public ModelPart Tail2;
    public ModelPart Tail3;
    public ModelPart FootLeft;
    public ModelPart FootRight;
    public ModelPart Head;
    public ModelPart Snout;
    public ModelPart EarLeft;
    public ModelPart EarRight;
    public ModelPart TopSnout;
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

    public static class Adult extends AkitaModel {
        public ModelPart ArmBaseLeft;
        public ModelPart ArmBaseRight;
        public ModelPart Hips;
        public ModelPart Saddlebag;
        public ModelPart shape42;
        public ModelPart Tail4;
        public ModelPart UpperLegLeft;
        public ModelPart LowerLegLeft;
        public ModelPart UpperLegRight;
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
            this.ArmRight = this.ArmBaseRight.getChild("ArmRight");
            this.Tail1 = this.Hips.getChild("Tail1");
            this.Hips = this.Body.getChild("Hips");
            this.EarLeft = this.Head.getChild("EarLeft");
            this.ForearmLeft = this.ArmLeft.getChild("ForearmLeft");
            this.TopSnout = this.Snout.getChild("TopSnout");
            this.ArmBaseRight = this.Chest.getChild("ArmBaseRight");
            this.EarRight = this.Head.getChild("EarRight");
            this.Head = this.Neck.getChild("Head");
            this.FootRight = this.LowerLegRight.getChild("FootRight");
            this.Collar = this.Neck.getChild("Collar");
            this.LowerLegRight = this.UpperLegRight.getChild("LowerLegRight");
            this.NeckLower = this.Neck.getChild("NeckLower");
            this.ThighRight = this.Hips.getChild("ThighRight");
            this.ThighLeft = this.Hips.getChild("ThighLeft");
            this.SaddlebagLatchR = this.Saddlebag.getChild("SaddlebagLatchR");
            this.Tail4 = this.Tail3.getChild("Tail4");
            this.Saddlebag = this.Body.getChild("Saddlebag");
            this.Tail2 = this.Tail1.getChild("Tail2");
            this.Tail3 = this.Tail2.getChild("Tail3");
            this.Snout = this.Head.getChild("Snout");
            this.ArmBaseLeft = this.Chest.getChild("ArmBaseLeft");
            this.LowerLegLeft = this.UpperLegLeft.getChild("LowerLegLeft");
            this.Muzzle = this.Head.getChild("Muzzle");
            this.Body = this.Chest.getChild("Body");
            this.SaddlebagLatchL = this.Saddlebag.getChild("SaddlebagLatchL");
            this.Neck = this.Chest.getChild("Neck");
            this.Tongue = this.Mouth.getChild("Tongue");
            this.ArmLeft = this.ArmBaseLeft.getChild("ArmLeft");
            this.HandRight = this.ForearmRight.getChild("HandRight");
            this.UpperLegRight = this.ThighRight.getChild("UpperLegRight");
            this.ForearmRight = this.ArmRight.getChild("ForearmRight");
            this.UpperLegLeft = this.ThighLeft.getChild("UpperLegLeft");
            this.HandLeft = this.ForearmLeft.getChild("HandLeft");
            this.shape42 = this.Body.getChild("shape42");
            this.FootLeft = this.LowerLegLeft.getChild("FootLeft");
            this.Mouth = this.Snout.getChild("Mouth");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshDefinition = new MeshDefinition();
            PartDefinition partDefinition = meshDefinition.getRoot();

            partDefinition.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(44, 37).mirror(true).addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(23, 12).addBox(-1.5F, -1.0F, -1.0F, 3, 3, 3), PartPose.offsetAndRotation(0.0F, 3.0F, 5.0F, 1.1383037381507017F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 0.0F, 0.0F, 8, 9, 5), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.18203784098300857F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1), PartPose.offsetAndRotation(2.0F, -3.0F, 0.0F, 0.4553564018453205F, 0.091106186954104F, 0.22759093446006054F));
            partDefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -2.5F, 8, 9, 5), PartPose.offsetAndRotation(0.0F, 10.2F, -5.7F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ForearmLeft", CubeListBuilder.create().texOffs(34, 44).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3), PartPose.offsetAndRotation(-0.1F, 3.5F, -3.0F, -0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("TopSnout", CubeListBuilder.create().texOffs(50, 8).addBox(-1.5F, 0.0F, 0.0F, 3, 2, 4), PartPose.offsetAndRotation(0.0F, 0.0F, -3.1F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ArmBaseRight", CubeListBuilder.create().texOffs(46, 28).mirror(true).addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4), PartPose.offsetAndRotation(-2.4F, 1.3F, -0.1F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(58, 4).mirror(true).addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1), PartPose.offsetAndRotation(-2.0F, -3.0F, 0.0F, 0.5009094953223726F, 0.091106186954104F, -0.22759093446006054F));
            partDefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(26, 0).addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6), PartPose.offsetAndRotation(0.0F, -4.2F, -0.9F, -0.5918411493512771F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(12, 92).mirror(true).addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3), PartPose.offset(0.1F, 5.0F, -0.9F));
            partDefinition.addOrReplaceChild("Collar", CubeListBuilder.create().texOffs(32, 76).addBox(-3.0F, 0.0F, -3.0F, 6, 1, 7), PartPose.offsetAndRotation(0.0F, -1.3F, -1.5F, 0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("LowerLegRight", CubeListBuilder.create().texOffs(12, 84).mirror(true).addBox(-1.5F, 0.0F, -3.0F, 3, 5, 3), PartPose.offsetAndRotation(0.0F, 4.0F, 3.5F, -0.6373942428283291F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("NeckLower", CubeListBuilder.create().texOffs(20, 46).addBox(-2.0F, 0.0F, 0.0F, 4, 8, 3), PartPose.offsetAndRotation(0.0F, -4.2F, -3.1F, -0.31869712141416456F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(22, 63).mirror(true).addBox(-2.5F, 0.0F, -3.0F, 5, 7, 6), PartPose.offsetAndRotation(-2.7F, 3.0F, 1.9F, 0.27314402793711257F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(0, 63).addBox(-2.5F, 0.0F, -3.0F, 5, 7, 6), PartPose.offsetAndRotation(2.7F, 3.0F, 1.9F, 0.27314402793711257F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("SaddlebagLatchR", CubeListBuilder.create().texOffs(35, 58).mirror(true).addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1), PartPose.offset(-4.0F, 0.5F, 0.0F));
            partDefinition.addOrReplaceChild("Tail4", CubeListBuilder.create().texOffs(44, 19).addBox(-1.5F, 0.0F, 0.0F, 3, 4, 3), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 1.0471975511965976F, 0.017453292519943295F, 0.18203784098300857F));
            partDefinition.addOrReplaceChild("Saddlebag", CubeListBuilder.create().texOffs(24, 84).addBox(-4.5F, 0.0F, -3.0F, 9, 5, 6), PartPose.offset(0.0F, -0.7F, 7.9F));
            partDefinition.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(35, 12).addBox(-1.5F, 0.0F, 0.0F, 3, 4, 3), PartPose.offsetAndRotation(0.0F, 2.0F, -1.0F, 0.7740535232594852F, -0.008726646259971648F, 0.0F));
            partDefinition.addOrReplaceChild("Tail3", CubeListBuilder.create().texOffs(32, 19).addBox(-1.5F, 0.0F, 0.0F, 3, 4, 3), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 1.1838568316277536F, 0.22759093446006054F, 0.0F));
            partDefinition.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(44, 0).addBox(-2.0F, 0.0F, -2.8F, 4, 3, 3), PartPose.offsetAndRotation(0.0F, -0.6F, -3.0F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ArmBaseLeft", CubeListBuilder.create().texOffs(30, 28).addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4), PartPose.offsetAndRotation(2.4F, 1.3F, -0.1F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("LowerLegLeft", CubeListBuilder.create().texOffs(0, 84).addBox(-1.5F, 0.0F, -3.0F, 3, 5, 3), PartPose.offsetAndRotation(0.0F, 4.0F, 3.5F, -0.6373942428283291F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Muzzle", CubeListBuilder.create().texOffs(38, 57).addBox(-2.5F, 0.0F, 0.0F, 5, 5, 5), PartPose.offset(0.0F, -1.0F, -6.6F));
            partDefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 14).addBox(-3.5F, 0.0F, 0.0F, 7, 9, 9), PartPose.offsetAndRotation(0.0F, -4.0F, 2.0F, 0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("SaddlebagLatchL", CubeListBuilder.create().texOffs(35, 58).addBox(0.0F, 0.0F, -0.5F, 1, 2, 1), PartPose.offset(4.0F, 0.5F, 0.0F));
            partDefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 46).addBox(-2.5F, -5.0F, -2.5F, 5, 7, 5), PartPose.offsetAndRotation(0.0F, -2.2F, -0.3F, 0.6829473363053812F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(46, 6).addBox(-1.0F, 0.0F, -4.0F, 2, 0, 4), PartPose.offsetAndRotation(0.0F, 0.0F, 1.5F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(32, 37).addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(46, 50).mirror(true).addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3), PartPose.offsetAndRotation(0.1F, 3.0F, 2.4F, 0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("UpperLegRight", CubeListBuilder.create().texOffs(16, 76).mirror(true).addBox(-2.0F, 0.0F, 0.0F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, 7.0F, -2.4F, 0.5462880558742251F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ForearmRight", CubeListBuilder.create().texOffs(46, 44).mirror(true).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3), PartPose.offsetAndRotation(0.1F, 3.5F, -3.0F, -0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("UpperLegLeft", CubeListBuilder.create().texOffs(0, 76).addBox(-2.0F, 0.0F, 0.0F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, 7.0F, -2.4F, 0.5009094953223726F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("HandLeft", CubeListBuilder.create().texOffs(34, 50).addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3), PartPose.offsetAndRotation(-0.1F, 3.0F, 2.4F, 0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("shape42", CubeListBuilder.create().texOffs(44, 67).addBox(-3.0F, 0.0F, 0.0F, 6, 3, 2), PartPose.offsetAndRotation(0.0F, -2.6F, 2.0F, -0.36425021489121656F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(0, 92).addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3), PartPose.offset(-0.1F, 5.0F, -0.9F));
            partDefinition.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(52, 14).addBox(-1.5F, 0.0F, -2.45F, 3, 1, 3), PartPose.offsetAndRotation(0.0F, 2.8F, 0.0F, -0.22759093446006054F, 0.0F, 0.0F));

            return LayerDefinition.create(meshDefinition, 64, 128);
        }

        @Override
        public void playIdleAnimation(AkitaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? 1.0F : 0.68F);
            this.Head.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.59F;
            if (!entity.isInSittingPose() && !entity.isLying()) {
                this.Tail1.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 1.2F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
                this.Tail2.zRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F;
            }
        }

        @Override
        public void playMovementAnimation(AkitaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
                this.ArmBaseLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.14F;
                this.ArmLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F + -0.04F;
                this.HandLeft.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.09F;
                this.ArmBaseRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.14F;
                this.ArmRight.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.5F) * limbSwingAmount * 0.5F + -0.04F;
                this.HandRight.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.09F;
                this.ArmBaseLeft.z = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + -0.1F;
                this.ArmBaseRight.z = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + -0.1F;
                this.Neck.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 0.68F;
                this.Head.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + -0.59F;
                this.ThighLeft.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.27F;
                this.UpperLegLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + 0.5F;
                this.LowerLegLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + -0.64F;
                this.FootLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.1F;
                this.ThighLeft.y = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 3.0F;
                this.ThighLeft.z = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + 1.9F;
                this.ThighRight.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.27F;
                this.UpperLegRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + 0.5F;
                this.LowerLegRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + -0.64F;
                this.FootRight.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.1F;
                this.ThighRight.y = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 3.0F;
                this.ThighRight.z = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 1.9F;
                this.Chest.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.05F) * limbSwingAmount * 0.5F + -0.05F;
                this.Body.xRot = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 0.04F;
                this.Hips.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + -0.15F;
                this.Neck.z = Mth.cos(5.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.07F) * limbSwingAmount * 0.5F + -0.3F;
                this.Tail1.xRot = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.5F) * limbSwingAmount * 0.5F + 1.14F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
                this.Chest.y = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.09F) * limbSwingAmount * 0.5F + 10.2F;
            }
        }

        @Override
        public void setSittingPose(AkitaEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmBaseLeft.setPos(2.4F, 0.7F, -0.6F);
            this.ArmBaseRight.setPos(-2.4F, 0.7F, -0.6F);
            this.Body.setPos(0.0F, -3.1F, 2.5F);
            this.Chest.setPos(0.0F, 11.0F, -5.7F);
            this.LowerLegLeft.setPos(0.6F, 6.4F, 3.5F);
            this.LowerLegRight.setPos(-0.6F, 6.4F, 3.5F);
            this.Neck.setPos(0.0F, -2.2F, -1.4F);
            this.setRotateAngle(ArmBaseLeft, 0.40980330836826856F, 0.0F, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.40980330836826856F, 0.0F, 0.0F);
            this.setRotateAngle(Body, -0.36425021489121656F, 0.0F, 0.0F);
            this.setRotateAngle(Chest, -0.31869712141416456F, 0.0F, 0.0F);
            this.setRotateAngle(FootLeft, 1.5025539530419183F, 0.0F, 0.0F);
            this.setRotateAngle(FootRight, 1.5025539530419183F, 0.0F, 0.0F);
            this.setRotateAngle(Hips, -0.31869712141416456F, 0.0F, 0.0F);
            this.setRotateAngle(LowerLegLeft, -1.8668041679331349F, 0.0F, 0.0F);
            this.setRotateAngle(LowerLegRight, -1.8668041679331349F, 0.0F, 0.0F);
            this.setRotateAngle(Neck, 1.0016444577195458F, 0.0F, 0.0F);
            this.setRotateAngle(Tail1, 1.8212510744560826F, 0.0F, 0.0F);
            this.setRotateAngle(Tail2, 0.36425021489121656F, 0.5462880558742251F, -0.5009094953223726F);
            this.setRotateAngle(Tail3, 0.6829473363053812F, 0.27314402793711257F, 0.0F);
            this.setRotateAngle(Tail4, 1.0016444577195458F, 0.017453292519943295F, 0.18203784098300857F);
            this.setRotateAngle(ThighLeft, -1.0927506446736497F, -0.136659280431156F, -0.18203784098300857F);
            this.setRotateAngle(ThighRight, -1.0927506446736497F, 0.136659280431156F, 0.18203784098300857F);
            this.setRotateAngle(UpperLegLeft, 2.41309222380736F, 0.0F, 0.0F);
            this.setRotateAngle(UpperLegRight, 2.41309222380736F, 0.0F, 0.0F);
            this.ThighLeft.setPos(2.7F, 3.0F, 4.9F);
            this.ThighRight.setPos(-2.7F, 3.0F, 4.9F);
            this.UpperLegLeft.setPos(0.0F, 6.9F, 2.6F);
            this.UpperLegRight.setPos(0.0F, 6.9F, 2.6F);
        }

        @Override
        public void setLyingPose(AkitaEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmBaseLeft.setPos(2.5F, -0.7F, -0.1F);
            this.setRotateAngle(ArmBaseLeft, 0.18203784098300857F, -0.22759093446006054F, -0.31869712141416456F);
            this.ForearmLeft.setPos(-0.1F, 3.5F, -3.0F);
            this.setRotateAngle(ForearmLeft, 0.045553093477052F, 0.0F, 0.0F);
            this.ArmLeft.setPos(0.2F, 7.0F, 1.5F);
            this.setRotateAngle(ArmLeft, -1.6390387005478748F, 0.136659280431156F, 0.36425021489121656F);
            this.HandLeft.setPos(-0.1F, 2.8F, 2.1F);
            this.setRotateAngle(HandLeft, 1.6845917940249266F, 0.0F, 0.0F);
            this.ArmBaseRight.setPos(-2.6F, -1.7F, -0.1F);
            this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.31869712141416456F, 0.0F);
            this.ForearmRight.setPos(0.1F, 4.0F, -2.9F);
            this.setRotateAngle(ForearmRight, 0.045553093477052F, 0.0F, 0.0F);
            this.ArmRight.setPos(-0.8F, 6.6F, 1.5F);
            this.setRotateAngle(ArmRight, -1.593485607070823F, 0.0F, 0.0F);
            this.HandRight.setPos(0.1F, 2.9F, 2.0F);
            this.setRotateAngle(HandRight, 1.593485607070823F, 0.0F, 0.0F);
            this.ThighLeft.setPos(2.7F, 7.5F, 4.3F);
            this.setRotateAngle(ThighLeft, -2.0943951023931953F, 0.045553093477052F, 0.18203784098300857F);
            this.UpperLegLeft.setPos(0.0F, 6.1F, 3.0F);
            this.setRotateAngle(UpperLegLeft, 2.231054382824351F, 0.22759093446006054F, 0.0F);
            this.setRotateAngle(LowerLegLeft, -1.4570008595648662F, 0.0F, 0.0F);
            this.setRotateAngle(FootLeft, 1.6845917940249266F, 0.0F, 0.0F);
            this.ThighRight.setPos(-2.7F, 5.0F, 0.9F);
            this.setRotateAngle(ThighRight, 0.136659280431156F, 0.36425021489121656F, -0.9105382707654417F);
            this.UpperLegRight.setPos(0.0F, 7.0F, -2.4F);
            this.setRotateAngle(UpperLegRight, 0.8651597102135892F, 0.0F, 0.0F);
            this.setRotateAngle(LowerLegRight, -0.6373942428283291F, 0.0F, 0.0F);
            this.setRotateAngle(FootRight, 1.6845917940249266F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 3.0F, 3.9F);
            this.setRotateAngle(Tail1, 1.1383037381507017F, 0.6829473363053812F, 1.6390387005478748F);
            this.setRotateAngle(Tail3, 1.0471975511965976F, 0.22759093446006054F, 0.0F);
            this.Head.setPos(0.0F, -4.6F, 0.0F);
            this.setRotateAngle(Head, -1.9123572614101867F, 0.0F, 0.0F);
            this.Chest.setPos(0.0F, 18.2F, -5.7F);
            this.Body.setPos(-0.4F, -3.6F, 2.0F);
            this.setRotateAngle(Body, -0.045553093477052F, -0.091106186954104F, -0.136659280431156F);
            this.Hips.setPos(0.0F, 0.6F, 9.0F);
            this.setRotateAngle(Hips, -0.18203784098300857F, 0.0F, -0.31869712141416456F);
            this.Neck.setPos(0.0F, -0.2F, -2.3F);
            this.setRotateAngle(Neck, 2.1399481958702475F, 0.0F, 0.0F);
        }

        @Override
        public void resetPose(AkitaEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmBaseLeft.setPos(2.4F, 1.3F, -0.1F);
            this.ForearmLeft.setPos(-0.1F, 3.5F, -3.0F);
            this.ArmLeft.setPos(0.0F, 5.0F, 1.5F);
            this.HandLeft.setPos(-0.1F, 3.0F, 2.4F);
            this.ArmBaseRight.setPos(-2.4F, 1.3F, -0.1F);
            this.ForearmRight.setPos(0.1F, 3.5F, -3.0F);
            this.ArmRight.setPos(0.0F, 5.0F, 1.5F);
            this.HandRight.setPos(0.1F, 3.0F, 2.4F);
            this.Head.setPos(0.0F, -4.2F, -0.9F);
            this.setRotateAngle(Head, -0.5918411493512771F, 0.0F, 0.0F);
            this.Body.setPos(0.0F, -4.0F, 2.0F);
            this.Chest.setPos(0.0F, 10.2F, -5.7F);
            this.Hips.setPos(0.0F, 0.0F, 9.0F);
            this.setRotateAngle(Hips, -0.18203784098300857F, 0.0F, 0.0F);
            this.LowerLegLeft.setPos(0.0F, 4.0F, 3.5F);
            this.LowerLegRight.setPos(0.0F, 4.0F, 3.5F);
            this.Neck.setPos(0.0F, -2.2F, -0.3F);
            this.setRotateAngle(ArmBaseLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.setRotateAngle(ForearmLeft, -0.136659280431156F, 0.0F, 0.0F);
            this.setRotateAngle(ArmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.setRotateAngle(HandLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.0F, 0.0F);
            this.setRotateAngle(ForearmRight, -0.136659280431156F, 0.0F, 0.0F);
            this.setRotateAngle(ArmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.setRotateAngle(HandRight, 0.091106186954104F, 0.0F, 0.0F);
            this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.setRotateAngle(FootLeft, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(FootRight, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(Hips, -0.18203784098300857F, 0.0F, 0.0F);
            this.setRotateAngle(LowerLegLeft, -0.6373942428283291F, 0.0F, 0.0F);
            this.setRotateAngle(LowerLegRight, -0.6373942428283291F, 0.0F, 0.0F);
            this.setRotateAngle(Neck, 0.6829473363053812F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 3.0F, 5.0F);
            this.setRotateAngle(Tail1, 1.1383037381507017F, 0.0F, 0.0F);
            this.setRotateAngle(Tail2, 0.7740535232594852F, -0.008726646259971648F, 0.0F);
            this.setRotateAngle(Tail3, 1.1838568316277536F, 0.22759093446006054F, 0.0F);
            this.setRotateAngle(Tail4, 1.0471975511965976F, 0.017453292519943295F, 0.18203784098300857F);
            this.setRotateAngle(ThighLeft, 0.27314402793711257F, 0.0F, 0.0F);
            this.setRotateAngle(ThighRight, 0.27314402793711257F, 0.0F, 0.0F);
            this.setRotateAngle(UpperLegLeft, 0.5009094953223726F, 0.0F, 0.0F);
            this.setRotateAngle(UpperLegRight, 0.5462880558742251F, 0.0F, 0.0F);
            this.ThighLeft.setPos(2.7F, 3.0F, 1.9F);
            this.ThighRight.setPos(-2.7F, 3.0F, 1.9F);
            this.UpperLegLeft.setPos(0.0F, 7.0F, -2.4F);
            this.UpperLegRight.setPos(0.0F, 7.0F, -2.4F);
        }
    }

    public static class Baby extends AkitaModel {
        public ModelPart EarFlapLeft;
        public ModelPart EarFlapRight;
        public ModelPart LegLeft;
        public ModelPart LegRight;

        public Baby(ModelPart root) {
            this.Chest = root.getChild("Chest");
            this.EarFlapLeft = this.EarLeft.getChild("EarFlapLeft");
            this.ThighRight = this.Body.getChild("ThighRight");
            this.EarRight = this.Head.getChild("EarRight");
            this.HandRight = this.ArmRight.getChild("HandRight");
            this.Mouth = this.Snout.getChild("Mouth");
            this.LegLeft = this.ThighLeft.getChild("LegLeft");
            this.HandLeft = this.ArmLeft.getChild("HandLeft");
            this.Snout = this.Head.getChild("Snout");
            this.FootRight = this.LegRight.getChild("FootRight");
            this.ArmLeft = this.Chest.getChild("ArmLeft");
            this.LegRight = this.ThighRight.getChild("LegRight");
            this.Tail3 = this.Tail2.getChild("Tail3");
            this.ThighLeft = this.Body.getChild("ThighLeft");
            this.Tail1 = this.Body.getChild("Tail1");
            this.ArmRight = this.Chest.getChild("ArmRight");
            this.EarFlapRight = this.EarRight.getChild("EarFlapRight");
            this.FootLeft = this.LegLeft.getChild("FootLeft");
            this.EarLeft = this.Head.getChild("EarLeft");
            this.Neck = this.Chest.getChild("Neck");
            this.Body = this.Chest.getChild("Body");
            this.Head = this.Neck.getChild("Head");
            this.TopSnout = this.Snout.getChild("TopSnout");
            this.Tail2 = this.Tail1.getChild("Tail2");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshDefinition = new MeshDefinition();
            PartDefinition partDefinition = meshDefinition.getRoot();

            partDefinition.addOrReplaceChild("EarFlapLeft", CubeListBuilder.create().texOffs(16, 9).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(44, 0).mirror(true).addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3), PartPose.offset(-1.7F, 1.3F, 3.0F));
            partDefinition.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(14, 12).mirror(true).addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1), PartPose.offsetAndRotation(-1.1F, -0.2F, 0.4F, 0.136659280431156F, 0.091106186954104F, -0.31869712141416456F));
            partDefinition.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(32, 20).mirror(true).addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.1F, 3.5F, 0.6F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(10, 25).addBox(-1.0F, -1.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, 2.3F, 0.2F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("LegLeft", CubeListBuilder.create().texOffs(34, 7).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(-0.1F, 4.0F, -1.1F, 0.4553564018453205F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("HandLeft", CubeListBuilder.create().texOffs(24, 20).addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(-0.1F, 3.5F, 0.6F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, 0.0F, -2.0F, 3, 2, 2), PartPose.offset(0.0F, 0.2F, -1.3F));
            partDefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -2.0F, 5, 5, 4), PartPose.offsetAndRotation(0.0F, 19.1F, -2.0F, -0.045553093477052F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(45, 11).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.1F, 2.0F, 2.0F, -0.40980330836826856F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(24, 15).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(1.7F, 1.0F, -0.5F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("LegRight", CubeListBuilder.create().texOffs(45, 7).mirror(true).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(0.1F, 4.0F, -1.1F, 0.4553564018453205F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Tail3", CubeListBuilder.create().texOffs(16, 22).addBox(-1.0F, -1.0F, 0.0F, 2, 1, 2), PartPose.offsetAndRotation(0.02F, 1.0F, 0.0F, -0.5462880558742251F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3), PartPose.offset(1.7F, 1.3F, 3.0F));
            partDefinition.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(14, 15).addBox(-1.0F, -2.0F, -2.0F, 2, 2, 2), PartPose.offsetAndRotation(0.0F, 2.0F, 4.0F, -0.8196066167365371F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(32, 15).mirror(true).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(-1.7F, 1.0F, -0.5F, 0.136659280431156F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarFlapRight", CubeListBuilder.create().texOffs(20, 12).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(34, 11).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(-0.1F, 2.0F, 2.0F, -0.40980330836826856F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(10, 9).addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1), PartPose.offsetAndRotation(1.1F, -0.2F, 0.4F, 0.136659280431156F, -0.091106186954104F, 0.31869712141416456F));
            partDefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, -2.7F, -2.1F, 3, 4, 4), PartPose.offsetAndRotation(0.0F, -1.3F, -0.7F, 0.6829473363053812F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, 0.0F, 0.0F, 4, 5, 4), PartPose.offset(0.0F, -2.5F, 2.0F));
            partDefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, -2.1F, -0.2F, -0.5918411493512771F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("TopSnout", CubeListBuilder.create().texOffs(8, 28).addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2), PartPose.offsetAndRotation(0.0F, -0.4F, -0.1F, 0.091106186954104F, 0.0F, 0.0F));
            partDefinition.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(16, 19).addBox(-1.0F, 0.0F, 0.0F, 2, 1, 2), PartPose.offsetAndRotation(0.02F, -2.0F, -1.9F, -1.3203415791337103F, 0.0F, 0.0F));

            return LayerDefinition.create(meshDefinition, 64, 32);
        }

        @Override
        public void playIdleAnimation(AkitaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? 1.23F : 0.68F);
            this.Head.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.59F;
            if (!entity.isInSittingPose() && !entity.isLying()) {
                this.Tail1.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + -0.82F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
                this.Tail2.zRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F;
            }
        }

        @Override
        public void playMovementAnimation(AkitaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 0.8f;
            this.ArmLeft.xRot = Mth.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 3.0F) * limbSwingAmount * 0.5F;
            this.ArmRight.xRot = Mth.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * -3.0F) * limbSwingAmount * 0.5F;
            this.ThighLeft.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + -0.05F;
            this.LegLeft.xRot = Mth.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * -1.5F) * limbSwingAmount * 0.5F + 0.6F;
            this.ThighRight.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + -0.05F;
            this.LegRight.xRot = Mth.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 1.5F) * limbSwingAmount * 0.5F + 0.6F;
            this.Neck.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + 0.8F;
            this.Head.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.6F;
            this.Chest.xRot = Mth.cos(3.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.07F) * limbSwingAmount * 0.5F + -0.03F;
            this.Body.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.025F;
            this.Chest.y = Mth.cos(4.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.03F) * limbSwingAmount * 0.5F + 19.1F;
            this.Tail1.zRot = Mth.cos(2.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F;
        }

        @Override
        public void setSittingPose(AkitaEntity entity, float speed, float walkSpeed, float partialTick) {
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
            this.Tail1.setPos(-0.3F, 1.0F, 3.2F);
            this.ThighLeft.setPos(1.7F, 1.3F, 4.4F);
            this.ThighRight.setPos(-1.7F, 1.3F, 4.4F);
        }

        @Override
        public void setLyingPose(AkitaEntity entity, float speed, float walkSpeed, float partialTick) {

        }

        @Override
        public void resetPose(AkitaEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmLeft.setPos(1.7F, 1.0F, -0.5F);
            this.setRotateAngle(ArmLeft, 0.136659280431156F, 0.0F, 0.0F);
            this.ArmRight.setPos(-1.7F, 1.0F, -0.5F);
            this.setRotateAngle(ArmRight, 0.136659280431156F, 0.0F, 0.0F);
            this.Neck.setPos(0.0F, -1.3F, -0.7F);
            this.setRotateAngle(Neck, 0.6829473363053812F, 0.0F, 0.0F);
            this.setRotateAngle(Body, 0.0F, 0.0F, 0.0F);
            this.Chest.setPos(0.0F, 19.1F, -2.0F);
            this.setRotateAngle(Chest, -0.045553093477052F, 0.0F, 0.0F);
            this.setRotateAngle(Head, -0.5918411493512771F, 0.0F, 0.0F);
            this.ThighLeft.setPos(1.7F, 1.3F, 3.0F);
            this.setRotateAngle(ThighLeft, 0.0F, 0.0F, 0.0F);
            this.ThighRight.setPos(-1.7F, 1.3F, 3.0F);
            this.setRotateAngle(ThighRight, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(LegLeft, 0.4553564018453205F, 0.0F, 0.0F);
            this.setRotateAngle(LegRight, 0.4553564018453205F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 2.0F, 4.0F);
            this.setRotateAngle(Tail1, -0.8196066167365371F, 0.0F, 0.0F);
        }
    }
}
