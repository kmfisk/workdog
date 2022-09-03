package com.github.kmfisk.workdog.tags;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class WorkDogTags {
    public static void init() {
    }

    public static final ITag.INamedTag<Item> RAW_MEATS = ItemTags.bind("forge:raw_meats");
}
