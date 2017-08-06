package net.adanicx.cyancraft.items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.CBlocks;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class BeetrootSeeds extends ItemSeeds implements IConfigurable {

	public BeetrootSeeds() {
		super(CBlocks.beetroot, Blocks.farmland);
		setTextureName("beetroot_seeds");
		setUnlocalizedName(Utilities.getUnlocalizedName("beetroot_seeds"));
		setCreativeTab(CyancraftMod.enableBeetroot ? CyancraftMod.creativeTab : null);

		if (CyancraftMod.enableBeetroot) {
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
		}
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableBeetroot;
	}
}