package net.adanicx.cyancraft.blocks;
import net.minecraft.block.BlockStairs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.IBlockAccess;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.CBlocks;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class PurpurStairs extends BlockStairs implements IConfigurable {

	public PurpurStairs() {
		super(CBlocks.purpur_block, 0);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utilities.getUnlocalizedName("purpur_stairs"));
		setCreativeTab(CyancraftMod.enableChorusFruit ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		return !(entity instanceof EntityDragon);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableChorusFruit;
	}
}