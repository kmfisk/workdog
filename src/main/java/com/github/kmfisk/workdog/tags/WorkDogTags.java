package com.github.kmfisk.workdog.tags;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class WorkDogTags {
    public static final Tags.IOptionalNamedTag<Item> RAW_MEATS = ItemTags.createOptional(new ResourceLocation("forge", "raw_meats"));
}
