package com.saita.hardmodemod.client.render;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.client.model.SuperSpiderModel;
import com.saita.hardmodemod.entities.SuperSpider;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SuperSpiderRender extends MobRenderer<SuperSpider, SuperSpiderModel> {
	
	protected static final ResourceLocation SUPER_SPIDER_TEXTURE = new ResourceLocation(HardmodeMod.MOD_ID, "textures/entity/super_spider.png");
	
	public SuperSpiderRender(EntityRendererManager rendererManagerIn)
	{
		super(rendererManagerIn, new SuperSpiderModel(), 0.8F);
	}
	
	public ResourceLocation getEntityTexture(SuperSpider entity) {
		return SUPER_SPIDER_TEXTURE;
	}
	
}
