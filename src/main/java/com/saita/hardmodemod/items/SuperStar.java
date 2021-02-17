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

public class SuperStar extends Item {

	public SuperStar(Properties properties) {
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
    	
    tooltip.add(new StringTextComponent("§7Will make you invincible for a short time. §f40 seconds cooldown."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
    
    @Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.EPIC;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	
    	ItemStack itemstack = playerIn.getHeldItem(handIn);
    	playerIn.getCooldownTracker().setCooldown(this, 800);
    	itemstack.shrink(1);
    	
    	 if(worldIn.isRemote)
    	 {
 	     playerIn.sendMessage(new TranslationTextComponent("§dAn overwhelming power flows through you!"));
    	 }
    	 
    	playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 240, 4));
    	playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 240, 3));
    	playerIn.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 240, 2));
    	playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 240, 3));
    	playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 240, 2));
    	playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 240, 0));
    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.SUPER_STAR.get(), SoundCategory.MASTER, 1.0F, 1.0F);
    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
