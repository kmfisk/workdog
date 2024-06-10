package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.JackRussellTerrierModel;
import com.github.kmfisk.workdog.entity.JackRussellTerrierEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Locale;

public class JackRussellTerrierRenderer extends WorkDogRenderer<JackRussellTerrierEntity, JackRussellTerrierModel> {
    public JackRussellTerrierRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new JackRussellTerrierModel.Adult(), 0.5f);
        adultModel = model;
        babyModel = new JackRussellTerrierModel.Baby();
    }

    @Override
    public void setupBabyTextureLocations(JackRussellTerrierEntity entity) {
        baby_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/jack_russell_terrier/jackrussell_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(JackRussellTerrierEntity entity) {
        adult_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/jack_russell_terrier/jackrussell_");
    }

    @Override
    public void setupVariants() {
        variants = new ArrayList<>();
        for (JackRussellTerrierEntity.JackRussellTerrierVariant variant : JackRussellTerrierEntity.JackRussellTerrierVariant.values())
            variants.add(variant.name().toLowerCase(Locale.ROOT));
    }
}
