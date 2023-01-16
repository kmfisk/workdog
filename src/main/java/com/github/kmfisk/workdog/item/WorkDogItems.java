package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.WorkingDogs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WorkDogItems {
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, WorkingDogs.MOD_ID);

    public static final RegistryObject<Item> PINK_JUICE = REGISTRAR.register("pink_juice", () -> new PinkJuiceItem(new Item.Properties().tab(WorkingDogs.ITEM_GROUP)));
    public static final RegistryObject<Item> STERILIZATION_POTION = REGISTRAR.register("sterilization_potion", () -> new SterilizationPotionItem(new Item.Properties().tab(WorkingDogs.ITEM_GROUP)));
}
