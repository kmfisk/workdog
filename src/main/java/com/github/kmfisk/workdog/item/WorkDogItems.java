package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.WorkDog;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WorkDogItems {
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, WorkDog.MOD_ID);

    public static final RegistryObject<Item> CRATE = REGISTRAR.register("crate", () -> new CrateItem(new Item.Properties().stacksTo(1).tab(WorkDog.ITEM_GROUP)));

    public static final RegistryObject<Item> PINK_JUICE = REGISTRAR.register("pink_juice", () -> new PinkJuiceItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> STERILIZATION_POTION = REGISTRAR.register("sterilization_potion", () -> new SterilizationPotionItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
    public static final RegistryObject<Item> SURRENDER_FORM = REGISTRAR.register("surrender_form", () -> new SurrenderFormItem(new Item.Properties().tab(WorkDog.ITEM_GROUP)));
}
