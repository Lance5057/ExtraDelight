package com.lance5057.extradelight.blocks;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class YeastPotBlock extends Block {
	protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);
	public static final BooleanProperty YEASTED = BooleanProperty.create("yeasted");
	private final int speed;
	final Supplier<Item> output;

	public YeastPotBlock(Supplier<Item> output, int speed) {
		super(Properties.of(Material.STONE).strength(0.5F, 1.0F).sound(SoundType.STONE).randomTicks());
		this.registerDefaultState(this.stateDefinition.any().setValue(YEASTED, false));
		this.speed = speed;
		this.output = output;
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pRandom.nextInt() % speed == 0)
			pLevel.setBlock(pPos, this.defaultBlockState().setValue(YEASTED, true), 2);
	}

	@Override
	public boolean isRandomlyTicking(BlockState pState) {
		return true;
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel,
			BlockPos pCurrentPos, BlockPos pFacingPos) {
		pLevel.scheduleTick(pCurrentPos, this, 1);

		return pState;
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult result) {
		if (!level.isClientSide) {
			if (state.getValue(YEASTED)) {
				if (player.getItemInHand(hand).getItem() == Items.GLASS_BOTTLE) {
					player.addItem(new ItemStack(output.get()));
					ItemStack s = player.getItemInHand(hand);
					s.setCount(s.getCount()-1);
					level.destroyBlock(pos, true);
					return InteractionResult.SUCCESS;
				}
				return InteractionResult.FAIL;
			} else
				return InteractionResult.FAIL;
		}
		return InteractionResult.SUCCESS;
	}

	public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pState.getValue(YEASTED)) {
			double d0 = (double) pPos.getX() + 0.25D + pRandom.nextDouble() / 2;
			double d1 = (double) pPos.getY() + 0.4D;
			double d2 = (double) pPos.getZ() + 0.25D + pRandom.nextDouble() / 2;
			pLevel.addParticle(ParticleTypes.BUBBLE_POP, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			pLevel.playLocalSound(d0, d1, d2, SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, SoundSource.AMBIENT, 0.1f, 0,
					false);
		}
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(YEASTED);
	}
}
