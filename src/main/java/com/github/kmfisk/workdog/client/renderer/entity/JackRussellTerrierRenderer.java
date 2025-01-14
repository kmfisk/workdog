package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.JackRussellTerrierModel;
import com.github.kmfisk.workdog.entity.JackRussellTerrierEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Locale;

public class JackRussellTerrierRenderer extends WorkDogRenderer<JackRussellTerrierEntity, JackRussellTerrierModel> {
    public JackRussellTerrierRenderer(EntityRendererProvider.Context context) {
        super(context, new JackRussellTerrierModel.Adult(context.bakeLayer(JackRussellTerrierModel.ADULT_LAYER)), 0.5f);
        adultModel = model;
        babyModel = new JackRussellTerrierModel.Baby(context.bakeLayer(JackRussellTerrierModel.BABY_LAYER));
    }

    @Override
    protected void scale(JackRussellTerrierEntity entity, PoseStack matrixStack, float partialTickTime) {
        matrixStack.scale(0.8F, 0.8F, 0.8F);
    }

    @Override
    public void setupBabyTextureLocations(JackRussellTerrierEntity entity) {
        baby_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/jack_russell_terrier/jackrussell_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(JackRussellTerrierEntity entity) {
        adult_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/jack_russell_terrier/jackrussell_");
    }

    @Override
    public void setupVariants() {
        variants = new ArrayList<>();
        for (JackRussellTerrierEntity.JackRussellTerrierVariant variant : JackRussellTerrierEntity.JackRussellTerrierVariant.values())
            variants.add(variant.name().toLowerCase(Locale.ROOT));
    }
}
