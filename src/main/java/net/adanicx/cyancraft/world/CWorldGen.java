package net.adanicx.cyancraft.world;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.util.ForgeDirection;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.CBlocks;
import net.adanicx.cyancraft.blocks.ChorusFlower;

public class CWorldGen implements IWorldGenerator {
	
	private final List<WorldGenMinable> generators = new LinkedList<WorldGenMinable>();

	public CWorldGen() {
		generators.add(new WorldGenMinable(CBlocks.stone, 1, CyancraftMod.maxStonesPerCluster, Blocks.stone));
		generators.add(new WorldGenMinable(CBlocks.stone, 3, CyancraftMod.maxStonesPerCluster, Blocks.stone));
		generators.add(new WorldGenMinable(CBlocks.stone, 5, CyancraftMod.maxStonesPerCluster, Blocks.stone));
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (CyancraftMod.enableCoarseDirt && world.provider.dimensionId != -1 && world.provider.dimensionId != 1)
			for (int x = chunkX * 16; x < chunkX * 16 + 16; x++)
				for (int z = chunkZ * 16; z < chunkZ * 16 + 16; z++)
					for (int y = 0; y < world.getActualHeight(); y++)
						if (world.getBlock(x, y, z) == Blocks.dirt && world.getBlockMetadata(x, y, z) == 1)
							world.setBlock(x, y, z, CBlocks.coarse_dirt, 0, 2);

		if (CyancraftMod.enableStones && CyancraftMod.maxStonesPerCluster > 0 && world.provider.dimensionId != -1 && world.provider.dimensionId != 1)
			for (Iterator<WorldGenMinable> iterator = generators.iterator(); iterator.hasNext();) {
				WorldGenMinable generator = iterator.next();
				for (int i = 0; i < 10; i++) {
					int x = chunkX * 16 + rand.nextInt(16);
					int y = rand.nextInt(80);
					int z = chunkZ * 16 + rand.nextInt(16);

					generator.generate(world, rand, x, y, z);
				}
			}

		if (CyancraftMod.enablePrismarine && world.provider.dimensionId != -1 && world.provider.dimensionId != 1)
			if (OceanTemple.canSpawnAt(world, chunkX, chunkZ)) {
				int x = chunkX * 16 + rand.nextInt(16);
				int y = 256;
				int z = chunkZ * 16 + rand.nextInt(16);
				for (; y > 0; y--)
					if (!world.getBlock(x, y, z).isAir(world, x, y, z))
						break;
				int monumentCeiling = y - (1 + rand.nextInt(3));
				OceanTemple.buildTemple(world, x, monumentCeiling - 22, z);
				return;
			}

		if (CyancraftMod.enableChorusFruit && world.provider.dimensionId == 1) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = 256;
			int z = chunkZ * 16 + rand.nextInt(16);
			for (; y > 0; y--)
				if (!world.getBlock(x, y, z).isAir(world, x, y, z))
					break;
			if (y > 0 && ChorusFlower.canPlantStay(world, x, y + 1, z))
				generateChorusPlant(world, x, y + 1, z, 0);
		}
	}

	public static void generateChorusPlant(World world, int x, int y, int z, int pass) {
		int height;
		for (height = 0; height < 4; height++) {
			if (!ChorusFlower.canPlantStay(world, x, y + height, z)) {
				world.setBlock(x, y + height, z, CBlocks.chorus_flower, 5, 2);
				break;
			}
			world.setBlock(x, y + height, z, CBlocks.chorus_plant);
		}
		if (height > 1) {
			world.setBlock(x, y + height, z, CBlocks.chorus_plant);
			boolean grew = false;

			if (pass < 5) {
				ForgeDirection[] dirs = new ForgeDirection[] { ForgeDirection.EAST, ForgeDirection.WEST, ForgeDirection.NORTH, ForgeDirection.SOUTH };
				for (int j = 0; j < world.rand.nextInt(4); j++) {
					ForgeDirection dir = dirs[world.rand.nextInt(dirs.length)];
					int xx = x + dir.offsetX;
					int yy = y + height + dir.offsetY;
					int zz = z + dir.offsetZ;
					if (world.isAirBlock(xx, yy, zz) && ChorusFlower.isSpaceAroundFree(world, xx, yy, zz, dir.getOpposite())) {
						generateChorusPlant(world, xx, yy, zz, pass + 1);
						grew = true;
					}
				}
			}

			if (!grew)
				world.setBlock(x, y + height, z, CBlocks.chorus_flower, 5, 2);
		}
	}

}
