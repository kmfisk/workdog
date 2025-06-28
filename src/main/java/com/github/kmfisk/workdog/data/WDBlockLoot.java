package com.github.kmfisk.workdog.data;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.block.WorkDogBlocks;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.stream.Collectors;

public class WDBlockLoot extends VanillaBlockLoot {
    @Override
    protected void generate() {
        dropSelf(WorkDogBlocks.KENNEL_EQUIPMENT.get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.WHITE).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.ORANGE).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.MAGENTA).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.LIGHT_BLUE).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.YELLOW).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.LIME).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.PINK).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.GRAY).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.LIGHT_GRAY).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.CYAN).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.PURPLE).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.BLUE).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.BROWN).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.GREEN).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.RED).get());
        dropSelf(WorkDogBlocks.BEDS.get(DyeColor.BLACK).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.WHITE).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.ORANGE).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.MAGENTA).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.LIGHT_BLUE).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.YELLOW).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.LIME).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.PINK).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.GRAY).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.LIGHT_GRAY).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.CYAN).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.PURPLE).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.BLUE).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.BROWN).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.GREEN).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.RED).get());
        dropSelf(WorkDogBlocks.FANCY_BEDS.get(DyeColor.BLACK).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.WHITE).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.ORANGE).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.MAGENTA).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.LIGHT_BLUE).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.YELLOW).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.LIME).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.PINK).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.GRAY).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.LIGHT_GRAY).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.CYAN).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.PURPLE).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.BLUE).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.BROWN).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.GREEN).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.RED).get());
        dropSelf(WorkDogBlocks.BOWLS.get(DyeColor.BLACK).get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(WorkDog.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
