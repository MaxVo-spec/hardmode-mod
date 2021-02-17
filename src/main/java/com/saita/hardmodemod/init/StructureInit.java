package com.saita.hardmodemod.init;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.world.gen.HardmodeUndergroundTreasurePieces;
import com.saita.hardmodemod.world.gen.HardmodeUndergroundTreasureStructure;
import com.saita.hardmodemod.world.gen.ShadowCoreHolderPieces;
import com.saita.hardmodemod.world.gen.ShadowCoreHolderStructure;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class StructureInit {
	
    public static Structure<NoFeatureConfig> SHADOW_CORE_HOLDER = new ShadowCoreHolderStructure(NoFeatureConfig::deserialize);
    public static IStructurePieceType SHADOW_CORE_HOLDER_PIECE = ShadowCoreHolderPieces.Piece::new;
    public static Structure<NoFeatureConfig> HARDMODE_UNDERGROUND_TREASURE = new HardmodeUndergroundTreasureStructure(NoFeatureConfig::deserialize);
    public static IStructurePieceType HARDMODE_UNDERGROUND_TREASURE_PIECE = HardmodeUndergroundTreasurePieces.Piece::new;

    @SubscribeEvent
    public static void onRegisterFeatures(final RegistryEvent.Register<Feature<?>> event)
    {
        
        IForgeRegistry<Feature<?>> registry = event.getRegistry();

        SHADOW_CORE_HOLDER.setRegistryName(new ResourceLocation(HardmodeMod.MOD_ID, "shadow_core_holder"));
        registry.register(SHADOW_CORE_HOLDER);
        Registry.register(Registry.STRUCTURE_PIECE, "shadow_core_holder", SHADOW_CORE_HOLDER_PIECE);
        
        HARDMODE_UNDERGROUND_TREASURE.setRegistryName(new ResourceLocation(HardmodeMod.MOD_ID, "hardmode_underground_treasure"));
        registry.register(HARDMODE_UNDERGROUND_TREASURE);
        Registry.register(Registry.STRUCTURE_PIECE, "hardmode_underground_treasure", HARDMODE_UNDERGROUND_TREASURE_PIECE);

    }

    
    public static void addToBiomes(){
        
        for (Biome biome : ForgeRegistries.BIOMES)
        {
			if(biome.getCategory() == Biome.Category.THEEND && biome != Biomes.THE_END)
			{
           
              biome.addStructure(SHADOW_CORE_HOLDER.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
              biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, SHADOW_CORE_HOLDER.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                    .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			}
			
			if(biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NETHER)
			{
				biome.addStructure(HARDMODE_UNDERGROUND_TREASURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, HARDMODE_UNDERGROUND_TREASURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
	                 .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			}
        }
    }
}
