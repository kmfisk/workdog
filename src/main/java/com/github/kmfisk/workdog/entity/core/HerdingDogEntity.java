package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.entity.goal.FollowHerderGoal;
import com.github.kmfisk.workdog.entity.goal.HerdLivestockGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public abstract class HerdingDogEntity extends WorkDogEntity {
    public List<MobEntity> herding = new ArrayList<>();
    private final FollowOwnerGoal herdersFollowGoal = new FollowOwnerGoal(this, 1.5D, 8.0F, 2.0F, false);
    private final HerdLivestockGoal herdLivestockGoal = new HerdLivestockGoal(this, 1.5F);

    public HerdingDogEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    @Override
    public void reassessModeGoals() {
        super.reassessModeGoals();
        this.goalSelector.removeGoal(herdersFollowGoal);
        this.goalSelector.removeGoal(herdLivestockGoal);
        if (herding != null) herding.clear();
        if (getMode() == Mode.WORK) {
            this.goalSelector.addGoal(6, herdersFollowGoal);
            this.goalSelector.addGoal(7, herdLivestockGoal);
        }
    }

    public void herd(MobEntity livestock) {
        herding.add(livestock);
        livestock.goalSelector.addGoal(6, new FollowHerderGoal(livestock, this));
    }
}
