package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class SurrenderFormItem extends Item {
    public SurrenderFormItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        if (target instanceof TamableAnimal tame) {
            if (tame.isTame() && (tame.isOwnedBy(player) || player.hasPermissions(2)) && player.isCrouching()) {
                for (int i = 0; i < 7; ++i) {
                    double d0 = tame.getRandom().nextGaussian() * 0.02D;
                    double d1 = tame.getRandom().nextGaussian() * 0.02D;
                    double d2 = tame.getRandom().nextGaussian() * 0.02D;
                    tame.level().addParticle(ParticleTypes.SMOKE, tame.getRandomX(1.0D), tame.getRandomY() + 0.5D, tame.getRandomZ(1.0D), d0, d1, d2);
                }
                if (!tame.level().isClientSide()) {
                    if (tame.isOrderedToSit()) tame.setOrderedToSit(false);
                    if (tame instanceof WorkDogEntity dog) dog.setMode(WorkDogEntity.Mode.WANDER);
                    tame.setTame(false);
                    tame.setOwnerUUID(null);
                    player.displayClientMessage(Component.translatable("chat.workdog.surrender_form.success", tame.getName()), true);
                    if (!player.isCreative()) stack.shrink(1);
                }
                return InteractionResult.sidedSuccess(tame.level().isClientSide);
            }
        }
        return super.interactLivingEntity(stack, player, target, hand);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("tooltip.workdog.surrender_form.usage").withStyle(ChatFormatting.GRAY));
    }
}
