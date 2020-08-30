package net.soggymustache.workingdogs.client.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.ModelCMF;
import net.soggymustache.bookworm.client.render.ResourceContainer;
import net.soggymustache.workingdogs.DogMain;
import net.soggymustache.workingdogs.client.IBabyModel;
import net.soggymustache.workingdogs.client.RenderConstants;
import net.soggymustache.workingdogs.client.animation.DogAnimator;
import net.soggymustache.workingdogs.client.render.RenderLivingDog;
import net.soggymustache.workingdogs.common.entity.type.EntityBorderCollie;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderBorderCollie extends RenderLivingDog<EntityBorderCollie> implements IBabyModel<EntityBorderCollie> {

	public static final ResourceContainer CONTAINER = new ResourceContainer(DogMain.MOD_ID);

	static{
		CONTAINER.addResource("textures/entity/border_collie/bordercollie_albino_short.png");
		CONTAINER.addResource("textures/entity/border_collie/bordercollie_melanistic_short.png");
		CONTAINER.addResource("textures/entity/border_collie/bordercollie_black_tri_short.png");//2
		CONTAINER.addResource("textures/entity/border_collie/bordercollie_black1_short.png");//3
		CONTAINER.addResource("textures/entity/border_collie/bordercollie_black2_short.png");//4
		CONTAINER.addResource("textures/entity/border_collie/bordercollie_black3_short.png");//5
		CONTAINER.addResource("textures/entity/border_collie/bordercollie_blue_merle_short.png");//6
		CONTAINER.addResource("textures/entity/border_collie/bordercollie_blue_short.png");//7
		CONTAINER.addResource("textures/entity/border_collie/bordercollie_chocolate_short.png");//8
		CONTAINER.addResource("textures/entity/border_collie/bordercollie_tan_short.png");//9
		CONTAINER.addResource("textures/entity/border_collie/bordercollie_white_short.png");//10

		CONTAINER.addResource("long", "textures/entity/border_collie/bordercollie_albino_long.png");
		CONTAINER.addResource("long","textures/entity/border_collie/bordercollie_melanistic_long.png");
		CONTAINER.addResource("long","textures/entity/border_collie/bordercollie_black_tri_long.png");
		CONTAINER.addResource("long","textures/entity/border_collie/bordercollie_black1_long.png");
		CONTAINER.addResource("long","textures/entity/border_collie/bordercollie_black2_long.png");
		CONTAINER.addResource("long","textures/entity/border_collie/bordercollie_black3_long.png");
		CONTAINER.addResource("long","textures/entity/border_collie/bordercollie_blue_merle_long.png");
		CONTAINER.addResource("long","textures/entity/border_collie/bordercollie_blue_long.png");
		CONTAINER.addResource("long","textures/entity/border_collie/bordercollie_chocolate_long.png");
		CONTAINER.addResource("long","textures/entity/border_collie/bordercollie_tan_long.png");
		CONTAINER.addResource("long","textures/entity/border_collie/bordercollie_white_long.png");

		CONTAINER.addResource("baby", "textures/entity/border_collie/bordercollie_puppy_albino.png");
		CONTAINER.addResource("baby","textures/entity/border_collie/bordercollie_puppy_melanistic.png");
		CONTAINER.addResource("baby","textures/entity/border_collie/bordercollie_puppy_black_tri.png");
		CONTAINER.addResource("baby","textures/entity/border_collie/bordercollie_puppy_black1.png");
		CONTAINER.addResource("baby","textures/entity/border_collie/bordercollie_puppy_black2.png");
		CONTAINER.addResource("baby","textures/entity/border_collie/bordercollie_puppy_black3.png");
		CONTAINER.addResource("baby","textures/entity/border_collie/bordercollie_puppy_blue.png");
		CONTAINER.addResource("baby","textures/entity/border_collie/bordercollie_puppy_blue_merle.png");
		CONTAINER.addResource("baby","textures/entity/border_collie/bordercollie_puppy_chocolate.png");
		CONTAINER.addResource("baby","textures/entity/border_collie/bordercollie_puppy_tan.png");
		CONTAINER.addResource("baby","textures/entity/border_collie/bordercollie_puppy_white.png");
	}

	public RenderBorderCollie(RenderManager rendermanagerIn) {
		super(rendermanagerIn, RenderConstants.BORDER_COLLIE.setAnimator(BorderCollieAnimator::new), 0.4F);
	}

	@Override
	protected void preRenderCallback(EntityBorderCollie e, float partialTickTime) {
		super.preRenderCallback(e, partialTickTime);
		if(e.isChild())
			GlStateManager.translate(0, -0.02F, 0);
	}

	@Override
	public ResourceContainer getResourceContainer() {
		return CONTAINER;
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(EntityBorderCollie entity) {
		return entity.hasLongHair() ? CONTAINER.get("long", entity.getVariant()) : CONTAINER.get(entity.getVariant());
	}

	@Override
	public ModelBase getBabyModel() {
		return RenderConstants.BORDER_COLLIE_PUPPY.setAnimator(RenderAkita.AkitaPuppyAnimator::new);
	}

	@Override
	public ResourceLocation getBabyTexture(EntityBorderCollie e) {
		return CONTAINER.get("baby", e.getVariant());
	}

	public static class BorderCollieAnimator extends DogAnimator<EntityBorderCollie> {
		protected final BookwormModelRenderer ArmBaseLeft = this.getModel().getPartByName("ArmBaseLeft");
		protected final BookwormModelRenderer ArmLeft = this.getModel().getPartByName("ArmLeft");
		protected final BookwormModelRenderer ForearmLeft = this.getModel().getPartByName("ForearmLeft");
		protected final BookwormModelRenderer ThighLeft = this.getModel().getPartByName("ThighLeft");
		protected final BookwormModelRenderer UpperLegLeft = this.getModel().getPartByName("UpperLegLeft");
		protected final BookwormModelRenderer LowerLegLeft = this.getModel().getPartByName("LowerLegLeft");
		protected final BookwormModelRenderer ArmBaseRight = this.getModel().getPartByName("ArmBaseRight");
		protected final BookwormModelRenderer ArmRight = this.getModel().getPartByName("ArmRight");
		protected final BookwormModelRenderer ForearmRight = this.getModel().getPartByName("ForearmRight");
		protected final BookwormModelRenderer ThighRight = this.getModel().getPartByName("ThighRight");
		protected final BookwormModelRenderer UpperLegRight = this.getModel().getPartByName("UpperLegRight");
		protected final BookwormModelRenderer LowerLegRight = this.getModel().getPartByName("LowerLegRight");
		protected final BookwormModelRenderer Neck = this.getModel().getPartByName("Neck");
		protected final BookwormModelRenderer Head = this.getModel().getPartByName("Head");
		protected final BookwormModelRenderer Tail1 = this.getModel().getPartByName("Tail1");
		protected final BookwormModelRenderer Tail2 = this.getModel().getPartByName("Tail2");
		protected final BookwormModelRenderer EarLeft = this.getModel().getPartByName("EarLeft");
		protected final BookwormModelRenderer EarRight = this.getModel().getPartByName("EarRight");
		protected final BookwormModelRenderer HandLeft = this.getModel().getPartByName("HandLeft");
		protected final BookwormModelRenderer FootLeft = this.getModel().getPartByName("FootLeft");
		protected final BookwormModelRenderer HandRight = this.getModel().getPartByName("HandRight");
		protected final BookwormModelRenderer FootRight = this.getModel().getPartByName("FootRight");
		protected final BookwormModelRenderer Body = this.getModel().getPartByName("Body");
		protected final BookwormModelRenderer Hips = this.getModel().getPartByName("Hips");
		protected final BookwormModelRenderer Mouth = this.getModel().getPartByName("Mouth");
		protected final BookwormModelRenderer Tongue = this.getModel().getPartByName("Tongue");

		public BorderCollieAnimator(ModelCMF model) {
			super(model);
			sitModel = RenderConstants.BORDER_COLLIE_SIT;
			layModel = RenderConstants.BORDER_COLLIE_LAY;
		}

		@Override
		protected void performGenericAnimation(float f, float f1, float f2, float f3, float f4, float f5, EntityBorderCollie entity) {
			super.performGenericAnimation(f, f1, f2, f3, f4, f5, entity);
			if(entity.isRunning()){
				degree = 0.4F;
				speed = 2.1F;
				this.ArmBaseLeft.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * 4.0F) * f1 * 0.5F + 0.15F;
				this.ArmLeft.rotateAngleX = MathHelper.cos(1.5F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 2.3F) * f1 * 0.5F + -0.2F;
				this.ForearmLeft.rotateAngleX = MathHelper.cos(5.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * f1 * 0.5F + 0.2F;
				this.HandLeft.rotateAngleX = MathHelper.cos(6.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * f1 * 0.5F + 0.2F;
				this.ThighLeft.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * -3.2F) * f1 * 0.5F + 0.1F;
				this.UpperLegLeft.rotateAngleX = MathHelper.cos(6.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * -1.8F) * f1 * 0.5F + 0.6F;
				this.LowerLegLeft.rotateAngleX = MathHelper.cos(3.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * -3.0F) * f1 * 0.5F + -0.7F;
				this.FootLeft.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * f1 * 0.5F + 0.1F;
				this.ArmBaseRight.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 4.0F) * f1 * 0.5F;
				this.ArmRight.rotateAngleX = MathHelper.cos(2.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 2.3F) * f1 * 0.5F + -0.2F;
				this.ForearmRight.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * f1 * 0.5F + 0.2F;
				this.HandRight.rotateAngleX = MathHelper.cos(2.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * f1 * 0.5F + 0.2F;
				this.ThighRight.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * -3.2F) * f1 * 0.5F + 0.1F;
				this.UpperLegRight.rotateAngleX = MathHelper.cos(6.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * -1.8F) * f1 * 0.5F + 0.6F;
				this.LowerLegRight.rotateAngleX = MathHelper.cos(2.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * -3.0F) * f1 * 0.5F + -0.7F;
				this.FootRight.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 2.0F) * f1 * 0.5F + 0.1F;
				this.Body.rotateAngleX = MathHelper.cos(4.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * -0.08F) * f1 * 0.5F + 0.05F;
				this.Hips.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * -0.4F) * f1 * 0.5F + -0.2F;
				this.Neck.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * -0.4F) * f1 * 0.5F + 0.9F;
				this.Head.rotateAngleX = MathHelper.cos(3.5F + (f * speed * 0.3F) + (float) Math.PI) * (degree * -0.5F) * f1 * 0.5F + -0.8F;
				this.Mouth.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * 0.4F) * f1 * 0.5F + 0.5F;
				this.Tongue.offsetZ = MathHelper.cos(4.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 0.15F) * f1 * 0.5F;
				this.EarLeft.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * 0.3F) * f1 * 0.5F + 0.4F;
				this.EarRight.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 0.3F) * f1 * 0.5F + 0.4F;
				this.Tail1.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 0.5F) * f1 * 0.5F + 1.6F;
			}
			else{
				speed = 3.3F;
				degree = 1.1F;
				this.ArmBaseLeft.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * 0.8F) * f1 * 0.5F + 0.15F;
				this.ArmLeft.rotateAngleX = MathHelper.cos(2.0F + (f * speed * 0.2F) + (float) Math.PI) * (degree * 0.9F) * f1 * 0.5F + -0.095F;
				this.ForearmLeft.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * 0.8F) * f1 * 0.5F + -0.05F;
				this.ThighLeft.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * -1.1F) * f1 * 0.5F + 0.12F;
				this.UpperLegLeft.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.2F) + (float) Math.PI) * (degree * 1.3F) * f1 * 0.5F + 0.62F;
				this.LowerLegLeft.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * -1.0F) * f1 * 0.5F + -0.6F;
				this.ArmBaseRight.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * -0.8F) * f1 * 0.5F + 0.15F;
				this.ArmRight.rotateAngleX = MathHelper.cos(2.0F + (f * speed * 0.2F) + (float) Math.PI) * (degree * -0.9F) * f1 * 0.5F + -0.095F;
				this.ForearmRight.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * -0.8F) * f1 * 0.5F + -0.05F;
				this.ThighRight.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * 1.1F) * f1 * 0.5F + 0.12F;
				this.UpperLegRight.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.2F) + (float) Math.PI) * (degree * -1.3F) * f1 * 0.5F + 0.62F;
				this.LowerLegRight.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * 1.0F) * f1 * 0.5F + -0.6F;
				this.Neck.rotateAngleX = MathHelper.cos(2.0F + (f * speed * 0.4F) + (float) Math.PI) * (degree * -0.05F) * f1 * 0.5F + 0.74F;
				this.Head.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * -0.05F) * f1 * 0.5F + -0.6F;
				this.Tail1.rotateAngleY = MathHelper.cos(1.0F + (f * speed * 0.2F) + (float) Math.PI) * (degree * -0.4F) * f1 * 0.5F;
				this.Tail2.rotateAngleZ = MathHelper.cos(2.0F + (f * speed * 0.2F) + (float) Math.PI) * (degree * -0.3F) * f1 * 0.5F;
			}
		}

		@Override
		protected void performIdleAnimation(float f, float f1, float f2, float f3, float f4, float f5, EntityBorderCollie entity) {
			super.performIdleAnimation(f, f1, f2, f3, f4, f5, entity);
			if(entity.isPanting()){
				speed = 1.4f;
				degree = 1.0f;
				this.Head.rotateAngleX = MathHelper.cos(2.0F + (f * speed * 0.7F) + (float) Math.PI) * (degree * 0.02F) * f1 * 0.5F + -0.59F;
				this.Mouth.rotateAngleX = MathHelper.cos((f * speed * 0.6F) + (float) Math.PI) * (degree * 0.15F) * f1 * 0.5F + 0.5F;
				this.Tongue.offsetZ = MathHelper.cos((f * speed * 0.6F) + (float) Math.PI) * (degree * -0.06F) * f1 * 0.5F;
			}
		}
	}
}
