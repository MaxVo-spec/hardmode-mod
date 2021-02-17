package com.saita.hardmodemod.client.render;

import com.saita.hardmodemod.HardmodeMod;
import com.saita.hardmodemod.client.model.FaceMonsterModel;
import com.saita.hardmodemod.entities.FaceMonster;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FaceMonsterRender extends MobRenderer<FaceMonster, FaceMonsterModel> {
	
	protected static final ResourceLocation FACE_MONSTER_TEXTURE = new ResourceLocation(HardmodeMod.MOD_ID, "textures/entity/face_monster.png");
	
	public FaceMonsterRender(EntityRendererManager rendererManagerIn)
	{
		super(rendererManagerIn, new FaceMonsterModel(), 0.5F);
	}
	
	public ResourceLocation getEntityTexture(FaceMonster entity) {
		return FACE_MONSTER_TEXTURE;
	}
	
}
