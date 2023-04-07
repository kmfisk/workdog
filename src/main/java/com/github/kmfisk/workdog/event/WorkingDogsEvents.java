package com.github.kmfisk.workdog.event;

import com.github.kmfisk.workdog.WorkingDogs;
import com.github.kmfisk.workdog.config.WorkingDogsConfig;
import com.github.kmfisk.workdog.entity.WorkDogEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

@Mod.EventBusSubscriber(modid = WorkingDogs.MOD_ID)
public class WorkingDogsEvents {
    @SubscribeEvent
    public static void joinWorldEvent(EntityJoinWorldEvent event) {
        if (!event.getWorld().isClientSide) {
            if (event.getEntity().getClass() == WolfEntity.class && WorkingDogsConfig.removeVanillaWolves.get()) {
                LivingEntity entity = (LivingEntity) event.getEntity();
                if (!entity.getPersistentData().contains("WorkDogsSpawn")) {
                    entity.getPersistentData().putBoolean("WorkDogsSpawn", true);
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void biomeLoad(final BiomeLoadingEvent event) {
        MobSpawnInfo.Spawners wolfSpawner = new MobSpawnInfo.Spawners(WorkDogEntities.WOLF, WorkingDogsConfig.wolfSpawnChance.get(), WorkingDogsConfig.wolfMinGroup.get(), WorkingDogsConfig.wolfMaxGroup.get());
        Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(RegistryKey.create(Registry.BIOME_REGISTRY, event.getName()));
        if (biomeTypes.contains(BiomeDictionary.Type.OVERWORLD)) {
            if (biomeTypes.contains(BiomeDictionary.Type.FOREST)
                    && !biomeTypes.contains(BiomeDictionary.Type.WET) && !biomeTypes.contains(BiomeDictionary.Type.JUNGLE)
                    && !biomeTypes.contains(BiomeDictionary.Type.HILLS) && !biomeTypes.contains(BiomeDictionary.Type.MOUNTAIN)) {
                event.getSpawns().getSpawner(EntityClassification.CREATURE).add(wolfSpawner);
            }
        }
    }
}
