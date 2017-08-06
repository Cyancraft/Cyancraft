package net.adanicx.cyancraft.client.renderer.entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import net.adanicx.cyancraft.client.model.ModelVillagerZombie;
import net.adanicx.cyancraft.entities.EntityZombieVillager;

@SideOnly(Side.CLIENT)
public class VillagerZombieRenderer extends RenderLiving {

	private static final ResourceLocation BUTCHER = new ResourceLocation("textures/entity/zombie_villager/zombie_butcher.png");
	private static final ResourceLocation FARMER = new ResourceLocation("textures/entity/zombie_villager/zombie_farmer.png");
	private static final ResourceLocation LIBRARIAN = new ResourceLocation("textures/entity/zombie_villager/zombie_librarian.png");
	private static final ResourceLocation PRIEST = new ResourceLocation("textures/entity/zombie_villager/zombie_priest.png");
	private static final ResourceLocation SMITH = new ResourceLocation("textures/entity/zombie_villager/zombie_smith.png");
	private static final ResourceLocation VILLAGER = new ResourceLocation("textures/entity/zombie_villager/zombie_villager.png");

	public VillagerZombieRenderer() {
		super(new ModelVillagerZombie(0), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		EntityZombieVillager zombie = (EntityZombieVillager) entity;
		switch (zombie.getType()) {
			case 0:
				return FARMER;
			case 1:
				return LIBRARIAN;
			case 2:
				return PRIEST;
			case 3:
				return SMITH;
			case 4:
				return BUTCHER;
			case 5:
			default:
				return VILLAGER;
		}
	}
}