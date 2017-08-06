package net.adanicx.cyancraft.API.client;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.SkinManager.SkinAvailableCallback;
import net.minecraft.util.ResourceLocation;
@SideOnly(Side.CLIENT)
public interface ISkinDownloadCallback extends SkinAvailableCallback {
	@Override
	void func_152121_a(Type skinType, ResourceLocation resourceLocation);
}