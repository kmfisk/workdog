package net.soggymustache.workingdogs.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {

	@Override
	public EntityPlayer getPlayer(MessageContext ctx) {
		if (ctx.side == Side.SERVER)
			return ctx.getServerHandler().player;
		return Minecraft.getMinecraft().player;
	}
}
