package com.saita.hardmodemod.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class TitanRing extends Item {

	public TitanRing(Properties properties) {
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
	    	
	    tooltip.add(new StringTextComponent("§7While in your inventory, you get 80% knockback resistance."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	 }
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		 if(entityIn instanceof PlayerEntity)
	    	{
	    	  PlayerEntity playerIn = (PlayerEntity)entityIn;		  
	    	  playerIn.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
	    	}

		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}

}
