package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import net.minecraft.world.item.Item;

public class DogEquipmentItem extends Item {
    private final int protection;
    private final AbstractInventoryAnimal.DogEquipmentType dogEquipmentType;

    public DogEquipmentItem(Properties properties, int protection, AbstractInventoryAnimal.DogEquipmentType dogEquipmentType) {
        super(properties);
        this.protection = protection;
        this.dogEquipmentType = dogEquipmentType;
    }

    public int getProtection() {
        return protection;
    }

    public AbstractInventoryAnimal.DogEquipmentType getDogEquipmentType() {
        return dogEquipmentType;
    }
}
