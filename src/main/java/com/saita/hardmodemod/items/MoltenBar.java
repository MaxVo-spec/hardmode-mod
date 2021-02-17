package com.saita.hardmodemod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class MoltenBar extends Item {

	public MoltenBar(Properties properties) {
		super(properties);
	
	}
	
	@Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.UNCOMMON;
    }
	
	@Override
	public boolean isBeaconPayment(ItemStack stack) {
		
		return true;
	}

}
