package com.github.kmfisk.workdog.util;

import com.github.kmfisk.workdog.WorkingDogs;
import com.github.kmfisk.workdog.entity.core.DogData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.EntityType;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class DogDataManager extends JsonDataLoader {
    public static final DogDataManager INSTANCE = new DogDataManager();
    private static final Gson GSON = new Gson();
    public static MinecraftServer server;
    public Map<EntityType<?>, DogData> dataMap = new HashMap<>();

    public DogDataManager() {
        super(GSON, "breeds");
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> loader, ResourceManager manager, Profiler profiler) {
        dataMap.clear();
        for (Map.Entry<Identifier, JsonElement> entry : loader.entrySet()) {
            DogData dogData = GSON.fromJson(entry.getValue(), DogData.class);
            dataMap.put(Registry.ENTITY_TYPE.get(entry.getKey()), dogData);
        }
        PacketByteBuf buf = PacketByteBufs.create();
        writeDogData(buf);
        for (ServerPlayerEntity player : PlayerLookup.all(server)) {
            ServerPlayNetworking.send(player, WorkingDogs.DATA_SYNC, buf);
        }
    }

    public static void writeDogData(PacketByteBuf buf) {
        Map<EntityType<?>, DogData> dataMap = INSTANCE.dataMap;
        buf.writeVarInt(dataMap.size());
        for (Map.Entry<EntityType<?>, DogData> dataEntry : dataMap.entrySet()) {
            buf.writeVarInt(Registry.ENTITY_TYPE.getRawId(dataEntry.getKey()));
            DogData dogData = dataEntry.getValue();
            buf.writeVarInt(dogData.maxHealth);
            buf.writeVarInt(dogData.coats);
            dogData.huntingSkill.write(buf);
            dogData.gaminess.write(buf);
            dogData.aggression.write(buf);
            dogData.wariness.write(buf);
            dogData.voice.write(buf);
            dogData.courage.write(buf);
            dogData.playfulness.write(buf);
            dogData.speed.write(buf);
            dogData.damage.write(buf);
            buf.writeVarInt(dogData.genetics.length);
            for (int[] i : dogData.genetics) {
                buf.writeVarInt(i.length);
                for (int j : i) {
                    buf.writeVarInt(j);
                }
            }
        }
    }

    public DogData getDogData(EntityType<?> type) {
        return dataMap.get(type);
    }
}
