package com.github.kmfisk.workdog.entity;

import com.github.kmfisk.workdog.entity.core.WorkingDogEntity;
import com.github.kmfisk.workdog.init.ModEntities;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class BorderCollieEntity extends WorkingDogEntity {
    public BorderCollieEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public PassiveEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        BorderCollieEntity puppy = ModEntities.BORDER_COLLIE.create(serverWorld);
        if (puppy != null) {
            puppy.setVariant(this.random.nextInt(this.getDogData().getMaxVariants()));
            puppy.setShortHair(this.random.nextBoolean());
        }
        return puppy;
    }

    @Override
    public EntityData initialize(ServerWorldAccess serverWorldAccess, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CompoundTag entityTag) {
        entityData = super.initialize(serverWorldAccess, difficulty, spawnReason, entityData, entityTag);
        this.setShortHair(this.random.nextBoolean());
        return entityData;
    }
}
