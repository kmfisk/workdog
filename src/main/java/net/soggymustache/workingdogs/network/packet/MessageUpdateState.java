package net.soggymustache.workingdogs.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.soggymustache.workingdogs.DogMain;
import net.soggymustache.workingdogs.common.entity.type.base.EntityWorkingDog;

public class MessageUpdateState implements IMessage {

	private int entityID;
	private int stateOrdinal;

	public MessageUpdateState(){}

	public MessageUpdateState(Entity entity, EntityWorkingDog.State state){
		entityID = entity.getEntityId();
		stateOrdinal = state.ordinal();
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = ByteBufUtils.readVarInt(buf, 4);
		stateOrdinal = ByteBufUtils.readVarInt(buf, 4);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, entityID, 4);
		ByteBufUtils.writeVarInt(buf, stateOrdinal, 4);
	}

	public static class Handler implements IMessageHandler<MessageUpdateState, IMessage>{

		@Override
		public IMessage onMessage(MessageUpdateState message, MessageContext ctx) {
			Entity e = DogMain.proxy.getPlayer(ctx).world.getEntityByID(message.entityID);
			if(e instanceof EntityWorkingDog) ((EntityWorkingDog) e).setState(EntityWorkingDog.State.values()[message.stateOrdinal]);
			return null;
		}

	}

}
