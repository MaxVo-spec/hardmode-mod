package com.saita.hardmodemod.client.render;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.client.model.SuperZombieModel;
import com.saita.hardmodemod.entities.SuperZombie;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SuperZombieRender extends MobRenderer<SuperZombie, SuperZombieModel> {
	
	protected static final ResourceLocation SUPER_ZOMBIE_TEXTURE = new ResourceLocation(HardmodeMod.MOD_ID, "textures/entity/super_zombie.png");
	
	public SuperZombieRender(EntityRendererManager rendererManagerIn)
	{
		super(rendererManagerIn, new SuperZombieModel(), 0.5F);
	}
	
	public ResourceLocation getEntityTexture(SuperZombie entity) {
		return SUPER_ZOMBIE_TEXTURE;
	}
	
}
