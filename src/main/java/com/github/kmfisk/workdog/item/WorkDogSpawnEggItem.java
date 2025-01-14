package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.HitResult;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.common.ForgeSpawnEggItem;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.world.item.Item.Properties;

public class WorkDogSpawnEggItem extends ForgeSpawnEggItem {
    public WorkDogSpawnEggItem(Supplier<? extends EntityType<?>> type, Properties props) {
        super(type, 0xFFFFFF, 0xFFFFFF, props);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        EntityType<?> entityType = getType(itemStack.getTag());
        Entity entity = entityType.create(level);
        if (player.isDiscrete() && entity != null && level.getServer() != null && (level.isClientSide || level.getServer().getPlayerList().isOp(player.getGameProfile()))) {
            int maxVariants = 0;
            int currentVariant;
            int setVariant;

            if (entity instanceof WorkDogEntity)
                maxVariants = ((WorkDogEntity) entity).getVariantCount() + 1;

            if (maxVariants > 0) {
                if (itemStack.getTag() != null && itemStack.getTag().contains("Variant")) {
                    currentVariant = itemStack.getTag().getInt("Variant");
                    setVariant = currentVariant == maxVariants ? -1 : Math.min(currentVariant + 1, maxVariants);
                } else setVariant = 0;
                String message = setVariant == -1 ? "Random" : String.valueOf(setVariant);
                player.displayClientMessage(new TextComponent(message), true);
                if (setVariant == -1) itemStack.removeTagKey("Variant");
                else itemStack.getOrCreateTag().putInt("Variant", setVariant);
            }
        }

        BlockHitResult rayTraceResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        if (rayTraceResult.getType() != HitResult.Type.BLOCK) return InteractionResultHolder.pass(itemStack);
        else if (!(level instanceof ServerLevel)) return InteractionResultHolder.success(itemStack);
        else {
            BlockPos blockPos = rayTraceResult.getBlockPos();
            if (!(level.getBlockState(blockPos).getBlock() instanceof LiquidBlock))
                return InteractionResultHolder.pass(itemStack);

            if (level.mayInteract(player, blockPos) && player.mayUseItemAt(blockPos, rayTraceResult.getDirection(), itemStack)) {
                if (entityType.spawn((ServerLevel) level, itemStack, player, blockPos, MobSpawnType.SPAWN_EGG, false, false) == null)
                    return InteractionResultHolder.pass(itemStack);
                else {
                    if (!player.abilities.instabuild) itemStack.shrink(1);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.consume(itemStack);
                }
            } else {
                return InteractionResultHolder.fail(itemStack);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        CompoundTag nbt = stack.getTag();
        if (nbt != null && nbt.contains("Variant")) {
            int variant = nbt.getInt("Variant");
            tooltip.add(new TranslatableComponent("tooltip.workdog.spawn_egg.variant", variant).withStyle(ChatFormatting.GRAY));
        }
    }
}
