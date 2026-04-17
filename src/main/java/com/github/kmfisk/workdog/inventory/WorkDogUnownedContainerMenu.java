package com.github.kmfisk.workdog.inventory;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;

public class WorkDogUnownedContainerMenu extends AbstractContainerMenu {
    public final AbstractInventoryAnimal dog;

    public WorkDogUnownedContainerMenu(int id, Inventory playerInventory) {
        super(WDMenuTypes.WORK_DOG_UNOWNED_CONTAINER.get(), id);
        dog = (WorkDogEntity) WorkDog.getReferencedMob();
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotId) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        double reach = player.getAttributeValue(ForgeMod.ENTITY_REACH.get()) + 5;
        return dog != null && dog.isAlive() && dog.distanceTo(player) < reach;
    }
}
