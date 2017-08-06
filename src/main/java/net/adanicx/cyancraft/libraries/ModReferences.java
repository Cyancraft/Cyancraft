package net.adanicx.cyancraft.libraries;

public class ModReferences {
	public static final String MOD_ID = "cyancraft";
	public static final String MOD_NAME = "Cyancraft Mod";
	public static final String DEPENDENCIES = "required-after:Forge@[10.13.4.1558,);";
	public static final String VERSION_NUMBER = "a_0.0.25";
	public static final String ITEM_BLOCK_TEXTURE_PATH = MOD_ID + ":";
	public static final String ARMOUR_TEXTURE_PATH = ITEM_BLOCK_TEXTURE_PATH + "textures/models/armor/";
	public static final String ENTITY_TEXTURE_PATH = ITEM_BLOCK_TEXTURE_PATH + "textures/entities/";

	public static final String GUI_FACTORY_CLASS = "net.adanicx.cyancraft.configuration.ConfigGuiFactory";
	public static final String SERVER_PROXY_CLASS = "net.adanicx.cyancraft.core.proxy.CommonProxy";
	public static final String CLIENT_PROXY_CLASS = "net.adanicx.cyancraft.core.proxy.ClientProxy";

}
