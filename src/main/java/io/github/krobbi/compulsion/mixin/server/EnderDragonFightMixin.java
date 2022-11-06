package io.github.krobbi.compulsion.mixin.server;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.krobbi.compulsion.CompulsionMod;
import net.minecraft.entity.boss.dragon.EnderDragonFight;

/**
 * Mixin for the EnderDragonFight class. Fixes the positioning of End gateways.
 */
@Mixin(EnderDragonFight.class)
public abstract class EnderDragonFightMixin {
	/**
	 * Mixes into the Ender dragon fight's method for generating new End
	 * gateways to generate End gateways at the correct locations. This is done
	 * by replacing the End gateway's floored coordinates with rounded
	 * coordinates, reverting a change made in Minecraft 1.14.
	 * 
	 * @param value The decimal X or Z coordinate of an End gateway feature.
	 * @return The coordinate {@code value}, rounded instead of floored.
	 */
	@Redirect(method = "generateNewEndGateway()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;floor(D)I"))
	private int generateNewEndGateway(double value){
		CompulsionMod.LOGGER.debug("Fixed rounding error in End gateway positioning");
		return (int) Math.round(value);
	}
}
