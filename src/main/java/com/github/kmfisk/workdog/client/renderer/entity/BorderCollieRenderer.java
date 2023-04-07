package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.BorderCollieModel;
import com.github.kmfisk.workdog.entity.BorderCollieEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class BorderCollieRenderer extends WorkDogRenderer<BorderCollieEntity, BorderCollieModel> {
    public BorderCollieRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new BorderCollieModel.Adult(), 0.5f);
        adultModel = model;
        babyModel = new BorderCollieModel.Baby();
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
        variants = new String[]{
                "black", "black_skim", "black_light", "black_heavy", "black_tri", "blue_skim", "blue_light", "blue_heavy",
                "blue_merle", "chocolate_skim", "chocolate_light", "chocolate_heavy", "red_merle", "tan", "white"
        };
    }
}
