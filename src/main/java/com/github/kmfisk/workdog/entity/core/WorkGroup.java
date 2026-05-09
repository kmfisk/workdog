package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.tags.WorkDogTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public enum WorkGroup {
    HUNTING("hunting_group", WorkDogTags.HUNTING_DOGS),
    BAY("bay_group", null),
    TERRIER("terrier_group", WorkDogTags.TERRIER_DOGS),
    GUARDIAN("guardian_group", null),
    HERDING("herding_group", WorkDogTags.HERDING_DOGS),
    SLED("sled_group", null),
    PROTECTION("protection_group", WorkDogTags.PROTECTION_DOGS),
    RETRIEVER("retriever_group", null),
    TOY("toy_group", WorkDogTags.TOY_DOGS),
    SUPPORT("support_group", null);

    private final String key;
    private final TagKey<EntityType<?>> tagKey;

    WorkGroup(String key, TagKey<EntityType<?>> tagKey) {
        this.key = key;
        this.tagKey = tagKey;
    }

    public String getKey() {
        return key;
    }

    public TagKey<EntityType<?>> getTagKey() {
        return tagKey;
    }

    public boolean hasWorkingMode() {
        return this != TOY;
    }
}
