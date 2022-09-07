package com.github.kmfisk.workdog.entity.goal;

import com.github.kmfisk.workdog.entity.core.WorkingDogEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Optional;

public class DogBirthGoal extends Goal {
    private final WorkingDogEntity mother;
    private WorkingDogEntity sire;
    World level;

    public DogBirthGoal(WorkingDogEntity dogEntity) {
        this.mother = dogEntity;
        this.level = dogEntity.level;
    }

    @Override
    public boolean canUse() {
        if (mother.getGender() != WorkingDogEntity.Gender.FEMALE || !mother.getBreedingStatus("ispregnant") || mother.getBreedingStatus("inheat"))
            return false;

        else if (mother.getBreedTimer() >= 0)
            return false;

        else return !mother.isTame() || mother.getOwner() != null;
    }

    @Override
    public boolean canContinueToUse() {
        return mother.getBreedingStatus("ispregnant");
    }

    @Override
    public void stop() {
        sire = null;
    }

    @Override
    public void tick() {
        Optional<EntityType<?>> sireType = EntityType.by(mother.getSire()); // recreate the saved sire nbt data
        if (sireType.isPresent()) {
            Entity entity = sireType.get().create(level);
            entity.load(mother.getSire());
            if (entity instanceof WorkingDogEntity) {
                sire = (WorkingDogEntity) entity; // create the sire dog for puppy referencing
                for (int i = 0; i < mother.getPuppies(); i++) mother.spawnChildFromBreeding((ServerWorld) level, sire);
            }
        }

        mother.getPersistentData().remove("Sire"); // deletes just used sire data
        mother.setPuppies(0); // resets puppy counter
        mother.setBreedingStatus("ispregnant", false); // ends pregnancy
        mother.setTimeCycle("end", 72000); // sets out of heat timer
    }
}
