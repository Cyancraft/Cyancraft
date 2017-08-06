package net.adanicx.cyancraft;
import java.lang.reflect.Field;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWood;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;

import net.adanicx.cyancraft.blocks.BlockBanner;
import net.adanicx.cyancraft.blocks.BlockBeetroot;
import net.adanicx.cyancraft.blocks.BlockMushroom;
import net.adanicx.cyancraft.blocks.BlockWoodDoor;
import net.adanicx.cyancraft.blocks.BlockWoodFence;
import net.adanicx.cyancraft.blocks.BlockWoodFenceGate;
import net.adanicx.cyancraft.blocks.ChorusFlower;
import net.adanicx.cyancraft.blocks.ChorusPlant;
import net.adanicx.cyancraft.blocks.CoarseDirt;
import net.adanicx.cyancraft.blocks.ConcreteBlack;
import net.adanicx.cyancraft.blocks.ConcreteBlue;
import net.adanicx.cyancraft.blocks.ConcreteBrown;
import net.adanicx.cyancraft.blocks.ConcreteCyan;
import net.adanicx.cyancraft.blocks.ConcreteGray;
import net.adanicx.cyancraft.blocks.ConcreteGreen;
import net.adanicx.cyancraft.blocks.ConcreteLightBlue;
import net.adanicx.cyancraft.blocks.ConcreteLime;
import net.adanicx.cyancraft.blocks.ConcreteMagenta;
import net.adanicx.cyancraft.blocks.ConcreteOrange;
import net.adanicx.cyancraft.blocks.ConcretePink;
import net.adanicx.cyancraft.blocks.ConcretePowderBlack;
import net.adanicx.cyancraft.blocks.ConcretePowderBlue;
import net.adanicx.cyancraft.blocks.ConcretePowderBrown;
import net.adanicx.cyancraft.blocks.ConcretePowderCyan;
import net.adanicx.cyancraft.blocks.ConcretePowderGray;
import net.adanicx.cyancraft.blocks.ConcretePowderGreen;
import net.adanicx.cyancraft.blocks.ConcretePowderLightBlue;
import net.adanicx.cyancraft.blocks.ConcretePowderLime;
import net.adanicx.cyancraft.blocks.ConcretePowderMagenta;
import net.adanicx.cyancraft.blocks.ConcretePowderOrange;
import net.adanicx.cyancraft.blocks.ConcretePowderPink;
import net.adanicx.cyancraft.blocks.ConcretePowderPurple;
import net.adanicx.cyancraft.blocks.ConcretePowderRed;
import net.adanicx.cyancraft.blocks.ConcretePowderSilver;
import net.adanicx.cyancraft.blocks.ConcretePowderWhite;
import net.adanicx.cyancraft.blocks.ConcretePowderYellow;
import net.adanicx.cyancraft.blocks.ConcretePurple;
import net.adanicx.cyancraft.blocks.ConcreteRed;
import net.adanicx.cyancraft.blocks.ConcreteSilver;
import net.adanicx.cyancraft.blocks.ConcreteWhite;
import net.adanicx.cyancraft.blocks.ConcreteYellow;
import net.adanicx.cyancraft.blocks.EndBricks;
import net.adanicx.cyancraft.blocks.EndRod;
import net.adanicx.cyancraft.blocks.FrostedIce;
import net.adanicx.cyancraft.blocks.GrassPath;
import net.adanicx.cyancraft.blocks.InvertedDaylightDetector;
import net.adanicx.cyancraft.blocks.IronTrapdoor;
import net.adanicx.cyancraft.blocks.NewAnvil;
import net.adanicx.cyancraft.blocks.NewBeacon;
import net.adanicx.cyancraft.blocks.NewBrewingStand;
import net.adanicx.cyancraft.blocks.NewDaylightSensor;
import net.adanicx.cyancraft.blocks.NewEnchantmentTable;
import net.adanicx.cyancraft.blocks.PrismarineBlocks;
import net.adanicx.cyancraft.blocks.PurpurBlock;
import net.adanicx.cyancraft.blocks.PurpurPillar;
import net.adanicx.cyancraft.blocks.PurpurSlab;
import net.adanicx.cyancraft.blocks.PurpurStairs;
import net.adanicx.cyancraft.blocks.RedSandstone;
import net.adanicx.cyancraft.blocks.RedSandstoneSlab;
import net.adanicx.cyancraft.blocks.RedSandstoneStairs;
import net.adanicx.cyancraft.blocks.SeaLantern;
import net.adanicx.cyancraft.blocks.SlimeBlock;
import net.adanicx.cyancraft.blocks.Sponge;
import net.adanicx.cyancraft.blocks.Stone;
import net.adanicx.cyancraft.blocks.TerracottaBlack;
import net.adanicx.cyancraft.blocks.TerracottaBlue;
import net.adanicx.cyancraft.blocks.TerracottaBrown;
import net.adanicx.cyancraft.blocks.TerracottaCyan;
import net.adanicx.cyancraft.blocks.TerracottaGray;
import net.adanicx.cyancraft.blocks.TerracottaGreen;
import net.adanicx.cyancraft.blocks.TerracottaLightBlue;
import net.adanicx.cyancraft.blocks.TerracottaLime;
import net.adanicx.cyancraft.blocks.TerracottaMagenta;
import net.adanicx.cyancraft.blocks.TerracottaOrange;
import net.adanicx.cyancraft.blocks.TerracottaPink;
import net.adanicx.cyancraft.blocks.TerracottaPurple;
import net.adanicx.cyancraft.blocks.TerracottaRed;
import net.adanicx.cyancraft.blocks.TerracottaSilver;
import net.adanicx.cyancraft.blocks.TerracottaWhite;
import net.adanicx.cyancraft.blocks.TerracottaYellow;

