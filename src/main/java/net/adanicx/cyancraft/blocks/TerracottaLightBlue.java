package net.adanicx.cyancraft.blocks;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;
import net.minecraft.block.material.Material;

public class TerracottaLightBlue extends BlockGeneric implements IConfigurable{
	public TerracottaLightBlue(){
		super(Material.rock);
		setHardness(1.8F);
		setResistance(9F);
		setBlockTextureName("glazed_terracotta_light_blue");
		setBlockName(Utilities.getUnlocalizedName("terracottalightblue"));
		setCreativeTab(CyancraftMod.enableConcrete ? CyancraftMod.creativeTab : null);
	}
	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableConcrete;
	}
}
