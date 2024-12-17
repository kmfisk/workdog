package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class CrateItem extends Item {
    public CrateItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
        if (target instanceof WorkDogEntity) {
            if (stack.hasTag()) {
                player.displayClientMessage(new TranslationTextComponent("chat.workdog.crate.full"), true);
                return ActionResultType.PASS;
            }

            WorkDogEntity dog = (WorkDogEntity) target;
            if (!dog.isTame() || dog.getOwner() == player) {
                if (player.level.isClientSide) return ActionResultType.SUCCESS;
                ItemStack capturedEntityItem = caughtEntityItem(dog, player);
                player.setItemInHand(hand, capturedEntityItem);
                return ActionResultType.CONSUME;
            } else player.displayClientMessage(new TranslationTextComponent("chat.workdog.crate.not_your_dog"), true);

        } else
            player.displayClientMessage(new TranslationTextComponent("chat.workdog.crate.fail"), true);

        return super.interactLivingEntity(stack, player, target, hand);
    }

    private ItemStack caughtEntityItem(WorkDogEntity dog, PlayerEntity player) {
        dog.stopRiding();
        dog.ejectPassengers();
        dog.revive();

        CompoundNBT tags = new CompoundNBT();
        dog.save(tags);

        ResourceLocation key = EntityType.getKey(dog.getType());
        tags.putString("id", key.toString());
        if (dog.isTame()) tags.putString("OwnerName", player.getName().getString());
        if (dog.hasCustomName()) tags.putString("DisplayName", dog.getDisplayName().getString());

        dog.remove();
        player.displayClientMessage(new TranslationTextComponent("chat.workdog.crate.capture", dog.getDisplayName()), true);

        ItemStack newStack = new ItemStack(this);
        newStack.setTag(tags);
        return newStack;
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        if (player != null) {
            World level = context.getLevel();
            ItemStack stack = context.getItemInHand();
            if (!stack.hasTag() || (stack.hasTag() && !stack.getTag().contains("id"))) {
                player.displayClientMessage(new TranslationTextComponent("chat.workdog.crate.empty"), true);
                return ActionResultType.PASS;
            }

            if (!level.isClientSide) {
                BlockPos pos = new BlockPos(context.getClickedPos()).relative(context.getClickedFace());

                CompoundNBT tags = stack.getTag();
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

                    player.displayClientMessage(new TranslationTextComponent("chat.workdog.crate.release", entity.getDisplayName()), true);
                }
            }

            return ActionResultType.sidedSuccess(level.isClientSide);
        }

        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World level, List<ITextComponent> tooltip, ITooltipFlag flag) {
        CompoundNBT nbt = stack.getTag();
        if (nbt != null && nbt.contains("id")) {
            if (nbt.contains("DisplayName"))
                tooltip.add(new StringTextComponent("\"" + nbt.getString("DisplayName") + "\"").withStyle(TextFormatting.AQUA));

            TranslationTextComponent entityId = new TranslationTextComponent(Util.makeDescriptionId("entity", new ResourceLocation(nbt.getString("id"))));
            tooltip.add(entityId.withStyle(TextFormatting.BLUE));

            if (nbt.contains("OwnerName")) {
                TranslationTextComponent owner = new TranslationTextComponent("tooltip.workdog.crate.owner", nbt.getString("OwnerName"));
                tooltip.add(owner.withStyle(TextFormatting.GRAY));
            }

        } else
            tooltip.add(new TranslationTextComponent("tooltip.workdog.crate.empty").withStyle(TextFormatting.GRAY));
    }
}
