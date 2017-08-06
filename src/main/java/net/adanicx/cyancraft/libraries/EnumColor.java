package net.adanicx.cyancraft.libraries;
import java.awt.Color;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.StatCollector;
public enum EnumColor {

	BLACK("Black", MapColor.blackColor),
	RED("Red", MapColor.redColor),
	GREEN("Green", MapColor.greenColor),
	BROWN("Brown", MapColor.brownColor),
	BLUE("Blue", MapColor.blueColor),
	PURPLE("Purple", MapColor.purpleColor),
	CYAN("Cyan", MapColor.cyanColor),
	LIGHT_GREY("LightGray", MapColor.silverColor),
	GREY("Gray", MapColor.grayColor),
	PINK("Pink", MapColor.pinkColor),
	LIME("Lime", MapColor.limeColor),
	YELLOW("Yellow", MapColor.yellowColor),
	LIGHT_BLUE("LightBlue", MapColor.lightBlueColor),
	MAGENTA("Magenta", MapColor.magentaColor),
	ORANGE("Orange", MapColor.adobeColor),
	WHITE("White", MapColor.snowColor);

	final String dye;
	final String name;
	final MapColor mapColor;

	EnumColor(String name, MapColor mapColor) {
		dye = "dye" + name;
		this.name = name;
		this.mapColor = mapColor;
	}

	public String getName() {
		return name;
	}

	public String getMojangName() {
		if (this == LIGHT_GREY)
			return "silver";
		return name.substring(0, 1).toLowerCase() + name.substring(1);
	}

	public String getOreName() {
		return dye;
	}

	public MapColor getMapColor() {
		return mapColor;
	}

	public Color getColor() {
		int i = getDamage();
		return new Color(EntitySheep.fleeceColorTable[i][0], EntitySheep.fleeceColorTable[i][1], EntitySheep.fleeceColorTable[i][2]);
	}

	public int getDamage() {
		return BlockColored.func_150031_c(ordinal());
	}

	public int getRGB() {
		return getColor().getRGB();
	}

	public int getDarker() {
		return getColor().darker().getRGB();
	}

	public int getBrighter() {
		return getColor().brighter().getRGB();
	}

	public String getTranslatedName() {
		return StatCollector.translateToLocal(getUnlocalizedName());
	}

	public String getUnlocalizedName() {
		return "color." + ModReferences.MOD_ID + "." + dye;
	}

	public static EnumColor fromDamage(int meta) {
		meta = BlockColored.func_150031_c(meta);
		return values()[Math.min(Math.max(0, meta), values().length - 1)];
	}
	
}
