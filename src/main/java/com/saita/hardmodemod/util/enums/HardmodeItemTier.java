package com.saita.hardmodemod.util.enums;

import java.util.function.Supplier;

import com.saita.hardmodemod.init.ItemInit;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum HardmodeItemTier implements IItemTier
{
     DRAGON(4, 2185, 11.5F, 7.0F, 10, () -> //1561 x 1.4
     {
     return Ingredient.fromItems(ItemInit.ENDER_DRAGON_ESSENCE.get());	 
     }),
     
     PALLADIUM(5, 2497, 12.5F, 8.0F, 20, () ->  //1561 x 1.6
     {
	 return Ingredient.fromItems(ItemInit.PALLADIUM_INGOT.get());	 
	 }),
     
     ORICHALCUM(6, 2965, 14.0F, 11.0F, 15, () -> //1561 x 1.9
     {
	 return Ingredient.fromItems(ItemInit.ORICHALCUM_INGOT.get());	 
	 }),
     
	 ADAMANTITE(7, 3824, 16.0F, 15.0F, 11, () -> //1561 x 2.45
     {
	 return Ingredient.fromItems(ItemInit.ADAMANTITE_INGOT.get());	 
	 }),
	 
	 LIGHTSABER(4, 2263, 13.0F, 7.5F, 20, () -> //1561 x 1.45
     {
	 return Ingredient.fromItems(ItemInit.STAR_FRAGMENT.get());	 
	 }),
	 
	 STAR_PICK(4, 2420, 13.0F, 7.0F, 10, () -> //1561 x 1.55
     {
	 return Ingredient.fromItems(ItemInit.STAR_FRAGMENT.get());	 
	 }),
	 
	 MOLTEN(6, 2810, 14.5F, 11.0F, 18, () -> //1561 x 1.8
     { 
	 return Ingredient.fromItems(ItemInit.MOLTEN_BAR.get());	 
	 }),
	 
	 RGB_LIGHTSABER(5, 3044, 14.5F, 13.0F, 20, () -> //1561 x 1.95
     {
	 return Ingredient.fromItems(ItemInit.STAR_FRAGMENT.get());	 
	 }),
	 
	 DEATH_SCYTHE(4, 2654, 13.0F, 11.0F, 10, () -> //1561 x 1.7
     {
	 return Ingredient.fromItems(ItemInit.SHADOW_ESSENCE.get());		 
	 }),
	 
	 PSYCHO_KNIFE(4, 2576, 13.0F, 9.5F, 14, () -> //1561 x 1.65
     {
	 return Ingredient.fromItems(ItemInit.SHADOW_ESSENCE.get());	 
	 }),
	 
	 KATANA(4, 1030, 9.0F, 6.0F, 14, () -> //1561 x 0.66
     {
     return Ingredient.fromItems(Items.IRON_INGOT);		 
	 }),
	 
	 DRAGON_BLADE(5, 3122, 14.0F, 12.0F, 15, () -> //1561 x 2
     {
     return Ingredient.fromItems(ItemInit.ENDER_DRAGON_ESSENCE.get());		 
	 }),
	 
	 NANO_BLADE(5, 3512, 15.0F, 14.5F, 15, () -> //1561 x 2.25
     {
     return Ingredient.fromItems(ItemInit.NANO_BOOST.get());		 
	 }),
	 
	 CHLOROPHYTE(8, 5385, 20.0F, 19.0F, 19, () -> //1561 x 3.45
     {
     return Ingredient.fromItems(ItemInit.CHLOROPHYTE_BAR.get());		 
	 }),
	 
	 CRIMSON(8, 4215, 17.5F, 17.0F, 14, () -> //1561 x 2.7
     {
     return Ingredient.fromItems(ItemInit.ADAMANTITE_INGOT.get());		 
	 }),
	 
	 INFERNAL_HAMMER(6, 3122, 15.0F, 17.0F, 18, () -> //1561 x 2
     { 
	 return Ingredient.fromItems(ItemInit.MOLTEN_BAR.get());	 
	 }),
	
	 EMERALD(3, 1717, 9.0F, 5.0F, 13, () -> //1561 x 1.1
     {
     return Ingredient.fromItems(Items.EMERALD);	 
     });
	
	 
	
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;
	
	private HardmodeItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial)
	{
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = new LazyValue<>(repairMaterial);
	}

	@Override
	public int getMaxUses() {
		
		return this.maxUses;
	}

	@Override
	public float getEfficiency() {
		
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() {
		
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() {
	
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		
		return this.repairMaterial.getValue();
	}
}
