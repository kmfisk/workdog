package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;

public class FollowMotherGoal extends Goal {
    private final WorkDogEntity puppy;
    private WorkDogEntity mother;
    private final double speedModifier;
    private int timeToRecalcPath;

    public FollowMotherGoal(WorkDogEntity puppy, double speedModifier) {
        this.puppy = puppy;
        this.speedModifier = speedModifier;
    }

    @Override
    public boolean canUse() {
        if (puppy.getAge() >= 0 || puppy.isOrderedToSit()) return false;
        else {
            List<? extends WorkDogEntity> list = puppy.level().getEntitiesOfClass(puppy.getClass(), puppy.getBoundingBox().inflate(8.0D, 4.0D, 8.0D));
            WorkDogEntity dogEntity = null;
            double d0 = Double.MAX_VALUE;

            for (WorkDogEntity dogEntity1 : list) {
                if (dogEntity1.getAge() >= 0) {
                    double d1 = puppy.distanceToSqr(dogEntity1);
                    if (!(d1 > d0) && puppy.isMother(dogEntity1.getUUID())) {
                        d0 = d1;
                        dogEntity = dogEntity1;
                    }
                }
            }

            if (dogEntity == null) return false;
            else if (d0 < 9.0D) return false;
            else {
                mother = dogEntity;
                return true;
            }
        }
    }

    @Override
    public boolean canContinueToUse() {
        if (puppy.getAge() >= 0 || puppy.isOrderedToSit()) return false;
        else if (!mother.isAlive()) return false;
        else {
            double d0 = puppy.distanceToSqr(mother);
            return !(d0 < 9.0D) && !(d0 > 256.0D);
        }
    }

    @Override
    public void start() {
        timeToRecalcPath = 0;
    }

    @Override
    public void stop() {
        mother = null;
    }

    @Override
    public void tick() {
        if (--timeToRecalcPath <= 0) {
            timeToRecalcPath = 10;
            puppy.getNavigation().moveTo(mother, speedModifier);
        }
    }
}
