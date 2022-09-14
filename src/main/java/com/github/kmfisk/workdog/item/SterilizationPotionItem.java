package com.github.kmfisk.workdog.item;

import com.github.kmfisk.workdog.entity.core.WorkingDogEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class SterilizationPotionItem extends Item {
    public SterilizationPotionItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
        if (target instanceof WorkingDogEntity) {
            WorkingDogEntity dog = (WorkingDogEntity) target;
            if ((!dog.isTame() || (dog.isTame() && dog.isOwnedBy(player))) && player.isCrouching() && !dog.isFixed()) {
                dog.setFixed(true);
                for (int i = 0; i < 7; ++i) {
                    double d0 = random.nextGaussian() * 0.02D;
                    double d1 = random.nextGaussian() * 0.02D;
                    double d2 = random.nextGaussian() * 0.02D;
                    dog.level.addParticle(ParticleTypes.HAPPY_VILLAGER, dog.getRandomX(1.0D), dog.getRandomY() + 0.5D, dog.getRandomZ(1.0D), d0, d1, d2);
                }
                player.displayClientMessage(new TranslationTextComponent(dog.getGender() == WorkingDogEntity.Gender.FEMALE ? "chat.info.success_fixed_female" : "chat.info.success_fixed_male", dog.getName()), true);

                if (!player.isCreative()) {
                    ItemStack emptyBottle = new ItemStack(Items.GLASS_BOTTLE);
                    stack.shrink(1);
                    if (stack.isEmpty())
                        player.setItemInHand(hand, emptyBottle);
                    else if (!player.inventory.add(emptyBottle))
                        player.drop(emptyBottle, false);
                }
            }
        }
        return super.interactLivingEntity(stack, player, target, hand);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("tooltip.sterilization_potion.usage"));
    }
}
