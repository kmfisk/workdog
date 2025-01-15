package com.github.kmfisk.workdog.entity.merchant.villager;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.block.WorkDogBlocks;
import com.github.kmfisk.workdog.entity.WorkDogEntities;
import com.github.kmfisk.workdog.item.DyeableDogEquipmentItem;
import com.github.kmfisk.workdog.item.WorkDogItems;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.*;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Random;

public class WorkDogVillagers {
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, WorkDog.MOD_ID);
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, WorkDog.MOD_ID);

    public static final RegistryObject<PoiType> KENNEL_EQUIPMENT = POI_TYPES.register("kennel_equipment", () -> new PoiType("kennel_hand", PoiType.getBlockStates(WorkDogBlocks.KENNEL_EQUIPMENT.get()), 2, 1));
    public static final RegistryObject<VillagerProfession> KENNEL_HAND = PROFESSIONS.register("kennel_hand", () -> new VillagerProfession("kennel_hand", KENNEL_EQUIPMENT.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_SHEPHERD));

    public static void registerTrades() {
//        numberOfItems, maxUses, villagerXp
        VillagerTrades.ItemListing[] novice = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.BEEF, 10, 16, 2),
                new VillagerTrades.EmeraldForItems(Items.PORKCHOP, 7, 16, 2),
                new VillagerTrades.EmeraldForItems(Items.COD, 15, 16, 2),
                new VillagerTrades.EmeraldForItems(Items.CHICKEN, 14, 16, 2)};
//       emeraldCost, numberOfItems, maxUses, villagerXp, priceMultiplier
        VillagerTrades.ItemListing[] apprentice = new VillagerTrades.ItemListing[]{
//                new VillagerTrades.ItemsForEmeraldsTrade(WorkDogItems.TENNIS_BALL.get(), 1, 1, 3, 10),
//                new VillagerTrades.ItemsForEmeraldsTrade(WorkDogItems.THROW_STICK.get(), 1, 1, 3, 10),
                new VillagerTrades.ItemsForEmeralds(WorkDogItems.FRISBEE.get(), 1, 1, 3, 10),
                new DyedEquipmentForEmeraldsTrade(WorkDogItems.COLLAR.get(), 3, 3, 10),
                new VillagerTrades.ItemsForEmeralds(WorkDogItems.STERILIZATION_POTION.get(), 3, 1, 16, 10)};
        VillagerTrades.ItemListing[] journeyman = new VillagerTrades.ItemListing[]{
                new DyedEquipmentForEmeraldsTrade(WorkDogItems.HARNESS.get(), 7, 3, 10),
                new DyedEquipmentForEmeraldsTrade(WorkDogItems.HOG_VEST.get(), 7, 3, 10)};
        VillagerTrades.ItemListing[] expert = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(WorkDogItems.CRATE.get(), 3, 1, 3, 30),
                new VillagerTrades.ItemsForEmeralds(WorkDogItems.SERVICE_VESTS.get(DyeColor.WHITE.getName()).get(), 7, 1, 3, 15),
//                new VillagerTrades.ItemsForEmeraldsTrade(WorkDogItems.WOLF_COLLAR.get(), 7, 1, 3, 15),
                new DyedEquipmentForEmeraldsTrade(WorkDogItems.MUZZLE.get(), 7, 3, 15)};
        VillagerTrades.ItemListing[] master = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(new ItemStack(ForgeSpawnEggItem.fromEntityType(WorkDogEntities.BOSTON_TERRIER.get())), 16, 1, 3, 15, 0.2f),
                new VillagerTrades.ItemsForEmeralds(new ItemStack(ForgeSpawnEggItem.fromEntityType(WorkDogEntities.JACK_RUSSELL_TERRIER.get())), 32, 1, 3, 15, 0.2f),
                new VillagerTrades.ItemsForEmeralds(new ItemStack(ForgeSpawnEggItem.fromEntityType(WorkDogEntities.BORDER_COLLIE.get())), 48, 1, 3, 15, 0.2f),
                new VillagerTrades.ItemsForEmeralds(new ItemStack(ForgeSpawnEggItem.fromEntityType(WorkDogEntities.PIT_BULL.get())), 64, 1, 3, 15, 0.2f),
                new VillagerTrades.ItemsForEmeralds(new ItemStack(ForgeSpawnEggItem.fromEntityType(WorkDogEntities.AKITA.get())), 64, 1, 3, 15, 0.2f),
                new VillagerTrades.ItemsForEmeralds(new ItemStack(ForgeSpawnEggItem.fromEntityType(WorkDogEntities.GERMAN_SHEPHERD.get())), 64, 1, 3, 15, 0.2f)};
        VillagerTrades.TRADES.put(KENNEL_HAND.get(), toIntMap(ImmutableMap.of(1, novice, 2, apprentice, 3, journeyman, 4, expert, 5, master)));
    }

    protected static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> map) {
        return new Int2ObjectOpenHashMap<>(map);
    }

    public static class DyedEquipmentForEmeraldsTrade implements VillagerTrades.ItemListing {
        private final Item item;
        private final int value;
        private final int maxUses;
        private final int villagerXp;

        public DyedEquipmentForEmeraldsTrade(Item item, int value, int maxUses, int villagerXp) {
            this.item = item;
            this.value = value;
            this.maxUses = maxUses;
            this.villagerXp = villagerXp;
        }

        public MerchantOffer getOffer(Entity entity, Random random) {
            ItemStack cost = new ItemStack(Items.EMERALD, value);
            ItemStack merch = new ItemStack(item);
            if (item instanceof DyeableDogEquipmentItem) {
                List<DyeItem> dyeItems = Lists.newArrayList();
                dyeItems.add(getRandomDye(random));
                if (random.nextFloat() > 0.7F) dyeItems.add(getRandomDye(random));
                if (random.nextFloat() > 0.8F) dyeItems.add(getRandomDye(random));
                merch = DyeableLeatherItem.dyeArmor(merch, dyeItems);
            }

            return new MerchantOffer(cost, merch, maxUses, villagerXp, 0.05F);
        }

        private static DyeItem getRandomDye(Random random) {
            return DyeItem.byColor(DyeColor.byId(random.nextInt(16)));
        }
    }
}
