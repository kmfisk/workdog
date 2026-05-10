package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.entity.goal.FollowHerderGoal;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public abstract class HerdingDogEntity extends WorkDogEntity {
    public List<Mob> herding = new ArrayList<>();
//    private final HerdLivestockGoal herdLivestockGoal = new HerdLivestockGoal(this, 1.5F);
    private FollowOwnerGoal herdersFollowGoal;

    public HerdingDogEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }

    @Override
    public WorkGroup getWorkGroup() {
        return WorkGroup.HERDING;
    }

    @Override
    public void reassessModeGoals() {
        super.reassessModeGoals();
        if (herdersFollowGoal == null)
            herdersFollowGoal = new FollowOwnerGoal(this, getSprintSpeedMod(), 8.0F, 2.0F, false);
        this.goalSelector.removeGoal(herdersFollowGoal);
//        this.goalSelector.removeGoal(herdLivestockGoal);
//        if (herding != null) herding.clear();
        if (getMode() == Mode.WORK) {
            this.goalSelector.addGoal(6, herdersFollowGoal);
//            this.goalSelector.addGoal(7, herdLivestockGoal);
        }
    }

    public void herd(Mob livestock) {
        herding.add(livestock);
        livestock.goalSelector.addGoal(6, new FollowHerderGoal(livestock, this));
    }
}
