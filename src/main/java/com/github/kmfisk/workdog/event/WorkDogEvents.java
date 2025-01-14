package com.github.kmfisk.workdog.event;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.WorkDogEntities;
import com.github.kmfisk.workdog.entity.core.HuntingDogEntity;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.biome.MobSpawnSettings;
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
            if (event.getEntity().getClass() == Wolf.class && WorkDogConfig.removeVanillaWolves.get()) {
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
        MobSpawnSettings.SpawnerData wolfSpawner = new MobSpawnSettings.SpawnerData(WorkDogEntities.WOLF.get(), WorkDogConfig.wolfSpawnChance.get(), WorkDogConfig.wolfMinGroup.get(), WorkDogConfig.wolfMaxGroup.get());
        Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(ResourceKey.create(Registry.BIOME_REGISTRY, event.getName()));
        if (biomeTypes.contains(BiomeDictionary.Type.OVERWORLD)) {
            if (biomeTypes.contains(BiomeDictionary.Type.FOREST) && !biomeTypes.contains(BiomeDictionary.Type.WET) && !biomeTypes.contains(BiomeDictionary.Type.JUNGLE) && !biomeTypes.contains(BiomeDictionary.Type.HILLS) && !biomeTypes.contains(BiomeDictionary.Type.MOUNTAIN)) {
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(wolfSpawner);
            }

            if (biomeTypes.contains(BiomeDictionary.Type.PLAINS) && !biomeTypes.contains(BiomeDictionary.Type.HOT) && !biomeTypes.contains(BiomeDictionary.Type.COLD)) {
                if (WorkDogConfig.straySpawns.get()) {
                    event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(WorkDogEntities.GERMAN_SHEPHERD.get(), WorkDogConfig.straySpawnChance.get(), 1, 1));
                }
            }

            if (biomeTypes.contains(BiomeDictionary.Type.SWAMP)) {
                if (WorkDogConfig.straySpawns.get()) {
                    event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(WorkDogEntities.JACK_RUSSELL_TERRIER.get(), WorkDogConfig.straySpawnChance.get(), 1, 1));
                }
            }
        }
    }

    @SubscribeEvent
    public static void lootingLevelEvent(LootingLevelEvent event) {
        HuntingDogEntity.lootingLevelEvent(event);
    }
}
