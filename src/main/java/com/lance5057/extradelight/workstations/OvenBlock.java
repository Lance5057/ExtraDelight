package com.lance5057.extradelight.workstations;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.TranslatableKeys;
import com.lance5057.extradelight.state.OvenSupport;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;
import vectorwing.farmersdelight.common.registry.ModSounds;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.MathUtils;

import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("deprecation")
public class OvenBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final EnumProperty<OvenSupport> SUPPORT = EnumProperty.create("support", OvenSupport.class);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 10.0D, 14.0D);
	protected static final VoxelShape SHAPE_WITH_TRAY = Shapes.or(SHAPE,
			Block.box(0.0D, -1.0D, 0.0D, 16.0D, 0.0D, 16.0D));

	public OvenBlock() {
		super(Properties.of(Material.METAL).strength(0.5F, 6.0F).sound(SoundType.LANTERN));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH)
				.setValue(SUPPORT, OvenSupport.NONE).setValue(WATERLOGGED, false));
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult result) {
		if (!level.isClientSide) {
			BlockEntity tileEntity = level.getBlockEntity(pos);
			if (tileEntity instanceof OvenBlockEntity OvenEntity) {
				NetworkHooks.openScreen((ServerPlayer) player, OvenEntity, pos);
			}
		}
		return InteractionResult.SUCCESS;
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
		return state.getValue(SUPPORT).equals(OvenSupport.TRAY) ? SHAPE_WITH_TRAY : SHAPE;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos pos = context.getClickedPos();
		Level level = context.getLevel();
		FluidState fluid = level.getFluidState(context.getClickedPos());

		BlockState state = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
				.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);

		if (context.getClickedFace().equals(Direction.DOWN)) {
			return state.setValue(SUPPORT, OvenSupport.HANDLE);
		}
		return state.setValue(SUPPORT, getTrayState(level, pos));
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level,
			BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}
		if (facing.getAxis().equals(Direction.Axis.Y) && !state.getValue(SUPPORT).equals(OvenSupport.HANDLE)) {
			return state.setValue(SUPPORT, getTrayState(level, currentPos));
		}
		return state;
	}

	private OvenSupport getTrayState(LevelAccessor level, BlockPos pos) {
		if (level.getBlockState(pos.below()).is(ModTags.TRAY_HEAT_SOURCES)) {
			return OvenSupport.TRAY;
		}
		return OvenSupport.NONE;
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
		ItemStack stack = super.getCloneItemStack(level, pos, state);
		OvenBlockEntity OvenEntity = (OvenBlockEntity) level.getBlockEntity(pos);
		if (OvenEntity != null) {
			CompoundTag nbt = OvenEntity.writeMeal(new CompoundTag());
			if (!nbt.isEmpty()) {
				stack.addTagElement("BlockEntityTag", nbt);
			}
			if (OvenEntity.hasCustomName()) {
				stack.setHoverName(OvenEntity.getCustomName());
			}
		}
		return stack;
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileEntity = level.getBlockEntity(pos);
			if (tileEntity instanceof OvenBlockEntity OvenEntity) {
				Containers.dropContents(level, pos, OvenEntity.getDroppableInventory());
				OvenEntity.getUsedRecipesAndPopExperience(level, Vec3.atCenterOf(pos));
				level.updateNeighbourForOutputSignal(pos, this);
			}

			super.onRemove(state, level, pos, newState, isMoving);
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip,
			TooltipFlag flagIn) {
		super.appendHoverText(stack, level, tooltip, flagIn);
		CompoundTag nbt = stack.getTagElement("BlockEntityTag");
		ItemStack mealStack = OvenBlockEntity.getMealFromItem(stack);

		if (!mealStack.isEmpty()) {
			MutableComponent textServingsOf = mealStack.getCount() == 1
					? Component.translatable(TranslatableKeys.SINGLE_SERVING)
					: Component.translatable(TranslatableKeys.MANY_SERVINGS, mealStack.getCount());
			tooltip.add(textServingsOf.withStyle(ChatFormatting.GRAY));
			MutableComponent textMealName = mealStack.getHoverName().copy();
			tooltip.add(textMealName.withStyle(mealStack.getRarity().color));
		} else {
			MutableComponent textEmpty = Component.translatable(TranslatableKeys.EMPTY);
			tooltip.add(textEmpty.withStyle(ChatFormatting.GRAY));
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, SUPPORT, WATERLOGGED);
	}

	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
			ItemStack stack) {
		if (stack.hasCustomHoverName()) {
			BlockEntity tileEntity = level.getBlockEntity(pos);
			if (tileEntity instanceof OvenBlockEntity) {
				((OvenBlockEntity) tileEntity).setCustomName(stack.getHoverName());
			}
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		BlockEntity tileEntity = level.getBlockEntity(pos);
		if (tileEntity instanceof OvenBlockEntity OvenEntity && OvenEntity.isHeated()) {
			SoundEvent boilSound = !OvenEntity.getMeal().isEmpty() ? ModSounds.BLOCK_COOKING_POT_BOIL_SOUP.get()
					: ModSounds.BLOCK_COOKING_POT_BOIL.get();
			double x = (double) pos.getX() + 0.5D;
			double y = pos.getY();
			double z = (double) pos.getZ() + 0.5D;
			if (random.nextInt(10) == 0) {
				level.playLocalSound(x, y, z, boilSound, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.2F + 0.9F,
						false);
			}
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
		BlockEntity tileEntity = level.getBlockEntity(pos);
		if (tileEntity instanceof OvenBlockEntity) {
			ItemStackHandler inventory = ((OvenBlockEntity) tileEntity).getInventory();
			return MathUtils.calcRedstoneFromItemHandler(inventory);
		}
		return 0;
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return ExtraDelightBlockEntities.OVEN.get().create(pos, state);
	}

	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
			BlockEntityType<T> blockEntity) {
		if (level.isClientSide) {
			return createTickerHelper(blockEntity, ExtraDelightBlockEntities.OVEN.get(),
					OvenBlockEntity::animationTick);
		}
		return createTickerHelper(blockEntity, ExtraDelightBlockEntities.OVEN.get(), OvenBlockEntity::cookingTick);
	}
}
