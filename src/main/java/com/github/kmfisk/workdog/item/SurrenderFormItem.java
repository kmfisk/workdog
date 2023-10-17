package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class SurrenderFormItem extends Item {
    public SurrenderFormItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
        if (target instanceof WorkDogEntity) {
            WorkDogEntity dog = (WorkDogEntity) target;
            if (dog.isTame() && dog.isOwnedBy(player) && player.isCrouching()) {
                for (int i = 0; i < 7; ++i) {
                    double d0 = random.nextGaussian() * 0.02D;
                    double d1 = random.nextGaussian() * 0.02D;
                    double d2 = random.nextGaussian() * 0.02D;
                    dog.level.addParticle(ParticleTypes.SMOKE, dog.getRandomX(1.0D), dog.getRandomY() + 0.5D, dog.getRandomZ(1.0D), d0, d1, d2);
                }
                if (!target.level.isClientSide()) {
                    if (dog.isOrderedToSit()) dog.setOrderedToSit(false);
                    dog.setMode(WorkDogEntity.Mode.WANDER);
                    dog.setTame(false);
                    dog.setOwnerUUID(null);
                    player.displayClientMessage(new TranslationTextComponent("chat.workdog.surrender_form.success", dog.getName()), true);
                    if (!player.isCreative()) stack.shrink(1);
                }
            }
        }
        return super.interactLivingEntity(stack, player, target, hand);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("tooltip.workdog.surrender_form.usage").withStyle(TextFormatting.GRAY));
    }
}
