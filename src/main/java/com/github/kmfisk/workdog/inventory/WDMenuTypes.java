package com.github.kmfisk.workdog.inventory;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.gui.WorkDogContainerScreen;
import com.github.kmfisk.workdog.client.gui.WorkDogUnownedContainerScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WDMenuTypes {
    public static final DeferredRegister<MenuType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.MENU_TYPES, WorkDog.MOD_ID);

    public static final RegistryObject<MenuType<WorkDogContainerMenu>> WORK_DOG_CONTAINER = REGISTRAR.register("work_dog_container", () -> new MenuType<>(WorkDogContainerMenu::new, FeatureFlags.DEFAULT_FLAGS));
    public static final RegistryObject<MenuType<WorkDogUnownedContainerMenu>> WORK_DOG_UNOWNED_CONTAINER = REGISTRAR.register("work_dog_unowned_container", () -> new MenuType<>(WorkDogUnownedContainerMenu::new, FeatureFlags.DEFAULT_FLAGS));

    @OnlyIn(Dist.CLIENT)
    public static void registerFactories() {
        MenuScreens.register(WORK_DOG_CONTAINER.get(), WorkDogContainerScreen::new);
        MenuScreens.register(WORK_DOG_UNOWNED_CONTAINER.get(), WorkDogUnownedContainerScreen::new);
    }
}
