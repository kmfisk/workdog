package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.layers.BostonTerrierEquipmentLayer;
import com.github.kmfisk.workdog.client.renderer.entity.model.BostonTerrierModel;
import com.github.kmfisk.workdog.entity.BostonTerrierEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Locale;

public class BostonTerrierRenderer extends WorkDogRenderer<BostonTerrierEntity, BostonTerrierModel> {
    public BostonTerrierRenderer(EntityRendererProvider.Context context) {
        super(context, new BostonTerrierModel.Adult(context.bakeLayer(BostonTerrierModel.ADULT_LAYER)), 0.5f);
        adultModel = model;
        babyModel = new BostonTerrierModel.Baby(context.bakeLayer(BostonTerrierModel.BABY_LAYER));
        addLayer(new BostonTerrierEquipmentLayer(this, context.getModelSet()));
    }

    @Override
    protected void scale(BostonTerrierEntity entity, PoseStack matrixStack, float partialTickTime) {
        matrixStack.scale(0.8F, 0.8F, 0.8F);
    }

    @Override
    public void setupBabyTextureLocations(BostonTerrierEntity entity) {
        baby_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/boston_terrier/bostonterrier_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(BostonTerrierEntity entity) {
        adult_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/boston_terrier/bostonterrier_");
    }

    @Override
    public void setupVariants() {
        variants = new ArrayList<>();
        for (BostonTerrierEntity.BostonTerrierVariant variant : BostonTerrierEntity.BostonTerrierVariant.values())
            variants.add(variant.name().toLowerCase(Locale.ROOT));
    }
}
