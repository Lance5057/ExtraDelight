package api.LanceNestAPI.src.util;

import net.minecraft.resources.ResourceLocation;

public class ResourceLocationUtil {
	public static ResourceLocation neoTag(String loc) {
		return ResourceLocation.fromNamespaceAndPath("c", loc);
	}

	public static ResourceLocation compendiumLoc(String loc) {
		return ResourceLocation.fromNamespaceAndPath("compendium", loc);
	}
	
	public static ResourceLocation butchercraftLoc(String loc) {
		return ResourceLocation.fromNamespaceAndPath("butchercraft", loc);
	}
	
	public static ResourceLocation buffetLoc(String loc) {
		return ResourceLocation.fromNamespaceAndPath("buffet", loc);
	}
	
	public static ResourceLocation apiLoc(String loc) {
		return ResourceLocation.fromNamespaceAndPath("lancenestapi", loc);
	}

	public static ResourceLocation mcLoc(String loc) {
		return ResourceLocation.withDefaultNamespace(loc);
	}
}
