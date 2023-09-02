package com.lance5057.extradelight.items;

import com.lance5057.extradelight.util.ItemUtils;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

public class ShuckableCorn extends Item {

	private final ResourceLocation table;

	public ShuckableCorn(ResourceLocation t, Properties pProperties) {
		super(pProperties);
		table = t;
	}

	public ResourceLocation getNextItem() {
		return table;
	}

	@Override
	public int getUseDuration(ItemStack pStack) {
		return 32;
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
			pStack.shrink(1);

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
			
			if (pLevel != null && !pLevel.isClientSide()) {
				final LootContext pContext = new LootContext.Builder((ServerLevel) pLevel)
						.withParameter(LootContextParams.THIS_ENTITY, p).withRandom(pLevel.getRandom())
						.create(LootContextParamSets.EMPTY);
				p.getServer().getLootTables().get(table).getRandomItems(pContext)
						.forEach(itemStack -> ItemUtils.giveOrDrop(itemStack, p));
			}

		}
		return pStack;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack pStack) {
		return UseAnim.BOW;
	}
}
