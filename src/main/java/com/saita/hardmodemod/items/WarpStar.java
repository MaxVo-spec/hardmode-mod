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
import net.minecraft.world.dimension.DimensionType;

public class WarpStar extends Item {

	public WarpStar(Properties properties) {
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
    	
    tooltip.add(new StringTextComponent("§7Will teleport you VERY VERY far away from world center and also very high. You'll probably need Elytra or something to slow down your fall. §f60 seconds cooldown."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
    
    @Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.EPIC;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	
    	if(playerIn.dimension == DimensionType.OVERWORLD)
    	{
    	
    	   ItemStack itemstack = playerIn.getHeldItem(handIn);
    	   playerIn.getCooldownTracker().setCooldown(this, 1200);
    	   itemstack.shrink(1);
           worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.WARP_STAR.get(), SoundCategory.MASTER, 1.0F, 1.0F);
           
           if(playerIn.isCreative() == false)
           {
              playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA, 300, 0));
           }
    	   
    	   int randomX = random.nextInt(4000000) + 800000;
    	   int randomZ = random.nextInt(4000000) + 800000;
    	   
    	   
    	   //To make it a negative number sometimes.
    	   boolean isNegativeX = random.nextBoolean();
    	   boolean isNegativeZ = random.nextBoolean();
    	   
    	   if(isNegativeX)
    	   {
    		   randomX = randomX * -1;
    	   }
    	   if(isNegativeZ)
    	   {
    		   randomZ = randomZ * -1;
    	   }
    	   
    	   playerIn.teleportKeepLoaded(randomX, 600D, randomZ);
    	   
    	}
    	else
    	{
    		 if(worldIn.isRemote)
    		 {
  	         playerIn.sendMessage(new TranslationTextComponent("§f"+playerIn.getName().getString()+", you need to be in the Overworld to use a Warp Star."));
    		 }
    	}

    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
