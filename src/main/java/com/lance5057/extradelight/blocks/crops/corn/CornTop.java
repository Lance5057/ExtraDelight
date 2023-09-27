package com.lance5057.extradelight.blocks.crops.corn;

import com.lance5057.extradelight.ExtraDelightBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CornTop extends BushBlock implements BonemealableBlock {
	public static final int MAX_AGE = 3;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	public static final BooleanProperty DIMENSION = BooleanProperty.create("dimension");
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] { Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };

	public CornTop(BlockBehaviour.Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)).setValue(DIMENSION, false));
	}

	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE_BY_AGE[pState.getValue(this.getAgeProperty())];
	}

	protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return pState.is(Blocks.FARMLAND);
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return MAX_AGE;
	}

	protected int getAge(BlockState pState) {
		return pState.getValue(this.getAgeProperty());
	}

	public BlockState getStateForAge(int pAge) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(pAge));
	}

	public boolean isMaxAge(BlockState pState) {
		return pState.getValue(this.getAgeProperty()) >= this.getMaxAge();
	}

	@Override
	public boolean isRandomlyTicking(BlockState pState) {
		return !this.isMaxAge(pState);
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (!pLevel.isAreaLoaded(pPos, 1))
			return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		if (pLevel.getRawBrightness(pPos, 0) >= 9) {
			int i = this.getAge(pState);
			if (i < this.getMaxAge()) {
				float f = getGrowthSpeed(this, pLevel, pPos);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, pPos, pState,
						pRandom.nextInt((int) (25.0F / f) + 1) == 0)) {
					pLevel.setBlock(pPos, this.getStateForAge(i + 1), 2);
					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
				}
			}
		}

	}

	public void growCrops(Level pLevel, BlockPos pPos, BlockState pState) {
		int i = this.getAge(pState) + this.getBonemealAgeIncrease(pLevel);
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}

		pLevel.setBlock(pPos, this.getStateForAge(i), 2);
	}

	protected int getBonemealAgeIncrease(Level pLevel) {
		return Mth.nextInt(pLevel.random, 0, 1);
	}

	protected static float getGrowthSpeed(Block pBlock, BlockGetter pLevel, BlockPos pPos) {
		float f = 1.0F;
		BlockPos blockpos = pPos.below();

		for (int i = -1; i <= 1; ++i) {
			for (int j = -1; j <= 1; ++j) {
				float f1 = 0.0F;
				BlockState blockstate = pLevel.getBlockState(blockpos.offset(i, 0, j));
				if (blockstate.canSustainPlant(pLevel, blockpos.offset(i, 0, j), net.minecraft.core.Direction.UP,
						(net.minecraftforge.common.IPlantable) pBlock)) {
					f1 = 1.0F;
					if (blockstate.isFertile(pLevel, pPos.offset(i, 0, j))) {
						f1 = 3.0F;
					}
				}

				if (i != 0 || j != 0) {
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		BlockPos blockpos1 = pPos.north();
		BlockPos blockpos2 = pPos.south();
		BlockPos blockpos3 = pPos.west();
		BlockPos blockpos4 = pPos.east();
		boolean flag = pLevel.getBlockState(blockpos3).is(pBlock) || pLevel.getBlockState(blockpos4).is(pBlock);
		boolean flag1 = pLevel.getBlockState(blockpos1).is(pBlock) || pLevel.getBlockState(blockpos2).is(pBlock);
		if (flag && flag1) {
			f /= 2.0F;
		} else {
			boolean flag2 = pLevel.getBlockState(blockpos3.north()).is(pBlock)
					|| pLevel.getBlockState(blockpos4.north()).is(pBlock)
					|| pLevel.getBlockState(blockpos4.south()).is(pBlock)
					|| pLevel.getBlockState(blockpos3.south()).is(pBlock);
			if (flag2) {
				f /= 2.0F;
			}
		}

		return f;
	}

	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return (pLevel.getRawBrightness(pPos, 0) >= 8 || pLevel.canSeeSky(pPos))
				&& pLevel.getBlockState(pPos.below()).getBlock() == ExtraDelightBlocks.CORN_BOTTOM.get();
	}

	public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
		if (pEntity instanceof Ravager
				&& net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(pLevel, pEntity)) {
			pLevel.destroyBlock(pPos, true, pEntity);
		}

		super.entityInside(pState, pLevel, pPos, pEntity);
	}

	protected ItemLike getBaseSeedId() {
		return Items.WHEAT_SEEDS;
	}

	public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
		return new ItemStack(this.getBaseSeedId());
	}

	/**
	 * @return whether bonemeal can be used on this block
	 */
	public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
		return !this.isMaxAge(pState);
	}

	public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
		return true;
	}

	public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
		this.growCrops(pLevel, pPos, pState);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(AGE, DIMENSION);
	}
	
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult hit) {
		if(this.isMaxAge(state))
		{
			
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
