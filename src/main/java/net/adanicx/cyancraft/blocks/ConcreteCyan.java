package net.adanicx.cyancraft.blocks;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ConcreteCyan extends Block implements IConfigurable{
	public ConcreteCyan(){
		super(Material.rock);
		setHardness(1.8F);
		setResistance(9F);
		setBlockTextureName("concrete_cyan");
		setBlockName(Utilities.getUnlocalizedName("concretecyan"));
		setCreativeTab(CyancraftMod.enableConcrete ? CyancraftMod.creativeTab : null);
	}
	
	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableConcrete;
	}
}
