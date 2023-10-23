package com.github.kmfisk.workdog.inventory;

import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

import java.util.Arrays;

public class DogEquipmentSlot extends Slot {
    public DogEquipmentSlot(IInventory container, int id, int posX, int posY) {
        super(container, id, posX, posY);
    }

    @Override
    public void setChanged() {
        container.setChanged();
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return Arrays.asList(WorkDogItems.SADDLEBAG.get(), WorkDogItems.COLLAR.get(), WorkDogItems.HARNESS.get(),
                WorkDogItems.HOG_VEST.get(), WorkDogItems.MUZZLE.get()).contains(stack);
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}
