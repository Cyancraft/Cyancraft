package net.adanicx.cyancraft.blocks;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;
import net.minecraft.block.material.Material;

public class TerracottaPink extends BlockGeneric implements IConfigurable{
	public TerracottaPink(){
		super(Material.rock);
		setHardness(1.8F);
		setResistance(9F);
		setBlockTextureName("glazed_terracotta_pink");
		setBlockName(Utilities.getUnlocalizedName("terracottapink"));
		setCreativeTab(CyancraftMod.enableConcrete ? CyancraftMod.creativeTab : null);
	}
	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableConcrete;
	}
}
