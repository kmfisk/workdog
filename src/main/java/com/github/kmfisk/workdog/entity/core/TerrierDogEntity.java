package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.entity.goal.AttackableTargetRangedGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;

public abstract class TerrierDogEntity extends WorkDogEntity {
    private final OwnerHurtTargetGoal ownerHurtTargetGoal = new OwnerHurtTargetGoal(this);
    private final FollowOwnerGoal terriersFollowGoal = new FollowOwnerGoal(this, 1.5D, 4.0F, 2.0F, false);
    private final AttackableTargetRangedGoal<LivingEntity> attackNearbyMobsGoal = new AttackableTargetRangedGoal<>(this, LivingEntity.class, false, false, 10.0D, (entity) -> entity instanceof IMob);

    public TerrierDogEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    @Override
    public void reassessModeGoals() {
        super.reassessModeGoals();
        this.goalSelector.removeGoal(terriersFollowGoal);
        this.targetSelector.removeGoal(ownerHurtTargetGoal);
        this.targetSelector.removeGoal(attackNearbyMobsGoal);
        if (getMode() == Mode.WORK) {
            this.goalSelector.addGoal(6, terriersFollowGoal);
            this.targetSelector.addGoal(2, ownerHurtTargetGoal);
            this.targetSelector.addGoal(3, attackNearbyMobsGoal);
        }
    }
}
