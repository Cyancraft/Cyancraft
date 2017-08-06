package net.adanicx.cyancraft.client.renderer.entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import net.adanicx.cyancraft.client.OpenGLHelper;
import net.adanicx.cyancraft.client.model.ModelArmorStand;
import net.adanicx.cyancraft.client.model.ModelArmorStandArmor;

@SideOnly(Side.CLIENT)
public class ArmorStandRenderer extends RenderBiped {

	private static final ResourceLocation TEXTURE_ARMOR_STAND = new ResourceLocation("textures/entity/armorstand/wood.png");

	public ArmorStandRenderer() {
		super(new ModelArmorStand(), 0.0F);
		modelBipedMain = (ModelBiped) mainModel;
		field_82423_g = new ModelArmorStandArmor(1.0F);
		field_82425_h = new ModelArmorStandArmor(0.5F);
	}

	@Override
	protected void func_82421_b() {
		field_82423_g = new ModelArmorStandArmor(1.0F);
		field_82425_h = new ModelArmorStandArmor(0.5F);
	}

	@Override
	protected void rotateCorpse(EntityLivingBase entity, float x, float y, float z) {
		OpenGLHelper.rotate(180.0F - y, 0.0F, 1.0F, 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return TEXTURE_ARMOR_STAND;
	}
}