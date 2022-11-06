package io.github.krobbi.compulsion.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.entity.EndPortalBlockEntity;
import net.minecraft.util.math.Direction;

/**
 * Mixin for the EndPortalBlockEntity class. Renders End portals on all sides.
 */
@Mixin(EndPortalBlockEntity.class)
public abstract class EndPortalBlockEntityMixin {
	/**
	 * Mixes into the End portal block entity's method for testing if a side
	 * should be drawn to render End portals on all sides. This is done by
	 * making the method always return {@code true}.
	 * 
	 * @param direction The direction to test whether to draw.
	 * @param info The callback info for the mixed in method, set to always
	 * return {@code true}.
	 */
	@Inject(method = "shouldDrawSide(Lnet/minecraft/util/math/Direction;)Z", at = @At("RETURN"), cancellable = true)
	private void shouldDrawSide(Direction direction, CallbackInfoReturnable<Boolean> info){
		info.setReturnValue(true);
	}
}
