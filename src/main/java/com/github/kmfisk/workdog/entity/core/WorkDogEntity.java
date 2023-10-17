package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.WDWolfEntity;
import com.github.kmfisk.workdog.entity.goal.DogAvoidEntityGoal;
import com.github.kmfisk.workdog.entity.goal.DogBirthGoal;
import com.github.kmfisk.workdog.entity.goal.DogBreedGoal;
import com.github.kmfisk.workdog.entity.goal.DogTemptGoal;
import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
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
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public abstract class WorkDogEntity extends TameableEntity {
    public static final DataParameter<Boolean> GENDER = EntityDataManager.defineId(WorkDogEntity.class, DataSerializers.BOOLEAN);
    public static final DataParameter<Boolean> LONGHAIR = EntityDataManager.defineId(WorkDogEntity.class, DataSerializers.BOOLEAN);
    public static final DataParameter<Integer> VARIANT = EntityDataManager.defineId(WorkDogEntity.class, DataSerializers.INT);

    private static final DataParameter<Boolean> FIXED = EntityDataManager.defineId(WorkDogEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> IN_HEAT = EntityDataManager.defineId(WorkDogEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> IS_PREGNANT = EntityDataManager.defineId(WorkDogEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> BREED_TIMER = EntityDataManager.defineId(WorkDogEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> PUPPIES = EntityDataManager.defineId(WorkDogEntity.class, DataSerializers.INT);

    private static final Ingredient FOOD = Ingredient.of(Items.BEEF); //todo: all raw meats.. tag stuff.. stupid ugh
    private DogAvoidEntityGoal<PlayerEntity> avoidPlayersGoal;

    public WorkDogEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(1, new SitGoal(this));
        this.goalSelector.addGoal(3, new DogTemptGoal(this, 0.6D, FOOD, true));
        this.goalSelector.addGoal(6, new DogBirthGoal(this));
        this.goalSelector.addGoal(9, new DogBreedGoal(this, 1.2D));
        this.goalSelector.addGoal(10, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(GENDER, false);
        this.entityData.define(LONGHAIR, false);
        this.entityData.define(VARIANT, 0);
        this.entityData.define(FIXED, false);
        this.entityData.define(IN_HEAT, false);
        this.entityData.define(IS_PREGNANT, false);
        this.entityData.define(BREED_TIMER, 0);
        this.entityData.define(PUPPIES, 0);
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        setGender(Gender.fromBool(random.nextBoolean()));
        setLonghair(random.nextFloat() <= getLonghairChance());
        setVariant(random.nextInt(getVariantCount()));

        if (getGender() == Gender.FEMALE && !isFixed()) setTimeCycle("end", random.nextInt(72000));

        return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
    }

    public Gender getGender() {
        return Gender.fromBool(entityData.get(GENDER));
    }

    public void setGender(Gender gender) {
        entityData.set(GENDER, gender.toBool());
    }

    public abstract boolean hasLonghairVariants();

    public abstract float getLonghairChance();

    public boolean isLonghair() {
        return entityData.get(LONGHAIR);
    }

    public void setLonghair(boolean longhair) {
        entityData.set(LONGHAIR, longhair);
    }

    public abstract int getVariantCount();

    public abstract String getVariantName();

    public abstract int getCarriedVariant(String name);

    public int getVariant() {
        return entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        entityData.set(VARIANT, variant);
    }

    public void setFixed(boolean fixed) {
        this.entityData.set(FIXED, fixed);
    }

    public boolean isFixed() {
        return this.entityData.get(FIXED);
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
            entityData.set(PUPPIES, puppies);
        else if (getPuppies() > 0)
            entityData.set(PUPPIES, getPuppies() + puppies);
    }

    public int getPuppies() {
        return entityData.get(PUPPIES);
    }

    public void addSire(WorkDogEntity sire) {
        if (!getPersistentData().contains("Sire") || (getPersistentData().contains("Sire") && getPersistentData().getCompound("Sire").isEmpty())) {
            CompoundNBT tags = new CompoundNBT();
            sire.save(tags);
            getPersistentData().put("Sire", tags);
        }
    }

    private void setSire(INBT sire) {
        if (getPersistentData().contains("Sire"))
            getPersistentData().put("Sire", sire);
    }

    public CompoundNBT getSire() {
        return getPersistentData().getCompound("Sire");
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putBoolean("Gender", getGender().toBool());
        nbt.putBoolean("Longhair", isLonghair());
        nbt.putInt("Variant", getVariant());

        nbt.putBoolean("Fixed", isFixed());
        if (getGender() == Gender.FEMALE && !isFixed()) {
            nbt.putBoolean("InHeat", getBreedingStatus("inheat"));
            nbt.putBoolean("IsPregnant", getBreedingStatus("ispregnant"));
            nbt.putInt("Puppies", getPuppies());
            nbt.put("Sire", getSire());
        }
        if (!isFixed()) nbt.putInt("Timer", getBreedTimer());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT nbt) {
        super.readAdditionalSaveData(nbt);
        setGender(Gender.fromBool(nbt.getBoolean("Gender")));
        setLonghair(nbt.getBoolean("Longhair"));
        setVariant(nbt.getInt("Variant"));

        setFixed(nbt.getBoolean("Fixed"));
        if (getGender() == Gender.FEMALE && !isFixed()) {
            setBreedingStatus("inheat", nbt.getBoolean("InHeat"));
            setBreedingStatus("ispregnant", nbt.getBoolean("IsPregnant"));
            setPuppies(nbt.getInt("Puppies"));
            setSire(nbt.get("Sire"));
        }
        if (!isFixed()) setBreedTimer(nbt.getInt("Timer"));
    }

    @Override
    public void tick() {
        super.tick();
        if (!level.isClientSide && !isBaby() && !isFixed() && getGender() == Gender.FEMALE) { //if female & adult & not fixed
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

        if (!isBaby() && !isFixed()) { //if not a child & not fixed
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
    public boolean isFood(ItemStack stack) {
        return FOOD.test(stack);
    }

    @Override
    public boolean canMate(AnimalEntity entity) {
        if (entity == this) return false;
        if (!(entity instanceof WorkDogEntity)) return false;
        if (entity.isBaby() || isBaby()) return false;
        if (isOrderedToSit() || ((WorkDogEntity) entity).isOrderedToSit()) return false;

        WorkDogEntity partner = (WorkDogEntity) entity;
        if (partner.isFixed() || isFixed()) return false;

        if (getGender() == Gender.MALE && getBreedTimer() == 0)
            return (partner.getGender() == Gender.FEMALE && partner.getBreedingStatus("inheat"));
        else return false;
    }

    public void setupChildVariant(WorkDogEntity parent1, WorkDogEntity parent2) {
        int variant;
        if (parent1.getType() == parent2.getType()) {
            if (random.nextBoolean()) {
                if (random.nextFloat() <= 0.6F) variant = parent2.getVariant();
                else variant = getCarriedVariant(parent2.getVariantName());
            } else {
                if (random.nextFloat() <= 0.6F) variant = parent1.getVariant();
                else variant = getCarriedVariant(parent1.getVariantName());
            }

        } else {
            if (random.nextFloat() <= 0.6F) variant = parent1.getVariant();
            else variant = getCarriedVariant(parent1.getVariantName());
        }
        setVariant(variant);
    }

    protected void setupChildData(WorkDogEntity parent1, WorkDogEntity parent2) {
        setAge(-72000);
        setGender(Gender.fromBool(random.nextBoolean()));
        boolean longhair;
        if (parent1.isLonghair() && parent2.isLonghair())
            longhair = true;
        else if ((parent1.isLonghair() && !parent2.isLonghair()) || (!parent1.isLonghair() && parent2.isLonghair()))
            longhair = random.nextFloat() <= 0.25F;
        else
            longhair = random.nextFloat() <= 0.08F;
        if (getLonghairChance() == 1.0F) longhair = true;
        else if (getLonghairChance() == 0.0F) longhair = false;
        setLonghair(longhair);
    }

    @Override
    public void spawnChildFromBreeding(ServerWorld world, AnimalEntity entity) {
        if (entity instanceof WorkDogEntity) {
            WorkDogEntity partner = (WorkDogEntity) entity;
            WorkDogEntity child;
            if (getType() == partner.getType() || random.nextBoolean())
                child = (WorkDogEntity) getBreedOffspring(world, partner);
            else child = (WorkDogEntity) partner.getBreedOffspring(world, this);
            final net.minecraftforge.event.entity.living.BabyEntitySpawnEvent event = new net.minecraftforge.event.entity.living.BabyEntitySpawnEvent(this, partner, child);
            final boolean cancelled = net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
            child = (WorkDogEntity) event.getChild();

            if (cancelled) return;

            if (child != null) {
                child.setupChildData(this, partner);
                child.moveTo(getX(), getY(), getZ(), 0.0F, 0.0F);
                world.addFreshEntityWithPassengers(child);
                world.broadcastEntityEvent(this, (byte) 18);

                for (int i = 0; i < 7; ++i) {
                    double d0 = random.nextGaussian() * 0.02D;
                    double d1 = random.nextGaussian() * 0.02D;
                    double d2 = random.nextGaussian() * 0.02D;
                    level.addParticle(ParticleTypes.HEART, getRandomX(1.0D), getRandomY() + 0.5D, getRandomZ(1.0D), d0, d1, d2);
                }

                if (world.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT))
                    world.addFreshEntity(new ExperienceOrbEntity(world, getX(), getY(), getZ(), getRandom().nextInt(7) + 1));
            }
        }
    }

    @Override
    protected void onOffspringSpawnedFromEgg(PlayerEntity player, MobEntity entity) {
        if (entity instanceof WorkDogEntity) {
            WorkDogEntity child = (WorkDogEntity) entity;
            child.setupChildVariant(this, this);
            child.setupChildData(this, this);
        }
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.getItem() == Items.STICK) { //todo: remove testing
            if (player.isDiscrete())
                player.displayClientMessage(new StringTextComponent("Variant: " + getVariant() + " // Longhair: " + isLonghair()), true);
            else {
                StringBuilder debugInfo = new StringBuilder();
                debugInfo.append(getGender() == Gender.MALE ? "MALE, " : "FEMALE, ");
                if (isFixed()) debugInfo.append("fixed: ").append(getBreedTimer());
                else if (getGender() == Gender.MALE) debugInfo.append("timer: ").append(getBreedTimer());
                else if (getBreedingStatus("inheat")) debugInfo.append("in heat for: ").append(getBreedTimer());
                else if (!getBreedingStatus("ispregnant")) debugInfo.append("heat starts in: ").append(getBreedTimer());
                else debugInfo.append("pregnant for: ").append(getBreedTimer()).append(" // puppies: ").append(getPuppies());

                player.displayClientMessage(new StringTextComponent(debugInfo.toString()), true);
            }

            return ActionResultType.CONSUME;

        } else if (stack.getItem() == Items.BLAZE_POWDER && !isFixed() && getBreedTimer() != 0 && !getBreedingStatus("ispregnant")) { //todo: remove testing
            if (getGender() == Gender.MALE) setBreedTimer(0);
            else if (getBreedingStatus("inheat")) setBreedTimer(20);
            else setBreedTimer(-20);
            return ActionResultType.CONSUME;

        } else if (stack.getItem() == Items.MILK_BUCKET && getGender() == Gender.FEMALE && getBreedingStatus("ispregnant")) { //todo: remove testing
            setBreedTimer(20);
            return ActionResultType.CONSUME;

        } else if (stack.getItem() == Items.BONE && isBaby()) { //todo: remove testing
            ageUp(-getAge(), true);
            return ActionResultType.CONSUME;
        }

        List<Item> functionalItems = Arrays.asList(WorkDogItems.CRATE.get(), WorkDogItems.PINK_JUICE.get(),
                WorkDogItems.STERILIZATION_POTION.get(), WorkDogItems.SURRENDER_FORM.get());
        if (functionalItems.contains(stack.getItem())) return ActionResultType.PASS;

        boolean isOwner = isOwnedBy(player);
        boolean canTame = isFood(stack) && !isTame() && (!(this instanceof WDWolfEntity) || (isBaby() && !WorkDogConfig.pedigreeMode.get()));
        if (level.isClientSide) {
            return isOwner || canTame ? ActionResultType.SUCCESS : ActionResultType.PASS;

        } else {
            if (isTame() && isOwner) {
                setOrderedToSit(!isOrderedToSit());
                jumping = false;
                navigation.stop();
                setTarget(null);
                return ActionResultType.CONSUME;

            } else if (canTame) {
                if (!player.abilities.instabuild) stack.shrink(1);

                if (random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    tame(player);
                    navigation.stop();
                    setTarget(null);
                    setOrderedToSit(true);
                    level.broadcastEntityEvent(this, (byte) 7);
                } else level.broadcastEntityEvent(this, (byte) 6);

                return ActionResultType.CONSUME;
            }
        }

        return ActionResultType.PASS;
    }

    @Override
    protected void reassessTameGoals() {
        if (isBaby() || !(this instanceof WDWolfEntity)) {
            if (avoidPlayersGoal == null)
                avoidPlayersGoal = new DogAvoidEntityGoal<>(this, PlayerEntity.class, 16.0F, 0.8D, 1.33D);

            this.goalSelector.removeGoal(avoidPlayersGoal);
            if (!isTame()) this.goalSelector.addGoal(4, avoidPlayersGoal);
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
            return new TranslationTextComponent("data_book." + WorkDog.MOD_ID + ".gender." + name().toLowerCase(Locale.ROOT));
        }
    }
}
