package net.adanicx.cyancraft.configuration;
import java.util.ArrayList;
import java.util.List;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

import net.adanicx.cyancraft.libraries.ModReferences;

public class ConfigGUI extends GuiConfig{
	
	public ConfigGUI(GuiScreen parent) {
		super(parent, getElements(), ModReferences.MOD_ID, ModReferences.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.INSTANCE.configFile.toString()));
	}

	@SuppressWarnings({ "rawtypes" })
	private static List<IConfigElement> getElements() {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		for (String category : ConfigurationHandler.INSTANCE.usedCategories)
			list.add(new ConfigElement(ConfigurationHandler.INSTANCE.configFile.getCategory(category)));
		return list;
	}

}
