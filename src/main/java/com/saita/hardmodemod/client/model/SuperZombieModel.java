package com.saita.hardmodemod.client.model;

import com.saita.hardmodemod.entities.SuperZombie;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class SuperZombieModel extends AnimatedEntityModel<SuperZombie> {

    private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer chest;
	private final AnimatedModelRenderer leftArm;
	private final AnimatedModelRenderer rightArm;
	private final AnimatedModelRenderer leftLeg;
	private final AnimatedModelRenderer rightLeg;

    public SuperZombieModel()
    {
        textureWidth = 64;
        textureHeight = 64;
        Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -24.0F, 0.0F);
		Body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		chest = new AnimatedModelRenderer(this);
		chest.setRotationPoint(0.0F, -24.0F, 0.0F);
		Body.addChild(chest);
		chest.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		chest.setModelRendererName("chest");
		this.registerModelRenderer(chest);

		leftArm = new AnimatedModelRenderer(this);
		leftArm.setRotationPoint(-6.0F, -22.0F, 0.0F);
		Body.addChild(leftArm);
		setRotationAngle(leftArm, -1.3963F, -0.0436F, -0.0436F);
		leftArm.setTextureOffset(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		leftArm.setModelRendererName("leftArm");
		this.registerModelRenderer(leftArm);

		rightArm = new AnimatedModelRenderer(this);
		rightArm.setRotationPoint(6.0F, -22.0F, 0.0F);
		Body.addChild(rightArm);
		setRotationAngle(rightArm, -1.3963F, 0.0436F, 0.0436F);
		rightArm.setTextureOffset(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		rightArm.setModelRendererName("rightArm");
		this.registerModelRenderer(rightArm);

		leftLeg = new AnimatedModelRenderer(this);
		leftLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
		Body.addChild(leftLeg);
		leftLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		leftLeg.setModelRendererName("leftLeg");
		this.registerModelRenderer(leftLeg);

		rightLeg = new AnimatedModelRenderer(this);
		rightLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		Body.addChild(rightLeg);
		rightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		rightLeg.setModelRendererName("rightLeg");
		this.registerModelRenderer(rightLeg);

    this.rootBones.add(Body);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("hardmode", "animations/super_zombie.json");
    }
}