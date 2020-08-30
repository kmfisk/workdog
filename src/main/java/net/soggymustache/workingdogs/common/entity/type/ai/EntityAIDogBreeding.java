package net.soggymustache.workingdogs.common.entity.type.ai;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.soggymustache.bookworm.common.entity.data.Gender;
import net.soggymustache.workingdogs.common.entity.DogData;
import net.soggymustache.workingdogs.common.entity.type.base.EntityWorkingDog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EntityAIDogBreeding extends EntityAIBase {

	private final EntityWorkingDog animal;
	private final Class<? extends EntityWorkingDog> mateClass;
	World world;
	private EntityWorkingDog targetMate;
	int spawnBabyDelay;
	double moveSpeed;

	public EntityAIDogBreeding(EntityWorkingDog animal, double speedIn) {
		this(animal, speedIn, EntityWorkingDog.class);
	}

	public EntityAIDogBreeding(EntityWorkingDog p_i47306_1_, double p_i47306_2_, Class<? extends EntityWorkingDog> p_i47306_4_) {
		this.animal = p_i47306_1_;
		this.world = p_i47306_1_.world;
		this.mateClass = p_i47306_4_;
		this.moveSpeed = p_i47306_2_;
		this.setMutexBits(3);
	}

	public boolean shouldExecute() {
		if (!this.animal.isInLove()) {
			return false;
		} else {
			this.targetMate = this.getNearbyMate();
			return this.targetMate != null;
		}
	}

	public boolean shouldContinueExecuting() {
		return this.targetMate.isEntityAlive() && this.targetMate.isInLove() && this.spawnBabyDelay < 60;
	}

	public void resetTask() {
		this.targetMate = null;
//		this.spawnBabyDelay = 0;
	}

	public void updateTask() {
		this.animal.getLookHelper().setLookPositionWithEntity(this.targetMate, 10.0F, (float) this.animal.getVerticalFaceSpeed());
		this.animal.getNavigator().tryMoveToEntityLiving(this.targetMate, this.moveSpeed);
		++this.spawnBabyDelay;

		if (/*this.spawnBabyDelay >= 60 &&*/ this.animal.getDistanceSq(this.targetMate) < 9.0D) {
			if(animal.getGender().equals(Gender.FEMALE)) //Hacky fix to prevent double spawn
				this.spawnBaby();
		}
	}

	private EntityWorkingDog getNearbyMate() {
		List<EntityWorkingDog> list = this.world.getEntitiesWithinAABB(this.mateClass, this.animal.getEntityBoundingBox().grow(8.0D));
		double d0 = Double.MAX_VALUE;
		EntityWorkingDog a = null;

		for (EntityWorkingDog EntityWorkingDog1 : list) {
			if (this.animal.canMateWith(EntityWorkingDog1) && this.animal.getDistanceSq(EntityWorkingDog1) < d0) {
				a = EntityWorkingDog1;
				d0 = this.animal.getDistanceSq(EntityWorkingDog1);
			}
		}

		return a;
	}

	private void spawnBaby() {
		EntityAgeable entityageable = this.animal.getRNG().nextBoolean() ? this.animal.createChild(this.targetMate) : this.targetMate.createChild(this.animal);
		final net.minecraftforge.event.entity.living.BabyEntitySpawnEvent event = new net.minecraftforge.event.entity.living.BabyEntitySpawnEvent(animal, targetMate, entityageable);
		final boolean cancelled = net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
		entityageable = event.getChild();
		if (cancelled) {
			this.animal.setGrowingAge(6000);
			this.targetMate.setGrowingAge(6000);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			return;
		}

		if (entityageable != null) {
			EntityPlayerMP entityplayermp = this.animal.getLoveCause();

			if(entityageable instanceof EntityWorkingDog){

				EntityWorkingDog dog = (EntityWorkingDog) entityageable;
				//TODO pass down traits

				//60% Chance to be 50% chance of mother/father variant
				if(dog.getRNG().nextFloat() <= 0.6F){
					dog.setVariant(dog.getRNG().nextBoolean() ? animal.getVariant() : targetMate.getVariant());
				}
				else{
					int[] carriesA = new int[] {animal.getVariant()}; //Mother
					int[] carriesB = new int[] {targetMate.getVariant()}; //Father

					//No method, get fucked
					for (DogData.Genetic a : animal.getData().getGenetics())
						if(a.variant == animal.getVariant()) {
							carriesA = a.carries;
							break;
						}

					for (DogData.Genetic a : targetMate.getData().getGenetics()){
						if(a.variant == targetMate.getVariant())
							carriesB = a.carries;
							break;
						}

					List<Integer> a = new ArrayList<>();

					for(int i : carriesA) a.add(i);
					for(int i : carriesB) a.add(i);

					System.out.println(a);
					dog.setVariant(a.get(dog.getRNG().nextInt(a.size())));
				}
			}

			if (entityplayermp == null && this.targetMate.getLoveCause() != null) {
				entityplayermp = this.targetMate.getLoveCause();
			}

			if (entityplayermp != null) {
				entityplayermp.addStat(StatList.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(entityplayermp, this.animal, this.targetMate, entityageable);
			}

			this.animal.setGrowingAge(6000);
			this.targetMate.setGrowingAge(6000);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			entityageable.setGrowingAge(-24000);
			entityageable.setLocationAndAngles(this.animal.posX, this.animal.posY, this.animal.posZ, 0.0F, 0.0F);

			this.world.spawnEntity(entityageable);
			Random random = this.animal.getRNG();

			for (int i = 0; i < 7; ++i) {
				double d0 = random.nextGaussian() * 0.02D;
				double d1 = random.nextGaussian() * 0.02D;
				double d2 = random.nextGaussian() * 0.02D;
				double d3 = random.nextDouble() * (double) this.animal.width * 2.0D - (double) this.animal.width;
				double d4 = 0.5D + random.nextDouble() * (double) this.animal.height;
				double d5 = random.nextDouble() * (double) this.animal.width * 2.0D - (double) this.animal.width;
				this.world.spawnParticle(EnumParticleTypes.HEART, this.animal.posX + d3, this.animal.posY + d4, this.animal.posZ + d5, d0, d1, d2);
			}

			if (this.world.getGameRules().getBoolean("doMobLoot")) {
				this.world.spawnEntity(new EntityXPOrb(this.world, this.animal.posX, this.animal.posY, this.animal.posZ, random.nextInt(7) + 1));
			}
		}
	}
}