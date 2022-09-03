package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkingDogs;
import com.github.kmfisk.workdog.client.renderer.entity.model.AkitaModel;
import com.github.kmfisk.workdog.entity.AkitaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class AkitaRenderer extends WorkDogRenderer<AkitaEntity, AkitaModel> {
    public AkitaRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new AkitaModel.Adult(), 0.5f);
        adultModel = model;
        babyModel = new AkitaModel.Baby();
    }

    @Override
    public void setupBabyTextureLocations(AkitaEntity entity) {
        baby_loc = new ResourceLocation(WorkingDogs.MOD_ID, "textures/entity/akita/akita_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(AkitaEntity entity) {
        adult_loc = new ResourceLocation(WorkingDogs.MOD_ID, "textures/entity/akita/akita_");
    }

    @Override
    public void setupVariants() {
        variants = new String[]{
                "black", "black_brindle", "black_brown_pinto", "black_pinto", "black_white_socks", "brown_brindle",
                "brown_pinto", "fawn", "fawn_brindle", "gold_sesame", "gray_brindle", "gray_pinto", "red_sesame",
                "tan_brindle", "tiger_brindle", "white"
        };
    }
}
