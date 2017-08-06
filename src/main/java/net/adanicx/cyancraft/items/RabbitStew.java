package net.adanicx.cyancraft.items;
import net.minecraft.item.ItemSoup;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class RabbitStew extends ItemSoup implements IConfigurable {

	public RabbitStew() {
		super(10);
		setTextureName("rabbit_stew");
		setUnlocalizedName(Utilities.getUnlocalizedName("rabbit_stew"));
		setCreativeTab(CyancraftMod.enableRabbit ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableRabbit;
	}
}