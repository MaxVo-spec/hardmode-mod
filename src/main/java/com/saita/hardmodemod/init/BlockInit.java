package com.saita.hardmodemod.init;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.blocks.*;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, HardmodeMod.MOD_ID);
	
	public static final RegistryObject<Block> SHADOW_CORE_BLOCK = BLOCKS.register("shadow_core_block", () -> new ShadowCoreBlock(Block.Properties.create(Material.IRON, MaterialColor.PURPLE).hardnessAndResistance(5.0F, 9.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> PALLADIUM_ORE = BLOCKS.register("palladium_ore", () -> new PalladiumOre(Block.Properties.create(Material.ROCK, MaterialColor.ADOBE).hardnessAndResistance(4.0F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(4).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ORICHALCUM_ORE = BLOCKS.register("orichalcum_ore", () -> new OrichalcumOre(Block.Properties.create(Material.ROCK, MaterialColor.PINK).hardnessAndResistance(5.5F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(5).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ADAMANTITE_ORE = BLOCKS.register("adamantite_ore", () -> new AdamantiteOre(Block.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(7.0F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(6).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PALLADIUM_BLOCK = BLOCKS.register("palladium_block", () -> new PalladiumBlock(Block.Properties.create(Material.IRON, MaterialColor.ADOBE).hardnessAndResistance(6.0F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(4).sound(SoundType.METAL)));
	public static final RegistryObject<Block> ORICHALCUM_BLOCK = BLOCKS.register("orichalcum_block", () -> new OrichalcumBlock(Block.Properties.create(Material.IRON, MaterialColor.PINK).hardnessAndResistance(7.5F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(5).sound(SoundType.METAL)));
	public static final RegistryObject<Block> ADAMANTITE_BLOCK = BLOCKS.register("adamantite_block", () -> new AdamantiteBlock(Block.Properties.create(Material.IRON, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(9.0F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(6).sound(SoundType.METAL)));
	public static final RegistryObject<Block> STAR_CHUNK = BLOCKS.register("star_chunk", () -> new StarChunk(Block.Properties.create(Material.ROCK, MaterialColor.YELLOW).hardnessAndResistance(4.0F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(4).sound(SoundType.STONE)));
	public static final RegistryObject<Block> HELLSTONE = BLOCKS.register("hellstone", () -> new Hellstone(Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(4.5F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(5).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MOLTEN_BLOCK = BLOCKS.register("molten_block", () -> new MoltenBlock(Block.Properties.create(Material.IRON, MaterialColor.RED).hardnessAndResistance(6.5F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(5).sound(SoundType.METAL)));
	public static final RegistryObject<Block> CRYSTAL_BLOCK = BLOCKS.register("crystal_block", () -> new CrystalBlock(Block.Properties.create(Material.IRON, MaterialColor.PURPLE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> CRYSTAL_CROPS = BLOCKS.register("crystal_crops", () -> new CrystalCrops(Block.Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> CRYSTAL_STAIRS = BLOCKS.register("crystal_stairs", () -> new StairsBlock(() -> BlockInit.CRYSTAL_BLOCK.get().getDefaultState(), Block.Properties.from(BlockInit.CRYSTAL_BLOCK.get())));
	public static final RegistryObject<Block> CRYSTAL_SLAB = BLOCKS.register("crystal_slab", () -> new SlabBlock(Block.Properties.from(BlockInit.CRYSTAL_BLOCK.get())));
	public static final RegistryObject<Block> PALLADIUM_BRICKS = BLOCKS.register("palladium_bricks", () -> new PalladiumBricks(Block.Properties.create(Material.IRON, MaterialColor.ADOBE).hardnessAndResistance(4.5F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(4).sound(SoundType.METAL)));
	public static final RegistryObject<Block> ORICHALCUM_BRICKS = BLOCKS.register("orichalcum_bricks", () -> new OrichalcumBricks(Block.Properties.create(Material.IRON, MaterialColor.PINK).hardnessAndResistance(6.0F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(5).sound(SoundType.METAL)));
	public static final RegistryObject<Block> ADAMANTITE_BRICKS = BLOCKS.register("adamantite_bricks", () -> new AdamantiteBricks(Block.Properties.create(Material.IRON, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(7.5F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(6).sound(SoundType.METAL)));
	public static final RegistryObject<Block> MOLTEN_BRICKS = BLOCKS.register("molten_bricks", () -> new MoltenBricks(Block.Properties.create(Material.IRON, MaterialColor.RED).hardnessAndResistance(5.0F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(5).sound(SoundType.METAL)));
	public static final RegistryObject<Block> PALLADIUM_STAIRS = BLOCKS.register("palladium_stairs", () -> new StairsBlock(() -> BlockInit.PALLADIUM_BRICKS.get().getDefaultState(), Block.Properties.from(BlockInit.PALLADIUM_BRICKS.get())));
	public static final RegistryObject<Block> PALLADIUM_SLAB = BLOCKS.register("palladium_slab", () -> new SlabBlock(Block.Properties.from(BlockInit.PALLADIUM_BRICKS.get())));
	public static final RegistryObject<Block> ORICHALCUM_STAIRS = BLOCKS.register("orichalcum_stairs", () -> new StairsBlock(() -> BlockInit.ORICHALCUM_BRICKS.get().getDefaultState(), Block.Properties.from(BlockInit.ORICHALCUM_BRICKS.get())));
	public static final RegistryObject<Block> ORICHALCUM_SLAB = BLOCKS.register("orichalcum_slab", () -> new SlabBlock(Block.Properties.from(BlockInit.ORICHALCUM_BRICKS.get())));
	public static final RegistryObject<Block> ADAMANTITE_STAIRS = BLOCKS.register("adamantite_stairs", () -> new StairsBlock(() -> BlockInit.ADAMANTITE_BRICKS.get().getDefaultState(), Block.Properties.from(BlockInit.ADAMANTITE_BRICKS.get())));
	public static final RegistryObject<Block> ADAMANTITE_SLAB = BLOCKS.register("adamantite_slab", () -> new SlabBlock(Block.Properties.from(BlockInit.ADAMANTITE_BRICKS.get())));
	public static final RegistryObject<Block> MOLTEN_STAIRS = BLOCKS.register("molten_stairs", () -> new MoltenStairs(() -> BlockInit.MOLTEN_BRICKS.get().getDefaultState(), Block.Properties.from(BlockInit.MOLTEN_BRICKS.get())));
	public static final RegistryObject<Block> MOLTEN_SLAB = BLOCKS.register("molten_slab", () -> new MoltenSlab(Block.Properties.from(BlockInit.MOLTEN_BRICKS.get())));
	public static final RegistryObject<Block> UNDERGROUND_HEART_CRYSTAL = BLOCKS.register("underground_heart_crystal", () -> new UndergroundHeartCrystal(Block.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(4.0F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(4).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> HARDMODE_BLOCK = BLOCKS.register("hardmode_block", () -> new HardmodeBlock(Block.Properties.create(Material.IRON, MaterialColor.PURPLE).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL)));
	public static final RegistryObject<Block> CHLOROPHYTE_ORE = BLOCKS.register("chlorophyte_ore", () -> new ChlorophyteOre(Block.Properties.create(Material.ROCK, MaterialColor.LIME).hardnessAndResistance(7.0F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(8).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHLOROPHYTE_BLOCK = BLOCKS.register("chlorophyte_block", () -> new ChlorophyteBlock(Block.Properties.create(Material.IRON, MaterialColor.LIME).hardnessAndResistance(9.0F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(8).sound(SoundType.METAL)));
	public static final RegistryObject<Block> CHLOROPHYTE_BRICKS = BLOCKS.register("chlorophyte_bricks", () -> new ChlorophyteBricks(Block.Properties.create(Material.IRON, MaterialColor.LIME).hardnessAndResistance(7.5F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(8).sound(SoundType.METAL)));
	public static final RegistryObject<Block> CHLOROPHYTE_STAIRS = BLOCKS.register("chlorophyte_stairs", () -> new StairsBlock(() -> BlockInit.CHLOROPHYTE_BRICKS.get().getDefaultState(), Block.Properties.from(BlockInit.CHLOROPHYTE_BRICKS.get())));
	public static final RegistryObject<Block> CHLOROPHYTE_SLAB = BLOCKS.register("chlorophyte_slab", () -> new SlabBlock(Block.Properties.from(BlockInit.CHLOROPHYTE_BRICKS.get())));
	public static final RegistryObject<Block> CHLOROCROPS = BLOCKS.register("chlorocrops", () -> new Chlorocrops(Block.Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> HARDMODE_FORCEFIELD = BLOCKS.register("hardmode_forcefield", () -> new HardmodeForcefield(Block.Properties.create(Material.IRON, MaterialColor.PURPLE).hardnessAndResistance(-1.0F, 3600000.0F).sound(SoundType.STONE).noDrops().notSolid()));
	
	public static final RegistryObject<Block> PETRIFIED_PALLADIUM_ORE = BLOCKS.register("petrified_palladium_ore", () -> new PetrifiedPalladiumOre(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PETRIFIED_ORICHALCUM_ORE = BLOCKS.register("petrified_orichalcum_ore", () -> new PetrifiedOrichalcumOre(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PETRIFIED_ADAMANTITE_ORE = BLOCKS.register("petrified_adamantite_ore", () -> new PetrifiedAdamantiteOre(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PETRIFIED_STAR_CHUNK = BLOCKS.register("petrified_star_chunk", () -> new PetrifiedStarChunk(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PETRIFIED_UNDERGROUND_HEART_CRYSTAL = BLOCKS.register("petrified_underground_heart_crystal", () -> new PetrifiedUndergroundHeartCrystal(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PETRIFIED_CHLOROPHYTE_ORE = BLOCKS.register("petrified_chlorophyte_ore", () -> new PetrifiedChlorophyteOre(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PETRIFIED_HELLSTONE = BLOCKS.register("petrified_hellstone", () -> new PetrifiedHellstone(Block.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).hardnessAndResistance(0.4F, 0.4F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> PETRIFIED_IRON_BLOCK = BLOCKS.register("petrified_iron_block", () -> new PetrifiedIronBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PETRIFIED_GOLD_BLOCK = BLOCKS.register("petrified_gold_block", () -> new PetrifiedGoldBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PETRIFIED_DIAMOND_BLOCK = BLOCKS.register("petrified_diamond_block", () -> new PetrifiedDiamondBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PETRIFIED_EMERALD_BLOCK = BLOCKS.register("petrified_emerald_block", () -> new PetrifiedEmeraldBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));



}
