package com.saita.hardmodemod.blockitems;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class HardmodeBlock extends BlockItem {

	public HardmodeBlock(Block blockIn, Properties builder) {
		super(blockIn, builder);
		
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
    tooltip.add(new StringTextComponent("§7Can be used as a Beacon base."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }

}
