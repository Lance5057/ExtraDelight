package api.LanceNestAPI.src.util;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;

public class CustomTier extends SimpleTier {
	String vanilla;
	TagKey<Item> repairTag;

	public TagKey<Item> getRepairTag() {
		return repairTag;
	}

	public String getVanilla() {
		return vanilla;
	}

	public CustomTier(TagKey<Block> incorrectBlocksForDrops, int uses, float speed, float attackDamageBonus,
			int enchantmentValue, TagKey<Item> repairTag) {
		super(incorrectBlocksForDrops, uses, speed, attackDamageBonus, enchantmentValue,
				() -> Ingredient.of(repairTag));
		// TODO Auto-generated constructor stub
	}

	public CustomTier(Tier tier) {
		super(tier.getIncorrectBlocksForDrops(), tier.getUses(), tier.getSpeed(), tier.getAttackDamageBonus(),
				tier.getEnchantmentValue(), () -> tier.getRepairIngredient());
	}

	public CustomTier(String tier) {
		this(Tiers.valueOf(tier));
		vanilla = tier;
	}

	public static CustomTier deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject j = json.getAsJsonObject();

		if (j.has("vanillaTier")) {
			return new CustomTier(j.get("vanillaTier").getAsString());
		}

		else {
			int uses = j.get("uses").getAsInt();
			float speed = j.get("speed").getAsFloat();
			float damage = j.get("damage").getAsFloat();
			int enchantmentValue = j.get("enchantmentValue").getAsInt();

			String useTag = j.get("useTag").getAsString();
			String repairTag = j.get("repairTag").getAsString();

			TagKey<Item> repair = ItemTags.create(ResourceLocation.parse(repairTag));

			return new CustomTier(BlockTags.create(ResourceLocation.parse(useTag)), uses, speed, damage,
					enchantmentValue, repair);
		}

	}

	public static JsonElement serialize(CustomTier src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject j = new JsonObject();

		if (src.getVanilla() != null && !src.getVanilla().isEmpty())
			j.addProperty("vanillaTier", src.getVanilla());

		else {
			j.addProperty("uses", src.getUses());
			j.addProperty("speed", src.getSpeed());
			j.addProperty("damage", src.getAttackDamageBonus());
			j.addProperty("enchantmentValue", src.getEnchantmentValue());
			j.addProperty("useTag", src.getIncorrectBlocksForDrops().location().toString());
			if (src.repairTag != null)
				j.addProperty("repairTag", src.getRepairTag().location().toString());
		}

		return j;

	}

}
