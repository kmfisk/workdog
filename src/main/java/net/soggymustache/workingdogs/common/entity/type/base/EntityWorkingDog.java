package net.soggymustache.workingdogs.common.entity.type.base;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityBodyHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.soggymustache.bookworm.client.animation.lerp.AnimationHandler;
import net.soggymustache.bookworm.common.entity.data.Gender;
import net.soggymustache.bookworm.util.BookwormUtils;
import net.soggymustache.workingdogs.DogMain;
import net.soggymustache.workingdogs.client.gui.GuiDogBook;
import net.soggymustache.workingdogs.common.entity.DogData;
import net.soggymustache.workingdogs.common.entity.move.DogBodyHelper;
import net.soggymustache.workingdogs.common.entity.type.ai.EntityAIDogBreeding;
import net.soggymustache.workingdogs.common.entity.type.ai.EntityAIDogFollowOwner;
import net.soggymustache.workingdogs.common.entity.type.projectile.EntityFrisbee;
import net.soggymustache.workingdogs.common.gui.GuiHandler;
import net.soggymustache.workingdogs.common.item.DogItems;
import net.soggymustache.workingdogs.network.DogPacketHandler;
import net.soggymustache.workingdogs.network.packet.MessageUpdateState;

import javax.annotation.Nullable;
import java.util.List;

public abstract class EntityWorkingDog extends EntityTameable {

	public static final DataParameter<Byte> GENDER = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BYTE);
	public static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.VARINT);
	public static final DataParameter<Boolean> LONG_COAT = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BOOLEAN);
	public static final DataParameter<Boolean> IS_WORKING = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BOOLEAN);

	public static final DataParameter<Boolean> IS_SICK = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BOOLEAN);
	public static final DataParameter<Byte> GAMINESS = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BYTE);
	public static final DataParameter<Byte> AGGRESSION = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BYTE);
	public static final DataParameter<Byte> WARINESS = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BYTE);
	public static final DataParameter<Byte> VOICE = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BYTE);
	public static final DataParameter<Byte> COURAGE = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BYTE);
	public static final DataParameter<Byte> PLAYFULNESS = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BYTE);
	public static final DataParameter<Byte> HUNTING_SKILL = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BYTE);
	public static final DataParameter<Byte> SPEED_MOD = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BYTE);
	public static final DataParameter<Byte> DAMAGE = EntityDataManager.createKey(EntityWorkingDog.class, DataSerializers.BYTE);

	//parent ids, stats, neutered, equipment, dog bed location

	public static final byte RUNNING = 60, RUNNING_OFF = 61;
	private State state;

	private boolean isPanting = false, isRunning;
	private int sneakTimes = 0;
	private int clearSneakIn = 0;
	private boolean sneakLock = false;
	private boolean isGoingToPlayer = false;
	private EntityFrisbee chasedFrisbee;

	public AnimationHandler animator = new AnimationHandler();

	public EntityWorkingDog(World worldIn) {
		super(worldIn);
		this.setSize(1.0F, 1.0F);

		if(!this.hasSpawned()){
			this.setGender((byte) this.getRNG().nextInt(2));
			this.setLongHair(this.getRNG().nextBoolean());
//			this.setGaminess();

			//Make the albino and melanistic variants rarer than the others
			if(this.getRNG().nextFloat() <= 0.01F)
				this.setVariant(0);
			else if(this.getRNG().nextFloat() <= 0.02F)
				this.setVariant(1);
			else
				this.setVariant(this.getRNG().nextInt(getData().getMaxVariants()));
		}
		this.setSpawned(true);

		if (worldIn.isRemote) {
			this.animator.abruptStopping = false;

		}
		this.setCustomNameTag(this.getGender().name() + " " + this.getVariant());
	}
	
	public int getMaxWorkingTime(){
		return 12000;
	}

	public void startRunning(){
		this.isRunning = true;
		updateRunning();
	}

	public void stopRunning(){
		this.isRunning = false;
		updateRunning();
	}

	public boolean canBeYeeted(){
		return false;
	}

	public abstract DogData getData();

	@Override
	protected EntityBodyHelper createBodyHelper() {
		return new DogBodyHelper(this);
	}

	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.aiSit = new EntityAISit(this);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.4D, true));
		this.tasks.addTask(6, new EntityAIDogFollowOwner(this, 1.0D, 20.0F, 2.0F));
		this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(10, new EntityAILookIdle(this));
		this.tasks.addTask(7, new EntityAIDogBreeding(this, 1.0D));
