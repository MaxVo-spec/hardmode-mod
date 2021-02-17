package com.saita.hardmodemod.items.tools;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class PalladiumPickaxe extends PickaxeItem {

	public PalladiumPickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§6"+tooltip.get(0).getString()+"§r"));	
    tooltip.add(new StringTextComponent("§7Able to mine §dOrichalcum Ore §7and §cHellstone§7."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
    
}
