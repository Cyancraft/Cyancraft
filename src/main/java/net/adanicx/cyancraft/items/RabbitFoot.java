package net.adanicx.cyancraft.items;
import java.lang.reflect.Field;
import java.util.HashMap;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;

import net.adanicx.cyancraft.CyancraftMod;
import net.adanicx.cyancraft.IConfigurable;
import net.adanicx.cyancraft.core.utilities.Utilities;

public class RabbitFoot extends Item implements IConfigurable {

	@SuppressWarnings("unchecked")
	public RabbitFoot() {
		setTextureName("rabbit_foot");
		setUnlocalizedName(Utilities.getUnlocalizedName("rabbit_foot"));
		setCreativeTab(CyancraftMod.enableRabbit ? CyancraftMod.creativeTab : null);

		if (CyancraftMod.enableRabbit)
			try {
				Field f = ReflectionHelper.findField(PotionHelper.class, "potionRequirements", "field_77927_l");
				f.setAccessible(true);
				HashMap<Integer, String> potionRequirements = (HashMap<Integer, String>) f.get(null);
				potionRequirements.put(Potion.jump.getId(), "0 & 1 & !2 & 3");

				Field f2 = ReflectionHelper.findField(PotionHelper.class, "potionAmplifiers", "field_77928_m");
				f2.setAccessible(true);
				HashMap<Integer, String> potionAmplifiers = (HashMap<Integer, String>) f2.get(null);
				potionAmplifiers.put(Potion.jump.getId(), "5");

				Field f3 = ReflectionHelper.findField(Potion.class, "liquidColor", "field_76414_N");
				f3.setAccessible(true);
				f3.set(Potion.jump, 0x22FF4C);
			} catch (Exception e) {
			}
	}

	@Override
	public String getPotionEffect(ItemStack stack) {
		return "+0+1-2+3&4-4+13";
	}

	@Override
	public boolean isPotionIngredient(ItemStack stack) {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return CyancraftMod.enableRabbit;
	}
}