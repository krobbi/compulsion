package io.github.krobbi.compulsion.mixin.server;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.krobbi.compulsion.CompulsionMod;

/**
 * Mixin for the SpikeCache class in the EndSpikeFeature class. Fixes the
 * positioning of End spikes.
 */
@Mixin(targets = "net.minecraft.world.gen.feature.EndSpikeFeature$SpikeCache")
public abstract class SpikeCacheMixin {
	/**
	 * Mixes into the End spike feature's spike cache to generate end spikes at
	 * the correct locations. This is done by replacing the End spike's floored
	 * coordinates with rounded coordinates, reverting a change made in
	 * Minecraft 1.14.
	 * 
	 * @param value The decimal X or Z coordinate of an End spike feature.
	 * @return The coordinate {@code value}, rounded instead of floored.
	 */
	@Redirect(method = "load(Ljava/lang/Long;)Ljava/util/List;", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;floor(D)I"))
	private int load(double value){
		CompulsionMod.LOGGER.debug("Fixed rounding error in End spike positioning");
		return (int) Math.round(value);
	}
}
