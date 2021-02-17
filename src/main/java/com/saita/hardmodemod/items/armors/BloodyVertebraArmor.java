package com.saita.hardmodemod.items.armors;

import java.util.List;

import com.saita.hardmodemod.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class BloodyVertebraArmor extends ArmorItem {

	public BloodyVertebraArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
		
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§cFull set bonus : §7Gives you infinite Strength I. You get stronger as your health goes down. Below half HP, you start getting healed automatically."));
	tooltip.set(0, new StringTextComponent("§c"+tooltip.get(0).getString()+"§r"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 	    	 
		  if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.BLOODY_VERTEBRA_MASK.get() && 
		     player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.BLOODY_VERTEBRA_TORSO.get() && 
		     player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.BLOODY_VERTEBRA_LEGGINGS.get() && 
		     player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.BLOODY_VERTEBRA_BOOTS.get())
			{
			    if(player.getHealth() > player.getMaxHealth() / 2)
			    {
				   player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 0, false, false)); 
			    }
			    
			    if(player.getHealth() <= player.getMaxHealth() / 2)
			    {
				    player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 1, false, false)); 
			    }
			    
			    if(player.getHealth() <= player.getMaxHealth() / 4)
			    {			    	
				    player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 2, false, false));					
			    }
			    
			    if(player.getHealth() < player.getMaxHealth() / 8)
			    {			    	
				    player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 3, false, false));					
			    }
			   		    
		  
		        if(world.getDayTime() % 80 == 0)
		        {
			       if(player.getHealth() < player.getMaxHealth() / 2)
			       {
			         int randomHealChance = random.nextInt(2);
			    
			          if(randomHealChance == 0)
			          {
			           player.heal(1);
			          }
		           }
			       if(player.getHealth() <= player.getMaxHealth() / 5)
			         {
			         int randomHealChance = random.nextInt(1);
				    
				     if(randomHealChance == 0)
				      {
				        player.heal(1);				    
			          }
			      }
		       }
		   }
			  			      
		super.onArmorTick(stack, world, player);  
   }
}
