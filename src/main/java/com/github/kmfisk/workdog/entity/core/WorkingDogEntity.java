package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.util.DogDataHandler;
import com.github.kmfisk.workdog.util.DogDataManager;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public abstract class WorkingDogEntity extends TameableEntity {
    private static final TrackedData<Byte> GENDER = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Integer> VARIANT = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> SHORT_HAIR = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> WORK_MODE = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> WORKING_TIME = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> WORKING_TIME_NEXT = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private static final TrackedData<Boolean> IS_SICK = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Byte> GAMINESS = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Byte> AGGRESSION = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Byte> WARINESS = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Byte> VOICE = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Byte> COURAGE = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Byte> PLAYFULNESS = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Byte> HUNTING_SKILL = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Byte> SPEED_MOD = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Byte> DAMAGE = DataTracker.registerData(WorkingDogEntity.class, TrackedDataHandlerRegistry.BYTE);

    //parent ids, stats, neutered, equipment, dog bed location

    private DogData dogData;
    public static final byte RUNNING = 60, RUNNING_OFF = 61;
    private State state;

    private boolean isPanting = false, isRunning;
    private int sneakTimes = 0;
    private int clearSneakIn = 0;
    private boolean sneakLock = false;
    private boolean isGoingToPlayer = false;
//    private EntityFrisbee chasedFrisbee;

    protected WorkingDogEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(this.getDogData().getMaxHealth());
        this.setHealth(this.getDogData().getMaxHealth());
    }

    public DogData getDogData() {
        if (!world.isClient) {
            if (dogData == null) {
                MinecraftServer server = world.getServer();
                if (server != null) {
                    DogDataManager manager = ((DogDataHandler) server).getDogDataManager();
                    this.dogData = manager.getDogData(Registry.ENTITY_TYPE.getId(this.getType()));
                }
            }
            return dogData;
        }
        return null;
    }

    public int getMaxWorkingTime(){
        return 12000;
    }

    public static DefaultAttributeContainer.Builder createDogAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D) //todo dogData speed and damage
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(GENDER, (byte) 0);
        this.dataTracker.startTracking(VARIANT, 1);
        this.dataTracker.startTracking(SHORT_HAIR, true);
        this.dataTracker.startTracking(WORK_MODE, false);
        this.dataTracker.startTracking(GAMINESS, (byte) 0);
    }

    @Override
    public EntityData initialize(ServerWorldAccess serverWorldAccess, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CompoundTag entityTag) {
        entityData = super.initialize(serverWorldAccess, difficulty, spawnReason, entityData, entityTag);
        this.setGender((byte) this.random.nextInt(2));
        if (this.random.nextFloat() <= 0.01F) this.setVariant(0);
        else if (this.random.nextFloat() <= 0.02F) this.setVariant(1);
        else this.setVariant(this.random.nextInt(this.getDogData().getMaxVariants()));
        this.setCustomName(new LiteralText(this.getGender().name() + " " + this.getVariant()));
        return entityData;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) return false;
        else {
            this.setSitting(false);
            return super.damage(source, amount);
        }
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(DamageSource.mob(this), (float)((int)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)));
        if (bl) this.dealDamage(this, target);

        return bl;
    }

    @Override
    public void setTarget(LivingEntity target) {
        super.setTarget(target);
        updateRunning(target != null);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        Item item = stack.getItem();
        return item.isFood() && item.getFoodComponent().isMeat();
    }

    @Override
    public boolean canBreedWith(AnimalEntity other) {
        if (other == this) {
            return false;
        } else if (!(other instanceof WorkingDogEntity)) {
            return false;
        } else {
            WorkingDogEntity otherDog = (WorkingDogEntity) other;
            if (otherDog.getGender() == this.getGender()) return false;
            else if (otherDog.isInSittingPose()) return false;
            else return this.isInLove() && otherDog.isInLove();
        }
    }

    public boolean canBePickedUpBy(Entity entity){
        return this.isBaby() && entity.getPassengerList().isEmpty();
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        if (this.world.isClient) {
            boolean bl = this.isOwner(player) || this.isTamed() || item == Items.BONE && !this.isTamed();
            return bl ? ActionResult.CONSUME : ActionResult.PASS;
        } else {
            if (this.isTamed()) {
                if (itemStack.isEmpty() && this.canBePickedUpBy(player)) {
                    this.setSitting(false);
                    this.setState(State.NONE);
                    this.startRiding(player);
                    return ActionResult.SUCCESS;
                }

                if (this.isBreedingItem(itemStack) && this.getHealth() < this.getMaxHealth()) {
                    if (!player.abilities.creativeMode) itemStack.decrement(1);

                    this.heal((float)item.getFoodComponent().getHunger());
                    return ActionResult.SUCCESS;
                }

                /*if (item == DogItems.WHISTLE) this.setWorking(true);
                else if (item == DogItems.DOG_BOOK) {
                    GuiDogBook.dog = this;
                    player.openGui(DogMain.instance, GuiHandler.GUI.DATA.id, player.world, (int)player.posX, (int)player.posY, (int)player.posZ);

                } else*/ if (!(item instanceof DyeItem)) {
                    ActionResult actionResult = super.interactMob(player, hand);
                    if ((!actionResult.isAccepted() || this.isBaby()) && this.isOwner(player)) {
                        this.setSitting(!this.isSitting());
                        this.setState(this.isSitting() ? State.SITTING : State.NONE);
                        this.jumping = false;
                        this.navigation.stop();
                        this.setTarget(null);
                        return ActionResult.SUCCESS;
                    }

                    return actionResult;
                }

                /*DyeColor dyeColor = ((DyeItem)item).getColor();
                if (dyeColor != this.getCollarColor()) {
                    this.setCollarColor(dyeColor);
                    if (!player.abilities.creativeMode) itemStack.decrement(1);

                    return ActionResult.SUCCESS;
                }*/
            } else if (item == Items.BONE) {
                if (!player.abilities.creativeMode) itemStack.decrement(1);

                if (this.random.nextInt(3) == 0) {
                    this.setOwner(player);
                    this.navigation.stop();
                    this.setTarget(null);
                    this.setSitting(true);
                    this.setState(State.SITTING);
                    this.world.sendEntityStatus(this, (byte)7);
                } else
                    this.world.sendEntityStatus(this, (byte)6);

                return ActionResult.SUCCESS;
            }

            return super.interactMob(player, hand);
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();

        if (!this.world.isClient) {
            BlockPos position = this.getBlockPos();
            this.isPanting = this.world.getBiome(position).getTemperature(position) >= 0.8F;
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isAlive() && this.isTamed()) {
            /*if (!this.isSitting() && !this.hasPlayerRider()) {
                if (chasedFrisbee == null) {
                    List<EntityFrisbee> frisbees = this.world.getEntitiesWithinAABB(EntityFrisbee.class, this.getEntityBoundingBox().grow(20D));
                    if (!frisbees.isEmpty()) {
                        double d = Double.MAX_VALUE;
                        EntityFrisbee frisbee = null;
                        for (EntityFrisbee f : frisbees) {
                            if (this.getDistanceSq(f) < d) {
                                d = getDistanceSq(f);
                                frisbee = f;
                            }
                        }
                        if (frisbee != null) {
                            chasedFrisbee = frisbee;
                        }
                    }
                } else {
                    if (!this.isRunning)
                        this.startRunning();
                    if(!chasedFrisbee.isDead)
                        this.getNavigator().tryMoveToEntityLiving(chasedFrisbee, 1.5D);
                    if (this.getDistanceSq(chasedFrisbee) < 4) {
                        chasedFrisbee.setDead();
                        this.getNavigator().tryMoveToEntityLiving(this.getOwner(), 1.5D);
                    }
                    if(this.getDistanceSq(this.getOwner()) < 9){
                        this.chasedFrisbee = null;
                        this.stopRunning();
                    }
                }
            }*/

            if (this.getOwner() != null) {
                if (this.getOwner().isSleeping())
                    if (this.getState() != State.LYING) this.setState(State.LYING);
                else
                    if (this.getState() != State.SITTING) this.setState(State.SITTING);

                if (!this.isSitting() && !this.hasPlayerRider()) {
                    //20^2
                    if (this.squaredDistanceTo(this.getOwner()) > 6 && this.squaredDistanceTo(this.getOwner()) <= 400) {
                        if (this.getOwner().isSneaking() && !sneakLock) {
                            ++sneakTimes;
                            sneakLock = true;
                            clearSneakIn = 0;
                        }
                        if (!this.getOwner().isSneaking()) sneakLock = false;
                        if (sneakTimes != 0 && clearSneakIn == 0) clearSneakIn = 10;
                        if (clearSneakIn > 0) {
                            clearSneakIn--;
                            if (clearSneakIn <= 1) {
                                sneakTimes = 0;
                                sneakLock = false;
                            }
                        }
                        if (sneakTimes >= 2) {
                            sneakTimes = 0;
                            clearSneakIn = 0;
                            isGoingToPlayer = true;
                        }
                    }

                    if (isGoingToPlayer) {
                        updateRunning(true);
                        this.getNavigation().startMovingTo(this.getOwner(), 1.4D);

                        if (this.squaredDistanceTo(this.getOwner()) < 9) {
                            updateRunning(false);
                            isGoingToPlayer = false;
                        }
                    }
                }
            }

            if (this.isWorking()) {
                if(this.getWorkingTime() <= 0) {
                    this.setWorking(false);
                    //TODO start tired timer
                }
                this.setWorkingTime(this.getWorkingTime() - 1);
                //TODO working task
            }
        }
    }

    @Override
    public void writeCustomDataToTag(CompoundTag tag) {
        super.writeCustomDataToTag(tag);
        tag.putByte("Gender", (byte) this.getGender().ordinal());
        tag.putInt("Variant", this.getVariant());
        tag.putBoolean("ShortHair", this.isShortHair());
        tag.putBoolean("Working", this.isWorking());
        tag.putInt("WorkingTime", this.getWorkingTime());
        tag.putInt("NWorkingTime", this.getNextWorkTime());
        tag.putByte("Gaminess", this.getGaminess());
    }

    @Override
    public void readCustomDataFromTag(CompoundTag tag) {
        super.readCustomDataFromTag(tag);
        this.setGender(tag.getByte("Gender"));
        this.setVariant(tag.getInt("Variant"));
        this.setShortHair(tag.getBoolean("ShortHair"));
        this.setWorking(tag.getBoolean("Working"));
        this.setWorkingTime(tag.getInt("WorkingTime"));
        this.setNextWorkTime(tag.getInt("NWorkingTime"));
        this.setGaminess(tag.getByte("Gaminess"));
    }

    public boolean isShortHair() {
        return this.dataTracker.get(SHORT_HAIR);
    }

    public void setShortHair(boolean shortHair) {
        this.dataTracker.set(SHORT_HAIR, shortHair);
    }

    public Gender getGender() {
        return Gender.values()[this.dataTracker.get(GENDER)];
    }

    public void setGender(byte gender) {
        this.dataTracker.set(GENDER, gender);
    }

    public int getVariant() {
        return this.dataTracker.get(VARIANT);
    }

    public void setVariant(int type) {
        if (type < 0 || type >= this.getDogData().getMaxVariants()) {
            type = this.random.nextInt(this.getDogData().getMaxVariants());
        }

        this.dataTracker.set(VARIANT, type);
    }

    public int getWorkingTime() {
        return this.dataTracker.get(WORKING_TIME);
    }

    public void setWorkingTime(int i) {
        this.dataTracker.set(WORKING_TIME, i);
    }

    public int getNextWorkTime() {
        return this.dataTracker.get(WORKING_TIME_NEXT);
    }

    public void setNextWorkTime(int i) {
        this.dataTracker.set(WORKING_TIME_NEXT, i);
    }

    public boolean isWorking() {
        return this.dataTracker.get(WORK_MODE);
    }

    public void setWorking(boolean working) {
        if (working) this.setWorkingTime(this.getMaxWorkingTime());
        this.dataTracker.set(WORK_MODE, working);
    }

    public byte getGaminess() {
        return this.dataTracker.get(GAMINESS);
    }

    public void setGaminess(byte gaminess) {
        this.dataTracker.set(GAMINESS, gaminess);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        /*if (!this.world.isClient)
            DogPacketHandler.net.sendToAll(new MessageUpdateState(this, state));*/
    }

    public void updateRunning(boolean running) {
        this.isRunning = running;
        this.world.sendEntityStatus(this, running ? RUNNING : RUNNING_OFF);
    }

    @Override
    public void handleStatus(byte status) {
        if (status == RUNNING) isRunning = true;
        else if (status == RUNNING_OFF) isRunning = false;
        else super.handleStatus(status);
    }

    public enum Gender {
        FEMALE, MALE
    }

    public enum State {
        NONE, SITTING, LYING
    }
}
