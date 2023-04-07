package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.PitBullModel;
import com.github.kmfisk.workdog.entity.PitBullEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class PitBullRenderer extends WorkDogRenderer<PitBullEntity, PitBullModel> {
    public PitBullRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new PitBullModel.Adult(), 0.5f);
        adultModel = model;
        babyModel = new PitBullModel.Baby();
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
        variants = new String[]{
                "black", "black_pinto", "blue_brindle", "blue_pinto", "brown_brindle", "brown_pinto", "dark_blue",
                "dark_brown", "dark_red", "fawn", "light_blue", "light_brown", "light_red", "red_pinto", "white"
        };
    }
}
