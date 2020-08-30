package net.soggymustache.workingdogs.common.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.soggymustache.workingdogs.client.gui.GuiDogBook;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

	public enum GUI{

		DATA;

		public final int id;

		GUI(){this.id = getNext();}

		static int cnt = 0;

		private static int getNext(){return cnt++;}
	}

	@Nullable
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Nullable
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == GUI.DATA.id){
			return new GuiDogBook();
		}

		return null;
	}
}
