package com.github.kmfisk.workdog.client.gui;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.github.kmfisk.workdog.inventory.WorkDogContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class WorkDogScreen extends ContainerScreen<WorkDogContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/dog_1.png");

    public WorkDogScreen(WorkDogContainer menu, PlayerInventory playerInventory, ITextComponent title) {
        super(menu, playerInventory, title);
        this.passEvents = false;
        this.imageWidth = 360;
        this.imageHeight = 187;
        this.titleLabelX = 192;
        this.inventoryLabelX = 192;
        this.inventoryLabelY = 91;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        minecraft.textureManager.bind(TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight, 384, 256);
        WorkDogEntity dog = menu.dog;
        if (dog != null && dog.hasSaddlebag())
            this.blit(matrixStack, i + 191, j + 25, 0, 187, dog.getInventoryColumns() * 18, 54, 384, 256);

        this.blit(matrixStack, i + 49, j + 75, 162, 205, 18, 18, 384, 256);
        this.blit(matrixStack, i + 49, j + 95, 180, 205, 18, 18, 384, 256);
        this.blit(matrixStack, i + 49, j + 115, 198, 205, 18, 18, 384, 256);
        this.blit(matrixStack, i + 49, j + 135, 216, 205, 18, 18, 384, 256);
        this.blit(matrixStack, i + 49, j + 155, 234, 205, 18, 18, 384, 256);
    }
}
