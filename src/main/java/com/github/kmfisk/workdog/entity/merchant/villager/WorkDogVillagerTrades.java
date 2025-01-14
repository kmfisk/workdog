package com.github.kmfisk.workdog.entity.merchant.villager;

import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.WorkDogEntities;
import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.event.village.VillagerTradesEvent;

public class WorkDogVillagerTrades {
    public static void onVillagerTradesEvent(VillagerTradesEvent event) {
        if (!WorkDogConfig.pedigreeMode.get()) {
            if (event.getType() == VillagerProfession.FARMER) {
                event.getTrades().get(3).add(new VillagerTrades.ItemsForEmeralds(WorkDogItems.SPAWN_EGGS.get(WorkDogEntities.BORDER_COLLIE).get(), 48, 1, 3, 15));
            }
        }
    }
}
