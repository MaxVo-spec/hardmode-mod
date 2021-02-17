package com.saita.hardmodemod.client.render;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.client.model.FireDemonModel;
import com.saita.hardmodemod.entities.FireDemon;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FireDemonRender extends MobRenderer<FireDemon, FireDemonModel> {
	
	protected static final ResourceLocation FIRE_DEMON_TEXTURE = new ResourceLocation(HardmodeMod.MOD_ID, "textures/entity/fire_demon.png");
	
	public FireDemonRender(EntityRendererManager rendererManagerIn)
	{
		super(rendererManagerIn, new FireDemonModel(), 0.5F);
	}
	
	public ResourceLocation getEntityTexture(FireDemon entity) {
		return FIRE_DEMON_TEXTURE;
	}
	
}