package com.lance5057.extradelight;

import java.util.function.Supplier;

import com.lance5057.extradelight.blocks.countercabinet.CounterCabinetMenu;
import com.lance5057.extradelight.blocks.sink.SinkCabinetMenu;
import com.lance5057.extradelight.displays.food.FoodDisplayMenu;
import com.lance5057.extradelight.displays.knife.KnifeBlockMenu;
import com.lance5057.extradelight.displays.spice.SpiceRackMenu;
import com.lance5057.extradelight.displays.wreath.WreathMenu;
import com.lance5057.extradelight.gui.StyleableMenu;
import com.lance5057.extradelight.workstations.chiller.ChillerMenu;
import com.lance5057.extradelight.workstations.doughshaping.DoughShapingMenu;
import com.lance5057.extradelight.workstations.meltingpot.MeltingPotMenu;
import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlMenu;
import com.lance5057.extradelight.workstations.oven.OvenMenu;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightContainers {

	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU,
			ExtraDelight.MOD_ID);

	public static final Supplier<MenuType<OvenMenu>> OVEN_MENU = MENU_TYPES.register("oven",
			() -> IMenuTypeExtension.create(OvenMenu::new));
	public static final Supplier<MenuType<MixingBowlMenu>> MIXING_BOWL_MENU = MENU_TYPES.register("mixing_bowl",
			() -> IMenuTypeExtension.create(MixingBowlMenu::new));

	public static final Supplier<MenuType<FoodDisplayMenu>> FOOD_DISPLAY_MENU = MENU_TYPES.register("food_display",
			() -> IMenuTypeExtension.create(FoodDisplayMenu::new));
	public static final Supplier<MenuType<KnifeBlockMenu>> KNIFE_BLOCK_MENU = MENU_TYPES.register("knife_block",
			() -> IMenuTypeExtension.create(KnifeBlockMenu::new));
	public static final Supplier<MenuType<SpiceRackMenu>> SPICE_RACK_MENU = MENU_TYPES.register("spice_rack",
			() -> IMenuTypeExtension.create(SpiceRackMenu::new));

	public static final Supplier<MenuType<DoughShapingMenu>> DOUGH_SHAPING_MENU = MENU_TYPES.register("dough_shaping",
			() -> IMenuTypeExtension.create(DoughShapingMenu::new));
	public static final Supplier<MenuType<WreathMenu>> WREATH_MENU = MENU_TYPES.register("wreath",
			() -> IMenuTypeExtension.create(WreathMenu::new));
	public static final Supplier<MenuType<SinkCabinetMenu>> SINK_MENU = MENU_TYPES.register("sink",
			() -> IMenuTypeExtension.create(SinkCabinetMenu::new));
	public static final Supplier<MenuType<CounterCabinetMenu>> COUNTER_CABINET_MENU = MENU_TYPES
			.register("counter_cabinet", () -> IMenuTypeExtension.create(CounterCabinetMenu::new));
	public static final Supplier<MenuType<StyleableMenu>> STYLE_MENU = MENU_TYPES.register("style",
			() -> IMenuTypeExtension.create(StyleableMenu::new));
	
	public static final Supplier<MenuType<MeltingPotMenu>> MELTING_POT_MENU = MENU_TYPES.register("melting_pot",
			() -> IMenuTypeExtension.create(MeltingPotMenu::new));
	public static final Supplier<MenuType<ChillerMenu>> CHILLER_MENU = MENU_TYPES.register("chiller",
			() -> IMenuTypeExtension.create(ChillerMenu::new));

	public static void register(IEventBus modBus) {
		MENU_TYPES.register(modBus);
	}

}
