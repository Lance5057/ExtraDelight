package api.LanceNestAPI.src.util;

import net.minecraft.resources.ResourceLocation;

public class ClientUtil {
	public static ResourceLocation createMaterialStyleBlockLocation(String mod, String block, String material,
			String style) {
		return ResourceLocation.fromNamespaceAndPath(mod, "block/" + material + "/" + block + "/" + style);
	}

	public static ResourceLocation createMaterialStyleLayerBlockLocation(String mod, String block, String layer,
			String material, String style) {
		return ResourceLocation.fromNamespaceAndPath(mod,
				"block/" + material + "/" + block + "/" + layer + "/" + style);
	}

	public static ResourceLocation createMaterialStyleLayerBlockLocation(String mod, String block, String layer,
			String material, String style, String extra) {
		return ResourceLocation.fromNamespaceAndPath(mod,
				"block/" + material + "/" + block + "/" + layer + "/" + style + extra);
	}

	public static ResourceLocation createStyleBlockLocation(String mod, String block, String style) {
		return ResourceLocation.fromNamespaceAndPath(mod, "block/" + block + "/" + style);
	}

	public static ResourceLocation createBlockLocation(String mod, String block) {
		return ResourceLocation.fromNamespaceAndPath(mod, "block/" + block);
	}

	public static ResourceLocation createItemLocation(String mod, String item) {
		return ResourceLocation.fromNamespaceAndPath(mod, "item/" + item);
	}

}
