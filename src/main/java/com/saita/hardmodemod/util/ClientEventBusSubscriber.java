package com.saita.hardmodemod.util;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.client.render.*;
import com.saita.hardmodemod.init.BlockInit;
import com.saita.hardmodemod.init.HardmodeEntityTypes;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HardmodeMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
	
		RenderingRegistry.registerEntityRenderingHandler(HardmodeEntityTypes.SUPER_ZOMBIE.get(), SuperZombieRender::new);
		RenderingRegistry.registerEntityRenderingHandler(HardmodeEntityTypes.WEREWOLF.get(), WerewolfRender::new);
		RenderingRegistry.registerEntityRenderingHandler(HardmodeEntityTypes.PSYCHO.get(), PsychoRender::new);
		RenderingRegistry.registerEntityRenderingHandler(HardmodeEntityTypes.REAPER.get(), ReaperRender::new);
		RenderingRegistry.registerEntityRenderingHandler(HardmodeEntityTypes.PLAYER_ASSASSIN.get(), PlayerAssassinRender::new);
		RenderingRegistry.registerEntityRenderingHandler(HardmodeEntityTypes.TITAN.get(), TitanRender::new);
		RenderingRegistry.registerEntityRenderingHandler(HardmodeEntityTypes.FIRE_DEMON.get(), FireDemonRender::new);
		RenderingRegistry.registerEntityRenderingHandler(HardmodeEntityTypes.SUPER_SPIDER.get(), SuperSpiderRender::new);
		RenderingRegistry.registerEntityRenderingHandler(HardmodeEntityTypes.DEMON_EYE.get(), DemonEyeRender::new);
		RenderingRegistry.registerEntityRenderingHandler(HardmodeEntityTypes.EYE_OF_CTHULHU.get(), EyeOfCthulhuRender::new);
		RenderingRegistry.registerEntityRenderingHandler(HardmodeEntityTypes.FACE_MONSTER.get(), FaceMonsterRender::new);

		
		RenderTypeLookup.setRenderLayer(BlockInit.CRYSTAL_CROPS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CHLOROCROPS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.HARDMODE_FORCEFIELD.get(), RenderType.getTranslucent());
		
	}

		
}
