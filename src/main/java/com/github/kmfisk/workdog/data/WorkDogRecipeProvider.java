package com.github.kmfisk.workdog.data;

import com.github.kmfisk.workdog.block.WorkDogBlocks;
import com.github.kmfisk.workdog.item.WorkDogItems;
import com.github.kmfisk.workdog.tags.WorkDogTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class WorkDogRecipeProvider extends RecipeProvider {
    public WorkDogRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(WorkDogItems.COLLAR.get(), 2)
                .pattern("TTT")
                .pattern("T T")
                .pattern("TRT")
                .define('T', Items.LEATHER)
                .define('R', Items.GOLD_INGOT)
                .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);
        ShapedRecipeBuilder.shaped(WorkDogItems.HARNESS.get())
                .pattern(" TT")
                .pattern("GRF")
                .pattern("TTT")
                .define('T', Items.LEATHER)
                .define('R', Items.GOLD_INGOT)
                .define('G', Items.GOLD_NUGGET)
                .define('F', Items.STRING)
                .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);
        ShapedRecipeBuilder.shaped(WorkDogItems.HOG_VEST.get())
                .pattern(" TT")
                .pattern("TRF")
                .pattern("TTT")
                .define('T', Items.LEATHER)
                .define('R', Items.IRON_INGOT)
                .define('F', Items.STRING)
                .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);
        ShapedRecipeBuilder.shaped(WorkDogItems.MUZZLE.get())
                .pattern("RRF")
                .pattern("TTL")
                .define('R', Items.IRON_BARS)
                .define('T', Items.IRON_INGOT)
                .define('L', Items.LEATHER)
                .define('F', Items.STRING)
                .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);
        ShapedRecipeBuilder.shaped(WorkDogItems.SADDLEBAG.get())
                .pattern("F F")
                .pattern("TRT")
                .pattern("TTT")
                .define('R', Tags.Items.CHESTS_WOODEN)
                .define('T', Items.LEATHER)
                .define('F', Items.STRING)
                .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);


        ShapedRecipeBuilder.shaped(WorkDogItems.CRATE.get())
                .pattern("III")
                .pattern("BDI")
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .define('B', Items.IRON_BARS)
                .define('D', ItemTags.CARPETS)
                .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT)).save(consumer);
        ShapelessRecipeBuilder.shapeless(WorkDogItems.STERILIZATION_POTION.get(), 4)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.SPIDER_EYE)
                .requires(Items.BONE)
                .requires(Items.IRON_NUGGET)
                .unlockedBy("has_bottle", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLASS_BOTTLE)).save(consumer);
        ShapelessRecipeBuilder.shapeless(WorkDogItems.SURRENDER_FORM.get())
                .requires(Items.PAPER)
                .requires(WorkDogItems.COLLAR.get())
                .unlockedBy("has_collar", InventoryChangeTrigger.TriggerInstance.hasItems(WorkDogItems.COLLAR.get())).save(consumer);

        ShapedRecipeBuilder.shaped(WorkDogBlocks.KENNEL_EQUIPMENT.get())
                .pattern("###")
                .pattern("HML")
                .pattern("S  ")
                .define('#', Items.STONE_SLAB)
                .define('H', WorkDogItems.HARNESS.get())
                .define('M', WorkDogItems.MUZZLE.get())
                .define('L', Items.LEAD)
                .define('S', Items.STICK)
                .unlockedBy("has_lead", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.ANY)).save(consumer);

        for (int i = 0; i < 16; i++) {
            DyeColor color = DyeColor.byId(i);
            ShapedRecipeBuilder.shaped(WorkDogItems.SERVICE_VESTS.get(color.getName()).get())
                    .pattern(" TT")
                    .pattern("TRF")
                    .pattern("TTT")
                    .define('T', Items.LEATHER)
                    .define('R', DyeItem.byColor(color))
                    .define('F', Items.STRING)
                    .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);
        }

        Ingredient woolCarpets = Ingredient.of(ItemTags.CARPETS);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.WHITE.getName()).get(), woolCarpets, Blocks.WHITE_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.ORANGE.getName()).get(), woolCarpets, Blocks.ORANGE_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.MAGENTA.getName()).get(), woolCarpets, Blocks.MAGENTA_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.LIGHT_BLUE.getName()).get(), woolCarpets, Blocks.LIGHT_BLUE_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.YELLOW.getName()).get(), woolCarpets, Blocks.YELLOW_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.LIME.getName()).get(), woolCarpets, Blocks.LIME_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.PINK.getName()).get(), woolCarpets, Blocks.PINK_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.GRAY.getName()).get(), woolCarpets, Blocks.GRAY_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.LIGHT_GRAY.getName()).get(), woolCarpets, Blocks.LIGHT_GRAY_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.CYAN.getName()).get(), woolCarpets, Blocks.CYAN_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.PURPLE.getName()).get(), woolCarpets, Blocks.PURPLE_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.BLUE.getName()).get(), woolCarpets, Blocks.BLUE_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.BROWN.getName()).get(), woolCarpets, Blocks.BROWN_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.GREEN.getName()).get(), woolCarpets, Blocks.GREEN_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.RED.getName()).get(), woolCarpets, Blocks.RED_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.BLACK.getName()).get(), woolCarpets, Blocks.BLACK_WOOL);

        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.WHITE.getName()).get(), Ingredient.of(Blocks.WHITE_WOOL), Blocks.WHITE_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.ORANGE.getName()).get(), Ingredient.of(Blocks.ORANGE_WOOL), Blocks.ORANGE_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.MAGENTA.getName()).get(), Ingredient.of(Blocks.MAGENTA_WOOL), Blocks.MAGENTA_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.LIGHT_BLUE.getName()).get(), Ingredient.of(Blocks.LIGHT_BLUE_WOOL), Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.YELLOW.getName()).get(), Ingredient.of(Blocks.YELLOW_WOOL), Blocks.YELLOW_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.LIME.getName()).get(), Ingredient.of(Blocks.LIME_WOOL), Blocks.LIME_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.PINK.getName()).get(), Ingredient.of(Blocks.PINK_WOOL), Blocks.PINK_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.GRAY.getName()).get(), Ingredient.of(Blocks.GRAY_WOOL), Blocks.GRAY_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.LIGHT_GRAY.getName()).get(), Ingredient.of(Blocks.LIGHT_GRAY_WOOL), Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.CYAN.getName()).get(), Ingredient.of(Blocks.CYAN_WOOL), Blocks.CYAN_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.PURPLE.getName()).get(), Ingredient.of(Blocks.PURPLE_WOOL), Blocks.PURPLE_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.BLUE.getName()).get(), Ingredient.of(Blocks.BLUE_WOOL), Blocks.BLUE_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.BROWN.getName()).get(), Ingredient.of(Blocks.BROWN_WOOL), Blocks.BROWN_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.GREEN.getName()).get(), Ingredient.of(Blocks.GREEN_WOOL), Blocks.GREEN_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.RED.getName()).get(), Ingredient.of(Blocks.RED_WOOL), Blocks.RED_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.BLACK.getName()).get(), Ingredient.of(Blocks.BLACK_WOOL), Blocks.BLACK_GLAZED_TERRACOTTA);

        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.WHITE.getName()).get(), Blocks.WHITE_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.ORANGE.getName()).get(), Blocks.ORANGE_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.MAGENTA.getName()).get(), Blocks.MAGENTA_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.LIGHT_BLUE.getName()).get(), Blocks.LIGHT_BLUE_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.YELLOW.getName()).get(), Blocks.YELLOW_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.LIME.getName()).get(), Blocks.LIME_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.PINK.getName()).get(), Blocks.PINK_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.GRAY.getName()).get(), Blocks.GRAY_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.LIGHT_GRAY.getName()).get(), Blocks.LIGHT_GRAY_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.CYAN.getName()).get(), Blocks.CYAN_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.PURPLE.getName()).get(), Blocks.PURPLE_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.BLUE.getName()).get(), Blocks.BLUE_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.BROWN.getName()).get(), Blocks.BROWN_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.GREEN.getName()).get(), Blocks.GREEN_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.RED.getName()).get(), Blocks.RED_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.BLACK.getName()).get(), Blocks.BLACK_CONCRETE);
    }

    public static void dogBed(Consumer<FinishedRecipe> consumer, Block bed, Ingredient topPiece, Block bottomPiece) {
        ShapedRecipeBuilder.shaped(bed)
                .pattern("WWW")
                .pattern("TTT")
                .define('W', topPiece)
                .define('T', bottomPiece)
                .unlockedBy("has_wool", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTags.WOOL).build())).save(consumer);
    }

    public static void dogBowl(Consumer<FinishedRecipe> consumer, Block bowl, Block concrete) {
        ShapedRecipeBuilder.shaped(bowl)
                .pattern("FCW")
                .pattern("CCC")
                .define('F', WorkDogTags.RAW_MEAT)
                .define('C', concrete)
                .define('W', Items.POTION.getDefaultInstance().getItem())
                .unlockedBy("has_concrete", InventoryChangeTrigger.TriggerInstance.hasItems(concrete)).save(consumer);
    }
}
