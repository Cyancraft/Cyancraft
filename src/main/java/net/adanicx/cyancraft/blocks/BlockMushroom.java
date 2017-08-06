package net.adanicx.cyancraft.blocks;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class BlockMushroom extends Block implements IConfigurable{

	private final Block block;

	public BlockMushroom(Block block, String str) {
		super(Material.wood);
		this.block = block;
		setHardness(0.2F);
		setStepSound(soundTypeWood);
		setBlockName(Utilities.getUnlocalizedName(str + "_mushroom"));
		setCreativeTab(CyancraftMod.enableSilkTouchingMushrooms ? CyancraftMod.creativeTab : null);
	}

	@Override
	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	public int quantityDropped(Random rand) {
		return Math.max(0, rand.nextInt(10) - 7);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return block.getItemDropped(meta, rand, fortune);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return block.getIcon(side, 14);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableSilkTouchingMushrooms;
	}
	
}
