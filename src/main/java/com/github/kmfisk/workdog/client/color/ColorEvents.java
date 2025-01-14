package com.github.kmfisk.workdog.client.color;

import com.github.kmfisk.workdog.block.WorkDogBlocks;
import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraftforge.client.event.ColorHandlerEvent;

public class ColorEvents {
    public static void registerColorHandlerBlocks(final ColorHandlerEvent.Block event) {
        event.getBlockColors().register((state, reader, pos, color) -> reader != null && pos != null ? BiomeColors.getAverageWaterColor(reader, pos) : -1,
                WorkDogBlocks.BOWLS.get(DyeColor.WHITE.getName()).get(), WorkDogBlocks.BOWLS.get(DyeColor.ORANGE.getName()).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.MAGENTA.getName()).get(), WorkDogBlocks.BOWLS.get(DyeColor.LIGHT_BLUE.getName()).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.YELLOW.getName()).get(), WorkDogBlocks.BOWLS.get(DyeColor.LIME.getName()).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.PINK.getName()).get(), WorkDogBlocks.BOWLS.get(DyeColor.GRAY.getName()).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.LIGHT_GRAY.getName()).get(), WorkDogBlocks.BOWLS.get(DyeColor.CYAN.getName()).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.PURPLE.getName()).get(), WorkDogBlocks.BOWLS.get(DyeColor.BLUE.getName()).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.BROWN.getName()).get(), WorkDogBlocks.BOWLS.get(DyeColor.GREEN.getName()).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.RED.getName()).get(), WorkDogBlocks.BOWLS.get(DyeColor.BLACK.getName()).get());
    }

    public static void registerColorHandlerItems(final ColorHandlerEvent.Item event) {
        event.getItemColors().register((stack, layer) -> layer > 0 ? -1 : ((DyeableLeatherItem) stack.getItem()).getColor(stack),
                WorkDogItems.COLLAR.get(), WorkDogItems.HARNESS.get(), WorkDogItems.HOG_VEST.get(), WorkDogItems.MUZZLE.get(), WorkDogItems.SADDLEBAG.get());
    }
}
