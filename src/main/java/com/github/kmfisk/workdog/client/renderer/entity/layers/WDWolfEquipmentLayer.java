package com.github.kmfisk.workdog.client.renderer.entity.layers;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.WDWolfModel;
import com.github.kmfisk.workdog.entity.WDWolfEntity;
import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import com.github.kmfisk.workdog.item.DogEquipmentItem;
import com.github.kmfisk.workdog.item.DyeableDogEquipmentItem;
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

public class WDWolfEquipmentLayer extends RenderLayer<WDWolfEntity, WDWolfModel> {
    private final WDWolfModel model;

    public WDWolfEquipmentLayer(RenderLayerParent<WDWolfEntity, WDWolfModel> layerParent, EntityModelSet modelSet) {
        super(layerParent);
        model = new WDWolfModel.Adult(modelSet.bakeLayer(WDWolfModel.EQUIPMENT_LAYER));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, WDWolfEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
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

                String typeLang = dogEquipmentType.toString().toLowerCase();
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(new ResourceLocation(WorkDog.MOD_ID, "textures/entity/wolf/equipment/wolf_" + typeLang + ".png")));
                model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, f, f1, f2, 1.0F);
                VertexConsumer vertexConsumer2 = buffer.getBuffer(RenderType.entityCutoutNoCull(new ResourceLocation(WorkDog.MOD_ID, "textures/entity/wolf/equipment/wolf_" + typeLang + "_metal.png")));
                model.renderToBuffer(poseStack, vertexConsumer2, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }
}
