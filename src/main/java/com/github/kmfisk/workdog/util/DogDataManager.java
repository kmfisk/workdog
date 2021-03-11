package com.github.kmfisk.workdog.util;

import com.github.kmfisk.workdog.entity.core.DogData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

import java.util.HashMap;
import java.util.Map;

public class DogDataManager extends JsonDataLoader {
    private static final Gson GSON = new Gson();
    private final Map<Identifier, DogData> dataMap = new HashMap<>();

    public DogDataManager() {
        super(GSON, "breeds");
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> loader, ResourceManager manager, Profiler profiler) {
        for (Map.Entry<Identifier, JsonElement> entry : loader.entrySet()) {
            DogData dogData = GSON.fromJson(entry.getValue(), DogData.class);
            dataMap.put(entry.getKey(), dogData);
        }
    }

    public DogData getDogData(Identifier id) {
        return dataMap.get(id);
    }
}
