package net.soggymustache.workingdogs.client;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.bookworm.client.model.ModelCMF;
import net.soggymustache.workingdogs.DogMain;

@SideOnly(Side.CLIENT)
public class RenderConstants {

	public static final ModelCMF FRISBEE = model("models/entity/projectile/frisbee.bkm");

	public static final ModelCMF AKITA = model("models/entity/akita/akita.bkm");
	public static final ModelCMF AKITA_PUPPY = model("models/entity/akita/akita_puppy.bkm");
	public static final ModelCMF AKITA_SIT = model("models/entity/akita/akita_sit.bkm");
	public static final ModelCMF AKITA_LAY = model("models/entity/akita/akita_lay.bkm");
	public static final ModelCMF AKITA_PUPPY_SIT = model("models/entity/akita/akita_puppy_sit.bkm");
	public static final ModelCMF AKITA_PUPPY_LAY = model("models/entity/akita/akita_puppy_lay.bkm");

	public static final ModelCMF BORDER_COLLIE = model("models/entity/border_collie/border_collie.bkm");
	public static final ModelCMF BORDER_COLLIE_PUPPY = model("models/entity/border_collie/border_collie_puppy.bkm");
	public static final ModelCMF BORDER_COLLIE_SIT = model("models/entity/border_collie/border_collie_sit.bkm");
	public static final ModelCMF BORDER_COLLIE_LAY = model("models/entity/border_collie/border_collie_lay.bkm");
	public static final ModelCMF BORDER_COLLIE_PUPPY_SIT = model("models/entity/border_collie/border_collie_puppy_sit.bkm");
	public static final ModelCMF BORDER_COLLIE_PUPPY_LAY = model("models/entity/border_collie/border_collie_puppy_lay.bkm");
	public static final ModelCMF BORDER_COLLIE_PUPPY_HELD = model("models/entity/border_collie/border_collie_puppy_held.bkm");

	private static ModelCMF model(String path){ return new ModelCMF(new ResourceLocation(DogMain.MOD_ID, path)); }

}
