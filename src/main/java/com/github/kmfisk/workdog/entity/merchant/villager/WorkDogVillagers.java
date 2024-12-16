package com.github.kmfisk.workdog.entity.merchant.villager;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.block.WorkDogBlocks;
import com.github.kmfisk.workdog.entity.WorkDogEntities;
import com.github.kmfisk.workdog.item.WorkDogItems;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WorkDogVillagers {
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, WorkDog.MOD_ID);
    public static final DeferredRegister<PointOfInterestType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, WorkDog.MOD_ID);

    public static final RegistryObject<PointOfInterestType> KENNEL_EQUIPMENT = POI_TYPES.register("kennel_equipment", () -> new PointOfInterestType("kennel_hand", PointOfInterestType.getBlockStates(WorkDogBlocks.KENNEL_EQUIPMENT.get()), 2, 1));
    public static final RegistryObject<VillagerProfession> KENNEL_HAND = PROFESSIONS.register("kennel_hand", () -> new VillagerProfession("kennel_hand", KENNEL_EQUIPMENT.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_SHEPHERD));

    public static void registerTrades() {
//        numberOfItems, maxUses, villagerXp
        VillagerTrades.ITrade[] novice = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.BEEF, 10, 16, 2),
                new VillagerTrades.EmeraldForItemsTrade(Items.PORKCHOP, 7, 16, 2),
                new VillagerTrades.EmeraldForItemsTrade(Items.COD, 15, 16, 2),
                new VillagerTrades.EmeraldForItemsTrade(Items.CHICKEN, 14, 16, 2)};
//       emeraldCost, numberOfItems, maxUses, villagerXp, priceMultiplier
        VillagerTrades.ITrade[] apprentice = new VillagerTrades.ITrade[]{
//                new VillagerTrades.EmeraldForItemsTrade(WorkDogItems.TENNIS_BALL.get(), 1, 1, 3, 10),
//                new VillagerTrades.EmeraldForItemsTrade(WorkDogItems.THROW_STICK.get(), 1, 1, 3, 10),
                new VillagerTrades.ItemsForEmeraldsTrade(WorkDogItems.COLLAR.get(), 3, 1, 3, 10),
                new VillagerTrades.ItemsForEmeraldsTrade(WorkDogItems.STERILIZATION_POTION.get(), 3, 1, 16, 10)};
        VillagerTrades.ITrade[] journeyman = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(WorkDogItems.HARNESS.get(), 7, 1, 3, 10),
                new VillagerTrades.ItemsForEmeraldsTrade(WorkDogItems.HOG_VEST.get(), 7, 1, 3, 10)};
        VillagerTrades.ITrade[] expert = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(WorkDogItems.CRATE.get(), 3, 1, 3, 30),
                new VillagerTrades.ItemsForEmeraldsTrade(WorkDogItems.SERVICE_VESTS.get(DyeColor.WHITE.getName()).get(), 7, 1, 3, 15),
//                new VillagerTrades.ItemsForEmeraldsTrade(WorkDogItems.WOLF_COLLAR.get(), 7, 1, 3, 15),
                new VillagerTrades.ItemsForEmeraldsTrade(WorkDogItems.MUZZLE.get(), 7, 2, 3, 15)};
        VillagerTrades.ITrade[] master = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(WorkDogItems.SPAWN_EGGS.get(WorkDogEntities.BOSTON_TERRIER).get()), 16, 1, 3, 15, 0.2f),
                new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(WorkDogItems.SPAWN_EGGS.get(WorkDogEntities.JACK_RUSSELL_TERRIER).get()), 32, 1, 3, 15, 0.2f),
                new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(WorkDogItems.SPAWN_EGGS.get(WorkDogEntities.BORDER_COLLIE).get()), 48, 1, 3, 15, 0.2f),
                new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(WorkDogItems.SPAWN_EGGS.get(WorkDogEntities.PIT_BULL).get()), 48, 1, 3, 15, 0.2f),
                new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(WorkDogItems.SPAWN_EGGS.get(WorkDogEntities.AKITA).get()), 64, 1, 3, 15, 0.2f),
                new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(WorkDogItems.SPAWN_EGGS.get(WorkDogEntities.GERMAN_SHEPHERD).get()), 64, 1, 3, 15, 0.2f)};
        VillagerTrades.TRADES.put(KENNEL_HAND.get(), toIntMap(ImmutableMap.of(1, novice, 2, apprentice, 3, journeyman, 4, expert, 5, master)));
    }

    protected static Int2ObjectMap<VillagerTrades.ITrade[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ITrade[]> map) {
        return new Int2ObjectOpenHashMap<>(map);
    }
}
