package com.github.kmfisk.workdog.inventory;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WorkDogContainer extends Container {
    private final IInventory container;
    public final WorkDogEntity dog;

    public WorkDogContainer(int id, PlayerInventory playerInventory) {
        this(id, playerInventory, new Inventory(5), null);
    }

    public WorkDogContainer(int id, PlayerInventory playerInventory, IInventory dogInventory, final WorkDogEntity dog) {
        super(WDContainerTypes.WORK_DOG_CONTAINER.get(), id);
        this.container = dogInventory;
        this.dog = dog;
        dogInventory.startOpen(playerInventory.player);
        // TODO
        this.addSlot(new DogEquipmentSlot(dogInventory, 0, 50, 76));
        this.addSlot(new DogEquipmentSlot(dogInventory, 1, 50, 96));
        this.addSlot(new DogEquipmentSlot(dogInventory, 2, 50, 116));
        this.addSlot(new DogEquipmentSlot(dogInventory, 3, 50, 136));
        this.addSlot(new DogEquipmentSlot(dogInventory, 4, 50, 156));

        if (dog != null && dog.hasSaddlebag()) {
            for (int k = 0; k < 3; ++k) {
                for (int l = 0; l < dog.getInventoryColumns(); ++l) {
                    this.addSlot(new Slot(dogInventory, 5 + l + k * dog.getInventoryColumns(), 80 + l * 18, 18 + k * 18));
                }
            }
        }

        for (int i1 = 0; i1 < 3; ++i1) {
            for (int k1 = 0; k1 < 9; ++k1) {
                this.addSlot(new Slot(playerInventory, k1 + i1 * 9 + 9, 192 + k1 * 18, 102 + i1 * 18));
            }
        }

        for (int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot(playerInventory, j1, 192 + j1 * 18, 160));
        }
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return container.stillValid(player) && dog.isAlive() && dog.distanceTo(player) < 8.0F;
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity player, int slotId) { // todo
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = slots.get(slotId);
        if (slot != null && slot.hasItem()) {
            ItemStack slotItem = slot.getItem();
            stack = slotItem.copy();
            int i = container.getContainerSize();
            if (slotId < i) {
                if (!moveItemStackTo(slotItem, i, slots.size(), true)) return ItemStack.EMPTY;
            } else if (getSlot(1).mayPlace(slotItem) && !getSlot(1).hasItem()) {
                if (!moveItemStackTo(slotItem, 1, 2, false)) return ItemStack.EMPTY;
            } else if (getSlot(0).mayPlace(slotItem)) {
                if (!moveItemStackTo(slotItem, 0, 1, false)) return ItemStack.EMPTY;
            } else if (i <= 2 || !moveItemStackTo(slotItem, 2, i, false)) {
                int j = i + 27;
                int k = j + 9;
                if (slotId >= j && slotId < k) {
                    if (!moveItemStackTo(slotItem, i, j, false)) return ItemStack.EMPTY;
                } else if (slotId >= i && slotId < j) {
                    if (!moveItemStackTo(slotItem, j, k, false)) return ItemStack.EMPTY;
                } else if (!moveItemStackTo(slotItem, j, j, false)) return ItemStack.EMPTY;

                return ItemStack.EMPTY;
            }

            if (slotItem.isEmpty()) slot.set(ItemStack.EMPTY);
            else slot.setChanged();
        }

        return stack;
    }

    @Override
    public void removed(PlayerEntity player) {
        super.removed(player);
        container.stopOpen(player);
    }
}
