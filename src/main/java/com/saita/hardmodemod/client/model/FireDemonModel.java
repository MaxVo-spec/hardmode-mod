package com.saita.hardmodemod.client.model;

import com.saita.hardmodemod.entities.FireDemon;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class FireDemonModel extends AnimatedEntityModel<FireDemon> {

    private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer rightLeg;
	private final AnimatedModelRenderer leftLeg;
	private final AnimatedModelRenderer rightArm;
	private final AnimatedModelRenderer leftArm;
	private final AnimatedModelRenderer chest;
	private final AnimatedModelRenderer head;

    public FireDemonModel()
    {
        textureWidth = 64;
        textureHeight = 32;
        Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		rightLeg = new AnimatedModelRenderer(this);
		rightLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		Body.addChild(rightLeg);
		rightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		rightLeg.setModelRendererName("rightLeg");
		this.registerModelRenderer(rightLeg);

		leftLeg = new AnimatedModelRenderer(this);
		leftLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
		Body.addChild(leftLeg);
		leftLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		leftLeg.setModelRendererName("leftLeg");
		this.registerModelRenderer(leftLeg);

		rightArm = new AnimatedModelRenderer(this);
		rightArm.setRotationPoint(6.0F, -22.0F, 0.0F);
		Body.addChild(rightArm);
		setRotationAngle(rightArm, -1.3526F, 0.0F, 0.0F);
		rightArm.setTextureOffset(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		rightArm.setModelRendererName("rightArm");
		this.registerModelRenderer(rightArm);

		leftArm = new AnimatedModelRenderer(this);
		leftArm.setRotationPoint(-6.0F, -22.0F, 0.0F);
		Body.addChild(leftArm);
		setRotationAngle(leftArm, -1.3526F, 0.0F, 0.0F);
		leftArm.setTextureOffset(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		leftArm.setModelRendererName("leftArm");
		this.registerModelRenderer(leftArm);

		chest = new AnimatedModelRenderer(this);
		chest.setRotationPoint(0.0F, -24.0F, 0.0F);
		Body.addChild(chest);
		chest.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		chest.setModelRendererName("chest");
		this.registerModelRenderer(chest);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -24.0F, 0.0F);
		Body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

    this.rootBones.add(Body);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("hardmode", "animations/fire_demon.json");
    }
}