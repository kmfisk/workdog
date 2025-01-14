package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.AkitaModel;
import com.github.kmfisk.workdog.entity.AkitaEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Locale;

public class AkitaRenderer extends WorkDogRenderer<AkitaEntity, AkitaModel> {
    public AkitaRenderer(EntityRendererProvider.Context context) {
        super(context, new AkitaModel.Adult(context.bakeLayer(AkitaModel.ADULT_LAYER)), 0.5f);
        adultModel = model;
        babyModel = new AkitaModel.Baby(context.bakeLayer(AkitaModel.BABY_LAYER));
    }

    @Override
    protected void scale(AkitaEntity entity, PoseStack matrixStack, float partialTickTime) {
        matrixStack.scale(0.9F, 0.9F, 0.9F);
    }

    @Override
    public void setupBabyTextureLocations(AkitaEntity entity) {
        baby_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/akita/akita_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(AkitaEntity entity) {
        adult_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/akita/akita_");
    }

    @Override
    public void setupVariants() {
        variants = new ArrayList<>();
        for (AkitaEntity.AkitaVariant variant : AkitaEntity.AkitaVariant.values())
            variants.add(variant.name().toLowerCase(Locale.ROOT));
    }
}
