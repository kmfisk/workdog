package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.entity.core.WorkingDogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public abstract class WorkDogRenderer<T extends MobEntity, M extends EntityModel<T>> extends MobRenderer<T, M> {
    protected ResourceLocation baby_loc;
    protected ResourceLocation adult_loc;
    protected String[] variants;

    public WorkDogRenderer(EntityRendererManager rendererManager, M model, float shadowRadius) {
        super(rendererManager, model, shadowRadius);
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
        if (entity instanceof WorkingDogEntity) {
            WorkingDogEntity dog = (WorkingDogEntity) entity;
            int i = dog.getVariant();
            if (variants == null || variants.length != dog.getVariantCount()) setupVariants();
            if (dog.isBaby()) {
                if (getBabyLocation() == null) setupBabyTextureLocations(entity);
                return new ResourceLocation(getBabyLocation() + getVariant(i) + ".png");

            } else {
                if (getAdultLocation() == null) setupAdultTextureLocations(entity);
                if (dog.hasLonghair()) return new ResourceLocation(getAdultLocation() + getVariant(i) + (dog.isLonghair() ? "_long.png" : "_short.png"));
                else return new ResourceLocation(getAdultLocation() + getVariant(i) + ".png");
            }
        }

        return null;
    }
}
