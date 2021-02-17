package com.saita.hardmodemod.items.tools;

import java.util.List;
import java.util.Random;

import com.saita.hardmodemod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class GreenLightsaber extends SwordItem {

	public GreenLightsaber(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§a"+tooltip.get(0).getString()+"§r"));	
    tooltip.add(new StringTextComponent("§7Will poison your foes."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addPotionEffect(new EffectInstance(Effects.POISON, 70, 1));
		return super.hitEntity(stack, target, attacker);
	}
	
	@Override
	public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
		Random r = new Random();
	    
		entity.playSound(SoundInit.LIGHTSABER.get(), 1.0F, 0.5F + r.nextFloat());
		return super.onEntitySwing(stack, entity);
	}
	

}
