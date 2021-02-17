package com.saita.hardmodemod.init;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.entities.*;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class HardmodeEntityTypes {

	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, HardmodeMod.MOD_ID);
	
	public static final RegistryObject<EntityType<SuperZombie>> SUPER_ZOMBIE = ENTITY_TYPES.register("super_zombie", () -> EntityType.Builder.<SuperZombie>create(SuperZombie::new, EntityClassification.MONSTER)
			.size(0.6F, 1.95F).build(new ResourceLocation(HardmodeMod.MOD_ID, "super_zombie").toString()));
	
	public static final RegistryObject<EntityType<Werewolf>> WEREWOLF = ENTITY_TYPES.register("werewolf", () -> EntityType.Builder.<Werewolf>create(Werewolf::new, EntityClassification.MONSTER)
			.size(0.6F, 1.95F).build(new ResourceLocation(HardmodeMod.MOD_ID, "werewolf").toString()));
	
	public static final RegistryObject<EntityType<Psycho>> PSYCHO = ENTITY_TYPES.register("psycho", () -> EntityType.Builder.<Psycho>create(Psycho::new, EntityClassification.MONSTER).immuneToFire()
			.size(0.6F, 1.95F).build(new ResourceLocation(HardmodeMod.MOD_ID, "psycho").toString()));
	
	public static final RegistryObject<EntityType<Reaper>> REAPER = ENTITY_TYPES.register("reaper", () -> EntityType.Builder.<Reaper>create(Reaper::new, EntityClassification.MONSTER).immuneToFire()
			.size(0.6F, 1.95F).build(new ResourceLocation(HardmodeMod.MOD_ID, "reaper").toString()));
	
	public static final RegistryObject<EntityType<PlayerAssassin>> PLAYER_ASSASSIN = ENTITY_TYPES.register("player_assassin", () -> EntityType.Builder.<PlayerAssassin>create(PlayerAssassin::new, EntityClassification.MONSTER)
			.size(0.6F, 1.95F).build(new ResourceLocation(HardmodeMod.MOD_ID, "player_assassin").toString()));
	
	public static final RegistryObject<EntityType<Titan>> TITAN = ENTITY_TYPES.register("titan", () -> EntityType.Builder.<Titan>create(Titan::new, EntityClassification.MONSTER)
			.size(1.45F, 7.8F).build(new ResourceLocation(HardmodeMod.MOD_ID, "titan").toString()));
	
	public static final RegistryObject<EntityType<FireDemon>> FIRE_DEMON = ENTITY_TYPES.register("fire_demon", () -> EntityType.Builder.<FireDemon>create(FireDemon::new, EntityClassification.MONSTER).immuneToFire()
			.size(0.6F, 1.95F).build(new ResourceLocation(HardmodeMod.MOD_ID, "fire_demon").toString()));
	
	public static final RegistryObject<EntityType<SuperSpider>> SUPER_SPIDER = ENTITY_TYPES.register("super_spider", () -> EntityType.Builder.<SuperSpider>create(SuperSpider::new, EntityClassification.MONSTER)
			.size(1.4F, 0.9F).build(new ResourceLocation(HardmodeMod.MOD_ID, "super_spider").toString()));
	
	public static final RegistryObject<EntityType<DemonEye>> DEMON_EYE = ENTITY_TYPES.register("demon_eye", () -> EntityType.Builder.<DemonEye>create(DemonEye::new, EntityClassification.MONSTER)
			.size(0.9F, 1.0F).build(new ResourceLocation(HardmodeMod.MOD_ID, "demon_eye").toString()));
	
	public static final RegistryObject<EntityType<EyeOfCthulhu>> EYE_OF_CTHULHU = ENTITY_TYPES.register("eye_of_cthulhu", () -> EntityType.Builder.<EyeOfCthulhu>create(EyeOfCthulhu::new, EntityClassification.MONSTER).immuneToFire()
			.size(1.5F, 2.0F).build(new ResourceLocation(HardmodeMod.MOD_ID, "eye_of_cthulhu").toString()));
	
	public static final RegistryObject<EntityType<FaceMonster>> FACE_MONSTER = ENTITY_TYPES.register("face_monster", () -> EntityType.Builder.<FaceMonster>create(FaceMonster::new, EntityClassification.MONSTER)
			.size(0.6F, 1.95F).build(new ResourceLocation(HardmodeMod.MOD_ID, "face_monster").toString()));
	
}
	
