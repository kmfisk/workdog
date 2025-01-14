package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.PitBullModel;
import com.github.kmfisk.workdog.entity.PitBullEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Locale;

public class PitBullRenderer extends WorkDogRenderer<PitBullEntity, PitBullModel> {
    public PitBullRenderer(EntityRendererProvider.Context context) {
        super(context, new PitBullModel.Adult(context.bakeLayer(PitBullModel.ADULT_LAYER)), 0.5f);
        adultModel = model;
        babyModel = new PitBullModel.Baby(context.bakeLayer(PitBullModel.BABY_LAYER));
    }

    @Override
    protected void scale(PitBullEntity entity, PoseStack matrixStack, float partialTickTime) {
        matrixStack.scale(0.9F, 0.9F, 0.9F);
    }

    @Override
    public void setupBabyTextureLocations(PitBullEntity entity) {
        baby_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/pit_bull/pitbull_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(PitBullEntity entity) {
        adult_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/pit_bull/pitbull_");
    }

    @Override
    public void setupVariants() {
        variants = new ArrayList<>();
        for (PitBullEntity.PitBullVariant variant : PitBullEntity.PitBullVariant.values())
            variants.add(variant.name().toLowerCase(Locale.ROOT));
    }
}
