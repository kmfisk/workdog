package net.soggymustache.workingdogs.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.soggymustache.workingdogs.common.item.DogItems;

import java.util.ArrayList;
import java.util.List;

public class DogBlocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();


    private static class DBlock extends Block {
        public DBlock(String unloc, Material material) {
            super(material);
            this.setUnlocalizedName(unloc);
            this.setRegistryName(unloc);

            DogBlocks.BLOCKS.add(this);
            DogItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        }
    }

}
