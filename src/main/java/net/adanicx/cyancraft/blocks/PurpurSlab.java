package net.adanicx.cyancraft.blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.IBlockAccess;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.CBlocks;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class PurpurSlab extends GenericSlab {

	public PurpurSlab() {
		super(Material.rock, CBlocks.purpur_block);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utilities.getUnlocalizedName("purpur_slab"));
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