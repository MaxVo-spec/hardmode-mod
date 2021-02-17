package com.saita.hardmodemod.client.render;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.client.model.TitanModel;
import com.saita.hardmodemod.entities.Titan;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TitanRender extends MobRenderer<Titan, TitanModel> {
	
	protected static final ResourceLocation TITAN_TEXTURE = new ResourceLocation(HardmodeMod.MOD_ID, "textures/entity/titan.png");
	
	public TitanRender(EntityRendererManager rendererManagerIn)
	{
		super(rendererManagerIn, new TitanModel(), 2.0F);
	}
	
	public ResourceLocation getEntityTexture(Titan entity) {
		return TITAN_TEXTURE;
	}
	
}
