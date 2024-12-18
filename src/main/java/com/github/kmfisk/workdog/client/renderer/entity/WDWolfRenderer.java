package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.WDWolfModel;
import com.github.kmfisk.workdog.entity.WDWolfEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Locale;

public class WDWolfRenderer extends WorkDogRenderer<WDWolfEntity, WDWolfModel> {
    public WDWolfRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new WDWolfModel.Adult(), 0.5f);
        adultModel = model;
        babyModel = new WDWolfModel.Baby();
    }

    @Override
    protected void scale(WDWolfEntity entity, MatrixStack matrixStack, float partialTickTime) {
        matrixStack.scale(1.1F, 1.1F, 1.1F);
    }

    @Override
    public void setupBabyTextureLocations(WDWolfEntity entity) {
        baby_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/wolf/wolf_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(WDWolfEntity entity) {
        adult_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/wolf/wolf_");
    }

    @Override
    public void setupVariants() {
        variants = new ArrayList<>();
        for (WDWolfEntity.WolfVariant variant : WDWolfEntity.WolfVariant.values())
            variants.add(variant.name().toLowerCase(Locale.ROOT));
    }
}
