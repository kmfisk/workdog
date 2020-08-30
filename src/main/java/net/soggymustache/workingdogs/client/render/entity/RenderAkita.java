package net.soggymustache.workingdogs.client.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
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
import net.soggymustache.workingdogs.common.entity.type.EntityAkita;
import net.soggymustache.workingdogs.common.entity.type.base.EntityWorkingDog;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderAkita extends RenderLivingDog<EntityAkita> implements IBabyModel<EntityAkita> {

	public static final ResourceContainer CONTAINER = new ResourceContainer(DogMain.MOD_ID);

	static{
		CONTAINER.addResource("textures/entity/akita/akita_albino.png");
		CONTAINER.addResource("textures/entity/akita/akita_melanistic.png");
		CONTAINER.addResource("textures/entity/akita/akita_black_pinto.png");
		CONTAINER.addResource("textures/entity/akita/akita_black_tan_pinto.png");
		CONTAINER.addResource("textures/entity/akita/akita_black_white_socks.png");
		CONTAINER.addResource("textures/entity/akita/akita_brown_black_pinto.png");
		CONTAINER.addResource("textures/entity/akita/akita_brown_brindle.png");
		CONTAINER.addResource("textures/entity/akita/akita_gray_pinto.png");
		CONTAINER.addResource("textures/entity/akita/akita_white.png");
		CONTAINER.addResource("textures/entity/akita/akita_fawn.png");

		CONTAINER.addResource("baby", "textures/entity/akita/akita_puppy_albino.png");
		CONTAINER.addResource("baby","textures/entity/akita/akita_puppy_melanistic.png");
		CONTAINER.addResource("baby","textures/entity/akita/akita_puppy_black_pinto.png");
		CONTAINER.addResource("baby","textures/entity/akita/akita_puppy_black_tan_pinto.png");
		CONTAINER.addResource("baby","textures/entity/akita/akita_puppy_black_white_socks.png");
		CONTAINER.addResource("baby","textures/entity/akita/akita_puppy_brown_black_pinto.png");
		CONTAINER.addResource("baby","textures/entity/akita/akita_puppy_brown_brindle.png");
		CONTAINER.addResource("baby","textures/entity/akita/akita_puppy_gray_pinto.png");
		CONTAINER.addResource("baby","textures/entity/akita/akita_puppy_white.png");
		CONTAINER.addResource("baby","textures/entity/akita/akita_puppy_fawn.png");
	}

	public RenderAkita(RenderManager rendermanagerIn) {
		super(rendermanagerIn, RenderConstants.AKITA.setAnimator(AkitaAnimator::new), 0.46F);
	}

	@Override
	protected void preRenderCallback(EntityAkita e, float partialTickTime) {
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
	protected ResourceLocation getEntityTexture(EntityAkita entity) {
		return CONTAINER.get(entity.getVariant());
	}

	@Override
	public ModelBase getBabyModel() {
		return RenderConstants.AKITA_PUPPY.setAnimator(AkitaPuppyAnimator::new);
	}

	@Override
	public ResourceLocation getBabyTexture(EntityAkita e) {
		return CONTAINER.get("baby", e.getVariant());
	}

	public static class AkitaAnimator extends DogAnimator<EntityAkita> {

		protected final BookwormModelRenderer ArmBaseLeft = this.getModel().getPartByName("ArmBaseLeft");
		protected final BookwormModelRenderer ArmLeft = this.getModel().getPartByName("ArmLeft");
		protected final BookwormModelRenderer ForearmLeft = this.getModel().getPartByName("ForearmLeft");
		protected final BookwormModelRenderer HandLeft = this.getModel().getPartByName("HandLeft");
		protected final BookwormModelRenderer ThighLeft = this.getModel().getPartByName("ThighLeft");
		protected final BookwormModelRenderer UpperLegLeft = this.getModel().getPartByName("UpperLegLeft");
		protected final BookwormModelRenderer LowerLegLeft = this.getModel().getPartByName("LowerLegLeft");
		protected final BookwormModelRenderer FootLeft = this.getModel().getPartByName("FootLeft");
		protected final BookwormModelRenderer ArmBaseRight = this.getModel().getPartByName("ArmBaseRight");
		protected final BookwormModelRenderer ArmRight = this.getModel().getPartByName("ArmRight");
		protected final BookwormModelRenderer ForearmRight = this.getModel().getPartByName("ForearmRight");
		protected final BookwormModelRenderer HandRight = this.getModel().getPartByName("HandRight");
		protected final BookwormModelRenderer ThighRight = this.getModel().getPartByName("ThighRight");
		protected final BookwormModelRenderer UpperLegRight = this.getModel().getPartByName("UpperLegRight");
		protected final BookwormModelRenderer LowerLegRight = this.getModel().getPartByName("LowerLegRight");
		protected final BookwormModelRenderer FootRight = this.getModel().getPartByName("FootRight");
		protected final BookwormModelRenderer Body = this.getModel().getPartByName("Body");
		protected final BookwormModelRenderer Hips = this.getModel().getPartByName("Hips");
		protected final BookwormModelRenderer Neck = this.getModel().getPartByName("Neck");
		protected final BookwormModelRenderer Head = this.getModel().getPartByName("Head");
		protected final BookwormModelRenderer Mouth = this.getModel().getPartByName("Mouth");
		protected final BookwormModelRenderer Tongue = this.getModel().getPartByName("Tongue");
		protected final BookwormModelRenderer EarLeft = this.getModel().getPartByName("EarLeft");
		protected final BookwormModelRenderer EarRight = this.getModel().getPartByName("EarRight");
		protected final BookwormModelRenderer Tail1 = this.getModel().getPartByName("Tail1");
		protected final BookwormModelRenderer Tail2 = this.getModel().getPartByName("Tail2");

		public AkitaAnimator(ModelCMF model) {
			super(model);
			sitModel = RenderConstants.AKITA_SIT;
			layModel = RenderConstants.AKITA_LAY;
		}

		@Override
		protected void performGenericAnimation(float f, float f1, float f2, float f3, float f4, float f5, EntityAkita entity) {
			super.performGenericAnimation(f, f1, f2, f3, f4, f5, entity);
			if(entity.isRunning()){
				speed = 2.3f;
				degree = 0.4f;
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
				this.Neck.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * -0.4F) * f1 * 0.5F + 0.75F;
				this.Head.rotateAngleX = MathHelper.cos(3.5F + (f * speed * 0.3F) + (float) Math.PI) * (degree * -0.5F) * f1 * 0.5F + -0.6F;
				this.Mouth.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * 0.4F) * f1 * 0.5F + 0.5F;
				this.Tongue.offsetZ = MathHelper.cos(4.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 0.15F) * f1 * 0.5F;
				this.EarLeft.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * 0.3F) * f1 * 0.5F + 0.4F;
				this.EarRight.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 0.3F) * f1 * 0.5F + 0.4F;
				this.Tail1.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 0.3F) * f1 * 0.5F + 1.6F;
				this.Tail2.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * 0.2F) * f1 * 0.5F + 0.9F;
			}
			else{
				speed = 3.0f;
				degree = 1.0f;
				this.ArmBaseLeft.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * 0.8F) * f1 * 0.5F + 0.15F;
				this.ArmLeft.rotateAngleX = MathHelper.cos(2.0F + (f * speed * 0.2F) + (float) Math.PI) * (degree * 0.9F) * f1 * 0.5F + -0.13F;
				this.ForearmLeft.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * 0.8F) * f1 * 0.5F + -0.05F;
				this.ThighLeft.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * -1.2F) * f1 * 0.5F + 0.14F;
				this.UpperLegLeft.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.2F) + (float) Math.PI) * (degree * 1.3F) * f1 * 0.5F + 0.62F;
				this.LowerLegLeft.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * -1.0F) * f1 * 0.5F + -0.6F;
				this.ArmBaseRight.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * -0.8F) * f1 * 0.5F + 0.15F;
				this.ArmRight.rotateAngleX = MathHelper.cos(2.0F + (f * speed * 0.2F) + (float) Math.PI) * (degree * -0.9F) * f1 * 0.5F + -0.13F;
				this.ForearmRight.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * -0.8F) * f1 * 0.5F + -0.05F;
				this.ThighRight.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * 1.2F) * f1 * 0.5F + 0.14F;
				this.UpperLegRight.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.2F) + (float) Math.PI) * (degree * -1.3F) * f1 * 0.5F + 0.62F;
				this.LowerLegRight.rotateAngleX = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * 1.0F) * f1 * 0.5F + -0.6F;
				this.Neck.rotateAngleX = MathHelper.cos(2.0F + (f * speed * 0.4F) + (float) Math.PI) * (degree * -0.05F) * f1 * 0.5F + 0.72F;
				this.Head.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * -0.05F) * f1 * 0.5F + -0.6F;
				this.Tail1.rotateAngleY = MathHelper.cos((f * speed * 0.2F) + (float) Math.PI) * (degree * -0.2F) * f1 * 0.5F;
			}
		}

		@Override
		protected void performIdleAnimation(float f, float f1, float f2, float f3, float f4, float f5, EntityAkita entity) {
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

	public static class AkitaPuppyAnimator extends DogAnimator<EntityWorkingDog> {
		protected final BookwormModelRenderer ArmLeft = this.getModel().getPartByName("ArmLeft");
		protected final BookwormModelRenderer ArmRight = this.getModel().getPartByName("ArmRight");
		protected final BookwormModelRenderer ThighLeft = this.getModel().getPartByName("ThighLeft");
		protected final BookwormModelRenderer LegLeft = this.getModel().getPartByName("LegLeft");
		protected final BookwormModelRenderer ThighRight = this.getModel().getPartByName("ThighRight");
		protected final BookwormModelRenderer LegRight = this.getModel().getPartByName("LegRight");
		protected final BookwormModelRenderer Neck = this.getModel().getPartByName("Neck");
		protected final BookwormModelRenderer Tail1 = this.getModel().getPartByName("Tail1");
		protected final BookwormModelRenderer Chest = this.getModel().getPartByName("Chest");
		protected final BookwormModelRenderer Head = this.getModel().getPartByName("Head");

		public AkitaPuppyAnimator(ModelCMF model) {
			super(model);
			sitModel = RenderConstants.AKITA_PUPPY_SIT;
			layModel = RenderConstants.AKITA_PUPPY_LAY;
		}

		@Override
		protected void performGenericAnimation(float f, float f1, float f2, float f3, float f4, float f5, EntityWorkingDog entity) {
			super.performGenericAnimation(f, f1, f2, f3, f4, f5, entity);
			if(entity.isRunning()){
				speed = 1.0F;
				this.ArmLeft.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 3.0F) * f1 * 0.5F + 0.1F;
				this.ArmRight.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.4F) + (float) Math.PI) * (degree * 3.0F) * f1 * 0.5F + 0.1F;
				this.ThighLeft.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.4F) + (float) Math.PI) * (degree * -2.2F) * f1 * 0.5F + -0.1F;
				this.ThighRight.rotateAngleX = MathHelper.cos(2.0F + (f * speed * 0.4F) + (float) Math.PI) * (degree * -2.2F) * f1 * 0.5F + -0.1F;
				this.Tail1.rotateAngleX = MathHelper.cos(3.0F + (f * speed * 0.4F) + (float) Math.PI) * (degree * -0.2F) * f1 * 0.5F + -0.8F;
				this.Chest.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * -0.15F) * f1 * 0.5F + -0.02F;
				this.Head.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * -0.1F) * f1 * 0.5F + -0.6F;
			}
			else {
				if(entity.isRiding() && entity.getRidingEntity() instanceof EntityPlayer){
					this.getModel().loadPosedModel(RenderConstants.BORDER_COLLIE_PUPPY_HELD);
				}
				else {
					speed = 2.0F;
					this.ArmLeft.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * 1.0F) * f1 * 0.5F + 0.1F;
					this.ArmRight.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * -1.0F) * f1 * 0.5F + 0.1F;
					this.ThighLeft.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * -1.0F) * f1 * 0.5F;
					this.LegLeft.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * -0.6F) * f1 * 0.5F + 0.4F;
					this.ThighRight.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.3F) + (float) Math.PI) * (degree * 1.0F) * f1 * 0.5F;
					this.LegRight.rotateAngleX = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * 0.6F) * f1 * 0.5F + 0.4F;
					this.Neck.rotateAngleX = MathHelper.cos(1.0F + (f * speed * 0.6F) + (float) Math.PI) * (degree * -0.06F) * f1 * 0.5F + 0.7F;
					this.Tail1.rotateAngleZ = MathHelper.cos((f * speed * 0.3F) + (float) Math.PI) * (degree * 0.3F) * f1 * 0.5F;
				}
			}
		}
	}

}
