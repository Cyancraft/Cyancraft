package net.adanicx.cyancraft.client.renderer.block;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

import net.adanicx.cyancraft.client.OpenGLHelper;
import net.adanicx.cyancraft.client.renderer.tileentity.TileEntityEndRodRenderer;
import net.adanicx.cyancraft.libraries.RenderIDs;

@SideOnly(Side.CLIENT)
public class BlockEndRodRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int meta, int modelID, RenderBlocks renderer) {
		OpenGLHelper.translate(-0.5F, -0.5F, -0.5F);
		TileEntityEndRodRenderer.renderRod(renderer, block, meta);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return RenderIDs.END_ROD;
	}
}