package com.github.kmfisk.workdog.client.renderer.entity.model;

import com.github.kmfisk.workdog.entity.BorderCollieEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public abstract class BorderCollieModel extends SegmentedModel<BorderCollieEntity> {
    private Iterable<ModelRenderer> parts;

    @Override
    public Iterable<ModelRenderer> parts() {
        if (parts == null)
            parts = ImmutableList.of(/*TODO*/);

        return parts;
    }

    public static class Adult extends BorderCollieModel {
        public Adult() {
        }

        @Override
        public void setupAnim(BorderCollieEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }
    }
}
