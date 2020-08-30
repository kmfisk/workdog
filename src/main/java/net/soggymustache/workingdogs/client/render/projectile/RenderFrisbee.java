package net.soggymustache.workingdogs.client.render.projectile;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.soggymustache.workingdogs.DogMain;
import net.soggymustache.workingdogs.client.RenderConstants;
import net.soggymustache.workingdogs.common.entity.type.projectile.EntityFrisbee;

import javax.annotation.Nullable;

public class RenderFrisbee extends Render<EntityFrisbee> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(DogMain.MOD_ID, "textures/entity/projectile/frisbee.png");

	public RenderFrisbee(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	public void doRender(EntityFrisbee entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(x, y + 1.4F, z);
		GlStateManager.scale(0.05F, 0.05F, 0.05F);
		GlStateManager.rotate(entityYaw, 0, 1, 0);
		GlStateManager.rotate(180, 1,0,0);
		this.bindTexture(getEntityTexture(entity));
		RenderConstants.FRISBEE.render(entity, 0, 0, 0, 0, 0, 1);
		GlStateManager.popMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(EntityFrisbee entity) {
		return TEXTURE;
	}
}
