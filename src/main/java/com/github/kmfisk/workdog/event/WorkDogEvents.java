package com.github.kmfisk.workdog.event;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.WorkDogEntities;
import com.github.kmfisk.workdog.entity.core.HuntingDogEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LootingLevelEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

@Mod.EventBusSubscriber(modid = WorkDog.MOD_ID)
public class WorkDogEvents {
    @SubscribeEvent
    public static void joinWorldEvent(EntityJoinWorldEvent event) {
        if (!event.getWorld().isClientSide) {
            if (event.getEntity().getClass() == WolfEntity.class && WorkDogConfig.removeVanillaWolves.get()) {
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
        MobSpawnInfo.Spawners wolfSpawner = new MobSpawnInfo.Spawners(WorkDogEntities.WOLF, WorkDogConfig.wolfSpawnChance.get(), WorkDogConfig.wolfMinGroup.get(), WorkDogConfig.wolfMaxGroup.get());
        Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(RegistryKey.create(Registry.BIOME_REGISTRY, event.getName()));
        if (biomeTypes.contains(BiomeDictionary.Type.OVERWORLD)) {
            if (biomeTypes.contains(BiomeDictionary.Type.FOREST)
                    && !biomeTypes.contains(BiomeDictionary.Type.WET) && !biomeTypes.contains(BiomeDictionary.Type.JUNGLE)
                    && !biomeTypes.contains(BiomeDictionary.Type.HILLS) && !biomeTypes.contains(BiomeDictionary.Type.MOUNTAIN)) {
                event.getSpawns().getSpawner(EntityClassification.CREATURE).add(wolfSpawner);
            }

            if (biomeTypes.contains(BiomeDictionary.Type.PLAINS) && !biomeTypes.contains(BiomeDictionary.Type.HOT) && !biomeTypes.contains(BiomeDictionary.Type.COLD)) {
                event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(WorkDogEntities.GERMAN_SHEPHERD, 2, 1, 1));
            }

            if (biomeTypes.contains(BiomeDictionary.Type.SWAMP)) {
                event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(WorkDogEntities.JACK_RUSSELL_TERRIER, 2, 1, 1));
            }
        }
    }

    @SubscribeEvent
    public static void lootingLevelEvent(LootingLevelEvent event) {
        HuntingDogEntity.lootingLevelEvent(event);
    }
}
