package io.github.krobbi.compulsion.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;

/**
 * Mixin for the EndPortalBlockEntityRenderer class. Renders the sides of End
 * portals with the correct height.
 */
@Mixin(EndPortalBlockEntityRenderer.class)
public abstract class EndPortalBlockEntityRendererMixin {
	/**
	 * The representation of the {@code renderSides} method to mix into.
	 */
	private static final String METHOD = "renderSides(Lnet/minecraft/block/entity/EndPortalBlockEntity;Lnet/minecraft/util/math/Matrix4f;Lnet/minecraft/client/render/VertexConsumer;)V";
	
	/**
	 * The representation of the {@code renderSide} method to modify the
	 * arguments of.
	 */
	private static final String TARGET = "Lnet/minecraft/client/render/block/entity/EndPortalBlockEntityRenderer;renderSide(Lnet/minecraft/block/entity/EndPortalBlockEntity;Lnet/minecraft/util/math/Matrix4f;Lnet/minecraft/client/render/VertexConsumer;FFFFFFFFLnet/minecraft/util/math/Direction;)V";
	
	/**
	 * The position of the {@code renderSide} method's {@code y1} argument.
	 */
	private static final int Y1_ARG = 5;
	
	/**
	 * The position of the {@code renderSide} method's {@code y2} argument.
	 */
	private static final int Y2_ARG = 6;
	
	/**
	 * Get the Y offset to render the top face of an End portal block entity.
	 * 
	 * @return The Y offset to render the top face of an End portal block
	 * entity.
	 */
	@Shadow
	protected abstract float getTopYOffset();
	
	/**
	 * Get the Y offset to render the bottom face of an End portal block entity.
	 * 
	 * @return The y offset to render the bottom face of an End portal block
	 * entity.
	 */
	@Shadow
	protected abstract float getBottomYOffset();
	
	/**
	 * Mixes into the End portal block entity renderer's render sides method to
	 * render the south side of End portals with the correct height. This is
	 * done by replacing the {@code renderSide} method's Y coordinate arguments
	 * with the correct Y offsets.
	 * 
	 * @param args The arguments passed to {@code renderSide}, replaced with the
	 * correct Y offsets.
	 */
	@ModifyArgs(method = METHOD, at = @At(value = "INVOKE", target = TARGET, ordinal = 0))
	private void renderSidesSouth(Args args){
		args.set(Y1_ARG, getBottomYOffset());
		args.set(Y2_ARG, getTopYOffset());
	}
	
	/**
	 * Mixes into the End portal block entity renderer's render sides method to
	 * render the north side of End portals with the correct height. This is
	 * done by replacing the {@code renderSide} method's Y coordinate arguments
	 * with the correct Y offsets.
	 * 
	 * @param args The arguments passed to {@code renderSide}, replaced with the
	 * correct Y offsets.
	 */
	@ModifyArgs(method = METHOD, at = @At(value = "INVOKE", target = TARGET, ordinal = 1))
	private void renderSidesNorth(Args args){
		args.set(Y1_ARG, getTopYOffset());
		args.set(Y2_ARG, getBottomYOffset());
	}
	
	/**
	 * Mixes into the End portal block entity renderer's render sides method to
	 * render the east side of End portals with the correct height. This is done
	 * by replacing the {@code renderSide} method's Y coordinate arguments with
	 * the correct Y offsets.
	 * 
	 * @param args The arguments passed to {@code renderSide}, replaced with the
	 * correct Y offsets.
	 */
	@ModifyArgs(method = METHOD, at = @At(value = "INVOKE", target = TARGET, ordinal = 2))
	private void renderSidesEast(Args args){
		args.set(Y1_ARG, getTopYOffset());
		args.set(Y2_ARG, getBottomYOffset());
	}
	
	/**
	 * Mixes into the End portal block entity renderer's render sides method to
	 * render the west side of End portals with the correct height. This is done
	 * by replacing the {@code renderSide} method's Y coordinate arguments with
	 * the correct Y offsets.
	 * 
	 * @param args The arguments passed to {@code renderSide}, replaced with the
	 * correct Y offsets.
	 */
	@ModifyArgs(method = METHOD, at = @At(value = "INVOKE", target = TARGET, ordinal = 3))
	private void renderSidesWest(Args args){
		args.set(Y1_ARG, getBottomYOffset());
		args.set(Y2_ARG, getTopYOffset());
	}
}
