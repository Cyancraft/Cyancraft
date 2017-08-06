package net.adanicx.cyancraft.configuration;
import java.io.File;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.enchantment.FrostWalker;
import net.adanicx.cyancraft.enchantment.Mending;
import net.adanicx.cyancraft.libraries.ModReferences;

public class ConfigurationHandler {
	
	public static ConfigurationHandler INSTANCE = new ConfigurationHandler();
	public Configuration configFile;
	public String[] usedCategories = { Configuration.CATEGORY_GENERAL };

	private int configInteger(String name, boolean requireRestart, int def) {
		return configInteger(name, null, requireRestart, def);
	}

	private int configInteger(String name, String tooltip, boolean requireRestart, int def) {
		int config = configFile.get(Configuration.CATEGORY_GENERAL, name, def, tooltip).getInt(def);
		return config >= 0 ? config : def;
	}

	private boolean configBoolean(String name, String tooltip, boolean requireRestart, boolean def) {
		return configFile.get(Configuration.CATEGORY_GENERAL, name, def, tooltip).getBoolean(def);
	}

	private boolean configBoolean(String name, boolean requireRestart, boolean def) {
		return configBoolean(name, null, requireRestart, def);
	}

	public void init(File file) {
		configFile = new Configuration(file);

		syncConfigs();
	}
	
