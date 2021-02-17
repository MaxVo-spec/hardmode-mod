package com.saita.hardmodemod.client.model;

import com.saita.hardmodemod.entities.Titan;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class TitanModel extends AnimatedEntityModel<Titan> {

	private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer chest;
	private final AnimatedModelRenderer leftArm;
	private final AnimatedModelRenderer rightArm;
	private final AnimatedModelRenderer leftLeg;
	private final AnimatedModelRenderer rightLeg;
	private final AnimatedModelRenderer head;

    public TitanModel()
    {
        textureWidth = 256;
        textureHeight = 128;
        Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		chest = new AnimatedModelRenderer(this);
		chest.setRotationPoint(0.0F, -95.0F, 0.0F);
		Body.addChild(chest);
		chest.setTextureOffset(64, 64).addBox(-16.0F, -1.0F, -1.0F, 32.0F, 48.0F, 16.0F, 0.0F, true);
		chest.setModelRendererName("chest");
		this.registerModelRenderer(chest);

		leftArm = new AnimatedModelRenderer(this);
		leftArm.setRotationPoint(-24.0F, -88.0F, 12.0F);
		Body.addChild(leftArm);
		setRotationAngle(leftArm, -1.2217F, 0.0F, 0.0F);
		leftArm.setTextureOffset(160, 64).addBox(-8.0F, -1.4202F, -9.3969F, 16.0F, 48.0F, 16.0F, 0.0F, false);
		leftArm.setModelRendererName("leftArm");
		this.registerModelRenderer(leftArm);

		rightArm = new AnimatedModelRenderer(this);
		rightArm.setRotationPoint(24.0F, -88.0F, 13.0F);
		Body.addChild(rightArm);
		setRotationAngle(rightArm, -1.2217F, 0.0F, 0.0F);
		rightArm.setTextureOffset(160, 64).addBox(-8.0F, -3.3941F, -7.5778F, 16.0F, 48.0F, 16.0F, 0.0F, true);
		rightArm.setModelRendererName("rightArm");
		this.registerModelRenderer(rightArm);

		leftLeg = new AnimatedModelRenderer(this);
		leftLeg.setRotationPoint(-8.0F, -47.0F, 7.0F);
		Body.addChild(leftLeg);
		leftLeg.setTextureOffset(0, 64).addBox(-8.0F, -1.0F, -8.0F, 16.0F, 48.0F, 16.0F, 0.0F, false);
		leftLeg.setModelRendererName("leftLeg");
		this.registerModelRenderer(leftLeg);

		rightLeg = new AnimatedModelRenderer(this);
		rightLeg.setRotationPoint(8.0F, -47.0F, 7.0F);
		Body.addChild(rightLeg);
		rightLeg.setTextureOffset(0, 64).addBox(-8.0F, -1.0F, -8.0F, 16.0F, 48.0F, 16.0F, 0.0F, true);
		rightLeg.setModelRendererName("rightLeg");
		this.registerModelRenderer(rightLeg);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -95.0F, 0.0F);
		Body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-16.0F, -33.0F, -9.0F, 32.0F, 32.0F, 32.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

    this.rootBones.add(Body);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("hardmode", "animations/titan.json");
    }
}