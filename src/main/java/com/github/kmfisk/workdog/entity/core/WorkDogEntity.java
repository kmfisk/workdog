package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.config.WorkDogConfig;
import com.github.kmfisk.workdog.entity.WDWolfEntity;
import com.github.kmfisk.workdog.entity.goal.*;
import com.github.kmfisk.workdog.item.WorkDogItems;
import com.github.kmfisk.workdog.tags.WorkDogTags;
import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class WorkDogEntity extends AbstractInventoryAnimal {
    public static final EntityDataAccessor<Boolean> GENDER = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> LONGHAIR = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> MODE = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Optional<UUID>> PARENT_ID_0 = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Optional<UUID>> PARENT_ID_1 = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> BREED_TIMER = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> PUPPIES = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> LITTERS = SynchedEntityData.defineId(WorkDogEntity.class, EntityDataSerializers.INT);

    @Nullable
    BlockPos homePos;
    private DogAvoidEntityGoal<Player> avoidPlayersGoal;
    protected WaterAvoidingRandomStrollGoal wanderGoal;
    protected final FollowOwnerGoal followGoal = new FollowOwnerGoal(this, 1.33D, 10.0F, 2.0F, false);

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
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.5D, true));
        this.goalSelector.addGoal(6, new FollowMotherGoal(this, 1.1D));
        this.goalSelector.addGoal(9, new DogBreedGoal(this, 1.2D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    @Override
    protected void reassessTameGoals() {
        if (isBaby() || !(this instanceof WDWolfEntity)) {
            if (avoidPlayersGoal == null)
                avoidPlayersGoal = new DogAvoidEntityGoal<>(this, Player.class, 16.0F, 0.8D, 1.33D);

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
        this.entityData.define(PARENT_ID_0, Optional.empty());
        this.entityData.define(PARENT_ID_1, Optional.empty());
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
        return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
    }

    @Nullable
    public abstract TagKey<EntityType<?>> getWorkGroupTag();

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

    public abstract int getCarriedVariant(int variant);

    public int getVariant() {
        return entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        entityData.set(VARIANT, variant);
    }

    public List<UUID> getParentUUIDs() {
        List<UUID> list = Lists.newArrayList();
        list.add(entityData.get(PARENT_ID_0).orElse(null));
        list.add(entityData.get(PARENT_ID_1).orElse(null));
        return list;
    }

    public void setParentUUID(@Nullable UUID uuid) {
        if (entityData.get(PARENT_ID_0).isPresent()) entityData.set(PARENT_ID_1, Optional.ofNullable(uuid));
        else entityData.set(PARENT_ID_0, Optional.ofNullable(uuid));
    }

    public boolean isMother(UUID uuid) {
        UUID mother = getParentUUIDs().get(0);
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

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putBoolean("Gender", getGender().toBool());
        nbt.putBoolean("Longhair", isLonghair());
        nbt.putInt("Variant", getVariant());

        List<UUID> list = getParentUUIDs();
        ListTag parentNbtList = new ListTag();
        for (UUID uuid : list) {
            if (uuid != null) parentNbtList.add(NbtUtils.createUUID(uuid));
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
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        setGender(Gender.fromBool(nbt.getBoolean("Gender")));
        setLonghair(nbt.getBoolean("Longhair"));
        setVariant(nbt.getInt("Variant"));

        ListTag parentNbtList = nbt.getList("Parents", 11);
        for (Tag inbt : parentNbtList) {
            setParentUUID(NbtUtils.loadUUID(inbt));
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
        setParentUUID(maternal.getUUID());
        setParentUUID(paternal.getUUID());
        if (maternal.isTame() && WorkDogConfig.tamedLimit.get() == 0/* || owner.getPersistentData().getInt("DogCount") < WorkDogConfig.tamedLimit.get()*/)
            tame((Player) maternal.getOwner());
        if (maternal.getHomePos() != null) setHomePos(maternal.getHomePos());
    }

    @Override
    public void spawnChildFromBreeding(ServerLevel world, Animal entity) {
        if (entity instanceof WorkDogEntity sire) {
            AgeableMob childBreedType;
            boolean purebred = getType() == sire.getType();
            if (purebred || random.nextBoolean()) {
                childBreedType = getBreedOffspring(world, sire);
                if (purebred && random.nextInt(100) < 2 && getWorkGroupTag() != null) {
                    Entity newBreed = ForgeRegistries.ENTITY_TYPES.tags().getTag(getWorkGroupTag()).stream().findAny().get().create(world);
                    if (newBreed instanceof WorkDogEntity)
                        childBreedType = ((WorkDogEntity) newBreed).getBreedOffspring(world, this);
                }
            } else childBreedType = sire.getBreedOffspring(world, this);
            if (!purebred && random.nextInt(100) < 5 && getWorkGroupTag() != null) {
                TagKey<EntityType<?>> newBreedTag = random.nextBoolean() && sire.getWorkGroupTag() != null ? sire.getWorkGroupTag() : getWorkGroupTag();
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
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        super.mobInteract(player, hand);
        ItemStack stack = player.getItemInHand(hand);
        List<Item> functionalItems = Arrays.asList(WorkDogItems.CRATE.get(), WorkDogItems.PINK_JUICE.get(),
                WorkDogItems.STERILIZATION_POTION.get(), WorkDogItems.SURRENDER_FORM.get());
        if (functionalItems.contains(stack.getItem())) return InteractionResult.PASS;

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

            } else if (stack.getItem() == WorkDogItems.COLLAR.get()) { //todo
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
                return InteractionResult.SUCCESS;

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
    protected void playStepSound(BlockPos pos, BlockState state) {
        playSound(SoundEvents.WOLF_STEP, 0.15F, 1.0F);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        /*if (isAngry()) return SoundEvents.WOLF_GROWL;
        else*/
        if (random.nextInt(3) == 0)
            return isTame() && getHealth() < getMaxHealth() / 2 ? SoundEvents.WOLF_WHINE : SoundEvents.WOLF_PANT;
        else return SoundEvents.WOLF_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.WOLF_HURT;
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
}
