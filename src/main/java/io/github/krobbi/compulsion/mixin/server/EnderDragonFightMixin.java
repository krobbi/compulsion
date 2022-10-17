package io.github.krobbi.compulsion.mixin.server;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.krobbi.compulsion.CompulsionMod;
import net.minecraft.entity.boss.dragon.EnderDragonFight;

@Mixin(EnderDragonFight.class)
public abstract class EnderDragonFightMixin {
	@Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;floor(D)I"), method = "generateNewEndGateway()V")
	private int round(double value){
		CompulsionMod.LOGGER.debug("Fixed rounding error in End gateway positioning");
		return (int) Math.round(value);
	}
}
