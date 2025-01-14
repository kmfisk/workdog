package com.github.kmfisk.workdog.entity.goal;

import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.function.Predicate;

public class AttackableTargetRangedGoal<T extends LivingEntity> extends TargetGoal {
    protected final Class<T> targetType;
    protected final int randomInterval;
    protected final double range;
    protected LivingEntity target;
    protected TargetingConditions targetConditions;

    public AttackableTargetRangedGoal(Mob mob, Class<T> targetType, boolean mustSee, boolean mustReach, double range, @Nullable Predicate<LivingEntity> targetConditions) {
        super(mob, mustSee, mustReach);
        this.targetType = targetType;
        this.randomInterval = 10;
        this.range = range;
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
        this.targetConditions = new TargetingConditions().range(range).selector(targetConditions);
    }

    @Override
    public boolean canUse() {
        if (randomInterval > 0 && mob.getRandom().nextInt(randomInterval) != 0) return false;
        else {
            findTarget();
            return target != null;
        }
    }

    protected void findTarget() {
        if (targetType != Player.class && targetType != ServerPlayer.class)
            target = mob.level.getNearestLoadedEntity(targetType, targetConditions, mob, mob.getX(), mob.getEyeY(), mob.getZ(), mob.getBoundingBox().inflate(range, 4.0D, range));
        else
            target = mob.level.getNearestPlayer(targetConditions, mob, mob.getX(), mob.getEyeY(), mob.getZ());
    }

    @Override
    public void start() {
        mob.setTarget(target);
        super.start();
    }
}
