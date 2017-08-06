package net.adanicx.cyancraft.core.handlers;
import java.util.HashMap;
import java.util.Map;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.CBlocks;

public class WorldTickEventHandler {

	private static Map<Block, Block> replacements;
	private boolean isReplacing = false;

	@SubscribeEvent
	public void tick(WorldTickEvent event) {
		if (event.side != Side.SERVER || event.phase != Phase.END || isReplacing)
			return;

		if (replacements == null) {
			replacements = new HashMap<Block, Block>();
			if (CyancraftMod.enableBrewingStands)
				replacements.put(Blocks.brewing_stand, CBlocks.brewing_stand);
			if (CyancraftMod.enableColorfulBeacons)
				replacements.put(Blocks.beacon, CBlocks.beacon);
			if (CyancraftMod.enableEnchants)
				replacements.put(Blocks.enchanting_table, CBlocks.enchantment_table);
			if (CyancraftMod.enableInvertedDaylightSensor)
				replacements.put(Blocks.daylight_detector, CBlocks.daylight_sensor);
		}

		if (replacements.isEmpty())
			return;

		isReplacing = true;
		World world = event.world;

		for (int i = 0; i < world.loadedTileEntityList.size(); i++) {
			TileEntity tile = (TileEntity) world.loadedTileEntityList.get(i);
			int x = tile.xCoord;
			int y = tile.yCoord;
			int z = tile.zCoord;
			Block replacement = replacements.get(world.getBlock(x, y, z));
			if (replacement != null && ((IConfigurable) replacement).isEnabled()) {
				NBTTagCompound nbt = new NBTTagCompound();
				tile.writeToNBT(nbt);
				if (tile instanceof IInventory) {
					IInventory invt = (IInventory) tile;
					for (int j = 0; j < invt.getSizeInventory(); j++)
						invt.setInventorySlotContents(j, null);
				}
				world.setBlock(x, y, z, replacement);
				TileEntity newTile = world.getTileEntity(x, y, z);
				newTile.readFromNBT(nbt);
				break;
			}
		}
		isReplacing = false;
	}
	
}
