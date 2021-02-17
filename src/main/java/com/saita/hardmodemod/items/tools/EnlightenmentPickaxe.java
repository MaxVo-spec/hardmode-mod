package com.saita.hardmodemod.items.tools;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class EnlightenmentPickaxe extends PickaxeItem {

	public EnlightenmentPickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.RARE;
	}

	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
	tooltip.add(new StringTextComponent("§7Able to mine §6Palladium Ore§7, §eStar Chunk§7 and §4Heart Crystals§7."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		if(stack.isEnchanted() == false)
			
		  {
		  stack.addEnchantment(Enchantments.FORTUNE, 4);
		  }
		
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
}
