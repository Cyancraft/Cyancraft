package net.adanicx.cyancraft.recipes;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.CBlocks;
import net.adanicx.cyancraft.CItems;
import net.adanicx.cyancraft.blocks.Stone;
import net.adanicx.cyancraft.libraries.EnumColor;
import net.adanicx.cyancraft.libraries.ModReferences;
public class CRecipes {
	
	public static String[] dyes = new String[] { "dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple", "dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite" };

	public static void init() {
		if (CyancraftMod.enableBanners) {
			RecipeSorter.register(ModReferences.MOD_ID + ".RecipeDuplicatePattern", RecipeDuplicatePattern.class, Category.SHAPELESS, "after:minecraft:shapeless");
			RecipeSorter.register(ModReferences.MOD_ID + ".RecipeAddPattern", RecipeAddPattern.class, Category.SHAPED, "after:minecraft:shaped");
		}

		registerOreDictionary();
		registerRecipes();
		tweakRecipes();
	}

	private static void tweakRecipes() {
		if (CyancraftMod.enableDoors) {
			Items.wooden_door.setMaxStackSize(64);
			Items.iron_door.setMaxStackSize(64);
			removeFirstRecipeFor(Items.wooden_door);
			removeFirstRecipeFor(Items.iron_door);
		}

		if (CyancraftMod.enableFences) {
			removeFirstRecipeFor(Blocks.fence);
			removeFirstRecipeFor(Blocks.fence_gate);
			Blocks.fence.setCreativeTab(null);
			Blocks.fence_gate.setCreativeTab(null);
		}

		if (CyancraftMod.enableBurnableBlocks) {
			Blocks.fire.setFireInfo(Blocks.fence_gate, 5, 20);
			Blocks.fire.setFireInfo(Blocks.fence, 5, 20);
			Blocks.fire.setFireInfo(Blocks.deadbush, 60, 100);
		}
	}

	private static void registerOreDictionary() {
		OreDictionary.registerOre("chestWood", new ItemStack(Blocks.chest));
		OreDictionary.registerOre("trapdoorWood", Blocks.trapdoor);

		if (CyancraftMod.enablePrismarine) {
			OreDictionary.registerOre("shardPrismarine", new ItemStack(CItems.prismarine_shard));
			OreDictionary.registerOre("crystalPrismarine", new ItemStack(CItems.prismarine_crystals));
			OreDictionary.registerOre("blockPrismarine", new ItemStack(CBlocks.prismarine, 1, OreDictionary.WILDCARD_VALUE));
		}

		if (CyancraftMod.enableStones) {
			OreDictionary.registerOre("stoneGranite", new ItemStack(CBlocks.stone, 1, Stone.GRANITE));
			OreDictionary.registerOre("stoneDiorite", new ItemStack(CBlocks.stone, 1, Stone.DIORITE));
			OreDictionary.registerOre("stoneAndesite", new ItemStack(CBlocks.stone, 1, Stone.ANDESITE));
			OreDictionary.registerOre("stoneGranitePolished", new ItemStack(CBlocks.stone, 1, Stone.POLISHED_GRANITE));
			OreDictionary.registerOre("stoneDioritePolished", new ItemStack(CBlocks.stone, 1, Stone.POLISHED_DIORITE));
			OreDictionary.registerOre("stoneAndesitePolished", new ItemStack(CBlocks.stone, 1, Stone.POLISHED_ANDESITE));
		}

		if (CyancraftMod.enableSlimeBlock)
			OreDictionary.registerOre("blockSlime", new ItemStack(CBlocks.slime));

		if (CyancraftMod.enableIronTrapdoor)
			OreDictionary.registerOre("trapdoorIron", CBlocks.iron_trapdoor);

		if (CyancraftMod.enableBeetroot)
			OreDictionary.registerOre("cropBeetroot", CItems.beetroot);

		if (CyancraftMod.enableChorusFruit)
			OreDictionary.registerOre("brickEndStone", CBlocks.end_bricks);
	}

