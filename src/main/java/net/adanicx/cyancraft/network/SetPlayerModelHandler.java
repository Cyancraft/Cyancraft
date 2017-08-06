package net.adanicx.cyancraft.network;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import net.adanicx.cyancraft.command.SetPlayerModelCommand;

public class SetPlayerModelHandler implements IMessageHandler<SetPlayerModelMessage, IMessage> {
	
	@Override
	public IMessage onMessage(SetPlayerModelMessage message, MessageContext ctx) {
		String playerName = message.playerName;
		boolean isAlex = message.isAlex;

		for (Object obj : Minecraft.getMinecraft().theWorld.playerEntities)
			if (obj instanceof EntityPlayer && playerName.equals(((EntityPlayer) obj).getCommandSenderName())) {
				EntityPlayer player = (EntityPlayer) obj;
				player.getEntityData().setBoolean(SetPlayerModelCommand.MODEL_KEY, isAlex);
			}

		return null;
	}

}
