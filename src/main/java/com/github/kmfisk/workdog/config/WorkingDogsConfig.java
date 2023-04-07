package com.github.kmfisk.workdog.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class WorkingDogsConfig {
    public static final ForgeConfigSpec CONFIG_SPEC;
    public static ForgeConfigSpec.BooleanValue removeVanillaWolves;
    public static ForgeConfigSpec.BooleanValue pedigreeMode;
    public static ForgeConfigSpec.ConfigValue<Integer> wolfSpawnChance;
    public static ForgeConfigSpec.ConfigValue<Integer> wolfMinGroup;
    public static ForgeConfigSpec.ConfigValue<Integer> wolfMaxGroup;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupConfig(configBuilder);
        CONFIG_SPEC = configBuilder.build();
    }

    private static void setupConfig(ForgeConfigSpec.Builder builder) {
        builder.push("Spawns");
        builder.push("Wolves");
        wolfSpawnChance = builder.define("chance", 8);
        wolfMinGroup = builder.define("min", 1);
        wolfMaxGroup = builder.define("max", 5);
        pedigreeMode = builder.define("pedigreeMode", false);
        removeVanillaWolves = builder.define("removeVanilla", true);
        builder.pop();
        builder.pop();
    }
}
