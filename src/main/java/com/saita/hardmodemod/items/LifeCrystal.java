package com.saita.hardmodemod.items;

import java.util.List;

import com.saita.hardmodemod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class LifeCrystal extends Item {

	public LifeCrystal(Properties properties) {
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
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§7Increases your maximum life. You can have a maximum of 20 hearts of health, but you will lose your bonus health if you die."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		
		if(entityLiving instanceof PlayerEntity)
		{
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			
		     if(playerIn.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getValue() < 40.0D)
    	     {
    	
    	       double getCurrentMaxHealth = playerIn.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getValue();
    	       playerIn.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(getCurrentMaxHealth + 2.0D);
    	       playerIn.heal(2);
    	       playerIn.playSound(SoundInit.LIFE_CRYSTAL.get(), 1.0F, 1.0F);
    	
         	 }
		     else
		     {
		    	 if(worldIn.isRemote)
		    	 {
		  	     playerIn.sendMessage(new TranslationTextComponent("§fYou already have 20 hearts of HP!"));
		    	 }
		     }
		}
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}

}
