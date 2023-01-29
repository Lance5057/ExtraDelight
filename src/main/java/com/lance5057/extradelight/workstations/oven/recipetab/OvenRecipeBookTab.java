package com.lance5057.extradelight.workstations.oven.recipetab;

public enum OvenRecipeBookTab
{
	MEALS("meals");

	public final String name;

	OvenRecipeBookTab(String name) {
		this.name = name;
	}

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
