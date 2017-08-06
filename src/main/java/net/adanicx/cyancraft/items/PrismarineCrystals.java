package net.adanicx.cyancraft.items;
import net.minecraft.item.Item;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class PrismarineCrystals extends Item implements IConfigurable {

	public PrismarineCrystals() {
		setTextureName("prismarine_crystals");
		setUnlocalizedName(Utilities.getUnlocalizedName("prismarine_crystals"));
		setCreativeTab(CyancraftMod.enablePrismarine ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enablePrismarine;
	}
}