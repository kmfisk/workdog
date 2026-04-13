package com.github.kmfisk.workdog.client.gui;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.github.kmfisk.workdog.inventory.BreedStandardContainerMenu;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
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
            String breedKeyPath = ForgeRegistries.ENTITY_TYPES.getKey(workDog.getType()).getPath();
            guiGraphics.blit(new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/" + breedKeyPath + "_" + workDog.getVariantName() + ".png"), 57, 15, 0, 0, 48, 48, 48, 48);
            drawCenteredString(guiGraphics, title.plainCopy().withStyle(ChatFormatting.BOLD), 152, 11);
            drawScaledText(guiGraphics, workDog.getType().getDescription().plainCopy().append(" " + workDog.getGender().getName().getString()), 152, 20, 0.8F, true, true, 78);
            renderParentage(guiGraphics, 135, 38);
            renderHealth(guiGraphics, 152, 59);

            guiGraphics.blit(BACKGROUND_TEXTURE, 50, 76, 16 * workDog.getWorkGroup().ordinal(), 187, 16, 16, 384, 256);
            guiGraphics.blit(BACKGROUND_TEXTURE, 50, 96, 160 + 16 * workDog.getGender().ordinal(), 187, 16, 16, 384, 256);
            guiGraphics.blit(BACKGROUND_TEXTURE, 50, 116, 192 + 16 * workDog.getWeatherType().ordinal(), 187, 16, 16, 384, 256);
            guiGraphics.blit(BACKGROUND_TEXTURE, 50, 136, workDog.isLonghair() ? 0 : 16, 203, 16, 16, 384, 256);
            guiGraphics.blit(BACKGROUND_TEXTURE, 50, 156, 32, 203, 16, 16, 384, 256);

            Component pronoun1 = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun1" : "gui.workdog.female.pronoun1"); // he/she
            Component pronoun2 = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun2" : "gui.workdog.female.pronoun2"); // him/her
            Component pronoun3 = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun3" : "gui.workdog.female.pronoun2"); // his/her
            drawScaledText(guiGraphics, Component.translatable("blurb.workdog." + workDog.getWorkGroup().getKey(), title, pronoun1, pronoun2, pronoun3, pronoun1.getString().toLowerCase(), pronoun2.getString().toLowerCase(), pronoun3.getString().toLowerCase()), 129, 85, 0.8F, true, true, 118);

            drawCenteredString(guiGraphics, workDog.getType().getDescription().plainCopy().withStyle(ChatFormatting.BOLD), 274, 11);
            drawScaledText(guiGraphics, Component.literal(Component.translatable("entity.workdog.size." + workDog.getSize().name().toLowerCase()).getString() + " " + Component.translatable("entity.workdog.work_group." + workDog.getWorkGroup().getKey()).getString()), 274, 20, 0.8F, true, false, 0);
            drawScaledText(guiGraphics, Component.translatable("blurb.workdog." + breedKeyPath), 274, 34, 0.6F, true, true, 156);
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

    public void drawScaledText(GuiGraphics guiGraphics, Component text, int guiX, int guiY, float scale, boolean centered, boolean wordWrap, int maxWidth) {
        guiGraphics.pose().pushPose();
        guiGraphics.pose().scale(scale, scale, scale);
        if (centered && !wordWrap)
            drawCenteredString(guiGraphics, text, (int) (guiX / scale), (int) (guiY / scale));
        else if (!centered && wordWrap)
            guiGraphics.drawWordWrap(font, text, (int) (guiX / scale), (int) (guiY / scale), (int) (maxWidth / scale), 4210752);
        else if (centered) // && wordWrap always true
            drawCenteredWordWrap(guiGraphics, text, (int) (guiX / scale), (int) (guiY / scale), (int) (maxWidth / scale));
        else
            guiGraphics.drawString(font, text, (int) (guiX / scale), (int) (guiY / scale), 4210752, false);
        guiGraphics.pose().popPose();
    }

    private void renderParentage(GuiGraphics guiGraphics, int guiX, int guiY) {
        if (menu.dog instanceof WorkDogEntity workDog) {
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
        if (menu.dog instanceof WorkDogEntity workDog) {
            if (isHovering(57, 15, 48, 48, mouseX, mouseY))
                guiGraphics.renderTooltip(font, title.plainCopy().append(": ").append(Component.translatable("coat.workdog." + workDog.getVariantName())).append(" ").append(workDog.getType().getDescription()), mouseX, mouseY);

            if (!workDog.getParentDataList().isEmpty() && workDog.getParentDataList().size() == 8) {
                if (isHovering(135, 38, 16, 16, mouseX, mouseY)) {
                    Component variantName = Component.translatable("coat.workdog." + workDog.getParentDataList().get(2));
                    Component breedName = Component.translatable(Util.makeDescriptionId("entity", new ResourceLocation(WorkDog.MOD_ID, workDog.getParentDataList().get(3))));
                    guiGraphics.renderTooltip(font, Component.literal(workDog.getParentDataList().get(1) + ": " + variantName.getString() + " " + breedName.getString()), mouseX, mouseY);
                }
                if (isHovering(135 + 18, 38, 16, 16, mouseX, mouseY)) {
                    Component variantName = Component.translatable("coat.workdog." + workDog.getParentDataList().get(6));
                    Component breedName = Component.translatable(Util.makeDescriptionId("entity", new ResourceLocation(WorkDog.MOD_ID, workDog.getParentDataList().get(7))));
                    guiGraphics.renderTooltip(font, Component.literal(workDog.getParentDataList().get(5) + ": " + variantName.getString() + " " + breedName.getString()), mouseX, mouseY);
                }
            }

            if (isHovering(50, 76, 16, 16, mouseX, mouseY))
                guiGraphics.renderTooltip(font, Component.translatable("entity.workdog.work_group." + workDog.getWorkGroup().getKey()), mouseX, mouseY);
            if (isHovering(50, 96, 16, 16, mouseX, mouseY)) {
                Component genderTooltip = Component.translatable("gui.workdog." + workDog.getGender().name().toLowerCase() + ".tooltip");
                guiGraphics.renderTooltip(font, font.split(genderTooltip, Math.max(guiGraphics.guiWidth() / 2, 200)), mouseX, mouseY);
            }
            if (isHovering(50, 116, 16, 16, mouseX, mouseY)) {
                Component climateTooltip = Component.translatable("gui.workdog.climate." + workDog.getWeatherType().name().toLowerCase());
                guiGraphics.renderTooltip(font, font.split(climateTooltip, Math.max(guiGraphics.guiWidth() / 2, 200)), mouseX, mouseY);
            }
            if (isHovering(50, 136, 16, 16, mouseX, mouseY)) {
                Component coatTooltip = Component.translatable("gui.workdog.coat_type." + (workDog.isLonghair() ? "long" : "short"));
                guiGraphics.renderTooltip(font, font.split(coatTooltip, Math.max(guiGraphics.guiWidth() / 2, 200)), mouseX, mouseY);
            }
            if (isHovering(50, 156, 16, 16, mouseX, mouseY)) {
                Component speedTooltip = Component.translatable("gui.workdog.speed", title, Component.translatable("gui.workdog.speed.low", "[SPEED]")); //todo
                guiGraphics.renderTooltip(font, font.split(speedTooltip, Math.max(guiGraphics.guiWidth() / 2, 200)), mouseX, mouseY);
            }
        }
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
