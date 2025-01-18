package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.entity.WDWolfEntity;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.EnumSet;

public class DogTemptGoal extends Goal {
    private final WorkDogEntity dog;
    protected Player player;
    private final double speedModifier;
    private final float lookDistance;
    private double px;
    private double py;
    private double pz;
    private double pRotX;
    private double pRotY;
    private int lookTime;
    private final TargetingConditions begTargeting;

    public DogTemptGoal(WorkDogEntity dog, double speedModifier) {
        this.dog = dog;
        this.speedModifier = speedModifier;
        this.lookDistance = 10.0F;
        this.begTargeting = TargetingConditions.forNonCombat().range(lookDistance).ignoreLineOfSight();
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        if (dog instanceof WDWolfEntity && !dog.isBaby()) return false;
        player = dog.level().getNearestPlayer(begTargeting, dog);
        return player != null && playerHoldingInteresting(player);
    }

    @Override
    public boolean canContinueToUse() {
        if (!player.isAlive()) return false;
        else if (canScare()) {
            if (dog.distanceToSqr(player) < 36.0D) {
                if (player.distanceToSqr(px, py, pz) > 0.010000000000000002D)
                    return false;
                if (Math.abs((double) player.getXRot() - pRotX) > 5.0D || Math.abs((double) player.getYRot() - pRotY) > 5.0D)
                    return false;
            } else {
                px = player.getX();
                py = player.getY();
                pz = player.getZ();
            }

            pRotX = player.getXRot();
            pRotY = player.getYRot();
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

    private boolean playerHoldingInteresting(Player playerEntity) {
        for (InteractionHand hand : InteractionHand.values()) {
            ItemStack itemstack = playerEntity.getItemInHand(hand);
            if (dog.isFood(itemstack)) return true;
        }

        return false;
    }
}
