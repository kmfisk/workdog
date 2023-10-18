package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.core.HerdingDogEntity;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

public class HerdLivestockGoal extends Goal {
    private static final EntityPredicate LIVESTOCK_TARGETING = new EntityPredicate().range(16.0D).selector((entity) -> WorkDogConfig.herdersLivestockList.get().contains(Objects.requireNonNull(entity.getType().getRegistryName()).toString()));
    protected final HerdingDogEntity herder;
    protected final World level;
    protected MobEntity livestock;
    private int stareTime;
    private final double speedModifier;

    public HerdLivestockGoal(HerdingDogEntity herdingDogEntity, double speedModifier) {
        this.herder = herdingDogEntity;
        this.level = herdingDogEntity.level;
        this.speedModifier = speedModifier;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        if (herder.getMode() != WorkDogEntity.Mode.WORK) return false;
        livestock = getLivestock();
        return livestock != null;
    }

    @Override
    public boolean canContinueToUse() {
        return livestock.isAlive() && stareTime <= 60 && herder.getMode() == WorkDogEntity.Mode.WORK;
    }

    @Override
    public void stop() {
        livestock = null;
        stareTime = 0;
    }

    @Override
    public void tick() {
        herder.getLookControl().setLookAt(livestock, 10.0F, (float) herder.getMaxHeadXRot());
        herder.getNavigation().moveTo(livestock, speedModifier);
        ++stareTime;
        if (stareTime >= 60 && herder.distanceToSqr(livestock) < 9.0D)
            herder.herd(livestock);
    }

    @Nullable
    private MobEntity getLivestock() {
        List<MobEntity> list = level.getNearbyEntities(MobEntity.class, LIVESTOCK_TARGETING, herder, herder.getBoundingBox().inflate(16.0D));
        double d0 = Double.MAX_VALUE;
        MobEntity livestockPotential = null;

        for (MobEntity livestockPotential1 : list) {
            if (herder.herding.contains(livestockPotential1)) break;
            if (herder.distanceToSqr(livestockPotential1) < d0) {
                livestockPotential = livestockPotential1;
                d0 = herder.distanceToSqr(livestockPotential1);
            }
        }

        return livestockPotential;
    }
}
