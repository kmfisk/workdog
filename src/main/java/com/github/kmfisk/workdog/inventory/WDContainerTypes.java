package com.github.kmfisk.workdog.inventory;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.gui.WorkDogScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WDContainerTypes {
    public static final DeferredRegister<MenuType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.CONTAINERS, WorkDog.MOD_ID);

    public static final RegistryObject<MenuType<WorkDogContainer>> WORK_DOG_CONTAINER = REGISTRAR.register("work_dog_container", () -> new MenuType<>(WorkDogContainer::new));

    @OnlyIn(Dist.CLIENT)
    public static void registerFactories() {
        MenuScreens.register(WORK_DOG_CONTAINER.get(), WorkDogScreen::new);
    }
}
