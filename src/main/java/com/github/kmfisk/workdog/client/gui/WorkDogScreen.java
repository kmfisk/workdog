package com.github.kmfisk.workdog.client.gui;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import com.github.kmfisk.workdog.inventory.WorkDogInventoryMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class WorkDogScreen extends AbstractContainerScreen<WorkDogInventoryMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/dog_1.png");

    public WorkDogScreen(WorkDogInventoryMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 360;
        this.imageHeight = 187;
        this.titleLabelX = 192;
        this.inventoryLabelX = 192;
        this.inventoryLabelY = 91;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
        int i = (width - imageWidth) / 2;
        int j = (height - imageHeight) / 2;
        guiGraphics.blit(TEXTURE, i, j, 0, 0, imageWidth, imageHeight, 384, 256);
        AbstractInventoryAnimal dog = menu.dog;
        if (dog != null) {//todo
            if (dog.hasSaddlebag()) guiGraphics.blit(TEXTURE, i + 191, j + 25, 0, 187, dog.getInventoryColumns() * 18, 54, 384, 256);
            if (dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.COLLAR)) guiGraphics.blit(TEXTURE, i + 49, j + 75, 162, 205, 18, 18, 384, 256);
            if (dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.HARNESS)) guiGraphics.blit(TEXTURE, i + 49, j + 95, 180, 205, 18, 18, 384, 256);
            if (dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.VEST)) guiGraphics.blit(TEXTURE, i + 49, j + 115, 198, 205, 18, 18, 384, 256);
            if (dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.MUZZLE)) guiGraphics.blit(TEXTURE, i + 49, j + 135, 216, 205, 18, 18, 384, 256);
//            if (dog.canEquipSaddlebag()) guiGraphics.blit(TEXTURE, i + 49, j + 155, 234, 205, 18, 18, 384, 256);
        }
    }
}
