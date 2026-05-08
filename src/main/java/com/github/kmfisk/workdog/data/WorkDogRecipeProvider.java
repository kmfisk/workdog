package com.github.kmfisk.workdog.data;

import com.github.kmfisk.workdog.block.WorkDogBlocks;
import com.github.kmfisk.workdog.item.WorkDogItems;
import com.github.kmfisk.workdog.tags.WorkDogTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class WorkDogRecipeProvider extends RecipeProvider {
    public WorkDogRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WorkDogItems.COLLAR.get(), 2)
                .pattern("TTT")
                .pattern("T T")
                .pattern("TRT")
                .define('T', Items.LEATHER)
                .define('R', Items.GOLD_INGOT)
                .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WorkDogItems.HARNESS.get())
                .pattern(" TT")
                .pattern("GRF")
                .pattern("TTT")
                .define('T', Items.LEATHER)
                .define('R', Items.GOLD_INGOT)
                .define('G', Items.GOLD_NUGGET)
                .define('F', Items.STRING)
                .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WorkDogItems.HOG_VEST.get())
                .pattern(" TT")
                .pattern("TRF")
                .pattern("TTT")
                .define('T', Items.LEATHER)
                .define('R', Items.IRON_INGOT)
                .define('F', Items.STRING)
                .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WorkDogItems.MUZZLE.get())
                .pattern("RRF")
                .pattern("TTL")
                .define('R', Items.IRON_BARS)
                .define('T', Items.IRON_INGOT)
                .define('L', Items.LEATHER)
                .define('F', Items.STRING)
                .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WorkDogItems.SADDLEBAG.get())
                .pattern("F F")
                .pattern("TRT")
                .pattern("TTT")
                .define('R', Tags.Items.CHESTS_WOODEN)
                .define('T', Items.LEATHER)
                .define('F', Items.STRING)
                .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WorkDogItems.SWEATER.get())
                .pattern(" TT")
                .pattern("TRF")
                .pattern("TTT")
                .define('T', Items.WHITE_WOOL)
                .define('R', Items.LEATHER)
                .define('F', Items.STRING)
                .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WorkDogItems.CRATE.get())
                .pattern("III")
                .pattern("BDI")
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .define('B', Items.IRON_BARS)
                .define('D', ItemTags.WOOL_CARPETS)
                .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WorkDogItems.STERILIZATION_POTION.get(), 4)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.SPIDER_EYE)
                .requires(Items.BONE)
                .requires(Items.IRON_NUGGET)
                .unlockedBy("has_bottle", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLASS_BOTTLE)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WorkDogItems.SURRENDER_FORM.get())
                .requires(Items.PAPER)
                .requires(WorkDogItems.COLLAR.get())
                .unlockedBy("has_collar", InventoryChangeTrigger.TriggerInstance.hasItems(WorkDogItems.COLLAR.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WorkDogBlocks.KENNEL_EQUIPMENT.get())
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
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WorkDogItems.SERVICE_VESTS.get(color).get())
                    .pattern(" TT")
                    .pattern("TRF")
                    .pattern("TTT")
                    .define('T', Items.LEATHER)
                    .define('R', DyeItem.byColor(color))
                    .define('F', Items.STRING)
                    .unlockedBy("has_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER)).save(consumer);
        }

        Ingredient woolCarpets = Ingredient.of(ItemTags.WOOL_CARPETS);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.WHITE).get(), woolCarpets, Blocks.WHITE_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.ORANGE).get(), woolCarpets, Blocks.ORANGE_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.MAGENTA).get(), woolCarpets, Blocks.MAGENTA_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.LIGHT_BLUE).get(), woolCarpets, Blocks.LIGHT_BLUE_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.YELLOW).get(), woolCarpets, Blocks.YELLOW_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.LIME).get(), woolCarpets, Blocks.LIME_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.PINK).get(), woolCarpets, Blocks.PINK_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.GRAY).get(), woolCarpets, Blocks.GRAY_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.LIGHT_GRAY).get(), woolCarpets, Blocks.LIGHT_GRAY_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.CYAN).get(), woolCarpets, Blocks.CYAN_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.PURPLE).get(), woolCarpets, Blocks.PURPLE_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.BLUE).get(), woolCarpets, Blocks.BLUE_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.BROWN).get(), woolCarpets, Blocks.BROWN_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.GREEN).get(), woolCarpets, Blocks.GREEN_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.RED).get(), woolCarpets, Blocks.RED_WOOL);
        dogBed(consumer, WorkDogBlocks.BEDS.get(DyeColor.BLACK).get(), woolCarpets, Blocks.BLACK_WOOL);

        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.WHITE).get(), Ingredient.of(Blocks.WHITE_WOOL), Blocks.WHITE_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.ORANGE).get(), Ingredient.of(Blocks.ORANGE_WOOL), Blocks.ORANGE_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.MAGENTA).get(), Ingredient.of(Blocks.MAGENTA_WOOL), Blocks.MAGENTA_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.LIGHT_BLUE).get(), Ingredient.of(Blocks.LIGHT_BLUE_WOOL), Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.YELLOW).get(), Ingredient.of(Blocks.YELLOW_WOOL), Blocks.YELLOW_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.LIME).get(), Ingredient.of(Blocks.LIME_WOOL), Blocks.LIME_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.PINK).get(), Ingredient.of(Blocks.PINK_WOOL), Blocks.PINK_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.GRAY).get(), Ingredient.of(Blocks.GRAY_WOOL), Blocks.GRAY_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.LIGHT_GRAY).get(), Ingredient.of(Blocks.LIGHT_GRAY_WOOL), Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.CYAN).get(), Ingredient.of(Blocks.CYAN_WOOL), Blocks.CYAN_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.PURPLE).get(), Ingredient.of(Blocks.PURPLE_WOOL), Blocks.PURPLE_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.BLUE).get(), Ingredient.of(Blocks.BLUE_WOOL), Blocks.BLUE_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.BROWN).get(), Ingredient.of(Blocks.BROWN_WOOL), Blocks.BROWN_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.GREEN).get(), Ingredient.of(Blocks.GREEN_WOOL), Blocks.GREEN_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.RED).get(), Ingredient.of(Blocks.RED_WOOL), Blocks.RED_GLAZED_TERRACOTTA);
        dogBed(consumer, WorkDogBlocks.FANCY_BEDS.get(DyeColor.BLACK).get(), Ingredient.of(Blocks.BLACK_WOOL), Blocks.BLACK_GLAZED_TERRACOTTA);

        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.WHITE).get(), Blocks.WHITE_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.ORANGE).get(), Blocks.ORANGE_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.MAGENTA).get(), Blocks.MAGENTA_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.LIGHT_BLUE).get(), Blocks.LIGHT_BLUE_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.YELLOW).get(), Blocks.YELLOW_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.LIME).get(), Blocks.LIME_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.PINK).get(), Blocks.PINK_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.GRAY).get(), Blocks.GRAY_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.LIGHT_GRAY).get(), Blocks.LIGHT_GRAY_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.CYAN).get(), Blocks.CYAN_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.PURPLE).get(), Blocks.PURPLE_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.BLUE).get(), Blocks.BLUE_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.BROWN).get(), Blocks.BROWN_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.GREEN).get(), Blocks.GREEN_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.RED).get(), Blocks.RED_CONCRETE);
        dogBowl(consumer, WorkDogBlocks.BOWLS.get(DyeColor.BLACK).get(), Blocks.BLACK_CONCRETE);
    }

    public static void dogBed(Consumer<FinishedRecipe> consumer, Block bed, Ingredient topPiece, Block bottomPiece) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, bed)
                .pattern("WWW")
                .pattern("TTT")
                .define('W', topPiece)
                .define('T', bottomPiece)
                .unlockedBy("has_wool", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTags.WOOL).build())).save(consumer);
    }

    public static void dogBowl(Consumer<FinishedRecipe> consumer, Block bowl, Block concrete) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, bowl, 3)
                .pattern("FCW")
                .pattern("CCC")
                .define('F', WorkDogTags.RAW_MEATS)
                .define('C', concrete)
                .define('W', Items.WATER_BUCKET.asItem())
                .unlockedBy("has_concrete", InventoryChangeTrigger.TriggerInstance.hasItems(concrete)).save(consumer);
    }
}
