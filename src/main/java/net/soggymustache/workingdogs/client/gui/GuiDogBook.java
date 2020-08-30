package net.soggymustache.workingdogs.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.soggymustache.workingdogs.DogMain;
import net.soggymustache.workingdogs.common.entity.type.base.EntityWorkingDog;

public class GuiDogBook extends GuiScreen {

	public static Minecraft mc = Minecraft.getMinecraft();

	public static final ResourceLocation TEXTURE = new ResourceLocation(DogMain.MOD_ID, "textures/gui/dog_book.png");
	private int mouseX, mouseY;
	public static EntityWorkingDog dog;

	public GuiDogBook(){ }

	@Override
	public void initGui() {
		super.initGui();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.mouseX = mouseX;
		this.mouseY = mouseY;

		GlStateManager.pushMatrix();
		GlStateManager.color(1,1,1,1);
		GlStateManager.enableColorMaterial();

		int x = (width - 287) / 2;
		int y = (height - 203) / 2;

		mc.getTextureManager().bindTexture(TEXTURE);
		drawModalRectWithCustomSizedTexture(x, y, 0,0,287, 203, 287, 203);

		GuiInventory.drawEntityOnScreen(x + 20, y + 120, 30, mouseX, mouseY, dog);

		fontRenderer.drawString("Variant: " + dog.getVariant(), 0, 0, 0);


		GlStateManager.popMatrix();

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
