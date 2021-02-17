package com.saita.hardmodemod.blockitems;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class ShadowCoreBlock extends BlockItem {

	public ShadowCoreBlock(Block blockIn, Properties builder) {
		super(blockIn, builder);
	
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

		return Rarity.EPIC;
	}

}
