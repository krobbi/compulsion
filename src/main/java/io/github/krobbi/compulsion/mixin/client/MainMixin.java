package io.github.krobbi.compulsion.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import io.github.krobbi.compulsion.CompulsionMod;
import net.minecraft.client.main.Main;

@Mixin(Main.class)
public abstract class MainMixin {
	@ModifyArg(method = "main([Ljava/lang/String;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/main/Main;main([Ljava/lang/String;Z)V"), index = 1)
	private static boolean main(boolean optimizeDataFixer){
		CompulsionMod.LOGGER.debug("Disabled data fixer optimization");
		return false;
	}
}
