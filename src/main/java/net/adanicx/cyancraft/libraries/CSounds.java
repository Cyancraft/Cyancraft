package net.adanicx.cyancraft.libraries;
import net.minecraft.block.Block.SoundType;
public class CSounds {
	
	public static final SoundType soundSlime = new CustomSound("mob.slime.big");

	private static final class CustomSound extends SoundType {

		private final boolean useDefaults;

		public CustomSound(String name, float volume, float pitch, boolean useDefaults) {
			super(name, volume, pitch);
			this.useDefaults = useDefaults;
		}

		public CustomSound(String name) {
			this(name, 1.0F, 1.0F, false);
		}

		@Override
		public String getBreakSound() {
			return useDefaults ? super.getBreakSound() : soundName;
		}

		@Override
		public String getStepResourcePath() {
			return useDefaults ? super.getStepResourcePath() : soundName;
		}
	}

}
