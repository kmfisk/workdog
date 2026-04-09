package com.github.kmfisk.workdog.sounds;

import com.github.kmfisk.workdog.WorkDog;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WorkDogSounds {
    public static final DeferredRegister<SoundEvent> REGISTRAR = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WorkDog.MOD_ID);

    public static RegistryObject<SoundEvent> CALL_WHISTLE = registerSound("call_whistle");
    public static RegistryObject<SoundEvent> GO_HERE_1 = registerSound("go_here_1");
    public static RegistryObject<SoundEvent> GO_HERE_2 = registerSound("go_here_2");
    public static RegistryObject<SoundEvent> LARGE_ATTACK = registerSound("large_attack");
    public static RegistryObject<SoundEvent> LARGE_GROWL = registerSound("large_growl");
    public static RegistryObject<SoundEvent> LARGE_HURT = registerSound("large_hurt");
//    public static RegistryObject<SoundEvent> NAME = registerSound("name");
    public static RegistryObject<SoundEvent> LARGE_IDLE = registerSound("large_idle");
    public static RegistryObject<SoundEvent> LARGE_WARNING = registerSound("large_warning");
    public static RegistryObject<SoundEvent> MEDIUM_HAPPY = registerSound("medium_happy");
    public static RegistryObject<SoundEvent> MEDIUM_HURT = registerSound("medium_hurt");
//    public static RegistryObject<SoundEvent> NAME = registerSound("name");
    public static RegistryObject<SoundEvent> MEDIUM_IDLE = registerSound("medium_idle");
//    public static RegistryObject<SoundEvent> NAME = registerSound("name");
    public static RegistryObject<SoundEvent> MEDIUM_WARNING = registerSound("medium_warning");
    public static RegistryObject<SoundEvent> PUPPY_IDLE = registerSound("puppy_idle");
    public static RegistryObject<SoundEvent> SMALL_GROWL = registerSound("small_growl");
    public static RegistryObject<SoundEvent> SMALL_HURT = registerSound("small_hurt");
//    public static RegistryObject<SoundEvent> NAME = registerSound("name");
    public static RegistryObject<SoundEvent> TOY_GROWL = registerSound("toy_growl");
    public static RegistryObject<SoundEvent> TOY_HAPPY = registerSound("toy_happy");
    public static RegistryObject<SoundEvent> TOY_WARNING = registerSound("toy_warning");

    private static RegistryObject<SoundEvent> registerSound(String name) {
        return REGISTRAR.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(WorkDog.MOD_ID, name)));
    }
}
