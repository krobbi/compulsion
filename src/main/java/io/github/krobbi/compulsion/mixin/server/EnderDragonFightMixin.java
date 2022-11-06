package io.github.krobbi.compulsion.mixin.server;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.krobbi.compulsion.CompulsionMod;
import net.minecraft.entity.boss.dragon.EnderDragonFight;

@Mixin(EnderDragonFight.class)
public abstract class EnderDragonFightMixin {
	@Redirect(method = "generateNewEndGateway()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;floor(D)I"))
	private int generateNewEndGateway(double value){
		CompulsionMod.LOGGER.debug("Fixed rounding error in End gateway positioning");
		return (int) Math.round(value);
	}
}
