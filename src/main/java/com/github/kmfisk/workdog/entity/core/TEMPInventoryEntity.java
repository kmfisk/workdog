package com.github.kmfisk.workdog.entity.core;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.inventory.WorkDogInventoryMenu;
import com.github.kmfisk.workdog.item.DogEquipmentItem;
import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public abstract class TEMPInventoryEntity extends TamableAnimal implements ContainerListener {
    private static final EntityDataAccessor<Boolean> SADDLEBAG = SynchedEntityData.defineId(TEMPInventoryEntity.class, EntityDataSerializers.BOOLEAN);
    protected SimpleContainer inventory;
    LazyOptional<?> itemHandler = null;

    public TEMPInventoryEntity(EntityType<? extends TamableAnimal> type, Level level) {
        super(type, level);
        this.createInventory();
    }

    public void openInventory(Player player) { // todo
        if (!level().isClientSide && isTame())
            NetworkHooks.openScreen((ServerPlayer) player, new SimpleMenuProvider((id, playerInv, pPlayer) -> new WorkDogInventoryMenu(id, playerInv, inventory, TEMPInventoryEntity.this), getName()));
//            player.openMenu(new SimpleMenuProvider((id, playerInv, pPlayer) -> new WorkDogInventoryMenu(id, playerInv, inventory, this), getName()));
        WorkDog.setReferencedMob(this);
    }

    protected int getInventorySize() {
        return hasSaddlebag() ? 4 + 3 * getInventoryColumns() : 4;
    }

    public int getInventoryColumns() {
        // todo (large= 27, 9 columns; medium= 18, 6 columns; small= 9, 3 columns)
        return 9;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(SADDLEBAG, false);
    }

    public boolean hasSaddlebag() {
        return entityData.get(SADDLEBAG);
    }

    public void setSaddlebag(boolean hasSaddlebag) {
        entityData.set(SADDLEBAG, hasSaddlebag);
    }

    private void equipSaddlebag(Player player, ItemStack itemStack) {
        setSaddlebag(true);
        playSaddlebagEquipsSound();
        if (!player.getAbilities().instabuild) itemStack.shrink(1);
        createInventory();
    }

    protected void playSaddlebagEquipsSound() {
        playSound(SoundEvents.DONKEY_CHEST, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
    }

    public ItemStack getDogEquipment(DogEquipmentType dogEquipmentType) {
        return getItemBySlot(dogEquipmentType.getEquipmentSlot());
    }

    private void setDogEquipment(DogEquipmentType dogEquipmentType, ItemStack itemStack) {
        setItemSlot(dogEquipmentType.getEquipmentSlot(), itemStack);
        setDropChance(dogEquipmentType.getEquipmentSlot(), 0.0F);
    }

    public void equipDogEquipment(Player player, DogEquipmentType dogEquipmentType, ItemStack stack) {
        if (isDogEquipment(stack)) {
            inventory.setItem(dogEquipmentType.getSlotId(), stack.copyWithCount(1));
            if (!player.getAbilities().instabuild) stack.shrink(1);
        }
    }

    public boolean canWearDogEquipment(DogEquipmentType dogEquipmentType) {
        return true; //todo
    }

    public boolean isWearingDogEquipment(DogEquipmentType dogEquipmentType) {
        return !getItemBySlot(dogEquipmentType.getEquipmentSlot()).isEmpty();
    }

    public boolean isDogEquipment(ItemStack stack) {
        return stack.getItem() instanceof DogEquipmentItem;
    }

//    public boolean isSaddled() {
//        return getFlag(4);
//    }

    protected void updateContainerEquipment() {
        if (!level().isClientSide) {
            for (DogEquipmentType dogEquipmentType : DogEquipmentType.values()) {
                setEquipment(dogEquipmentType, inventory.getItem(dogEquipmentType.slotId));
                setDropChance(dogEquipmentType.getEquipmentSlot(), 0.0F);
            }
        }
    }

    private void setEquipment(DogEquipmentType dogEquipmentType, ItemStack itemStack) {
        setDogEquipment(dogEquipmentType, itemStack);
//        if (!level().isClientSide) { todo
//            getAttribute(Attributes.ARMOR).removeModifier(ARMOR_MODIFIER_UUID);
//            if (isDogEquipment(itemStack)) {
//                int i = ((DogEquipmentItem) itemStack.getItem()).getProtection();
//                if (i != 0)
//                    getAttribute(Attributes.ARMOR).addTransientModifier(new AttributeModifier(ARMOR_MODIFIER_UUID, "Dog equipment bonus", (double) i, AttributeModifier.Operation.ADDITION));
//            }
//        }
    }

    protected void createInventory() {
        SimpleContainer simplecontainer = inventory;
        inventory = new SimpleContainer(getInventorySize());
        if (simplecontainer != null) {
            simplecontainer.removeListener(this);
            int i = Math.min(simplecontainer.getContainerSize(), inventory.getContainerSize());

            for (int j = 0; j < i; ++j) {
                ItemStack itemstack = simplecontainer.getItem(j);
                if (!itemstack.isEmpty()) inventory.setItem(j, itemstack.copy());
            }
        }

        inventory.addListener(this);
        updateContainerEquipment();
        itemHandler = LazyOptional.of(() -> new InvWrapper(inventory));
    }

    @Override
    public void containerChanged(Container container) {
        for (DogEquipmentType dogEquipmentType : DogEquipmentType.values()) {
            ItemStack itemStack = getDogEquipment(dogEquipmentType);
            updateContainerEquipment();
            ItemStack itemStack1 = getDogEquipment(dogEquipmentType);
            if (tickCount > 20 && isDogEquipment(itemStack1) && itemStack != itemStack1)
                playSound(SoundEvents.HORSE_ARMOR, 0.5F, 1.0F);
        }
    }

    @Override
    protected void dropEquipment() {
        super.dropEquipment();
        if (inventory != null) {
            for (int i = 0; i < inventory.getContainerSize(); ++i) {
                ItemStack itemstack = inventory.getItem(i);
                if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack)) spawnAtLocation(itemstack);
            }
        }
        if (hasSaddlebag()) { //todo color
            if (!level().isClientSide) spawnAtLocation(WorkDogItems.SADDLEBAG.get());
            setSaddlebag(false);
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!isBaby()) {
            if (isTame() && player.isSecondaryUseActive()) {
                openInventory(player);
                return InteractionResult.sidedSuccess(level().isClientSide);
            }

            ItemStack stack = player.getItemInHand(hand);
            if (!stack.isEmpty()) {
                if (!hasSaddlebag() && stack.is(WorkDogItems.SADDLEBAG.get())) {
                    equipSaddlebag(player, stack);
                    return InteractionResult.sidedSuccess(level().isClientSide);
                }

                InteractionResult interactionresult = stack.interactLivingEntity(player, this, hand);
                if (interactionresult.consumesAction()) return interactionresult;

                if (isDogEquipment(stack)) {
                    DogEquipmentType equipmentType = ((DogEquipmentItem) stack.getItem()).getDogEquipmentType();
                    if (canWearDogEquipment(equipmentType) && !isWearingDogEquipment(equipmentType)) {
                        equipDogEquipment(player, equipmentType, stack);
                        return InteractionResult.sidedSuccess(level().isClientSide);
                    }
                }
            }
        }

        return super.mobInteract(player, hand);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        if (!inventory.getItem(0).isEmpty())
            compoundTag.put("CollarItem", inventory.getItem(0).save(new CompoundTag()));
        if (!inventory.getItem(1).isEmpty())
            compoundTag.put("HarnessItem", inventory.getItem(1).save(new CompoundTag()));
        if (!inventory.getItem(2).isEmpty())
            compoundTag.put("VestItem", inventory.getItem(2).save(new CompoundTag()));
        if (!inventory.getItem(3).isEmpty())
            compoundTag.put("MuzzleItem", inventory.getItem(3).save(new CompoundTag()));

        compoundTag.putBoolean("Saddlebag", hasSaddlebag());
        if (hasSaddlebag()) {
            ListTag listtag = new ListTag();
            for (int i = 4; i < inventory.getContainerSize(); ++i) {
                ItemStack stack = inventory.getItem(i);
                if (!stack.isEmpty()) {
                    CompoundTag tag = new CompoundTag();
                    tag.putByte("Slot", (byte) i);
                    stack.save(tag);
                    listtag.add(tag);
                }
            }
            compoundTag.put("Items", listtag);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("CollarItem", 10)) {
            ItemStack itemstack = ItemStack.of(compoundTag.getCompound("CollarItem"));
            if (!itemstack.isEmpty() && isDogEquipment(itemstack)) inventory.setItem(0, itemstack);
        }
        if (compoundTag.contains("HarnessItem", 10)) {
            ItemStack itemstack = ItemStack.of(compoundTag.getCompound("HarnessItem"));
            if (!itemstack.isEmpty() && isDogEquipment(itemstack)) inventory.setItem(1, itemstack);
        }
        if (compoundTag.contains("VestItem", 10)) {
            ItemStack itemstack = ItemStack.of(compoundTag.getCompound("VestItem"));
            if (!itemstack.isEmpty() && isDogEquipment(itemstack)) inventory.setItem(2, itemstack);
        }
        if (compoundTag.contains("MuzzleItem", 10)) {
            ItemStack itemstack = ItemStack.of(compoundTag.getCompound("MuzzleItem"));
            if (!itemstack.isEmpty() && isDogEquipment(itemstack)) inventory.setItem(3, itemstack);
        }

        setSaddlebag(compoundTag.getBoolean("Saddlebag"));
        createInventory();
        if (hasSaddlebag()) {
            ListTag listtag = compoundTag.getList("Items", 10);
            for (int i = 0; i < listtag.size(); ++i) {
                CompoundTag tag = listtag.getCompound(i);
                int j = tag.getByte("Slot") & 255;
                if (j >= 4 && j < inventory.getContainerSize()) inventory.setItem(j, ItemStack.of(tag));
            }
        }
        updateContainerEquipment();
    }

    private SlotAccess createEquipmentSlotAccess(final int i, final Predicate<ItemStack> stackPredicate) {
        return new SlotAccess() {
            public ItemStack get() {
                return TEMPInventoryEntity.this.inventory.getItem(i);
            }

            public boolean set(ItemStack itemStack) {
                if (!stackPredicate.test(itemStack)) {
                    return false;
                } else {
                    TEMPInventoryEntity.this.inventory.setItem(i, itemStack);
                    TEMPInventoryEntity.this.updateContainerEquipment();
                    return true;
                }
            }
        };
    }

    @Override
    public SlotAccess getSlot(int slotId) {
        if (slotId == 499) {
            return new SlotAccess() {
                @Override
                public ItemStack get() {
                    return TEMPInventoryEntity.this.hasSaddlebag() ? new ItemStack(WorkDogItems.SADDLEBAG.get()) : ItemStack.EMPTY;
                }

                @Override
                public boolean set(ItemStack stack) {
                    if (stack.isEmpty()) {
                        if (TEMPInventoryEntity.this.hasSaddlebag()) {
                            TEMPInventoryEntity.this.setSaddlebag(false);
                            TEMPInventoryEntity.this.createInventory();
                        }
                        return true;

                    } else if (stack.is(WorkDogItems.SADDLEBAG.get())) {
                        if (!TEMPInventoryEntity.this.hasSaddlebag()) {
                            TEMPInventoryEntity.this.setSaddlebag(true);
                            TEMPInventoryEntity.this.createInventory();
                        }
                        return true;

                    } else return false;
                }
            };

        } else {
            int i = slotId - 400;
            if (i >= 0 && i < 4 && i < inventory.getContainerSize()) {
                if (!canWearDogEquipment(DogEquipmentType.fromSlotId(i))) return SlotAccess.NULL;
                return createEquipmentSlotAccess(i, (stack) -> stack.isEmpty() || isDogEquipment(stack) && ((DogEquipmentItem) stack.getItem()).getDogEquipmentType().slotId == i);
            }

            int j = slotId - 500 + 4;
            return j >= 4 && j < inventory.getContainerSize() ? SlotAccess.forContainer(inventory, j) : super.getSlot(slotId);
        }
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (capability == ForgeCapabilities.ITEM_HANDLER && itemHandler != null && isAlive())
            return itemHandler.cast();
        return super.getCapability(capability, facing);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        if (itemHandler != null) {
            LazyOptional<?> oldHandler = itemHandler;
            itemHandler = null;
            oldHandler.invalidate();
        }
    }

    public boolean hasInventoryChanged(Container container) {
        return inventory != container;
    }

    public enum DogEquipmentType {
        COLLAR(0, EquipmentSlot.HEAD),
        HARNESS(1, EquipmentSlot.CHEST),
        VEST(2, EquipmentSlot.LEGS),
        MUZZLE(3, EquipmentSlot.FEET);

        private final int slotId;
        private final EquipmentSlot equipmentSlot;

        DogEquipmentType(int slotId, EquipmentSlot equipmentSlot) {
            this.slotId = slotId;
            this.equipmentSlot = equipmentSlot;
        }

        public int getSlotId() {
            return slotId;
        }

        public static DogEquipmentType fromSlotId(int slotId) {
            return switch (slotId) {
                case 0 -> COLLAR;
                case 1 -> HARNESS;
                case 2 -> VEST;
                case 3 -> MUZZLE;
                default -> throw new IllegalStateException("Unexpected value: " + slotId);
            };
        }

        public EquipmentSlot getEquipmentSlot() {
            return equipmentSlot;
        }
    }
}