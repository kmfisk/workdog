package com.github.kmfisk.workdog.entity.core;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class WorkingDogEntity extends TameableEntity {
    public static final DataParameter<Integer> VARIANT = EntityDataManager.defineId(WorkingDogEntity.class, DataSerializers.INT);
    public static final DataParameter<Boolean> LONGHAIR = EntityDataManager.defineId(WorkingDogEntity.class, DataSerializers.BOOLEAN);

    public WorkingDogEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
        this.entityData.define(LONGHAIR, false);
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        setVariant(random.nextInt(getVariants()));

        return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
    }

    public abstract int getVariants();

    public int getVariant() {
        return entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        entityData.set(VARIANT, variant);
    }

    public boolean isLonghair() {
        return entityData.get(LONGHAIR);
    }

    public void setLonghair(boolean longhair) {
        entityData.set(LONGHAIR, longhair);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("Variant", this.getVariant());
        nbt.putBoolean("Longhair", this.isLonghair());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT nbt) {
        super.readAdditionalSaveData(nbt);
        setVariant(nbt.getInt("Variant"));
        setLonghair(nbt.getBoolean("Longhair"));
    }
}
