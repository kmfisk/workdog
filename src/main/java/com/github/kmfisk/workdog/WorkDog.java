package com.github.kmfisk.workdog;

import com.github.kmfisk.workdog.block.WorkDogBlocks;
import com.github.kmfisk.workdog.client.color.ColorEvents;
import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.data.WDAdvancementProvider;
import com.github.kmfisk.workdog.data.WDBlockLoot;
import com.github.kmfisk.workdog.data.WDTagsProviders;
import com.github.kmfisk.workdog.data.WorkDogRecipeProvider;
import com.github.kmfisk.workdog.entity.WorkDogEntities;
import com.github.kmfisk.workdog.entity.merchant.villager.WorkDogVillagerTrades;
import com.github.kmfisk.workdog.entity.merchant.villager.WorkDogVillagers;
import com.github.kmfisk.workdog.inventory.WDMenuTypes;
import com.github.kmfisk.workdog.item.WorkDogItems;
import com.github.kmfisk.workdog.network.WorkDogChannel;
import com.github.kmfisk.workdog.sounds.WorkDogSounds;
import com.github.kmfisk.workdog.world.WorkDogSpawns;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collections;
import java.util.List;

@Mod(WorkDog.MOD_ID)
public class WorkDog {
    public static final String MOD_ID = "workdog";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WorkDog.MOD_ID);
    public static final RegistryObject<CreativeModeTab> ITEM_GROUP = CREATIVE_MODE_TAB.register(MOD_ID + ".group", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup." + MOD_ID + ".group"))
            .icon(() -> WorkDogItems.CRATE.get().getDefaultInstance())
            .displayItems((itemDisplayParameters, output) -> WorkDogItems.REGISTRAR.getEntries().forEach(item -> output.accept(item.get())))
            .build());

    private static Entity referencedMob = null;
    public static Entity getReferencedMob() {
        return referencedMob;
    }
    public static void setReferencedMob(Entity entity) {
        referencedMob = entity;
    }

    public WorkDog() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.addListener(WorkDogVillagerTrades::onVillagerTradesEvent);

        WorkDogEntities.REGISTRAR.register(bus);
        WorkDogBlocks.REGISTRAR.register(bus);
        WorkDogItems.REGISTRAR.register(bus);
        CREATIVE_MODE_TAB.register(bus);
        WorkDogSounds.REGISTRAR.register(bus);
        WDMenuTypes.REGISTRAR.register(bus);
        WorkDogVillagers.POI_TYPES.register(bus);
        WorkDogVillagers.PROFESSIONS.register(bus);

        bus.addListener(this::setup);
        bus.addListener(this::registerAttributes);
        bus.addListener(this::gatherData);

        bus.addListener(this::setupClient);

        WorkDogSpawns.registerBiomeModifiers();
        WorkDogSpawns.BIOME_REGISTRAR.register(bus);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            bus.addListener(this::registerLayerDefinitions);
            bus.addListener(ColorEvents::registerColorHandlerBlocks);
            bus.addListener(ColorEvents::registerColorHandlerItems);
        }

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, WorkDogConfig.CONFIG_SPEC);
    }

    private void setup(final FMLCommonSetupEvent event) {
        WorkDogChannel.register();
        WorkDogEntities.registerSpawnPlacements();
        event.enqueueWork(WorkDogVillagers::registerTrades);
    }

    private void setupClient(final FMLClientSetupEvent event) {
        WorkDogEntities.registerRenderers();
        WDMenuTypes.registerFactories();
    }

    @OnlyIn(Dist.CLIENT)
    private void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        WorkDogEntities.registerLayerDefinitions(event);
    }

    private void registerAttributes(final EntityAttributeCreationEvent event) {
        WorkDogEntities.registerAttributes((type, builder) -> event.put(type, builder.build()));
    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
//        dataGenerator.addProvider(event.includeClient(), new WDBlockModels(packOutput, event.getExistingFileHelper()));
//        dataGenerator.addProvider(event.includeClient(), new WDBlockStates(packOutput, event.getExistingFileHelper()));
//        dataGenerator.addProvider(event.includeClient(), new WDItemModels(packOutput, event.getExistingFileHelper()));

        WDTagsProviders.WDBlockTagsProvider blockTagsProvider = new WDTagsProviders.WDBlockTagsProvider(packOutput, event.getLookupProvider(), event.getExistingFileHelper());
        dataGenerator.addProvider(event.includeServer(), blockTagsProvider);
        dataGenerator.addProvider(event.includeServer(), new WDTagsProviders.WDItemTagsProvider(packOutput, event.getLookupProvider(), blockTagsProvider, event.getExistingFileHelper()));
        dataGenerator.addProvider(event.includeServer(), new WDTagsProviders.WDPoiTypeTagsProvider(packOutput, event.getLookupProvider(), event.getExistingFileHelper()));
        dataGenerator.addProvider(event.includeServer(), new WDTagsProviders.WDEntityTypeTagsProvider(packOutput, event.getLookupProvider(), event.getExistingFileHelper()));
        dataGenerator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(WDBlockLoot::new, LootContextParamSets.BLOCK))));
        dataGenerator.addProvider(event.includeServer(), new WorkDogRecipeProvider(packOutput));
        dataGenerator.addProvider(event.includeServer(), new WDAdvancementProvider(packOutput, event.getLookupProvider(), event.getExistingFileHelper()));
    }
}
