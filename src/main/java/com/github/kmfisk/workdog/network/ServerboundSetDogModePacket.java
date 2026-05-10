package com.github.kmfisk.workdog.network;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class ServerboundSetDogModePacket {
    private final int entityId;
    private final int modeOrdinal;

    public ServerboundSetDogModePacket(int entityId, int modeOrdinal) {
        this.entityId = entityId;
        this.modeOrdinal = modeOrdinal;
    }

    public ServerboundSetDogModePacket(FriendlyByteBuf buf) {
        this.entityId = buf.readVarInt();
        this.modeOrdinal = buf.readByte();
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeVarInt(entityId);
        buf.writeByte(modeOrdinal);
    }

    public void handle(Supplier<NetworkEvent.Context> supplier) {
        supplier.get().enqueueWork(() -> {
            final ServerLevel level = supplier.get().getSender().serverLevel();
            final Entity entity = level.getEntity(entityId);
            if (entity instanceof WorkDogEntity workDog) {
                workDog.setMode(WorkDogEntity.Mode.fromOrdinal(modeOrdinal));
            }
        });
        supplier.get().setPacketHandled(true);
    }
}
