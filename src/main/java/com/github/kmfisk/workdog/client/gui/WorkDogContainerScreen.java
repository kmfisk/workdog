package com.github.kmfisk.workdog.client.gui;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.github.kmfisk.workdog.inventory.WorkDogContainerMenu;
import com.github.kmfisk.workdog.network.ServerboundSetDogModePacket;
import com.github.kmfisk.workdog.network.WorkDogChannel;
import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.registries.ForgeRegistries;

public class WorkDogContainerScreen extends AbstractContainerScreen<WorkDogContainerMenu> {
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/dog_1.png");
    private boolean albinistic, melanistic;
    int conditionalIconsShown;

    public WorkDogContainerScreen(WorkDogContainerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 360;
        this.imageHeight = 187;
        this.titleLabelX = 152;
        this.titleLabelY = 15;
        this.inventoryLabelX = 192;
        this.inventoryLabelY = 91;
    }

    @Override
    protected void init() {
        super.init();
        if (menu.dog instanceof WorkDogEntity workDog) {
            addRenderableWidget(CycleButton.builder(WorkDogEntity.Mode::getDisplayName)
                    .withValues(CycleButton.ValueListSupplier.create(() -> workDog.getWorkGroup() == null || !workDog.getWorkGroup().hasWorkingMode(), ImmutableList.copyOf(WorkDogEntity.Mode.values()), ImmutableList.of(WorkDogEntity.Mode.FOLLOW, WorkDogEntity.Mode.WANDER)))
                    .withInitialValue(workDog.getMode())
                    .displayOnlyValue().create(
                            leftPos + 152 - 35, topPos + 57, 70, 20, Component.empty(),
                            (button, mode) -> changeDogMode(workDog, mode)
                    ));
        }
    }

