package net.adanicx.cyancraft.blocks;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class IronTrapdoor extends BlockTrapDoor implements IConfigurable {

	public IronTrapdoor() {
		super(Material.iron);
		setHardness(5.0F);
		setStepSound(soundTypeMetal);
		setBlockTextureName("iron_trapdoor");
		setBlockName(Utilities.getUnlocalizedName("iron_trapdoor"));
		setCreativeTab(CyancraftMod.enableIronTrapdoor ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableIronTrapdoor;
	}
}