	private void syncConfigs() {
		CyancraftMod.enableStones = configBoolean("Stones", true, CyancraftMod.enableStones);
		CyancraftMod.enableIronTrapdoor = configBoolean("Iron Trapdoor", true, CyancraftMod.enableIronTrapdoor);
		CyancraftMod.enableMutton = configBoolean("Mutton", true, CyancraftMod.enableMutton);
		CyancraftMod.enableSponge = configBoolean("Sponge", true, CyancraftMod.enableSponge);
		CyancraftMod.enablePrismarine = configBoolean("Prismarine", true, CyancraftMod.enablePrismarine);
		CyancraftMod.enableDoors = configBoolean("Doors", true, CyancraftMod.enableDoors);
		CyancraftMod.enableInvertedDaylightSensor = configBoolean("Inverted Daylight Sensor", true, CyancraftMod.enableInvertedDaylightSensor);
		CyancraftMod.enableCoarseDirt = configBoolean("Coarse Dirt", true, CyancraftMod.enableCoarseDirt);
		CyancraftMod.enableRedSandstone = configBoolean("Red Sandstone", true, CyancraftMod.enableRedSandstone);
		CyancraftMod.enableEnchants = configBoolean("Enchanting Table - Note: This breaks Extra Utilities, which needs a Vanilla Enchanting Table", true, CyancraftMod.enableEnchants);
		CyancraftMod.enableAnvil = configBoolean("Anvil", true, CyancraftMod.enableAnvil);
		CyancraftMod.enableFences = configBoolean("Fences and Gates", true, CyancraftMod.enableFences);
		CyancraftMod.enableSilkTouchingMushrooms = configBoolean("Mushroom Blocks", true, CyancraftMod.enableSilkTouchingMushrooms);
		CyancraftMod.enableBanners = configBoolean("Banners", true, CyancraftMod.enableBanners);
		CyancraftMod.enableSlimeBlock = configBoolean("Slime Block", true, CyancraftMod.enableSlimeBlock);
		CyancraftMod.enableArmorStand = configBoolean("Armor Stand", true, CyancraftMod.enableArmorStand);
		CyancraftMod.enableRabbit = configBoolean("Rabbits", true, CyancraftMod.enableRabbit);
		CyancraftMod.enableRecipeForPrismarine = configBoolean("Recipes for prismarine", true, CyancraftMod.enableRecipeForPrismarine);
		CyancraftMod.enableEndermite = configBoolean("Endermite", true, CyancraftMod.enableEndermite);
		CyancraftMod.enableBeetroot = configBoolean("Beetroot", true, CyancraftMod.enableBeetroot);
		CyancraftMod.enableChorusFruit = configBoolean("Chorus Fruit (and related blocks)", true, CyancraftMod.enableChorusFruit);
		CyancraftMod.enableGrassPath = configBoolean("Grass Path", true, CyancraftMod.enableGrassPath);
		CyancraftMod.enableSticksFromDeadBushes = configBoolean("Dead Bushes drop sticks", true, CyancraftMod.enableSticksFromDeadBushes);
		CyancraftMod.enableBowRendering = configBoolean("Bows render pulling animation on inventory", true, CyancraftMod.enableBowRendering);
		CyancraftMod.enableTippedArrows = configBoolean("Tipped Arrows", true, CyancraftMod.enableTippedArrows);
		CyancraftMod.enableLingeringPotions = configBoolean("Lingering Potions", true, CyancraftMod.enableLingeringPotions);
		CyancraftMod.enableDmgIndicator = configBoolean("Heart Damage Indicator", true, CyancraftMod.enableDmgIndicator);
		CyancraftMod.enableTransparentAmour = configBoolean("Allow non-opaque armour", true, CyancraftMod.enableTransparentAmour);
		CyancraftMod.enableUpdatedFoodValues = configBoolean("Use updated food values", true, CyancraftMod.enableUpdatedFoodValues);
		CyancraftMod.enableUpdatedHarvestLevels = configBoolean("Use updated harvest levels", true, CyancraftMod.enableUpdatedHarvestLevels);
		CyancraftMod.enableVillagerZombies = configBoolean("Villager Zombies", true, CyancraftMod.enableVillagerZombies);
		CyancraftMod.enableStoneBrickRecipes = configBoolean("Stone Brick Recipes", true, CyancraftMod.enableStoneBrickRecipes);
		CyancraftMod.enableBabyGrowthBoost = configBoolean("Baby growth boost", true, CyancraftMod.enableBabyGrowthBoost);
		CyancraftMod.enableVillagerTurnsIntoWitch = configBoolean("Villagers turn into Witches when struck by lightning", true, CyancraftMod.enableVillagerTurnsIntoWitch);
		CyancraftMod.enableElytra = configBoolean("Elytra", true, CyancraftMod.enableElytra);
		CyancraftMod.enableFancySkulls = configBoolean("Fancy Skulls", true, CyancraftMod.enableFancySkulls);
		CyancraftMod.enableSkullDrop = configBoolean("Skulls drop from charged creeper kills", true, CyancraftMod.enableSkullDrop);
		CyancraftMod.enableBurnableBlocks = configBoolean("Fences, gates and dead bushes burn", true, CyancraftMod.enableBurnableBlocks);
		CyancraftMod.enableFrostWalker = configBoolean("Frost Walker", true, CyancraftMod.enableFrostWalker);
		CyancraftMod.enableMending = configBoolean("Mending", true, CyancraftMod.enableMending);
		CyancraftMod.enableFrostWalker = configBoolean("Frost Walker", true, CyancraftMod.enableFrostWalker);
		FrostWalker.ID = configInteger("Frost Walker ID - Don't change unless you get a conflict error", true, FrostWalker.ID);
		Mending.ID = configInteger("Mending ID - Don't change unless you get a conflict error", true, Mending.ID);
		CyancraftMod.enableBrewingStands = configBoolean("Brewing Stands", true, CyancraftMod.enableBrewingStands);
		CyancraftMod.enableColorfulBeacons = configBoolean("Colorful Beacon Beams - Note: This breaks Botania and Extra Utilities, which need a Vanilla Beacon", true, CyancraftMod.enableColorfulBeacons);
		CyancraftMod.maxStonesPerCluster = configInteger("Max number of 1.8 stones in a cluster", true, CyancraftMod.maxStonesPerCluster);
		CyancraftMod.enablePlayerSkinOverlay = configBoolean("Skin overlays", true, CyancraftMod.enablePlayerSkinOverlay);
		CyancraftMod.enableShearableGolems = configBoolean("Shearing Snow Golems", true, CyancraftMod.enableShearableGolems);
		CyancraftMod.enableShearableCobwebs = configBoolean("Shears harvest cobwebs", true, CyancraftMod.enableShearableCobwebs);
		CyancraftMod.enableDragonRespawn = configBoolean("Dragon respawning", true, CyancraftMod.enableDragonRespawn);
		CyancraftMod.enableConcrete = configBoolean("Enable Concrete Powder, Concrete, and Terracotta from 1.12", true, CyancraftMod.enableConcrete);
		CyancraftMod.enableShulkerStorage = configBoolean("Craftable Shulker Boxes - until I implement Shulkers", true, CyancraftMod.enableShulkerStorage);

		if (configFile.hasChanged())
			configFile.save();
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (ModReferences.MOD_ID.equals(eventArgs.modID))
			syncConfigs();
	}

}
