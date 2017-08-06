package net.adanicx.cyancraft.blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.CBlocks.IBurnableBlock;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class BlockWoodFenceGate extends BlockFenceGate implements IBurnableBlock, IConfigurable {
	
	private final int meta;

	public BlockWoodFenceGate(int meta) {
		this.meta = meta;
		setHardness(2.0F);
		setResistance(5.0F);
		setStepSound(soundTypeWood);
		setBlockName(Utilities.getUnlocalizedName("fence_gate_" + BlockWoodDoor.names[meta]));
		setCreativeTab(CyancraftMod.enableFences ? CyancraftMod.creativeTab : null);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return Blocks.planks.getIcon(side, this.meta);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableFences;
	}

}
