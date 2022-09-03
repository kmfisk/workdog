package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkingDogs;
import com.github.kmfisk.workdog.client.renderer.entity.model.JackRussellTerrierModel;
import com.github.kmfisk.workdog.entity.JackRussellTerrierEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class JackRussellTerrierRenderer extends WorkDogRenderer<JackRussellTerrierEntity, JackRussellTerrierModel> {
    public JackRussellTerrierRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new JackRussellTerrierModel.Adult(), 0.5f);
        adultModel = model;
        babyModel = new JackRussellTerrierModel.Baby();
    }

    @Override
    public void setupBabyTextureLocations(JackRussellTerrierEntity entity) {
        baby_loc = new ResourceLocation(WorkingDogs.MOD_ID, "textures/entity/jack_russell_terrier/jackrussell_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(JackRussellTerrierEntity entity) {
        adult_loc = new ResourceLocation(WorkingDogs.MOD_ID, "textures/entity/jack_russell_terrier/jackrussell_");
    }

    @Override
    public void setupVariants() {
        variants = new String[]{
                "black_and_tan", "black", "brown_ears", "brown_face", "brown_saddle", "heavy_tri", "light_tri",
                "mid_tri", "white"
        };
    }
}
