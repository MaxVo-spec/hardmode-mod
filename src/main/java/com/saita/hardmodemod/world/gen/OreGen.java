package com.saita.hardmodemod.world.gen;

import com.saita.hardmodemod.init.BlockInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
	
	public static void generateOre()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{                                                                                         // (Rarity, OffsetBottom, OffsetTop, MaxHeight)
			ConfiguredPlacement<CountRangeConfig> palladiumSpawn = Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 1, 1, 29));
			ConfiguredPlacement<CountRangeConfig> orichalcumSpawn = Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 1, 1, 23));
			ConfiguredPlacement<CountRangeConfig> adamantiteSpawn = Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 1, 1, 16));
			ConfiguredPlacement<CountRangeConfig> starChunkSpawn = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 1, 1, 29));
			ConfiguredPlacement<CountRangeConfig> heartSpawn = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 1, 1, 24));
			
			ConfiguredPlacement<CountRangeConfig> ironBlockSpawn = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 1, 1, 64));
			ConfiguredPlacement<CountRangeConfig> goldBlockSpawn = Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 1, 1, 32));
			ConfiguredPlacement<CountRangeConfig> diamondEmeraldBlockSpawn = Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 1, 1, 16));
			
			ConfiguredPlacement<CountRangeConfig> chlorophyteSpawn = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 1, 1, 32));
			
			ConfiguredPlacement<CountRangeConfig> hellstoneSpawn = Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 1, 1, 50));
			                                                                                          
			if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND)
				
			 {	
				
			  biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration                   // Max Ore per vein
			  (new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.PETRIFIED_PALLADIUM_ORE.get().getDefaultState(), 6)).withPlacement(palladiumSpawn));
			
			  biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration                   
			  (new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.PETRIFIED_ORICHALCUM_ORE.get().getDefaultState(), 6)).withPlacement(orichalcumSpawn));
			
			  biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration                   
			  (new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.PETRIFIED_ADAMANTITE_ORE.get().getDefaultState(), 5)).withPlacement(adamantiteSpawn));

			  biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration                   
			  (new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.PETRIFIED_STAR_CHUNK.get().getDefaultState(), 3)).withPlacement(starChunkSpawn));
			  
			  biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration                   
			  (new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.PETRIFIED_UNDERGROUND_HEART_CRYSTAL.get().getDefaultState(), 3)).withPlacement(heartSpawn));
			  
			  biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration                   
			  (new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.PETRIFIED_IRON_BLOCK.get().getDefaultState(), 4)).withPlacement(ironBlockSpawn));
			  
			  biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration                   
			  (new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.PETRIFIED_GOLD_BLOCK.get().getDefaultState(), 4)).withPlacement(goldBlockSpawn));
			  
			  biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration                   
			  (new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.PETRIFIED_DIAMOND_BLOCK.get().getDefaultState(), 3)).withPlacement(diamondEmeraldBlockSpawn));
			  
			  biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration                   
			  (new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.PETRIFIED_EMERALD_BLOCK.get().getDefaultState(), 3)).withPlacement(diamondEmeraldBlockSpawn));
			  			  
			 }
			
			 if(biome.getCategory() == Biome.Category.JUNGLE)
			 {
				 biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration              
				 (new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.PETRIFIED_CHLOROPHYTE_ORE.get().getDefaultState(), 16)).withPlacement(chlorophyteSpawn));
			 }
			
			if(biome.getCategory() == Biome.Category.NETHER)
				
			  {
			
			  biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration                   
			  (new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockInit.PETRIFIED_HELLSTONE.get().getDefaultState(), 10)).withPlacement(hellstoneSpawn));
			
			  }
						
		}
		
	}

}
