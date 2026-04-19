package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.WDWolfEntity;
import com.github.kmfisk.workdog.entity.goal.*;
import com.github.kmfisk.workdog.item.DogEquipmentItem;
import com.github.kmfisk.workdog.item.WorkDogItems;
import com.github.kmfisk.workdog.sounds.WorkDogSounds;
import com.github.kmfisk.workdog.tags.WorkDogTags;
import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.DoubleSupplier;

public abstract class WorkDogEntity extends AbstractInventoryAnimal {
    public static final EntityDataAccessor<Boolean> GENDER = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> LONGHAIR = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> MODE = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Integer> BREED_TIMER = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> PUPPIES = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> LITTERS = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.INT);
    private String[] parent1;
    private String[] parent2;
    @Nullable
    BlockPos homePos;
    private double sprintSpeedMod;
    private DogAvoidEntityGoal<Player> avoidPlayersGoal;
    protected WaterAvoidingRandomStrollGoal wanderGoal;
    protected final FollowOwnerGoal followGoal = new FollowOwnerGoal(this, sprintSpeedMod, 10.0F, 2.0F, false);

    public WorkDogEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
        reassessModeGoals();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new DogBirthGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new DogTemptGoal(this, 0.6D));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, getSprintSpeedMod(), true));
        this.goalSelector.addGoal(6, new FollowMotherGoal(this, 1.1D));
        this.goalSelector.addGoal(9, new DogBreedGoal(this, 1.2D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    @Override
    protected void reassessTameGoals() {
        if (isBaby() || !(this instanceof WDWolfEntity)) {
            if (avoidPlayersGoal == null)
                avoidPlayersGoal = new DogAvoidEntityGoal<>(this, Player.class, 16.0F, 0.8D, sprintSpeedMod);

            this.goalSelector.removeGoal(avoidPlayersGoal);
            if (!isTame()) this.goalSelector.addGoal(4, avoidPlayersGoal);
        }
    }

    public void reassessModeGoals() {
        if (wanderGoal == null) wanderGoal = new DogWanderGoal(this, 1.0D, 0.001F);
        this.goalSelector.removeGoal(wanderGoal);
        this.goalSelector.removeGoal(followGoal);
        if (getMode() == Mode.FOLLOW) {
            this.goalSelector.addGoal(6, followGoal);
            this.goalSelector.addGoal(10, wanderGoal);

        } else if (getMode() == Mode.WANDER) this.goalSelector.addGoal(10, wanderGoal);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(GENDER, false);
        this.entityData.define(LONGHAIR, false);
        this.entityData.define(VARIANT, 0);
        this.entityData.define(BREED_TIMER, 0);
        this.entityData.define(PUPPIES, 0);
        this.entityData.define(LITTERS, 0);
        this.entityData.define(MODE, 2);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        setGender(Gender.fromBool(random.nextBoolean()));
        setLonghair(random.nextFloat() <= getLonghairChance());
        int variant = random.nextInt(getVariantCount());
        if (dataTag != null && dataTag.contains("Variant")) variant = dataTag.getInt("Variant");
        setVariant(variant);
        if (getGender() == Gender.FEMALE && !isInfertile()) setHeatCycle(false, WorkDogConfig.heatCooldown.get());
        setMode(Mode.WANDER);
        if (!(this instanceof WDWolfEntity)) {
            Component name;
            if (getGender() == Gender.MALE) name = Component.literal(WorkDogConfig.maleNameStockList.get().get(random.nextInt(WorkDogConfig.maleNameStockList.get().size())));
            else name = Component.literal(WorkDogConfig.femaleNameStockList.get().get(random.nextInt(WorkDogConfig.femaleNameStockList.get().size())));
            setCustomName(name);
        }
        sprintSpeedMod = generateSprintMod(world.getRandom()::nextDouble);
        return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
    }

    public double sprintPredisposition() {
        return 1.8D; //low=1.6, mid=1.8, high=2.0
    }

    public abstract WorkGroup getWorkGroup();

    public abstract Size getSize();

    public abstract Weather getWeatherType();

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

    public abstract int getCarriedVariant(int variant);

    public int getVariant() {
        return entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        entityData.set(VARIANT, variant);
    }

    public List<String> getParentDataList() {
        List<String> list = Lists.newArrayList();
        if (parent1 != null) {
            list.addAll(List.of(parent1));
            list.addAll(List.of(parent2));
        }
        return list;
    }

    public void setParentData(UUID uuid, String name, String variantName, EntityType<?> breed) { // if anyone is reading this, don't. eugh.
        if (parent1 == null) parent1 = new String[]{uuid.toString(), name, variantName, BuiltInRegistries.ENTITY_TYPE.getKey(breed).getPath()};
        else parent2 = new String[]{uuid.toString(), name, variantName, BuiltInRegistries.ENTITY_TYPE.getKey(breed).getPath()};
    }

    public boolean isMother(UUID uuid) {
        String uuidFromData = !getParentDataList().isEmpty() && getParentDataList().size() == 8 ? getParentDataList().get(4) : "";
        UUID mother = uuidFromData.isEmpty() ? null : UUID.fromString(uuidFromData);
        return mother != null && mother.equals(uuid);
    }

    public void setInfertile(boolean infertile) {
        setFlag(8, infertile);
    }

    public boolean isInfertile() {
        return getFlag(8);
    }

    public void setHeatCycle(boolean startHeat, int time) {
        setBreedingStatus(BreedingStatus.HEAT, startHeat);
        setBreedTimer(startHeat ? time : -time);
    }

    public void setBreedingStatus(BreedingStatus breedingStatus, boolean isTrue) {
        if (breedingStatus == BreedingStatus.HEAT) setFlag(16, isTrue);
        else if (breedingStatus == BreedingStatus.PREGNANT) setFlag(32, isTrue);
    }

    public boolean getBreedingStatus(BreedingStatus breedingStatus) {
        if (getGender() == Gender.MALE) return false;
        if (breedingStatus == BreedingStatus.HEAT) return getFlag(16);
        else if (breedingStatus == BreedingStatus.PREGNANT) return getFlag(32);
        else return false;
    }

    private void setFlag(int flagId, boolean isFlag) {
        if (isFlag) entityData.set(DATA_FLAGS_ID, (byte) (entityData.get(DATA_FLAGS_ID) | flagId));
        else entityData.set(DATA_FLAGS_ID, (byte) (entityData.get(DATA_FLAGS_ID) & ~flagId));
    }

    private boolean getFlag(int flagId) {
        return (entityData.get(DATA_FLAGS_ID) & flagId) != 0;
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
            CompoundTag tags = new CompoundTag();
            sire.save(tags);
            getPersistentData().put("Sire", tags);
        }
    }

    private void setSire(Tag sire) {
        if (getPersistentData().contains("Sire"))
            getPersistentData().put("Sire", sire);
    }

    public CompoundTag getSire() {
        return getPersistentData().getCompound("Sire");
    }

    public void setLitters(int litters) {
        entityData.set(LITTERS, litters);
    }

    public int getLitters() {
        return entityData.get(LITTERS);
    }

    public boolean isLying() {
        return getGender() == WorkDogEntity.Gender.FEMALE && getBreedingStatus(WorkDogEntity.BreedingStatus.PREGNANT) && getBreedTimer() < WorkDogConfig.pregnancyTimer.get() / 10;
    }

    public void setMode(Mode mode) {
        this.entityData.set(MODE, mode.ordinal());
        reassessModeGoals();
    }

    public Mode getMode() {
        return Mode.fromOrdinal(this.entityData.get(MODE));
    }

    @Nullable
    public BlockPos getHomePos() {
        return homePos;
    }

    public void setHomePos(BlockPos position) {
        homePos = position;
    }

    public double getSprintSpeedMod() {
        return sprintSpeedMod;
    }

    private double generateSprintMod(DoubleSupplier doubleSupplier) {
        double result = 1.25D + doubleSupplier.getAsDouble() * 0.55D + doubleSupplier.getAsDouble() * 0.55D;
        return (result + sprintPredisposition() * 4) / 5.0D;
    }

    private static double createOffspringSprintMod(double parent1, double parent2, RandomSource randomSource) {
        double min = 1.25D, max = 2.35D;
        parent1 = Mth.clamp(parent1, min, max);
        parent2 = Mth.clamp(parent2, min, max);
        double d0 = Math.abs(parent1 - parent2) + (max - min) * 0.05D; // parent's absolute difference + 5% whole range
        double d1 = (randomSource.nextDouble() + randomSource.nextDouble() + randomSource.nextDouble()) / 3.0D - 0.5D; // -0.5 - 0.5
        double parentAvg = (parent1 + parent2) / 2.0D;
        double result = parentAvg + d0 * d1;
        if (result > max) {
            double d6 = result - max;
            return max - d6;
        } else if (result < min) {
            double d5 = min - result;
            return min + d5;
        } else {
            return result;
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putBoolean("Gender", getGender().toBool());
        nbt.putBoolean("Longhair", isLonghair());
        nbt.putInt("Variant", getVariant());

        List<String> list = getParentDataList();
        ListTag parentNbtList = new ListTag();
        for (String string : list) {
            if (!string.isEmpty()) parentNbtList.add(StringTag.valueOf(string));
        }
        nbt.put("Parents", parentNbtList);

        nbt.putBoolean("Infertile", isInfertile());
        nbt.putInt("Litters", getLitters());
        if (getGender() == Gender.FEMALE) {
            if (!isInfertile()) {
                nbt.putBoolean("InHeat", getBreedingStatus(BreedingStatus.HEAT));
                nbt.putBoolean("IsPregnant", getBreedingStatus(BreedingStatus.PREGNANT));
                nbt.putInt("Puppies", getPuppies());
                nbt.put("Sire", getSire());
            }
        }
        if (!isInfertile()) nbt.putInt("Timer", getBreedTimer());

        nbt.putInt("Mode", getMode().ordinal());
        if (getHomePos() != null) nbt.put("HomePos", NbtUtils.writeBlockPos(getHomePos()));
        nbt.putDouble("SprintMod", sprintSpeedMod == 0 ? generateSprintMod(getRandom()::nextDouble) : sprintSpeedMod);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        setGender(Gender.fromBool(nbt.getBoolean("Gender")));
        setLonghair(nbt.getBoolean("Longhair"));
        setVariant(nbt.getInt("Variant"));

        ListTag parentNbtList = nbt.getList("Parents", 8);
        if (!parentNbtList.isEmpty()) {
            setParentData(UUID.fromString(parentNbtList.get(0).getAsString()), parentNbtList.get(1).getAsString(), parentNbtList.get(2).getAsString(), ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(WorkDog.MOD_ID, parentNbtList.get(3).getAsString())));
            setParentData(UUID.fromString(parentNbtList.get(4).getAsString()), parentNbtList.get(5).getAsString(), parentNbtList.get(6).getAsString(), ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(WorkDog.MOD_ID, parentNbtList.get(7).getAsString())));
        }

        setInfertile(nbt.getBoolean("Infertile"));
        setLitters(nbt.getInt("Litters"));
        if (getGender() == Gender.FEMALE) {
            if (!isInfertile()) {
                setBreedingStatus(BreedingStatus.HEAT, nbt.getBoolean("InHeat"));
                setBreedingStatus(BreedingStatus.PREGNANT, nbt.getBoolean("IsPregnant"));
                setPuppies(nbt.getInt("Puppies"));
                setSire(nbt.get("Sire"));
            }
        }
        if (!isInfertile()) setBreedTimer(nbt.getInt("Timer"));

        setMode(Mode.fromOrdinal(nbt.getInt("Mode")));
        if (nbt.contains("HomePos")) setHomePos(NbtUtils.readBlockPos(nbt.getCompound("HomePos")));
        sprintSpeedMod = nbt.getDouble("SprintMod");
    }

    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide && !isBaby() && !isInfertile() && getGender() == Gender.FEMALE) { //if female & adult & not infertile
            if (getBreedingStatus(BreedingStatus.HEAT)) //if in heat
                if (getBreedTimer() <= 0) { //and timer is finished (reaching 0 after being in positives)
                    if (!getBreedingStatus(BreedingStatus.PREGNANT)) //and not pregnant
                        setHeatCycle(false, WorkDogConfig.heatCooldown.get()); //sets out of heat for 3 (default) minecraft days
                    else { //or if IS pregnant
                        setBreedTimer(WorkDogConfig.pregnancyTimer.get()); //and heat time runs out, starts pregnancy timer for birth
                        setBreedingStatus(BreedingStatus.HEAT, false); //sets out of heat
                    }
                }
            if (!getBreedingStatus(BreedingStatus.HEAT)) { //if not in heat
                if (getBreedTimer() >= 0) { //and timer is finished (reaching 0 after being in negatives)
                    if (!getBreedingStatus(BreedingStatus.PREGNANT)) //and not pregnant
                        setHeatCycle(true, WorkDogConfig.heatTimer.get()); //sets in heat for 2 minecraft days
                }
            }
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();

        if (!isBaby() && !isInfertile()) { //if not a child & not infertile
            int breedTimer = getBreedTimer();
            if (getGender() == Gender.FEMALE) {
                if (getBreedingStatus(BreedingStatus.HEAT) || getBreedingStatus(BreedingStatus.PREGNANT)) {
                    --breedTimer;
                    if (getBreedingStatus(BreedingStatus.HEAT)) {
                        if (breedTimer % 10 == 0) {

                            double d0 = random.nextGaussian() * 0.02D;
                            double d1 = random.nextGaussian() * 0.02D;
                            double d2 = random.nextGaussian() * 0.02D;
                            level().addParticle(ParticleTypes.HEART, getRandomX(1.0D), getRandomY() + 0.5D, getRandomZ(1.0D), d0, d1, d2);
                        }
                    }
                } else if (!getBreedingStatus(BreedingStatus.HEAT) && !getBreedingStatus(BreedingStatus.PREGNANT))
                    ++breedTimer;
            } else if (getGender() == Gender.MALE) {
                if (breedTimer > 0)
                    --breedTimer;
                else breedTimer = 0;
            }
            setBreedTimer(breedTimer);
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(WorkDogTags.RAW_MEATS);
    }

    public boolean canTame(Player player, ItemStack stack) {
        if (isTame()) return false;
        if (WorkDogConfig.tamedLimit.get() != 0 && player.getPersistentData().getInt("DogCount") >= WorkDogConfig.tamedLimit.get())
            return false;
        if (!(this instanceof WDWolfEntity) || (isBaby() && !WorkDogConfig.pedigreeMode.get()))
            return isFood(stack);
        return false;
    }

    @Override
    public boolean canMate(Animal entity) {
        if (entity == this) return false;
        if (!(entity instanceof WorkDogEntity partner)) return false;
        if (entity.isBaby() || isBaby()) return false;
        if (isOrderedToSit() || partner.isOrderedToSit()) return false;

        if (partner.isInfertile() || isInfertile()) return false;

        if (getGender() == Gender.MALE && getBreedTimer() == 0)
            return (partner.getGender() == Gender.FEMALE && partner.getBreedingStatus(BreedingStatus.HEAT));
        else return false;
    }

    public void setupChildVariant(WorkDogEntity maternal, WorkDogEntity paternal) {
        int variant;
        if (getType() != maternal.getType() && getType() != paternal.getType()) {
            variant = random.nextInt(getVariantCount());

        } else if (maternal.getType() == paternal.getType()) {
            WorkDogEntity parent = random.nextBoolean() ? maternal : paternal;
            if (random.nextFloat() <= 0.6F) variant = parent.getVariant();
            else variant = getCarriedVariant(parent.getVariant());

        } else {
            WorkDogEntity parent = getType() == maternal.getType() ? maternal : paternal;
            if (random.nextFloat() <= 0.6F) variant = parent.getVariant();
            else variant = getCarriedVariant(parent.getVariant());
        }

        if (random.nextInt(100) < 1)
            variant = getVariantCount() + (random.nextBoolean() ? 0 : 1);

        setVariant(variant);
    }

    protected void setupChildData(WorkDogEntity maternal, WorkDogEntity paternal) {
        setAge(-WorkDogConfig.puppyMatureTimer.get());
        setGender(Gender.fromBool(random.nextBoolean()));
        boolean longhair;
        if (maternal.isLonghair() && paternal.isLonghair())
            longhair = true;
        else if ((maternal.isLonghair() && !paternal.isLonghair()) || (!maternal.isLonghair() && paternal.isLonghair()))
            longhair = random.nextFloat() <= 0.25F;
        else
            longhair = random.nextFloat() <= 0.08F;
        if (getLonghairChance() == 1.0F) longhair = true;
        else if (getLonghairChance() == 0.0F) longhair = false;
        setLonghair(longhair);
        if (WorkDogConfig.nameBabies.get() && (maternal.hasCustomName() || paternal.hasCustomName()))
            setCustomName(Component.translatable("name.workdog.name_babies", maternal.hasCustomName() ? maternal.getCustomName() : paternal.getCustomName()));
        setParentData(paternal.getUUID(), paternal.getCustomName() != null ? paternal.getName().getString() : "???", paternal.getVariantName(), paternal.getType());
        setParentData(maternal.getUUID(), maternal.getCustomName() != null ? maternal.getName().getString() : "???", maternal.getVariantName(), maternal.getType());
        if (maternal.isTame() && WorkDogConfig.tamedLimit.get() == 0/* || owner.getPersistentData().getInt("DogCount") < WorkDogConfig.tamedLimit.get()*/)
            tame((Player) maternal.getOwner());
        if (maternal.getHomePos() != null) setHomePos(maternal.getHomePos());
        sprintSpeedMod = createOffspringSprintMod(paternal.sprintSpeedMod, maternal.sprintSpeedMod, random);
    }

    @Override
    public void spawnChildFromBreeding(ServerLevel world, Animal entity) {
        if (entity instanceof WorkDogEntity sire) {
            AgeableMob childBreedType;
            boolean purebred = getType() == sire.getType();
            if (purebred || random.nextBoolean()) {
                childBreedType = getBreedOffspring(world, sire);
                if (purebred && random.nextInt(100) < 2 && getWorkGroup() != null) {
                    Entity newBreed = ForgeRegistries.ENTITY_TYPES.tags().getTag(getWorkGroup().getTagKey()).stream().findAny().get().create(world);
                    if (newBreed instanceof WorkDogEntity)
                        childBreedType = ((WorkDogEntity) newBreed).getBreedOffspring(world, this);
                }
            } else childBreedType = sire.getBreedOffspring(world, this);
            if (!purebred && random.nextInt(100) < 5 && getWorkGroup() != null) {
                TagKey<EntityType<?>> newBreedTag = random.nextBoolean() && sire.getWorkGroup() != null ? sire.getWorkGroup().getTagKey() : getWorkGroup().getTagKey();
                Entity newBreed = ForgeRegistries.ENTITY_TYPES.tags().getTag(newBreedTag).stream().findAny().get().create(world);
                if (newBreed instanceof WorkDogEntity)
                    childBreedType = ((WorkDogEntity) newBreed).getBreedOffspring(world, this);
            }
            final net.minecraftforge.event.entity.living.BabyEntitySpawnEvent event = new net.minecraftforge.event.entity.living.BabyEntitySpawnEvent(this, sire, childBreedType);
            final boolean cancelled = net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
            childBreedType = event.getChild();

            if (cancelled) return;

            if (childBreedType instanceof WorkDogEntity child) {
                child.setupChildVariant(this, sire);
                child.setupChildData(this, sire);
                child.moveTo(getX(), getY(), getZ(), 0.0F, 0.0F);
                world.addFreshEntityWithPassengers(child);
                world.broadcastEntityEvent(this, (byte) 18);

                for (int i = 0; i < 7; ++i) {
                    double d0 = random.nextGaussian() * 0.02D;
                    double d1 = random.nextGaussian() * 0.02D;
                    double d2 = random.nextGaussian() * 0.02D;
                    level().addParticle(ParticleTypes.HEART, getRandomX(1.0D), getRandomY() + 0.5D, getRandomZ(1.0D), d0, d1, d2);
                }

                if (world.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT))
                    world.addFreshEntity(new ExperienceOrb(world, getX(), getY(), getZ(), getRandom().nextInt(7) + 1));
            }
        }
    }

    @Override
    protected void onOffspringSpawnedFromEgg(Player player, Mob entity) {
        if (entity instanceof WorkDogEntity child) {
            child.setupChildVariant(this, this);
            child.setupChildData(this, this);
        }
    }

    @Override
    public boolean hurt(DamageSource damageSource, float amount) {
        if (this.isInvulnerableTo(damageSource)) return false;
        else {
            Entity entity = damageSource.getEntity();
            this.setOrderedToSit(false);
            if (entity != null && !(entity instanceof Player) && !(entity instanceof AbstractArrow))
                amount = (amount + 1.0F) / 2.0F;

            return super.hurt(damageSource, amount);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        boolean flag = !isWearingDogEquipmentType(DogEquipmentType.MUZZLE) && entity.hurt(damageSources().mobAttack(this), (float) ((int) getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) doEnchantDamageEffects(this, entity);
        return flag;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        InteractionResult stackInteraction = stack.interactLivingEntity(player, this, hand);
        if (stackInteraction.consumesAction()) return stackInteraction;
        super.mobInteract(player, hand);

        boolean isOwner = isOwnedBy(player);
        if (isTame() && isOwner) {
            if (stack.getItem() == Items.STICK) {
                if (getMode() == Mode.WANDER) { //if (stack.getItem() == Items.SLIME_BALL)
                    setMode(Mode.FOLLOW);
                    player.displayClientMessage(Component.translatable("chat.workdog.follow_mode", getName()), true);
                    return InteractionResult.sidedSuccess(level().isClientSide);
                } else if (getMode() == Mode.FOLLOW) { //if (stack.getItem() == Items.GUNPOWDER) {
                    setMode(Mode.WORK);
                    player.displayClientMessage(Component.translatable("chat.workdog.work_mode", getName()), true);
                    return InteractionResult.sidedSuccess(level().isClientSide);
                } else if (getMode() == Mode.WORK) { //if (stack.getItem() == Items.FEATHER)
                    setMode(Mode.WANDER);
                    player.displayClientMessage(Component.translatable("chat.workdog.wander_mode", getName()), true);
                    return InteractionResult.sidedSuccess(level().isClientSide);
                }
            } else if (isFood(stack) && getHealth() < getMaxHealth()) {
                usePlayerItem(player, hand, stack);
                heal(2.0F);
                return InteractionResult.sidedSuccess(level().isClientSide);

            } else if (stack.getItem() instanceof DogEquipmentItem dogEquipmentItem) {
                if (dogEquipmentItem == WorkDogItems.COLLAR.get()) {
                    if (player.isDiscrete()) {
                        if (getHomePos() != null) {
                            homePos = null;
                            player.displayClientMessage(Component.translatable("chat.info.remove_home", getName()), true);
                        } else {
                            setHomePos(getOnPos());
                            player.displayClientMessage(Component.translatable("chat.info.set_home", getName(), getHomePos().getX(), getHomePos().getY(), getHomePos().getZ()), true);
                        }
                    } else if (getHomePos() != null)
                        player.displayClientMessage(Component.literal(getHomePos().getX() + ", " + getHomePos().getY() + ", " + getHomePos().getZ()), true);
                }
                return InteractionResult.sidedSuccess(level().isClientSide);
            } else if (stack.is(WorkDogItems.SADDLEBAG.get()) || stack.is(Tags.Items.SHEARS)) {
                return InteractionResult.sidedSuccess(level().isClientSide);

            } else if (!isLying() && !player.isSecondaryUseActive()) {
                setOrderedToSit(!isOrderedToSit());
                jumping = false;
                navigation.stop();
                setTarget(null);
                return InteractionResult.sidedSuccess(level().isClientSide);
            }

        } else if (canTame(player, stack)) {
            if (!player.getAbilities().instabuild) stack.shrink(1);

            if (random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                tame(player);
                navigation.stop();
                setTarget(null);
                setOrderedToSit(true);
                this.goalSelector.addGoal(6, followGoal);
                setMode(Mode.FOLLOW);
                level().broadcastEntityEvent(this, (byte) 7);

            } else level().broadcastEntityEvent(this, (byte) 6);
            return InteractionResult.sidedSuccess(level().isClientSide);

        }

        return InteractionResult.PASS;
    }

    @Override
    public int getInventoryColumns() {
        return getSize().getInventoryColumns();
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        playSound(SoundEvents.WOLF_STEP, 0.15F, 1.0F);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        /*if (isAngry()) return SoundEvents.WOLF_GROWL;
        else*/
        if (random.nextInt(3) == 0)
            return isTame() && getHealth() < getMaxHealth() / 2 ? getSize().getHurtSound() : getSize().getIdleSound();
        else if (isBaby() && random.nextInt(3) == 0) return WorkDogSounds.PUPPY_IDLE.get();
        else return null;//getSize().getHappyBarkSound();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return getSize().getHurtSound();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOLF_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }

    @Override
    public int getAmbientSoundInterval() {
        return 240;
    }

    public enum Gender {
        FEMALE,
        MALE;

        public Component getName() {
            return Component.translatable("gui.workdog." + this.name().toLowerCase());
        }

        public static Gender fromBool(boolean value) {
            return value ? MALE : FEMALE;
        }

        // This is for serialization. Do not use for checking for if this entity is male
        // The fact that true == MALE is an implementation detail that should not be relied on.
        public boolean toBool() {
            return this == MALE;
        }
    }

    public enum Mode {
        WORK,
        FOLLOW,
        WANDER;

        public static Mode fromOrdinal(int ordinal) {
            return switch (ordinal) {
                case 0 -> WORK;
                case 1 -> FOLLOW;
                case 2 -> WANDER;
                default -> throw new IllegalStateException("Unexpected value: " + ordinal);
            };
        }
    }

    public enum BreedingStatus {
        HEAT,
        PREGNANT;
    }

    public enum Size {
        LARGE(9, Arrays.asList(WorkDogSounds.MEDIUM_HAPPY.get(), WorkDogSounds.LARGE_IDLE.get(), WorkDogSounds.LARGE_HURT.get(), WorkDogSounds.LARGE_GROWL.get(), WorkDogSounds.LARGE_WARNING.get()/*, WorkDogSounds.LARGE_ATTACK.get()*/)),
        MEDIUM(6, Arrays.asList(WorkDogSounds.MEDIUM_HAPPY.get(), WorkDogSounds.MEDIUM_IDLE.get(), WorkDogSounds.MEDIUM_HURT.get(), WorkDogSounds.LARGE_GROWL.get(), WorkDogSounds.MEDIUM_WARNING.get()/*, WorkDogSounds.MEDIUM_ATTACK.get()*/)), // missing: growl, attack
        SMALL(3, Arrays.asList(WorkDogSounds.TOY_HAPPY.get(), WorkDogSounds.MEDIUM_IDLE.get(), WorkDogSounds.SMALL_HURT.get(), WorkDogSounds.SMALL_GROWL.get(), WorkDogSounds.TOY_WARNING.get()/*, WorkDogSounds.SMALL_ATTACK.get()*/)), // missing: idle, warning, attack
        TOY(0, Arrays.asList(WorkDogSounds.TOY_HAPPY.get(), WorkDogSounds.MEDIUM_IDLE.get(), WorkDogSounds.SMALL_HURT.get(), WorkDogSounds.TOY_GROWL.get(), WorkDogSounds.TOY_WARNING.get()/*, WorkDogSounds.TOY_ATTACK.get()*/)); // missing: idle, hurt, attack

        private final int inventoryColumns;
        private final List<SoundEvent> sounds;

        Size(int inventoryColumns, List<SoundEvent> sounds) {
            this.inventoryColumns = inventoryColumns;
            this.sounds = sounds;
        }

        public int getInventoryColumns() {
            return inventoryColumns;
        }

        public SoundEvent getHappyBarkSound() {
            return sounds.get(0);
        }

        public SoundEvent getIdleSound() {
            return sounds.get(1);
        }

        public SoundEvent getHurtSound() {
            return sounds.get(2);
        }

        public SoundEvent getGrowlSound() {
            return sounds.get(3);
        }

        public SoundEvent getWarningSound() {
            return sounds.get(4);
        }

        /*public SoundEvent getAttackSound() {
            return sounds.get(5);
        }*/
    }

    public enum Weather {
        COLD, TEMPERATE, HOT;
    }
}
