package api.LanceNestAPI.src.blocks.RecipeToolSupplier;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class RecipeToolSupplierBlock extends Block {

	public RecipeToolSupplierBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
			ItemStack stack) {
		BlockEntity b = level.getBlockEntity(pos);
		if (b != null) {
			if (b instanceof RecipeToolSupplierBlockEntity rtsb)
				rtsb.searchForWorkstations(level);
		}
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest,
			FluidState fluid) {

		BlockEntity b = level.getBlockEntity(pos);
		if (b != null) {
			if (b instanceof RecipeToolSupplierBlockEntity rtsb)
				rtsb.removeFromWorkstations(level);
		}
		return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);

	}
}
