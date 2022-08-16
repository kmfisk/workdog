package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.entity.GermanShepherdEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;

public abstract class GermanShepherdModel extends WorkDogModel<GermanShepherdEntity> {
    private Iterable<ModelRenderer> parts; // todo: adult & child

    @Override
    public Iterable<ModelRenderer> parts() {
        if (parts == null)
            parts = ImmutableList.of(/*Chest*/);

        return parts;
    }

    public static class Adult extends GermanShepherdModel {
        public Adult() {
        }

        @Override
        public void setupAnim(GermanShepherdEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }
    }

    public static class Child extends GermanShepherdModel {
        public Child() {
        }

        @Override
        public void setupAnim(GermanShepherdEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }
    }
}
