package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.entity.goal.AttackableTargetRangedGoal;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;

import static com.github.kmfisk.workdog.tags.WorkDogTags.PROTECTION_DOGS;

public abstract class ProtectionDogEntity extends WorkDogEntity {
    private final FollowOwnerGoal protectorsFollowGoal = new FollowOwnerGoal(this, 1.5D, 4.0F, 2.0F, false);
    private final OwnerHurtByTargetGoal ownerHurtByTargetGoal = new OwnerHurtByTargetGoal(this);
    private final AttackableTargetRangedGoal<LivingEntity> attackNearbyMobsGoal = new AttackableTargetRangedGoal<>(this, LivingEntity.class, false, false, 10.0D, (entity) -> entity instanceof Enemy);

    public ProtectionDogEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    @Override
    public Tags.IOptionalNamedTag<EntityType<?>> getWorkGroupTag() {
        return PROTECTION_DOGS;
    }

    @Override
    public void reassessModeGoals() {
        super.reassessModeGoals();
        this.goalSelector.removeGoal(protectorsFollowGoal);
        this.targetSelector.removeGoal(ownerHurtByTargetGoal);
        this.targetSelector.removeGoal(attackNearbyMobsGoal);
        if (getMode() == Mode.WORK) {
            this.goalSelector.addGoal(6, protectorsFollowGoal);
            this.goalSelector.addGoal(10, wanderGoal);
            this.targetSelector.addGoal(1, ownerHurtByTargetGoal);
            this.targetSelector.addGoal(3, attackNearbyMobsGoal);
        }
    }
}
