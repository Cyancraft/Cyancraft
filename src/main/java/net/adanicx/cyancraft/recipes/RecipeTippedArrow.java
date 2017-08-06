package net.adanicx.cyancraft.recipes;
import java.util.List;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.oredict.ShapedOreRecipe;

import net.adanicx.cyancraft.CItems;
import net.adanicx.cyancraft.items.LingeringPotion;
import net.adanicx.cyancraft.items.TippedArrow;

public class RecipeTippedArrow extends ShapedOreRecipe {

	public RecipeTippedArrow(ItemStack result, Object... recipe) {
		super(result, recipe);
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting grid) {
		ItemStack potion = grid.getStackInRowAndColumn(1, 1);
		List<PotionEffect> effects = ((LingeringPotion) CItems.lingering_potion).getEffects(potion);

		ItemStack stack = new ItemStack(CItems.tipped_arrow, 8);
		if (!effects.isEmpty()) {
			PotionEffect effect = effects.get(0);
			TippedArrow.setEffect(stack, Potion.potionTypes[effect.getPotionID()], effect.getDuration());
		}

		return stack;
	}
}