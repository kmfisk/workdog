package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class SterilizationPotionItem extends Item {
    public SterilizationPotionItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        if (target instanceof WorkDogEntity) {
            WorkDogEntity dog = (WorkDogEntity) target;
            if ((!dog.isTame() || (dog.isTame() && dog.isOwnedBy(player))) && player.isCrouching() && !dog.isInfertile()) {
                for (int i = 0; i < 7; ++i) {
                    double d0 = dog.getRandom().nextGaussian() * 0.02D;
                    double d1 = dog.getRandom().nextGaussian() * 0.02D;
                    double d2 = dog.getRandom().nextGaussian() * 0.02D;
                    dog.level().addParticle(ParticleTypes.HAPPY_VILLAGER, dog.getRandomX(1.0D), dog.getRandomY() + 0.5D, dog.getRandomZ(1.0D), d0, d1, d2);
                }
                if (!target.level().isClientSide()) {
                    dog.setInfertile(true);
                    player.displayClientMessage(Component.translatable(dog.getGender() == WorkDogEntity.Gender.FEMALE ? "chat.workdog.sterilization_potion.success_female" : "chat.workdog.sterilization_potion.success_male", dog.getName()), true);

                    if (!player.isCreative()) {
                        ItemStack emptyBottle = new ItemStack(Items.GLASS_BOTTLE);
                        stack.shrink(1);
                        if (stack.isEmpty())
                            player.setItemInHand(hand, emptyBottle);
                        else if (!player.getInventory().add(emptyBottle))
                            player.drop(emptyBottle, false);
                    }
                }
            }
        }
        return super.interactLivingEntity(stack, player, target, hand);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("tooltip.workdog.sterilization_potion.usage").withStyle(ChatFormatting.GRAY));
    }
}
