package net.adanicx.cyancraft.blocks;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBeacon;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;
import net.adanicx.cyancraft.tileentities.TileEntityNewBeacon;

public class NewBeacon extends BlockBeacon implements IConfigurable {

	public NewBeacon() {
		setLightLevel(1.0F);
		setCreativeTab(null);
		setBlockTextureName("beacon");
		setBlockName(Utilities.getUnlocalizedName("beacon"));
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return Item.getItemFromBlock(Blocks.beacon);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(Blocks.beacon);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityNewBeacon();
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableColorfulBeacons;
	}
}