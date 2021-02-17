package com.saita.hardmodemod.items;

import java.util.List;

import com.saita.hardmodemod.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class EyeOfCthulhuTreasureBag extends Item {

	public EyeOfCthulhuTreasureBag(Properties properties) {
		super(properties);
	
	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7Right click to open it."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
    
    @Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.EPIC;
    }
    

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	
    	ItemStack itemstack = playerIn.getHeldItem(handIn);
    	itemstack.shrink(1);
    	
    	int palladiumNum = random.nextInt(13) + 8 ;
    	int orichalcumNum = random.nextInt(10) + 6 ;
    	int adamantiteNum = random.nextInt(6) + 5 ;
    	int essenceNum = random.nextInt(17) + 16 ;
    	
  
    	ItemStack palladiumStack = new ItemStack(ItemInit.PALLADIUM_ORE.get(), palladiumNum);
    	ItemStack orichalcumStack = new ItemStack(ItemInit.ORICHALCUM_ORE.get(), orichalcumNum);
    	ItemStack adamantiteStack = new ItemStack(ItemInit.ADAMANTITE_ORE.get(), adamantiteNum);
    	ItemStack essenceStack = new ItemStack(ItemInit.CRIMSON_ESSENCE.get(), essenceNum);
    	
    	ItemStack crystalSeedsStack = new ItemStack(ItemInit.CRYSTAL_SEEDS.get(), 1);
    	ItemStack shatteredMagicMirrorStack = new ItemStack(ItemInit.SHATTERED_MAGIC_MIRROR.get(), 1);
    	
 	    playerIn.dropItem(palladiumStack, false).setNoPickupDelay();
	    playerIn.dropItem(orichalcumStack, false).setNoPickupDelay();
	    playerIn.dropItem(adamantiteStack, false).setNoPickupDelay();
	    playerIn.dropItem(crystalSeedsStack, false).setNoPickupDelay();
	    playerIn.dropItem(essenceStack, false).setNoPickupDelay();
	    
	    boolean mirrorDrop = random.nextBoolean();
	    if(mirrorDrop)
	    {
	    	playerIn.dropItem(shatteredMagicMirrorStack, false).setNoPickupDelay();
	    }
	      	
    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
