package com.saita.hardmodemod.client.render;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.client.model.DemonEyeModel;
import com.saita.hardmodemod.entities.DemonEye;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DemonEyeRender extends MobRenderer<DemonEye, DemonEyeModel> {
	
	protected static final ResourceLocation DEMON_EYE_TEXTURE = new ResourceLocation(HardmodeMod.MOD_ID, "textures/entity/demon_eye.png");
	
	public DemonEyeRender(EntityRendererManager rendererManagerIn)
	{
		super(rendererManagerIn, new DemonEyeModel(), 0.75F);
	}
	
	public ResourceLocation getEntityTexture(DemonEye entity) {
		return DEMON_EYE_TEXTURE;
	}
	
}