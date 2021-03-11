package com.github.kmfisk.workdog.mixin;

import com.github.kmfisk.workdog.util.DogDataHandler;
import com.github.kmfisk.workdog.util.DogDataManager;
import net.minecraft.resource.ServerResourceManager;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin implements DogDataHandler {
    @Shadow
    private ServerResourceManager serverResourceManager;

    @Override
    public DogDataManager getDogDataManager() {
        return ((DogDataHandler) serverResourceManager).getDogDataManager();
    }
}
