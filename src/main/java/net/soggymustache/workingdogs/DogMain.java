package net.soggymustache.workingdogs;

import com.google.gson.GsonBuilder;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.soggymustache.bookworm.BookwormMain;
import net.soggymustache.bookworm.util.CMFInfo;
import net.soggymustache.bookworm.util.UserChangeable;
import net.soggymustache.workingdogs.client.render.entity.RenderAkita;
import net.soggymustache.workingdogs.client.render.entity.RenderBorderCollie;
import net.soggymustache.workingdogs.client.render.projectile.RenderFrisbee;
import net.soggymustache.workingdogs.common.block.DogBlocks;
import net.soggymustache.workingdogs.common.entity.DogData;
import net.soggymustache.workingdogs.common.entity.DogEntities;
import net.soggymustache.workingdogs.common.entity.type.EntityAkita;
import net.soggymustache.workingdogs.common.entity.type.EntityBorderCollie;
import net.soggymustache.workingdogs.common.entity.type.base.EntityWorkingDog;
import net.soggymustache.workingdogs.common.entity.type.projectile.EntityFrisbee;
import net.soggymustache.workingdogs.common.gui.GuiHandler;
import net.soggymustache.workingdogs.common.item.DogItems;
import net.soggymustache.workingdogs.network.DogPacketHandler;
import net.soggymustache.workingdogs.proxy.CommonProxy;
import net.soggymustache.workingdogs.util.DogDataManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = DogMain.MOD_ID)
@Mod(modid = DogMain.MOD_ID, name = DogMain.NAME, version = DogMain.VERSION, dependencies = DogMain.DEPEND, acceptedMinecraftVersions = "1.12.2")
public class DogMain {

    public static final Logger LOGGER = LogManager.getLogger(DogMain.MOD_ID);
    public static final String MOD_ID = "workdog";
    public static final String NAME = "Working Dogs";
    public static final String VERSION = "1.12.2-1.0.0";
    public static final String SERVER_PROXY_CLASS = "net.soggymustache.workingdogs.proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "net.soggymustache.workingdogs.proxy.ClientProxy";
    public static final String DEPEND = "required-after:bookworm@[1.12.2-2.5.2,);";

    public static final Map<Class<? extends EntityWorkingDog>, DogData> DATA = new HashMap<>();
    private static UserChangeable<DogData> dogChangeable;

