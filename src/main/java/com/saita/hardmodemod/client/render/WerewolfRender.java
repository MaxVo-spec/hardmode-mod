package com.saita.hardmodemod.client.render;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.client.model.WerewolfModel;
import com.saita.hardmodemod.entities.Werewolf;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class WerewolfRender extends MobRenderer<Werewolf, WerewolfModel> {
	
	protected static final ResourceLocation WEREWOLF_TEXTURE = new ResourceLocation(HardmodeMod.MOD_ID, "textures/entity/werewolf.png");
	
	public WerewolfRender(EntityRendererManager rendererManagerIn)
	{
		super(rendererManagerIn, new WerewolfModel(), 0.5F);
	}
	
	public ResourceLocation getEntityTexture(Werewolf entity) {
		return WEREWOLF_TEXTURE;
	}
	
}
