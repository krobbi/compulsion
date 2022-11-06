package io.github.krobbi.compulsion.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;

@Mixin(EndPortalBlockEntityRenderer.class)
public abstract class EndPortalBlockEntityRendererMixin {
	private static final String METHOD = "renderSides(Lnet/minecraft/block/entity/EndPortalBlockEntity;Lnet/minecraft/util/math/Matrix4f;Lnet/minecraft/client/render/VertexConsumer;)V";
	private static final String TARGET = "Lnet/minecraft/client/render/block/entity/EndPortalBlockEntityRenderer;renderSide(Lnet/minecraft/block/entity/EndPortalBlockEntity;Lnet/minecraft/util/math/Matrix4f;Lnet/minecraft/client/render/VertexConsumer;FFFFFFFFLnet/minecraft/util/math/Direction;)V";
	private static final int Y1_ARG = 5;
	private static final int Y2_ARG = 6;
	
	@Shadow
	protected abstract float getTopYOffset();
	
	@Shadow
	protected abstract float getBottomYOffset();
	
	@ModifyArgs(method = METHOD, at = @At(value = "INVOKE", target = TARGET, ordinal = 0))
	private void renderSidesSouth(Args args){
		args.set(Y1_ARG, getBottomYOffset());
		args.set(Y2_ARG, getTopYOffset());
	}
	
	@ModifyArgs(method = METHOD, at = @At(value = "INVOKE", target = TARGET, ordinal = 1))
	private void renderSidesNorth(Args args){
		args.set(Y1_ARG, getTopYOffset());
		args.set(Y2_ARG, getBottomYOffset());
	}
	
	@ModifyArgs(method = METHOD, at = @At(value = "INVOKE", target = TARGET, ordinal = 2))
	private void renderSidesEast(Args args){
		args.set(Y1_ARG, getTopYOffset());
		args.set(Y2_ARG, getBottomYOffset());
	}
	
	@ModifyArgs(method = METHOD, at = @At(value = "INVOKE", target = TARGET, ordinal = 3))
	private void renderSidesWest(Args args){
		args.set(Y1_ARG, getBottomYOffset());
		args.set(Y2_ARG, getTopYOffset());
	}
}
