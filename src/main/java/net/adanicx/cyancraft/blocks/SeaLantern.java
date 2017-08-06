package net.adanicx.cyancraft.blocks;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.CItems;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class SeaLantern extends Block implements IConfigurable {

	public SeaLantern() {
		super(Material.glass);
		setHardness(0.3F);
		setLightLevel(1.0F);
		setStepSound(soundTypeGlass);
		setBlockTextureName("sea_lantern");
		setBlockName(Utilities.getUnlocalizedName("sea_lantern"));
		setCreativeTab(CyancraftMod.enablePrismarine ? CyancraftMod.creativeTab : null);
	}

	@Override
	public int quantityDropped(Random random) {
		return 2 + random.nextInt(2);
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		return MathHelper.clamp_int(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 5);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return CItems.prismarine_crystals;
	}

	@Override
	public MapColor getMapColor(int meta) {
		return MapColor.quartzColor;
	}

	@Override
	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enablePrismarine;
	}
}