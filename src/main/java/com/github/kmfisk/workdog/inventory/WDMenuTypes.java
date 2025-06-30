package com.github.kmfisk.workdog.inventory;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.gui.WorkDogScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WDMenuTypes {
    public static final DeferredRegister<MenuType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.MENU_TYPES, WorkDog.MOD_ID);

    public static final RegistryObject<MenuType<WorkDogInventoryMenu>> WORK_DOG_CONTAINER = REGISTRAR.register("work_dog_container", () -> new MenuType<>(WorkDogInventoryMenu::new, FeatureFlags.DEFAULT_FLAGS));

    @OnlyIn(Dist.CLIENT)
    public static void registerFactories() {
        MenuScreens.register(WORK_DOG_CONTAINER.get(), WorkDogScreen::new);
    }
}
