package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.WorkDog;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.Util;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class WorkDogItems {
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, WorkDog.MOD_ID);

    public static final RegistryObject<Item> CRATE = REGISTRAR.register("crate", () -> new CrateItem(new Item.Properties().stacksTo(1).tab(WorkDog.ITEM_GROUP)));

    public static final RegistryObject<Item> PINK_JUICE = REGISTRAR.register("pink_juice", () -> new PinkJuiceItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> STERILIZATION_POTION = REGISTRAR.register("sterilization_potion", () -> new SterilizationPotionItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> SURRENDER_FORM = REGISTRAR.register("surrender_form", () -> new SurrenderFormItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));

    public static final RegistryObject<Item> FRISBEE = REGISTRAR.register("frisbee", () -> new Item(new Item.Properties().tab(WorkDog.ITEM_GROUP)));

    public static final RegistryObject<Item> COLLAR = REGISTRAR.register("collar", () -> new Item(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> HARNESS = REGISTRAR.register("harness", () -> new Item(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> HOG_VEST = REGISTRAR.register("hog_vest", () -> new Item(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> MUZZLE = REGISTRAR.register("muzzle", () -> new Item(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> SADDLEBAG = REGISTRAR.register("saddlebag", () -> new Item(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final List<RegistryObject<Item>> SERVICE_VESTS = Util.make(new ArrayList<>(), list -> {
        for (int i = 0; i < 16; i++) {
            DyeColor color = DyeColor.byId(i);
            list.add(REGISTRAR.register(color.getName() + "_service_vest", () -> new Item(new Item.Properties().tab(WorkDog.ITEM_GROUP))));
        }
    });
}
