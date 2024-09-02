package net.clozynoii.drstone.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class DrStoneConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> DEVICERANGE;
	public static final ForgeConfigSpec.ConfigValue<Double> NATURALUNPETRIFY;
	public static final ForgeConfigSpec.ConfigValue<Double> FIRSTAWAKENTIME;
	public static final ForgeConfigSpec.ConfigValue<Double> MASSEVENTTIME;
	static {
		BUILDER.push("Items");
		DEVICERANGE = BUILDER.comment("Changes the maximum range of the petrification device, time is in ticks. (Default: 1000)").define("Petrification Device Range", (double) 1000);
		BUILDER.pop();
		BUILDER.push("Players");
		NATURALUNPETRIFY = BUILDER.comment("The time it takes to naturally unpetrify when underneath a miracle dripstone, time is in ticks (Default: 72000)").define("Natural Unpetrifying Timer", (double) 72000);
		FIRSTAWAKENTIME = BUILDER.comment("Changes the time it takes for the first player to wake up, time is in ticks (Default: 4500)").define("First Awakening Timer", (double) 4500);
		BUILDER.pop();
		BUILDER.push("World");
		MASSEVENTTIME = BUILDER.comment("The time that can pass before the Mass Petrification Event will trigger, time is in ticks. (Default: 8000)").define("Mass Petrification Event Timer", (double) 8000);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
