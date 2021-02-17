package com.saita.hardmodemod.world;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.init.HardmodeEntityTypes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = HardmodeMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class HardmodeMobsSpawns {
	
	@SubscribeEvent
	public static void spawnHardmodeEntities(FMLLoadCompleteEvent event)
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			if(biome != null && biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND &&
			   biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.MUSHROOM && biome != Biomes.THE_VOID)
				
			{
				biome.getSpawns(HardmodeEntityTypes.SUPER_ZOMBIE.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.SUPER_ZOMBIE.get(), 9, 1, 7));
				biome.getSpawns(HardmodeEntityTypes.WEREWOLF.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.WEREWOLF.get(), 9, 1, 6));
				biome.getSpawns(HardmodeEntityTypes.PSYCHO.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.PSYCHO.get(), 8, 1, 5));
				biome.getSpawns(HardmodeEntityTypes.REAPER.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.REAPER.get(), 8, 1, 5));
				biome.getSpawns(HardmodeEntityTypes.PLAYER_ASSASSIN.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.PLAYER_ASSASSIN.get(), 8, 1, 7));
				biome.getSpawns(HardmodeEntityTypes.SUPER_SPIDER.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.SUPER_SPIDER.get(), 8, 1, 6));
				biome.getSpawns(HardmodeEntityTypes.DEMON_EYE.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.DEMON_EYE.get(), 5, 1, 6));
				biome.getSpawns(HardmodeEntityTypes.FACE_MONSTER.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.FACE_MONSTER.get(), 9, 1, 6));
				biome.getSpawns(HardmodeEntityTypes.TITAN.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.TITAN.get(), 2, 1, 1));			
			}
			
			if(biome != null && biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND &&
			   biome.getCategory() != Biome.Category.MUSHROOM && biome != Biomes.THE_VOID)
			{
				biome.getSpawns(HardmodeEntityTypes.DEMON_EYE.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.DEMON_EYE.get(), 2, 1, 4));
			}
			
						
			if(biome != null && biome.getCategory() == Biome.Category.NETHER)
			{
				biome.getSpawns(HardmodeEntityTypes.FIRE_DEMON.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.FIRE_DEMON.get(), 3, 1, 6));
				
				biome.getSpawns(HardmodeEntityTypes.PSYCHO.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.PSYCHO.get(), 1, 1, 3));
				biome.getSpawns(HardmodeEntityTypes.REAPER.get().getClassification()).add(new SpawnListEntry(HardmodeEntityTypes.REAPER.get(), 1, 1, 3));
				
			}
		}
	}

}
