package com.github.kmfisk.workdog.client.render.entity;

import com.github.kmfisk.workdog.WorkingDogs;
import com.github.kmfisk.workdog.client.model.entity.BorderCollieModel;
import com.github.kmfisk.workdog.client.model.entity.BorderColliePuppyModel;
import com.github.kmfisk.workdog.entity.BorderCollieEntity;
import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class BorderCollieRenderer extends MobEntityRenderer<BorderCollieEntity, EntityModel<BorderCollieEntity>> {
    public static final Map<Integer, Identifier> TEXTURES_SHORT_HAIR = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_albino_short.png"));
        hashMap.put(1, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_melanistic_short.png"));
        hashMap.put(2, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_black1_short.png"));
        hashMap.put(3, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_black2_short.png"));
        hashMap.put(4, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_black3_short.png"));
        hashMap.put(5, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_blacktri_short.png"));
        hashMap.put(6, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_blue_short.png"));
        hashMap.put(7, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_bluemerle_short.png"));
        hashMap.put(8, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_chocolate_short.png"));
        hashMap.put(9, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_redmerle_short.png"));
        hashMap.put(10, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_tan_short.png"));
        hashMap.put(11, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_white_short.png"));
    });
    public static final Map<Integer, Identifier> TEXTURES_LONG_HAIR = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_albino_long.png"));
        hashMap.put(1, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_melanistic_long.png"));
        hashMap.put(2, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_black1_long.png"));
        hashMap.put(3, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_black2_long.png"));
        hashMap.put(4, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_black3_long.png"));
        hashMap.put(5, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_blacktri_long.png"));
        hashMap.put(6, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_blue_long.png"));
        hashMap.put(7, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_bluemerle_long.png"));
        hashMap.put(8, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_chocolate_long.png"));
        hashMap.put(9, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_redmerle_long.png"));
        hashMap.put(10, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_tan_long.png"));
        hashMap.put(11, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_white_long.png"));
    });
    public static final Map<Integer, Identifier> TEXTURES_PUPPY = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_albino.png"));
        hashMap.put(1, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_melanistic.png"));
        hashMap.put(2, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_black1.png"));
        hashMap.put(3, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_black2.png"));
        hashMap.put(4, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_black3.png"));
        hashMap.put(5, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_blacktri.png"));
        hashMap.put(6, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_blue.png"));
        hashMap.put(7, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_bluemerle.png"));
        hashMap.put(8, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_chocolate.png"));
        hashMap.put(9, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_redmerle.png"));
        hashMap.put(10, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_tan.png"));
        hashMap.put(11, new Identifier(WorkingDogs.MOD_ID, "textures/entity/border_collie/bordercollie_puppy_white.png"));
    });
    private final BorderColliePuppyModel<BorderCollieEntity> puppyModel = new BorderColliePuppyModel<>();
    private final BorderCollieModel<BorderCollieEntity> adultModel = new BorderCollieModel<>();

    public BorderCollieRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new BorderCollieModel<>(), 0.4F);
    }

    @Override
    public Identifier getTexture(BorderCollieEntity entity) {
        if (entity.isBaby())
            return TEXTURES_PUPPY.getOrDefault(entity.getVariant(), TEXTURES_PUPPY.get(0));
        else {
            if (entity.isShortHair())
                return TEXTURES_SHORT_HAIR.getOrDefault(entity.getVariant(), TEXTURES_SHORT_HAIR.get(0));
            else
                return TEXTURES_LONG_HAIR.getOrDefault(entity.getVariant(), TEXTURES_LONG_HAIR.get(0));
        }
    }

    @Override
    public void render(BorderCollieEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby())
            this.model = this.puppyModel;
        else
            this.model = this.adultModel;

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
