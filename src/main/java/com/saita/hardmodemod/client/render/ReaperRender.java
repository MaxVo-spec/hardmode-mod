package com.saita.hardmodemod.client.render;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.client.model.ReaperModel;
import com.saita.hardmodemod.entities.Reaper;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ReaperRender extends MobRenderer<Reaper, ReaperModel<Reaper>> {
	
	protected static final ResourceLocation REAPER_TEXTURE = new ResourceLocation(HardmodeMod.MOD_ID, "textures/entity/reaper.png");
	
	public ReaperRender(EntityRendererManager rendererManagerIn)
	{
		super(rendererManagerIn, new ReaperModel<Reaper>(), 0.5F);
	}
	
	public ResourceLocation getEntityTexture(Reaper entity) {
		return REAPER_TEXTURE;
	}
	
}