public class CBlocks {

	public static final Block stone = new Stone();
	public static final Block iron_trapdoor = new IronTrapdoor();
	public static final Block prismarine = new PrismarineBlocks();
	public static final Block sea_lantern = new SeaLantern();
	public static final Block inverted_daylight_detector = new InvertedDaylightDetector();
	public static final Block red_sandstone = new RedSandstone();
	public static final Block red_sandstone_slab = new RedSandstoneSlab();
	public static final Block red_sandstone_stairs = new RedSandstoneStairs();
	public static final Block brown_mushroom_block = new BlockMushroom(Blocks.brown_mushroom_block, "brown");
	public static final Block red_mushroom_block = new BlockMushroom(Blocks.red_mushroom_block, "red");
	public static final Block coarse_dirt = new CoarseDirt();
	public static final Block banner = new BlockBanner();
	public static final Block slime = new SlimeBlock();
	public static final Block sponge = new Sponge();
	public static final Block beetroot = new BlockBeetroot();
	public static final Block purpur_block = new PurpurBlock();
	public static final Block purpur_pillar = new PurpurPillar();
	public static final Block purpur_stairs = new PurpurStairs();
	public static final Block purpur_slab = new PurpurSlab();
	public static final Block end_bricks = new EndBricks();
	public static final Block grass_path = new GrassPath();
	public static final Block end_rod = new EndRod();
	public static final Block chorus_plant = new ChorusPlant();
	public static final Block chorus_flower = new ChorusFlower();
	public static final Block frosted_ice = new FrostedIce();
	public static final Block brewing_stand = new NewBrewingStand();
	public static final Block beacon = new NewBeacon();
	public static final Block enchantment_table = new NewEnchantmentTable();
	public static final Block anvil = new NewAnvil();
	public static final Block daylight_sensor = new NewDaylightSensor();
	public static final Block terracottablack = new TerracottaBlack();
	public static final Block terracottablue = new TerracottaBlue();
	public static final Block terracottabrown = new TerracottaBrown();
	public static final Block terracottacyan = new TerracottaCyan();
	public static final Block terracottagray = new TerracottaGray();
	public static final Block terracottagreen = new TerracottaGreen();
	public static final Block terracottalightblue = new TerracottaLightBlue();
	public static final Block terracottalime = new TerracottaLime();
	public static final Block terracottamagenta = new TerracottaMagenta();
	public static final Block terracottaorange = new TerracottaOrange();
	public static final Block terracottapink = new TerracottaPink();
	public static final Block terracottapurple = new TerracottaPurple();
	public static final Block terracottared = new TerracottaRed();
	public static final Block terracottasilver = new TerracottaSilver();
	public static final Block terracottawhite = new TerracottaWhite();
	public static final Block terracottayellow = new TerracottaYellow();
	public static final Block concreteblack = new ConcreteBlack();
	public static final Block concreteblue = new ConcreteBlue();
	public static final Block concretebrown = new ConcreteBrown();
	public static final Block concretecyan = new ConcreteCyan();
	public static final Block concretegray = new ConcreteGray();
	public static final Block concretegreen = new ConcreteGreen();
	public static final Block concretelightblue = new ConcreteLightBlue();
	public static final Block concretelime = new ConcreteLime();
	public static final Block concretemagenta = new ConcreteMagenta();
	public static final Block concreteorange = new ConcreteOrange();
	public static final Block concretepink = new ConcretePink();
	public static final Block concretepurple = new ConcretePurple();
	public static final Block concretered = new ConcreteRed();
	public static final Block concretesilver = new ConcreteSilver();
	public static final Block concretewhite = new ConcreteWhite();
	public static final Block concreteyellow = new ConcreteYellow();
	public static final Block concretepowderblack = new ConcretePowderBlack();
	public static final Block concretepowderblue = new ConcretePowderBlue();
	public static final Block concretepowderbrown = new ConcretePowderBrown();
	public static final Block concretepowdercyan = new ConcretePowderCyan();
	public static final Block concretepowdergray = new ConcretePowderGray();
	public static final Block concretepowdergreen = new ConcretePowderGreen();
	public static final Block concretepowderlightblue = new ConcretePowderLightBlue();
	public static final Block concretepowderlime = new ConcretePowderLime();
	public static final Block concretepowdermagenta = new ConcretePowderMagenta();
	public static final Block concretepowderorange = new ConcretePowderOrange();
	public static final Block concretepowderpink = new ConcretePowderPink();
	public static final Block concretepowderpurple = new ConcretePowderPurple();
	public static final Block concretepowderred = new ConcretePowderRed();
	public static final Block concretepowdersilver = new ConcretePowderSilver();
	public static final Block concretepowderwhite = new ConcretePowderWhite();
	public static final Block concretepowderyellow = new ConcretePowderYellow();
	
