package com.saita.hardmodemod.items;

import java.util.List;

import com.saita.hardmodemod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class NanoBoost extends Item {

	public NanoBoost(Properties properties) {
		super(properties);
		
	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7Use it to get a powerful speed, resistance, haste and strength boost for 1 minute. Can be used to craft Nano Blade. §f60 seconds cooldown."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
    
    @Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.RARE;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	
    	ItemStack itemstack = playerIn.getHeldItem(handIn);
    	playerIn.getCooldownTracker().setCooldown(this, 1200);
    	itemstack.shrink(1);
    	
    	if(worldIn.isRemote)
    	{
 	    playerIn.sendMessage(new TranslationTextComponent("§bYou feel... Powerful!"));
    	}
    	
    	playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 1200, 2));
    	playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 1200, 1));
    	playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 1200, 2));
    	playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 1200, 2));
    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.NANO_BOOST.get(), SoundCategory.MASTER, 0.5F, 1.0F);
    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