	private static void registerRecipes() {
		if (CyancraftMod.enableStoneBrickRecipes) {
			addShapelessRecipe(new ItemStack(Blocks.mossy_cobblestone), new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.vine));
			addShapelessRecipe(new ItemStack(Blocks.stonebrick, 1, 1), new ItemStack(Blocks.stonebrick), new ItemStack(Blocks.vine));
			addShapedRecipe(new ItemStack(Blocks.stonebrick, 1, 3), "x", "x", 'x', new ItemStack(Blocks.stone_slab, 1, 5));
			GameRegistry.addSmelting(new ItemStack(Blocks.stonebrick), new ItemStack(Blocks.stonebrick, 1, 2), 0.0F);
		}

		if (CyancraftMod.enableSlimeBlock) {
			addShapedRecipe(new ItemStack(CBlocks.slime), "xxx", "xxx", "xxx", 'x', "slimeball");
			addShapelessRecipe(new ItemStack(Items.slime_ball, 9), CBlocks.slime);
		}

		if (CyancraftMod.enableCoarseDirt)
			addShapedRecipe(new ItemStack(CBlocks.coarse_dirt, 4), "xy", "yx", 'x', new ItemStack(Blocks.dirt), 'y', new ItemStack(Blocks.gravel));

		if (CyancraftMod.enableMutton)
			GameRegistry.addSmelting(CItems.raw_mutton, new ItemStack(CItems.cooked_mutton), 0.35F);

		if (CyancraftMod.enableIronTrapdoor)
			addShapedRecipe(new ItemStack(CBlocks.iron_trapdoor), "xx", "xx", 'x', "ingotIron");

		if (CyancraftMod.enableStones) {
			// Diorite
			addShapedRecipe(new ItemStack(CBlocks.stone, 2, Stone.DIORITE), "xy", "yx", 'x', new ItemStack(Blocks.cobblestone), 'y', "gemQuartz");
			addShapedRecipe(new ItemStack(CBlocks.stone, 4, Stone.POLISHED_DIORITE), "xx", "xx", 'x', "stoneDiorite");
			// Andesite
			addShapelessRecipe(new ItemStack(CBlocks.stone, 2, Stone.ANDESITE), new ItemStack(Blocks.cobblestone), "stoneDiorite");
			addShapedRecipe(new ItemStack(CBlocks.stone, 4, Stone.POLISHED_ANDESITE), "xx", "xx", 'x', "stoneAndesite");
			// Granite
			addShapelessRecipe(new ItemStack(CBlocks.stone, 2, Stone.GRANITE), "gemQuartz", "stoneDiorite");
			addShapedRecipe(new ItemStack(CBlocks.stone, 4, Stone.POLISHED_GRANITE), "xx", "xx", 'x', "stoneGranite");
		}

		if (CyancraftMod.enablePrismarine) {
			int PLAIN = 0;
			int BRICKS = 1;
			int DARK = 2;

			addShapedRecipe(new ItemStack(CBlocks.prismarine, 1, DARK), "xxx", "xyx", "xxx", 'x', "shardPrismarine", 'y', "dyeBlack");
			addShapedRecipe(new ItemStack(CBlocks.prismarine, 1, PLAIN), "xx", "xx", 'x', "shardPrismarine");
			addShapedRecipe(new ItemStack(CBlocks.prismarine, 1, BRICKS), "xxx", "xxx", "xxx", 'x', "shardPrismarine");
			addShapedRecipe(new ItemStack(CBlocks.sea_lantern), "xyx", "yyy", "xyx", 'x', "shardPrismarine", 'y', "crystalPrismarine");

			if (CyancraftMod.enableRecipeForPrismarine && !Loader.isModLoaded("Botania")) {
				addShapedRecipe(new ItemStack(CItems.prismarine_shard, 4), "xy", "zx", 'x', "gemQuartz", 'y', "dyeBlue", 'z', "dyeGreen");
				addShapedRecipe(new ItemStack(CItems.prismarine_crystals, 4), "xy", "yx", 'x', "gemQuartz", 'y', "dustGlowstone");
			}
		}

