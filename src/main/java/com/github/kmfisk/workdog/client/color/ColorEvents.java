package com.github.kmfisk.workdog.client.color;

import com.github.kmfisk.workdog.block.WorkDogBlocks;
import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;

public class ColorEvents {
    public static void registerColorHandlerBlocks(final RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((state, reader, pos, color) -> reader != null && pos != null ? BiomeColors.getAverageWaterColor(reader, pos) : -1,
                WorkDogBlocks.BOWLS.get(DyeColor.WHITE).get(), WorkDogBlocks.BOWLS.get(DyeColor.ORANGE).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.MAGENTA).get(), WorkDogBlocks.BOWLS.get(DyeColor.LIGHT_BLUE).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.YELLOW).get(), WorkDogBlocks.BOWLS.get(DyeColor.LIME).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.PINK).get(), WorkDogBlocks.BOWLS.get(DyeColor.GRAY).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.LIGHT_GRAY).get(), WorkDogBlocks.BOWLS.get(DyeColor.CYAN).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.PURPLE).get(), WorkDogBlocks.BOWLS.get(DyeColor.BLUE).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.BROWN).get(), WorkDogBlocks.BOWLS.get(DyeColor.GREEN).get(),
                WorkDogBlocks.BOWLS.get(DyeColor.RED).get(), WorkDogBlocks.BOWLS.get(DyeColor.BLACK).get());
    }

    public static void registerColorHandlerItems(final RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, layer) -> layer > 0 ? -1 : ((DyeableLeatherItem) stack.getItem()).getColor(stack),
                WorkDogItems.COLLAR.get(), WorkDogItems.HARNESS.get(), WorkDogItems.HOG_VEST.get(), WorkDogItems.MUZZLE.get(), WorkDogItems.SADDLEBAG.get(), WorkDogItems.SWEATER.get());
    }
}
