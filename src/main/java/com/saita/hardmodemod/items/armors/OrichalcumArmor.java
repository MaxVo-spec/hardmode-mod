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

public class OrichalcumArmor extends ArmorItem {

	public OrichalcumArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
	
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§dFull set bonus : §7Gives you an Absorption Shield every 20 seconds and infinite Speed II and Jump Boost I."));		
	tooltip.set(0, new StringTextComponent("§d"+tooltip.get(0).getString()+"§r"));	
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 		 		 
			 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.ORICHALCUM_HELMET.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.ORICHALCUM_CHESTPLATE.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.ORICHALCUM_LEGGINGS.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.ORICHALCUM_BOOTS.get())
			 {
				 if(world.getDayTime() % 400 == 0 && player.getActivePotionEffect(Effects.ABSORPTION) == null)
				 {
					 
				    player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 180, 0, false, false));
			
				 }
			      
			 }
		 	
			 if(player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.ORICHALCUM_CHESTPLATE.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.ORICHALCUM_BOOTS.get() && 
			    player.getActivePotionEffect(Effects.SPEED) == null)
			 {		 
				player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 1, false, false));
			 }

			 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.ORICHALCUM_HELMET.get() && 
				player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.ORICHALCUM_LEGGINGS.get() && 
			    player.getActivePotionEffect(Effects.JUMP_BOOST) == null)
			 { 
				 player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 0, false, false)); 
			 }
		 
		super.onArmorTick(stack, world, player);
	  
     }

}