		if (CyancraftMod.enableDoors) {
			for (int i = 0; i < CBlocks.doors.length; i++)
				addShapedRecipe(new ItemStack(CBlocks.doors[i], 3), "xx", "xx", "xx", 'x', new ItemStack(Blocks.planks, 1, i + 1));
			addShapedRecipe(new ItemStack(Items.wooden_door, 3), "xx", "xx", "xx", 'x', "plankWood");
			addShapedRecipe(new ItemStack(Items.iron_door, 3), "xx", "xx", "xx", 'x', "ingotIron");
		}

		if (CyancraftMod.enableRedSandstone) {
			addShapedRecipe(new ItemStack(CBlocks.red_sandstone), "xx", "xx", 'x', new ItemStack(Blocks.sand, 1, 1));
			addShapedRecipe(new ItemStack(CBlocks.red_sandstone, 1, 1), "x", "x", 'x', new ItemStack(CBlocks.red_sandstone_slab));
			addShapedRecipe(new ItemStack(CBlocks.red_sandstone, 4, 2), "xx", "xx", 'x', new ItemStack(CBlocks.red_sandstone));
			addShapedRecipe(new ItemStack(CBlocks.red_sandstone_slab, 6), "xxx", 'x', CBlocks.red_sandstone);
			addShapedRecipe(new ItemStack(CBlocks.red_sandstone_stairs, 4), "x  ", "xx ", "xxx", 'x', CBlocks.red_sandstone);
		}

		if (CyancraftMod.enableFences) {
			for (int i = 0; i < CBlocks.fences.length; i++)
				addShapedRecipe(new ItemStack(CBlocks.fences[i], 3), "xyx", "xyx", 'x', new ItemStack(Blocks.planks, 1, i), 'y', "stickWood");
			addShapedRecipe(new ItemStack(CBlocks.fences[0], 3), "xyx", "xyx", 'x', "plankWood", 'y', "stickWood");
			addShapelessRecipe(new ItemStack(Blocks.fence), CBlocks.fences[0]);
			addShapelessRecipe(new ItemStack(CBlocks.fences[0]), Blocks.fence);

			for (int i = 0; i < CBlocks.gates.length; i++)
				addShapedRecipe(new ItemStack(CBlocks.gates[i]), "yxy", "yxy", 'x', new ItemStack(Blocks.planks, 1, i + 1), 'y', "stickWood");
			addShapedRecipe(new ItemStack(Blocks.fence_gate), "yxy", "yxy", 'x', "plankWood", 'y', "stickWood");
		}

		if (CyancraftMod.enableBanners) {
			for (EnumColor colour : EnumColor.values())
				addShapedRecipe(new ItemStack(CBlocks.banner, 1, colour.getDamage()), new Object[] { "xxx", "xxx", " y ", 'x', new ItemStack(Blocks.wool, 1, colour.getDamage()), 'y', "stickWood" });
			GameRegistry.addRecipe(new RecipeDuplicatePattern());
			GameRegistry.addRecipe(new RecipeAddPattern());
		}

		if (CyancraftMod.enableArmorStand)
			addShapedRecipe(new ItemStack(CItems.armor_stand), "xxx", " x ", "xyx", 'x', "stickWood", 'y', new ItemStack(Blocks.stone_slab));

		if (CyancraftMod.enableRabbit) {
			addShapedRecipe(new ItemStack(CItems.rabbit_stew), " R ", "CPM", " B ", 'R', new ItemStack(CItems.cooked_rabbit), 'C', Items.carrot, 'P', Items.baked_potato, 'M', Blocks.brown_mushroom, 'B', Items.bowl);
			addShapedRecipe(new ItemStack(CItems.rabbit_stew), " R ", "CPD", " B ", 'R', new ItemStack(CItems.cooked_rabbit), 'C', Items.carrot, 'P', Items.baked_potato, 'D', Blocks.red_mushroom, 'B', Items.bowl);
			GameRegistry.addSmelting(CItems.raw_rabbit, new ItemStack(CItems.cooked_rabbit), 0.35F);
			addShapedRecipe(new ItemStack(Items.leather), "xx", "xx", 'x', CItems.rabbit_hide);
		}

