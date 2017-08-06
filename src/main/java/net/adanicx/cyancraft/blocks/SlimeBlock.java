package net.adanicx.cyancraft.blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;
import net.adanicx.cyancraft.libraries.CSounds;
import net.adanicx.cyancraft.libraries.ModReferences;
import net.adanicx.cyancraft.libraries.RenderIDs;

public class SlimeBlock extends Block implements IConfigurable {

	public SlimeBlock() {
		super(Material.clay);
		setHardness(0.0F);
		setBlockTextureName("slime");
		setStepSound(CSounds.soundSlime);
		setBlockName(Utilities.getUnlocalizedName("slime"));
		setCreativeTab(CyancraftMod.enableSlimeBlock ? CyancraftMod.creativeTab : null);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		float f = 0.125F;
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1 - f, z + 1);
	}

	@Override
	public void onFallenUpon(World world, int x, int y, int z, Entity entity, float fallDistance) {
		if (!entity.isSneaking()) {
			entity.fallDistance = 0;
			if (entity.motionY < 0)
				entity.getEntityData().setDouble(ModReferences.MOD_ID + ":slime", -entity.motionY);
		}
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		NBTTagCompound data = entity.getEntityData();
		if (data.hasKey(ModReferences.MOD_ID + ":slime")) {
			entity.motionY = data.getDouble(ModReferences.MOD_ID + ":slime");
			data.removeTag(ModReferences.MOD_ID + ":slime");
		}

		if (Math.abs(entity.motionY) < 0.1 && !entity.isSneaking()) {
			double d = 0.4 + Math.abs(entity.motionY) * 0.2;
			entity.motionX *= d;
			entity.motionZ *= d;
		}
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public int getRenderType() {
		return RenderIDs.SLIME_BLOCK;
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableSlimeBlock;
	}
}