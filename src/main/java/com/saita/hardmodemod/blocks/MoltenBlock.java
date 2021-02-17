package com.saita.hardmodemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class MoltenBlock extends Block {

	public MoltenBlock(Properties properties) {
		super(properties);
		
	}
	
	@Override
	public int getLightValue(BlockState state) {
		
		return 15;
	}
	
	@Override
	public boolean isBeaconBase(BlockState state, IWorldReader world, BlockPos pos, BlockPos beacon) {
		
		return true;
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (!entityIn.isImmuneToFire() && entityIn instanceof LivingEntity
			&& !EnchantmentHelper.hasFrostWalker((LivingEntity)entityIn) && !entityIn.isInWater()) {
			
	         entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 4.0F);
	         entityIn.setFire(5);
	      }
		
		super.onEntityWalk(worldIn, pos, entityIn);
	}

}