		if (CyancraftMod.enableSponge) {
			addShapelessRecipe(new ItemStack(CBlocks.sponge), Blocks.sponge);
			addShapelessRecipe(new ItemStack(Blocks.sponge), CBlocks.sponge);
			GameRegistry.addSmelting(new ItemStack(CBlocks.sponge, 1, 1), new ItemStack(CBlocks.sponge), 0.0F);
		}

		if (CyancraftMod.enableBeetroot) {
			addShapedRecipe(new ItemStack(CItems.beetroot_soup), "xxx", "xxx", " y ", 'x', "cropBeetroot", 'y', Items.bowl);
			addShapelessRecipe(new ItemStack(Items.dye, 1, 1), "cropBeetroot");
		}

		if (CyancraftMod.enableChorusFruit) {
			addShapedRecipe(new ItemStack(CBlocks.purpur_block, 4), "xx", "xx", 'x', CItems.popped_chorus_fruit);
			addShapedRecipe(new ItemStack(CBlocks.purpur_stairs, 4), "x  ", "xx ", "xxx", 'x', CBlocks.purpur_block);
			addShapedRecipe(new ItemStack(CBlocks.purpur_slab, 6), "xxx", 'x', CBlocks.purpur_block);
			addShapedRecipe(new ItemStack(CBlocks.purpur_pillar), "x", "x", 'x', CBlocks.purpur_slab);
			addShapedRecipe(new ItemStack(CBlocks.end_bricks), "xx", "xx", 'x', Blocks.end_stone);
			GameRegistry.addSmelting(new ItemStack(CItems.chorus_fruit), new ItemStack(CItems.popped_chorus_fruit), 0.0F);
			addShapedRecipe(new ItemStack(CBlocks.end_rod), "x", "y", 'x', Items.blaze_rod, 'y', CItems.popped_chorus_fruit);
		}

		if (CyancraftMod.enableLingeringPotions)
			addShapelessRecipe(new ItemStack(CItems.dragon_breath), new ItemStack(Items.potionitem, 1, 8195), CItems.chorus_fruit, CItems.chorus_fruit);

		if (CyancraftMod.enableDragonRespawn)
			addShapedRecipe(new ItemStack(CItems.end_crystal), "xxx", "xyx", "xzx", 'x', "blockGlassColorless", 'y', Items.ender_eye, 'z', Items.ghast_tear);


		if (CyancraftMod.enableTippedArrows && CyancraftMod.enableLingeringPotions) {
			RecipeSorter.register(ModReferences.MOD_ID + ".RecipeTippedArrow", RecipeTippedArrow.class, Category.SHAPED, "after:minecraft:shaped");
			GameRegistry.addRecipe(new RecipeTippedArrow(new ItemStack(CItems.tipped_arrow), "xxx", "xyx", "xxx", 'x', Items.arrow, 'y', new ItemStack(CItems.lingering_potion, 1, OreDictionary.WILDCARD_VALUE)));
		}
	}

	private static void addShapedRecipe(ItemStack output, Object... objects) {
		GameRegistry.addRecipe(new ShapedOreRecipe(output, objects));
	}

	private static void addShapelessRecipe(ItemStack output, Object... objects) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(output, objects));
	}

	private static void removeFirstRecipeFor(Block block) {
		removeFirstRecipeFor(Item.getItemFromBlock(block));
	}

	private static void removeFirstRecipeFor(Item item) {
		for (Object recipe : CraftingManager.getInstance().getRecipeList())
			if (recipe != null) {
				ItemStack stack = ((IRecipe) recipe).getRecipeOutput();
				if (stack != null && stack.getItem() == item) {
					CraftingManager.getInstance().getRecipeList().remove(recipe);
					return;
				}
			}
	}

}
