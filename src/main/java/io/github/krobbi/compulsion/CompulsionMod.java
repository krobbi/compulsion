package io.github.krobbi.compulsion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;

/**
 * The Compulsion mod's mod initializer. Stores the mod's mod ID and a logger.
 */
public class CompulsionMod implements ModInitializer {
	/**
	 * The Compulsion mod's mod ID.
	 */
	public static final String MOD_ID = "compulsion";
	
	/**
	 * The Compulsion mod's logger. Used for all logging in the mod.
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	static {
		LOGGER.debug("Debug messages from Compulsion mod are available");
	}
	
	/**
	 * Runs the Compulsion mod's mod initializer. Logs an info message.
	 */
	@Override
	public void onInitialize(){
		LOGGER.info("Compulsion mod initialized");
	}
}
