package net.adanicx.cyancraft.client.model;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
@SideOnly(Side.CLIENT)
public class ModelElytra extends ModelBiped {

	private ModelRenderer wingRight;
	private ModelRenderer wingLeft;

	public ModelElytra() {
		wingLeft = new ModelRenderer(this, 22, 0);
		wingLeft.addBox(-10.0F, 0.0F, 0.0F, 10, 20, 2, 1.0F);
		wingRight = new ModelRenderer(this, 22, 0);
		wingRight.mirror = true;
		wingRight.addBox(0.0F, 0.0F, 0.0F, 10, 20, 2, 1.0F);
	}

	@Override
	public void render(Entity entity, float f0, float f1, float f2, float f3, float f4, float f5) {
		wingLeft.render(f5);
		wingRight.render(f5);
	}
}