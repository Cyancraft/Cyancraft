package net.adanicx.cyancraft.blocks;
import net.minecraft.block.material.Material;


import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.CBlocks;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class RedSandstoneSlab extends GenericSlab {

	public RedSandstoneSlab() {
		super(Material.rock, CBlocks.red_sandstone);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utilities.getUnlocalizedName("red_sandstone_slab"));
		setCreativeTab(CyancraftMod.enableRedSandstone ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableRedSandstone;
	}
}