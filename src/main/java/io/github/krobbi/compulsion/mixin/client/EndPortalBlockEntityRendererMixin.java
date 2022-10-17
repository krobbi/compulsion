package io.github.krobbi.compulsion.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;

@Mixin(EndPortalBlockEntityRenderer.class)
public abstract class EndPortalBlockEntityRendererMixin {
	private static final String OWNER = "Lnet/minecraft/client/render/block/entity/EndPortalBlockEntityRenderer;";
	private static final String ENTITY_ARG = "Lnet/minecraft/block/entity/EndPortalBlockEntity;";
	private static final String MATRIX_ARG = "Lnet/minecraft/util/math/Matrix4f;";
	private static final String VERTEX_CONSUMER_ARG = "Lnet/minecraft/client/render/VertexConsumer;";
	private static final String DIRECTION_ARG = "Lnet/minecraft/util/math/Direction;";
	private static final String OBJECT_ARGS = ENTITY_ARG + MATRIX_ARG + VERTEX_CONSUMER_ARG;
	private static final String RENDER_SIDE = OWNER + "renderSide(" + OBJECT_ARGS + "FFFFFFFF" + DIRECTION_ARG + ")V";
	private static final String RENDER_SIDES = "renderSides(" + OBJECT_ARGS + ")V";
	private static final int Y1_ARG_INDEX = 5;
	private static final int Y2_ARG_INDEX = 6;
	
	@Shadow
	protected abstract float getTopYOffset();
	
	@Shadow
	protected abstract float getBottomYOffset();
	
	@ModifyArgs(at = @At(value = "INVOKE", target = RENDER_SIDE, ordinal = 0), method = RENDER_SIDES)
	private void renderSouthSide(Args args){
		args.set(Y1_ARG_INDEX, getBottomYOffset());
		args.set(Y2_ARG_INDEX, getTopYOffset());
	}
	
	@ModifyArgs(at = @At(value = "INVOKE", target = RENDER_SIDE, ordinal = 1), method = RENDER_SIDES)
	private void renderNorthSide(Args args){
		args.set(Y1_ARG_INDEX, getTopYOffset());
		args.set(Y2_ARG_INDEX, getBottomYOffset());
	}
	
	@ModifyArgs(at = @At(value = "INVOKE", target = RENDER_SIDE, ordinal = 2), method = RENDER_SIDES)
	private void renderEastSide(Args args){
		args.set(Y1_ARG_INDEX, getTopYOffset());
		args.set(Y2_ARG_INDEX, getBottomYOffset());
	}
	
	@ModifyArgs(at = @At(value = "INVOKE", target = RENDER_SIDE, ordinal = 3), method = RENDER_SIDES)
	private void renderWestSide(Args args){
		args.set(Y1_ARG_INDEX, getBottomYOffset());
		args.set(Y2_ARG_INDEX, getTopYOffset());
	}
}
