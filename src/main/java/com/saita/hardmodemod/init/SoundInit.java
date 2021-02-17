package com.saita.hardmodemod.init;

import com.saita.hardmodemod.HardmodeMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {
	
	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, HardmodeMod.MOD_ID);
	
	public static final RegistryObject<SoundEvent> SUPER_STAR = SOUNDS.register("super_star_theme", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "super_star_theme")));
	
	public static final RegistryObject<SoundEvent> LIGHTSABER = SOUNDS.register("lightsaber_sound", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "lightsaber_sound")));
	
	public static final RegistryObject<SoundEvent> MOLTEN_CORE = SOUNDS.register("molten_core_sound", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "molten_core_sound")));
	
	public static final RegistryObject<SoundEvent> EYE_OF_CTHULHU_SCREAM = SOUNDS.register("eye_of_cthulhu_scream", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "eye_of_cthulhu_scream")));
	
	public static final RegistryObject<SoundEvent> SCREAM = SOUNDS.register("scream", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "scream")));
	
	public static final RegistryObject<SoundEvent> DRAGON_BLADE_DASH = SOUNDS.register("dragon_blade_dash", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "dragon_blade_dash")));
	
	public static final RegistryObject<SoundEvent> WEREWOLF_AMBIENT = SOUNDS.register("werewolf_ambient", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "werewolf_ambient")));
	
	public static final RegistryObject<SoundEvent> WEREWOLF_HIT = SOUNDS.register("werewolf_hit", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "werewolf_hit")));
	
	public static final RegistryObject<SoundEvent> WEREWOLF_DEATH = SOUNDS.register("werewolf_death", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "werewolf_death")));
	
	public static final RegistryObject<SoundEvent> PSYCHO_AMBIENT = SOUNDS.register("psycho_ambient", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "psycho_ambient")));
	
	public static final RegistryObject<SoundEvent> REAPER_AMBIENT = SOUNDS.register("reaper_ambient", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "reaper_ambient")));
	
	public static final RegistryObject<SoundEvent> REAPER_HIT = SOUNDS.register("reaper_hit", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "reaper_hit")));
	
	public static final RegistryObject<SoundEvent> REAPER_DEATH = SOUNDS.register("reaper_death", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "reaper_death")));
	
	public static final RegistryObject<SoundEvent> NANO_BOOST = SOUNDS.register("nano_boost", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "nano_boost")));
	
	public static final RegistryObject<SoundEvent> TITAN_AMBIENT = SOUNDS.register("titan_ambient", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "titan_ambient")));
	
	public static final RegistryObject<SoundEvent> TITAN_HIT = SOUNDS.register("titan_hit", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "titan_hit")));
	
	public static final RegistryObject<SoundEvent> TITAN_DEATH = SOUNDS.register("titan_death", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "titan_death")));
	
	public static final RegistryObject<SoundEvent> WARP_STAR = SOUNDS.register("warp_star", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "warp_star")));
	
	public static final RegistryObject<SoundEvent> MAGIC_MIRROR = SOUNDS.register("magic_mirror", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "magic_mirror")));
	
	public static final RegistryObject<SoundEvent> INSTANT_HEALING_POTION = SOUNDS.register("instant_healing_potion", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "instant_healing_potion")));
	
	public static final RegistryObject<SoundEvent> LIFE_CRYSTAL = SOUNDS.register("life_crystal", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "life_crystal")));
	
	public static final RegistryObject<SoundEvent> EYE_HIT = SOUNDS.register("eye_hit", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "eye_hit")));
	
	public static final RegistryObject<SoundEvent> EYE_DEATH = SOUNDS.register("eye_death", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "eye_death")));
	
	public static final RegistryObject<SoundEvent> FACE_MONSTER_AMBIENT = SOUNDS.register("face_monster_ambient", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "face_monster_ambient")));
	
	public static final RegistryObject<SoundEvent> FACE_MONSTER_HIT = SOUNDS.register("face_monster_hit", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "face_monster_hit")));
	
	public static final RegistryObject<SoundEvent> FACE_MONSTER_DEATH = SOUNDS.register("face_monster_death", () -> new SoundEvent
			(new ResourceLocation(HardmodeMod.MOD_ID, "face_monster_death")));
	
}
