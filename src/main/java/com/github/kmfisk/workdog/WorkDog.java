package com.github.kmfisk.workdog;

import com.github.kmfisk.workdog.block.WorkDogBlocks;
import com.github.kmfisk.workdog.client.color.ColorEvents;
import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.data.WorkDogRecipeProvider;
import com.github.kmfisk.workdog.entity.WorkDogEntities;
import com.github.kmfisk.workdog.entity.merchant.villager.WorkDogVillagerTrades;
import com.github.kmfisk.workdog.entity.merchant.villager.WorkDogVillagers;
import com.github.kmfisk.workdog.inventory.WDContainerTypes;
import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(WorkDog.MOD_ID)
public class WorkDog {
    public static final String MOD_ID = "workdog";
    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(MOD_ID + ".group") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(WorkDogItems.CRATE.get());
        }
    };

    public WorkDog() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.addListener(WorkDogVillagerTrades::onVillagerTradesEvent);

        WorkDogEntities.REGISTRAR.register(bus);
        WorkDogBlocks.REGISTRAR.register(bus);
        WorkDogItems.REGISTRAR.register(bus);
        WDContainerTypes.REGISTRAR.register(bus);
        WorkDogVillagers.POI_TYPES.register(bus);
        WorkDogVillagers.PROFESSIONS.register(bus);

        bus.addListener(this::setup);
        bus.addListener(this::registerAttributes);
        bus.addListener(this::gatherData);

        bus.addListener(this::setupClient);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            bus.addListener(ColorEvents::registerColorHandlerBlocks);
            bus.addListener(ColorEvents::registerColorHandlerItems);
        }

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, WorkDogConfig.CONFIG_SPEC);
    }

    private void setup(final FMLCommonSetupEvent event) {
        WorkDogEntities.registerSpawnPlacements();
        event.enqueueWork(WorkDogVillagers::registerTrades);
    }

    private void setupClient(final FMLClientSetupEvent event) {
        WorkDogEntities.registerRenderers();
        WorkDogBlocks.setRenderLayers();
        WDContainerTypes.registerFactories();
    }

    private void registerAttributes(final EntityAttributeCreationEvent event) {
        WorkDogEntities.registerAttributes((type, builder) -> event.put(type, builder.build()));
    }

    private void gatherData(final GatherDataEvent event) {
        System.out.println("Generating workdog Data!");
        DataGenerator dataGenerator = event.getGenerator();
        if (event.includeServer()) dataGenerator.addProvider(new WorkDogRecipeProvider(dataGenerator));
    }
}
