package net.adanicx.cyancraft.client.renderer.entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
@SideOnly(Side.CLIENT)
public class LingeringEffectRenderer extends Render {

	public LingeringEffectRenderer() {
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float p_76986_9_) {
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return null;
	}
}