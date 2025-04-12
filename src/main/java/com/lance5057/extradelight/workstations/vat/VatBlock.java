package com.lance5057.extradelight.workstations.vat;

import java.util.List;

import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.blocks.interfaces.IStyleable;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.IItemHandler;

public class VatBlock extends Block implements EntityBlock, IStyleable {
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D);
	public static final IntegerProperty STYLE = IntegerProperty.create("style", 0, Styles.values().length);

	public static enum Styles {
		COPPER
	}

	public VatBlock() {
		super(Properties.ofFullCopy(Blocks.ACACIA_WOOD).strength(0.5F, 1.0F).sound(SoundType.WOOD).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(STYLE, 0));
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
		p_53681_.add(STYLE);
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
		if (!pLevel.isClientSide())
			return pBlockEntityType == ExtraDelightBlockEntities.VAT.get() ? VatBlockEntity::tick : null;
		return null;
	}

}
