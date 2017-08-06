package net.adanicx.cyancraft;

import java.lang.reflect.Field;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import net.adanicx.cyancraft.items.Beetroot;
import net.adanicx.cyancraft.items.BeetrootSeeds;
import net.adanicx.cyancraft.items.BeetrootSoup;
import net.adanicx.cyancraft.items.ChorusFruit;
import net.adanicx.cyancraft.items.DragonsBreath;
import net.adanicx.cyancraft.items.Elytra;
import net.adanicx.cyancraft.items.EndCrystal;
import net.adanicx.cyancraft.items.ItemArmorStand;
import net.adanicx.cyancraft.items.LingeringPotion;
import net.adanicx.cyancraft.items.MuttonCooked;
import net.adanicx.cyancraft.items.MuttonRaw;
import net.adanicx.cyancraft.items.PoppedChorusFruit;
import net.adanicx.cyancraft.items.PrismarineCrystals;
import net.adanicx.cyancraft.items.PrismarineShard;
import net.adanicx.cyancraft.items.RabbitCooked;
import net.adanicx.cyancraft.items.RabbitFoot;
import net.adanicx.cyancraft.items.RabbitHide;
import net.adanicx.cyancraft.items.RabbitRaw;
import net.adanicx.cyancraft.items.RabbitStew;
import net.adanicx.cyancraft.items.TippedArrow;

public class CItems {
	
	public static final Item raw_mutton = new MuttonRaw();
	public static final Item cooked_mutton = new MuttonCooked();
	public static final Item prismarine_shard = new PrismarineShard();
	public static final Item prismarine_crystals = new PrismarineCrystals();
	public static final Item armor_stand = new ItemArmorStand();
	public static final Item raw_rabbit = new RabbitRaw();
	public static final Item cooked_rabbit = new RabbitCooked();
	public static final Item rabbit_foot = new RabbitFoot();
	public static final Item rabbit_hide = new RabbitHide();
	public static final Item rabbit_stew = new RabbitStew();
	public static final Item beetroot = new Beetroot();
	public static final Item beetroot_seeds = new BeetrootSeeds();
	public static final Item beetroot_soup = new BeetrootSoup();
	public static final Item chorus_fruit = new ChorusFruit();
	public static final Item popped_chorus_fruit = new PoppedChorusFruit();
	public static final Item tipped_arrow = new TippedArrow();
	public static final Item lingering_potion = new LingeringPotion();
	public static final Item dragon_breath = new DragonsBreath();
	public static final Item elytra = new Elytra();
	public static final Item end_crystal = new EndCrystal();

	public static void init() {
		try {
			for (Field f : CItems.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if (obj instanceof Item)
					registerItem((Item) obj);
				else if (obj instanceof Item[])
					for (Item item : (Item[]) obj)
						registerItem(item);
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private static void registerItem(Item item) {
		if (!(item instanceof IConfigurable) || ((IConfigurable) item).isEnabled()) {
			String name = item.getUnlocalizedName();
			String[] strings = name.split("\\.");
			GameRegistry.registerItem(item, strings[strings.length - 1]);
		}
	}

}
