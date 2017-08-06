package net.adanicx.cyancraft.blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.world.World;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;
import net.adanicx.cyancraft.libraries.GUIsID;
import net.adanicx.cyancraft.tileentities.TileEntityNewBrewingStand;

public class NewBrewingStand extends BlockBrewingStand implements IConfigurable {

	public NewBrewingStand() {
		setHardness(0.5F);
		setLightLevel(0.125F);
		setBlockTextureName("brewing_stand");
		setBlockName(Utilities.getUnlocalizedName("brewing_stand"));
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return true;
		else {
			TileEntityBrewingStand tile = (TileEntityBrewingStand) world.getTileEntity(x, y, z);
			if (tile != null)
				player.openGui(CyancraftMod.instance, GUIsID.BREWING_STAND, world, x, y, z);

			return true;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Items.brewing_stand;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityNewBrewingStand();
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableBrewingStands;
	}
}