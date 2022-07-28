package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkingDogs;
import com.github.kmfisk.workdog.client.renderer.entity.model.BorderCollieModel;
import com.github.kmfisk.workdog.entity.BorderCollieEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class BorderCollieRenderer extends WorkDogRenderer<BorderCollieEntity, BorderCollieModel> {
    public BorderCollieRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new BorderCollieModel.Adult(), 0.5f);
    }

    @Override
    public void setupBabyTextureLocations(BorderCollieEntity entity) {
        baby_loc = new ResourceLocation(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(BorderCollieEntity entity) {
        adult_loc = new ResourceLocation(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_");
    }

    @Override
    public void setupVariants() {
        variants = new String[]{
                "albino", "black1", "black2", "black3", "black_tri", "blue", "blue_merle", "chocolate", "melanistic",
                "redmerle", "tan", "white"
        };
    }
}
