package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

public class ServiceVestItem extends DogEquipmentItem {
    private final DyeColor color;

    public ServiceVestItem(Properties properties, DyeColor color) {
        super(properties, AbstractInventoryAnimal.DogEquipmentType.VEST);
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }
}
