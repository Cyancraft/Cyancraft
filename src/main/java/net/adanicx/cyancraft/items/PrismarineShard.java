package net.adanicx.cyancraft.items;
import net.minecraft.item.Item;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class PrismarineShard extends Item implements IConfigurable {

	public PrismarineShard() {
		setTextureName("prismarine_shard");
		setUnlocalizedName(Utilities.getUnlocalizedName("prismarine_shard"));
		setCreativeTab(CyancraftMod.enablePrismarine ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enablePrismarine;
	}
}