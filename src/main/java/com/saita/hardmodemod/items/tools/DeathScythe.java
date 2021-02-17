package com.saita.hardmodemod.items.tools;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class DeathScythe extends SwordItem {

	public DeathScythe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.RARE;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§5"+tooltip.get(0).getString()+"§r"));
	tooltip.add(new StringTextComponent("§7Has a chance to heal you upon dealing damage."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		int randomAttackHealChance = random.nextInt(6);
		  if(randomAttackHealChance == 0)
		  {
			attacker.heal(1);
			stack.damageItem(1, attacker, null);
		  }
		  if(randomAttackHealChance == 1)
		  {
			attacker.heal(2);
			stack.damageItem(1, attacker, null);
		  }
		
		
		return super.hitEntity(stack, target, attacker);
	}
	

}
