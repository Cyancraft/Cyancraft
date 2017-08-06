package net.adanicx.cyancraft.core.proxy;
import java.io.File;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.CBlocks;
import net.adanicx.cyancraft.client.renderer.block.BlockChestRenderer;
import net.adanicx.cyancraft.client.renderer.block.BlockChorusFlowerRenderer;
import net.adanicx.cyancraft.client.renderer.block.BlockChorusPlantRenderer;
import net.adanicx.cyancraft.client.renderer.block.BlockDoorRenderer;
import net.adanicx.cyancraft.client.renderer.block.BlockEndRodRenderer;
import net.adanicx.cyancraft.client.renderer.block.BlockSlimeBlockRenderer;
import net.adanicx.cyancraft.client.renderer.entity.ArmorStandRenderer;
import net.adanicx.cyancraft.client.renderer.entity.EndermiteRenderer;
import net.adanicx.cyancraft.client.renderer.entity.LingeringEffectRenderer;
import net.adanicx.cyancraft.client.renderer.entity.LingeringPotionRenderer;
import net.adanicx.cyancraft.client.renderer.entity.NewSnowGolemRenderer;
import net.adanicx.cyancraft.client.renderer.entity.PlacedEndCrystalRenderer;
import net.adanicx.cyancraft.client.renderer.entity.RabbitRenderer;
import net.adanicx.cyancraft.client.renderer.entity.VillagerZombieRenderer;
import net.adanicx.cyancraft.client.renderer.item.ItemBannerRenderer;
import net.adanicx.cyancraft.client.renderer.item.ItemBowRenderer;
import net.adanicx.cyancraft.client.renderer.item.ItemSkullRenderer;
import net.adanicx.cyancraft.client.renderer.tileentity.TileEntityBannerRenderer;
import net.adanicx.cyancraft.client.renderer.tileentity.TileEntityEndRodRenderer;
import net.adanicx.cyancraft.client.renderer.tileentity.TileEntityFancySkullRenderer;
import net.adanicx.cyancraft.client.renderer.tileentity.TileEntityNewBeaconRenderer;
import net.adanicx.cyancraft.client.skins.NewRenderPlayer;
import net.adanicx.cyancraft.client.skins.NewSkinManager;
import net.adanicx.cyancraft.core.handlers.ClientEventHandler;
import net.adanicx.cyancraft.entities.EntityArmorStand;
import net.adanicx.cyancraft.entities.EntityEndermite;
import net.adanicx.cyancraft.entities.EntityLingeringEffect;
import net.adanicx.cyancraft.entities.EntityLingeringPotion;
import net.adanicx.cyancraft.entities.EntityNewSnowGolem;
import net.adanicx.cyancraft.entities.EntityPlacedEndCrystal;
import net.adanicx.cyancraft.entities.EntityRabbit;
import net.adanicx.cyancraft.entities.EntityZombieVillager;
import net.adanicx.cyancraft.tileentities.TileEntityBanner;
import net.adanicx.cyancraft.tileentities.TileEntityEndRod;
import net.adanicx.cyancraft.tileentities.TileEntityNewBeacon;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerEvents() {
		super.registerEvents();
		FMLCommonHandler.instance().bus().register(ClientEventHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(ClientEventHandler.INSTANCE);
	}

	@Override
	public void registerRenderers() {
		registerItemRenderers();
		registerBlockRenderers();
		registerEntityRenderers();
	}

	private void registerItemRenderers() {
		if (CyancraftMod.enableBanners)
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CBlocks.banner), new ItemBannerRenderer());
		if (CyancraftMod.enableFancySkulls)
			MinecraftForgeClient.registerItemRenderer(Items.skull, new ItemSkullRenderer());
		if (CyancraftMod.enableBowRendering)
			MinecraftForgeClient.registerItemRenderer(Items.bow, new ItemBowRenderer());
	}

	private void registerBlockRenderers() {
		if (CyancraftMod.enableSlimeBlock)
			RenderingRegistry.registerBlockHandler(new BlockSlimeBlockRenderer());

		if (CyancraftMod.enableDoors)
			RenderingRegistry.registerBlockHandler(new BlockDoorRenderer());

		if (CyancraftMod.enableBanners)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBanner.class, new TileEntityBannerRenderer());

		if (CyancraftMod.enableFancySkulls)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySkull.class, new TileEntityFancySkullRenderer());

		if (CyancraftMod.enableChorusFruit) {
			RenderingRegistry.registerBlockHandler(new BlockEndRodRenderer());
			RenderingRegistry.registerBlockHandler(new BlockChorusFlowerRenderer());
			RenderingRegistry.registerBlockHandler(new BlockChorusPlantRenderer());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEndRod.class, new TileEntityEndRodRenderer());
		}

		if (CyancraftMod.enableColorfulBeacons)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNewBeacon.class, new TileEntityNewBeaconRenderer());

		RenderingRegistry.registerBlockHandler(new BlockChestRenderer());
	}

	@SuppressWarnings("unchecked")
	private void registerEntityRenderers() {
		if (CyancraftMod.enableArmorStand)
			RenderingRegistry.registerEntityRenderingHandler(EntityArmorStand.class, new ArmorStandRenderer());
		if (CyancraftMod.enableEndermite)
			RenderingRegistry.registerEntityRenderingHandler(EntityEndermite.class, new EndermiteRenderer());
		if (CyancraftMod.enableRabbit)
			RenderingRegistry.registerEntityRenderingHandler(EntityRabbit.class, new RabbitRenderer());
		if (CyancraftMod.enableLingeringPotions) {
			RenderingRegistry.registerEntityRenderingHandler(EntityLingeringPotion.class, new LingeringPotionRenderer());
			RenderingRegistry.registerEntityRenderingHandler(EntityLingeringEffect.class, new LingeringEffectRenderer());
		}
		if (CyancraftMod.enableVillagerZombies)
			RenderingRegistry.registerEntityRenderingHandler(EntityZombieVillager.class, new VillagerZombieRenderer());
		if (CyancraftMod.enableDragonRespawn)
			RenderingRegistry.registerEntityRenderingHandler(EntityPlacedEndCrystal.class, new PlacedEndCrystalRenderer());
		if (CyancraftMod.enablePlayerSkinOverlay) {
			TextureManager texManager = Minecraft.getMinecraft().renderEngine;
			File fileAssets = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), "fileAssets", "field_110446_Y", " field_110607_c");
			File skinFolder = new File(fileAssets, "skins");
			MinecraftSessionService sessionService = Minecraft.getMinecraft().func_152347_ac();
			ReflectionHelper.setPrivateValue(Minecraft.class, Minecraft.getMinecraft(), new NewSkinManager(Minecraft.getMinecraft().func_152342_ad(), texManager, skinFolder, sessionService), "field_152350_aA");

			RenderManager.instance.entityRenderMap.put(EntityPlayer.class, new NewRenderPlayer());
		}
		if (CyancraftMod.enableShearableGolems)
			RenderingRegistry.registerEntityRenderingHandler(EntityNewSnowGolem.class, new NewSnowGolemRenderer());
	}

}
