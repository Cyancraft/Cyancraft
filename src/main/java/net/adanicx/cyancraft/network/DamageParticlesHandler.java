package net.adanicx.cyancraft.network;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

import net.adanicx.cyancraft.client.particle.DamageEffect;

public class DamageParticlesHandler implements IMessageHandler<DamageParticlesMessage, IMessage> {
	
	@Override
	public IMessage onMessage(DamageParticlesMessage message, MessageContext ctx) {
		handleMessage(message);
		return null;
	}

	@SideOnly(Side.CLIENT)
	private void handleMessage(DamageParticlesMessage message) {
		World world = Minecraft.getMinecraft().theWorld;
		double x = message.x;
		double y = message.y;
		double z = message.z;

		Minecraft.getMinecraft().effectRenderer.addEffect(new DamageEffect(world, x, y, z));
	}

}
