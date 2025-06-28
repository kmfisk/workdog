package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;

import java.util.EnumSet;
import java.util.Optional;

public class DogBirthGoal extends Goal {
    private final WorkDogEntity mother;
    private WorkDogEntity sire;
    Level level;

    public DogBirthGoal(WorkDogEntity dogEntity) {
        this.mother = dogEntity;
        this.level = dogEntity.level();
        this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (mother.getGender() != WorkDogEntity.Gender.FEMALE || !mother.getBreedingStatus(WorkDogEntity.BreedingStatus.PREGNANT) || mother.getBreedingStatus(WorkDogEntity.BreedingStatus.HEAT))
            return false;

        else if (mother.getBreedTimer() >= WorkDogConfig.pregnancyTimer.get() / 10 || mother.isInfertile())
            return false;

        else return !mother.isTame() || mother.getOwner() != null;
    }

    @Override
    public boolean canContinueToUse() {
        return mother.getBreedingStatus(WorkDogEntity.BreedingStatus.PREGNANT) && !mother.isInfertile();
    }

    @Override
    public void start() {
        mother.setLying(true);
    }

    @Override
    public void stop() {
        sire = null;
        mother.setLying(false);
    }

    @Override
    public void tick() {
        if (mother.getBreedTimer() <= 0) {
            Optional<EntityType<?>> sireType = EntityType.by(mother.getSire()); // recreate the saved sire nbt data
            if (sireType.isPresent()) {
                Entity entity = sireType.get().create(level);
                entity.load(mother.getSire());
                if (entity instanceof WorkDogEntity) {
                    sire = (WorkDogEntity) entity; // create the sire dog for puppy referencing
                    for (int i = 0; i < mother.getPuppies(); i++)
                        mother.spawnChildFromBreeding((ServerLevel) level, sire);
                }
            }

            mother.getPersistentData().remove("Sire"); // deletes just used sire data
            mother.setPuppies(0); // resets puppy counter
            mother.setBreedingStatus(WorkDogEntity.BreedingStatus.PREGNANT, false); // ends pregnancy
            mother.setHeatCycle(false, WorkDogConfig.heatCooldown.get()); // sets out of heat timer

            int litters = mother.getLitters() + 1;
            mother.setLitters(litters);
            if (litters >= 5 && (mother.getRandom().nextInt(4) == 0 || WorkDogConfig.pedigreeMode.get() && mother.getRandom().nextBoolean()))
                mother.setInfertile(true);
        }
    }
}
