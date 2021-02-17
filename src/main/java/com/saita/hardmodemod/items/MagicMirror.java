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

public class MagicMirror extends Item {

	public MagicMirror(Properties properties) {
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
    	
    tooltip.add(new StringTextComponent("§7Requires 3 levels of experience. Gaze in the mirror to teleport to this world's spawn point. §f10 seconds cooldown."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
    
    @Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.RARE;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	
    	if(playerIn.dimension == DimensionType.OVERWORLD)
    	 {
    		if(playerIn.experienceLevel >= 3 || playerIn.isCreative() == true)
    		{
        	
             if(playerIn.isCreative() == false)
             {
    		     playerIn.addExperienceLevel(-3);	
    		     playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 0));
             }
    	     
             playerIn.getCooldownTracker().setCooldown(this, 200);
             worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.MAGIC_MIRROR.get(), SoundCategory.MASTER, 1.0F, 1.0F);
    	   
             int spawnX = worldIn.getSpawnPoint().getX();
             int spawnY = worldIn.getSpawnPoint().getY();
             int spawnZ = worldIn.getSpawnPoint().getZ();
    	     playerIn.teleportKeepLoaded(spawnX, spawnY, spawnZ);
    	     
    		}
    		else
    		{
    			 if(worldIn.isRemote)
    			 {
    	  	        playerIn.sendMessage(new TranslationTextComponent("§fYou don't have enough levels to use a Magic Mirror!"));
    			 }
    		}
    	             
    	   	   
    	 }
    	else
    	 {
    		 if(worldIn.isRemote)
    		 {
  	           playerIn.sendMessage(new TranslationTextComponent("§f"+playerIn.getName().getString()+", you need to be in the Overworld to use a Magic Mirror"));
    		 }
    	 }

    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }
    
}
