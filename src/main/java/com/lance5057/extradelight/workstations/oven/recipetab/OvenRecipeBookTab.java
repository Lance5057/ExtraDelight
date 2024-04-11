package com.lance5057.extradelight.workstations.oven.recipetab;

import java.util.EnumSet;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;

public enum OvenRecipeBookTab {
	MEALS("meals");

	public final String name;

	OvenRecipeBookTab(String name) {
		this.name = name;
	}

	public static final Codec<OvenRecipeBookTab> CODEC = Codec.STRING.flatXmap(s -> {
		OvenRecipeBookTab tab = findByName(s);
		if (tab == null) {
			return DataResult.error(
					() -> "Optional field 'recipe_book_tab' does not match any valid tab. If defined, must be one of the following: "
							+ EnumSet.allOf(OvenRecipeBookTab.class));
		}
		return DataResult.success(tab);
	}, tab -> DataResult.success(tab.toString()));

	public static OvenRecipeBookTab findByName(String name) {
		for (OvenRecipeBookTab value : values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
