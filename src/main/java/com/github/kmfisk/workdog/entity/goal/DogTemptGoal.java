package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.entity.WDWolfEntity;
import com.github.kmfisk.workdog.entity.core.WorkingDogEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.item.crafting.Ingredient;

public class DogTemptGoal extends TemptGoal {
    private final WorkingDogEntity dog;

    public DogTemptGoal(WorkingDogEntity dog, double speedModifier, Ingredient items, boolean canScare) {
        super(dog, speedModifier, items, canScare);
        this.dog = dog;
    }

    @Override
    public boolean canUse() {
        return (!(dog instanceof WDWolfEntity) || dog.isBaby()) && !dog.isTame() && super.canUse();
    }
}
