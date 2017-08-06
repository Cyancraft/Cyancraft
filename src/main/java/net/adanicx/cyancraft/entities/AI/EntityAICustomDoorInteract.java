package net.adanicx.cyancraft.entities.AI;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;
public abstract class EntityAICustomDoorInteract extends EntityAIBase {
	
	protected EntityLiving theEntity;
	protected int entityPosX;
	protected int entityPosY;
	protected int entityPosZ;
	protected BlockDoor field_151504_e;
	boolean hasStoppedDoorInteraction;
	float entityPositionX;
	float entityPositionZ;

	public EntityAICustomDoorInteract(EntityLiving p_i1621_1_) {
		theEntity = p_i1621_1_;
	}

	@Override
	public boolean shouldExecute() {
		if (!theEntity.isCollidedHorizontally)
			return false;
		else {
			PathNavigate pathnavigate = theEntity.getNavigator();
			PathEntity pathentity = pathnavigate.getPath();

			if (pathentity != null && !pathentity.isFinished() && pathnavigate.getCanBreakDoors()) {
				for (int i = 0; i < Math.min(pathentity.getCurrentPathIndex() + 2, pathentity.getCurrentPathLength()); ++i) {
					PathPoint pathpoint = pathentity.getPathPointFromIndex(i);
					entityPosX = pathpoint.xCoord;
					entityPosY = pathpoint.yCoord + 1;
					entityPosZ = pathpoint.zCoord;

					if (theEntity.getDistanceSq(entityPosX, theEntity.posY, entityPosZ) <= 2.25D) {
						field_151504_e = func_151503_a(entityPosX, entityPosY, entityPosZ);

						if (field_151504_e != null)
							return true;
					}
				}

				entityPosX = MathHelper.floor_double(theEntity.posX);
				entityPosY = MathHelper.floor_double(theEntity.posY + 1.0D);
				entityPosZ = MathHelper.floor_double(theEntity.posZ);
				field_151504_e = func_151503_a(entityPosX, entityPosY, entityPosZ);
				return field_151504_e != null;
			} else
				return false;
		}
	}

	@Override
	public boolean continueExecuting() {
		return !hasStoppedDoorInteraction;
	}

	@Override
	public void startExecuting() {
		hasStoppedDoorInteraction = false;
		entityPositionX = (float) (entityPosX + 0.5F - theEntity.posX);
		entityPositionZ = (float) (entityPosZ + 0.5F - theEntity.posZ);
	}

	@Override
	public void updateTask() {
		float f = (float) (entityPosX + 0.5F - theEntity.posX);
		float f1 = (float) (entityPosZ + 0.5F - theEntity.posZ);
		float f2 = entityPositionX * f + entityPositionZ * f1;

		if (f2 < 0.0F)
			hasStoppedDoorInteraction = true;
	}

	private BlockDoor func_151503_a(int x, int y, int z) {
		Block block = theEntity.worldObj.getBlock(x, y, z);
		return block instanceof BlockDoor ? (BlockDoor) block : null;
	}

}
