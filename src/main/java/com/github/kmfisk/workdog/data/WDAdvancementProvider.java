package com.github.kmfisk.workdog.data;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.entity.WorkDogEntities;
import com.github.kmfisk.workdog.item.WorkDogItems;
import com.github.kmfisk.workdog.tags.WorkDogTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class WDAdvancementProvider extends ForgeAdvancementProvider {
    public WDAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new WDAdvancementGenerator()));
    }

    public static class WDAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
            Advancement root = Advancement.Builder.advancement()
                    .display(WorkDogItems.CRATE.get(), Component.translatable("advancements.workdog.root"), Component.translatable("advancements.workdog.root.desc"), new ResourceLocation("textures/block/oak_planks.png"), FrameType.TASK, true, false, false)
                    .addCriterion("dog", TameAnimalTrigger.TriggerInstance.tamedAnimal(EntityPredicate.Builder.entity().of(WorkDogTags.WORKING_DOGS).build()))
                    .save(consumer, WorkDog.MOD_ID + ":root");

//            Advancement escape = Advancement.Builder.advancement().parent(root)
//                    .display(WorkDogItems.MUZZLE.get(), Component.translatable("advancements.workdog.escape"), Component.translatable("advancements.workdog.escape.desc"), null, FrameType.TASK, true, true, false)
//                    .addCriterion("dog_killed_passive", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(???), DamageSourcePredicate.Builder.damageType().source(EntityPredicate.Builder.entity().of(WorkDogTags.WORKING_DOGS))))
//                    .save(consumer, WorkDog.MOD_ID + ":escape");

            Advancement michael = Advancement.Builder.advancement()/*.parent(escape)*/.parent(root)
                    .display(WorkDogItems.MUZZLE.get(), Component.translatable("advancements.workdog.michael"), Component.translatable("advancements.workdog.michael.desc"), null, FrameType.TASK, true, true, true)
                    .addCriterion("dog_killed_dog", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(WorkDogTags.WORKING_DOGS), DamageSourcePredicate.Builder.damageType().source(EntityPredicate.Builder.entity().of(WorkDogTags.WORKING_DOGS))))
                    .save(consumer, WorkDog.MOD_ID + ":michael");

            Advancement bites = Advancement.Builder.advancement().parent(michael)
                    .display(WorkDogItems.PINK_JUICE.get(), Component.translatable("advancements.workdog.bites"), Component.translatable("advancements.workdog.bites.desc"), null, FrameType.TASK, true, true, true)
                    .addCriterion("dog_killed_player", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.PLAYER), DamageSourcePredicate.Builder.damageType().source(EntityPredicate.Builder.entity().of(WorkDogTags.WORKING_DOGS))))
                    .save(consumer, WorkDog.MOD_ID + ":bites");

            Advancement hound = Advancement.Builder.advancement().parent(root)
                    .display(WorkDogItems.HOG_VEST.get(), Component.translatable("advancements.workdog.hound"), Component.translatable("advancements.workdog.hound.desc"), null, FrameType.TASK, true, true, false)
                    .addCriterion("dog_killed_wolf", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(WorkDogEntities.WOLF.get()), DamageSourcePredicate.Builder.damageType().source(EntityPredicate.Builder.entity().of(WorkDogTags.WORKING_DOGS))))
                    .save(consumer, WorkDog.MOD_ID + ":hound");

//            Advancement esa = Advancement.Builder.advancement().parent(root)
//                    .display(WorkDogItems.SERVICE_VESTS.get(DyeColor.WHITE).get(), Component.translatable("advancements.workdog.esa"), Component.translatable("advancements.workdog.esa.desc"), null, FrameType.TASK, true, true, false)
//                    .addCriterion("equip_service_vest", )
//                    .save(consumer, WorkDog.MOD_ID + ":esa");

            Advancement peta = Advancement.Builder.advancement().parent(root)
                    .display(WorkDogItems.SURRENDER_FORM.get(), Component.translatable("advancements.workdog.peta"), Component.translatable("advancements.workdog.peta.desc"), null, FrameType.TASK, true, true, true)
                    .addCriterion("player_killed_dog", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(WorkDogTags.WORKING_DOGS)))
                    .save(consumer, WorkDog.MOD_ID + ":peta");

            Advancement masculinity = Advancement.Builder.advancement().parent(root)
                    .display(WorkDogItems.SERVICE_VESTS.get(DyeColor.BROWN).get(), Component.translatable("advancements.workdog.masculinity"), Component.translatable("advancements.workdog.masculinity.desc"), null, FrameType.TASK, true, true, false)
                    .requirements(RequirementsStrategy.OR)
                    .addCriterion("black", InventoryChangeTrigger.TriggerInstance.hasItems(WorkDogItems.SERVICE_VESTS.get(DyeColor.BLACK).get()))
                    .addCriterion("gray", InventoryChangeTrigger.TriggerInstance.hasItems(WorkDogItems.SERVICE_VESTS.get(DyeColor.GRAY).get()))
                    .addCriterion("brown", InventoryChangeTrigger.TriggerInstance.hasItems(WorkDogItems.SERVICE_VESTS.get(DyeColor.BROWN).get()))
                    .save(consumer, WorkDog.MOD_ID + ":masculinity");

            Advancement gay = Advancement.Builder.advancement().parent(root)
                    .display(WorkDogItems.SERVICE_VESTS.get(DyeColor.MAGENTA).get(), Component.translatable("advancements.workdog.gay"), Component.translatable("advancements.workdog.gay.desc"), null, FrameType.TASK, true, true, false)
                    .requirements(RequirementsStrategy.OR)
                    .addCriterion("cyan", InventoryChangeTrigger.TriggerInstance.hasItems(WorkDogItems.SERVICE_VESTS.get(DyeColor.CYAN).get()))
                    .addCriterion("pink", InventoryChangeTrigger.TriggerInstance.hasItems(WorkDogItems.SERVICE_VESTS.get(DyeColor.PINK).get()))
                    .addCriterion("magenta", InventoryChangeTrigger.TriggerInstance.hasItems(WorkDogItems.SERVICE_VESTS.get(DyeColor.MAGENTA).get()))
                    .save(consumer, WorkDog.MOD_ID + ":gay");
        }
    }
}
