package com.saita.hardmodemod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.saita.hardmodemod.blocks.AdamantiteBlock;
import com.saita.hardmodemod.blocks.AdamantiteOre;
import com.saita.hardmodemod.blocks.Chlorocrops;
import com.saita.hardmodemod.blocks.ChlorophyteBlock;
import com.saita.hardmodemod.blocks.ChlorophyteOre;
import com.saita.hardmodemod.blocks.CrystalCrops;
import com.saita.hardmodemod.blocks.HardmodeBlock;
import com.saita.hardmodemod.blocks.Hellstone;
import com.saita.hardmodemod.blocks.MoltenBlock;
import com.saita.hardmodemod.blocks.OrichalcumBlock;
import com.saita.hardmodemod.blocks.OrichalcumOre;
import com.saita.hardmodemod.blocks.PalladiumBlock;
import com.saita.hardmodemod.blocks.PalladiumOre;
import com.saita.hardmodemod.blocks.ShadowCoreBlock;
import com.saita.hardmodemod.blocks.StarChunk;
import com.saita.hardmodemod.init.*;
import com.saita.hardmodemod.items.HardmodeSpawnEgg;
import com.saita.hardmodemod.world.gen.OreGen;

import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;


@Mod("hardmode")
@Mod.EventBusSubscriber(modid = HardmodeMod.MOD_ID, bus = Bus.MOD)
public class HardmodeMod
{

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "hardmode";
    public static HardmodeMod instance;
  


    public HardmodeMod() {
    	
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
        modEventBus.addListener(this::setup);    
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        SoundInit.SOUNDS.register(modEventBus);
        HardmodeEntityTypes.ENTITY_TYPES.register(modEventBus);
        instance = this;  
        MinecraftForge.EVENT_BUS.register(this);

    }   
    
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	BlockInit.BLOCKS.getEntries().stream().filter(block -> !(block.get() instanceof ShadowCoreBlock))
    	                                      .filter(block -> !(block.get() instanceof CrystalCrops))
    	                                      .filter(block -> !(block.get() instanceof PalladiumOre))
    	                                      .filter(block -> !(block.get() instanceof OrichalcumOre))
    	                                      .filter(block -> !(block.get() instanceof AdamantiteOre))
    	                                      .filter(block -> !(block.get() instanceof PalladiumBlock))
    	                                      .filter(block -> !(block.get() instanceof OrichalcumBlock))
    	                                      .filter(block -> !(block.get() instanceof AdamantiteBlock))
    	                                      .filter(block -> !(block.get() instanceof StarChunk))
    	                                      .filter(block -> !(block.get() instanceof Hellstone))
    	                                      .filter(block -> !(block.get() instanceof MoltenBlock))
    	                                      .filter(block -> !(block.get() instanceof HardmodeBlock))
    	                                      .filter(block -> !(block.get() instanceof ChlorophyteOre))
    	                                      .filter(block -> !(block.get() instanceof ChlorophyteBlock))
    	                                      .filter(block -> !(block.get() instanceof Chlorocrops)).map(RegistryObject::get).forEach(block -> {
    	
    		final Item.Properties properties = new Item.Properties().group(HardmodeItemGroup.instance);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    } 

	private void setup(final FMLCommonSetupEvent event) {
		
    	LOGGER.info("Hello from Hardmode Mod 1.5!");
    	StructureInit.addToBiomes();
      
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
  
    }
    
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event)
    {
    	OreGen.generateOre();
    }
    
    
    
    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
    	
		HardmodeSpawnEgg.initSpawnEggs();
	}
    
    public static class HardmodeItemGroup extends ItemGroup
    {
    	public static final HardmodeItemGroup instance = new HardmodeItemGroup(ItemGroup.GROUPS.length, "HardmodeTab");
    	private HardmodeItemGroup(int index, String label)
    	{
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon()
    	{
    		return new ItemStack(ItemInit.SHADOW_CORE_ITEM.get());
    	}
    }

}
