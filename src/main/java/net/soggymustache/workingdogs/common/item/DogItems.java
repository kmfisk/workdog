package net.soggymustache.workingdogs.common.item;

import net.minecraft.item.Item;
import net.soggymustache.workingdogs.DogMain;

import java.util.ArrayList;
import java.util.List;

public class DogItems {

    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item WHISTLE = new DItem("whistle");
    public static final Item DOG_TREAT = new DItem("dog_treat");
    public static final Item DOG_FOOD = new DItem("dog_food");
    public static final Item MUZZLE = new DItem("muzzle");
    public static final Item HARNESS = new DItem("harness");
    public static final Item SADDLE_BAG = new DItem("saddle_bag");
    public static final Item HOG_VEST = new DItem("hog_vest");
    public static final Item WOLF_COLLAR = new DItem("wolf_collar");
    public static final Item SLED = new DItem("sled");
    public static final Item PULL_CART = new DItem("pull_cart");
    public static final Item FRISBEE = new ItemFrisbee("frisbee");
    public static final Item DOG_BOOK = new DItem("dog_book");

    public static class DItem extends Item{
        public DItem(String unloc) {
            this.setUnlocalizedName(unloc);
            this.setRegistryName(unloc);
            this.setCreativeTab(DogMain.DOG_TAB);
            DogItems.ITEMS.add(this);
        }
    }
}
