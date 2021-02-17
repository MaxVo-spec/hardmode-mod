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

public class ShadowCape extends ArmorItem{

	public ShadowCape(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
		
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§7Makes the wearer invisible."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	@Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
				  	 
	    	 if(player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.SHADOW_CAPE.get())
		     {
				 player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 5, 0, false, false));
		     }  	
	    	     	 
	  super.onArmorTick(stack, world, player);
    }

}
