package com.github.kmfisk.workdog.entity.core;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LootingLevelEvent;

public abstract class HuntingDogEntity extends WorkDogEntity {
    private final OwnerHurtTargetGoal ownerHurtTargetGoal = new OwnerHurtTargetGoal(this);
    private final FollowOwnerGoal huntersFollowGoal = new FollowOwnerGoal(this, 1.5D, 4.0F, 2.0F, false);

    public HuntingDogEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    @Override
    public WorkGroup getWorkGroup() {
        return WorkGroup.HUNTING;
    }

    @Override
    public void reassessModeGoals() {
        super.reassessModeGoals();
        this.goalSelector.removeGoal(huntersFollowGoal);
        this.targetSelector.removeGoal(ownerHurtTargetGoal);
        if (getMode() == Mode.WORK) {
            this.goalSelector.addGoal(6, huntersFollowGoal);
            this.targetSelector.addGoal(2, ownerHurtTargetGoal);
        }
    }

    public abstract int getLootingLevel();

    public static void lootingLevelEvent(final LootingLevelEvent event) {
        DamageSource damageSource = event.getDamageSource();
        if (damageSource != null && damageSource.getEntity() instanceof HuntingDogEntity) {
            HuntingDogEntity dog = (HuntingDogEntity) damageSource.getEntity();
            int lootLevel = dog.getLootingLevel();
            event.setLootingLevel(event.getLootingLevel() + lootLevel);
        }
    }
}
