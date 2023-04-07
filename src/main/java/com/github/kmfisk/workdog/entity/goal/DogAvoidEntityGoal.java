package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.util.EntityPredicates;

public class DogAvoidEntityGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {
    private final WorkDogEntity dog;

    public DogAvoidEntityGoal(WorkDogEntity dog, Class<T> avoidClass, float maxDistance, double walkSpeedModifier, double sprintSpeedModifier) {
        super(dog, avoidClass, maxDistance, walkSpeedModifier, sprintSpeedModifier, EntityPredicates.NO_CREATIVE_OR_SPECTATOR::test);
        this.dog = dog;
    }

    @Override
    public boolean canUse() {
        return !dog.isTame() && super.canUse();
    }

    @Override
    public boolean canContinueToUse() {
        return !dog.isTame() && super.canContinueToUse();
    }
}
