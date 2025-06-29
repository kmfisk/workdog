package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class DogWanderGoal extends WaterAvoidingRandomStrollGoal {
    protected final WorkDogEntity dog;

    public DogWanderGoal(WorkDogEntity dog, double speed, float probability) {
        super(dog, speed, probability);
        this.dog = dog;
    }

    @Override
    public boolean canUse() {
        return super.canUse();
    }

    @Override
    protected @Nullable Vec3 getPosition() {
        boolean outsideBounds = dog.getHomePos() != null && !dog.getHomePos().closerToCenterThan(dog.position(), WorkDogConfig.wanderAreaLimit.get());
        Vec3 defaultPos = DefaultRandomPos.getPos(dog, 10, 7);
        if (dog.isInWaterOrBubble()) {
            Vec3 landPos = LandRandomPos.getPos(dog, 15, 7);
            return landPos == null ? defaultPos : landPos;
        }

        Vec3 pos = null;
        Vec3 towardsHomePos = dog.getHomePos() != null ? LandRandomPos.getPosTowards(dog, 10, 7, dog.getHomePos().getCenter()) : null;
        if (outsideBounds && towardsHomePos != null) return towardsHomePos;
        else if (dog.getRandom().nextFloat() >= probability) {
            pos = LandRandomPos.getPos(dog, 10, 7);

            if (pos != null && dog.getHomePos() != null && !dog.getHomePos().closerToCenterThan(pos, WorkDogConfig.wanderAreaLimit.get()))
                pos = towardsHomePos;
        }

        return pos == null ? defaultPos : pos;
    }
}
