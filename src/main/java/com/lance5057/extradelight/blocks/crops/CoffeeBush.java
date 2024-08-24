//package com.lance5057.extradelight.blocks.crops;
//
//import com.lance5057.extradelight.ExtraDelightItems;
//import com.mojang.serialization.MapCodec;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.util.RandomSource;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.ItemInteractionResult;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.LevelReader;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.BonemealableBlock;
//import net.minecraft.world.level.block.BushBlock;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.minecraft.world.level.block.state.properties.IntegerProperty;
//import net.minecraft.world.level.gameevent.GameEvent;
//import net.minecraft.world.phys.BlockHitResult;
//import net.minecraft.world.phys.shapes.CollisionContext;
//import net.minecraft.world.phys.shapes.VoxelShape;
//
//public class CoffeeBush extends BushBlock implements BonemealableBlock {
//	public static final MapCodec<CoffeeBush> CODEC = simpleCodec(CoffeeBush::new);
//	public static final int MAX_AGE = 3;
//	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
//	private static final VoxelShape SAPLING_SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 8.0, 13.0);
//	private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
//
//	@Override
//	public MapCodec<CoffeeBush> codec() {
//		return CODEC;
//	}
//
//	public CoffeeBush(BlockBehaviour.Properties p_57249_) {
//		super(p_57249_);
//		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
//	}
//
//	@Override
//	public ItemStack getCloneItemStack(LevelReader p_304655_, BlockPos p_57257_, BlockState p_57258_) {
//		return new ItemStack(ExtraDelightItems.COFFEE_CHERRIES.get());
//	}
//
//	@Override
//	public VoxelShape getShape(BlockState p_57291_, BlockGetter p_57292_, BlockPos p_57293_,
//			CollisionContext p_57294_) {
//		if (p_57291_.getValue(AGE) == 0) {
//			return SAPLING_SHAPE;
//		} else {
//			return p_57291_.getValue(AGE) < 3 ? MID_GROWTH_SHAPE
//					: super.getShape(p_57291_, p_57292_, p_57293_, p_57294_);
//		}
//	}
//
//	@Override
//	public boolean isRandomlyTicking(BlockState p_57284_) {
//		return p_57284_.getValue(AGE) < 3;
//	}
//
//	@Override
//	public void randomTick(BlockState p_222563_, ServerLevel p_222564_, BlockPos p_222565_, RandomSource p_222566_) {
//		int i = p_222563_.getValue(AGE);
//		if (i < 3 && p_222564_.getRawBrightness(p_222565_.above(), 0) >= 9 && net.neoforged.neoforge.common.CommonHooks
//				.canCropGrow(p_222564_, p_222565_, p_222563_, p_222566_.nextInt(5) == 0)) {
//			BlockState blockstate = p_222563_.setValue(AGE, Integer.valueOf(i + 1));
//			p_222564_.setBlock(p_222565_, blockstate, 2);
//			p_222564_.gameEvent(GameEvent.BLOCK_CHANGE, p_222565_, GameEvent.Context.of(blockstate));
//			net.neoforged.neoforge.common.CommonHooks.fireCropGrowPost(p_222564_, p_222565_, p_222563_);
//		}
//	}
//
//	@Override
//	public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player,
//			InteractionHand hand, BlockHitResult hitResult) {
//		int i = state.getValue(AGE);
//		boolean flag = i == 3;
//		if (!flag && stack.is(Items.BONE_MEAL)) {
//			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
//		} else if (i > 2) {
//			int j = 1 + level.random.nextInt(2);
//			popResource(level, pos, new ItemStack(ExtraDelightItems.COFFEE_CHERRIES.get(), j + 1));
//			level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F,
//					0.8F + level.random.nextFloat() * 0.4F);
//			BlockState blockstate = state.setValue(AGE, Integer.valueOf(1));
//			level.setBlock(pos, blockstate, 3);
//			level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
//			return ItemInteractionResult.sidedSuccess(!level.isClientSide());
//		} else {
//			return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
//		}
//	}
//
//	@Override
//	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57282_) {
//		p_57282_.add(AGE);
//	}
//
//	@Override
//	public boolean isValidBonemealTarget(LevelReader p_256056_, BlockPos p_57261_, BlockState p_57262_) {
//		return p_57262_.getValue(AGE) < 3;
//	}
//
//	@Override
//	public boolean isBonemealSuccess(Level p_222558_, RandomSource p_222559_, BlockPos p_222560_,
//			BlockState p_222561_) {
//		return true;
//	}
//
//	@Override
//	public void performBonemeal(ServerLevel p_222553_, RandomSource p_222554_, BlockPos p_222555_,
//			BlockState p_222556_) {
//		int i = Math.min(3, p_222556_.getValue(AGE) + 1);
//		p_222553_.setBlock(p_222555_, p_222556_.setValue(AGE, Integer.valueOf(i)), 2);
//	}
//}
