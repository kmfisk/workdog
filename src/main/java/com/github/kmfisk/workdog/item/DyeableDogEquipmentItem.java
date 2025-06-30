package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.entity.core.TEMPInventoryEntity;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.Item.Properties;

public class DyeableDogEquipmentItem extends DogEquipmentItem implements DyeableLeatherItem {
    public DyeableDogEquipmentItem(Properties properties, TEMPInventoryEntity.DogEquipmentType dogEquipmentType) {
        super(properties, dogEquipmentType);
    }
}
