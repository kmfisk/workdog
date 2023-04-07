package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.BostonTerrierModel;
import com.github.kmfisk.workdog.entity.BostonTerrierEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class BostonTerrierRenderer extends WorkDogRenderer<BostonTerrierEntity, BostonTerrierModel> {
    public BostonTerrierRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new BostonTerrierModel.Adult(), 0.5f);
        adultModel = model;
        babyModel = new BostonTerrierModel.Baby();
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
        variants = new String[]{
                "black", "black_and_white", "blue", "brindle", "brown", "jade_black", "lilac", "white"
        };
    }
}
