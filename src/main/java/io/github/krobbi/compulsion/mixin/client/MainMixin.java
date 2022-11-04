package io.github.krobbi.compulsion.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import io.github.krobbi.compulsion.CompulsionMod;
import net.minecraft.client.main.Main;

@Mixin(Main.class)
public abstract class MainMixin {
	@ModifyVariable(at = @At("HEAD"), method = "main([Ljava/lang/String;Z)V", ordinal = 0)
	private static boolean main(boolean optimizeDataFixer){
		CompulsionMod.LOGGER.debug("Disabled data fixer optimization");
		return false;
	}
}
