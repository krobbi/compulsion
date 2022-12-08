package io.github.krobbi.compulsion.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.MinecraftClient;

/**
 * Mixin for the MinecraftClient class. Makes Minecraft behave as if telemetry
 * is disabled.
 */
@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
	/**
	 * Mixes into the Minecraft client's method for getting whether the
	 * telemetry API is enabled to make Minecraft behave as if telemetry is
	 * disabled. This is done by making the method always return {@code false}.
	 * 
	 * @param info The callback info for the mixed in method, set to always
	 * return {@code false}.
	 */
	@Inject(method = "isTelemetryEnabledByApi()Z", at = @At("RETURN"), cancellable = true)
	private void isTelemetryEnabledByApi(CallbackInfoReturnable<Boolean> info){
		info.setReturnValue(false);
	}
}
