package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.AkitaModel;
import com.github.kmfisk.workdog.entity.AkitaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Locale;

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
        variants = new ArrayList<>();
        for (AkitaEntity.AkitaVariant variant : AkitaEntity.AkitaVariant.values())
            variants.add(variant.name().toLowerCase(Locale.ROOT));
    }
}
