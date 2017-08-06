package net.adanicx.cyancraft.core.proxy;
import java.util.LinkedList;
import java.util.List;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.MinecraftForge;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.core.utilities.Utilities;
import net.adanicx.cyancraft.client.gui.inventory.GuiAnvil;
import net.adanicx.cyancraft.client.gui.inventory.GuiEnchantment;
import net.adanicx.cyancraft.client.gui.inventory.GuiNewBrewingStand;
import net.adanicx.cyancraft.configuration.ConfigurationHandler;
import net.adanicx.cyancraft.core.handlers.ServerEventHandler;
import net.adanicx.cyancraft.core.handlers.WorldTickEventHandler;
import net.adanicx.cyancraft.entities.EntityArmorStand;
import net.adanicx.cyancraft.entities.EntityEndermite;
import net.adanicx.cyancraft.entities.EntityLingeringEffect;
import net.adanicx.cyancraft.entities.EntityLingeringPotion;
import net.adanicx.cyancraft.entities.EntityNewSnowGolem;
import net.adanicx.cyancraft.entities.EntityPlacedEndCrystal;
import net.adanicx.cyancraft.entities.EntityRabbit;
import net.adanicx.cyancraft.entities.EntityRespawnedDragon;
import net.adanicx.cyancraft.entities.EntityTippedArrow;
import net.adanicx.cyancraft.entities.EntityZombieVillager;
import net.adanicx.cyancraft.entities.ModEntityList;
import net.adanicx.cyancraft.inventory.ContainerAnvil;
import net.adanicx.cyancraft.inventory.ContainerEnchantment;
import net.adanicx.cyancraft.inventory.ContainerNewBrewingStand;
import net.adanicx.cyancraft.libraries.GUIsID;
import net.adanicx.cyancraft.tileentities.TileEntityBanner;
import net.adanicx.cyancraft.tileentities.TileEntityEndRod;
import net.adanicx.cyancraft.tileentities.TileEntityNewBeacon;
import net.adanicx.cyancraft.tileentities.TileEntityNewBrewingStand;

public class CommonProxy implements IGuiHandler{
	public void registerEvents() {
		FMLCommonHandler.instance().bus().register(new WorldTickEventHandler());
		FMLCommonHandler.instance().bus().register(ConfigurationHandler.INSTANCE);
		FMLCommonHandler.instance().bus().register(ServerEventHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(ServerEventHandler.INSTANCE);
	}
	public void registerEntities() {
		if (CyancraftMod.enableBanners)
			GameRegistry.registerTileEntity(TileEntityBanner.class, Utilities.getUnlocalizedName("banner"));
		if (CyancraftMod.enableArmorStand)
			ModEntityList.registerEntity(EntityArmorStand.class, "wooden_armorstand", 0, CyancraftMod.instance, 64, 1, true);
		if (CyancraftMod.enableEndermite)
			ModEntityList.registerEntity(EntityEndermite.class, "endermite", 1, CyancraftMod.instance, 64, 1, true, 1447446, 7237230);
		if (CyancraftMod.enableChorusFruit)
			GameRegistry.registerTileEntity(TileEntityEndRod.class, Utilities.getUnlocalizedName("end_rod"));
		if (CyancraftMod.enableTippedArrows)
			ModEntityList.registerEntity(EntityTippedArrow.class, "tipped_arrow", 2, CyancraftMod.instance, 64, 20, true);
		if (CyancraftMod.enableBrewingStands)
			GameRegistry.registerTileEntity(TileEntityNewBrewingStand.class, Utilities.getUnlocalizedName("brewing_stand"));
		if (CyancraftMod.enableColorfulBeacons)
			GameRegistry.registerTileEntity(TileEntityNewBeacon.class, Utilities.getUnlocalizedName("beacon"));
		if (CyancraftMod.enableRabbit) {
			ModEntityList.registerEntity(EntityRabbit.class, "rabbit", 3, CyancraftMod.instance, 80, 3, true, 10051392, 7555121);

			List<BiomeGenBase> biomes = new LinkedList<BiomeGenBase>();
			label: for (BiomeGenBase biome : BiomeGenBase.getBiomeGenArray())
				if (biome != null)
					// Check if pigs can spawn on this biome
					for (Object obj : biome.getSpawnableList(EnumCreatureType.creature))
						if (obj instanceof SpawnListEntry) {
							SpawnListEntry entry = (SpawnListEntry) obj;
							if (entry.entityClass == EntityPig.class) {
								biomes.add(biome);
								continue label;
							}
						}
			EntityRegistry.addSpawn(EntityRabbit.class, 10, 3, 3, EnumCreatureType.creature, biomes.toArray(new BiomeGenBase[biomes.size()]));
		}

		if (CyancraftMod.enableLingeringPotions) {
			ModEntityList.registerEntity(EntityLingeringPotion.class, "lingering_potion", 4, CyancraftMod.instance, 64, 10, true);
			ModEntityList.registerEntity(EntityLingeringEffect.class, "lingering_effect", 5, CyancraftMod.instance, 64, 1, true);
		}

		if (CyancraftMod.enableVillagerZombies)
			ModEntityList.registerEntity(EntityZombieVillager.class, "villager_zombie", 6, CyancraftMod.instance, 80, 3, true, 44975, 7969893);

		if (CyancraftMod.enableDragonRespawn) {
			ModEntityList.registerEntity(EntityPlacedEndCrystal.class, "end_crystal", 7, CyancraftMod.instance, 256, Integer.MAX_VALUE, false);
			ModEntityList.registerEntity(EntityRespawnedDragon.class, "ender_dragon", 8, CyancraftMod.instance, 160, 3, true);
		}

		if (CyancraftMod.enableShearableGolems)
			ModEntityList.registerEntity(EntityNewSnowGolem.class, "snow_golem", 9, CyancraftMod.instance, 80, 3, true);
	}

	public void registerRenderers() {
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case GUIsID.ENCHANTING_TABLE:
				return new ContainerEnchantment(player.inventory, world, x, y, z);
			case GUIsID.ANVIL:
				return new ContainerAnvil(player, world, x, y, z);
			case GUIsID.BREWING_STAND:
				return new ContainerNewBrewingStand(player.inventory, (TileEntityNewBrewingStand) world.getTileEntity(x, y, z));
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case GUIsID.ENCHANTING_TABLE:
				return new GuiEnchantment(player.inventory, world, null);
			case GUIsID.ANVIL:
				return new GuiAnvil(player, world, x, y, z);
			case GUIsID.BREWING_STAND:
				return new GuiNewBrewingStand(player.inventory, (TileEntityNewBrewingStand) world.getTileEntity(x, y, z));
			default:
				return null;
		}
	}
}