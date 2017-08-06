package net.adanicx.cyancraft.blocks;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ConcretePink extends Block implements IConfigurable{
	public ConcretePink(){
		super(Material.rock);
		setHardness(1.8F);
		setResistance(9F);
		setBlockTextureName("concrete_pink");
		setBlockName(Utilities.getUnlocalizedName("concretepink"));
		setCreativeTab(CyancraftMod.enableConcrete ? CyancraftMod.creativeTab : null);
	}
	
	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableConcrete;
	}
}
