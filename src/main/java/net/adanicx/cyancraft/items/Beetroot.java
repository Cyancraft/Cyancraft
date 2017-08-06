package net.adanicx.cyancraft.items;
import net.minecraft.item.ItemFood;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class Beetroot extends ItemFood implements IConfigurable {

	public Beetroot() {
		super(1, 0.6F, false);
		setTextureName("beetroot");
		setUnlocalizedName(Utilities.getUnlocalizedName("beetroot"));
		setCreativeTab(CyancraftMod.enableBeetroot ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableBeetroot;
	}
}
