package com.github.kmfisk.workdog.inventory;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.github.kmfisk.workdog.item.DogEquipmentItem;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;

public class WorkDogInventoryMenu extends AbstractContainerMenu {
    private final Container container;
    public final AbstractInventoryAnimal dog;

    public WorkDogInventoryMenu(int id, Inventory playerInventory) {
        this(id, playerInventory, new SimpleContainer(
                WorkDog.getReferencedMob() != null && WorkDog.getReferencedMob() instanceof WorkDogEntity ? ((WorkDogEntity) WorkDog.getReferencedMob()).getInventorySize() : 4
        ), null);
    }

    public WorkDogInventoryMenu(int id, Inventory playerInventory, Container dogInventory, AbstractInventoryAnimal dog) {
        super(WDMenuTypes.WORK_DOG_CONTAINER.get(), id);
        this.container = dogInventory;
        if (dog == null && WorkDog.getReferencedMob() instanceof WorkDogEntity)
            dog = (WorkDogEntity) WorkDog.getReferencedMob();
        this.dog = dog;
        dogInventory.startOpen(playerInventory.player);
        for (int i = 0; i < 4; i++) {
            int slotId = i;
            addSlot(new Slot(dogInventory, slotId, 50, i * 20 + 76) {
                @Override
                public boolean mayPlace(ItemStack itemStack) {
                    if (WorkDogInventoryMenu.this.dog.isDogEquipment(itemStack) && WorkDogInventoryMenu.this.dog.canWearDogEquipment(itemStack)) {
                        AbstractInventoryAnimal.DogEquipmentType equipmentType = ((DogEquipmentItem) itemStack.getItem()).getDogEquipmentType();
                        return WorkDogInventoryMenu.this.dog.canWearDogEquipmentType(equipmentType) && equipmentType == AbstractInventoryAnimal.DogEquipmentType.fromSlotId(slotId) && !hasItem();
                    }
                    return false;
                }

                @Override
                public int getMaxStackSize() {
                    return 1;
                }

                @Override
                public boolean isActive() {
                    return WorkDogInventoryMenu.this.dog.canWearDogEquipmentType(AbstractInventoryAnimal.DogEquipmentType.fromSlotId(slotId));
                }
            });
        }

        if (WorkDogInventoryMenu.this.dog.hasSaddlebag()) {
            for (int row = 0; row < 3; ++row) {
                for (int column = 0; column < dog.getInventoryColumns(); ++column) {
                    this.addSlot(new Slot(dogInventory, 4 + column + row * dog.getInventoryColumns(), 192 + column * 18, 26 + row * 18));
                }
            }
        }

        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, column + row * 9 + 9, 192 + column * 18, 102 + row * 18));
            }
        }

        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, 192 + column * 18, 160));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        double reach = player.getAttributeValue(ForgeMod.ENTITY_REACH.get()) + 5;
        return !dog.hasInventoryChanged(container) && container.stillValid(player) && dog.isAlive() && dog.distanceTo(player) < reach;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotId) { // todo
        ItemStack stack = ItemStack.EMPTY;
//        Slot slot = slots.get(slotId);
//        if (slot != null && slot.hasItem()) {
//            ItemStack slotItem = slot.getItem();
//            stack = slotItem.copy();
//            int i = container.getContainerSize();
//            if (slotId < i) {
//                if (!moveItemStackTo(slotItem, i, slots.size(), true)) return ItemStack.EMPTY;
//            } else if (getSlot(1).mayPlace(slotItem) && !getSlot(1).hasItem()) {
//                if (!moveItemStackTo(slotItem, 1, 2, false)) return ItemStack.EMPTY;
//            } else if (getSlot(0).mayPlace(slotItem)) {
//                if (!moveItemStackTo(slotItem, 0, 1, false)) return ItemStack.EMPTY;
//            } else if (i <= 2 || !moveItemStackTo(slotItem, 2, i, false)) {
//                int j = i + 27;
//                int k = j + 9;
//                if (slotId >= j && slotId < k) {
//                    if (!moveItemStackTo(slotItem, i, j, false)) return ItemStack.EMPTY;
//                } else if (slotId >= i && slotId < j) {
//                    if (!moveItemStackTo(slotItem, j, k, false)) return ItemStack.EMPTY;
//                } else if (!moveItemStackTo(slotItem, j, j, false)) return ItemStack.EMPTY;
//
//                return ItemStack.EMPTY;
//            }
//
//            if (slotItem.isEmpty()) slot.set(ItemStack.EMPTY);
//            else slot.setChanged();
//        }

        return stack;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        container.stopOpen(player);
    }
}
