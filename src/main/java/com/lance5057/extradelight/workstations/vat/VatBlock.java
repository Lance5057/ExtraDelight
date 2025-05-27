package com.lance5057.extradelight.workstations.vat;

import java.util.List;

import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.blocks.interfaces.IStyleable;
import com.lance5057.extradelight.state.OvenSupport;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.IItemHandler;

public class VatBlock extends Block implements EntityBlock, IStyleable {
	protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
	public static final IntegerProperty STYLE = IntegerProperty.create("style", 0, Styles.values().length - 1);
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	public static enum Styles {
		COPPER_BLOCK, WHITE_TERRACOTTA, LIGHT_GRAY_TERRACOTTA, GRAY_TERRACOTTA, BLACK_TERRACOTTA, BROWN_TERRACOTTA,
		RED_TERRACOTTA, ORANGE_TERRACOTTA, YELLOW_TERRACOTTA, LIME_TERRACOTTA, GREEN_TERRACOTTA, CYAN_TERRACOTTA,
		LIGHT_BLUE_TERRACOTTA, BLUE_TERRACOTTA, MAGENTA_TERRACOTTA, PINK_TERRACOTTA, PURPLE_TERRACOTTA,
//		WHITE_GLAZED_TERRACOTTA, LIGHT_GRAY_GLAZED_TERRACOTTA, GRAY_GLAZED_TERRACOTTA, BLACK_GLAZED_TERRACOTTA,
//		BROWN_GLAZED_TERRACOTTA, RED_GLAZED_TERRACOTTA, ORANGE_GLAZED_TERRACOTTA, YELLOW_GLAZED_TERRACOTTA,
//		LIME_GLAZED_TERRACOTTA, GREEN_GLAZED_TERRACOTTA, CYAN_GLAZED_TERRACOTTA, LIGHT_BLUE_GLAZED_TERRACOTTA,
//		BLUE_GLAZED_TERRACOTTA, MAGENTA_GLAZED_TERRACOTTA, PINK_GLAZED_TERRACOTTA, PURPLE_GLAZED_TERRACOTTA

	}

	public VatBlock() {
		super(Properties.ofFullCopy(Blocks.COPPER_BLOCK));
		this.registerDefaultState(this.stateDefinition.any().setValue(STYLE, 0).setValue(FACING, Direction.NORTH));
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
		p_53681_.add(STYLE, FACING);
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public boolean isPathfindable(BlockState pState, PathComputationType pType) {
		return false;
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState pState, Level pLevel, BlockPos pPos,
			Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if (pLevel.isClientSide) {
			return ItemInteractionResult.SUCCESS;
		} else {
			BlockEntity tileEntity = pLevel.getBlockEntity(pPos);
			if (tileEntity instanceof VatBlockEntity mbe) {
				MenuProvider containerProvider = new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.translatable("screen.vat.name");
					}

					@Override
					public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory,
							Player playerEntity) {
						return new VatMenu(windowId, playerInventory, mbe);
					}
				};
				pPlayer.openMenu(containerProvider, buf -> buf.writeBlockPos(pPos));

			}
			return ItemInteractionResult.CONSUME;

		}

	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		// TODO Auto-generated method stub
		return new VatBlockEntity(pPos, pState);
	}

	@Override
	public int numStyles() {
		return Styles.values().length;
	}

	@Override
	public int getCurrentStyle(BlockState state) {
		return state.getValue(STYLE);
	}

	@Override
	public void setNextStyle(Level level, BlockPos pos, BlockState state) {
		int next = state.getValue(STYLE) + 1;
		if (state.getValue(STYLE) >= numStyles() - 1) {
			next = 0;
		}

		for (int i = 0; i < 10; i++)
			level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.SNOW_BLOCK.defaultBlockState()),
					pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, 0, 0, 0);
		level.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

		BlockState nextState = state.setValue(STYLE, next);
		level.setBlock(pos, nextState, 3);
	}

	@Override
	public void setPrevStyle(Level level, BlockPos pos, BlockState state) {
		int next = state.getValue(STYLE) - 1;
		if (next < 0) {
			next = this.numStyles() - 1;
		}

		for (int i = 0; i < 10; i++)
			level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.SNOW_BLOCK.defaultBlockState()),
					pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, 0, 0, 0);
		level.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

		BlockState nextState = state.setValue(STYLE, next);
		level.setBlock(pos, nextState, 3);
	}

	@Override
	public BlockState getState(int i) {
		return this.defaultBlockState().setValue(STYLE, i);
	}

	@Override
	public void setStyle(Level level, BlockPos pos, BlockState state, int style) {
		BlockState nextState = state.setValue(STYLE, style);
		level.setBlock(pos, nextState, 3);
	}

	@Override
	public boolean isPatreonStyle(int style) {
		return false;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents,
			TooltipFlag tooltipFlag) {
		MutableComponent textEmpty = Component.translatable(ExtraDelight.MOD_ID + ".tooltip.styleable");
		tooltipComponents.add(textEmpty.withStyle(ChatFormatting.AQUA));
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileEntity = level.getBlockEntity(pos);
			if (tileEntity instanceof VatBlockEntity te) {
				IItemHandler items = te.getItemHandler();
				for (int i = 0; i < te.getItemHandler().getSlots(); i++) {
					level.addFreshEntity(
							new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), items.getStackInSlot(i)));
				}
				level.updateNeighbourForOutputSignal(pos, this);
			}

			super.onRemove(state, level, pos, newState, isMoving);
		}
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
			BlockEntityType<T> pBlockEntityType) {
//		if (!pLevel.isClientSide())
		return pBlockEntityType == ExtraDelightBlockEntities.VAT.get() ? VatBlockEntity::tick : null;
//		return null;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos,
			Player player) {
		ItemStack stack = new ItemStack(this);
		stack.set(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY.with(STYLE, state.getValue(STYLE)));
		return stack;
	}

	@Override
	public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
		if (!level.isClientSide && !player.isCreative()
				&& level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
			ItemStack itemstack = new ItemStack(this);
			itemstack.set(DataComponents.BLOCK_STATE,
					BlockItemStateProperties.EMPTY.with(STYLE, state.getValue(STYLE)));
			ItemEntity itementity = new ItemEntity(level, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					itemstack);
			itementity.setDefaultPickUpDelay();
			level.addFreshEntity(itementity);
		}

		return super.playerWillDestroy(level, pos, state, player);
	}

}
