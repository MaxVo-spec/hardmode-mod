package com.saita.hardmodemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class MoltenBricks extends Block{

	public MoltenBricks(Properties properties) {
		super(properties);
	
	}
	
	@Override
	public int getLightValue(BlockState state) {
		
		return 15;
	}

}
