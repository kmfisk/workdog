package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import net.minecraft.Util;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class WorkDogItems {
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, WorkDog.MOD_ID);

    public static final RegistryObject<Item> CRATE = REGISTRAR.register("crate", () -> new CrateItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PINK_JUICE = REGISTRAR.register("pink_juice", () -> new PinkJuiceItem(new Item.Properties()));
    public static final RegistryObject<Item> STERILIZATION_POTION = REGISTRAR.register("sterilization_potion", () -> new SterilizationPotionItem(new Item.Properties()));
    public static final RegistryObject<Item> SURRENDER_FORM = REGISTRAR.register("surrender_form", () -> new SurrenderFormItem(new Item.Properties()));

    public static final RegistryObject<Item> FRISBEE = REGISTRAR.register("frisbee", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COLLAR = REGISTRAR.register("collar", () -> new DyeableDogEquipmentItem(new Item.Properties(), AbstractInventoryAnimal.DogEquipmentType.COLLAR));
    public static final RegistryObject<Item> HARNESS = REGISTRAR.register("harness", () -> new DyeableDogEquipmentItem(new Item.Properties(), AbstractInventoryAnimal.DogEquipmentType.HARNESS));
    public static final RegistryObject<Item> HOG_VEST = REGISTRAR.register("hog_vest", () -> new DyeableDogEquipmentItem(new Item.Properties(), AbstractInventoryAnimal.DogEquipmentType.VEST));
    public static final RegistryObject<Item> MUZZLE = REGISTRAR.register("muzzle", () -> new DyeableDogEquipmentItem(new Item.Properties(), AbstractInventoryAnimal.DogEquipmentType.MUZZLE));
    public static final RegistryObject<Item> SADDLEBAG = REGISTRAR.register("saddlebag", () -> new SaddlebagItem(new Item.Properties()));
    public static final Map<DyeColor, RegistryObject<Item>> SERVICE_VESTS = Util.make(new HashMap<>(), list -> {
        for (int i = 0; i < DyeColor.values().length; i++) {
            DyeColor color = DyeColor.byId(i);
            list.put(color, REGISTRAR.register(color.getName() + "_service_vest", () -> new ServiceVestItem(new Item.Properties(), color)));
        }
    });
}
