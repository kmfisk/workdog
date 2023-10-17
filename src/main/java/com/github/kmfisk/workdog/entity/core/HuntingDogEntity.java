package com.github.kmfisk.workdog.entity.core;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LootingLevelEvent;

public abstract class HuntingDogEntity extends WorkDogEntity {
    private final OwnerHurtTargetGoal ownerHurtTargetGoal = new OwnerHurtTargetGoal(this);
    private final FollowOwnerGoal huntersFollowGoal = new FollowOwnerGoal(this, 1.5D, 4.0F, 2.0F, false);

    public HuntingDogEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    @Override
    public void reassessModeGoals() {
        super.reassessModeGoals();
        this.goalSelector.removeGoal(ownerHurtTargetGoal);
        this.goalSelector.removeGoal(huntersFollowGoal);
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
