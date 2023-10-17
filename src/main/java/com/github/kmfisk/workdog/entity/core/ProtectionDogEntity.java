package com.github.kmfisk.workdog.entity.core;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;

public abstract class ProtectionDogEntity extends WorkDogEntity {
    private final FollowOwnerGoal protectorsFollowGoal = new FollowOwnerGoal(this, 1.5D, 4.0F, 2.0F, false);
    private final OwnerHurtByTargetGoal ownerHurtByTargetGoal = new OwnerHurtByTargetGoal(this);
    private final NearestAttackableTargetGoal<LivingEntity> attackNearbyMobsGoal = new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, false, false, (entity) -> entity instanceof IMob);

    public ProtectionDogEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    @Override
    public void reassessModeGoals() {
        super.reassessModeGoals();
        this.goalSelector.removeGoal(protectorsFollowGoal);
        this.goalSelector.removeGoal(ownerHurtByTargetGoal);
        this.goalSelector.removeGoal(attackNearbyMobsGoal);
        if (getMode() == Mode.WORK) {
            this.goalSelector.addGoal(6, protectorsFollowGoal);
            this.goalSelector.addGoal(10, wanderGoal);
            this.targetSelector.addGoal(1, ownerHurtByTargetGoal);
            this.targetSelector.addGoal(3, attackNearbyMobsGoal);
        }
    }
}
