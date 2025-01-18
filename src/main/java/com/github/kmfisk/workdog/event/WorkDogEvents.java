package com.github.kmfisk.workdog.event;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.core.HuntingDogEntity;
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
import net.minecraftforge.event.entity.living.LootingLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod.EventBusSubscriber(modid = WorkDog.MOD_ID)
public class WorkDogEvents {
    @SubscribeEvent
    public static void lootingLevelEvent(LootingLevelEvent event) {
        HuntingDogEntity.lootingLevelEvent(event);
    }
}
