package net.adanicx.cyancraft.blocks;
import net.minecraft.block.BlockStairs;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.CBlocks;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class RedSandstoneStairs extends BlockStairs implements IConfigurable {

	public RedSandstoneStairs() {
		super(CBlocks.red_sandstone, 0);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utilities.getUnlocalizedName("red_sandstone_stairs"));
		setCreativeTab(CyancraftMod.enableRedSandstone ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableRedSandstone;
	}
}