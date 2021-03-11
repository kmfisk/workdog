package com.github.kmfisk.workdog;

import com.github.kmfisk.workdog.entity.BorderCollieEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.github.kmfisk.workdog.init.ModEntities.BORDER_COLLIE;

public class WorkingDogs implements ModInitializer {
	public static final String MOD_ID = "workdog";
	public static final Logger LOGGER = LogManager.getLogger();

	public static final ItemGroup GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "tab"),
			() -> new ItemStack(Items.BONE));

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(BORDER_COLLIE, BorderCollieEntity.createDogAttributes());
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "border_collie_spawn_egg"), new SpawnEggItem(BORDER_COLLIE, 0x0DA70B, 0x73420E, new Item.Settings().group(GROUP)));
	}
}
