package com.saita.hardmodemod.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class BlazingSkull extends Item {

	public BlazingSkull(Properties properties) {
		super(properties);
		
	}
	
	@Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.RARE;
    }
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	 @Override
	    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	    {
	    	
	    tooltip.add(new StringTextComponent("§7While in your inventory, you get fire resistance, and you get healed and stronger when you are burning."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	  }
	 
	 @Override
	 public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
	    	
	    if(entityIn instanceof PlayerEntity)
	    	{
	    	   PlayerEntity playerIn = (PlayerEntity)entityIn;
	    	      if(playerIn.getActivePotionEffect(Effects.FIRE_RESISTANCE) == null)
  			        {
	    	          playerIn.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 5, 0, false, false));
  			        }
	    	   
	    	   if(playerIn.isBurning())
	    	   {
	    		   if(playerIn.getActivePotionEffect(Effects.STRENGTH) == null)
	    		   {
	    			   playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 2, false, false));
	    		   }
	    		   
	    		   if(worldIn.getDayTime() % 60 == 0)
	    		   {
	    			   playerIn.heal(1);
	    		   }
	    	   } 			
	    			 
	    	}
	    	   	
	       
	    	super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	    }

}
