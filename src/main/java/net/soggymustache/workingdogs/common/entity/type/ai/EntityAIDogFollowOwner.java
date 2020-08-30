package net.soggymustache.workingdogs.common.entity.type.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.world.World;
import net.soggymustache.workingdogs.common.entity.type.base.EntityWorkingDog;

public class EntityAIDogFollowOwner extends EntityAIBase {

	private final EntityWorkingDog tameable;
	private EntityLivingBase owner;
	World world;
	private final double followSpeed;
	private final PathNavigate petPathfinder;
	private int timeToRecalcPath;
	float maxDist;
	float minDist;
	private float oldWaterCost;

	public EntityAIDogFollowOwner(EntityWorkingDog tameableIn, double followSpeedIn, float minDistIn, float maxDistIn) {
		this.tameable = tameableIn;
		this.world = tameableIn.world;
		this.followSpeed = followSpeedIn;
		this.petPathfinder = tameableIn.getNavigator();
		this.minDist = minDistIn;
		this.maxDist = maxDistIn;
		this.setMutexBits(3);

		if (!(tameableIn.getNavigator() instanceof PathNavigateGround) && !(tameableIn.getNavigator() instanceof PathNavigateFlying)) {
			throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
		}
	}

	public boolean shouldExecute() {
		return false;
		/*
		EntityLivingBase entitylivingbase = this.tameable.getOwner();

		if (entitylivingbase == null) {
			return false;
		} else if (entitylivingbase instanceof EntityPlayer && ((EntityPlayer) entitylivingbase).isSpectator()) {
			return false;
		} else if (this.tameable.isSitting()) {
			return false;
		} else if (this.tameable.getDistanceSq(entitylivingbase) < (double) (this.minDist * this.minDist)) {
			return false;
		} else {
			this.owner = entitylivingbase;
			return true;
		}
		 */
	}

	public boolean shouldContinueExecuting() {
		return !this.petPathfinder.noPath() && this.tameable.getDistanceSq(this.owner) > (double) (this.maxDist * this.maxDist) && !this.tameable.isSitting();
	}

	public void startExecuting() {
		this.timeToRecalcPath = 0;
		this.oldWaterCost = this.tameable.getPathPriority(PathNodeType.WATER);
		this.tameable.setPathPriority(PathNodeType.WATER, 0.0F);
	}

	public void resetTask() {
//        this.tameable.stopRunning();
		this.owner = null;
		this.petPathfinder.clearPath();
		this.tameable.setPathPriority(PathNodeType.WATER, this.oldWaterCost);
	}

	public void updateTask() {
		this.tameable.getLookHelper().setLookPositionWithEntity(this.owner, 10.0F, (float) this.tameable.getVerticalFaceSpeed());

		if (!this.tameable.isSitting()) {
			if (--this.timeToRecalcPath <= 0) {
				this.timeToRecalcPath = 10;

				if (!this.petPathfinder.tryMoveToEntityLiving(this.owner, this.followSpeed)) {
				    //TODO Make the dog whine/whimper
				}
			}
		}
	}
}