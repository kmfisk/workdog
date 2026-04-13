package com.github.kmfisk.workdog.client.gui;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.github.kmfisk.workdog.inventory.WorkDogUnownedContainerMenu;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.registries.ForgeRegistries;

public class WorkDogUnownedContainerScreen extends AbstractContainerScreen<WorkDogUnownedContainerMenu> {
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/dog_unowned.png");
    private static final ResourceLocation ICONS_TEXTURE = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/dog_2.png");
    private boolean albinistic, melanistic;
    int conditionalIconsShown;

    public WorkDogUnownedContainerScreen(WorkDogUnownedContainerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 232;
        this.imageHeight = 187;
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        if (menu.dog instanceof WorkDogEntity workDog) {
            guiGraphics.blit(new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/" + ForgeRegistries.ENTITY_TYPES.getKey(workDog.getType()).getPath() + "_" + workDog.getVariantName() + ".png"), 15, 15, 0, 0, 48, 48, 48, 48);
            drawCenteredString(guiGraphics, title.plainCopy().withStyle(ChatFormatting.BOLD), 130, 11);
            drawCenteredString(guiGraphics, workDog.getType().getDescription(), 130, 20);
            drawCenteredString(guiGraphics, workDog.getGender().getName(), 130, 29);
            renderParentage(guiGraphics, 113, 41);
            renderHealth(guiGraphics, 130, 61);
            Component owner = workDog.getOwner() != null ? Component.translatable("gui.workdog.owner", title, workDog.getOwner().getName()) : Component.translatable("gui.workdog.unknown_owner");
            drawCenteredString(guiGraphics, owner, 96, 82); // todo save owner name to nbt to account for offline players probably?
            Component pronoun = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun1" : "gui.workdog.female.pronoun1");
//            guiGraphics.drawString(font, Component.translatable("gui.workdog.birthday", pronoun, "[DATE]"), 68, 82 + 9 * 2, 4210752, false);
            Component lifeStage = Component.translatable(workDog.isBaby() ? "gui.workdog.age_puppy" : "gui.workdog.age_adult");
            drawCenteredString(guiGraphics, Component.translatable("gui.workdog.age", pronoun, lifeStage), 96, 100);

            albinistic = workDog.getVariant() == workDog.getVariantCount();
            melanistic = workDog.getVariant() == workDog.getVariantCount() + 1;
            conditionalIconsShown = albinistic || melanistic ? 2 : 1;
            int icon1X = -16;
            if (workDog.getBreedingStatus(WorkDogEntity.BreedingStatus.HEAT)) icon1X = 80;
            else if (workDog.getBreedingStatus(WorkDogEntity.BreedingStatus.PREGNANT)) icon1X = 96;
            else if (workDog.isInfertile()) icon1X = 112;
            else conditionalIconsShown = 1;
            guiGraphics.blit(ICONS_TEXTURE, 96 - (16 * conditionalIconsShown) / 2, 165, icon1X, 203, 16, 16, 384, 256);

            int icon2X = -16;
            if (albinistic) icon2X = 128;
            else if (melanistic) icon2X = 144;
            guiGraphics.blit(ICONS_TEXTURE, 96 - (16 * conditionalIconsShown) / 2 + 16 * (conditionalIconsShown - 1), 165, icon2X, 203, 16, 16, 384, 256);
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
            Component pronoun = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun1" : "gui.workdog.female.pronoun1");
            ResourceLocation unknownIcon = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/unknown.png");
            ResourceLocation paternalIcon = unknownIcon;
            ResourceLocation maternalIcon = unknownIcon;
            if (!workDog.getParentDataList().isEmpty() && workDog.getParentDataList().size() == 8) {
                paternalIcon = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/" + workDog.getParentDataList().get(3) + "_" + workDog.getParentDataList().get(2) + ".png");
                maternalIcon = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/" + workDog.getParentDataList().get(7) + "_" + workDog.getParentDataList().get(6) + ".png");
                drawCenteredWordWrap(guiGraphics, Component.translatable("gui.workdog.parentage", pronoun, workDog.getParentDataList().get(1), workDog.getParentDataList().get(5)), 96, 118, 176);

            } else drawCenteredString(guiGraphics, Component.translatable("gui.workdog.stray", pronoun), 96, 118);

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
            if (isHovering(15, 15, 48, 48, mouseX, mouseY))
                guiGraphics.renderTooltip(font, title.plainCopy().append(": ").append(Component.translatable("coat.workdog." + workDog.getVariantName())).append(" ").append(workDog.getType().getDescription()), mouseX, mouseY);

            if (!workDog.getParentDataList().isEmpty() && workDog.getParentDataList().size() == 8) {
                if (isHovering(113, 41, 16, 16, mouseX, mouseY)) {
                    Component variantName = Component.translatable("coat.workdog." + workDog.getParentDataList().get(2));
                    Component breedName = Component.translatable(Util.makeDescriptionId("entity", new ResourceLocation(WorkDog.MOD_ID, workDog.getParentDataList().get(3))));
                    guiGraphics.renderTooltip(font, Component.literal(workDog.getParentDataList().get(1) + ": " + variantName.getString() + " " + breedName.getString()), mouseX, mouseY);
                }
                if (isHovering(113 + 18, 41, 16, 16, mouseX, mouseY)) {
                    Component variantName = Component.translatable("coat.workdog." + workDog.getParentDataList().get(6));
                    Component breedName = Component.translatable(Util.makeDescriptionId("entity", new ResourceLocation(WorkDog.MOD_ID, workDog.getParentDataList().get(7))));
                    guiGraphics.renderTooltip(font, Component.literal(workDog.getParentDataList().get(5) + ": " + variantName.getString() + " " + breedName.getString()), mouseX, mouseY);
                }
            }

            if (conditionalIconsShown > 1 || (!albinistic && !melanistic)) {
                if (isHovering(96 - (16 * conditionalIconsShown) / 2, 165, 16, 16, mouseX, mouseY)) {
                    Component breedingStatus = null;
                    Component pronoun = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun1" : "gui.workdog.female.pronoun1");
                    if (workDog.getBreedingStatus(WorkDogEntity.BreedingStatus.HEAT))
                        breedingStatus = Component.translatable("gui.workdog.heat", title);
                    else if (workDog.getBreedingStatus(WorkDogEntity.BreedingStatus.PREGNANT)) {
                        Component timerHint;
                        if (workDog.getBreedTimer() >= WorkDogConfig.pregnancyTimer.get() / 1.5)
                            timerHint = Component.translatable("gui.workdog.pregnant.hint_1");
                        else if (workDog.getBreedTimer() >= WorkDogConfig.pregnancyTimer.get() / 3)
                            timerHint = Component.translatable("gui.workdog.pregnant.hint_2");
                        else if (workDog.getBreedTimer() >= WorkDogConfig.pregnancyTimer.get() / 9)
                            timerHint = Component.translatable("gui.workdog.pregnant.hint_3");
                        else timerHint = Component.translatable("gui.workdog.pregnant.hint_4");
                        Component s = workDog.getSire().contains("CustomName", 8) ? Component.Serializer.fromJson(workDog.getSire().getString("CustomName")) : Component.empty();
                        String sireName = s == null || s.getString().isEmpty() ? "???" : s.getString();
                        breedingStatus = Component.translatable("gui.workdog.pregnant", title, sireName, timerHint);
                    } else if (workDog.isInfertile())
                        breedingStatus = Component.translatable("gui.workdog.infertile", title, pronoun);
                    if (breedingStatus != null) guiGraphics.renderTooltip(font, font.split(breedingStatus, Math.max(guiGraphics.guiWidth() / 2, 200)), mouseX, mouseY);
                }
            }
            if (albinistic || melanistic) {
                if (isHovering(96 - (16 * conditionalIconsShown) / 2 + 18 * (conditionalIconsShown - 1), 165, 16, 16, mouseX, mouseY)) {
                    String pronoun2 = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun2" : "gui.workdog.female.pronoun2").getString().toLowerCase();
                    Component tooltip = Component.translatable(albinistic ? "gui.workdog.albinistic" : "gui.workdog.melanistic", title, pronoun2);
                    guiGraphics.renderTooltip(font, font.split(tooltip, Math.max(guiGraphics.guiWidth() / 2, 200)), mouseX, mouseY);
                }
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
        guiGraphics.blit(BACKGROUND_TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight);
    }
}
