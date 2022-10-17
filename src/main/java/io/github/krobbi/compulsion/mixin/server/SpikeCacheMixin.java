package io.github.krobbi.compulsion.mixin.server;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.krobbi.compulsion.CompulsionMod;

@Mixin(targets = "net.minecraft.world.gen.feature.EndSpikeFeature$SpikeCache")
public abstract class SpikeCacheMixin {
	@Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;floor(D)I"), method = "load(Ljava/lang/Long;)Ljava/util/List;")
	private int round(double value){
		CompulsionMod.LOGGER.debug("Fixed rounding error in End spike positioning");
		return (int) Math.round(value);
	}
}
