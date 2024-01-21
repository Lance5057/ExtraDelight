package com.lance5057.extradelight.data;

import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import xyz.brassgoggledcoders.patchouliprovider.BookBuilder;
import xyz.brassgoggledcoders.patchouliprovider.CategoryBuilder;
import xyz.brassgoggledcoders.patchouliprovider.PatchouliBookProvider;

public class PatchouliGen extends PatchouliBookProvider {

	public PatchouliGen(DataGenerator gen, String modid, String locale) {
		super(gen, modid, locale);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addBooks(Consumer<BookBuilder> consumer) {
		BookBuilder book = this
				.createBookBuilder("cookbook2", "Well Worn Cookbook",
						"This is a WIP, many pages will contain duplicates!")
				.setBookTexture("patchouli:textures/gui/book_red.png").setModel("extradelight:cookbook");

		CategoryBuilder beverages = book.addCategory("beverages", "Beverages", "Drinks!", "extradelight:sweet_berry_juice").setSortnum(6);
		CategoryBuilder casseroles = book.addCategory("casseroles", "Casseroles / One Pot", "Casseroles!", "extradelight:hotdish");
		CategoryBuilder condiments = book.addCategory("condiments", "Condiments", "Saucy!", "extradelight:bbq_jar_item").setSortnum(7);
		CategoryBuilder deserts = book.addCategory("deserts", "Deserts", "Sweet Treats!", "extradelight:chocolate_custard").setSortnum(5);
		CategoryBuilder eggs = book.addCategory("eggs", "Egg Dishes", "Breakfast!", "extradelight:quiche");
		CategoryBuilder fish = book.addCategory("fish", "Fish and Seafood", "Fish!", "extradelight:fried_fish");
		CategoryBuilder meats = book.addCategory("meats", "Meats and Cheeses", "Tasty Animals!", "extradelight:potroast");
		CategoryBuilder pasta = book.addCategory("pasta", "Rice and Pasta", "Carbs!", "extradelight:cooked_pasta");
		CategoryBuilder salads = book.addCategory("salads", "Salads", "Leafy!", "extradelight:salad");
		CategoryBuilder sandwiches = book.addCategory("sandwiches", "Sandwiches", "Meals between bread!", "extradelight:fish_salad_sandwich");
		CategoryBuilder soups = book.addCategory("soups", "Soups", "Wet Food!", "extradelight:tomato_soup");
		CategoryBuilder vegetables = book.addCategory("vegetables", "Fruits and Vegetables", "Tasty Plants!", "extradelight:glazed_carrot");

		book.build(consumer);
	}

}
