package com.saita.hardmodemod.items;

import java.util.List;

import com.saita.hardmodemod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class InstantHealingPotion extends Item {

	public InstantHealingPotion(Properties properties) {
		super(properties);
		
	}
	
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	 {
	    	
	 tooltip.add(new StringTextComponent("§7Heals 3 hearts instantly. §f1 second cooldown."));
     super.addInformation(stack, worldIn, tooltip, flagIn);
	 }  
	    
	 @Override
	 public Rarity getRarity(ItemStack stack) {
	    	
	 return Rarity.UNCOMMON;
	 }
	 
	 @Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	    	
	    ItemStack itemstack = playerIn.getHeldItem(handIn);
	    playerIn.getCooldownTracker().setCooldown(this, 20);
	    itemstack.shrink(1);
	    
	    playerIn.heal(6);
	    playerIn.playSound(SoundInit.INSTANT_HEALING_POTION.get(), 1.0F, 1.0F);

	    return super.onItemRightClick(worldIn, playerIn, handIn);
	 }

}
