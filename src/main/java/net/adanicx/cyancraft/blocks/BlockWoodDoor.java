package net.adanicx.cyancraft.blocks;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.CBlocks.ISubBlocksBlock;
import net.adanicx.cyancraft.core.utilities.Utilities;
import net.adanicx.cyancraft.items.block.ItemWoodDoor;
import net.adanicx.cyancraft.libraries.RenderIDs;

public class BlockWoodDoor  extends BlockDoor implements ISubBlocksBlock, IConfigurable {
	
	public static final String[] names = new String[] { "oak", "spruce", "birch", "jungle", "acacia", "dark_oak" };

	public BlockWoodDoor(int meta) {
		super(Material.wood);
		String name = names[meta];

		disableStats();
		setHardness(3.0F);
		setStepSound(soundTypeWood);
		setBlockTextureName("door_" + name);
		setBlockName(Utilities.getUnlocalizedName("door_" + name));
		setCreativeTab(CyancraftMod.enableDoors ? CyancraftMod.creativeTab : null);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return (meta & 8) != 0 ? null : Item.getItemFromBlock(this);
	}

	@Override
	public int getRenderType() {
		return RenderIDs.DOOR;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getItemIconName() {
		return getTextureName();
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemWoodDoor.class;
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableDoors;
	}

}
