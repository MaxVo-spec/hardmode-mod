package com.saita.hardmodemod.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class HellstoneChunk extends Item{

	public HellstoneChunk(Properties properties) {
		super(properties);
		
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7Used to create §cMolten bars§7. It's also a great fuel!"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	@Override
	public int getBurnTime(ItemStack itemStack) {
		
		return 6400;
	}

}
