package com.github.kmfisk.workdog;

import com.github.kmfisk.workdog.client.render.entity.BorderCollieRenderer;
import com.github.kmfisk.workdog.entity.core.DogData;
import com.github.kmfisk.workdog.util.DogDataManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

import static com.github.kmfisk.workdog.WorkingDogs.DATA_SYNC;
import static com.github.kmfisk.workdog.entity.ModEntities.BORDER_COLLIE;

@Environment(EnvType.CLIENT)
public class WorkingDogsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(BORDER_COLLIE, ((entityRenderDispatcher, context) -> new BorderCollieRenderer(entityRenderDispatcher)));
        ClientPlayNetworking.registerGlobalReceiver(DATA_SYNC, (client, handler, buf, responseSender) -> {
            Map<EntityType<?>, DogData> dogDataMap = new HashMap<>();
            for (int i = 0; i < buf.readVarInt(); i++) {
                EntityType<?> entityType = Registry.ENTITY_TYPE.get(buf.readVarInt());
                DogData dogData = new DogData();
                dogData.maxHealth = buf.readVarInt();
                dogData.coats = buf.readVarInt();
                dogData.huntingSkill = DogData.IntRange.read(buf);
                dogData.gaminess = DogData.IntRange.read(buf);
                dogData.aggression = DogData.IntRange.read(buf);
                dogData.wariness = DogData.IntRange.read(buf);
                dogData.voice = DogData.IntRange.read(buf);
                dogData.courage = DogData.IntRange.read(buf);
                dogData.playfulness = DogData.IntRange.read(buf);
                dogData.speed = DogData.FloatRange.read(buf);
                dogData.damage = DogData.IntRange.read(buf);
                int size = buf.readVarInt();
                dogData.genetics = new int[size][];
                for (int j = 0; j < size; j++) {
                    int carriesSize = buf.readVarInt();
                    dogData.genetics[j] = new int[carriesSize];
                    for (int k = 0; k < carriesSize; k++) {
                        dogData.genetics[j][k] = buf.readVarInt();
                    }
                }
                dogDataMap.put(entityType, dogData);
            }
            client.execute(() -> DogDataManager.INSTANCE.dataMap = dogDataMap);
        });
    }
}
