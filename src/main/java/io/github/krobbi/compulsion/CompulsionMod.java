package io.github.krobbi.compulsion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;

public class CompulsionMod implements ModInitializer {
	public static final String MOD_ID = "compulsion";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	@Override
	public void onInitialize(){
		LOGGER.info("Compulsion mod initialized");
	}
}