    private void changeDogMode(WorkDogEntity workDog, WorkDogEntity.Mode mode) {
        workDog.setMode(mode);
        WorkDogChannel.sendToServer(new ServerboundSetDogModePacket(workDog.getId(), mode.ordinal()));
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        if (menu.dog instanceof WorkDogEntity workDog) {
            guiGraphics.blit(new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/" + ForgeRegistries.ENTITY_TYPES.getKey(workDog.getType()).getPath() + "_" + workDog.getVariantName() + ".png"), 57, 15, 0, 0, 48, 48, 48, 48);
            Component dogTitle = title.plainCopy().append(", ").append(workDog.getType().getDescription()).append(" ").append(workDog.getGender().getName());
            guiGraphics.drawString(font, dogTitle, 114, 11, 4210752, false);
            renderParentage(guiGraphics, 135, 23);
            renderHealth(guiGraphics, 152, 43);
            Component owner = workDog.getOwner() != null ? Component.translatable("gui.workdog.owner", title, workDog.getOwner().getName()) : Component.translatable("gui.workdog.unknown_owner");
            guiGraphics.drawString(font, owner, 68, 82, 4210752, false); // todo save owner name to nbt to account for offline players probably?
            Component pronoun = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun1" : "gui.workdog.female.pronoun1");
//            guiGraphics.drawString(font, Component.translatable("gui.workdog.birthday", pronoun, "[DATE]"), 68, 82 + 9 * 2, 4210752, false);
            Component lifeStage = Component.translatable(workDog.isBaby() ? "gui.workdog.age_puppy" : "gui.workdog.age_adult");
            guiGraphics.drawString(font, Component.translatable("gui.workdog.age", pronoun, lifeStage), 68, 100, 4210752, false);

            albinistic = workDog.getVariant() == workDog.getVariantCount();
            melanistic = workDog.getVariant() == workDog.getVariantCount() + 1;
            conditionalIconsShown = albinistic || melanistic ? 2 : 1;
            int icon1X = -16;
            if (workDog.getBreedingStatus(WorkDogEntity.BreedingStatus.HEAT)) icon1X = 163;
            else if (workDog.getBreedingStatus(WorkDogEntity.BreedingStatus.PREGNANT)) icon1X = 181;
            else if (workDog.isInfertile()) icon1X = 199;
            else conditionalIconsShown = 1;
            guiGraphics.blit(BACKGROUND_TEXTURE, 129 - (16 * conditionalIconsShown) / 2, 165, icon1X, 188, 16, 16, 384, 256);

            int icon2X = -16;
            if (albinistic) icon2X = 217;
            else if (melanistic) icon2X = 235;
            guiGraphics.blit(BACKGROUND_TEXTURE, 129 - (16 * conditionalIconsShown) / 2 + 16 * (conditionalIconsShown - 1), 165, icon2X, 188, 16, 16, 384, 256);
        }

        guiGraphics.drawString(font, playerInventoryTitle, inventoryLabelX, inventoryLabelY, 4210752, false);
    }

    private void renderParentage(GuiGraphics guiGraphics, int guiX, int guiY) {
        if (menu.dog instanceof WorkDogEntity workDog) {
            Component pronoun = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun1" : "gui.workdog.female.pronoun1");
            ResourceLocation unknownIcon = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/unknown.png");
            ResourceLocation paternalIcon = unknownIcon;
            ResourceLocation maternalIcon = unknownIcon;
            if (workDog.getParentDataList().get(0).length > 0) {
                paternalIcon = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/" + workDog.getParentDataList().get(0)[3] + "_" + workDog.getParentDataList().get(0)[2] + ".png");
                maternalIcon = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/" + workDog.getParentDataList().get(1)[3] + "_" + workDog.getParentDataList().get(1)[2] + ".png");
                guiGraphics.drawWordWrap(font, Component.translatable("gui.workdog.parentage", pronoun, workDog.getParentDataList().get(0)[1], workDog.getParentDataList().get(1)[1]), 68, 118, 122, 4210752);

            } else
                guiGraphics.drawWordWrap(font, Component.translatable("gui.workdog.stray", pronoun), 68, 118, 122, 4210752);

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

            if (workDog.getParentDataList().get(0).length > 0) {
                if (isHovering(135, 23, 16, 16, mouseX, mouseY)) {
                    Component variantName = Component.translatable("coat.workdog." + workDog.getParentDataList().get(0)[2]);
                    Component breedName = Component.translatable(Util.makeDescriptionId("entity", new ResourceLocation(WorkDog.MOD_ID, workDog.getParentDataList().get(0)[3])));
                    guiGraphics.renderTooltip(font, Component.literal(workDog.getParentDataList().get(0)[1] + ": " + variantName.getString() + " " + breedName.getString()), mouseX, mouseY);
                }
                if (isHovering(135 + 18, 23, 16, 16, mouseX, mouseY)) {
                    Component variantName = Component.translatable("coat.workdog." + workDog.getParentDataList().get(1)[2]);
                    Component breedName = Component.translatable(Util.makeDescriptionId("entity", new ResourceLocation(WorkDog.MOD_ID, workDog.getParentDataList().get(1)[3])));
                    guiGraphics.renderTooltip(font, Component.literal(workDog.getParentDataList().get(1)[1] + ": " + variantName.getString() + " " + breedName.getString()), mouseX, mouseY);
                }
            }

            if (conditionalIconsShown > 1 || (!albinistic && !melanistic)) {
                if (isHovering(129 - (16 * conditionalIconsShown) / 2, 165, 16, 16, mouseX, mouseY)) {
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
                    if (breedingStatus != null)
                        guiGraphics.renderTooltip(font, font.split(breedingStatus, Math.max(guiGraphics.guiWidth() / 2, 200)), mouseX, mouseY);
                }
            }
            if (albinistic || melanistic) {
                if (isHovering(129 - (16 * conditionalIconsShown) / 2 + 18 * (conditionalIconsShown - 1), 165, 16, 16, mouseX, mouseY)) {
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
        guiGraphics.blit(BACKGROUND_TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight, 384, 256);
        AbstractInventoryAnimal dog = menu.dog;
        if (dog != null) {
            if (dog.hasSaddlebag())
                guiGraphics.blit(BACKGROUND_TEXTURE, leftPos + 191, topPos + 25, 0, 187, dog.getInventoryColumns() * 18, 54, 384, 256);
            if (dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.MUZZLE))
                guiGraphics.blit(BACKGROUND_TEXTURE, leftPos + 49, topPos + 75, 162, 205, 18, 18, 384, 256);
            if (dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.COLLAR))
                guiGraphics.blit(BACKGROUND_TEXTURE, leftPos + 49, topPos + 95, 180, 205, 18, 18, 384, 256);
            if (dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.HARNESS))
                guiGraphics.blit(BACKGROUND_TEXTURE, leftPos + 49, topPos + 115, 198, 205, 18, 18, 384, 256);
            if (dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.VEST))
                guiGraphics.blit(BACKGROUND_TEXTURE, leftPos + 49, topPos + 135, 216, 205, 18, 18, 384, 256);
        }
    }
}
