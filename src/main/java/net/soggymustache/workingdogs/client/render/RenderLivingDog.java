package net.soggymustache.workingdogs.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.bookworm.client.render.ResourceContainer;
import net.soggymustache.bookworm.util.BookwormRenderUtils;
import net.soggymustache.workingdogs.client.IBabyModel;
import net.soggymustache.workingdogs.common.entity.type.base.EntityWorkingDog;

import javax.annotation.Nullable;

public abstract class RenderLivingDog<T extends EntityWorkingDog> extends RenderLiving<T> {

	public RenderLivingDog(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
		if(this instanceof IBabyModel<?>){
			this.addLayer(new LayerChild((RenderLivingDog<EntityWorkingDog>) this));
		}
	}

	public abstract ResourceContainer getResourceContainer();

	@Override
	protected void preRenderCallback(T e, float partialTickTime) {
		super.preRenderCallback(e, partialTickTime);
		if(e.isRiding() && e.getRidingEntity() instanceof EntityPlayer){
			GlStateManager.rotate(180, 0, 1, 0);
		}
	}

	@SideOnly(Side.CLIENT)
	public static class LayerChild implements LayerRenderer<EntityWorkingDog>{

		private final RenderLivingDog<EntityWorkingDog> RENDER;
		private final IBabyModel<EntityWorkingDog> BABY;
		private final ModelBase MODEL;

		public LayerChild(RenderLivingDog<EntityWorkingDog> render){
			this.RENDER = render;
			this.BABY = (IBabyModel<EntityWorkingDog>)RENDER;
			this.MODEL = BABY.getBabyModel();
		}

		@Override
		public void doRenderLayer(EntityWorkingDog e, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
			if(e.isChild() && !e.isInvisible()){
				if(MODEL != null){
					this.RENDER.bindTexture(BABY.getBabyTexture(e));
					this.MODEL.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, e);
					this.MODEL.render(e, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
				}
			}
		}

		@Override
		public boolean shouldCombineTextures() {
			return true;
		}
	}

	@Nullable
	protected abstract ResourceLocation getEntityTexture(T entity);

	@Override
	protected boolean bindEntityTexture(T entity)
	{
		ResourceLocation resourcelocation = this.getEntityTexture(entity);

		if (resourcelocation == null)
		{
			return false;
		}
		else
		{
			if(this instanceof IBabyModel<?> && entity.isChild()){
				this.bindTexture(BookwormRenderUtils.NONE);
				return false;
			}
			this.bindTexture(resourcelocation);
			return true;
		}
	}
}