//		this.tasks.addTask(10, new EntityAIHurtByTarget(this, false));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.26D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(getData().getMaxHealth());
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}

	@Override
	public void updateRidden() {
		Entity ridingEntity = this.getRidingEntity();
		if(ridingEntity instanceof EntityPlayer) {
			this.motionX = 0.0D;
			this.motionY = 0.0D;
			this.motionZ = 0.0D;
			this.onUpdate();
			if (this.isRiding()) {
				if (ridingEntity.isPassenger(this)) {
					this.rotationYaw = ((EntityPlayer) ridingEntity).renderYawOffset;
					this.rotationYawHead = ((EntityPlayer) ridingEntity).renderYawOffset;
					this.prevRotationYaw = ((EntityPlayer) ridingEntity).renderYawOffset;

					float angle = (float) (((Math.PI / 180)  * ((EntityPlayer) ridingEntity).renderYawOffset) + 157.1F);
					this.setPosition(ridingEntity.posX + (0.7F * MathHelper.sin((float) (Math.PI + angle))), ridingEntity.posY + 0.8D, ridingEntity.posZ + (0.7F * MathHelper.cos(angle)));

					if ((!canBeYeeted() && Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown()) || (ridingEntity.onGround && ridingEntity.isSneaking()) || !((EntityPlayer) ridingEntity).getHeldItemMainhand().isEmpty() || !((EntityPlayer) ridingEntity).getHeldItemOffhand().isEmpty()) {
						this.dismountRidingEntity();
					}
					if(canBeYeeted() && Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown()){
						this.dismountRidingEntity();
						this.motionX = -MathHelper.sin((float) (this.rotationYaw * (Math.PI / 180) + 157.1F)) * 2.0F;
						this.motionZ = MathHelper.cos((float) (this.rotationYaw * (Math.PI / 180) + 157.1F)) * 2.0F;
						this.motionY = 0.4F;
					}
				}
			}
		}
		else{
			super.updateRidden();
		}
	}

	public boolean canBePickedUpBy(Entity entity){
		return this.isChild() && entity.getPassengers().isEmpty();
	}

	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);

		if (this.isTamed()) {
			if (!stack.isEmpty()) {
				//Do stuff
				if(stack.getItem() == DogItems.WHISTLE){
					this.setWorking(true);
				}
				if(stack.getItem() == DogItems.DOG_BOOK){
					GuiDogBook.dog = this;
					player.openGui(DogMain.instance, GuiHandler.GUI.DATA.id, player.world, (int)player.posX, (int)player.posY, (int)player.posZ);
				}
			}
			else{
				if(canBePickedUpBy(player)){
					this.setSitting(false);
					this.startRiding(player);
					return true;
				}
			}

			if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(stack)) {
				this.aiSit.setSitting(!this.isSitting());

				//Why the fuck???
				if(this.isSitting())
					setState(State.NONE);
				else
					setState(State.SIT);

				this.isJumping = false;
				this.navigator.clearPath();
				this.setAttackTarget(null);
			}
		} else if (isTameItem(stack)) {
			if (!player.capabilities.isCreativeMode)
				stack.shrink(1);

			if (!this.world.isRemote) {
				if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
					this.setTamedBy(player);
					this.navigator.clearPath();
					this.setAttackTarget(null);
					this.aiSit.setSitting(true);
					setState(State.SIT);
					this.setHealth(20.0F);
					this.playTameEffect(true);
					this.world.setEntityState(this, (byte) 7);
				} else {
					this.playTameEffect(false);
					this.world.setEntityState(this, (byte) 6);
				}
			}

			return true;
		}
		return super.processInteract(player, hand);
	}

	@Override
	public boolean canMateWith(EntityAnimal otherAnimal) {
		return this.isInLove() && otherAnimal.isInLove() && otherAnimal instanceof EntityWorkingDog && ((EntityWorkingDog) otherAnimal).getGender() != this.getGender();
	}

	public boolean canDoAction(){
		return !this.isSitting() && !this.isRiding();
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		BlockPos position = this.getPosition();
		isPanting = !isChild() && this.world.getBiome(position).getTemperature(position) >= 0.8F;

		if(this.isTamed() && canDoAction()) {
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
		}

		if(this.isTamed() && this.getOwner() != null){
			if(this.getOwner().isPlayerSleeping()) {
				if (this.getState() != State.LYING)
					this.setState(State.LYING);
			}
			else{
				if (this.getState() != State.SIT)
					this.setState(State.SIT);
			}

			if(canDoAction()) {
				//20^2
				if (this.getDistanceSq(this.getOwner()) > 6 && this.getDistanceSq(this.getOwner()) <= 400) {
					if (this.getOwner().isSneaking() && !sneakLock) {
						++sneakTimes;
						sneakLock = true;
						clearSneakIn = 0;
					}
					if (!this.getOwner().isSneaking()) {
						sneakLock = false;
					}
					if (sneakTimes != 0 && clearSneakIn == 0) {
						clearSneakIn = 10;
					}
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
					startRunning();
					this.getNavigator().tryMoveToEntityLiving(this.getOwner(), 1.4D);

					if (this.getDistanceSq(this.getOwner()) < 9) {
						stopRunning();
						isGoingToPlayer = false;
					}
				}
			}
		}

		if(this.isWorking()){
			if(this.getWorkingTime() <= 0) {
				this.setWorking(false);
				//TODO start tired timer
			}

			this.setWorkingTime(this.getWorkingTime() - 1);

			//TODO working task
		}

		//This should be called last
		if (this.world.isRemote) {
			this.animator.onEntityUpdate(this);
		}
	}

	@Override
	public void setAttackTarget(@Nullable EntityLivingBase target) {
		super.setAttackTarget(target);
		isRunning = target != null;
		updateRunning();
	}

	public void updateRunning(){
		this.world.setEntityState(this, isRunning ? RUNNING : RUNNING_OFF);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		super.attackEntityAsMob(entityIn);

		return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 2.0F);
	}

	@Override
	public void handleStatusUpdate(byte id) {
		if(id == RUNNING)
			isRunning = true;
		else if(id == RUNNING_OFF)
			isRunning = false;
		else
			super.handleStatusUpdate(id);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(GENDER, (byte) 0);
		this.dataManager.register(VARIANT, 0);
		this.dataManager.register(GAMINESS, (byte) 0);
		this.dataManager.register(IS_WORKING, false);
		this.dataManager.register(LONG_COAT, false);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		this.setGender(tag.getByte("Gender"));
		this.setVariant(tag.getInteger("Variant"));
		this.setWorking(tag.getBoolean("Working"));
		this.setWorkingTime(tag.getInteger("WorkingTime"));
		this.setNextWorkTime(tag.getInteger("NWorkingTime"));
		this.setGaminess(tag.getByte("Gaminess"));
		this.setLongHair(tag.getBoolean("LongHair"));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setByte("Gender", (byte) this.getGender().ordinal());
		tag.setInteger("Variant", this.getVariant());
		tag.setBoolean("Working", this.isWorking());
		tag.setInteger("WorkingTime", this.getWorkingTime());
		tag.setInteger("NWorkingTime", this.getNextWorkTime());
		tag.setByte("Gaminess", this.getGaminess());
		tag.setBoolean("LongHair", this.hasLongHair());
	}

	public int getWorkingTime(){
		return this.getEntityData().getInteger("WorkingTime");
	}

	public void setWorkingTime(int i){
		this.getEntityData().setInteger("WorkingTime", i);
	}

	public int getNextWorkTime(){
		return this.getEntityData().getInteger("NWorkingTime");
	}

	public void setNextWorkTime(int i){
		this.getEntityData().setInteger("NWorkingTime", i);
	}

	public boolean isWorking(){
		return this.dataManager.get(IS_WORKING);
	}

	public void setWorking(boolean b){
		if(b)
			this.setWorkingTime(this.getMaxWorkingTime());
		this.dataManager.set(IS_WORKING, b);
	}

	public void setSpawned(boolean b){
		this.getEntityData().setBoolean("Spawn", b);
	}

	public boolean hasSpawned(){
		return this.getEntityData().getBoolean("Spawn");
	}

	public boolean isTameItem(ItemStack stack) {
		return stack.getItem() instanceof ItemFood && ((ItemFood) stack.getItem()).isWolfsFavoriteMeat();
	}

	public void setGender(byte b) {
		this.dataManager.set(GENDER, b);
	}

	public void setGender(Gender gender) {
		setGender((byte) gender.ordinal());
	}

	public Gender getGender() {
		return Gender.values()[this.dataManager.get(GENDER)];
	}

	public void setVariant(int variant) {
		this.dataManager.set(VARIANT, variant);
	}

	public int getVariant() {
		return this.dataManager.get(VARIANT);
	}

	public void setGaminess(byte gaminess) {
		this.dataManager.set(GAMINESS, gaminess);
	}

	public byte getGaminess() {
		return this.dataManager.get(GAMINESS);
	}

	public boolean isPanting() {
		return isPanting;
	}

	public boolean isRunning(){
		return isRunning;
	}

	public State getState(){
		return state;
	}

	public byte getAggression(){
		return 0;
	}

	public void setAggression(byte i){

	}

	public byte getWariness(){
		return 0;
	}

	public void setWarniess(byte i){

	}

	public byte getVoiceLevel(){
		return 0;
	}

	public void setVoiceLevel(byte i){

	}

	public byte getCourage(){
		return 0;
	}

	public void setCourage(byte i){

	}

	public byte getPlayfulness(){
		return 0;
	}

	public void setPlayfulness(byte i){

	}

	public byte getHuntingSkill(byte i){
		return 0;
	}

	public void setHuntingSkill(){

	}

	public byte getSpeedModifier(){
		return 0;
	}

	public void setSpeedModifier(byte i){

	}

	public byte getDamageModifier(){
		return 0;
	}

	public void setDamageModifier(byte i){

	}

	public void setLongHair(boolean b){
		this.dataManager.set(LONG_COAT, b);
	}

	public boolean hasLongHair(){
		return this.dataManager.get(LONG_COAT);
	}

	public void setState(State state){
		this.state = state;
		if(!this.world.isRemote)
			DogPacketHandler.net.sendToAll(new MessageUpdateState(this, state));
	}

	public enum State{
		NONE, SIT, LYING
	}

}
