package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.WorkingDogs;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.Stats;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Locale;

public abstract class WorkingDogEntity extends TameableEntity {
    public static final DataParameter<Boolean> GENDER = EntityDataManager.defineId(WorkingDogEntity.class, DataSerializers.BOOLEAN);
    public static final DataParameter<Boolean> LONGHAIR = EntityDataManager.defineId(WorkingDogEntity.class, DataSerializers.BOOLEAN);
    public static final DataParameter<Integer> VARIANT = EntityDataManager.defineId(WorkingDogEntity.class, DataSerializers.INT);

    public WorkingDogEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        // todo
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(GENDER, false);
        this.entityData.define(LONGHAIR, false);
        this.entityData.define(VARIANT, 0);
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        setGender(Gender.fromBool(random.nextBoolean()));
        setLonghair(random.nextFloat() <= 0.08F);
        setVariant(random.nextInt(getVariantCount()));

        return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
    }

    public Gender getGender() {
        return Gender.fromBool(entityData.get(GENDER));
    }

    public void setGender(Gender gender) {
        entityData.set(GENDER, gender.toBool());
    }

    public abstract boolean hasLonghair();

    public boolean isLonghair() {
        return entityData.get(LONGHAIR);
    }

    public void setLonghair(boolean longhair) {
        entityData.set(LONGHAIR, longhair);
    }

    public abstract int getVariantCount();

    public int getVariant() {
        return entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        entityData.set(VARIANT, variant);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putBoolean("Gender", this.getGender().toBool());
        nbt.putBoolean("Longhair", this.isLonghair());
        nbt.putInt("Variant", this.getVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT nbt) {
        super.readAdditionalSaveData(nbt);
        setGender(Gender.fromBool(nbt.getBoolean("Gender")));
        setLonghair(nbt.getBoolean("Longhair"));
        setVariant(nbt.getInt("Variant"));
    }

    @Override
    public boolean canMate(AnimalEntity entity) {
        if (entity == this)
            return false;
        if (!(entity instanceof WorkingDogEntity))
            return false;
        if (entity.isBaby() || this.isBaby())
            return false;
        if (this.isOrderedToSit() || ((WorkingDogEntity) entity).isOrderedToSit())
            return false;

        WorkingDogEntity partner = (WorkingDogEntity) entity;
        /*if (partner.isFixed() || this.isFixed()) todo: neutering
            return false;*/

        if (this.getGender() == Gender.MALE /*&& this.getMateTimer() == 0 todo: male breeding cooldown*/)
            return (partner.getGender() == Gender.FEMALE /*&& partner.getBreedingStatus("inheat") todo: female heat cycle*/);
        else
            return false;
    }

    @Override
    public void spawnChildFromBreeding(ServerWorld world, AnimalEntity entity) {
        if (entity instanceof WorkingDogEntity) {
            WorkingDogEntity partner = (WorkingDogEntity) entity;
            WorkingDogEntity baby = (WorkingDogEntity) getBreedOffspring(world, partner);
            final net.minecraftforge.event.entity.living.BabyEntitySpawnEvent event = new net.minecraftforge.event.entity.living.BabyEntitySpawnEvent(this, partner, baby);
            final boolean cancelled = net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
            baby = (WorkingDogEntity) event.getChild();

            if (cancelled) {
                setAge(6000);
                partner.setAge(6000);
                resetLove();
                partner.resetLove();
                return;
            }

            if (baby != null) {
                ServerPlayerEntity serverplayerentity = getLoveCause();
                if (serverplayerentity == null && partner.getLoveCause() != null)
                    serverplayerentity = partner.getLoveCause();

                if (serverplayerentity != null) {
                    serverplayerentity.awardStat(Stats.ANIMALS_BRED);
                    CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this, partner, baby);
                }

                setAge(6000);
                partner.setAge(6000);
                resetLove();
                partner.resetLove();
                baby.setBaby(true);
                baby.setGender(Gender.fromBool(random.nextBoolean()));
                boolean longhair;
                if (isLonghair() && partner.isLonghair())
                    longhair = true;
                else if ((isLonghair() && !partner.isLonghair()) || (!isLonghair() && partner.isLonghair()))
                    longhair = random.nextFloat() <= 0.25F;
                else
                    longhair = random.nextFloat() <= 0.08F;
                baby.setLonghair(longhair);
                baby.setVariant(random.nextInt(getVariantCount())); // todo: coat "genetics"
                baby.moveTo(getX(), getY(), getZ(), 0.0F, 0.0F);
                world.addFreshEntityWithPassengers(baby);
                world.broadcastEntityEvent(this, (byte) 18);
                if (world.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT))
                    world.addFreshEntity(new ExperienceOrbEntity(world, this.getX(), this.getY(), this.getZ(), this.getRandom().nextInt(7) + 1));
            }
        }
    }

    @Override
    protected void onOffspringSpawnedFromEgg(PlayerEntity player, MobEntity entity) {
        if (entity instanceof WorkingDogEntity) {
            WorkingDogEntity baby = (WorkingDogEntity) entity;
            baby.setBaby(true);
            baby.setGender(Gender.fromBool(random.nextBoolean()));
            baby.setLonghair(isLonghair() ? random.nextFloat() <= 0.25F : random.nextFloat() <= 0.8F);
            baby.setVariant(random.nextInt(getVariantCount())); // todo: coat "genetics"
        }
    }

    public enum Gender {
        FEMALE,
        MALE;

        public static Gender fromBool(boolean value) {
            return value ? MALE : FEMALE;
        }

        // This is for serialization. Do not use for checking for if this entity is male
        // The fact that true == MALE is an implementation detail that should not be relied on.
        public boolean toBool() {
            return this == MALE;
        }

        public TextComponent getLocalizedName() {
            return new TranslationTextComponent("data_book." + WorkingDogs.MOD_ID + ".gender." + name().toLowerCase(Locale.ROOT));
        }
    }
}
