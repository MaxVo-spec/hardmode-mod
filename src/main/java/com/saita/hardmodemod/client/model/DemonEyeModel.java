package com.saita.hardmodemod.client.model;

import com.saita.hardmodemod.entities.DemonEye;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class DemonEyeModel extends AnimatedEntityModel<DemonEye> {

    private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer Head;
	private final AnimatedModelRenderer Tentacles;
	private final AnimatedModelRenderer Tentacle4;
	private final AnimatedModelRenderer Tentacle3;
	private final AnimatedModelRenderer Tentacle2;
	private final AnimatedModelRenderer Tentacle1;
	private final AnimatedModelRenderer Tentacle5;
	private final AnimatedModelRenderer Tentacle6;

    public DemonEyeModel()
    {
    	    textureWidth = 95;
    	    textureHeight = 24;
    	    Body = new AnimatedModelRenderer(this);
    		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
    			
    		Body.setModelRendererName("Body");
    		this.registerModelRenderer(Body);

    		Head = new AnimatedModelRenderer(this);
    		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
    		Body.addChild(Head);
    		Head.setTextureOffset(0, 0).addBox(-6.0F, -13.0F, -7.0F, 12.0F, 12.0F, 12.0F, 0.0F, false);
    		Head.setModelRendererName("Head");
    		this.registerModelRenderer(Head);

    		Tentacles = new AnimatedModelRenderer(this);
    		Tentacles.setRotationPoint(0.0F, 0.0F, 0.0F);
    		Body.addChild(Tentacles);
    			
    		Tentacles.setModelRendererName("Tentacles");
    		this.registerModelRenderer(Tentacles);

    		Tentacle4 = new AnimatedModelRenderer(this);
    		Tentacle4.setRotationPoint(-4.0F, -3.0F, 0.0F);
    		Tentacles.addChild(Tentacle4);
    		Tentacle4.setTextureOffset(71, 1).addBox(2.0F, -4.0F, 4.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
    		Tentacle4.setModelRendererName("Tentacle4");
    		this.registerModelRenderer(Tentacle4);

    		Tentacle3 = new AnimatedModelRenderer(this);
    		Tentacle3.setRotationPoint(0.0F, 0.0F, 0.0F);
    		Tentacles.addChild(Tentacle3);
    		Tentacle3.setTextureOffset(71, 2).addBox(1.0F, -7.0F, 4.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
    		Tentacle3.setModelRendererName("Tentacle3");
    		this.registerModelRenderer(Tentacle3);

    		Tentacle2 = new AnimatedModelRenderer(this);
    		Tentacle2.setRotationPoint(0.0F, 0.0F, 0.0F);
    		Tentacles.addChild(Tentacle2);
    		Tentacle2.setTextureOffset(55, 12).addBox(-4.0F, -4.0F, 4.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
    		Tentacle2.setModelRendererName("Tentacle2");
    		this.registerModelRenderer(Tentacle2);

    		Tentacle1 = new AnimatedModelRenderer(this);
    		Tentacle1.setRotationPoint(0.0F, 0.0F, 0.0F);
    		Tentacles.addChild(Tentacle1);
    		Tentacle1.setTextureOffset(73, 2).addBox(3.0F, -4.0F, 4.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
    		Tentacle1.setModelRendererName("Tentacle1");
    		this.registerModelRenderer(Tentacle1);

    		Tentacle5 = new AnimatedModelRenderer(this);
    		Tentacle5.setRotationPoint(0.0F, -6.0F, 0.0F);
    		Tentacles.addChild(Tentacle5);
    		Tentacle5.setTextureOffset(62, 6).addBox(3.0F, -5.0F, 4.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
    		Tentacle5.setModelRendererName("Tentacle5");
    		this.registerModelRenderer(Tentacle5);

    		Tentacle6 = new AnimatedModelRenderer(this);
    		Tentacle6.setRotationPoint(-6.0F, -6.0F, 0.0F);
    		Tentacles.addChild(Tentacle6);
    		Tentacle6.setTextureOffset(53, 1).addBox(2.0F, -5.0F, 4.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
    		Tentacle6.setModelRendererName("Tentacle6");
    	    this.registerModelRenderer(Tentacle6);


      this.rootBones.add(Body);
    }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("hardmode", "animations/demon_eye.json");
    }
}


