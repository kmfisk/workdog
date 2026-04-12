package com.github.kmfisk.workdog.client.gui;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.github.kmfisk.workdog.inventory.BreedStandardContainerMenu;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.registries.ForgeRegistries;

public class BreedStandardContainerScreen extends AbstractContainerScreen<BreedStandardContainerMenu> {
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/dog_2.png");

    public BreedStandardContainerScreen(BreedStandardContainerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 360;
        this.imageHeight = 187;
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        if (menu.dog instanceof WorkDogEntity workDog) {
            guiGraphics.blit(new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/" + ForgeRegistries.ENTITY_TYPES.getKey(workDog.getType()).getPath() + "_" + workDog.getVariantName() + ".png"), 57, 15, 0, 0, 48, 48, 48, 48);
            drawCenteredString(guiGraphics, title.plainCopy().withStyle(ChatFormatting.BOLD), 152, 11);
//            drawCenteredString(guiGraphics, workDog.getGender().getName(), 152, 29);
            renderParentage(guiGraphics, 135, 41);
            renderHealth(guiGraphics, 152, 61);

            guiGraphics.blit(BACKGROUND_TEXTURE, 50, 76, 16 * workDog.getWorkGroup().ordinal(), 187, 16, 16, 384, 256);
            guiGraphics.blit(BACKGROUND_TEXTURE, 50, 96, 160 + 16 * workDog.getGender().ordinal(), 187, 16, 16, 384, 256);
            guiGraphics.blit(BACKGROUND_TEXTURE, 50, 116, 192 + 16 * workDog.getWeatherType().ordinal(), 187, 16, 16, 384, 256);
            guiGraphics.blit(BACKGROUND_TEXTURE, 50, 136, workDog.isLonghair() ? 0 : 16, 203, 16, 16, 384, 256);
            guiGraphics.blit(BACKGROUND_TEXTURE, 50, 156, 32, 203, 16, 16, 384, 256);

            Component pronoun1 = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun" : "gui.workdog.female.pronoun");
            Component pronoun2 = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun2" : "gui.workdog.female.pronoun2");
            drawCenteredWordWrap(guiGraphics, Component.translatable("blurb.workdog." + workDog.getWorkGroup().getKey(), title, pronoun1, pronoun2), 129, 85, 118);

            drawCenteredString(guiGraphics, workDog.getType().getDescription().plainCopy().withStyle(ChatFormatting.BOLD), 274, 11);
            drawCenteredString(guiGraphics, Component.literal("Large hunting dog"), 274, 20);
            drawCenteredWordWrap(guiGraphics, Component.translatable("blurb.workdog.akita"), 274, 38, 156);
        }
    }

    public void drawCenteredString(GuiGraphics guiGraphics, Component text, int guiCenterX, int guiY) {
        guiGraphics.drawString(font, text, guiCenterX - (font.width(text) / 2), guiY, 4210752, false);
    }

    public void drawCenteredWordWrap(GuiGraphics guiGraphics, Component text, int guiCenterX, int guiY, int maxWidth) {
        for (FormattedCharSequence charSequence : font.split(text, maxWidth)) {
            guiGraphics.drawString(font, charSequence, guiCenterX - (font.width(charSequence) / 2), guiY, 4210752, false);
            guiY += 9;
        }
    }

    private void renderParentage(GuiGraphics guiGraphics, int guiX, int guiY) {
        if (menu.dog instanceof WorkDogEntity workDog) {
            Component pronoun = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun" : "gui.workdog.female.pronoun");
            ResourceLocation unknownIcon = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/unknown.png");
            ResourceLocation paternalIcon = unknownIcon;
            ResourceLocation maternalIcon = unknownIcon;
            if (!workDog.getParentDataList().isEmpty() && workDog.getParentDataList().size() == 8) {
                paternalIcon = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/" + workDog.getParentDataList().get(3) + "_" + workDog.getParentDataList().get(2) + ".png");
                maternalIcon = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/" + workDog.getParentDataList().get(7) + "_" + workDog.getParentDataList().get(6) + ".png");
            }
            guiGraphics.blit(paternalIcon, guiX, guiY, 0, 0, 16, 16, 16, 16);
            guiGraphics.blit(maternalIcon, guiX + 18, guiY, 0, 0, 16, 16, 16, 16);
        }
    }

    private void renderHealth(GuiGraphics guiGraphics, int guiX, int guiY) {
        int dogHealth = Mth.ceil(menu.dog.getHealth());
        int maxHealth = Mth.ceil(menu.dog.getAttributeValue(Attributes.MAX_HEALTH));
        Component health = Component.literal(dogHealth + "/" + maxHealth);
        int centeredX = guiX - ((10 + font.width(health)) / 2);
        ResourceLocation guiIcons = new ResourceLocation("textures/gui/icons.png");
        guiGraphics.blit(guiIcons, centeredX, guiY, 16, 0, 9, 9);
        guiGraphics.blit(guiIcons, centeredX, guiY, 52, 0, 9, 9);
        guiGraphics.drawString(font, health, centeredX + 11, guiY + 1, 4210752, false);
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
        guiGraphics.blit(BACKGROUND_TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight, 384, 256);
    }
}
