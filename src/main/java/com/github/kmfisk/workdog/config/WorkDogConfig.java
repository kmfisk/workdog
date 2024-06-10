package com.github.kmfisk.workdog.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class WorkDogConfig {
    public static final ForgeConfigSpec CONFIG_SPEC;
    public static ForgeConfigSpec.BooleanValue pedigreeMode;
    public static ForgeConfigSpec.BooleanValue removeVanillaWolves;
    public static ForgeConfigSpec.ConfigValue<Integer> wolfSpawnChance;
    public static ForgeConfigSpec.ConfigValue<Integer> wolfMinGroup;
    public static ForgeConfigSpec.ConfigValue<Integer> wolfMaxGroup;
    public static ForgeConfigSpec.ConfigValue<Integer> pregnancyTimer;
    public static ForgeConfigSpec.ConfigValue<Integer> heatTimer;
    public static ForgeConfigSpec.ConfigValue<Integer> heatCooldown;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> wolfPreyList;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> herderLivestockList;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupConfig(configBuilder);
        CONFIG_SPEC = configBuilder.build();
    }

    private static void setupConfig(ForgeConfigSpec.Builder builder) {
        builder.push("Options");
        pedigreeMode = builder.define("pedigreeMode", false);
        removeVanillaWolves = builder.define("removeVanilla", true);
        builder.pop();

        builder.push("Spawns");
        builder.push("Wolves");
        wolfSpawnChance = builder.define("chance", 16);
        wolfMinGroup = builder.define("min", 1);
        wolfMaxGroup = builder.define("max", 5);
        builder.pop();
        builder.pop();

        builder.push("Timers");
//        kitten_mature_timer = builder
//                .comment(" Number of minecraft ticks before a kitten becomes an adult.",
//                        " Default: 168000 (7 full minecraft days)")
//                .define("kitten_mature_timer", 24000 * 7);

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

//        male_cooldown = builder
//                .comment(" Number of minecraft ticks that a male cat will not try to breed after breeding once already.",
//                        " Default: 6000 (1/4th minecraft day)")
//                .define("male_cooldown", 24000 / 4);
        builder.pop();

        builder.push("Lists");
        wolfPreyList = builder.defineList("wolfPreyList", Arrays.asList("minecraft:sheep", "minecraft:pig", "minecraft:rabbit",
                "minecraft:cat", "minecraft:parrot", "simplycats:cat", "hotchicks:chicken", "hotchicks:cow",
                "hotchicks:rabbit", "workdog:boston_terrier", "workdog:jack_russell_terrier"), entry -> true);
        herderLivestockList = builder.defineList("herderLivestockList", Arrays.asList("minecraft:sheep",
                "minecraft:cow", "minecraft:pig", "minecraft:chicken", "minecraft:rabbit", "minecraft:llama",
                "minecraft:trader_llama", "hotchicks:cow", "hotchicks:chicken", "hotchicks:rabbit"), entry -> true);
        builder.pop();
    }
}
