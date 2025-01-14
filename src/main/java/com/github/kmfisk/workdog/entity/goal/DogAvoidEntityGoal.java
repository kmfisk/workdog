package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.EntitySelector;

public class DogAvoidEntityGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {
    private final WorkDogEntity dog;

    public DogAvoidEntityGoal(WorkDogEntity dog, Class<T> avoidClass, float maxDistance, double walkSpeedModifier, double sprintSpeedModifier) {
        super(dog, avoidClass, maxDistance, walkSpeedModifier, sprintSpeedModifier, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test);
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
