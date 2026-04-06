package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import net.minecraft.world.item.Item;

public class DogEquipmentItem extends Item {
    private final AbstractInventoryAnimal.DogEquipmentType dogEquipmentType;

    public DogEquipmentItem(Properties properties, AbstractInventoryAnimal.DogEquipmentType dogEquipmentType) {
        super(properties);
        this.dogEquipmentType = dogEquipmentType;
    }

    public int getProtection() {
        return 3; //3=leather, 5=iron, 7=gold, 11=diamond
    }

    public AbstractInventoryAnimal.DogEquipmentType getDogEquipmentType() {
        return dogEquipmentType;
    }
}
