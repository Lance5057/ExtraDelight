package api.LanceNestAPI.src.blocks.RecipeToolSupplier.components.fluid;

import api.LanceNestAPI.src.components.WorkstationComponent;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

public class _WorkstationTank implements WorkstationComponent {
	protected final BlockEntity be;
	private final String name;
	public final String TAG;
	private final FluidTank fluids = createHandler();
	private final Lazy<IFluidHandler> fluidHandler = Lazy.of(() -> fluids);
	public final int SIZE;
	private final Direction accessDirection;
	private final boolean usedInRecipe;

	public _WorkstationTank(String name, BlockEntity be, int size, Direction accessDirection, boolean usedInRecipe) {
		this.be = be;
		this.name = name;
		this.SIZE = size;
		this.TAG = name + "_tag";
		this.accessDirection = accessDirection;
		this.usedInRecipe = usedInRecipe;

	}

	private FluidTank createHandler() {
		return new FluidTank(SIZE);
	}

	@Override
	public boolean isUsedInRecipe() {
		return usedInRecipe;
	}

	@Override
	public CompoundTag writeNBT(HolderLookup.Provider provider, CompoundTag tag) {
		return fluids.writeToNBT(provider, tag);
	}

	@Override
	public void readNBT(HolderLookup.Provider provider, CompoundTag nbt) {
		fluids.readFromNBT(provider, nbt);
	}

	public IFluidHandler registerHandler(Direction d) {
		if (d == this.accessDirection)
			return fluidHandler.get();
		return null;
	}
}
