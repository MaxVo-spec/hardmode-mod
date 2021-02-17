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

public class ChlorophyteArmor extends ArmorItem {

	public ChlorophyteArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
	
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
    tooltip.add(new StringTextComponent("§2Full set bonus : §7Gives you an Absorption II Shield every 20 seconds, heals you overtime and infinite Haste I, Strength I, Speed I and Jump Boost I. Makes you immune to poison."));
	tooltip.set(0, new StringTextComponent("§2"+tooltip.get(0).getString()+"§r"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
   	    
	     if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.CHLOROPHYTE_HELMET.get() && 
	        player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.CHLOROPHYTE_CHESTPLATE.get() && 
	    	player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.CHLOROPHYTE_LEGGINGS.get() && 
	    	player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.CHLOROPHYTE_BOOTS.get())
	        { 
	           if(world.getDayTime() % 80 == 0)
	             {
	            	
	              int randomHealChance = random.nextInt(3);
	               
	              if(randomHealChance == 0)
	              {
	                 player.heal(1);
	              }
	           }

	           if(world.getDayTime() % 400 == 0 && player.getActivePotionEffect(Effects.ABSORPTION) == null)
	           { 	
	               player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 180, 1, false, false));
	           }
	           
	           if(player.getActivePotionEffect(Effects.HASTE) != null)
	           {
	              player.removeActivePotionEffect(Effects.POISON);
	           }
	        }

	         if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.CHLOROPHYTE_HELMET.get() && 
	        	 player.getActivePotionEffect(Effects.HASTE) == null)
	         {
	            player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 0, false, false));
	         }

	         if(player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.CHLOROPHYTE_CHESTPLATE.get() && 
	        	 player.getActivePotionEffect(Effects.STRENGTH) == null)
	         {
	            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 0, false, false));
	         }
	         
	         if(player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.CHLOROPHYTE_LEGGINGS.get() && 
		        player.getActivePotionEffect(Effects.SPEED) == null)
		    {
		        player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 0, false, false));
		    }
	         
	         if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.CHLOROPHYTE_BOOTS.get() && 
		        player.getActivePotionEffect(Effects.JUMP_BOOST) == null)
		    {
		        player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 0, false, false));
		    }
	         
	      
	      super.onArmorTick(stack, world, player);
	   }

}
