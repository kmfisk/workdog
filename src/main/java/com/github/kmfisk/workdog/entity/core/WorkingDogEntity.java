package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.WorkingDogs;
import com.github.kmfisk.workdog.entity.goal.DogBreedGoal;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
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

    private static final DataParameter<Boolean> IN_HEAT = EntityDataManager.defineId(WorkingDogEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> IS_PREGNANT = EntityDataManager.defineId(WorkingDogEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> BREED_TIMER = EntityDataManager.defineId(WorkingDogEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> PUPPIES = EntityDataManager.defineId(WorkingDogEntity.class, DataSerializers.INT);

    public WorkingDogEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        // todo

        /*if (!this.isFixed())*/
            this.goalSelector.addGoal(9, new DogBreedGoal(this, 1.2D));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(GENDER, false);
        this.entityData.define(LONGHAIR, false);
        this.entityData.define(VARIANT, 0);
        this.entityData.define(IN_HEAT, false);
        this.entityData.define(IS_PREGNANT, false);
        this.entityData.define(BREED_TIMER, 0);
        this.entityData.define(PUPPIES, 0);
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        setGender(Gender.fromBool(random.nextBoolean()));
        setLonghair(random.nextFloat() <= 0.08F);
        setVariant(random.nextInt(getVariantCount()));

        if (getGender() == Gender.FEMALE /*todo: && !isFixed()*/) setTimeCycle("end", random.nextInt(72000));

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

    public void setTimeCycle(String s, int time) {
        if (s.equals("start")) {
            setBreedingStatus("inheat", true);
            setBreedTimer(time);
        }
        if (s.equals("end")) {
            setBreedingStatus("inheat", false);
            setBreedTimer(-time);
        }
        if (s.equals("pregnancy")) {
            setBreedTimer(time);
        }
    }

    public void setBreedingStatus(String string, boolean parTrue) {
        if (string.equals("inheat")) entityData.set(IN_HEAT, parTrue);
        else if (string.equals("ispregnant")) entityData.set(IS_PREGNANT, parTrue);
    }

    public boolean getBreedingStatus(String string) {
        if (string.equals("inheat"))
            return entityData.get(IN_HEAT);
        else if (string.equals("ispregnant"))
            return entityData.get(IS_PREGNANT);
        return false;
    }

    public void setBreedTimer(int time) {
        entityData.set(BREED_TIMER, time);
    }

    public int getBreedTimer() {
        return entityData.get(BREED_TIMER);
    }

    public void setPuppies(int puppies) {
        if (getPuppies() <= 0 || puppies == 0)
            this.entityData.set(PUPPIES, puppies);
        else if (getPuppies() > 0)
            this.entityData.set(PUPPIES, this.getPuppies() + puppies);
    }

    public int getPuppies() {
        return this.entityData.get(PUPPIES);
    }

    public void addFather(WorkingDogEntity father, int size) {
        for (int i = 0; i < size; i++) {
            if (!this.getPersistentData().contains("Father" + i) || (this.getPersistentData().contains("Father" + i) && this.getPersistentData().getCompound("Father" + i).isEmpty())) {
                this.getPersistentData().put("Father" + i, father.saveWithoutId(new CompoundNBT()));
            }
        }
    }

    private void setFather(int i, INBT father) {
        if (this.getPersistentData().contains("Father" + i))
            this.getPersistentData().put("Father" + i, father);
    }

    public CompoundNBT getFather(int i) {
        return this.getPersistentData().getCompound("Father" + i);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putBoolean("Gender", getGender().toBool());
        nbt.putBoolean("Longhair", isLonghair());
        nbt.putInt("Variant", getVariant());

        if (getGender() == Gender.FEMALE) {
            nbt.putBoolean("InHeat", getBreedingStatus("inheat"));
            nbt.putBoolean("IsPregnant", getBreedingStatus("ispregnant"));
            nbt.putInt("Puppies", getPuppies());
            for (int i = 0; i < 5; i++)
                nbt.put("Father" + i, getFather(i));
        }
        nbt.putInt("Timer", getBreedTimer());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT nbt) {
        super.readAdditionalSaveData(nbt);
        setGender(Gender.fromBool(nbt.getBoolean("Gender")));
        setLonghair(nbt.getBoolean("Longhair"));
        setVariant(nbt.getInt("Variant"));

        if (getGender() == Gender.FEMALE /*todo: && !isFixed()*/) {
            setBreedingStatus("inheat", nbt.getBoolean("InHeat"));
            setBreedingStatus("ispregnant", nbt.getBoolean("IsPregnant"));
            setPuppies(nbt.getInt("Puppies"));
            for (int i = 0; i < 5; i++)
                setFather(i, nbt.get("Father" + i));
        }
        /*todo: if (!isFixed())*/
        setBreedTimer(nbt.getInt("Timer"));
    }

    @Override
    public void tick() {
        super.tick();
        if (!level.isClientSide && !isBaby() /*todo: && !isFixed()*/ && getGender() == Gender.FEMALE) { //if female & adult & not fixed
            if (getBreedingStatus("inheat")) //if in heat
                if (getBreedTimer() <= 0) { //and timer is finished (reaching 0 after being in positives)
                    if (!getBreedingStatus("ispregnant")) //and not pregnant
                        setTimeCycle("end", 72000); //sets out of heat for 16 (default) minecraft days
                    else { //or if IS pregnant
                        setTimeCycle("pregnant", 72000); //and heat time runs out, starts pregnancy timer for birth
                        setBreedingStatus("inheat", false); //sets out of heat
                    }
                }
            if (!getBreedingStatus("inheat")) { //if not in heat
                if (getBreedTimer() >= 0) { //and timer is finished (reaching 0 after being in negatives)
                    if (!getBreedingStatus("ispregnant")) //and not pregnant
                        setTimeCycle("start", 48000); //sets in heat for 2 minecraft days
                }
            }
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();

        if (!isBaby() /*todo: && !isFixed()*/) { //if not a child & not fixed
            int breedTimer = getBreedTimer();
            if (getGender() == Gender.FEMALE) {
                if (getBreedingStatus("inheat") || getBreedingStatus("ispregnant")) {
                    --breedTimer;
                    if (getBreedingStatus("inheat")) {
                        if (breedTimer % 10 == 0) {

                            double d0 = random.nextGaussian() * 0.02D;
                            double d1 = random.nextGaussian() * 0.02D;
                            double d2 = random.nextGaussian() * 0.02D;
                            level.addParticle(ParticleTypes.HEART, getRandomX(1.0D), getRandomY() + 0.5D, getRandomZ(1.0D), d0, d1, d2);
                        }
                    }
                } else if (!getBreedingStatus("inheat") && !getBreedingStatus("ispregnant"))
                    ++breedTimer;
            } else if (getGender() == Gender.MALE) {
                if (breedTimer > 0)
                    --breedTimer;
                else if (breedTimer <= 0)
                    breedTimer = 0;
            }
            setBreedTimer(breedTimer);
        }
    }

    @Override
    public boolean canMate(AnimalEntity entity) {
        if (entity == this)
            return false;
        if (!(entity instanceof WorkingDogEntity))
            return false;
        if (entity.isBaby() || isBaby())
            return false;
        if (isOrderedToSit() || ((WorkingDogEntity) entity).isOrderedToSit())
            return false;

        WorkingDogEntity partner = (WorkingDogEntity) entity;
        /*if (partner.isFixed() || isFixed()) todo: neutering
            return false;*/

        if (getGender() == Gender.MALE && getBreedTimer() == 0)
            return (partner.getGender() == Gender.FEMALE && partner.getBreedingStatus("inheat"));
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
                    world.addFreshEntity(new ExperienceOrbEntity(world, getX(), getY(), getZ(), getRandom().nextInt(7) + 1));
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

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (stack.getItem() == Items.STICK) { //todo: remove testing
            if (player.isDiscrete())
                player.displayClientMessage(new StringTextComponent("Longhair: " + isLonghair()), true);
            else if (getGender() == Gender.FEMALE && !getBreedingStatus("ispregnant"))
                player.displayClientMessage(new StringTextComponent("FEMALE, heat: " + getBreedingStatus("inheat") + " // timer: " + getBreedTimer()), true);
            else if (getGender() == Gender.FEMALE)
                player.displayClientMessage(new StringTextComponent("FEMALE, pregnant: " + getBreedingStatus("ispregnant") + " // puppies: " + getPuppies()), true);
            else
                player.displayClientMessage(new StringTextComponent("MALE, timer: " + getBreedTimer()), true);

            return ActionResultType.CONSUME;

        } else if (stack.getItem() == Items.BLAZE_POWDER) { //todo: remove testing
            if (isBaby())
                ageUp((int) ((float) (-getAge() / 20) * 0.8F), true);
            else if (/*!isFixed() &&*/ getBreedTimer() != 0)
                setBreedTimer(getBreedTimer() / 2);

            return ActionResultType.CONSUME;
        }

        return super.mobInteract(player, hand);
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
