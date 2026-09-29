package api.LanceNestAPI.src.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

public class RecipeItemUse {

	public static final String USES_FIELD = "uses";
	public static final String TOOL_FIELD = "tool";
	public static final String COUNT_FIELD = "count";
	public static final String DAMAGE_FIELD = "damage";
	public static final String LOOT_TABLE_FIELD = "loot_table";

	public static final RecipeItemUse EMPTY = new RecipeItemUse(0, Ingredient.EMPTY, 1, false,
			ResourceLocation.withDefaultNamespace(""));
	// TODO Switch to private?
	public final int uses;
	public final Ingredient tool;
	public final int count;
	public final boolean damageTool;
	public final ResourceLocation lootTable;

	public RecipeItemUse(int uses, Ingredient tool, int count, boolean damage, ResourceLocation lootTable) {
		this.uses = uses;
		this.tool = tool;
		this.count = count;
		this.damageTool = damage;
		this.lootTable = lootTable;
	}

	public static final Codec<RecipeItemUse> CODEC = RecordCodecBuilder.create(inst -> inst
			.group(Codec.INT.fieldOf("uses").forGetter(RecipeItemUse::getUses),
					Ingredient.CODEC_NONEMPTY.fieldOf("tool").forGetter(RecipeItemUse::getTool),
					Codec.INT.fieldOf("count").forGetter(RecipeItemUse::getCount),
					Codec.BOOL.fieldOf("damage").forGetter(RecipeItemUse::isDamageTool),
					ResourceLocation.CODEC.fieldOf("loot_table").forGetter(RecipeItemUse::getLootTable))
			.apply(inst, RecipeItemUse::new));

	public static final StreamCodec<RegistryFriendlyByteBuf, RecipeItemUse> STREAM_CODEC = StreamCodec
			.of(RecipeItemUse::write, RecipeItemUse::read);

	public int getUses() {
		return uses;
	}

	public Ingredient getTool() {
		return tool;
	}

	public int getCount() {
		return count;
	}

	public boolean isDamageTool() {
		return damageTool;
	}

	public ResourceLocation getLootTable() {
		return lootTable;
	}
	
	private static RecipeItemUse read(RegistryFriendlyByteBuf buffer) {
        int u = buffer.readVarInt();
        //ItemStack stack = buffer.readItemStack();
        Ingredient i = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
        int c = buffer.readVarInt();
        boolean b = buffer.readBoolean();

        ResourceLocation s = buffer.readResourceLocation();

        return new RecipeItemUse(u, i, c, b, s);
    }

    private static void write(RegistryFriendlyByteBuf buffer, RecipeItemUse r) {
        buffer.writeVarInt(r.uses);
        Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, r.tool);
        buffer.writeVarInt(r.count);
        buffer.writeBoolean(r.damageTool);
        buffer.writeResourceLocation(r.lootTable);
    }
}
