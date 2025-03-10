package zalgodev;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zalgodev.commands.CommandManager;

public class RceClient implements ModInitializer {
	public static final String MOD_ID = "Rce-Client";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		CommandManager.init();
	}
}