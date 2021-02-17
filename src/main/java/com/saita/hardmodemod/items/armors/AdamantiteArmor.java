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

public class AdamantiteArmor extends ArmorItem {

	public AdamantiteArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
		
	}
	
	@Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§4Full set bonus : §7Gives you an Absorption Shield every 20 seconds, heals you overtime and infinite Strength I and Haste I."));	
	tooltip.set(0, new StringTextComponent("§4"+tooltip.get(0).getString()+"§r"));
	super.addInformation(stack, world, tooltip, flagIn);
	
    }
	
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 	      	    
	     if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.ADAMANTITE_HELMET.get() && 
	        player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.ADAMANTITE_CHESTPLATE.get() && 
	    	player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.ADAMANTITE_LEGGINGS.get() && 
	    	player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.ADAMANTITE_BOOTS.get())
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
	               player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 180, 0, false, false));
	           }
	        }

	         if(player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.ADAMANTITE_CHESTPLATE.get() && 
	        	 player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.ADAMANTITE_BOOTS.get() && 
	        	 player.getActivePotionEffect(Effects.STRENGTH) == null)
	         {
	            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 0, false, false));
	         }

	         if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.ADAMANTITE_HELMET.get() && 
	        	 player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.ADAMANTITE_LEGGINGS.get() && 
	        	 player.getActivePotionEffect(Effects.HASTE) == null)
	         {
	            player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 0, false, false));
	         }
	      
	      super.onArmorTick(stack, world, player);
	   }
	}