package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.EnumSet;
import java.util.Optional;

public class DogBirthGoal extends Goal {
    private final WorkDogEntity mother;
    private WorkDogEntity sire;
    World level;

    public DogBirthGoal(WorkDogEntity dogEntity) {
        this.mother = dogEntity;
        this.level = dogEntity.level;
        this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (mother.getGender() != WorkDogEntity.Gender.FEMALE || !mother.getBreedingStatus("ispregnant") || mother.getBreedingStatus("inheat"))
            return false;

        else if (mother.getBreedTimer() >= WorkDogConfig.pregnancyTimer.get() / 10 || mother.isFixed())
            return false;

        else return !mother.isTame() || mother.getOwner() != null;
    }

    @Override
    public boolean canContinueToUse() {
        return mother.getBreedingStatus("ispregnant") && !mother.isFixed();
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
                        mother.spawnChildFromBreeding((ServerWorld) level, sire);
                }
            }

            mother.getPersistentData().remove("Sire"); // deletes just used sire data
            mother.setPuppies(0); // resets puppy counter
            mother.setBreedingStatus("ispregnant", false); // ends pregnancy
            mother.setTimeCycle("end", WorkDogConfig.heatCooldown.get()); // sets out of heat timer
        }
    }
}
