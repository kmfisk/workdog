package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class CrateItem extends Item {
    public CrateItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        if (target instanceof WorkDogEntity) {
            if (stack.hasTag()) {
                player.displayClientMessage(Component.translatable("chat.workdog.crate.full"), true);
                return InteractionResult.PASS;
            }

            WorkDogEntity dog = (WorkDogEntity) target;
            if (!dog.isTame() || dog.getOwner() == player || player.hasPermissions(2)) {
                if (player.level().isClientSide) return InteractionResult.SUCCESS;
                ItemStack capturedEntityItem = caughtEntityItem(dog, player);
                player.setItemInHand(hand, capturedEntityItem);
                return InteractionResult.CONSUME;
            } else player.displayClientMessage(Component.translatable("chat.workdog.crate.not_your_dog"), true);

        } else
            player.displayClientMessage(Component.translatable("chat.workdog.crate.fail"), true);

        return super.interactLivingEntity(stack, player, target, hand);
    }

    private ItemStack caughtEntityItem(WorkDogEntity dog, Player player) {
        dog.stopRiding();
        dog.ejectPassengers();
        dog.revive();

        CompoundTag tags = new CompoundTag();
        dog.save(tags);

        ResourceLocation key = EntityType.getKey(dog.getType());
        tags.putString("id", key.toString());
        if (dog.isTame() && dog.isOwnedBy(player)) tags.putString("OwnerName", player.getName().getString());
        if (dog.hasCustomName()) tags.putString("DisplayName", dog.getDisplayName().getString());

        dog.discard();
        player.displayClientMessage(Component.translatable("chat.workdog.crate.capture", dog.getDisplayName()), true);

        ItemStack newStack = new ItemStack(this);
        newStack.setTag(tags);
        return newStack;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player != null) {
            Level level = context.getLevel();
            ItemStack stack = context.getItemInHand();
            if (!stack.hasTag() || (stack.hasTag() && !stack.getTag().contains("id"))) {
                player.displayClientMessage(Component.translatable("chat.workdog.crate.empty"), true);
                return InteractionResult.PASS;
            }

            if (!level.isClientSide) {
                BlockPos pos = new BlockPos(context.getClickedPos()).relative(context.getClickedFace());

                CompoundTag tags = stack.getTag();
                tags.remove("Passengers");
                tags.remove("Leash");
                tags.remove("OwnerName");
                tags.remove("DisplayName");

                LivingEntity entity = (LivingEntity) EntityType.loadEntityRecursive(tags, level, entity1 -> entity1);
                if (entity != null) {
                    entity.absMoveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, context.getRotation(), 0);
                    entity.setUUID(tags.getUUID("UUID"));
                    level.addFreshEntity(entity);

                    stack.shrink(1);
                    player.setItemInHand(context.getHand(), new ItemStack(this));

                    player.displayClientMessage(Component.translatable("chat.workdog.crate.release", entity.getDisplayName()), true);
                }
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        CompoundTag nbt = stack.getTag();
        if (nbt != null && nbt.contains("id")) {
            if (nbt.contains("DisplayName"))
                tooltip.add(Component.literal("\"" + nbt.getString("DisplayName") + "\"").withStyle(ChatFormatting.AQUA));

            MutableComponent entityId = Component.translatable(Util.makeDescriptionId("entity", new ResourceLocation(nbt.getString("id"))));
            MutableComponent gender = Component.translatable(nbt.getBoolean("Gender") ? "tooltip.workdog.crate.male" : "tooltip.workdog.crate.female");
            tooltip.add(gender.append(" ").append(entityId).withStyle(ChatFormatting.BLUE));

            if (nbt.contains("OwnerName")) {
                MutableComponent owner = Component.translatable("tooltip.workdog.crate.owner", nbt.getString("OwnerName"));
                tooltip.add(owner.withStyle(ChatFormatting.GRAY));
            }

        } else
            tooltip.add(Component.translatable("tooltip.workdog.crate.empty").withStyle(ChatFormatting.GRAY));
    }
}
