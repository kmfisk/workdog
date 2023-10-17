package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.entity.WDWolfEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.world.Difficulty;

import java.util.function.Predicate;

public class WolfTargetNearestGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
    private WDWolfEntity wolf;

    public WolfTargetNearestGoal(WDWolfEntity wolf, Class<T> classTarget, boolean checkSight, Predicate<LivingEntity> targetSelector) {
        super(wolf, classTarget, 10, checkSight, false, targetSelector);
        this.wolf = wolf;
    }

    @Override
    public boolean canUse() {
        if (wolf.level.getDifficulty() == Difficulty.PEACEFUL) return false;
        return super.canUse() && target != null && !target.getClass().equals(wolf.getClass());
    }
}
