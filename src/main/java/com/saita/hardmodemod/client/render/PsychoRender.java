package com.saita.hardmodemod.client.render;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.client.model.PsychoModel;
import com.saita.hardmodemod.entities.Psycho;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PsychoRender extends MobRenderer<Psycho, PsychoModel> {
	
	protected static final ResourceLocation PSYCHO_TEXTURE = new ResourceLocation(HardmodeMod.MOD_ID, "textures/entity/psycho.png");
	
	public PsychoRender(EntityRendererManager rendererManagerIn)
	{
		super(rendererManagerIn, new PsychoModel(), 0.5F);
	}
	
	public ResourceLocation getEntityTexture(Psycho entity) {
		return PSYCHO_TEXTURE;
	}
	
}
