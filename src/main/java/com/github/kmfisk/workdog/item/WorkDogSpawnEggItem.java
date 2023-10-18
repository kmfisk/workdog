package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeSpawnEggItem;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class WorkDogSpawnEggItem extends ForgeSpawnEggItem {
    public WorkDogSpawnEggItem(Supplier<? extends EntityType<?>> type, Properties props) {
        super(type, 0xFFFFFF, 0xFFFFFF, props);
    }

    @Override
    public ActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        EntityType<?> entityType = getType(itemStack.getTag());
        Entity entity = entityType.create(level);
        if (player.isDiscrete() && entity != null && level.getServer() != null && (level.isClientSide || level.getServer().getPlayerList().isOp(player.getGameProfile()))) {
            int maxVariants = 0;
            int currentVariant;
            int setVariant;

            if (entity instanceof WorkDogEntity)
                maxVariants = ((WorkDogEntity) entity).getVariantCount() - 1;

            if (maxVariants > 0) {
                if (itemStack.getTag() != null && itemStack.getTag().contains("Variant")) {
                    currentVariant = itemStack.getTag().getInt("Variant");
                    setVariant = currentVariant == maxVariants ? -1 : Math.min(currentVariant + 1, maxVariants);
                } else setVariant = 0;
                String message = setVariant == -1 ? "Random" : String.valueOf(setVariant);
                player.displayClientMessage(new StringTextComponent(message), true);
                if (setVariant == -1) itemStack.removeTagKey("Variant");
                else itemStack.getOrCreateTag().putInt("Variant", setVariant);
            }
        }

        BlockRayTraceResult rayTraceResult = getPlayerPOVHitResult(level, player, RayTraceContext.FluidMode.SOURCE_ONLY);
        if (rayTraceResult.getType() != RayTraceResult.Type.BLOCK) return ActionResult.pass(itemStack);
        else if (!(level instanceof ServerWorld)) return ActionResult.success(itemStack);
        else {
            BlockPos blockPos = rayTraceResult.getBlockPos();
            if (!(level.getBlockState(blockPos).getBlock() instanceof FlowingFluidBlock))
                return ActionResult.pass(itemStack);

            if (level.mayInteract(player, blockPos) && player.mayUseItemAt(blockPos, rayTraceResult.getDirection(), itemStack)) {
                if (entityType.spawn((ServerWorld) level, itemStack, player, blockPos, SpawnReason.SPAWN_EGG, false, false) == null)
                    return ActionResult.pass(itemStack);
                else {
                    if (!player.abilities.instabuild) itemStack.shrink(1);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    return ActionResult.consume(itemStack);
                }
            } else {
                return ActionResult.fail(itemStack);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World level, List<ITextComponent> tooltip, ITooltipFlag isAdvanced) {
        CompoundNBT nbt = stack.getTag();
        if (nbt != null && nbt.contains("Variant")) {
            int variant = nbt.getInt("Variant");
            tooltip.add(new TranslationTextComponent("tooltip.workdog.spawn_egg.variant", variant).withStyle(TextFormatting.GRAY));
        }
    }
}
