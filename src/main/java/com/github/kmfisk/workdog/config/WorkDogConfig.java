package com.github.kmfisk.workdog.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class WorkDogConfig {
    public static final ForgeConfigSpec CONFIG_SPEC;
    public static ForgeConfigSpec.BooleanValue removeVanillaWolves;
    public static ForgeConfigSpec.BooleanValue pedigreeMode;
    public static ForgeConfigSpec.ConfigValue<Integer> wolfSpawnChance;
    public static ForgeConfigSpec.ConfigValue<Integer> wolfMinGroup;
    public static ForgeConfigSpec.ConfigValue<Integer> wolfMaxGroup;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> wolfPreyList;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupConfig(configBuilder);
        CONFIG_SPEC = configBuilder.build();
    }

    private static void setupConfig(ForgeConfigSpec.Builder builder) {
        builder.push("Spawns");
        builder.push("Wolves");
        wolfSpawnChance = builder.define("chance", 16);
        wolfMinGroup = builder.define("min", 1);
        wolfMaxGroup = builder.define("max", 5);
        pedigreeMode = builder.define("pedigreeMode", false);
        removeVanillaWolves = builder.define("removeVanilla", true);
        wolfPreyList = builder.define("preyList", Arrays.asList("minecraft:sheep", "minecraft:pig", "minecraft:rabbit",
                "minecraft:cat", "minecraft:parrot", "simplycats:cat", "hotchicks:chicken", "hotchicks:cow",
                "hotchicks:rabbit", "workdog:boston_terrier", "workdog:jack_russell_terrier"), entry -> true);
        builder.pop();
        builder.pop();
    }
}
