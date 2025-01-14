package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.WorkDog;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.Util;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class WorkDogItems {
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, WorkDog.MOD_ID);

    public static final Map<EntityType<?>, RegistryObject<Item>> SPAWN_EGGS = new HashMap<>();

    public static final RegistryObject<Item> CRATE = REGISTRAR.register("crate", () -> new CrateItem(new Item.Properties().stacksTo(1).tab(WorkDog.ITEM_GROUP)));

    public static final RegistryObject<Item> PINK_JUICE = REGISTRAR.register("pink_juice", () -> new PinkJuiceItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> STERILIZATION_POTION = REGISTRAR.register("sterilization_potion", () -> new SterilizationPotionItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> SURRENDER_FORM = REGISTRAR.register("surrender_form", () -> new SurrenderFormItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));

    public static final RegistryObject<Item> FRISBEE = REGISTRAR.register("frisbee", () -> new Item(new Item.Properties().tab(WorkDog.ITEM_GROUP)));

    public static final RegistryObject<Item> COLLAR = REGISTRAR.register("collar", () -> new DyeableDogEquipmentItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> HARNESS = REGISTRAR.register("harness", () -> new DyeableDogEquipmentItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> HOG_VEST = REGISTRAR.register("hog_vest", () -> new DyeableDogEquipmentItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> MUZZLE = REGISTRAR.register("muzzle", () -> new DyeableDogEquipmentItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> SADDLEBAG = REGISTRAR.register("saddlebag", () -> new DyeableDogEquipmentItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final Map<String, RegistryObject<Item>> SERVICE_VESTS = Util.make(new HashMap<>(), list -> {
        for (int i = 0; i < DyeColor.values().length; i++) {
            DyeColor color = DyeColor.byId(i);
            list.put(color.getName(), REGISTRAR.register(color.getName() + "_service_vest", () -> new Item(new Item.Properties().tab(WorkDog.ITEM_GROUP))));
        }
    });
}