	public static final Block[] doors = new Block[BlockWood.field_150096_a.length - 1];
	public static final Block[] fences = new Block[BlockWood.field_150096_a.length];
	public static final Block[] gates = new Block[BlockWood.field_150096_a.length - 1];

	static {
		for (int i = 0; i < doors.length; i++)
			doors[i] = new BlockWoodDoor(i + 1);

		for (int i = 0; i < fences.length; i++)
			fences[i] = new BlockWoodFence(i);

		for (int i = 0; i < gates.length; i++)
			gates[i] = new BlockWoodFenceGate(i + 1);
	}

	public static void init() {
		try {
			for (Field f : CBlocks.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if (obj instanceof Block)
					registerBlock((Block) obj);
				else if (obj instanceof Block[])
					for (Block block : (Block[]) obj)
						if (block != null)
							registerBlock(block);
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private static void registerBlock(Block block) {
		if (!(block instanceof IConfigurable) || ((IConfigurable) block).isEnabled()) {
			String name = block.getUnlocalizedName();
			String[] strings = name.split("\\.");

			if (block instanceof ISubBlocksBlock)
				GameRegistry.registerBlock(block, ((ISubBlocksBlock) block).getItemBlockClass(), strings[strings.length - 1]);
			else
				GameRegistry.registerBlock(block, strings[strings.length - 1]);

			if (block instanceof IBurnableBlock)
				Blocks.fire.setFireInfo(block, 5, 20);
		}
	}

	public static interface ISubBlocksBlock {

		Class<? extends ItemBlock> getItemBlockClass();
	}

	public static interface IBurnableBlock {
	}
}
