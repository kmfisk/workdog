package com.github.kmfisk.workdog.client.renderer.entity;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import org.joml.Matrix4f;

import java.util.List;

public abstract class WorkDogRenderer<T extends WorkDogEntity, M extends EntityModel<T>> extends MobRenderer<T, M> {
    public static final ResourceLocation UNKNOWN_VARIANT = new ResourceLocation(WorkDog.MOD_ID, "textures/entity/unknown_variant.png");
    protected M adultModel;
    protected M babyModel;
    protected ResourceLocation baby_loc;
    protected ResourceLocation adult_loc;
    protected List<String> variants;

    public WorkDogRenderer(EntityRendererProvider.Context context, M model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Override
    public void render(T entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
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
        return variants.get(variant);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        if (entity instanceof WorkDogEntity) {
            WorkDogEntity dog = (WorkDogEntity) entity;
            int i = dog.getVariant();
            if (variants == null || variants.size() != dog.getVariantCount() + 2) setupVariants();
            if (i >= dog.getVariantCount() + 2) return UNKNOWN_VARIANT;

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

    @Override
    protected void renderNameTag(T entity, Component textComponent, PoseStack matrixStack, MultiBufferSource renderTypeBuffer, int packedLightCoords) {
        super.renderNameTag(entity, textComponent, matrixStack, renderTypeBuffer, packedLightCoords);

        double distance = entityRenderDispatcher.distanceToSqr(entity);
        if (ForgeHooksClient.isNameplateInRenderDistance(entity, distance) && entityRenderDispatcher.camera.getEntity().isShiftKeyDown() && !entity.isInfertile() && !entity.isBaby()) {
            boolean notDiscrete = !entity.isDiscrete();
            float height = entity.getBbHeight() + 0.62F;

            matrixStack.pushPose();
            matrixStack.translate(0.0D, height, 0.0D);
            matrixStack.mulPose(entityRenderDispatcher.cameraOrientation());
            matrixStack.scale(-0.012F, -0.012F, 0.012F);
            Matrix4f matrix4f = matrixStack.last().pose();

            float backgroundOpacity = Minecraft.getInstance().options.getBackgroundOpacity(0.25F);
            int j = (int) (backgroundOpacity * 255.0F) << 24;

            MutableComponent info = Component.translatable((entity.getGender() == WorkDogEntity.Gender.FEMALE ? (entity.getBreedingStatus("inheat") ? "name.workdog.in_heat" : "name.workdog.not_in_heat") : "name.workdog.male"), entity.getBreedTimer());
            if (entity.getBreedingStatus("ispregnant"))
                info = Component.translatable("name.workdog.pregnant", entity.getBreedTimer());

            Font fontRenderer = getFont();
            float centeredPos = (float) (-fontRenderer.width(info) / 2);

            fontRenderer.drawInBatch(info, centeredPos, 0, 553648127, false, matrix4f, renderTypeBuffer, notDiscrete ? Font.DisplayMode.SEE_THROUGH : Font.DisplayMode.NORMAL, j, packedLightCoords);
            if (notDiscrete)
                fontRenderer.drawInBatch(info, centeredPos, 0, -1, false, matrix4f, renderTypeBuffer, Font.DisplayMode.NORMAL, 0, packedLightCoords);

            matrixStack.popPose();
        }
    }
}
