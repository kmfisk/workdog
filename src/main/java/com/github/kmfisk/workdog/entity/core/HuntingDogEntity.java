package com.github.kmfisk.workdog.entity.core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LootingLevelEvent;

public abstract class HuntingDogEntity extends WorkDogEntity {
    private final OwnerHurtTargetGoal ownerHurtTargetGoal = new OwnerHurtTargetGoal(this);

    public HuntingDogEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    @Override
    public void reassessModeGoals(Mode mode) {
        super.reassessModeGoals(mode);
        this.goalSelector.removeGoal(ownerHurtTargetGoal);
        if (mode == Mode.WORK) {
            this.goalSelector.addGoal(6, followGoal);
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

    @Override
    public boolean doHurtTarget(Entity p_70652_1_) {
        return super.doHurtTarget(p_70652_1_);
    }
}
