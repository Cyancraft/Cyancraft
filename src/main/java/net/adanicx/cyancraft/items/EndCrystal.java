package net.adanicx.cyancraft.items;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSimpleFoiled;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;
import net.adanicx.cyancraft.entities.EntityPlacedEndCrystal;

public class EndCrystal extends ItemSimpleFoiled implements IConfigurable {

	public EndCrystal() {
		setTextureName("end_crystal");
		setUnlocalizedName(Utilities.getUnlocalizedName("end_crystal"));
		setCreativeTab(CyancraftMod.enableDragonRespawn ? CyancraftMod.creativeTab : null);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (side != 1)
			return false;

		Block block = world.getBlock(x, y, z);
		if (block == Blocks.obsidian || block == Blocks.bedrock)
			if (world.isAirBlock(x, y + 1, z)) {
				if (!world.isRemote) {
					EntityPlacedEndCrystal endCrystal = new EntityPlacedEndCrystal(world);
					endCrystal.setPosition(x + 0.5, y, z + 0.5);
					endCrystal.setBlockPos(x, y, z);

					world.spawnEntityInWorld(endCrystal);
					if (!player.capabilities.isCreativeMode)
						stack.stackSize--;
				}
				return true;
			}

		return false;
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableDragonRespawn;
	}
}