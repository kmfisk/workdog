package com.github.kmfisk.workdog;

import com.github.kmfisk.workdog.block.WorkDogBlocks;
import com.github.kmfisk.workdog.client.color.ColorEvents;
import com.github.kmfisk.workdog.entity.WorkDogEntities;
import com.github.kmfisk.workdog.item.WorkDogItems;
import com.github.kmfisk.workdog.tags.WorkDogTags;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(WorkDog.MOD_ID)
public class WorkDog {
    public static final String MOD_ID = "workdog";
    public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID + ".tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.BONE);
        }
    };

    public WorkDog() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        WorkDogTags.init();

        WorkDogEntities.REGISTRAR.register(modBus);
        WorkDogItems.REGISTRAR.register(modBus);
        WorkDogBlocks.REGISTRAR.register(modBus);

        modBus.addListener(this::registerAttributes);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            modBus.addListener(this::setupClient);
            modBus.addListener(ColorEvents::registerColorHandlerBlocks);
        }
    }

    private void setupClient(final FMLClientSetupEvent event) {
        WorkDogEntities.registerRenderers();
        WorkDogBlocks.setRenderLayers();
    }

    private void registerAttributes(final EntityAttributeCreationEvent event) {
        WorkDogEntities.registerAttributes((type, builder) -> event.put(type, builder.build()));
    }
}
