package com.saita.hardmodemod.items;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.saita.hardmodemod.init.ItemInit;
import com.saita.hardmodemod.init.SoundInit;
import com.saita.hardmodemod.util.HardmodeGameTimeConstant;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
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


public class ShadowCoreItem extends Item {
	
	private static final Logger LOGGER = LogManager.getLogger();

	public ShadowCoreItem(Properties properties) {
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
    	
    tooltip.add(new StringTextComponent("§7It's pulsing with a strange energy. You feel sick holding it. §4Right Click to activate Hardmode."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
    
    @Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.EPIC;
    }
    
    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    	
    	if(entityIn instanceof PlayerEntity)
    	{
    	   PlayerEntity playerIn = (PlayerEntity)entityIn;
    	   
    	   if(playerIn.isCreative() == false)
    	   {
    	
    		  if(((playerIn.getHeldItemMainhand().getItem() == ItemInit.SHADOW_CORE_ITEM.get())) || 
    			(playerIn.getHeldItemOffhand().getItem() == ItemInit.SHADOW_CORE_ITEM.get()))
    			
    		    { 			 
    	          playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA, 100, 0, true, true)); 			  
    		    }
    	    }
    		 
     	 }
    	
    	   super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
      }
     
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	
    	ItemStack itemstack = playerIn.getHeldItem(handIn);
    	ItemStack shadowEssenceStack = new ItemStack(ItemInit.SHADOW_ESSENCE.get(), 16);
    	
    	if(playerIn.dimension == DimensionType.OVERWORLD)
    	{
    	
    	   itemstack.shrink(1);
    	   playerIn.dropItem(shadowEssenceStack, false).setNoPickupDelay();
    	   playerIn.giveExperiencePoints(500);
    	
    	   if(worldIn.getGameTime() < HardmodeGameTimeConstant.HardmodeGameTime)
    	       {	
    		
    		   worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.EYE_OF_CTHULHU_SCREAM.get(), SoundCategory.HOSTILE, 1.0F, 1.0F);
    		   worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.SCREAM.get(), SoundCategory.MASTER, 1.0F, 1.0F);
    		   
    		   if(worldIn.isRemote)
    		   {
    	         playerIn.sendMessage(new TranslationTextComponent("§4You use a Shadow Core. HARDMODE HAS BEEN ACTIVATED!"));
    	         LOGGER.info("IMPORTANT: Hardmode has been activated in this world by "+playerIn.getName().getString()+"");
    		   }
    		   
    	       long currentGameTime = worldIn.getGameTime();
    	       worldIn.setGameTime(currentGameTime + HardmodeGameTimeConstant.HardmodeGameTime);
	       
    	       ItemStack hardmodeMedallionStack = new ItemStack(ItemInit.HARDMODE_MEDALLION.get());
    	       playerIn.dropItem(hardmodeMedallionStack, false).setNoPickupDelay();
    	
    	       }
    	       else	
    	       { 
    	    	  if(worldIn.isRemote)
        		  {
    	             playerIn.sendMessage(new TranslationTextComponent("§cYou use a Shadow Core. But Hardmode has already been activated in that world. It has no effects."));
        		  }
    	
    	   }
    	}
    	else
    	{
    	   if(worldIn.isRemote)
  		   {
 	       playerIn.sendMessage(new TranslationTextComponent("§f"+playerIn.getName().getString()+", you need to be in the Overworld to use the Shadow Core."));
  		   }
    	}
    	
    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }
      
}

