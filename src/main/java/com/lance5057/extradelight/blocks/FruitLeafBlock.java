package com.lance5057.extradelight.blocks;

import java.util.OptionalInt;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredItem;

public class FruitLeafBlock extends Block {

	public static final int DECAY_DISTANCE = 7;
	public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE;
	public static final int MAX_AGE = 3;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;

	private final DeferredItem<Item> fruit;

	public FruitLeafBlock(Properties p_49795_, DeferredItem<Item> fruit) {
		super(p_49795_);
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0))
				.setValue(DISTANCE, Integer.valueOf(7)).setValue(PERSISTENT, false));
		this.fruit = fruit;
	}

	@Override
	public VoxelShape getBlockSupportShape(BlockState p_54456_, BlockGetter p_54457_, BlockPos p_54458_) {
		return Shapes.empty();
	}

	@Override
	public boolean isRandomlyTicking(BlockState p_54449_) {
		return !p_54449_.getValue(PERSISTENT) && p_54449_.getValue(DISTANCE) == 7 || p_54449_.getValue(AGE) < 3;
	}

	@Override
	public void randomTick(BlockState p_222563_, ServerLevel p_222564_, BlockPos p_222565_, RandomSource p_222566_) {
		if (this.decaying(p_222563_)) {
			dropResources(p_222563_, p_222564_, p_222565_);
			p_222564_.removeBlock(p_222565_, false);
		}

		if (p_222566_.nextInt(100) % 6 == 0) {
			int i = p_222563_.getValue(AGE);
			if (i < 3 && p_222564_.getRawBrightness(p_222565_.above(), 0) >= 9
					&& net.neoforged.neoforge.common.CommonHooks.canCropGrow(p_222564_, p_222565_, p_222563_,
							p_222566_.nextInt(5) == 0)) {
				BlockState blockstate = p_222563_.setValue(AGE, Integer.valueOf(i + 1));
				p_222564_.setBlock(p_222565_, blockstate, 2);
				p_222564_.gameEvent(GameEvent.BLOCK_CHANGE, p_222565_, GameEvent.Context.of(blockstate));
				net.neoforged.neoforge.common.CommonHooks.fireCropGrowPost(p_222564_, p_222565_, p_222563_);
			}
		}
	}

	protected boolean decaying(BlockState p_221386_) {
		return !p_221386_.getValue(PERSISTENT) && p_221386_.getValue(DISTANCE) == 7;
	}

	@Override
	public void tick(BlockState p_221369_, ServerLevel p_221370_, BlockPos p_221371_, RandomSource p_221372_) {
		p_221370_.setBlock(p_221371_, updateDistance(p_221369_, p_221370_, p_221371_), 3);
	}

	@Override
	public int getLightBlock(BlockState p_54460_, BlockGetter p_54461_, BlockPos p_54462_) {
		return 1;
	}

	@Override
	public BlockState updateShape(BlockState p_54440_, Direction p_54441_, BlockState p_54442_, LevelAccessor p_54443_,
			BlockPos p_54444_, BlockPos p_54445_) {
		int i = getDistanceAt(p_54442_) + 1;
		if (i != 1 || p_54440_.getValue(DISTANCE) != i) {
			p_54443_.scheduleTick(p_54444_, this, 1);
		}

		return p_54440_;
	}

	private static BlockState updateDistance(BlockState p_54436_, LevelAccessor p_54437_, BlockPos p_54438_) {
		int i = 7;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (Direction direction : Direction.values()) {
			blockpos$mutableblockpos.setWithOffset(p_54438_, direction);
			i = Math.min(i, getDistanceAt(p_54437_.getBlockState(blockpos$mutableblockpos)) + 1);
			if (i == 1) {
				break;
			}
		}

		return p_54436_.setValue(DISTANCE, Integer.valueOf(i));
	}

	private static int getDistanceAt(BlockState p_54464_) {
		return getOptionalDistanceAt(p_54464_).orElse(7);
	}

	public static OptionalInt getOptionalDistanceAt(BlockState p_277868_) {
		if (p_277868_.is(BlockTags.LOGS)) {
			return OptionalInt.of(0);
		} else {
			return p_277868_.hasProperty(DISTANCE) ? OptionalInt.of(p_277868_.getValue(DISTANCE)) : OptionalInt.empty();
		}
	}

	@Override
	public void animateTick(BlockState p_221374_, Level p_221375_, BlockPos p_221376_, RandomSource p_221377_) {
		if (p_221375_.isRainingAt(p_221376_.above())) {
			if (p_221377_.nextInt(15) == 1) {
				BlockPos blockpos = p_221376_.below();
				BlockState blockstate = p_221375_.getBlockState(blockpos);
				if (!blockstate.canOcclude() || !blockstate.isFaceSturdy(p_221375_, blockpos, Direction.UP)) {
					ParticleUtils.spawnParticleBelow(p_221375_, p_221376_, p_221377_, ParticleTypes.DRIPPING_WATER);
				}
			}
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_54447_) {
		p_54447_.add(DISTANCE, PERSISTENT, AGE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext p_54424_) {
		BlockState blockstate = this.defaultBlockState().setValue(PERSISTENT, Boolean.valueOf(true));
		return updateDistance(blockstate, p_54424_.getLevel(), p_54424_.getClickedPos());
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult result) {
		if (!level.isClientSide)
			if (state.getValue(AGE) >= FruitLeafBlock.MAX_AGE) {
				ItemStack fruit = new ItemStack(this.fruit.get(), level.random.nextInt(3) + 1);
				player.getInventory().placeItemBackInInventory(fruit);
				level.setBlock(pos, state.setValue(AGE, 0), 3);
			}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}
}
