package com.lance5057.extradelight.blocks;

import com.lance5057.extradelight.ExtraDelightTags;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class FrostableBlock extends Block {
	public static enum Styles {
		CREEPER, CROSS, EYE, PIGLIN, SHINGLE, SKELETON, SNOW, SNOW_TRIM, SWIRL, TRIM, WITHER
	};

	public static final IntegerProperty STYLE = IntegerProperty.create("style", 0, 10);

	public FrostableBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(STYLE, 0));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(STYLE);
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult hit) {
		ItemStack stack = player.getItemInHand(hand);

		if (stack.is(ExtraDelightTags.OFFSET_SPATULAS)) {
			int next = state.getValue(STYLE) + 1;
			if (state.getValue(STYLE) >= 10) {
				next = 0;
			}

			for (int i = 0; i < 10; i++) 
				level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.SNOW_BLOCK.defaultBlockState()),
						pos.getX() + 0.5f,
						pos.getY() + 0.5f,
						pos.getZ() + 0.5f, 0, 0, 0);
			level.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

			level.setBlock(pos, state.setValue(STYLE, next), 3);
			return InteractionResult.SUCCESS;
		}

		return InteractionResult.PASS;
	}
}
