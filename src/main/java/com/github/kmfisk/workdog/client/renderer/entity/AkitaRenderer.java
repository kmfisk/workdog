package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
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
        baby_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/akita/akita_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(AkitaEntity entity) {
        adult_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/akita/akita_");
    }

    @Override
    public void setupVariants() {
        variants = new String[]{
                "black", "black_white_socks", "black_pinto", "black_brown_pinto", "black_tan_pinto", "black_brindle",
                "brown_brindle", "brown_pinto", "fawn", "fawn_brindle", "fawn_pinto", "gray_brindle", "gray_pinto",
                "silver_brindle", "silver_pinto", "tan_brindle", "tan_pinto", "tiger_brindle", "red_sesame",
                "gold_sesame", "white"
        };
    }
}
