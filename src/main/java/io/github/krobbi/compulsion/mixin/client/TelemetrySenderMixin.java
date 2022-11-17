package io.github.krobbi.compulsion.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.krobbi.compulsion.CompulsionMod;
import net.minecraft.client.util.telemetry.TelemetrySender;

/**
 * Mixin for the TelemetrySender class. Disables telemetry.
 */
@Mixin(TelemetrySender.class)
public abstract class TelemetrySenderMixin {
	/**
	 * Mixes into the telemetry sender's method for creating and sending a
	 * telemetry event to disable telemetry. This is done by cancelling the
	 * method at its head.
	 * 
	 * @param gameMode The telemetry sender's player game mode.
	 * @param info The callback info for the mixed in method, cancels the method
	 * before a telemetry event is created and sent.
	 */
	@Inject(method = "send(Lnet/minecraft/client/util/telemetry/TelemetrySender$PlayerGameMode;)V", at = @At("HEAD"), cancellable = true)
	private void send(TelemetrySender.PlayerGameMode gameMode, CallbackInfo info){
		CompulsionMod.LOGGER.debug("Blocked telemetry event");
		info.cancel();
	}
}
