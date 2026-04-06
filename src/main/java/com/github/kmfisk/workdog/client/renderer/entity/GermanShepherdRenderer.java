package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.renderer.entity.layers.GermanShepherdEquipmentLayer;
import com.github.kmfisk.workdog.client.renderer.entity.model.GermanShepherdModel;
import com.github.kmfisk.workdog.entity.GermanShepherdEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Locale;

public class GermanShepherdRenderer extends WorkDogRenderer<GermanShepherdEntity, GermanShepherdModel> {
    public GermanShepherdRenderer(EntityRendererProvider.Context context) {
        super(context, new GermanShepherdModel.Adult(context.bakeLayer(GermanShepherdModel.ADULT_LAYER)), 0.5f);
        adultModel = model;
        babyModel = new GermanShepherdModel.Baby(context.bakeLayer(GermanShepherdModel.BABY_LAYER));
        addLayer(new GermanShepherdEquipmentLayer(this, context.getModelSet()));
    }

    @Override
    protected void scale(GermanShepherdEntity entity, PoseStack matrixStack, float partialTickTime) {
        matrixStack.scale(0.9F, 0.9F, 0.9F);
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
        variants = new ArrayList<>();
        for (GermanShepherdEntity.GermanShepherdVariant variant : GermanShepherdEntity.GermanShepherdVariant.values())
            variants.add(variant.name().toLowerCase(Locale.ROOT));
    }
}
