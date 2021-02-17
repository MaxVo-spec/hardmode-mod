package com.saita.hardmodemod.client.render;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.client.model.EyeOfCthulhuModel;
import com.saita.hardmodemod.entities.EyeOfCthulhu;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class EyeOfCthulhuRender extends MobRenderer<EyeOfCthulhu, EyeOfCthulhuModel> {
	
	protected static final ResourceLocation EYE_OF_CTHULHU_TEXTURE = new ResourceLocation(HardmodeMod.MOD_ID, "textures/entity/demon_eye.png");
	
	public EyeOfCthulhuRender(EntityRendererManager rendererManagerIn)
	{
		super(rendererManagerIn, new EyeOfCthulhuModel(), 3.75F);
	}
	
	public ResourceLocation getEntityTexture(EyeOfCthulhu entity) {
		return EYE_OF_CTHULHU_TEXTURE;
	}
	
}