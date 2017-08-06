package net.adanicx.cyancraft.items;
import net.minecraft.item.Item;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class PoppedChorusFruit extends Item implements IConfigurable {

	public PoppedChorusFruit() {
		setTextureName("chorus_fruit_popped");
		setUnlocalizedName(Utilities.getUnlocalizedName("chorus_fruit_popped"));
		setCreativeTab(CyancraftMod.enableChorusFruit ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableChorusFruit;
	}
}