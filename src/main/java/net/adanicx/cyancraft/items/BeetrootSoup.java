package net.adanicx.cyancraft.items;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSoup;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class BeetrootSoup extends ItemSoup implements IConfigurable {

	public BeetrootSoup() {
		super(6);
		setContainerItem(Items.bowl);
		setTextureName("beetroot_soup");
		setUnlocalizedName(Utilities.getUnlocalizedName("beetroot_soup"));
		setCreativeTab(CyancraftMod.enableBeetroot ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableBeetroot;
	}
}