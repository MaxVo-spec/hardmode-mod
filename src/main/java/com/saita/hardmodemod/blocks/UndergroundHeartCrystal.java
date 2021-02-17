package com.saita.hardmodemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class UndergroundHeartCrystal extends Block {

	public UndergroundHeartCrystal(Properties properties) {
		super(properties);

	}
	
	@Override
	public int getLightValue(BlockState state) {
		
		return 5;
	}
	
	@Override
	public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		
		return MathHelper.nextInt(RANDOM, 7, 11);
	}

	
}
