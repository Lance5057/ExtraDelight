package com.lance5057.extradelight.items;

import com.lance5057.extradelight.util.ItemUtils;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

public class ShuckableCorn extends Item {

	private final ResourceKey<LootTable> table;

	public ShuckableCorn(ResourceKey<LootTable> t, Properties pProperties) {
		super(pProperties);
		table = t;
	}

	public ResourceKey<LootTable> getNextItem() {
		return table;
	}

	@Override
	public int getUseDuration(ItemStack stack, LivingEntity entity) {
		return 16;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
		pPlayer.startUsingItem(pUsedHand);
		return InteractionResultHolder.consume(itemstack);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
		if (pLivingEntity instanceof Player p) {
			int c = Math.min(pStack.getCount(), 8);

			for (int i = 0; i < 5; ++i) {
				Vec3 vec3 = new Vec3(((double) pLevel.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D,
						0.0D);
				vec3 = vec3.xRot(-pLivingEntity.getXRot() * ((float) Math.PI / 180F));
				vec3 = vec3.yRot(-pLivingEntity.getYRot() * ((float) Math.PI / 180F));
				double d0 = (double) (-pLevel.random.nextFloat()) * 0.6D - 0.3D;
				Vec3 vec31 = new Vec3(((double) pLevel.random.nextFloat() - 0.5D) * 0.3D, d0, 0.6D);
				vec31 = vec31.xRot(-pLivingEntity.getXRot() * ((float) Math.PI / 180F));
				vec31 = vec31.yRot(-pLivingEntity.getYRot() * ((float) Math.PI / 180F));
				vec31 = vec31.add(pLivingEntity.getX(), pLivingEntity.getEyeY(), pLivingEntity.getZ());
				if (pLevel instanceof ServerLevel) // Forge: Fix MC-2518 spawnParticle is nooped on server, need to use
													// server specific variant
					((ServerLevel) pLevel).sendParticles(new ItemParticleOption(ParticleTypes.ITEM, pStack), vec31.x,
							vec31.y, vec31.z, 1, vec3.x, vec3.y + 0.05D, vec3.z, 0.0D);
				else
					pLevel.addParticle(new ItemParticleOption(ParticleTypes.ITEM, pStack), vec31.x, vec31.y, vec31.z,
							vec3.x, vec3.y + 0.05D, vec3.z);

			}

			for (int i = 0; i < c; ++i) {
				if (pLevel != null && !pLevel.isClientSide()) {
					final LootParams pContext = new LootParams.Builder((ServerLevel) pLevel)
							.withParameter(LootContextParams.THIS_ENTITY, p).create(LootContextParamSets.EMPTY);

					p.getServer().reloadableRegistries().getLootTable(table).getRandomItems(pContext)
							.forEach(itemStack -> ItemUtils.giveOrDrop(itemStack, p));
				}
			}

			pStack.shrink(8);
		}
		return pStack;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack pStack) {
		return UseAnim.BOW;
	}
}
