package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.entity.WDWolfEntity;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

import java.util.EnumSet;

public class DogTemptGoal extends Goal {
    private final WorkDogEntity dog;
    protected PlayerEntity player;
    private final double speedModifier;
    private final float lookDistance;
    private double px;
    private double py;
    private double pz;
    private double pRotX;
    private double pRotY;
    private int lookTime;
    private final EntityPredicate begTargeting;

    public DogTemptGoal(WorkDogEntity dog, double speedModifier) {
        this.dog = dog;
        this.speedModifier = speedModifier;
        this.lookDistance = 10.0F;
        this.begTargeting = new EntityPredicate().range(lookDistance).allowInvulnerable().allowSameTeam().allowNonAttackable();
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        if (dog instanceof WDWolfEntity && !dog.isBaby()) return false;
        player = dog.level.getNearestPlayer(begTargeting, dog);
        return player != null && playerHoldingInteresting(player);
    }

    @Override
    public boolean canContinueToUse() {
        if (!player.isAlive()) return false;
        else if (canScare()) {
            if (dog.distanceToSqr(player) < 36.0D) {
                if (player.distanceToSqr(px, py, pz) > 0.010000000000000002D)
                    return false;
                if (Math.abs((double) player.xRot - pRotX) > 5.0D || Math.abs((double) player.yRot - pRotY) > 5.0D)
                    return false;
            } else {
                px = player.getX();
                py = player.getY();
                pz = player.getZ();
            }

            pRotX = player.xRot;
            pRotY = player.yRot;
        }

        return lookTime > 0 && playerHoldingInteresting(player);
    }

    protected boolean canScare() {
        return !dog.isTame();
    }

    public void start() {
        px = player.getX();
        py = player.getY();
        pz = player.getZ();
        lookTime = 40 + dog.getRandom().nextInt(40);
    }

    public void stop() {
        player = null;
        dog.getNavigation().stop();
    }

    @Override
    public void tick() {
        dog.getLookControl().setLookAt(player, (float) (dog.getMaxHeadYRot() + 20), (float) dog.getMaxHeadXRot());
        if (dog.distanceToSqr(player) < 6.25D) dog.getNavigation().stop();
        else dog.getNavigation().moveTo(player, speedModifier);
        --lookTime;
    }

    private boolean playerHoldingInteresting(PlayerEntity playerEntity) {
        for (Hand hand : Hand.values()) {
            ItemStack itemstack = playerEntity.getItemInHand(hand);
            if (dog.isFood(itemstack)) return true;
        }

        return false;
    }
}
