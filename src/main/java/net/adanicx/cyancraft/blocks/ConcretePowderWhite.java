package net.adanicx.cyancraft.blocks;

import net.adanicx.cyancraft.CBlocks;
import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.blocks.GenericGravityBlock;
import net.adanicx.cyancraft.core.utilities.Utilities;
import net.adanicx.cyancraft.libraries.CMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class ConcretePowderWhite extends GenericGravityBlock implements IConfigurable {
	
	
	
	public ConcretePowderWhite(){
		super(CMaterials.concretepowder);
		setHardness(0.5F);
		setResistance(2.5F);
		setStepSound(soundTypeSand);
		setBlockTextureName("concrete_powder_white");
		setBlockName(Utilities.getUnlocalizedName("concretepowderwhite"));
		setCreativeTab(CyancraftMod.enableConcrete ? CyancraftMod.creativeTab : null);
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        this.func_149805_n(world, x, y, z);
    }
	
	private void func_149805_n(World World, int x, int y, int z)
    {
        if (World.getBlock(x, y, z) == this)
        {
           
			if (this.blockMaterial == CMaterials.concretepowder)
            {
                boolean flag = false;

                if (flag || World.getBlock(x, y, z - 1).getMaterial() == Material.water)
                {
                    flag = true;
                }

                if (flag || World.getBlock(x, y, z + 1).getMaterial() == Material.water)
                {
                    flag = true;
                }

                if (flag || World.getBlock(x - 1, y, z).getMaterial() == Material.water)
                {
                    flag = true;
                }

                if (flag || World.getBlock(x + 1, y, z).getMaterial() == Material.water)
                {
                    flag = true;
                }

                if (flag || World.getBlock(x, y + 1, z).getMaterial() == Material.water)
                {
                    flag = true;
                }
                
                if (flag || World.getBlock(x, y - 1, z).getMaterial() == Material.water)
                {
                	flag = true;
                }

                if (flag)
                {
                    int l = World.getBlockMetadata(x, y, z);

                    if (l == 0)
                    {
                        World.setBlock(x, y, z, CBlocks.concretewhite);
                    }
                }
            }
        }
    }
	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableConcrete;
	}

}
