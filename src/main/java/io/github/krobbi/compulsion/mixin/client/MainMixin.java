package io.github.krobbi.compulsion.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import io.github.krobbi.compulsion.CompulsionMod;
import net.minecraft.client.main.Main;

/**
 * Mixin for the Main class. Disables data fixer optimization.
 */
@Mixin(Main.class)
public abstract class MainMixin {
	/**
	 * Mixes into the main method to disable data fixer optimization. This is
	 * done by calling the secondary main method's {@code optimizeDataFixer}
	 * argument with {@code false} instead of {@code true}.
	 * 
	 * @param optimizeDataFixer Whether the game should be started with data fixer optimization.
	 * @return The value to replace {@code optimizeDataFixer} with, always
	 * {@code false}.
	 */
	@ModifyArg(method = "main([Ljava/lang/String;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/main/Main;main([Ljava/lang/String;Z)V"), index = 1)
	private static boolean main(boolean optimizeDataFixer){
		CompulsionMod.LOGGER.debug("Disabled data fixer optimization");
		return false;
	}
}
