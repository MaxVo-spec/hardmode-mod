package com.saita.hardmodemod.items;

import java.util.List;

import com.saita.hardmodemod.entities.EyeOfCthulhu;
import com.saita.hardmodemod.init.HardmodeEntityTypes;
import com.saita.hardmodemod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SuspiciousLookingEye extends Item {

	public SuspiciousLookingEye(Properties properties) {
		super(properties);

	}
	
	
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	 {
	    	
	 tooltip.add(new StringTextComponent("§7Summons the Eye of Cthulhu. §4WARNING! §7Fighting the EoC during daytime will make it much stronger and tougher to kill! §4Use it with caution! §f10 seconds cooldown."));
     super.addInformation(stack, worldIn, tooltip, flagIn);
	 }  
	    
	 @Override
	 public Rarity getRarity(ItemStack stack) {
	    	
	    return Rarity.RARE;
	 }
	 
	 @Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	 
	      ItemStack itemstack = playerIn.getHeldItem(handIn);
	      playerIn.getCooldownTracker().setCooldown(this, 200);
	      itemstack.shrink(1);
	    
	      if(worldIn.isRemote)
		  {
	          playerIn.sendMessage(new TranslationTextComponent("§cYou feel an evil presence watching you..."));
		  }	
	    
		  worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.EYE_OF_CTHULHU_SCREAM.get(), SoundCategory.HOSTILE, 1.0F, 1.0F);
		
		  int randomX = random.nextInt(16);
		  int randomZ = random.nextInt(16);
		
		  boolean isXNegative = random.nextBoolean();
		  boolean isZNegative = random.nextBoolean();
		
		  if(isXNegative)
		    {
			    randomX = randomX * -1;
		    }
		
		  if(isZNegative)
		    {
			  randomZ = randomZ * -1;
		    }
		
		EyeOfCthulhu EoC = new EyeOfCthulhu(HardmodeEntityTypes.EYE_OF_CTHULHU.get(), worldIn);
		EoC.setPositionAndUpdate(playerIn.getPosX() + randomX, playerIn.getPosY() + 20, playerIn.getPosZ() + randomZ);
		worldIn.addEntity(EoC);
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

 }
	
	


