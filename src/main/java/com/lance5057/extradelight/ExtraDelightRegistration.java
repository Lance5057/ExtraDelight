package com.lance5057.extradelight;

import java.util.ArrayList;
import java.util.List;

import com.lance5057.extradelight.util.registration.SimpleRegistration;
import com.lance5057.extradelight.util.registration.types.BlockRegistration;
import com.lance5057.extradelight.workstations.oven.OvenBlock;

public class ExtraDelightRegistration {
	public static List<SimpleRegistration> registry = new ArrayList<SimpleRegistration>();

	public static final BlockRegistration OVEN = (BlockRegistration) BlockRegistration.register("oven", OvenBlock::new)
			.finish();
}
