package net.adanicx.cyancraft.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.adanicx.cyancraft.CBlocks.ISubBlocksBlock;
import net.adanicx.cyancraft.items.block.ItemBlockGeneric;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class GenericGravityBlock extends BlockFalling implements ISubBlocksBlock {
	

	public GenericGravityBlock(Material material, String... types) {
		super(material);
		
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemBlockGeneric.class;
	}


}