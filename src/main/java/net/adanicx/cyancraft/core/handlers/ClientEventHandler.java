package net.adanicx.cyancraft.core.handlers;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderPlayerEvent.SetArmorModel;
import net.minecraftforge.client.event.TextureStitchEvent;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.CBlocks;
import net.adanicx.cyancraft.blocks.PrismarineBlocks;
import net.adanicx.cyancraft.client.OpenGLHelper;
import net.adanicx.cyancraft.client.PrismarineIcon;

public class ClientEventHandler {
	
	public static final ClientEventHandler INSTANCE = new ClientEventHandler();

	private ClientEventHandler() {
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void loadTextures(TextureStitchEvent.Pre event) {
		if (CyancraftMod.enablePrismarine)
			if (event.map.getTextureType() == 0) {
				TextureAtlasSprite icon = new PrismarineIcon("prismarine_rough");
				if (event.map.setTextureEntry("prismarine_rough", icon))
					((PrismarineBlocks) CBlocks.prismarine).setIcon(0, icon);
				else
					((PrismarineBlocks) CBlocks.prismarine).setIcon(0, event.map.registerIcon("prismarine_rough"));
			}
	}

	@SubscribeEvent
	public void renderPlayerEventPre(RenderPlayerEvent.Pre event) {
		if (CyancraftMod.enableTransparentAmour) {
			OpenGLHelper.enableBlend();
			OpenGLHelper.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		}
	}

	@SubscribeEvent
	public void renderPlayerSetArmour(SetArmorModel event) {
		if (CyancraftMod.enableTransparentAmour) {
			OpenGLHelper.enableBlend();
			OpenGLHelper.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		}
	}

	@SubscribeEvent
	public void renderPlayerEventPost(RenderPlayerEvent.Post event) {
		if (CyancraftMod.enableTransparentAmour)
			OpenGLHelper.disableBlend();
	}

}
