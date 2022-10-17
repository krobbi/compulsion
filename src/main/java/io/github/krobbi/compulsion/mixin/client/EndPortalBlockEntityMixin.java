package io.github.krobbi.compulsion.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.entity.EndPortalBlockEntity;
import net.minecraft.util.math.Direction;

@Mixin(EndPortalBlockEntity.class)
public abstract class EndPortalBlockEntityMixin {
	@Inject(at = @At("RETURN"), method = "shouldDrawSide(Lnet/minecraft/util/math/Direction;)Z", cancellable = true)
	private void shouldDrawSide(Direction direction, CallbackInfoReturnable<Boolean> info){
		info.setReturnValue(true);
	}
}
