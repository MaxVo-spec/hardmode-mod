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

public class PalladiumArmor extends ArmorItem {

	public PalladiumArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
		
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§6Full set bonus : §7Randomly heals you overtime and gives you an Absorption Shield every 20 seconds."));
	tooltip.set(0, new StringTextComponent("§6"+tooltip.get(0).getString()+"§r"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 	    	 
		  if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.PALLADIUM_HELMET.get() && 
		     player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.PALLADIUM_CHESTPLATE.get() && 
		     player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.PALLADIUM_LEGGINGS.get() && 
		     player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.PALLADIUM_BOOTS.get())
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
		      
		super.onArmorTick(stack, world, player);  
   }

}
