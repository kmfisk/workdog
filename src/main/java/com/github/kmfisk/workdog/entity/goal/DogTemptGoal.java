package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.entity.WDWolfEntity;
import com.github.kmfisk.workdog.entity.core.WorkingDogEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;

import javax.annotation.Nullable;

public class DogTemptGoal extends TemptGoal {
    @Nullable
    private PlayerEntity selectedPlayer;
    private final WorkingDogEntity dog;

    public DogTemptGoal(WorkingDogEntity dog, double speedModifier, Ingredient items, boolean canScare) {
        super(dog, speedModifier, items, canScare);
        this.dog = dog;
    }

    @Override
    public void tick() {
        super.tick();
        if (selectedPlayer == null && mob.getRandom().nextInt(600) == 0)
            selectedPlayer = player;

        else if (mob.getRandom().nextInt(500) == 0)
            selectedPlayer = null;
    }

    @Override
    protected boolean canScare() {
        return (selectedPlayer == null || !selectedPlayer.equals(player)) && super.canScare();
    }

    @Override
    public boolean canUse() {
        return (!(dog instanceof WDWolfEntity) || dog.isBaby()) && !dog.isTame() && super.canUse();
    }
}
