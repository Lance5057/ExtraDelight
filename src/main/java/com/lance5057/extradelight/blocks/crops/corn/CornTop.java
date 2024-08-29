package com.lance5057.extradelight.blocks.crops.corn;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CornTop extends CropBlock {
	public static final int MAX_AGE = 3;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	public static final BooleanProperty DIMENSION = BooleanProperty.create("dimension");
	public static final BooleanProperty DENSE = BooleanProperty.create("dense");
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] { Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D),
			Block.box(4.0D, 0.0D, 4.0D, 12.0D, 14.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D),
			Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D) };

	public CornTop(BlockBehaviour.Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0))
				.setValue(DIMENSION, false).setValue(DENSE, false));
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

	public int getAge(BlockState pState) {
		return pState.getValue(this.getAgeProperty());
	}

	public BlockState getStateForAge(int pAge) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(pAge));
	}

//	public boolean isMaxAge(BlockState pState) {
//		return pState.getValue(this.getAgeProperty()) >= this.getMaxAge();
//	}

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
				float f = CropBlock.getGrowthSpeed(pState, pLevel, pPos);
				if (net.neoforged.neoforge.common.CommonHooks.canCropGrow(pLevel, pPos, pState,
						pRandom.nextInt((int) (25.0F / f) + 1) == 0)) {
					pLevel.setBlock(pPos, this.getStateForAge(i + 1), Block.UPDATE_ALL);
					net.neoforged.neoforge.common.CommonHooks.fireCropGrowPost(pLevel, pPos, pState);
				}
			}
		}

	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel,
			BlockPos pCurrentPos, BlockPos pFacingPos) {
		BlockState s = super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);

		if (s.getBlock() == ExtraDelightBlocks.CORN_TOP.get())
			if (isMaxAge(pState)) {
				if (checkSides(pLevel, pCurrentPos.east()) && checkSides(pLevel, pCurrentPos.north())
						&& checkSides(pLevel, pCurrentPos.west()) && checkSides(pLevel, pCurrentPos.south())) {
					pLevel.setBlock(pCurrentPos, s.setValue(CornTop.DENSE, true), Block.UPDATE_ALL);
				}
			}

		return s;
	}

	boolean checkSides(LevelAccessor pLevel, BlockPos pos) {
		BlockState e = pLevel.getBlockState(pos);
		if (e.getBlock() instanceof CornTop) {
			return isMaxAge(e);
		}
		return false;
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

//	protected static float getGrowthSpeed(Block pBlock, BlockGetter pLevel, BlockPos pPos) {
//		float f = 1.0F;
//		BlockPos blockpos = pPos.below();
//
//		for (int i = -1; i <= 1; ++i) {
//			for (int j = -1; j <= 1; ++j) {
//				float f1 = 0.0F;
//				BlockState blockstate = pLevel.getBlockState(blockpos.offset(i, 0, j));
//				if (blockstate.canSustainPlant(pLevel, blockpos.offset(i, 0, j), net.minecraft.core.Direction.UP,
//						(IPlantable) pBlock)) {
//					f1 = 1.0F;
//					if (blockstate.isFertile(pLevel, pPos.offset(i, 0, j))) {
//						f1 = 3.0F;
//					}
//				}
//
//				if (i != 0 || j != 0) {
//					f1 /= 4.0F;
//				}
//
//				f += f1;
//			}
//		}
//
//		BlockPos blockpos1 = pPos.north();
//		BlockPos blockpos2 = pPos.south();
//		BlockPos blockpos3 = pPos.west();
//		BlockPos blockpos4 = pPos.east();
//		boolean flag = pLevel.getBlockState(blockpos3).is(pBlock) || pLevel.getBlockState(blockpos4).is(pBlock);
//		boolean flag1 = pLevel.getBlockState(blockpos1).is(pBlock) || pLevel.getBlockState(blockpos2).is(pBlock);
//		if (flag && flag1) {
//			f /= 2.0F;
//		} else {
//			boolean flag2 = pLevel.getBlockState(blockpos3.north()).is(pBlock)
//					|| pLevel.getBlockState(blockpos4.north()).is(pBlock)
//					|| pLevel.getBlockState(blockpos4.south()).is(pBlock)
//					|| pLevel.getBlockState(blockpos3.south()).is(pBlock);
//			if (flag2) {
//				f /= 2.0F;
//			}
//		}
//
//		return f;
//	}

	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		if (pState.getValue(CornTop.DIMENSION))
			return true;
		return (pLevel.getRawBrightness(pPos, 0) >= 8 || pLevel.canSeeSky(pPos))
				&& pLevel.getBlockState(pPos.below()).getBlock() == ExtraDelightBlocks.CORN_BOTTOM.get();
	}

