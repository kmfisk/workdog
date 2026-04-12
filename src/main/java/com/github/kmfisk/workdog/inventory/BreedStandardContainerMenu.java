package com.github.kmfisk.workdog.inventory;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;

public class BreedStandardContainerMenu extends AbstractContainerMenu {
    public final AbstractInventoryAnimal dog;

    public BreedStandardContainerMenu(int id, Inventory playerInventory) {
        super(WDMenuTypes.BREED_STANDARD_CONTAINER.get(), id);
        this.dog = (WorkDogEntity) WorkDog.getReferencedMob();
    }

    @Override
    public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        double reach = player.getAttributeValue(ForgeMod.ENTITY_REACH.get()) + 5;
        return dog.isAlive() && dog.distanceTo(player) < reach;
    }
}
