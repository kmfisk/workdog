package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.GermanShepherdEntity;
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

public abstract class GermanShepherdModel extends WorkDogModel<GermanShepherdEntity> {
    public static ModelLayerLocation ADULT_LAYER = new ModelLayerLocation(new ResourceLocation(WorkDog.MOD_ID, "german_shepherd"), "adult");
    public static ModelLayerLocation EQUIPMENT_LAYER = new ModelLayerLocation(new ResourceLocation(WorkDog.MOD_ID, "german_shepherd"), "equipment");
    public static ModelLayerLocation BABY_LAYER = new ModelLayerLocation(new ResourceLocation(WorkDog.MOD_ID, "german_shepherd"), "baby");
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

    public static class Adult extends GermanShepherdModel {
        public ModelPart ArmBaseLeft;
        public ModelPart ArmBaseRight;
        public ModelPart Hips;
        public ModelPart Saddlebag;
        public ModelPart shape42;
        public ModelPart BellyFur;
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
        public ModelPart ForearmLeft;
        public ModelPart ForearmRight;
        
        public Adult(ModelPart root) {
            this.Chest = root.getChild("Chest");
            this.ArmBaseRight = this.Chest.getChild("ArmBaseRight");
            this.ArmRight = this.ArmBaseRight.getChild("ArmRight");
            this.ForearmRight = this.ArmRight.getChild("ForearmRight");
            this.HandRight = this.ForearmRight.getChild("HandRight");

            this.Neck = this.Chest.getChild("Neck");
            this.NeckLower = this.Neck.getChild("NeckLower");

            this.Collar = this.Neck.getChild("Collar");

            this.NeckFurLeft = this.Neck.getChild("NeckFurLeft");

            this.NeckFur2 = this.Neck.getChild("NeckFur2");

            this.NeckFurRight = this.Neck.getChild("NeckFurRight");

            this.Head = this.Neck.getChild("Head");
            this.FaceFurLeft = this.Head.getChild("FaceFurLeft");

            this.Muzzle = this.Head.getChild("Muzzle");

            this.EarLeft = this.Head.getChild("EarLeft");

            this.FaceFurRight = this.Head.getChild("FaceFurRight");

            this.Snout = this.Head.getChild("Snout");
            this.TopSnout = this.Snout.getChild("TopSnout");

            this.Mouth = this.Snout.getChild("Mouth");
            this.Tongue = this.Mouth.getChild("Tongue");

            this.EarRight = this.Head.getChild("EarRight");

            this.Body = this.Chest.getChild("Body");
            this.Hips = this.Body.getChild("Hips");
            this.Tail1 = this.Hips.getChild("Tail1");
            this.TailFur1 = this.Tail1.getChild("TailFur1");

            this.Tail2 = this.Tail1.getChild("Tail2");
            this.TailFur2 = this.Tail2.getChild("TailFur2");

            this.ThighLeft = this.Hips.getChild("ThighLeft");
            this.UpperLegLeft = this.ThighLeft.getChild("UpperLegLeft");
            this.LowerLegLeft = this.UpperLegLeft.getChild("LowerLegLeft");
            this.FootLeft = this.LowerLegLeft.getChild("FootLeft");

            this.ThighRight = this.Hips.getChild("ThighRight");
            this.UpperLegRight = this.ThighRight.getChild("UpperLegRight");
            this.LowerLegRight = this.UpperLegRight.getChild("LowerLegRight");
            this.FootRight = this.LowerLegRight.getChild("FootRight");

            this.Saddlebag = this.Body.getChild("Saddlebag");
            this.SaddlebagLatchL = this.Saddlebag.getChild("SaddlebagLatchL");

            this.SaddlebagLatchR = this.Saddlebag.getChild("SaddlebagLatchR");

            this.shape42 = this.Body.getChild("shape42");

            this.BellyFur = this.Body.getChild("BellyFur");

            this.ArmBaseLeft = this.Chest.getChild("ArmBaseLeft");
            this.ArmLeft = this.ArmBaseLeft.getChild("ArmLeft");
            this.ForearmLeft = this.ArmLeft.getChild("ForearmLeft");
            this.HandLeft = this.ForearmLeft.getChild("HandLeft");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshDefinition = new MeshDefinition();
            PartDefinition partDefinition = meshDefinition.getRoot();

            PartDefinition Chest = partDefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -2.5F, 8, 9, 5), PartPose.offsetAndRotation(0.0F, 10.1F, -5.7F, -0.09093165402890456F, 0.0F, 0.0F));
            PartDefinition Body = Chest.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 14).addBox(-3.5F, 0.0F, 0.0F, 7, 9, 10), PartPose.offsetAndRotation(0.0F, -4.0F, 2.0F, 0.045553093477052F, 0.0F, 0.0F));
            PartDefinition Hips = Body.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(0, 33).addBox(-4.0F, 0.0F, 0.0F, 8, 9, 5), PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, -0.18203784098300857F, 0.0F, 0.0F));
            PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 47).addBox(-2.5F, -5.0F, -2.5F, 5, 7, 5), PartPose.offsetAndRotation(0.0F, -2.6F, -0.9F, 1.0189232173142897F, 0.0F, 0.0F));
            PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(26, 0).addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6), PartPose.offsetAndRotation(0.0F, -4.2F, -0.9F, -0.7742280561846846F, 0.0F, 0.0F));
            PartDefinition FaceFurLeft = Head.addOrReplaceChild("FaceFurLeft", CubeListBuilder.create().texOffs(0, 110).addBox(0.0F, 0.0F, 0.0F, 4, 4, 5), PartPose.offsetAndRotation(-0.7F, 0.0F, -3.4F, 0.0F, 0.136659280431156F, 0.0F));
            PartDefinition Tail1 = Hips.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(40, 19).addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3), PartPose.offsetAndRotation(0.0F, 1.5F, 4.5F, 1.2747884856566583F, 0.0F, 0.0F));
            PartDefinition TailFur1 = Tail1.addOrReplaceChild("TailFur1", CubeListBuilder.create().texOffs(46, 106).addBox(-2.5F, 0.0F, -4.0F, 5, 6, 4), PartPose.offset(0.0F, 0.0F, -0.2F));
            PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(52, 17).addBox(-1.5F, 0.0F, 0.0F, 3, 6, 3), PartPose.offsetAndRotation(0.0F, 5.0F, -2.0F, 0.27314402793711257F, 0.0F, 0.0F));
            PartDefinition Saddlebag = Body.addOrReplaceChild("Saddlebag", CubeListBuilder.create().texOffs(24, 85).addBox(-4.5F, 0.0F, -3.0F, 9, 5, 6), PartPose.offset(0.0F, -0.7F, 9.9F));
            PartDefinition SaddlebagLatchL = Saddlebag.addOrReplaceChild("SaddlebagLatchL", CubeListBuilder.create().texOffs(35, 58).addBox(0.0F, 0.0F, -0.5F, 1, 2, 1), PartPose.offset(4.0F, 0.5F, 0.0F));
            PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(24, 12).addBox(-2.0F, 0.0F, -3.5F, 4, 3, 4), PartPose.offsetAndRotation(0.1F, -0.8F, -3.0F, 0.136659280431156F, 0.0F, 0.0F));
            PartDefinition Mouth = Snout.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(36, 12).addBox(-1.5F, 0.0F, -3.05F, 3, 1, 3), PartPose.offsetAndRotation(0.0F, 2.7F, 0.0F, -0.136659280431156F, 0.0F, 0.0F));
            PartDefinition Tongue = Mouth.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(46, 6).addBox(-1.0F, 0.0F, -4.0F, 2, 0, 4), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition TopSnout = Snout.addOrReplaceChild("TopSnout", CubeListBuilder.create().texOffs(48, 10).addBox(-1.5F, 0.0F, 0.0F, 3, 2, 5), PartPose.offsetAndRotation(0.0F, 0.0F, -3.8F, 0.136659280431156F, 0.0F, 0.0F));
            PartDefinition NeckLower = Neck.addOrReplaceChild("NeckLower", CubeListBuilder.create().texOffs(20, 47).addBox(-2.0F, 0.0F, 0.0F, 4, 8, 3), PartPose.offsetAndRotation(0.0F, -4.2F, -3.7F, -0.31869712141416456F, 0.0F, 0.0F));
            PartDefinition ArmBaseLeft = Chest.addOrReplaceChild("ArmBaseLeft", CubeListBuilder.create().texOffs(30, 29).addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4), PartPose.offsetAndRotation(2.4F, 1.3F, -0.1F, 0.20996310901491783F, 0.0F, 0.0F));
            PartDefinition ArmLeft = ArmBaseLeft.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(32, 38).addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition ThighLeft = Hips.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(0, 63).addBox(-2.5F, 0.0F, -2.5F, 5, 7, 5), PartPose.offsetAndRotation(2.7F, 2.3F, 2.9F, 0.27314402793711257F, 0.0F, 0.0F));
            PartDefinition UpperLegLeft = ThighLeft.addOrReplaceChild("UpperLegLeft", CubeListBuilder.create().texOffs(0, 75).addBox(-2.0F, 0.0F, 0.0F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, 7.0F, -2.4F, 0.5009094953223726F, 0.0F, 0.0F));
            PartDefinition Collar = Neck.addOrReplaceChild("Collar", CubeListBuilder.create().texOffs(32, 76).addBox(-3.0F, 0.0F, -3.5F, 6, 1, 8), PartPose.offset(0.0F, -1.3F, -1.6F));
            PartDefinition Muzzle = Head.addOrReplaceChild("Muzzle", CubeListBuilder.create().texOffs(38, 57).addBox(-2.5F, 0.0F, 0.0F, 5, 5, 5), PartPose.offset(0.0F, -1.2F, -6.8F));
            PartDefinition ArmBaseRight = Chest.addOrReplaceChild("ArmBaseRight", CubeListBuilder.create().texOffs(46, 29).mirror(true).addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4), PartPose.offsetAndRotation(-2.4F, 1.3F, -0.1F, 0.24137903555081577F, 0.0F, 0.0F));
            PartDefinition ArmRight = ArmBaseRight.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(44, 38).mirror(true).addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition ThighRight = Hips.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(20, 63).mirror(true).addBox(-2.5F, 0.0F, -2.5F, 5, 7, 5), PartPose.offsetAndRotation(-2.7F, 2.3F, 2.9F, 0.27314402793711257F, 0.0F, 0.0F));
            PartDefinition UpperLegRight = ThighRight.addOrReplaceChild("UpperLegRight", CubeListBuilder.create().texOffs(16, 75).mirror(true).addBox(-2.0F, 0.0F, 0.0F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, 7.0F, -2.4F, 0.5462880558742251F, 0.0F, 0.0F));
            PartDefinition LowerLegRight = UpperLegRight.addOrReplaceChild("LowerLegRight", CubeListBuilder.create().texOffs(12, 83).mirror(true).addBox(-1.5F, 0.0F, -3.0F, 3, 5, 3), PartPose.offsetAndRotation(0.0F, 4.0F, 3.5F, -0.6373942428283291F, 0.0F, 0.0F));
            PartDefinition FootRight = LowerLegRight.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(12, 91).mirror(true).addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3), PartPose.offsetAndRotation(0.1F, 5.0F, -0.9F, 0.045553093477052F, 0.0F, 0.0F));
            PartDefinition ForearmRight = ArmRight.addOrReplaceChild("ForearmRight", CubeListBuilder.create().texOffs(46, 45).mirror(true).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3), PartPose.offsetAndRotation(0.1F, 3.5F, -3.0F, -0.136659280431156F, 0.0F, 0.0F));
            PartDefinition ForearmLeft = ArmLeft.addOrReplaceChild("ForearmLeft", CubeListBuilder.create().texOffs(34, 45).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3), PartPose.offsetAndRotation(-0.1F, 3.5F, -3.0F, -0.136659280431156F, 0.0F, 0.0F));
            PartDefinition HandLeft = ForearmLeft.addOrReplaceChild("HandLeft", CubeListBuilder.create().texOffs(34, 51).addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3), PartPose.offsetAndRotation(-0.1F, 3.0F, 2.4F, 0.091106186954104F, 0.0F, 0.0F));
            PartDefinition EarLeft = Head.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(44, 0).addBox(-1.5F, -2.5F, 0.0F, 3, 4, 1), PartPose.offsetAndRotation(1.7F, -3.0F, 0.0F, 0.4553564018453205F, 0.091106186954104F, 0.22759093446006054F));
            PartDefinition FaceFurRight = Head.addOrReplaceChild("FaceFurRight", CubeListBuilder.create().texOffs(18, 110).mirror(true).addBox(-4.0F, 0.0F, 0.0F, 4, 4, 5), PartPose.offsetAndRotation(0.7F, 0.0F, -3.4F, 0.0F, -0.136659280431156F, 0.0F));
            PartDefinition TailFur2 = Tail2.addOrReplaceChild("TailFur2", CubeListBuilder.create().texOffs(33, 114).addBox(-2.0F, 0.0F, 0.0F, 4, 8, 5), PartPose.offsetAndRotation(0.0F, 0.0F, -2.5F, 0.045553093477052F, 0.0F, 0.0F));
            PartDefinition NeckFurLeft = Neck.addOrReplaceChild("NeckFurLeft", CubeListBuilder.create().texOffs(21, 96).addBox(-1.5F, 0.0F, 0.0F, 3, 5, 4), PartPose.offsetAndRotation(1.3F, -4.7F, -3.7F, -0.7740535232594852F, 0.136659280431156F, 0.0F));
            PartDefinition HandRight = ForearmRight.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(46, 51).mirror(true).addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3), PartPose.offsetAndRotation(0.1F, 3.0F, 2.4F, 0.091106186954104F, 0.0F, 0.0F));
            PartDefinition LowerLegLeft = UpperLegLeft.addOrReplaceChild("LowerLegLeft", CubeListBuilder.create().texOffs(0, 83).addBox(-1.5F, 0.0F, -3.0F, 3, 5, 3), PartPose.offsetAndRotation(0.0F, 4.0F, 3.5F, -0.6373942428283291F, 0.0F, 0.0F));
            PartDefinition FootLeft = LowerLegLeft.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(0, 91).addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3), PartPose.offsetAndRotation(-0.1F, 5.0F, -0.9F, 0.045553093477052F, 0.0F, 0.0F));
            PartDefinition SaddlebagLatchR = Saddlebag.addOrReplaceChild("SaddlebagLatchR", CubeListBuilder.create().texOffs(35, 58).mirror(true).addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1), PartPose.offset(-4.0F, 0.5F, 0.0F));
            PartDefinition shape42 = Body.addOrReplaceChild("shape42", CubeListBuilder.create().texOffs(44, 67).addBox(-3.0F, 0.0F, 0.0F, 6, 3, 2), PartPose.offsetAndRotation(0.0F, -2.6F, 3.0F, -0.36425021489121656F, 0.0F, 0.0F));
            PartDefinition NeckFur2 = Neck.addOrReplaceChild("NeckFur2", CubeListBuilder.create().texOffs(35, 96).addBox(-2.0F, 0.0F, 0.0F, 4, 6, 4), PartPose.offsetAndRotation(0.01F, -1.7F, -5.7F, -0.4553564018453205F, 0.0F, 0.0F));
            PartDefinition NeckFurRight = Neck.addOrReplaceChild("NeckFurRight", CubeListBuilder.create().texOffs(21, 96).mirror(true).addBox(-1.5F, 0.0F, 0.0F, 3, 5, 4), PartPose.offsetAndRotation(-1.3F, -4.7F, -3.7F, -0.7740535232594852F, -0.136659280431156F, 0.0F));
            PartDefinition EarRight = Head.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(52, 0).mirror(true).addBox(-1.5F, -2.5F, 0.0F, 3, 4, 1), PartPose.offsetAndRotation(-1.7F, -3.0F, 0.0F, 0.5009094953223726F, 0.091106186954104F, -0.22759093446006054F));
            PartDefinition BellyFur = Body.addOrReplaceChild("BellyFur", CubeListBuilder.create().texOffs(0, 96).addBox(-2.5F, 0.0F, 0.0F, 5, 3, 11), PartPose.offsetAndRotation(0.0F, 8.7F, -0.5F, 0.18203784098300857F, 0.0F, 0.0F));

            return LayerDefinition.create(meshDefinition, 64, 128);
        }

        @Override
        public void playIdleAnimation(GermanShepherdEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? 1.0F : 1.01F);
            this.Head.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? -0.5F : -0.77F);
            if (!entity.isInSittingPose() && !entity.isLying()) {
                this.Tail1.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 1.27F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
                this.Tail2.zRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F;
            }
        }

        @Override
        public void playMovementAnimation(GermanShepherdEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
                this.ArmBaseLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.14F;
                this.ArmLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F + -0.04F;
                this.HandLeft.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.09F;
                this.ArmBaseRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.14F;
                this.ArmRight.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.5F) * limbSwingAmount * 0.5F + -0.04F;
                this.HandRight.xRot = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.09F;
                this.ArmBaseLeft.z = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + -0.1F;
                this.ArmBaseRight.z = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + -0.1F;
                this.Neck.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 1.01F;
                this.Head.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + -0.77F;
                this.ThighLeft.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.27F;
                this.UpperLegLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + 0.5F;
                this.LowerLegLeft.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + -0.64F;
                this.FootLeft.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F + 0.1F;
                this.ThighLeft.y = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 2.3F;
                this.ThighLeft.z = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + 0.03F + 2.9F;
                this.ThighRight.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.27F;
                this.UpperLegRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + 0.5F;
                this.LowerLegRight.xRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + -0.64F;
                this.FootRight.xRot = Mth.cos(5.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F + 0.1F;
                this.ThighRight.y = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.1F) * limbSwingAmount * 0.5F + 2.3F;
                this.ThighRight.z = Mth.cos(4.0F + (limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + 2.9F;
                this.Chest.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.05F) * limbSwingAmount * 0.5F + -0.09F;
                this.Body.xRot = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.1F) * limbSwingAmount * 0.5F + 0.05F;
                this.Hips.xRot = Mth.cos(2.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.2F) * limbSwingAmount * 0.5F + -0.18F;
                this.Neck.z = Mth.cos(5.0F + (limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.07F) * limbSwingAmount * 0.5F + -0.9F;
                this.Tail1.xRot = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * 0.5F) * limbSwingAmount * 0.5F + 1.27F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.25F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
                this.Chest.y = Mth.cos((limbSwing * speed * 0.5F) + (float) Math.PI) * (degree * -0.09F) * limbSwingAmount * 0.5F + 10.1F;
            }
        }

        @Override
        public void setSittingPose(GermanShepherdEntity entity, float speed, float walkSpeed, float partialTick) {
            this.ArmBaseLeft.setPos(2.4F, 2.3F, 0.9F);
            this.ArmBaseRight.setPos(-2.4F, 2.3F, 0.9F);
            this.Body.setPos(0.0F, -3.6F, 2.0F);
            this.Chest.setPos(0.0F, 9.2F, -5.7F);
            this.FootLeft.setPos(-0.1F, 4.7F, -0.8F);
            this.FootRight.setPos(0.1F, 4.7F, -0.8F);
            this.LowerLegLeft.setPos(0.6F, 4.4F, 3.5F);
            this.LowerLegRight.setPos(-0.6F, 4.4F, 3.5F);
            this.Neck.setPos(0.0F, -2.2F, -1.4F);
            this.setRotateAngle(ArmBaseLeft, 0.5009094953223726F, 0.0F, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.5009094953223726F, 0.0F, 0.0F);
            this.setRotateAngle(BellyFur, 0.5009094953223726F, 0.0F, 0.0F);
            this.setRotateAngle(Body, -0.40980330836826856F, 0.0F, 0.0F);
            this.setRotateAngle(Chest, -0.40980330836826856F, 0.0F, 0.0F);
            this.setRotateAngle(FootLeft, 1.7756979809790308F, 0.0F, 0.0F);
            this.setRotateAngle(FootRight, 1.7756979809790308F, 0.0F, 0.0F);
            this.setRotateAngle(Head, -0.5462880558742251F, 0.0F, 0.0F);
            this.setRotateAngle(LowerLegLeft, -1.730144887501979F, 0.0F, 0.0F);
            this.setRotateAngle(LowerLegRight, -1.730144887501979F, 0.0F, 0.0F);
            this.setRotateAngle(Neck, 1.0471975511965976F, 0.0F, 0.0F);
            this.setRotateAngle(Tail1, 1.8668041679331349F, -0.6373942428283291F, 0.0F);
            this.setRotateAngle(Tail2, 0.27314402793711257F, 0.0F, 0.6373942428283291F);
            this.setRotateAngle(ThighLeft, -1.2292353921796064F, -0.091106186954104F, -0.136659280431156F);
            this.setRotateAngle(ThighRight, -1.2292353921796064F, 0.091106186954104F, 0.136659280431156F);
            this.setRotateAngle(UpperLegLeft, 2.321986036853256F, 0.0F, 0.0F);
            this.setRotateAngle(UpperLegRight, 2.321986036853256F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 2.5F, 4.5F);
            this.ThighLeft.setPos(3.1F, 4.5F, 7.6F);
            this.ThighRight.setPos(-3.1F, 4.5F, 7.6F);
            this.UpperLegLeft.setPos(0.3F, 7.0F, 2.6F);
            this.UpperLegRight.setPos(-0.3F, 7.0F, 2.6F);

        }

        @Override
        public void setLyingPose(GermanShepherdEntity entity, float speed, float walkSpeed, float partialTick) {
            this.UpperLegRight.setPos(0.0F, 7.0F, 2.5F);
            this.setRotateAngle(UpperLegRight, 2.5497515042385164F, 0.0F, 0.0F);
            this.LowerLegRight.setPos(0.0F, 5.5F, 3.5F);
            this.setRotateAngle(LowerLegRight, -1.593485607070823F, 0.0F, 0.0F);
            this.Mouth.setPos(0.0F, 2.7F, 0.0F);
            this.setRotateAngle(Mouth, -0.136659280431156F, 0.0F, 0.0F);
            this.Hips.setPos(0.0F, 0.0F, 9.0F);
            this.setRotateAngle(Hips, -0.18203784098300857F, 0.22759093446006054F, 0.0F);
            this.LowerLegLeft.setPos(0.0F, 5.0F, 3.5F);
            this.setRotateAngle(LowerLegLeft, -1.4570008595648662F, 0.0F, 0.0F);
            this.FaceFurLeft.setPos(-0.7F, 0.0F, -3.4F);
            this.setRotateAngle(FaceFurLeft, 0.0F, 0.136659280431156F, 0.0F);
            this.Head.setPos(0.4F, -5.4F, 0.5F);
            this.setRotateAngle(Head, -1.1383037381507017F, -0.5462880558742251F, 0.7285004297824331F);
            this.ArmRight.setPos(0.0F, 6.3F, 1.5F);
            this.setRotateAngle(ArmRight, -1.593485607070823F, 0.0F, 0.0F);
            this.ForearmLeft.setPos(-0.1F, 3.5F, -3.0F);
            this.setRotateAngle(ForearmLeft, 0.045553093477052F, 0.0F, 0.0F);
            this.TailFur1.setPos(0.0F, 0.0F, -0.2F);
            this.Chest.setPos(-2.0F, 17.4F, 0.3F);
            this.setRotateAngle(Chest, -0.09093165402890456F, 1.1383037381507017F, 0.0F);
            this.Saddlebag.setPos(0.0F, -0.7F, 9.9F);
            this.ArmLeft.setPos(0.0F, 7.0F, 1.5F);
            this.setRotateAngle(ArmLeft, -1.5481070465189704F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 1.5F, 4.3F);
            this.setRotateAngle(Tail1, 0.9105382707654417F, 0.0F, 0.0F);
            this.ArmBaseRight.setPos(-2.4F, 0.4F, -0.9F);
            this.setRotateAngle(ArmBaseRight, 0.136659280431156F, 0.0F, 0.0F);
            this.Collar.setPos(0.0F, -1.3F, -1.6F);
            this.HandLeft.setPos(-0.1F, 2.7F, 2.4F);
            this.setRotateAngle(HandLeft, 1.593485607070823F, 0.0F, 0.0F);
            this.Snout.setPos(0.1F, -0.8F, -3.0F);
            this.setRotateAngle(Snout, 0.136659280431156F, 0.0F, 0.0F);
            this.ThighLeft.setPos(2.7F, 6.5F, 5.9F);
            this.setRotateAngle(ThighLeft, -2.0943951023931953F, -0.36425021489121656F, 0.0F);
            this.SaddlebagLatchR.setPos(-4.0F, 0.5F, 0.0F);
            this.NeckFurLeft.setPos(1.3F, -4.7F, -3.7F);
            this.setRotateAngle(NeckFurLeft, -0.7740535232594852F, 0.136659280431156F, 0.0F);
            this.ArmBaseLeft.setPos(2.9F, -0.7F, -0.1F);
            this.setRotateAngle(ArmBaseLeft, 0.045553093477052F, 0.0F, 0.0F);
            this.NeckLower.setPos(0.3F, -5.3F, -2.7F);
            this.setRotateAngle(NeckLower, -0.31869712141416456F, 0.0F, 0.0F);
            this.Tail2.setPos(0.0F, 5.0F, -2.0F);
            this.setRotateAngle(Tail2, 0.27314402793711257F, 0.0F, -0.5918411493512771F);
            this.SaddlebagLatchL.setPos(4.0F, 0.5F, 0.0F);
            this.shape42.setPos(0.0F, -2.6F, 3.0F);
            this.setRotateAngle(shape42, -0.36425021489121656F, 0.0F, 0.0F);
            this.NeckFur2.setPos(0.01F, -1.7F, -5.7F);
            this.setRotateAngle(NeckFur2, -0.4553564018453205F, 0.0F, 0.0F);
            this.FaceFurRight.setPos(0.7F, 0.0F, -3.4F);
            this.setRotateAngle(FaceFurRight, 0.0F, -0.136659280431156F, 0.0F);
            this.HandRight.setPos(0.1F, 2.5F, 1.8F);
            this.setRotateAngle(HandRight, 1.4114477660878142F, 0.0F, 0.0F);
            this.ThighRight.setPos(-2.7F, 7.3F, 4.9F);
            this.setRotateAngle(ThighRight, -2.231054382824351F, 0.0F, 0.0F);
            this.UpperLegLeft.setPos(0.0F, 7.0F, 2.0F);
            this.setRotateAngle(UpperLegLeft, 2.231054382824351F, 0.0F, 0.0F);
            this.Tongue.setPos(0.0F, 0.0F, 0.5F);
            this.setRotateAngle(Tongue, -0.045553093477052F, 0.0F, 0.0F);
            this.EarRight.setPos(-1.7F, -3.0F, 0.0F);
            this.setRotateAngle(EarRight, 0.5009094953223726F, 0.091106186954104F, -0.22759093446006054F);
            this.TailFur2.setPos(0.0F, 0.0F, -2.5F);
            this.setRotateAngle(TailFur2, 0.045553093477052F, 0.0F, 0.0F);
            this.NeckFurRight.setPos(-1.3F, -4.7F, -3.7F);
            this.setRotateAngle(NeckFurRight, -0.7740535232594852F, -0.136659280431156F, 0.0F);
            this.EarLeft.setPos(1.7F, -3.0F, 0.0F);
            this.setRotateAngle(EarLeft, 0.4553564018453205F, 0.091106186954104F, 0.22759093446006054F);
            this.ForearmRight.setPos(0.1F, 3.5F, -3.0F);
            this.setRotateAngle(ForearmRight, 0.091106186954104F, 0.0F, 0.0F);
            this.Muzzle.setPos(0.0F, -1.2F, -6.8F);
            this.TopSnout.setPos(0.0F, 0.0F, -3.8F);
            this.setRotateAngle(TopSnout, 0.136659280431156F, 0.0F, 0.0F);
            this.Body.setPos(0.0F, -3.9F, 1.8F);
            this.setRotateAngle(Body, 0.0F, 0.27314402793711257F, 0.0F);
            this.BellyFur.setPos(0.0F, 8.7F, -0.5F);
            this.setRotateAngle(BellyFur, 0.18203784098300857F, 0.0F, 0.0F);
            this.Neck.setPos(0.0F, -1.9F, -0.3F);
            this.setRotateAngle(Neck, 1.0189232173142897F, -0.40980330836826856F, 0.0F);
            this.FootRight.setPos(0.1F, 4.7F, -1.2F);
            this.setRotateAngle(FootRight, 1.5481070465189704F, 0.0F, 0.0F);
            this.FootLeft.setPos(-0.1F, 5.0F, -0.9F);
            this.setRotateAngle(FootLeft, 1.5481070465189704F, 0.0F, 0.0F);
        }

        @Override
        public void resetPose(GermanShepherdEntity entity, float speed, float walkSpeed, float partialTick) {
            this.Hips.setPos(0.0F, 0.0F, 10.0F);
            this.setRotateAngle(Hips, -0.18203784098300857F, 0.0F, 0.0F);
            this.FaceFurLeft.setPos(-0.7F, 0.0F, -3.4F);
            this.setRotateAngle(FaceFurLeft, 0.0F, 0.136659280431156F, 0.0F);
            this.TailFur1.setPos(0.0F, 0.0F, -0.2F);
            this.Tail2.setPos(0.0F, 5.0F, -2.0F);
            this.setRotateAngle(Tail2, 0.27314402793711257F, 0.0F, 0.0F);
            this.Tongue.setPos(0.0F, 0.0F, 0.5F);
            this.setRotateAngle(Tongue, -0.045553093477052F, 0.0F, 0.0F);
            this.TopSnout.setPos(0.0F, 0.0F, -3.8F);
            this.setRotateAngle(TopSnout, 0.136659280431156F, 0.0F, 0.0F);
            this.NeckLower.setPos(0.0F, -4.2F, -3.7F);
            this.setRotateAngle(NeckLower, -0.31869712141416456F, 0.0F, 0.0F);
            this.ArmLeft.setPos(0.0F, 5.0F, 1.5F);
            this.setRotateAngle(ArmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.UpperLegLeft.setPos(0.0F, 7.0F, -2.4F);
            this.setRotateAngle(UpperLegLeft, 0.5009094953223726F, 0.0F, 0.0F);
            this.ArmBaseRight.setPos(-2.4F, 1.3F, -0.1F);
            this.setRotateAngle(ArmBaseRight, 0.24137903555081577F, 0.0F, 0.0F);
            this.ArmRight.setPos(0.0F, 5.0F, 1.5F);
            this.setRotateAngle(ArmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.FootRight.setPos(0.1F, 5.0F, -0.9F);
            this.setRotateAngle(FootRight, 0.045553093477052F, 0.0F, 0.0F);
            this.HandLeft.setPos(-0.1F, 3.0F, 2.4F);
            this.setRotateAngle(HandLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.Neck.setPos(0.0F, -2.6F, -0.9F);
            this.setRotateAngle(Neck, 1.0189232173142897F, 0.0F, 0.0F);
            this.EarLeft.setPos(1.7F, -3.0F, 0.0F);
            this.setRotateAngle(EarLeft, 0.4553564018453205F, 0.091106186954104F, 0.22759093446006054F);
            this.FaceFurRight.setPos(0.7F, 0.0F, -3.4F);
            this.setRotateAngle(FaceFurRight, 0.0F, -0.136659280431156F, 0.0F);
            this.UpperLegRight.setPos(0.0F, 7.0F, -2.4F);
            this.setRotateAngle(UpperLegRight, 0.5462880558742251F, 0.0F, 0.0F);
            this.Snout.setPos(0.1F, -0.8F, -3.0F);
            this.setRotateAngle(Snout, 0.136659280431156F, 0.0F, 0.0F);
            this.TailFur2.setPos(0.0F, 0.0F, -2.5F);
            this.setRotateAngle(TailFur2, 0.045553093477052F, 0.0F, 0.0F);
            this.NeckFurLeft.setPos(1.3F, -4.7F, -3.7F);
            this.setRotateAngle(NeckFurLeft, -0.7740535232594852F, 0.136659280431156F, 0.0F);
            this.Mouth.setPos(0.0F, 2.7F, 0.0F);
            this.setRotateAngle(Mouth, -0.136659280431156F, 0.0F, 0.0F);
            this.HandRight.setPos(0.1F, 3.0F, 2.4F);
            this.setRotateAngle(HandRight, 0.091106186954104F, 0.0F, 0.0F);
            this.FootLeft.setPos(-0.1F, 5.0F, -0.9F);
            this.setRotateAngle(FootLeft, 0.045553093477052F, 0.0F, 0.0F);
            this.Tail1.setPos(0.0F, 1.5F, 4.5F);
            this.setRotateAngle(Tail1, 1.2747884856566583F, 0.0F, 0.0F);
            this.shape42.setPos(0.0F, -2.6F, 3.0F);
            this.setRotateAngle(shape42, -0.36425021489121656F, 0.0F, 0.0F);
            this.ForearmLeft.setPos(-0.1F, 3.5F, -3.0F);
            this.setRotateAngle(ForearmLeft, -0.136659280431156F, 0.0F, 0.0F);
            this.Chest.setPos(0.0F, 10.1F, -5.7F);
            this.setRotateAngle(Chest, -0.09093165402890456F, 0.0F, 0.0F);
            this.ThighLeft.setPos(2.7F, 2.3F, 2.9F);
            this.setRotateAngle(ThighLeft, 0.27314402793711257F, 0.0F, 0.0F);
            this.NeckFur2.setPos(0.01F, -1.7F, -5.7F);
            this.setRotateAngle(NeckFur2, -0.4553564018453205F, 0.0F, 0.0F);
            this.NeckFurRight.setPos(-1.3F, -4.7F, -3.7F);
            this.setRotateAngle(NeckFurRight, -0.7740535232594852F, -0.136659280431156F, 0.0F);
            this.EarRight.setPos(-1.7F, -3.0F, 0.0F);
            this.setRotateAngle(EarRight, 0.5009094953223726F, 0.091106186954104F, -0.22759093446006054F);
            this.ThighRight.setPos(-2.7F, 2.3F, 2.9F);
            this.setRotateAngle(ThighRight, 0.27314402793711257F, 0.0F, 0.0F);
            this.LowerLegLeft.setPos(0.0F, 4.0F, 3.5F);
            this.setRotateAngle(LowerLegLeft, -0.6373942428283291F, 0.0F, 0.0F);
            this.Body.setPos(0.0F, -4.0F, 2.0F);
            this.setRotateAngle(Body, 0.045553093477052F, 0.0F, 0.0F);
            this.LowerLegRight.setPos(0.0F, 4.0F, 3.5F);
            this.setRotateAngle(LowerLegRight, -0.6373942428283291F, 0.0F, 0.0F);
            this.ForearmRight.setPos(0.1F, 3.5F, -3.0F);
            this.setRotateAngle(ForearmRight, -0.136659280431156F, 0.0F, 0.0F);
            this.ArmBaseLeft.setPos(2.4F, 1.3F, -0.1F);
            this.setRotateAngle(ArmBaseLeft, 0.20996310901491783F, 0.0F, 0.0F);
            this.BellyFur.setPos(0.0F, 8.7F, -0.5F);
            this.setRotateAngle(BellyFur, 0.18203784098300857F, 0.0F, 0.0F);
            this.Head.setPos(0.0F, -4.2F, -0.9F);
            this.setRotateAngle(Head, -0.7742280561846846F, 0.0F, 0.0F);
        }
    }

    public static class Baby extends GermanShepherdModel {
        public ModelPart LegLeft;
        public ModelPart LegRight;
        public ModelPart EarFlapLeft;
        public ModelPart EarFlapRight;

        public Baby(ModelPart root) {
            this.Chest = root.getChild("Chest");
            this.ArmLeft = this.Chest.getChild("ArmLeft");
            this.HandLeft = this.ArmLeft.getChild("HandLeft");

            this.Body = this.Chest.getChild("Body");
            this.ThighLeft = this.Body.getChild("ThighLeft");
            this.LegLeft = this.ThighLeft.getChild("LegLeft");
            this.FootLeft = this.LegLeft.getChild("FootLeft");

            this.Tail1 = this.Body.getChild("Tail1");

            this.ThighRight = this.Body.getChild("ThighRight");
            this.LegRight = this.ThighRight.getChild("LegRight");
            this.FootRight = this.LegRight.getChild("FootRight");

            this.ArmRight = this.Chest.getChild("ArmRight");
            this.HandRight = this.ArmRight.getChild("HandRight");

            this.Neck = this.Chest.getChild("Neck");
            this.Head = this.Neck.getChild("Head");
            this.Snout = this.Head.getChild("Snout");
            this.Mouth = this.Snout.getChild("Mouth");

            this.TopSnout = this.Snout.getChild("TopSnout");

            this.EarLeft = this.Head.getChild("EarLeft");
            this.EarFlapLeft = this.EarLeft.getChild("EarFlapLeft");

            this.EarRight = this.Head.getChild("EarRight");
            this.EarFlapRight = this.EarRight.getChild("EarFlapRight");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshDefinition = new MeshDefinition();
            PartDefinition partDefinition = meshDefinition.getRoot();

            PartDefinition Chest = partDefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -2.0F, 5, 5, 4), PartPose.offsetAndRotation(0.0F, 19.5F, -2.0F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition ArmLeft = Chest.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(24, 15).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(1.7F, 0.7F, -0.5F, 0.136659280431156F, 0.0F, 0.0F));
            PartDefinition Body = Chest.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, 0.0F, 0.0F, 4, 5, 4), PartPose.offset(0.0F, -2.5F, 2.0F));
            PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, -2.7F, -2.1F, 3, 4, 4), PartPose.offsetAndRotation(0.0F, -1.3F, -0.7F, 0.7285004297824331F, 0.0F, 0.0F));
            PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4), PartPose.offsetAndRotation(0.0F, -2.1F, -0.2F, -0.6373942428283291F, 0.0F, 0.0F));
            PartDefinition ThighLeft = Body.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3), PartPose.offset(1.7F, 0.9F, 2.7F));
            PartDefinition EarRight = Head.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(14, 12).mirror(true).addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1), PartPose.offsetAndRotation(-1.1F, -0.2F, 0.4F, 0.136659280431156F, 0.091106186954104F, -0.31869712141416456F));
            PartDefinition EarFlapRight = EarRight.addOrReplaceChild("EarFlapRight", CubeListBuilder.create().texOffs(20, 12).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(27, 24).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 4), PartPose.offsetAndRotation(0.0F, 0.4F, 4.0F, -0.7285004297824331F, 0.0F, 0.0F));
            PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, 0.0F, -2.0F, 3, 2, 2), PartPose.offset(0.0F, 0.1F, -1.3F));
            PartDefinition LegLeft = ThighLeft.addOrReplaceChild("LegLeft", CubeListBuilder.create().texOffs(34, 7).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(-0.1F, 4.0F, -1.1F, 0.4553564018453205F, 0.0F, 0.0F));
            PartDefinition FootLeft = LegLeft.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(34, 11).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(-0.1F, 2.0F, 2.0F, -0.40980330836826856F, 0.0F, 0.0F));
            PartDefinition HandLeft = ArmLeft.addOrReplaceChild("HandLeft", CubeListBuilder.create().texOffs(24, 20).addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(-0.1F, 3.5F, 0.6F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition TopSnout = Snout.addOrReplaceChild("TopSnout", CubeListBuilder.create().texOffs(8, 28).addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2), PartPose.offsetAndRotation(0.0F, -0.4F, -0.1F, 0.091106186954104F, 0.0F, 0.0F));
            PartDefinition EarLeft = Head.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(10, 9).addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1), PartPose.offsetAndRotation(1.1F, -0.7F, 0.4F, 0.136659280431156F, -0.091106186954104F, 0.31869712141416456F));
            PartDefinition EarFlapLeft = EarLeft.addOrReplaceChild("EarFlapLeft", CubeListBuilder.create().texOffs(16, 9).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition ArmRight = Chest.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(32, 15).mirror(true).addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2), PartPose.offsetAndRotation(-1.7F, 0.7F, -0.5F, 0.136659280431156F, 0.0F, 0.0F));
            PartDefinition HandRight = ArmRight.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(32, 20).mirror(true).addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.1F, 3.5F, 0.6F, -0.091106186954104F, 0.0F, 0.0F));
            PartDefinition Mouth = Snout.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(10, 25).addBox(-1.0F, -1.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.0F, 2.1F, 0.2F, -0.045553093477052F, 0.0F, 0.0F));
            PartDefinition ThighRight = Body.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(44, 0).mirror(true).addBox(-1.0F, 0.0F, -1.5F, 2, 4, 3), PartPose.offset(-1.7F, 0.9F, 2.7F));
            PartDefinition LegRight = ThighRight.addOrReplaceChild("LegRight", CubeListBuilder.create().texOffs(45, 7).mirror(true).addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2), PartPose.offsetAndRotation(0.1F, 4.0F, -1.1F, 0.4553564018453205F, 0.0F, 0.0F));
            PartDefinition FootRight = LegRight.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(45, 11).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2), PartPose.offsetAndRotation(0.1F, 2.0F, 2.0F, -0.40980330836826856F, 0.0F, 0.0F));

            return LayerDefinition.create(meshDefinition, 64, 32);
        }

        @Override
        public void playIdleAnimation(GermanShepherdEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.Neck.xRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.2F) * limbSwingAmount * 0.5F + (entity.isInSittingPose() ? 1.23F : 0.68F);
            this.Head.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.3F) * limbSwingAmount * 0.5F + -0.59F;
            if (!entity.isInSittingPose() && !entity.isLying()) {
                this.Tail1.xRot = Mth.cos(1.0F + (limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * 0.3F) * limbSwingAmount * 0.5F + -0.82F;
                this.Tail1.yRot = Mth.cos((limbSwing * speed * 0.1F) + (float) Math.PI) * (degree * -0.5F) * limbSwingAmount * 0.5F;
            }
        }

        @Override
        public void playMovementAnimation(GermanShepherdEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
            this.Chest.y = Mth.cos(4.0F + (limbSwing * speed * 0.6F) + (float) Math.PI) * (degree * -0.03F) * limbSwingAmount * 0.5F + 19.5F;
            this.Tail1.zRot = Mth.cos(2.0F + (limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F;
        }

        @Override
        public void setSittingPose(GermanShepherdEntity entity, float speed, float walkSpeed, float partialTick) {
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
        public void setLyingPose(GermanShepherdEntity entity, float speed, float walkSpeed, float partialTick) {

        }

        @Override
        public void resetPose(GermanShepherdEntity entity, float speed, float walkSpeed, float partialTick) {
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
            this.LegLeft.setPos(-0.1F, 4.0F, -1.1F);
            this.setRotateAngle(LegLeft, 0.4553564018453205F, 0.0F, 0.0F);
            this.LegRight.setPos(0.1F, 4.0F, -1.1F);
            this.setRotateAngle(LegRight, 0.4553564018453205F, 0.0F, 0.0F);
        }
    }
}
