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

public class MoltenCore extends Item{

	public MoltenCore(Properties properties) {
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
    	
    tooltip.add(new StringTextComponent("§7Will make you way too §cHOT §7against your foes. §f45 seconds cooldown."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
    
    @Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.RARE;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	
    	ItemStack itemstack = playerIn.getHeldItem(handIn);
    	playerIn.getCooldownTracker().setCooldown(this, 900);
    	itemstack.shrink(1);
    	
    	if(worldIn.isRemote)
    	{
 	      playerIn.sendMessage(new TranslationTextComponent("§cYou feel like a volcano!"));
    	}
    	
    	playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 900, 9));
    	playerIn.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 900, 0));
    	playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 900, 3));
    	playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 900, 1));
    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.MOLTEN_CORE.get(), SoundCategory.MASTER, 0.6F, 1.0F);
    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
