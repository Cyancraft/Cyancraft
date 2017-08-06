package net.adanicx.cyancraft.items;
import net.minecraft.item.ItemFood;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class MuttonRaw extends ItemFood {

	public MuttonRaw() {
		super(2, 0.3F, true);
		setTextureName("mutton_raw");
		setUnlocalizedName(Utilities.getUnlocalizedName("mutton_raw"));
		setCreativeTab(CyancraftMod.enableMutton ? CyancraftMod.creativeTab : null);
	}
}