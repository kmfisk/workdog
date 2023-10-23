package com.github.kmfisk.workdog.inventory;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.client.gui.WorkDogScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WDContainerTypes {
    public static final DeferredRegister<ContainerType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.CONTAINERS, WorkDog.MOD_ID);

    public static final RegistryObject<ContainerType<WorkDogContainer>> WORK_DOG_CONTAINER = REGISTRAR.register("work_dog_container", () -> new ContainerType<>(WorkDogContainer::new));

    @OnlyIn(Dist.CLIENT)
    public static void registerFactories() {
        ScreenManager.register(WORK_DOG_CONTAINER.get(), WorkDogScreen::new);
    }
}
