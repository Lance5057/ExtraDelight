//package com.lance5057.extradelight.data;
//
//import java.util.function.Consumer;
//
//import com.lance5057.extradelight.ExtraDelight;
//
//import net.minecraft.data.DataGenerator;
//import net.minecraft.resources.ResourceLocation;
//import xyz.brassgoggledcoders.patchouliprovider.BookBuilder;
//import xyz.brassgoggledcoders.patchouliprovider.CategoryBuilder;
//import xyz.brassgoggledcoders.patchouliprovider.EntryBuilder;
//import xyz.brassgoggledcoders.patchouliprovider.PatchouliBookProvider;
//
//public class PatchouliGen extends PatchouliBookProvider {
//
//	public PatchouliGen(DataGenerator gen, String modid, String locale) {
//		super(gen, modid, locale);
//		// TODO Auto-generated constructor stub
//	}
//
//	ResourceLocation modLoc(String loc) {
//		return ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, loc);
//	}
//
//	@Override
//	protected void addBooks(Consumer<BookBuilder> consumer) {
//		BookBuilder book = this
//				.createBookBuilder("cookbook2", "Well Worn Cookbook",
//						"This is a WIP, many pages will contain duplicates!")
//				.setBookTexture("patchouli:textures/gui/book_red.png").setModel("extradelight:cookbook");
//
//		CategoryBuilder beverages = book
//				.addCategory("beverages", "Beverages", "Drinks!", "extradelight:sweet_berry_juice").setSortnum(6);
//		CategoryBuilder casseroles = book.addCategory("casseroles", "Casseroles / One Pot", "Casseroles!",
//				"extradelight:hotdish");
//		CategoryBuilder condiments = book.addCategory("condiments", "Condiments", "Saucy!", "extradelight:bbq_jar_item")
//				.setSortnum(7);
//		CategoryBuilder deserts = book
//				.addCategory("deserts", "Deserts", "Sweet Treats!", "extradelight:chocolate_custard").setSortnum(5);
//		CategoryBuilder eggs = book.addCategory("eggs", "Egg Dishes", "Breakfast!", "extradelight:quiche");
//		CategoryBuilder fish = book.addCategory("fish", "Fish and Seafood", "Fish!", "extradelight:fried_fish");
//		CategoryBuilder meats = book.addCategory("meats", "Meats and Cheeses", "Tasty Animals!",
//				"extradelight:potroast");
//		CategoryBuilder pasta = book.addCategory("pasta", "Rice and Pasta", "Carbs!", "extradelight:cooked_pasta");
//		CategoryBuilder salads = book.addCategory("salads", "Salads", "Leafy!", "extradelight:salad");
//		CategoryBuilder sandwiches = book.addCategory("sandwiches", "Sandwiches", "Meals between bread!",
//				"extradelight:fish_salad_sandwich");
//		CategoryBuilder soups = book.addCategory("soups", "Soups", "Wet Food!", "extradelight:tomato_soup");
//		CategoryBuilder vegetables = book.addCategory("vegetables", "Fruits and Vegetables", "Tasty Plants!",
//				"extradelight:glazed_carrot");
//
//		doBeverages(beverages);
//		doCasseroles(casseroles);
//		doCondiments(condiments);
//		doDeserts(deserts);
//		doEggs(eggs);
//		doFish(fish);
//		doMeats(meats);
//		doPasta(pasta);
//		doSalads(salads);
//		doSandwiches(sandwiches);
//		doSoups(soups);
//		doVegetables(vegetables);
//
//		book.build(consumer);
//	}
//
//	private void doVegetables(CategoryBuilder vegetables) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void doSoups(CategoryBuilder soups) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void doSandwiches(CategoryBuilder sandwiches) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void doSalads(CategoryBuilder salads) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void doPasta(CategoryBuilder pasta) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void doMeats(CategoryBuilder meats) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void doFish(CategoryBuilder fish) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void doEggs(CategoryBuilder eggs) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void doDeserts(CategoryBuilder deserts) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void doCondiments(CategoryBuilder condiments) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void doCasseroles(CategoryBuilder casseroles) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void doBeverages(CategoryBuilder beverages) {
//		EntryBuilder glowberry = beverages.addEntry("glow_berry_juice", "Glow Berry Juice",
//				"extradelight:glow_berry_juice");
//		glowberry.addTextPage(
//				"A tart juice made from glowberries that maintains its glow inducing quality. It's anti-inflammatory and anti-oxidant effects will make you feel a little healthier almost instantly!");
//		glowberry.addCraftingPage(modLoc("glow_berry_juice"));
//		glowberry.build();
//
//		EntryBuilder sweetberry = beverages.addEntry("sweet_berry_juice", "Sweet Berry Juice",
//				modLoc("sweet_berry_juice").toString());
//		sweetberry.addTextPage(
//				"A delightfully sweet juice made from sweet berries. A glass of this juice will perk you right up quickly but provides little nutritional value.");
//		sweetberry.addCraftingPage(modLoc("sweet_berry_juice"));
//		sweetberry.build();
//
//		EntryBuilder tomato = beverages.addEntry("tomato_juice", "Tomato Juice", modLoc("tomato_juice").toString());
//		tomato.addTextPage(
//				"A savory juice made of tomatos. It's jam packed full of nutrients to keep healthy even in the deepest dungeons!");
//		tomato.addCraftingPage(modLoc("tomato_juice"));
//		tomato.build();
//	}
//
//}
