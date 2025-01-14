package com.github.kmfisk.workdog.tags;

import com.github.kmfisk.workdog.WorkDog;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public class WorkDogTags {
    public static final TagKey<EntityType<?>> WORKING_DOGS = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(WorkDog.MOD_ID, "working_dogs"));
    public static final TagKey<EntityType<?>> HERDING_DOGS = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(WorkDog.MOD_ID, "working_dogs/herding"));
    public static final TagKey<EntityType<?>> HUNTING_DOGS = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(WorkDog.MOD_ID, "working_dogs/hunting"));
    public static final TagKey<EntityType<?>> PROTECTION_DOGS = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(WorkDog.MOD_ID, "working_dogs/protection"));
    public static final TagKey<EntityType<?>> TERRIER_DOGS = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(WorkDog.MOD_ID, "working_dogs/terrier"));
    public static final TagKey<EntityType<?>> TOY_DOGS = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(WorkDog.MOD_ID, "working_dogs/toy"));

    public static final TagKey<Item> RAW_MEAT = ItemTags.create(new ResourceLocation("forge", "raw_meat"));
}
