package com.lance5057.extradelight;

import java.util.function.Supplier;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.fluids.SimpleFluidContent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightComponents {
	public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(ExtraDelight.MOD_ID);

    public static Supplier<DataComponentType<SimpleFluidContent>> FLUID = COMPONENTS.registerComponentType("fluid",
        builder -> builder.persistent(SimpleFluidContent.CODEC).networkSynchronized(SimpleFluidContent.STREAM_CODEC));
}
