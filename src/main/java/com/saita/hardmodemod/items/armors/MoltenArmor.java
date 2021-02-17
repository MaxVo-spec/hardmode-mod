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

public class MoltenArmor extends ArmorItem {	

	public MoltenArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§cFull set bonus : §7Gives you an Absorption Shield every 20 seconds and infinite Strength I and Fire Resistance."));			
	tooltip.set(0, new StringTextComponent("§c"+tooltip.get(0).getString()+"§r"));	
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
			 
	    	 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.MOLTEN_HELMET.get() && 
	    	    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.MOLTEN_CHESTPLATE.get() && 
	    		player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.MOLTEN_LEGGINGS.get() && 
	    		player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.MOLTEN_BOOTS.get())
	    		 
		       {
	    		 if(player.getActivePotionEffect(Effects.FIRE_RESISTANCE) == null)
				  {
				   player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 5, 0, false, false));
				  }
	    		 if(world.getDayTime() % 400 == 0 && player.getActivePotionEffect(Effects.ABSORPTION) == null )
				  {  
				   player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 180, 0, false, false));	  
				  }   	          
		       }  	
	    	 
		       if(player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.MOLTEN_CHESTPLATE.get() && 
		    	  player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.MOLTEN_BOOTS.get() && 
		    	  player.getActivePotionEffect(Effects.STRENGTH) == null)
		    	   
			    { 
				   player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 0, false, false));			 
				}
			    
	  super.onArmorTick(stack, world, player);
	  
 }

}
