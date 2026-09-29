package api.LanceNestAPI.src.recipes.multitoolrecipe;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import com.google.common.annotations.VisibleForTesting;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import api.LanceNestAPI.src.util.recipes.MultiToolRecipeWrapper;
import it.unimi.dsi.fastutil.chars.CharArraySet;
import it.unimi.dsi.fastutil.chars.CharSet;
import net.minecraft.Util;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public final class MultiToolRecipeShapedPattern {
	static int maxWidth = 5;
	static int maxHeight = 5;

	public static int getMaxWidth() {
		return maxWidth;
	}

	public static int getMaxHeight() {
		return maxHeight;
	}

	public static void setCraftingSize(int width, int height) {
		if (maxWidth < width)
			maxWidth = width;
		if (maxHeight < height)
			maxHeight = height;
	}

	public static final MapCodec<MultiToolRecipeShapedPattern> MAP_CODEC = MultiToolRecipeShapedPattern.Data.MAP_CODEC
			.flatXmap(MultiToolRecipeShapedPattern::unpack, p_344423_ -> p_344423_.data.map(DataResult::success)
					.orElseGet(() -> DataResult.error(() -> "Cannot encode unpacked recipe")));
	public static final StreamCodec<RegistryFriendlyByteBuf, MultiToolRecipeShapedPattern> STREAM_CODEC = StreamCodec
			.ofMember(MultiToolRecipeShapedPattern::toNetwork, MultiToolRecipeShapedPattern::fromNetwork);
	private final int width;
	private final int height;
	private final NonNullList<Ingredient> ingredients;
	private final Optional<MultiToolRecipeShapedPattern.Data> data;
	private final int ingredientCount;
	private final boolean symmetrical;

	public MultiToolRecipeShapedPattern(int width, int height, NonNullList<Ingredient> ingredients,
			Optional<MultiToolRecipeShapedPattern.Data> data) {
		this.width = width;
		this.height = height;
		this.ingredients = ingredients;
		this.data = data;
		int i = 0;

		for (Ingredient ingredient : ingredients) {
			if (!ingredient.isEmpty()) {
				i++;
			}
		}

		this.ingredientCount = i;
		this.symmetrical = Util.isSymmetrical(width, height, ingredients);
	}

	public static MultiToolRecipeShapedPattern of(Map<Character, Ingredient> key, String... pattern) {
		return of(key, List.of(pattern));
	}

	public static MultiToolRecipeShapedPattern of(Map<Character, Ingredient> key, List<String> pattern) {
		MultiToolRecipeShapedPattern.Data shapedrecipepattern$data = new MultiToolRecipeShapedPattern.Data(key,
				pattern);
		return unpack(shapedrecipepattern$data).getOrThrow();
	}

	private static DataResult<MultiToolRecipeShapedPattern> unpack(MultiToolRecipeShapedPattern.Data data) {
		String[] astring = shrink(data.pattern);
		int i = astring[0].length();
		int j = astring.length;
		NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i * j, Ingredient.EMPTY);
		CharSet charset = new CharArraySet(data.key.keySet());

		for (int k = 0; k < astring.length; k++) {
			String s = astring[k];

			for (int l = 0; l < s.length(); l++) {
				char c0 = s.charAt(l);
				Ingredient ingredient = c0 == ' ' ? Ingredient.EMPTY : data.key.get(c0);
				if (ingredient == null) {
					return DataResult
							.error(() -> "Pattern references symbol '" + c0 + "' but it's not defined in the key");
				}

				charset.remove(c0);
				nonnulllist.set(l + i * k, ingredient);
			}
		}

		return !charset.isEmpty()
				? DataResult.error(() -> "Key defines symbols that aren't used in pattern: " + charset)
				: DataResult.success(new MultiToolRecipeShapedPattern(i, j, nonnulllist, Optional.of(data)));
	}

	@VisibleForTesting
	static String[] shrink(List<String> pattern) {
		int i = Integer.MAX_VALUE;
		int j = 0;
		int k = 0;
		int l = 0;

		for (int i1 = 0; i1 < pattern.size(); i1++) {
			String s = pattern.get(i1);
			i = Math.min(i, firstNonSpace(s));
			int j1 = lastNonSpace(s);
			j = Math.max(j, j1);
			if (j1 < 0) {
				if (k == i1) {
					k++;
				}

				l++;
			} else {
				l = 0;
			}
		}

		if (pattern.size() == l) {
			return new String[0];
		} else {
			String[] astring = new String[pattern.size() - l - k];

			for (int k1 = 0; k1 < astring.length; k1++) {
				astring[k1] = pattern.get(k1 + k).substring(i, j + 1);
			}

			return astring;
		}
	}

	private static int firstNonSpace(String row) {
		int i = 0;

		while (i < row.length() && row.charAt(i) == ' ') {
			i++;
		}

		return i;
	}

	private static int lastNonSpace(String row) {
		int i = row.length() - 1;

		while (i >= 0 && row.charAt(i) == ' ') {
			i--;
		}

		return i;
	}

	public boolean matches(MultiToolRecipeWrapper input) {
		if (input.ingredientCount() != this.ingredientCount) {
			return false;
		} else {
			if (input.width() == this.width && input.height() == this.height) {
				if (!this.symmetrical && this.matches(input, true)) {
					return true;
				}

				if (this.matches(input, false)) {
					return true;
				}
			}

			return false;
		}
	}

	private boolean matches(MultiToolRecipeWrapper input, boolean symmetrical) {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				Ingredient ingredient;
				if (symmetrical) {
					ingredient = this.ingredients.get(this.width - j - 1 + i * this.width);
				} else {
					ingredient = this.ingredients.get(j + i * this.width);
				}

				ItemStack itemstack = input.getItem(j, i);
				if (!ingredient.test(itemstack)) {
					return false;
				}
			}
		}

		return true;
	}

	private void toNetwork(RegistryFriendlyByteBuf buffer) {
		buffer.writeVarInt(this.width);
		buffer.writeVarInt(this.height);

		for (Ingredient ingredient : this.ingredients) {
			Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
		}
	}

	private static MultiToolRecipeShapedPattern fromNetwork(RegistryFriendlyByteBuf buffer) {
		int i = buffer.readVarInt();
		int j = buffer.readVarInt();
		NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i * j, Ingredient.EMPTY);
		nonnulllist.replaceAll(p_319733_ -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
		return new MultiToolRecipeShapedPattern(i, j, nonnulllist, Optional.empty());
	}

	public int width() {
		return this.width;
	}

	public int height() {
		return this.height;
	}

	public NonNullList<Ingredient> ingredients() {
		return this.ingredients;
	}

	public static record Data(Map<Character, Ingredient> key, List<String> pattern) {
		private static final Codec<List<String>> PATTERN_CODEC = Codec.STRING.listOf().comapFlatMap(p_312085_ -> {
			if (p_312085_.size() > maxHeight) {
				return DataResult.error(() -> "Invalid pattern: too many rows, %s is maximum".formatted(maxHeight));
			} else if (p_312085_.isEmpty()) {
				return DataResult.error(() -> "Invalid pattern: empty pattern not allowed");
			} else {
				int i = p_312085_.get(0).length();

				for (String s : p_312085_) {
					if (s.length() > maxWidth) {
						return DataResult
								.error(() -> "Invalid pattern: too many columns, %s is maximum".formatted(maxWidth));
					}

					if (i != s.length()) {
						return DataResult.error(() -> "Invalid pattern: each row must be the same width");
					}
				}

				return DataResult.success(p_312085_);
			}
		}, Function.identity());
		private static final Codec<Character> SYMBOL_CODEC = Codec.STRING.comapFlatMap(p_312250_ -> {
			if (p_312250_.length() != 1) {
				return DataResult.error(() -> "Invalid key entry: '" + p_312250_
						+ "' is an invalid symbol (must be 1 character only).");
			} else {
				return " ".equals(p_312250_) ? DataResult.error(() -> "Invalid key entry: ' ' is a reserved symbol.")
						: DataResult.success(p_312250_.charAt(0));
			}
		}, String::valueOf);
		public static final MapCodec<MultiToolRecipeShapedPattern.Data> MAP_CODEC = RecordCodecBuilder
				.mapCodec(p_312573_ -> p_312573_
						.group(ExtraCodecs.strictUnboundedMap(SYMBOL_CODEC, Ingredient.CODEC_NONEMPTY).fieldOf("key")
								.forGetter(p_312509_ -> p_312509_.key),
								PATTERN_CODEC.fieldOf("pattern").forGetter(p_312713_ -> p_312713_.pattern))
						.apply(p_312573_, MultiToolRecipeShapedPattern.Data::new));
	}
}
