package com.github.kmfisk.workdog;

import com.github.kmfisk.workdog.entity.WorkDogEntities;
import com.github.kmfisk.workdog.item.WorkDogItems;
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

@Mod(WorkingDogs.MOD_ID)
public class WorkingDogs {
	public static final String MOD_ID = "workdog";
	public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID + ".tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.BONE);
		}
	};

	public WorkingDogs() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		WorkDogEntities.REGISTRAR.register(modBus);
		WorkDogItems.REGISTRAR.register(modBus);

		modBus.addListener(this::registerAttributes);

		if (FMLEnvironment.dist == Dist.CLIENT)
			modBus.addListener(this::setupClient);
	}

	private void setupClient(final FMLClientSetupEvent event) {
		WorkDogEntities.registerRenderers();
	}

	private void registerAttributes(final EntityAttributeCreationEvent event) {
		WorkDogEntities.registerAttributes((type, builder) -> event.put(type, builder.build()));
	}
}
