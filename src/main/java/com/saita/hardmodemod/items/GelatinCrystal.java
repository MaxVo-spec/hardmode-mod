package com.saita.hardmodemod.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;


public class GelatinCrystal extends Item {

	public GelatinCrystal(Properties properties) {
		super(properties);
		
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7It's super sweet and tasty !"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		
		entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION, 300, 1));
		entityLiving.addPotionEffect(new EffectInstance(Effects.SPEED, 300, 1));
		entityLiving.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 300, 1));

		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}

}
