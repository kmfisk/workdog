package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public abstract class WorkDogRenderer<T extends MobEntity, M extends EntityModel<T>> extends MobRenderer<T, M> {
    protected M adultModel;
    protected M babyModel;
    protected ResourceLocation baby_loc;
    protected ResourceLocation adult_loc;
    protected String[] variants;

    public WorkDogRenderer(EntityRendererManager rendererManager, M model, float shadowRadius) {
        super(rendererManager, model, shadowRadius);
    }

    @Override
    public void render(T entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
        model = entity.isBaby() ? babyModel : adultModel;
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }

    public abstract void setupBabyTextureLocations(T entity);

    public abstract void setupAdultTextureLocations(T entity);

    public abstract void setupVariants();

    public ResourceLocation getAdultLocation() {
        return adult_loc;
    }

    public ResourceLocation getBabyLocation() {
        return baby_loc;
    }

    public String getVariant(int variant) {
        return variants[variant];
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        if (entity instanceof WorkDogEntity) {
            WorkDogEntity dog = (WorkDogEntity) entity;
            int i = dog.getVariant();
            if (variants == null || variants.length != dog.getVariantCount()) setupVariants();
            if (dog.isBaby()) {
                if (getBabyLocation() == null) setupBabyTextureLocations(entity);
                return new ResourceLocation(getBabyLocation() + getVariant(i) + ".png");

            } else {
                if (getAdultLocation() == null) setupAdultTextureLocations(entity);
                if (dog.hasLonghairVariants())
                    return new ResourceLocation(getAdultLocation() + getVariant(i) + (dog.isLonghair() ? "_long.png" : "_short.png"));
                else return new ResourceLocation(getAdultLocation() + getVariant(i) + ".png");
            }
        }

        return null;
    }
}
