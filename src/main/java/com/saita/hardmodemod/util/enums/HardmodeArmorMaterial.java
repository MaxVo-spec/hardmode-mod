package com.saita.hardmodemod.util.enums;

import java.util.function.Supplier;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum HardmodeArmorMaterial implements IArmorMaterial
{
	PALLADIUM(HardmodeMod.MOD_ID + ":palladium", 62, new int[] {3, 6, 8, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F, () -> { // 33 x 1.9
		return Ingredient.fromItems(ItemInit.PALLADIUM_INGOT.get());	 
	}),
	
	ORICHALCUM(HardmodeMod.MOD_ID + ":orichalcum", 80, new int[] {3, 7, 8, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 7.0F, () -> { // 33 x 2.45
		return Ingredient.fromItems(ItemInit.ORICHALCUM_INGOT.get());	 
	}),
	
	ADAMANTITE(HardmodeMod.MOD_ID + ":adamantite", 105, new int[] {4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 9.0F, () -> { //33 x 3.2
		return Ingredient.fromItems(ItemInit.ADAMANTITE_INGOT.get());	 
	}),
	
	MOLTEN(HardmodeMod.MOD_ID + ":molten", 77, new int[] {3, 7, 8, 4}, 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 7.5F, () -> { // 33 x 2.35
		return Ingredient.fromItems(ItemInit.MOLTEN_BAR.get());	 
	}),
	
	DRAGON(HardmodeMod.MOD_ID + ":dragon", 49, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 4.0F, () -> { // 33 x 1.5
		return Ingredient.fromItems(ItemInit.ENDER_DRAGON_ESSENCE.get());	 
	}),
	
	SHADOW_CAPE(HardmodeMod.MOD_ID + ":shadow_cape", 18, new int[] {1, 3, 4, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, () -> {
		return Ingredient.fromItems(ItemInit.SHADOW_ESSENCE.get());	 
	}),
	
	CHLOROPHYTE(HardmodeMod.MOD_ID + ":chlorophyte", 139, new int[] {4, 7, 9, 4}, 19, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 11.0F, () -> { //33 x 3.2
		return Ingredient.fromItems(ItemInit.CHLOROPHYTE_BAR.get());	 
	}),
	
	BLOODY_VERTEBRA(HardmodeMod.MOD_ID + ":bloody_vertebra", 59, new int[] {3, 7, 8, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 7.0F, () -> { //33 x 1.8
		return Ingredient.fromItems(ItemInit.BLOODY_VERTEBRA.get());	 
	}),
	
	EMERALD(HardmodeMod.MOD_ID + ":emerald", 39, new int[] {3, 6, 8, 3}, 13, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, () -> { //33 x 1.2
		return Ingredient.fromItems(Items.EMERALD);	 
	});
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;
	
	private HardmodeArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
			int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn)
	{
		this.name = nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionAmountArray = damageReductionAmountIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = soundEventIn;
		this.toughness = toughnessIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
		
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
	
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() {
		
		return this.repairMaterial.getValue();
	}
    
	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		
		return this.name;
	}

	@Override
	public float getToughness() {
	
		return this.toughness;
	}

}