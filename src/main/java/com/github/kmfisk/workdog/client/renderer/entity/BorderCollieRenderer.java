package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkingDogs;
import com.github.kmfisk.workdog.client.renderer.entity.model.BorderCollieModel;
import com.github.kmfisk.workdog.entity.BorderCollieEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BorderCollieRenderer extends MobRenderer<BorderCollieEntity, BorderCollieModel> {
    public static final ResourceLocation ADULT_LOC = new ResourceLocation(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_");
    public static final ResourceLocation BABY_LOC = new ResourceLocation(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_");
    public static final String[] VARIANT = new String[]{
            "albino", "black1", "black2", "black3", "black_tri", "blue", "blue_merle", "chocolate", "melanistic", "redmerle", "tan", "white"
    };

    public BorderCollieRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new BorderCollieModel.Adult(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BorderCollieEntity entity) {
        int variant = entity.getVariant();
        if (entity.isBaby()) return new ResourceLocation(BABY_LOC + VARIANT[variant] + ".png");
        else return new ResourceLocation(ADULT_LOC + VARIANT[variant] +
                (entity.isLonghair() ? "_long.png" : "_short.png"));
    }
}
