package com.github.kmfisk.workdog.data;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.block.WorkDogBlocks;
import com.github.kmfisk.workdog.entity.WorkDogEntities;
import com.github.kmfisk.workdog.entity.merchant.villager.WorkDogVillagers;
import com.github.kmfisk.workdog.tags.WorkDogTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class WDTagsProviders {
    public static class WDBlockTagsProvider extends BlockTagsProvider {
        public WDBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, WorkDog.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(WorkDogBlocks.KENNEL_EQUIPMENT.get());
        }
    }

    public static class WDItemTagsProvider extends ItemTagsProvider {
        public WDItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider tagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(packOutput, lookupProvider, tagsProvider.contentsGetter(), WorkDog.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(WorkDogTags.RAW_MEATS).addTags(WorkDogTags.RAW_BEEF, WorkDogTags.RAW_CHICKEN, WorkDogTags.RAW_MUTTON, WorkDogTags.RAW_PORK, WorkDogTags.RAW_RABBIT);
            tag(WorkDogTags.RAW_BEEF).add(Items.BEEF);
            tag(WorkDogTags.RAW_CHICKEN).add(Items.CHICKEN);
            tag(WorkDogTags.RAW_MUTTON).add(Items.MUTTON);
            tag(WorkDogTags.RAW_PORK).add(Items.PORKCHOP);
            tag(WorkDogTags.RAW_RABBIT).add(Items.RABBIT);
        }
    }

    public static class WDPoiTypeTagsProvider extends PoiTypeTagsProvider {
        public WDPoiTypeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(packOutput, lookupProvider, WorkDog.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).add(WorkDogVillagers.KENNEL_EQUIPMENT.getKey());
        }
    }

    public static class WDEntityTypeTagsProvider extends EntityTypeTagsProvider {
        public WDEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> p_256572_, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, p_256572_, WorkDog.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(WorkDogTags.WORKING_DOGS).addTags(WorkDogTags.HERDING_DOGS, WorkDogTags.HUNTING_DOGS, WorkDogTags.PROTECTION_DOGS, WorkDogTags.TERRIER_DOGS, WorkDogTags.TOY_DOGS);
            tag(WorkDogTags.HERDING_DOGS).add(WorkDogEntities.BORDER_COLLIE.get());
            tag(WorkDogTags.HUNTING_DOGS).add(WorkDogEntities.AKITA.get(), WorkDogEntities.PIT_BULL.get());
            tag(WorkDogTags.PROTECTION_DOGS).add(WorkDogEntities.GERMAN_SHEPHERD.get());
            tag(WorkDogTags.TERRIER_DOGS).add(WorkDogEntities.JACK_RUSSELL_TERRIER.get());
            tag(WorkDogTags.TOY_DOGS).add(WorkDogEntities.BOSTON_TERRIER.get());
        }
    }
}
