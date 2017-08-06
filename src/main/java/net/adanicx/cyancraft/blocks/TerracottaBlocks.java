package net.adanicx.cyancraft.blocks;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class TerracottaBlocks extends BlockGeneric implements IConfigurable {
	
	public static final int BLACK = 1;
	public static final int BLUE = 2;
	public static final int BROWN = 3;
	public static final int CYAN = 4;
	public static final int GRAY = 5;
	public static final int GREEN = 6;
	public static final int LIGHT_BLUE = 7;
	public static final int LIME = 8;
	public static final int MAGENTA = 9;
	public static final int ORANGE = 10;
	public static final int PINK = 11;
	public static final int PURPLE = 12;
	public static final int RED = 13;
	public static final int SILVER = 14;
	public static final int WHITE = 15;
	public static final int YELLOW = 16;
	
	public TerracottaBlocks(){
		super(Material.rock, "", "black", "blue", "brown", "cyan", "gray", "green", "light_blue", "lime", "magenta", "orange", "pink", "purple", "red", "silver", "white", "yellow");
		startMeta = 1;
		setHardness(1.8F);
		setResistance(9F);
		setBlockTextureName("glazed_terracotta");
		setBlockName(Utilities.getUnlocalizedName("terracotta"));
		setCreativeTab(CyancraftMod.enableConcrete ? CyancraftMod.creativeTab : null);
	}
	
	
	
	@SideOnly(Side.CLIENT)
	public void setIcon(int index, IIcon icon) {
		if (icons == null)
			icons = new IIcon[types.length];
		icons[index] = icon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		if (icons == null)
			icons = new IIcon[types.length];
		
		for (int i = 1; i < types.length; i++)
			if ("".equals(types[i]))
				icons[i] = reg.registerIcon(getTextureName());
			else
				icons[i] = reg.registerIcon(getTextureName() + "_" + types[i]);
	}
	
	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableConcrete;
	}
	
	

}
