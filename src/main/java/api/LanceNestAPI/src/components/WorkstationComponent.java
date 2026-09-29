package api.LanceNestAPI.src.components;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;

public interface WorkstationComponent {
	public boolean isUsedInRecipe();

	CompoundTag writeNBT(HolderLookup.Provider provider, CompoundTag tag);

	void readNBT(HolderLookup.Provider provider, CompoundTag nbt);
}
