package com.lance5057.extradelight.state;

import net.minecraft.util.StringRepresentable;

public enum OvenSupport implements StringRepresentable {
	NONE("none"), TRAY("tray"), HANDLE("handle");

	private final String supportName;

	OvenSupport(String name) {
		this.supportName = name;
	}

	@Override
	public String toString() {
		return this.getSerializedName();
	}

	@Override
	public String getSerializedName() {
		return this.supportName;
	}
}
