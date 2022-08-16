package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkingDogs;
import com.github.kmfisk.workdog.client.renderer.entity.model.WDWolfModel;
import com.github.kmfisk.workdog.entity.WDWolfEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class WDWolfRenderer extends WorkDogRenderer<WDWolfEntity, WDWolfModel> {
    public WDWolfRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new WDWolfModel.Adult(), 0.5f);
        adultModel = model;
        babyModel = new WDWolfModel.Baby();
    }

    @Override
    public void setupBabyTextureLocations(WDWolfEntity entity) {
        baby_loc = new ResourceLocation(WorkingDogs.MOD_ID, "textures/entity/wolf/wolf_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(WDWolfEntity entity) {
        adult_loc = new ResourceLocation(WorkingDogs.MOD_ID, "textures/entity/wolf/wolf_");
    }

    @Override
    public void setupVariants() {
        variants = new String[]{
                "albino", "black", "brown", "gray", "melanistic", "white"
        };
    }
}
