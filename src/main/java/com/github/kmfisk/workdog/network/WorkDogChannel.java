package com.github.kmfisk.workdog.network;

import com.github.kmfisk.workdog.WorkDog;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class WorkDogChannel {
    private static final String PROTOCOL_VERSION = "1.0";
    private static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(WorkDog.MOD_ID, "main"))
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .simpleChannel();

    public static void register() {
        int id = 0;
        INSTANCE.messageBuilder(ServerboundSetDogModePacket.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .decoder(ServerboundSetDogModePacket::new)
                .encoder(ServerboundSetDogModePacket::write)
                .consumerMainThread(ServerboundSetDogModePacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }
}
