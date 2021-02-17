package com.saita.hardmodemod.items;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.saita.hardmodemod.util.HardmodeGameTimeConstant;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class CoreOfPeace extends Item {
	
	private static final Logger LOGGER = LogManager.getLogger();

	public CoreOfPeace(Properties properties) {
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
    	
    tooltip.add(new StringTextComponent("§fCreative Mode only! §bRight Click to deactivate Hardmode"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
    
    @Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.EPIC;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	
    	ItemStack itemstack = playerIn.getHeldItem(handIn);
    	
    	if(playerIn.dimension == DimensionType.OVERWORLD)
    	{
    	
    	   itemstack.shrink(1);
    	
    	   if(worldIn.getGameTime() >= HardmodeGameTimeConstant.HardmodeGameTime)
    	   {	
    		
    		   if(worldIn.isRemote)
    		   {
    	          playerIn.sendMessage(new TranslationTextComponent("§bYou use a Core of Peace. Hardmode has been deactivated."));
    	          LOGGER.info("IMPORTANT: Hardmode has been deactivated in this world by "+playerIn.getName().getString()+"");
    		   }
    	       long currentGameTime = worldIn.getGameTime();
    	       worldIn.setGameTime(currentGameTime - HardmodeGameTimeConstant.HardmodeGameTime);
    	       	          	
    	       }
    	       else	
    	       {
    		      if(worldIn.isRemote)
    		      {
    	            playerIn.sendMessage(new TranslationTextComponent("§bYou use a Core of Peace. But Hardmode is already off. It has no effects."));
    		      }
    	
    	     }
    	}
    	else
    	{
    	   if(worldIn.isRemote)
    	   {
  	       playerIn.sendMessage(new TranslationTextComponent("§f"+playerIn.getName().getString()+", you need to be in the Overworld to use the Core of Peace."));
    	   }
    	}
    	
    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
