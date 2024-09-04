package com.lance5057.extradelight.blocks.crops;

import com.lance5057.extradelight.ExtraDelightItems;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import vectorwing.farmersdelight.common.block.RicePaniclesBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class MallowRootCrop extends BushBlock implements BonemealableBlock, LiquidBlockContainer {
	public static final MapCodec<MallowRootCrop> CODEC = simpleCodec(MallowRootCrop::new);

	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 8);
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] { Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D),
			Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D),
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D) };

	public MallowRootCrop(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(AGE, 0));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
	}

	@Override
	public boolean canPlaceLiquid(Player player, BlockGetter level, BlockPos pos, BlockState state, Fluid fluid) {
		return false;
	}

	@Override
	public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState) {
		return false;
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
		return !this.isMaxAge(state);
	}

	@Override
	public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
		return true;
	}

	protected int getBonemealAgeIncrease(Level level) {
		return Mth.nextInt(level.random, 1, 4);
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	protected int getAge(BlockState state) {
		return state.getValue(this.getAgeProperty());
	}

	public int getMaxAge() {
		return 8;
	}

	public final boolean isMaxAge(BlockState state) {
		return this.getAge(state) >= this.getMaxAge();
	}

	@Override
	public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
		return new ItemStack(ExtraDelightItems.MALLOW_ROOT.get());
	}

	public BlockState withAge(int age) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), age);
	}

	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		super.tick(state, level, pos, random);
		if (!level.isAreaLoaded(pos, 1))
			return;
		if (level.getRawBrightness(pos.above(), 0) >= 6) {
			int age = this.getAge(state);
			if (age <= this.getMaxAge()) {
				float chance = 10;
				if (CommonHooks.canCropGrow(level, pos, state, random.nextInt((int) (25.0F / chance) + 1) == 0)) {
					if (age == this.getMaxAge()) {
						RicePaniclesBlock riceUpper = (RicePaniclesBlock) ModBlocks.RICE_CROP_PANICLES.get();
						if (riceUpper.defaultBlockState().canSurvive(level, pos.above())
								&& level.isEmptyBlock(pos.above())) {
							level.setBlockAndUpdate(pos.above(), riceUpper.defaultBlockState());
							CommonHooks.fireCropGrowPost(level, pos, state);
						}
					} else {
						level.setBlock(pos, this.withAge(age + 1), 2);
						CommonHooks.fireCropGrowPost(level, pos, state);
					}
				}
			}
		}
	}

	@Override
	protected MapCodec<? extends BushBlock> codec() {
		return CODEC;
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return Fluids.WATER.getSource(false);
	}

	@Override
	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		this.growCrops(level, pos, state);
	}

	public void growCrops(Level level, BlockPos pos, BlockState state) {
		int i = this.getAge(state) + this.getBonemealAgeIncrease(level);
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}

		level.setBlock(pos, this.getStateForAge(i), 2);
	}

	public BlockState getStateForAge(int age) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(age));
	}

}
