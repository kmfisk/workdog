package com.github.kmfisk.workdog.world;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod.EventBusSubscriber(modid = WorkDog.MOD_ID)
public class WorkDogSpawns {
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_REGISTRAR = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, WorkDog.MOD_ID);
    private static final RegistryObject<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZER = RegistryObject.create(new ResourceLocation(WorkDog.MOD_ID, "biome_spawn_serializer"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, WorkDog.MOD_ID);

    public record WorkDogBiomeModifier(MobSpawnSettings.SpawnerData wolfSpawner, MobSpawnSettings.SpawnerData gsSpawner,
                                       MobSpawnSettings.SpawnerData jrtSpawner) implements BiomeModifier {
        @Override
        public void modify(Holder<Biome> holder, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
            if (phase == Phase.ADD && holder.containsTag(BiomeTags.IS_OVERWORLD)) {
                if (holder.containsTag(BiomeTags.IS_FOREST) && !holder.containsTag(Tags.Biomes.IS_WET) && !holder.containsTag(BiomeTags.IS_JUNGLE) && !holder.containsTag(BiomeTags.IS_HILL) && !holder.containsTag(Tags.Biomes.IS_MOUNTAIN)) {
                    builder.getMobSpawnSettings().addSpawn(wolfSpawner.type.getCategory(), wolfSpawner);
                }

                if (WorkDogConfig.straySpawns.get()) {
                    if (holder.containsTag(Tags.Biomes.IS_PLAINS) && !holder.containsTag(Tags.Biomes.IS_HOT) && !holder.containsTag(Tags.Biomes.IS_COLD)) {
                        builder.getMobSpawnSettings().addSpawn(gsSpawner.type.getCategory(), gsSpawner);
                    }

                    if (holder.containsTag(Tags.Biomes.IS_SWAMP)) {
                        builder.getMobSpawnSettings().addSpawn(jrtSpawner.type.getCategory(), jrtSpawner);
                    }
                }

            } else if (phase == Phase.REMOVE) {
                List<MobSpawnSettings.SpawnerData> spawns = builder.getMobSpawnSettings().getSpawner(MobCategory.CREATURE);
                spawns.removeIf(WorkDogBiomeModifier::shouldRemove);
            }
        }

        @Override
        public Codec<? extends BiomeModifier> codec() {
            return BIOME_MODIFIER_SERIALIZER.get();
        }

        private static boolean shouldRemove(MobSpawnSettings.SpawnerData spawner) {
            return WorkDogConfig.removeVanillaWolves.get() && spawner.type == EntityType.WOLF;
        }
    }

    public static void registerBiomeModifiers() {
        Codec<WorkDogBiomeModifier> codec = RecordCodecBuilder.create(builder -> builder.group(
                MobSpawnSettings.SpawnerData.CODEC.fieldOf("wolf_spawner").forGetter(WorkDogBiomeModifier::wolfSpawner),
                MobSpawnSettings.SpawnerData.CODEC.fieldOf("german_shepherd_spawner").forGetter(WorkDogBiomeModifier::gsSpawner),
                MobSpawnSettings.SpawnerData.CODEC.fieldOf("jack_russell_terrier_spawner").forGetter(WorkDogBiomeModifier::jrtSpawner)
        ).apply(builder, WorkDogBiomeModifier::new));
        BIOME_REGISTRAR.register("spawner", () -> codec);
    }
}
