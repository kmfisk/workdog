package com.github.kmfisk.workdog.client.renderer.entity.layers;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.BorderCollieModel;
import com.github.kmfisk.workdog.entity.BorderCollieEntity;
import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import com.github.kmfisk.workdog.item.DogEquipmentItem;
import com.github.kmfisk.workdog.item.DyeableDogEquipmentItem;
import com.github.kmfisk.workdog.item.SaddlebagItem;
import com.github.kmfisk.workdog.item.ServiceVestItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class BorderCollieEquipmentLayer extends RenderLayer<BorderCollieEntity, BorderCollieModel> {
    private final BorderCollieModel model;

    public BorderCollieEquipmentLayer(RenderLayerParent<BorderCollieEntity, BorderCollieModel> layerParent, EntityModelSet modelSet) {
        super(layerParent);
        model = new BorderCollieModel.Adult(modelSet.bakeLayer(BorderCollieModel.EQUIPMENT_LAYER));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, BorderCollieEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.hasSaddlebag()) {
            getParentModel().copyPropertiesTo(model);
            model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
            model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            int i = ((SaddlebagItem) entity.getSaddlebag().getItem()).getColor(entity.getSaddlebag());
            float f = (float) (i >> 16 & 255) / 255.0F;
            float f1 = (float) (i >> 8 & 255) / 255.0F;
            float f2 = (float) (i & 255) / 255.0F;
            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(new ResourceLocation(WorkDog.MOD_ID, "textures/entity/border_collie/equipment/bordercollie_saddlebag.png")));
            model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, f, f1, f2, 1.0F);
            VertexConsumer vertexConsumer2 = buffer.getBuffer(RenderType.entityCutoutNoCull(new ResourceLocation(WorkDog.MOD_ID, "textures/entity/border_collie/equipment/bordercollie_saddlebag_metal.png")));
            model.renderToBuffer(poseStack, vertexConsumer2, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }

        for (AbstractInventoryAnimal.DogEquipmentType dogEquipmentType : AbstractInventoryAnimal.DogEquipmentType.values()) {
            ItemStack equipmentStack = entity.getDogEquipment(dogEquipmentType);
            if (equipmentStack.getItem() instanceof DogEquipmentItem dogEquipmentItem) {
                getParentModel().copyPropertiesTo(model);
                model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
                model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                float f;
                float f1;
                float f2;
                if (dogEquipmentItem instanceof DyeableDogEquipmentItem dyedItem) {
                    int i = dyedItem.getColor(equipmentStack);
                    f = (float) (i >> 16 & 255) / 255.0F;
                    f1 = (float) (i >> 8 & 255) / 255.0F;
                    f2 = (float) (i & 255) / 255.0F;
                } else {
                    f = 1.0F;
                    f1 = 1.0F;
                    f2 = 1.0F;
                }

                if (dogEquipmentType != AbstractInventoryAnimal.DogEquipmentType.VEST || dogEquipmentItem instanceof DyeableDogEquipmentItem) {
                    String typeLang = dogEquipmentType.toString().toLowerCase();
                    if (dogEquipmentType == AbstractInventoryAnimal.DogEquipmentType.VEST) typeLang = "hogvest";
                    VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(new ResourceLocation(WorkDog.MOD_ID, "textures/entity/border_collie/equipment/bordercollie_" + typeLang + ".png")));
                    model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, f, f1, f2, 1.0F);
                    VertexConsumer vertexConsumer2 = buffer.getBuffer(RenderType.entityCutoutNoCull(new ResourceLocation(WorkDog.MOD_ID, "textures/entity/border_collie/equipment/bordercollie_" + typeLang + "_metal.png")));
                    model.renderToBuffer(poseStack, vertexConsumer2, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

                } else if (dogEquipmentItem instanceof ServiceVestItem serviceVestItem) {
                    VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(new ResourceLocation(WorkDog.MOD_ID, "textures/entity/border_collie/equipment/bordercollie_service_" + serviceVestItem.getColor().getName() + ".png")));
                    model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, f, f1, f2, 1.0F);
                }
            }
        }
    }
}
