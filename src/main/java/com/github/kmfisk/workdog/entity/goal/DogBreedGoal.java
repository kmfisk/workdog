package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.entity.core.WorkingDogEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.List;

public class DogBreedGoal extends Goal {
    private static final EntityPredicate PARTNER_TARGETING = (new EntityPredicate()).range(8.0D).allowInvulnerable().allowSameTeam().allowUnseeable();
    private static final double NEARBY_RADIUS_CHECK = 16.0D;
    private final double moveSpeed;
    private final WorkingDogEntity dog;
    protected final World level;
    private WorkingDogEntity target;
    private int breedDelay;
    private List<WorkingDogEntity> nearbyDogs;

    public DogBreedGoal(WorkingDogEntity entityDog, double speed) {
        this.dog = entityDog;
        this.level = entityDog.level;
        this.moveSpeed = speed;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        if (dog.getGender() == WorkingDogEntity.Gender.FEMALE) return false;
        if (dog.getIsFixed()) return false;

        nearbyDogs = level.getEntitiesOfClass(WorkingDogEntity.class, dog.getBoundingBox().inflate(NEARBY_RADIUS_CHECK));
        /*if (nearbyDogs.size() >= SCConfig.breeding_limit.get()) todo: breeding limit?
            return false;*/

        LivingEntity dogOwner = dog.getOwner();
        if (/*todo: ownerExceedsLimit(dog, dogOwner) ||*/ ownerIsOffline(dog, dogOwner) || dog.getBreedTimer() > 0)
            return false;

        target = getNearbyMate();
        if (target != null && dog.getSensing().canSee(target) && target.getBreedingStatus("inheat")) {
            if (!target.isTame()) return true;
            LivingEntity targetOwner = target.getOwner();
            return /*todo: !ownerExceedsLimit(target, targetOwner) &&*/ !ownerIsOffline(target, targetOwner);
        }

        return false;
    }

    @Override
    public boolean canContinueToUse() {
        if (dog.isOrderedToSit() || target.isOrderedToSit()) return false;
        if (dog.isFixed() || target.isFixed()) return false;

        boolean maleCooldownCheck = dog.getGender() == WorkingDogEntity.Gender.MALE && dog.getBreedTimer() == 0;
        boolean femaleHeatCheck = target.getGender() == WorkingDogEntity.Gender.FEMALE && target.getBreedingStatus("inheat");

        nearbyDogs = level.getEntitiesOfClass(WorkingDogEntity.class, dog.getBoundingBox().inflate(NEARBY_RADIUS_CHECK));

        return maleCooldownCheck && target.isAlive() && femaleHeatCheck && breedDelay < 60
                /*todo: && nearbyDogs.size() < SCConfig.breeding_limit.get()*/ && dog.getSensing().canSee(target);
    }

    /*private boolean ownerExceedsLimit(WorkingDogEntity tamedDog, LivingEntity owner) { todo: taming limits?
        return tamedDog != null && tamedDog.isTame() && SCConfig.tamed_limit.get() != 0 && owner != null && owner.getPersistentData().getInt("CatCount") >= SCConfig.tamed_limit.get();
    }*/

    private boolean ownerIsOffline(WorkingDogEntity tamedDog, LivingEntity owner) {
        return tamedDog != null && tamedDog.isTame() && owner == null;
    }

    @Override
    public void stop() {
        target = null;
        breedDelay = 0;
        nearbyDogs.clear();
    }

    @Override
    public void tick() {
        dog.getLookControl().setLookAt(target, 10.0F, (float) dog.getMaxHeadXRot());
        target.getLookControl().setLookAt(dog, 10.0F, (float) target.getMaxHeadXRot());
        dog.getNavigation().moveTo(target, moveSpeed);
        target.getNavigation().moveTo(dog, moveSpeed);
        ++breedDelay;

        if (breedDelay >= 60 && dog.distanceToSqr(target) < 4.0D) startPregnancy(); // 100% chance of success
    }

    private WorkingDogEntity getNearbyMate() {
        List<WorkingDogEntity> list = level.getNearbyEntities(WorkingDogEntity.class, PARTNER_TARGETING, dog, dog.getBoundingBox().inflate(NEARBY_RADIUS_CHECK));
        double d0 = Double.MAX_VALUE;
        WorkingDogEntity entityDog = null;

        if (dog.getGender() == WorkingDogEntity.Gender.MALE) {
            for (WorkingDogEntity dog1 : list) {
                if (dog.canMate(dog1) && dog.distanceToSqr(dog1) < d0) {
                    entityDog = dog1;
                    d0 = dog.distanceToSqr(dog1);
                }
            }
        }

        return entityDog;
    }

    private void startPregnancy() {
        int litterSize = level.random.nextInt(4) + 1; // at least 1 puppies, max of 4
        target.setBreedingStatus("ispregnant", true);
        target.setPuppies(target.getRandom().nextFloat() <= 0.1F ? 0 : litterSize);
        target.addSire(dog); // save sire nbt data to mother dog for each puppy added to litterSize
        target.setBreedingStatus("inheat", false); // 100% chance ends heat
        target.setTimeCycle("pregnancy", 72000); // starts pregnancy timer
    }
}
