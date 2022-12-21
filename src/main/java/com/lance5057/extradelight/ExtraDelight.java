package com.lance5057.extradelight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExtraDelight.MOD_ID)
public class ExtraDelight {
	public final static String MOD_ID = "extradelight";
    public static final String VERSION = "1.0";

    public static Logger logger = LogManager.getLogger();

    public ExtraDelight() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }
}
