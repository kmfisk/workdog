package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.WDWolfEntity;
import com.github.kmfisk.workdog.entity.core.AbstractInventoryAnimal;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import com.github.kmfisk.workdog.inventory.BreedStandardContainerMenu;
import com.github.kmfisk.workdog.inventory.WorkDogContainerMenu;
import com.github.kmfisk.workdog.inventory.WorkDogUnownedContainerMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkHooks;

public class BreedStandardBookItem extends Item {
    public BreedStandardBookItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (entity instanceof WorkDogEntity workDog && !(entity instanceof WDWolfEntity)) {
            Component name = workDog.getCustomName() != null ? workDog.getName() : Component.literal("???");
            if (!workDog.level().isClientSide)
                NetworkHooks.openScreen((ServerPlayer) player, new SimpleMenuProvider((id, playerInv, pPlayer) -> new BreedStandardContainerMenu(id, playerInv), name));
            WorkDog.setReferencedMob(workDog);
            return InteractionResult.sidedSuccess(workDog.level().isClientSide);
        }
        return InteractionResult.PASS;
    }
}
