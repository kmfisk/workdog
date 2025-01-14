package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.entity.core.HerdingDogEntity;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;

import java.util.EnumSet;

public class FollowHerderGoal extends Goal {
    private final Mob livestock;
    private HerdingDogEntity herder;
    private final PathNavigation navigation;
    private int timeToRecalcPath;
    private float oldWaterCost;

    public FollowHerderGoal(Mob livestockEntity, HerdingDogEntity herdingDogEntity) {
        this.livestock = livestockEntity;
        this.herder = herdingDogEntity;
        this.navigation = livestockEntity.getNavigation();
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        float startDistance = 4.0F;
        if (herder == null) return false;
        else if (livestock instanceof TamableAnimal && ((TamableAnimal) livestock).isOrderedToSit())
            return false;
        else return !(livestock.distanceToSqr(herder) < (double) (startDistance * startDistance));
    }

    @Override
    public boolean canContinueToUse() {
        if (herder.getMode() != WorkDogEntity.Mode.WORK) return false;
        float stopDistance = 2.0F;
        if (navigation.isDone()) return false;
        else if (livestock instanceof TamableAnimal && ((TamableAnimal) livestock).isOrderedToSit())
            return false;
        else return !(livestock.distanceToSqr(herder) <= (double) (stopDistance * stopDistance));
    }

    @Override
    public void start() {
        timeToRecalcPath = 0;
        oldWaterCost = livestock.getPathfindingMalus(BlockPathTypes.WATER);
        livestock.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    @Override
    public void stop() {
        navigation.stop();
        livestock.setPathfindingMalus(BlockPathTypes.WATER, oldWaterCost);
        if (herder.getMode() != WorkDogEntity.Mode.WORK) herder = null;
    }

    @Override
    public void tick() {
        livestock.getLookControl().setLookAt(herder, 10.0F, (float) livestock.getMaxHeadXRot());
        if (--timeToRecalcPath <= 0) {
            timeToRecalcPath = 10;
            if (!livestock.isLeashed() && !livestock.isPassenger()) {
                double speedModifier = 1.0D;
                if (livestock.distanceToSqr(herder) >= 144.0D) teleportToHerder();
                else navigation.moveTo(herder, speedModifier);
            }
        }
    }

    private void teleportToHerder() {
        BlockPos blockpos = herder.blockPosition();
        for (int i = 0; i < 10; ++i) {
            int j = randomIntInclusive(-3, 3);
            int k = randomIntInclusive(-1, 1);
            int l = randomIntInclusive(-3, 3);
            boolean flag = maybeTeleportTo(blockpos.getX() + j, blockpos.getY() + k, blockpos.getZ() + l);
            if (flag) return;
        }
    }

    private boolean maybeTeleportTo(int posX, int posY, int posZ) {
        if (Math.abs((double) posX - herder.getX()) < 2.0D && Math.abs((double) posZ - herder.getZ()) < 2.0D)
            return false;
        else if (!canTeleportTo(new BlockPos(posX, posY, posZ))) return false;
        else {
            livestock.moveTo((double) posX + 0.5D, posY, (double) posZ + 0.5D, livestock.yRot, livestock.xRot);
            navigation.stop();
            return true;
        }
    }

    private boolean canTeleportTo(BlockPos position) {
        LevelReader level = livestock.level;
        BlockPathTypes pathnodetype = WalkNodeEvaluator.getBlockPathTypeStatic(level, position.mutable());
        if (pathnodetype != BlockPathTypes.WALKABLE) return false;
        else {
            BlockState blockstate = level.getBlockState(position.below());
            if (blockstate.getBlock() instanceof LeavesBlock) return false;
            else {
                BlockPos blockpos = position.subtract(livestock.blockPosition());
                return level.noCollision(livestock, livestock.getBoundingBox().move(blockpos));
            }
        }
    }

    private int randomIntInclusive(int min, int max) {
        return livestock.getRandom().nextInt(max - min + 1) + min;
    }
}
