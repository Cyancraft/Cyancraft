package net.adanicx.cyancraft.blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.CItems;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class BlockBeetroot extends BlockCrops implements IConfigurable {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockBeetroot() {
		setCreativeTab(null);
		setBlockTextureName("beetroots");
		setBlockName(Utilities.getUnlocalizedName("beetroots"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (meta < 7) {
			if (meta == 6)
				meta = 5;
			return icons[meta >> 1];
		} else
			return icons[3];
	}

	@Override
	protected Item func_149866_i() {
		return CItems.beetroot_seeds;
	}

	@Override
	protected Item func_149865_P() {
		return CItems.beetroot;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		icons = new IIcon[4];
		for (int i = 0; i < icons.length; i++)
			icons[i] = reg.registerIcon(getTextureName() + "_stage_" + i);
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableBeetroot;
	}

}
