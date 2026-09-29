//package lance5057.compendium.core.recipes;
//
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.crafting.Recipe;
//import net.minecraft.world.level.Level;
//
//public abstract class InWorldHandedToolRecipe implements Recipe<HandedToolWrapper> {
//	private final ResourceLocation id;
//	private final Ingredient offInteractionHand;
//	private final ItemStack block;
//	private final ItemStack output;
//
//	public InWorldHandedToolRecipe(ResourceLocation id, ItemStack block, Ingredient offInteractionHand,
//			ItemStack output) {
//		this.id = id;
//		this.offInteractionHand = offInteractionHand;
//		this.block = block;
//		this.output = output;
//	}
//
//	@Override
//	public boolean matches(HandedToolWrapper inv, Level worldIn) {
//		if (inv.block.equals(block, true))
//			if (this.offInteractionHand.test(inv.offInteractionHand))
//				return true;
//		return false;
//	}
//
//	@Override
//	public ItemStack assemble(HandedToolWrapper inv) {
//		return this.getResultItem();
//	}
//
//	@Override
//	public boolean canCraftInDimensions(int width, int height) {
//		return false;
//	}
//
//	@Override
//	public ItemStack getResultItem() {
//		return output.copy();
//	}
//
//	@Override
//	public ResourceLocation getId() {
//		return id;
//	}
//
//	public Ingredient getIngredient() {
//		return this.offInteractionHand;
//	}
//
//	public ItemStack getBlock() {
//		return this.block;
//	}
//}
