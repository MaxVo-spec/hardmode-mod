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

public class DragonArmor extends ArmorItem {

	public DragonArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
		
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§5Full set bonus : §7Gives you an Absorption Shield and Strength I every 20 seconds for 9 seconds."));	
	tooltip.set(0, new StringTextComponent("§5"+tooltip.get(0).getString()+"§r"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  


	@Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 	  	 
	      if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.DRAGON_HELMET.get() && 
	    	 player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.DRAGON_CHESTPLATE.get() &&
	    	 player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.DRAGON_LEGGINGS.get() && 
	    	 player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.DRAGON_BOOTS.get() && 
             world.getDayTime() % 400 == 0)
			   {
				  if(player.getActivePotionEffect(Effects.ABSORPTION) == null)
				    {
					   player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 180, 0, false, false));
					}
					      
			      if(player.getActivePotionEffect(Effects.STRENGTH) == null)
					{
						    player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 180, 0, false, false));
					}					      
			   
		   }
			     	    
		super.onArmorTick(stack, world, player);
	  
    }

}
