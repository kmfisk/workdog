package com.github.kmfisk.workdog.block;

import com.github.kmfisk.workdog.WorkDog;
import com.github.kmfisk.workdog.item.WorkDogItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class WorkDogBlocks {
    public static final DeferredRegister<Block> REGISTRAR = DeferredRegister.create(ForgeRegistries.BLOCKS, WorkDog.MOD_ID);

    public static final RegistryObject<Block> KENNEL_EQUIPMENT = registerWithItem("kennel_equipment", () -> new KennelEquipmentBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE).noOcclusion()));

    public static final Map<String, RegistryObject<Block>> BEDS = new HashMap<>();
    public static final Map<String, RegistryObject<Block>> FANCY_BEDS = new HashMap<>();
    public static final Map<String, RegistryObject<Block>> BOWLS = new HashMap<>();

    static {
        for (int i = 0; i < 16; i++) {
            DyeColor color = DyeColor.byId(i);
            BEDS.put(color.getName(), registerWithItem(color.getName() + "_dog_bed", () -> new DogBedBlock(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.WOOD).strength(0.2F).noOcclusion())));
            FANCY_BEDS.put(color.getName(), registerWithItem("fancy_" + color.getName() + "_dog_bed", () -> new DogBedBlock(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.WOOD).strength(0.2F).noOcclusion())));
            BOWLS.put(color.getName(), registerWithItem(color.getName() + "_dog_bowl", () -> new BowlBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion())));
        }
    }

    private static <T extends Block> RegistryObject<T> registerWithItem(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = REGISTRAR.register(name, block);
        WorkDogItems.REGISTRAR.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties().tab(WorkDog.ITEM_GROUP)));
        return registryObject;
    }
}
