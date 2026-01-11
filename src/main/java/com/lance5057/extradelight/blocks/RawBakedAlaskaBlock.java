package com.lance5057.extradelight.blocks;

import com.lance5057.extradelight.modules.SummerCitrus;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RawBakedAlaskaBlock extends Block {
	protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);
	public static final BooleanProperty ON_FIRE = BooleanProperty.create("on_fire");

	public RawBakedAlaskaBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(ON_FIRE, false));
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pState.getValue(ON_FIRE)) {
			pLevel.setBlock(pPos, SummerCitrus.BAKED_ALASKA.get().defaultBlockState(), UPDATE_ALL);
		}
	}

	@Override
	public boolean isRandomlyTicking(BlockState pState) {
		return true;
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult hitResult) {
		if (!level.isClientSide) {
			if (!state.getValue(ON_FIRE)) {
				if (stack.is(Items.FLINT_AND_STEEL)) {
					stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
					level.setBlock(pos, this.defaultBlockState().setValue(ON_FIRE, true), 2);
					return ItemInteractionResult.SUCCESS;
				}
				return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
			} else
				return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
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
		pBuilder.add(ON_FIRE);
	}
}
