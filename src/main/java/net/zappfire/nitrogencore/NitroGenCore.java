package net.zappfire.nitrogencore;

import net.fabricmc.api.ModInitializer;
import net.zappfire.nitrogencore.world.dimension.ModDimensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NitroGenCore implements ModInitializer {
	public static final String MODID = "nitrogen-core";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);



	@Override
	public void onInitialize() {
		LOGGER.info("NitroGen-Core has been initialized!");
		ModDimensions.register();
	}
}
