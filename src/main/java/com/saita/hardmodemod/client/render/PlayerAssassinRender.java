package com.saita.hardmodemod.client.render;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.client.model.PlayerAssassinModel;
import com.saita.hardmodemod.entities.PlayerAssassin;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PlayerAssassinRender extends MobRenderer<PlayerAssassin, PlayerAssassinModel> {
	
	protected static final ResourceLocation PLAYER_ASSASSIN_TEXTURE = new ResourceLocation(HardmodeMod.MOD_ID, "textures/entity/player_assassin.png");
	
	public PlayerAssassinRender(EntityRendererManager rendererManagerIn)
	{
		super(rendererManagerIn, new PlayerAssassinModel(), 0.5F);
	}
	
	public ResourceLocation getEntityTexture(PlayerAssassin entity) {
		return PLAYER_ASSASSIN_TEXTURE;
	}
	
}