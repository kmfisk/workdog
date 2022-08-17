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
    private WorkingDogEntity father;
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
        father = null;
    }

    @Override
    public void tick() {
        for (int i = 0; i < mother.getPuppies(); i++) {
            Optional<EntityType<?>> type = EntityType.by(mother.getFather(i)); // recreate the saved father nbt data
            if (type.isPresent()) {
                Entity entity = type.get().create(level);
                if (entity instanceof WorkingDogEntity) {
                    father = (WorkingDogEntity) entity; // create the father dog for kitten referencing

                    mother.spawnChildFromBreeding((ServerWorld) level, father);
                }
            }
            mother.getPersistentData().remove("Father" + i); // deletes just used father data
        }

        mother.setPuppies(0); // resets kitten counter
        mother.setBreedingStatus("ispregnant", false); // ends pregnancy
        mother.setTimeCycle("end", 72000); // sets out of heat timer
    }
}
