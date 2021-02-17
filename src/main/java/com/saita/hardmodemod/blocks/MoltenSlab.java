package com.saita.hardmodemod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;

public class MoltenSlab extends SlabBlock{

	public MoltenSlab(Properties properties) {
		super(properties);
		
	}
	
	@Override
	public int getLightValue(BlockState state) {
		
		return 15;
	}

}
