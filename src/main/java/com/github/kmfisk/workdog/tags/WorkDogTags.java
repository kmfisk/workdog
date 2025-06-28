package com.github.kmfisk.workdog.tags;

import com.github.kmfisk.workdog.WorkDog;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public class WorkDogTags {
    public static final TagKey<EntityType<?>> WORKING_DOGS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(WorkDog.MOD_ID, "working_dogs"));
    public static final TagKey<EntityType<?>> HERDING_DOGS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(WorkDog.MOD_ID, "working_dogs/herding"));
    public static final TagKey<EntityType<?>> HUNTING_DOGS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(WorkDog.MOD_ID, "working_dogs/hunting"));
    public static final TagKey<EntityType<?>> PROTECTION_DOGS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(WorkDog.MOD_ID, "working_dogs/protection"));
    public static final TagKey<EntityType<?>> TERRIER_DOGS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(WorkDog.MOD_ID, "working_dogs/terrier"));
    public static final TagKey<EntityType<?>> TOY_DOGS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(WorkDog.MOD_ID, "working_dogs/toy"));

    public static final String FORGE_ID = "forge";
    public static final TagKey<Item> RAW_MEATS = ItemTags.create(new ResourceLocation(FORGE_ID, "raw_meats"));
    public static final TagKey<Item> RAW_BEEF = ItemTags.create(new ResourceLocation(FORGE_ID, "raw_beef"));
    public static final TagKey<Item> RAW_CHICKEN = ItemTags.create(new ResourceLocation(FORGE_ID, "raw_chicken"));
    public static final TagKey<Item> RAW_MUTTON = ItemTags.create(new ResourceLocation(FORGE_ID, "raw_mutton"));
    public static final TagKey<Item> RAW_PORK = ItemTags.create(new ResourceLocation(FORGE_ID, "raw_pork"));
    public static final TagKey<Item> RAW_RABBIT = ItemTags.create(new ResourceLocation(FORGE_ID, "raw_rabbit"));
}
