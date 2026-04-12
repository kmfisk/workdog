package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import net.minecraft.world.item.DyeableLeatherItem;

public class DyeableDogEquipmentItem extends DogEquipmentItem implements DyeableLeatherItem {
    public DyeableDogEquipmentItem(Properties properties, int protection, AbstractInventoryAnimal.DogEquipmentType dogEquipmentType) {
        super(properties, protection, dogEquipmentType);
    }
}
