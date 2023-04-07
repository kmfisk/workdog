package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.model.GermanShepherdModel;
import com.github.kmfisk.workdog.entity.GermanShepherdEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class GermanShepherdRenderer extends WorkDogRenderer<GermanShepherdEntity, GermanShepherdModel> {
    public GermanShepherdRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new GermanShepherdModel.Adult(), 0.5f);
        adultModel = model;
        babyModel = new GermanShepherdModel.Baby();
    }

    @Override
    public void setupBabyTextureLocations(GermanShepherdEntity entity) {
        baby_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/german_shepherd/germanshepherd_puppy_");
    }

    @Override
    public void setupAdultTextureLocations(GermanShepherdEntity entity) {
        adult_loc = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/german_shepherd/germanshepherd_");
    }

    @Override
    public void setupVariants() {
        variants = new String[]{
                "black", "black_and_red", "black_and_silver", "black_and_tan", "red_sable", "red_saddleback",
                "silver_sable", "silver_saddleback", "tan_sable", "tan_saddleback", "white"
        };
    }
}
