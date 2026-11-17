package com.lance5057.extradelight.blocks.crops.strawberry;

import net.minecraft.util.StringRepresentable;

public enum RunnerConnect implements StringRepresentable {
	NONE("none", 0), NORTH("north", 0), SOUTH("south", 180), WEST("west", 270), EAST("east", 90);

	private final String name;
	private final int yRot;

	private RunnerConnect(String name, int yRot) {
		this.name = name;
		this.yRot = yRot;
	}

	@Override
	public String toString() {
		return this.getSerializedName();
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}

	public int getYRotation() {
		return this.yRot;
	}
}
