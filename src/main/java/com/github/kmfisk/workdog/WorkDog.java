package com.github.kmfisk.workdog;

import com.github.kmfisk.workdog.block.WorkDogBlocks;
import com.github.kmfisk.workdog.client.color.ColorEvents;
import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.data.WorkDogRecipeProvider;
import com.github.kmfisk.workdog.entity.WorkDogEntities;
import com.github.kmfisk.workdog.inventory.WDContainerTypes;
import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(WorkDog.MOD_ID)
public class WorkDog {
    public static final String MOD_ID = "workdog";
    public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID + ".group") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.BONE);
        }
    };

    public WorkDog() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        WorkDogEntities.REGISTRAR.register(bus);
        WorkDogBlocks.REGISTRAR.register(bus);
        WorkDogItems.REGISTRAR.register(bus);
        WDContainerTypes.REGISTRAR.register(bus);

        bus.addListener(this::setup);
        bus.addListener(this::registerAttributes);
        bus.addListener(this::gatherData);

        bus.addListener(this::setupClient);

        if (FMLEnvironment.dist == Dist.CLIENT) bus.addListener(ColorEvents::registerColorHandlerBlocks);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, WorkDogConfig.CONFIG_SPEC);
    }

    private void setup(final FMLClientSetupEvent event) {
        WorkDogEntities.registerSpawnPlacements();
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
