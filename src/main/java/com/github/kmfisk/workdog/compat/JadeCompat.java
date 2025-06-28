package com.github.kmfisk.workdog.compat;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.theme.IThemeHelper;

@WailaPlugin
public class JadeCompat implements IWailaPlugin {
    public static final ResourceLocation DOG_TIMERS = new ResourceLocation(WorkDog.MOD_ID, "dog_timers");
    public static final ResourceLocation WORKING_MODE = new ResourceLocation(WorkDog.MOD_ID, "working_mode");

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerEntityDataProvider(DogTimersProvider.INSTANCE, WorkDogEntity.class);
        registration.registerEntityDataProvider(WorkingModeProvider.INSTANCE, WorkDogEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerEntityComponent(DogTimersProvider.INSTANCE, WorkDogEntity.class);
        registration.registerEntityComponent(WorkingModeProvider.INSTANCE, WorkDogEntity.class);
    }

    public enum DogTimersProvider implements IEntityComponentProvider, IServerDataProvider<EntityAccessor> {
        INSTANCE;

        @Override
        public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
            if (!entityAccessor.getServerData().contains("Timer", CompoundTag.TAG_INT)) return;

            WorkDogEntity dog = (WorkDogEntity) entityAccessor.getEntity();
            boolean dogIsFemale = dog.getGender() == WorkDogEntity.Gender.FEMALE;
            int timer = entityAccessor.getServerData().getInt("Timer");

            String timerInfo = dogIsFemale ? dog.getBreedingStatus(WorkDogEntity.BreedingStatus.HEAT) ? "name.workdog.in_heat" : "name.workdog.not_in_heat" : "name.workdog.male";
            if (dog.getBreedingStatus(WorkDogEntity.BreedingStatus.PREGNANT))
                timerInfo = "name.workdog.pregnant";

            iTooltip.add(Component.translatable(dogIsFemale ? "tooltip.workdog.crate.female" : "tooltip.workdog.crate.male")
                    .append(dog.isInfertile() && entityAccessor.showDetails() ? Component.literal(", ").append(Component.translatable("name.workdog.infertile")) : Component.empty())
                    .append(!dog.isInfertile() && !dog.isBaby() && entityAccessor.showDetails() ? Component.literal(", ").append(Component.translatable(timerInfo, IThemeHelper.get().seconds(timer))) : Component.empty()));
        }

        @Override
        public void appendServerData(CompoundTag compoundTag, EntityAccessor entityAccessor) {
            if (entityAccessor.getEntity() instanceof WorkDogEntity dog)
                compoundTag.putInt("Timer", dog.getBreedTimer());
        }

        @Override
        public ResourceLocation getUid() {
            return JadeCompat.DOG_TIMERS;
        }
    }

    public enum WorkingModeProvider implements IEntityComponentProvider, IServerDataProvider<EntityAccessor> {
        INSTANCE;

        @Override
        public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
            if (!entityAccessor.getServerData().contains("Mode", CompoundTag.TAG_INT)) return;

            WorkDogEntity.Mode mode = ((WorkDogEntity) entityAccessor.getEntity()).getMode();

            Component workModeComponent;
            if (mode == WorkDogEntity.Mode.FOLLOW) workModeComponent = Component.translatable("name.workdog.follow_mode");
            else if (mode == WorkDogEntity.Mode.WORK) workModeComponent = Component.translatable("name.workdog.work_mode");
            else workModeComponent = Component.translatable("name.workdog.wander_mode");

            iTooltip.add(workModeComponent);
        }

        @Override
        public void appendServerData(CompoundTag compoundTag, EntityAccessor entityAccessor) {
            if (entityAccessor.getEntity() instanceof WorkDogEntity dog)
                compoundTag.putInt("Mode", dog.getMode().ordinal());
        }

        @Override
        public ResourceLocation getUid() {
            return JadeCompat.WORKING_MODE;
        }
    }
}
