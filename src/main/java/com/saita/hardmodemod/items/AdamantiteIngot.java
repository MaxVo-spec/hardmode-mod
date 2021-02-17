package com.saita.hardmodemod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class AdamantiteIngot extends Item{

	public AdamantiteIngot(Properties properties) {
		super(properties);

	}
	
	@Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.RARE;
    }
	
	@Override
	public boolean isBeaconPayment(ItemStack stack) {
		
		return true;
	}

}
