package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.entity.goal.AttackableTargetRangedGoal;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;

import static com.github.kmfisk.workdog.tags.WorkDogTags.TERRIER_DOGS;

public abstract class TerrierDogEntity extends WorkDogEntity {
    private final OwnerHurtTargetGoal ownerHurtTargetGoal = new OwnerHurtTargetGoal(this);
    private final FollowOwnerGoal terriersFollowGoal = new FollowOwnerGoal(this, 1.5D, 4.0F, 2.0F, false);
    private final AttackableTargetRangedGoal<LivingEntity> attackNearbyMobsGoal = new AttackableTargetRangedGoal<>(this, LivingEntity.class, false, false, 10.0D, (entity) -> entity instanceof Enemy);

    public TerrierDogEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    @Override
    public TagKey<EntityType<?>> getWorkGroupTag() {
        return TERRIER_DOGS;
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
