package com.github.kmfisk.workdog.mixin;

import com.github.kmfisk.workdog.util.DogDataManager;
import net.minecraft.resource.ReloadableResourceManager;
import net.minecraft.resource.ServerResourceManager;
import net.minecraft.server.command.CommandManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerResourceManager.class)
public class DogDataMixin {
	@Shadow
	@Final
	private ReloadableResourceManager resourceManager;

	@Inject(at = @At("TAIL"), method = "<init>")
	private void init(CommandManager.RegistrationEnvironment registrationEnvironment, int i, CallbackInfo info) {
		resourceManager.registerListener(DogDataManager.INSTANCE);
	}
}