    @SidedProxy(serverSide = DogMain.SERVER_PROXY_CLASS, clientSide = DogMain.CLIENT_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.Instance(DogMain.MOD_ID)
    public static DogMain instance;

    public static final CreativeTabs DOG_TAB = new CreativeTabs("dog_tab") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.ACACIA_BOAT);
        }

        @Override
        @SideOnly(Side.CLIENT)
        public void displayAllRelevantItems(NonNullList<ItemStack> itemList) {
            super.displayAllRelevantItems(itemList);
            EntityList.ENTITY_EGGS.values().forEach(egg -> {
                if (egg.spawnedID.getResourceDomain().equals(DogMain.MOD_ID)) {
                    ItemStack itemstack = new ItemStack(Items.SPAWN_EGG, 1);
                    ItemMonsterPlacer.applyEntityIdToItemStack(itemstack, egg.spawnedID);
                    itemList.add(itemstack);
                }
            });
        }
    };

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        GsonBuilder builder = new GsonBuilder();
        dogChangeable = new UserChangeable<>(DogData.class, "WorkingDogs" + DogMain.VERSION, builder.create(), "workdog");
        DogDataManager.register();

        DogPacketHandler.initPackets();
        NetworkRegistry.INSTANCE.registerGuiHandler(DogMain.instance, new GuiHandler());
    }

    public static DogData registerPack(Class<? extends EntityWorkingDog> clazz, String location){
        DogData data = dogChangeable.load("data/animal/" + location);
        if(data == null) data = new DogData();
        DATA.put(clazz, data);
        return data;
    }

    @EventHandler
    public static void serverStarting(FMLServerStartingEvent event) {
        //Where we register spawns
    }

    @Mod.EventBusSubscriber(modid = DogMain.MOD_ID)
    public static class Handlers {

        private static int ENTITY_ID = 0;

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
            final IForgeRegistry<EntityEntry> registry = event.getRegistry();
            DogEntities.CONTAINERS.forEach(a -> {
                ResourceLocation r = new ResourceLocation(DogMain.MOD_ID, a.entityName);
                EntityEntry e = EntityEntryBuilder.create().entity(a.entityClass).id(r, ENTITY_ID++).name(DogMain.MOD_ID + "." + a.entityName).tracker(200, 1, true).build();
                if(a.sec != -1 && a.prim != -1)
                    e.setEgg(new EntityList.EntityEggInfo(r, a.prim, a.sec));
                registry.register(e);
            });
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> e) {
            e.getRegistry().registerAll(DogItems.ITEMS.toArray(new Item[0]));
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> e) {
            e.getRegistry().registerAll(DogBlocks.BLOCKS.toArray(new Block[0]));
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void registerRenders(ModelRegistryEvent e) {
            CMFInfo info = new CMFInfo();
            info.cmfOTBL = false;
            BookwormMain.CMF_INFO.put(DogMain.MOD_ID, info);

            for (Item itm : DogItems.ITEMS) ModelLoader.setCustomModelResourceLocation(itm, 0, new ModelResourceLocation(itm.getRegistryName(), "inventory"));

            for (Block itm : DogBlocks.BLOCKS) ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(itm), 0, new ModelResourceLocation(itm.getRegistryName(), "inventory"));

            RenderingRegistry.registerEntityRenderingHandler(EntityAkita.class, RenderAkita::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityBorderCollie.class, RenderBorderCollie::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityFrisbee.class, RenderFrisbee::new);
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void playerRenderPre(RenderPlayerEvent.Pre event){
            EntityPlayer pl = event.getEntityPlayer();
            if(isPlayerHoldingDog(Minecraft.getMinecraft().player)) {
                ModelPlayer player = event.getRenderer().getMainModel();
                player.bipedLeftArm.isHidden = true;
                player.bipedRightArm.isHidden = true;
            }
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void playerRenderPost(RenderPlayerEvent.Post event){
            EntityPlayer pl = event.getEntityPlayer();
            if(isPlayerHoldingDog(Minecraft.getMinecraft().player)) {
                ModelPlayer player = event.getRenderer().getMainModel();

                GlStateManager.pushMatrix();
                AbstractClientPlayer aplayer = (AbstractClientPlayer) event.getEntity();
                ResourceLocation skinLoc = aplayer.getLocationSkin();
                Minecraft.getMinecraft().getTextureManager().bindTexture(skinLoc);

                handleArm(true, player.bipedLeftArm, pl, event.getPartialRenderTick(), 100, 12);
                handleArm(false, player.bipedRightArm, pl, event.getPartialRenderTick(), 100, -12);

                GlStateManager.popMatrix();
            }
        }

        public static boolean isPlayerHoldingDog(EntityPlayer player){
            return player.getHeldItemMainhand().isEmpty() && player.getHeldItemOffhand().isEmpty() && !player.getPassengers().isEmpty() && player.getPassengers().get(0) instanceof EntityWorkingDog;
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void renderArm(RenderHandEvent event){
            if(isPlayerHoldingDog(Minecraft.getMinecraft().player)) {
                event.setCanceled(true);
            }

        }

        private static void handleArm(boolean flip, ModelRenderer arm, EntityPlayer pl, float partial, float x, float z){
            float rotation = (pl.prevRenderYawOffset + (pl.renderYawOffset - pl.prevRenderYawOffset) * partial);
            arm.isHidden = false;
            if(flip) {
                arm.rotationPointZ = MathHelper.sin((float) Math.toRadians(rotation)) * 4.75F;
                arm.rotationPointX = MathHelper.cos((float) Math.toRadians(rotation)) * 4.75F;
            }else{
                arm.rotationPointZ = -MathHelper.sin((float) Math.toRadians(rotation)) * 4.75F;
                arm.rotationPointX = -MathHelper.cos((float) Math.toRadians(rotation)) * 4.75F;
            }

            arm.rotationPointY = pl.isSneaking() ? 15 : 20;

            arm.rotateAngleX = (float) Math.toRadians(x);
            arm.rotateAngleY = (float) -Math.toRadians(rotation);
            arm.rotateAngleZ = (float) Math.toRadians(z);

            arm.renderWithRotation(0.0625F);
            arm.rotationPointY = 2;
        }
    }
}
