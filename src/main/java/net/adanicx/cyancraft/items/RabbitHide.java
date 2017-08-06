package net.adanicx.cyancraft.items;
import net.minecraft.item.Item;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class RabbitHide extends Item implements IConfigurable {

	public RabbitHide() {
		setTextureName("rabbit_hide");
		setUnlocalizedName(Utilities.getUnlocalizedName("rabbit_hide"));
		setCreativeTab(CyancraftMod.enableRabbit ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableRabbit;
	}
}