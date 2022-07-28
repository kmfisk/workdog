package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.client.renderer.entity.model.BorderCollieModel;
import com.github.kmfisk.workdog.entity.BorderCollieEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BorderCollieRenderer extends MobRenderer<BorderCollieEntity, BorderCollieModel> {
    public BorderCollieRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new BorderCollieModel.Adult(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BorderCollieEntity entity) {
        return null;
    }
}
