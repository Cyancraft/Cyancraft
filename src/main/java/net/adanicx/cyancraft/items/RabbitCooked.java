package net.adanicx.cyancraft.items;
import net.minecraft.item.ItemFood;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class RabbitCooked extends ItemFood implements IConfigurable {

	public RabbitCooked() {
		super(5, 0.6F, true);
		setTextureName("rabbit_cooked");
		setUnlocalizedName(Utilities.getUnlocalizedName("rabbit_cooked"));
		setCreativeTab(CyancraftMod.enableRabbit ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableRabbit;
	}
}