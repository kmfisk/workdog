package com.github.kmfisk.workdog.client.color;

import com.github.kmfisk.workdog.block.WorkDogBlocks;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.client.event.ColorHandlerEvent;

public class ColorEvents {
    public static void registerColorHandlerBlocks(final ColorHandlerEvent.Block event) {
        event.getBlockColors().register((state, reader, pos, color) -> reader != null && pos != null ? BiomeColors.getAverageWaterColor(reader, pos) : -1,
                WorkDogBlocks.BOWL.get());
    }
}
