package net.adanicx.cyancraft.blocks;
import net.minecraft.block.BlockSandStone;
import net.minecraft.item.ItemBlock;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.CBlocks.ISubBlocksBlock;
import net.adanicx.cyancraft.core.utilities.Utilities;
import net.adanicx.cyancraft.items.block.ItemBlockRedSandstone;

public class RedSandstone extends BlockSandStone implements ISubBlocksBlock, IConfigurable {

	public RedSandstone() {
		setHardness(0.8F);
		setBlockTextureName("red_sandstone");
		setBlockName(Utilities.getUnlocalizedName("red_sandstone"));
		setCreativeTab(CyancraftMod.enableRedSandstone ? CyancraftMod.creativeTab : null);
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemBlockRedSandstone.class;
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableRedSandstone;
	}
}