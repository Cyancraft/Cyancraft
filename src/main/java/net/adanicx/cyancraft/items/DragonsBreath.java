package net.adanicx.cyancraft.items;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class DragonsBreath extends Item implements IConfigurable {

	public DragonsBreath() {
		setPotionEffect("-14+13");
		setTextureName("dragon_breath");
		setContainerItem(Items.glass_bottle);
		setUnlocalizedName(Utilities.getUnlocalizedName("dragon_breath"));
		setCreativeTab(CyancraftMod.enableLingeringPotions ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableLingeringPotions;
	}
}