package com.saita.hardmodemod.blocks;

import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class MoltenStairs extends StairsBlock{

	public MoltenStairs(Supplier<BlockState> state, Properties properties) {
		super(state, properties);
		
	}
	
	@Override
	public int getLightValue(BlockState state) {
		
		return 15;
	}

}
