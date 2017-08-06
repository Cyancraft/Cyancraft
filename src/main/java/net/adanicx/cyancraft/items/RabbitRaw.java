package net.adanicx.cyancraft.items;
import net.minecraft.item.ItemFood;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class RabbitRaw extends ItemFood implements IConfigurable {

	public RabbitRaw() {
		super(3, 0.3F, true);
		setTextureName("rabbit_raw");
		setUnlocalizedName(Utilities.getUnlocalizedName("rabbit_raw"));
		setCreativeTab(CyancraftMod.enableRabbit ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableRabbit;
	}
}