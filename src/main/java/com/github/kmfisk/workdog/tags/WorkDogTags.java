package com.github.kmfisk.workdog.tags;

import com.github.kmfisk.workdog.WorkDog;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.Tags;

public class WorkDogTags {
    public static final Tags.IOptionalNamedTag<EntityType<?>> WORKING_DOGS = EntityTypeTags.createOptional(new ResourceLocation(WorkDog.MOD_ID, "working_dogs"));
    public static final Tags.IOptionalNamedTag<EntityType<?>> HERDING_DOGS = EntityTypeTags.createOptional(new ResourceLocation(WorkDog.MOD_ID, "working_dogs/herding"));
    public static final Tags.IOptionalNamedTag<EntityType<?>> HUNTING_DOGS = EntityTypeTags.createOptional(new ResourceLocation(WorkDog.MOD_ID, "working_dogs/hunting"));
    public static final Tags.IOptionalNamedTag<EntityType<?>> PROTECTION_DOGS = EntityTypeTags.createOptional(new ResourceLocation(WorkDog.MOD_ID, "working_dogs/protection"));
    public static final Tags.IOptionalNamedTag<EntityType<?>> TERRIER_DOGS = EntityTypeTags.createOptional(new ResourceLocation(WorkDog.MOD_ID, "working_dogs/terrier"));
    public static final Tags.IOptionalNamedTag<EntityType<?>> TOY_DOGS = EntityTypeTags.createOptional(new ResourceLocation(WorkDog.MOD_ID, "working_dogs/toy"));

    public static final Tags.IOptionalNamedTag<Item> RAW_MEAT = ItemTags.createOptional(new ResourceLocation("forge", "raw_meat"));
}
