package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.BorderCollieModel;
import com.github.kmfisk.workdog.entity.BorderCollieEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Locale;

public class BorderCollieRenderer extends WorkDogRenderer<BorderCollieEntity, BorderCollieModel> {
    public BorderCollieRenderer(EntityRendererProvider.Context context) {
        super(context, new BorderCollieModel.Adult(context.bakeLayer(BorderCollieModel.ADULT_LAYER)), 0.5f);
        adultModel = model;
        babyModel = new BorderCollieModel.Baby(context.bakeLayer(BorderCollieModel.BABY_LAYER));
    }

    @Override
    protected void scale(BorderCollieEntity entity, PoseStack matrixStack, float partialTickTime) {
        matrixStack.scale(0.9F, 0.9F, 0.9F);
    }

    @Override
    public void setupBabyTextureLocations(BorderCollieEntity entity) {
        baby_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(BorderCollieEntity entity) {
        adult_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/border_collie/bordercollie_");
    }

    @Override
    public void setupVariants() {
        variants = new ArrayList<>();
        for (BorderCollieEntity.BorderCollieVariant variant : BorderCollieEntity.BorderCollieVariant.values())
            variants.add(variant.name().toLowerCase(Locale.ROOT));
    }
}