//	public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
//		if (pEntity instanceof Ravager
//				&& net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(pLevel, pEntity)) {
//			pLevel.destroyBlock(pPos, true, pEntity);
//		}
//
//		if (pEntity instanceof Player p) {
//			boolean b = pState.getValue(CornTop.DENSE);
//			if (b) {
//				if (isHalloween()) {
//					if (p.hasEffect(MobEffects.CONFUSION)) {
//						MobEffectInstance mei = p.getEffect(MobEffects.CONFUSION);
//						if (mei.getDuration() <= 3) {
//							if (pLevel instanceof ServerLevel && !pEntity.isPassenger() && !pEntity.isVehicle()
//									&& pEntity.canChangeDimensions()) {
//								ResourceKey<Level> resourcekey = ExtraDelightWorldGen.CORNFIELD;
//								ServerLevel serverlevel = ((ServerLevel) pLevel).getServer().getLevel(resourcekey);
//								if (serverlevel == null) {
//									return;
//								}
//
//								pEntity.changeDimension(serverlevel, new ITeleporter() {
//									@Override
//									public Entity placeEntity(Entity entity, ServerLevel currentWorld,
//											ServerLevel destWorld, float yaw,
//											Function<Boolean, Entity> repositionEntity) {
//										Entity repositionedEntity = repositionEntity.apply(false);
//
//										return repositionedEntity;
//									}
//
//									@Override
//									public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld,
//											Function<ServerLevel, PortalInfo> defaultPortalInfo) {
//										return new PortalInfo(new Vec3(p.getX(), 33, p.getZ()),
//												entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
//									}
//
//									@Override
//									public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld,
//											ServerLevel destWorld) {
//										return false;
//									}
//								});
//							}
//						}
//					} else {
//						if (pLevel.random.nextInt(100) == 0)
//							p.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200));
//					}
//				}
//			}
//
//		}
//		if (pState.getValue(CornTop.DIMENSION)) {
//			if (pEntity.isSprinting())
//				pEntity.hurt(DamageSource.SWEET_BERRY_BUSH, 1);
//			pEntity.makeStuckInBlock(pState, new Vec3((double) 0.8F, 0.75D, (double) 0.4F));
//
//		}
//		super.entityInside(pState, pLevel, pPos, pEntity);
//	}

	private static boolean isHalloween() {
		LocalDate localdate = LocalDate.now();
		int i = localdate.get(ChronoField.DAY_OF_MONTH);
		int j = localdate.get(ChronoField.MONTH_OF_YEAR);
		return j == 10 && i >= 1 || j == 11 && i <= 10;
	}

	protected ItemLike getBaseSeedId() {
		return ExtraDelightItems.CORN_SEEDS.get();
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
		pBuilder.add(AGE, DIMENSION, DENSE);
	}

//	@Override
//	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
//			BlockHitResult hit) {
//		if (!state.getValue(CornTop.DIMENSION))
//			if (this.isMaxAge(state)) {
//				level.setBlock(pos, this.getStateForAge(0), 2);
//				ItemStack corn = new ItemStack(ExtraDelightItems.UNSHUCKED_CORN.get(), 4);
//				if (!player.getInventory().add(corn)) {
//					player.drop(corn, false);
//				}
//
//				return InteractionResult.SUCCESS;
//			}
//		return InteractionResult.PASS;
//	}

	@Override
	public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
		if (pState.getValue(DIMENSION)) {
			pLevel.setBlock(pPos, pState, 4);
		}
	}
}
