package com.saita.hardmodemod.items.tools;

import java.util.List;

import com.saita.hardmodemod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class TrueDragonBlade extends SwordItem {

	public TrueDragonBlade(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.RARE;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§a"+tooltip.get(0).getString()+"§r"));
	tooltip.add(new StringTextComponent("§7Right click for a quick temporary speed boost."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 35, 4));
		itemstack.damageItem(2, playerIn, null);
		playerIn.playSound(SoundInit.DRAGON_BLADE_DASH.get(), 1.0F, 1.0F);
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
