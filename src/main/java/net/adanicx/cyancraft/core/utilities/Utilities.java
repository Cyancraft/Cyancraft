package net.adanicx.cyancraft.core.utilities;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.oredict.OreDictionary;
import net.adanicx.cyancraft.libraries.ModReferences;

public class Utilities {
	
	public static String getUnlocalizedName(String name) {
		return ModReferences.MOD_ID + "." + name;
	}
	
	public static String getBlockTexture(String name) {
		return ModReferences.ITEM_BLOCK_TEXTURE_PATH + name;
	}
	
	public static String getItemTexture(String name) {
		return ModReferences.ITEM_BLOCK_TEXTURE_PATH + name;
	}
	
	public static ResourceLocation getResource(String path) {
		return new ResourceLocation(path);
	}
	
	public static String getContainerName(String name) {
		return "container." + ModReferences.MOD_ID + "." +name;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getTileEntity(IBlockAccess world, int x, int y, int z, Class<T> cls) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (!cls.isInstance(tile))
			return null;
		return (T) tile;
	}
	
	public static List<String> getOreNames(ItemStack stack) {
		List <String> list = new ArrayList<String>();
		for (int id : OreDictionary.getOreIDs(stack))
			list.add(OreDictionary.getOreName(id));
		
		return list;
	}

}
