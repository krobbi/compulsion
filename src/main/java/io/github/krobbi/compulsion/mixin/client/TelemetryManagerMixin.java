package io.github.krobbi.compulsion.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.krobbi.compulsion.CompulsionMod;
import net.minecraft.client.util.telemetry.TelemetryManager;
import net.minecraft.client.util.telemetry.TelemetrySender;

/**
 * Mixin for the TelemetryManager class. Disables telemetry.
 */
@Mixin(TelemetryManager.class)
public abstract class TelemetryManagerMixin {
	/**
	 * Mixes into the telemetry manager's method for creating a telemetry
	 * session and getting a telemetry sender to disable telemetry. This is done
	 * by returning a no-op telemetry sender that is used for development and
	 * handling errors.
	 * 
	 * @param info The callback info for the mixed in method, returns a no-op
	 * telemetry sender.
	 */
	@Inject(method = "getSender()Lnet/minecraft/client/util/telemetry/TelemetrySender;", at = @At("HEAD"), cancellable = true)
	private void getSender(CallbackInfoReturnable<TelemetrySender> info){
		CompulsionMod.LOGGER.debug("Blocked creating telemetry session");
		info.setReturnValue(TelemetrySender.NOOP);
	}
}
