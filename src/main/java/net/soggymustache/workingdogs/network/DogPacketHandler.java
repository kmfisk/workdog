package net.soggymustache.workingdogs.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.soggymustache.workingdogs.DogMain;
import net.soggymustache.workingdogs.network.packet.MessageUpdateState;

public class DogPacketHandler {

	public static SimpleNetworkWrapper net;
	private static int ID = 0;

	public static void initPackets(){
		net = NetworkRegistry.INSTANCE.newSimpleChannel(DogMain.MOD_ID.toUpperCase());
		registerMessage(MessageUpdateState.Handler.class, MessageUpdateState.class);
	}

	private static void registerMessage(Class packet, Class message){
		net.registerMessage(packet, message, ID, Side.CLIENT);
		net.registerMessage(packet, message, ID, Side.SERVER);
		ID++;
	}

}
