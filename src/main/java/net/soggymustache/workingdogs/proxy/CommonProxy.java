package net.soggymustache.workingdogs.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy {

	public EntityPlayer getPlayer(MessageContext ctx) {
		if (ctx.side == Side.SERVER)
			return ctx.getServerHandler().player;
		return null;
	}

}
