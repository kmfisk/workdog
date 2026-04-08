package com.github.kmfisk.workdog.client.gui;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.github.kmfisk.workdog.inventory.WorkDogInventoryMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.registries.ForgeRegistries;

public class WorkDogScreen extends AbstractContainerScreen<WorkDogInventoryMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(WorkDog.MOD_ID, "textures/gui/dog_1.png");

    public WorkDogScreen(WorkDogInventoryMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 360;
        this.imageHeight = 187;
        this.titleLabelX = 152;
        this.titleLabelY = 15;
        this.inventoryLabelX = 192;
        this.inventoryLabelY = 91;
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        if (menu.dog instanceof WorkDogEntity workDog) {
            Component dogTitle = title.plainCopy().append(", ").append(workDog.getType().getDescription()).append(" ").append(workDog.getGender().getName());
            guiGraphics.drawString(font, dogTitle, 114, 11, 4210752, false);
            guiGraphics.blit(new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/" + ForgeRegistries.ENTITY_TYPES.getKey(workDog.getType()).getPath() + "_" + workDog.getVariantName() + ".png" /*+ workDog.getType().getDescription()*/), 57, 15, 0, 0, 48, 48, 48, 48);
            renderParentage(guiGraphics, 135, 23);
            renderHealth(guiGraphics, 151, 43);
            Component owner = workDog.getOwner() != null ? Component.translatable("gui.workdog.owner", title, workDog.getOwner().getName()) : Component.translatable("gui.workdog.unknown_owner");
            guiGraphics.drawString(font, owner, 68, 82, 4210752, false); // todo save owner name to nbt to account for offline players probably?
            Component pronoun = Component.translatable(workDog.getGender().toBool() ? "gui.workdog.male.pronoun" : "gui.workdog.female.pronoun");
//            guiGraphics.drawString(font, Component.translatable("gui.workdog.birthday", pronoun, "[DATE]"), 68, 82 + 9 * 2, 4210752, false);
            Component lifeStage = Component.translatable(workDog.isBaby() ? "gui.workdog.age_puppy" : "gui.workdog.age_adult");
            guiGraphics.drawString(font, Component.translatable("gui.workdog.age", pronoun, lifeStage), 68, 100, 4210752, false);
            // if (parents aren't null) {
            guiGraphics.drawWordWrap(font, Component.translatable("gui.workdog.parentage", pronoun, "[NAME1]", "[NAME2]"), 68, 118, 122, 4210752);
//            } else guiGraphics.drawWordWrap(font, Component.translatable("gui.workdog.stray", pronoun), 68, 118, 122, 4210752);

            boolean albinistic = workDog.getVariant() == workDog.getVariantCount();
            boolean melanistic = workDog.getVariant() == workDog.getVariantCount() + 1;
            int i = albinistic || melanistic ? 2 : 1;
            int icon1X = -16;
            if (workDog.getBreedingStatus(WorkDogEntity.BreedingStatus.HEAT)) icon1X = 163;
            else if (workDog.getBreedingStatus(WorkDogEntity.BreedingStatus.PREGNANT)) icon1X = 181;
            else if (workDog.isInfertile()) icon1X = 199;
            else i = 1;
            guiGraphics.blit(TEXTURE, 129 - (16 * i) / 2, 165, icon1X, 188, 16, 16, 384, 256);

            int icon2X = -16;
            if (albinistic) icon2X = 217;
            else if (melanistic) icon2X = 235;
            guiGraphics.blit(TEXTURE, 129 - (16 * i) / 2 + 16 * (i - 1), 165, icon2X, 188, 16, 16, 384, 256);
        }

        guiGraphics.drawString(font, playerInventoryTitle, inventoryLabelX, inventoryLabelY, 4210752, false);
    }

    private void renderParentage(GuiGraphics guiGraphics, int guiX, int guiY) {
        guiGraphics.blit(new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/unknown.png"), guiX, guiY, 0, 0, 16, 16, 16, 16);
        guiGraphics.blit(new ResourceLocation(WorkDog.MOD_ID, "textures/gui/coat_portrait/unknown.png"), guiX + 18, guiY, 0, 0, 16, 16, 16, 16);
    }

    private void renderHealth(GuiGraphics guiGraphics, int guiX, int guiY) {
        int dogHealth = Mth.ceil(menu.dog.getHealth());
        int maxHealth = Mth.ceil(menu.dog.getAttributeValue(Attributes.MAX_HEALTH));
        Component health = Component.literal(dogHealth + "/" + maxHealth);
        int centeredX = guiX - ((9 + font.width(health)) / 2);
        ResourceLocation guiIcons = new ResourceLocation("textures/gui/icons.png");
        guiGraphics.blit(guiIcons, centeredX, guiY, 16, 0, 9, 9);
        guiGraphics.blit(guiIcons, centeredX, guiY, 52, 0, 9, 9);
        guiGraphics.drawString(font, health, centeredX + 11, guiY + 1, 4210752, false);
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
        if (dog != null) {
            if (dog.hasSaddlebag()) guiGraphics.blit(TEXTURE, i + 191, j + 25, 0, 187, dog.getInventoryColumns() * 18, 54, 384, 256);
            if (dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.MUZZLE)) guiGraphics.blit(TEXTURE, i + 49, j + 75, 162, 205, 18, 18, 384, 256);
            if (dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.COLLAR)) guiGraphics.blit(TEXTURE, i + 49, j + 95, 180, 205, 18, 18, 384, 256);
            if (dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.HARNESS)) guiGraphics.blit(TEXTURE, i + 49, j + 115, 198, 205, 18, 18, 384, 256);
            if (dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.VEST)) guiGraphics.blit(TEXTURE, i + 49, j + 135, 216, 205, 18, 18, 384, 256);
        }
    }
}
