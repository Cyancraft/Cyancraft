package net.adanicx.cyancraft.items;
import net.minecraft.item.ItemFood;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class MuttonCooked extends ItemFood implements IConfigurable {

	public MuttonCooked() {
		super(6, 0.8F, true);
		setTextureName("mutton_cooked");
		setUnlocalizedName(Utilities.getUnlocalizedName("mutton_cooked"));
		setCreativeTab(CyancraftMod.enableMutton ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableMutton;
	}
}