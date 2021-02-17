package com.saita.hardmodemod.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class CrystalApple extends Item {

	public CrystalApple(Properties properties) {
		super(properties);
		
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.RARE;
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		
		entityLiving.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 2400, 0));
		entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION, 600, 2));
		entityLiving.addPotionEffect(new EffectInstance(Effects.SPEED, 1200, 1));
		entityLiving.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 1200, 1));
		entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, 1200, 1));
		entityLiving.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 6000, 0));

		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}

}
