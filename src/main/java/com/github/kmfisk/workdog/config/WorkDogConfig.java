package com.github.kmfisk.workdog.config;

import com.github.kmfisk.workdog.WorkDog;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class WorkDogConfig {
    public static final ForgeConfigSpec CONFIG_SPEC;
    private static final String PREFIX = "config." + WorkDog.MOD_ID;
    public static ForgeConfigSpec.BooleanValue pedigreeMode;
    public static ForgeConfigSpec.BooleanValue removeVanillaWolves;
    //    public static ForgeConfigSpec.ConfigValue<Double> wanderAreaLimit;
    public static ForgeConfigSpec.ConfigValue<Integer> tamedLimit;
    public static ForgeConfigSpec.ConfigValue<Integer> breedingLimit;
    public static ForgeConfigSpec.BooleanValue nameBabies;
    public static ForgeConfigSpec.BooleanValue straySpawns;
    public static ForgeConfigSpec.ConfigValue<Integer> puppyMatureTimer;
    public static ForgeConfigSpec.ConfigValue<Integer> pregnancyTimer;
    public static ForgeConfigSpec.ConfigValue<Integer> heatTimer;
    public static ForgeConfigSpec.ConfigValue<Integer> heatCooldown;
    public static ForgeConfigSpec.ConfigValue<Integer> male_cooldown;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> wolfPreyList;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> herderLivestockList;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupConfig(configBuilder);
        CONFIG_SPEC = configBuilder.build();
    }

    private static void setupConfig(ForgeConfigSpec.Builder builder) {
        builder.push("Options");
        straySpawns = builder.define("enabled", true);
        pedigreeMode = builder.define("pedigree_mode", false);
        removeVanillaWolves = builder.define("remove_vanilla_wolves", true);
//        wanderAreaLimit = builder.worldRestart()
//                .comment(" When a dog's home point is set, this is the distance in blocks they will roam around it.",
//                        " Default: 200.0")
//                .translation(PREFIX + ".wander_area_limit")
//                .define("wander_area_limit", 200.0D);
        tamedLimit = builder
                .comment(" Sets a limit of dogs each player is allowed to have tamed, setting this to 0 will disable the limit.")
                .translation(PREFIX + ".tamed_limit")
                .define("tamed_limit", 0);
        breedingLimit = builder
                .comment(" This number is used to limit dog breeding; if more than this amount of dogs are nearby, automatic breeding will be disabled.",
                        " Default: 20")
                .translation(PREFIX + ".breeding_limit")
                .define("breeding_limit", 20);
        nameBabies = builder
                .comment(" Enable automatic naming for baby animals; this will give a placeholder name to the offspring of named animals.",
                        " Set this to true if you operate a server that has a lag clearing feature that wipes un-named entities!")
                .translation(PREFIX + ".name_babies")
                .define("name_babies", false);
        builder.pop();

        builder.push("Timers");
        puppyMatureTimer = builder
                .comment(" Number of minecraft ticks before a puppy becomes an adult.",
                        " Default: 72000 (3 full minecraft days)")
                .define("puppy_mature_timer", 24000 * 3);

        pregnancyTimer = builder
                .comment(" Number of minecraft ticks before a pregnant dog will give birth.",
                        " Default: 72000 (3 full minecraft days)")
                .define("pregnancy_timer", 24000 * 3);

        heatTimer = builder
                .comment(" Number of minecraft ticks that a dog will be in heat.",
                        " Default: 48000 (2 full minecraft days)")
                .define("heat_timer", 24000 * 2);

        heatCooldown = builder
                .comment(" Number of minecraft ticks that a dog will not go into heat.",
                        " Default: 72000 (3 full minecraft days)")
                .define("heat_cooldown", 24000 * 3);
        builder.pop();

        builder.push("Lists");
        wolfPreyList = builder.defineList("wolf_prey_list", Arrays.asList("minecraft:sheep", "minecraft:pig", "minecraft:rabbit",
                "minecraft:cat", "minecraft:chicken", "minecraft:cow", "minecraft:ocelot", "minecraft:parrot", "simplycats:cat",
                "hotchicks:chicken", "hotchicks:cow", "hotchicks:rabbit", "workdog:boston_terrier", "workdog:jack_russell_terrier"), entry -> true);
        herderLivestockList = builder.defineList("herder_livestock_list", Arrays.asList("minecraft:sheep",
                "minecraft:cow", "minecraft:pig", "minecraft:chicken", "minecraft:rabbit", "minecraft:llama",
                "minecraft:trader_llama", "hotchicks:cow", "hotchicks:chicken", "hotchicks:rabbit"), entry -> true);
        builder.pop();
    }
}
