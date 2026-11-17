package api.LanceNestAPI.src.blocks;

import javax.annotation.Nullable;

import api.LanceNestAPI.src.blockentities.MultiToolRecipeStation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public abstract class StationBlock extends Block {

	public StationBlock(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
			ItemStack stack) {
		BlockEntity b = level.getBlockEntity(pos);
		if (b != null) {
			if (b instanceof MultiToolRecipeStation rtsb)
				rtsb.searchForToolSuppliers(level);
		}
	}

}
