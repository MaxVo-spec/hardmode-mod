package com.saita.hardmodemod.client.model;

import com.saita.hardmodemod.entities.SuperSpider;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class SuperSpiderModel extends AnimatedEntityModel<SuperSpider> {

	    private final AnimatedModelRenderer Body;
		private final AnimatedModelRenderer leg7;
		private final AnimatedModelRenderer leg6;
		private final AnimatedModelRenderer leg4;
		private final AnimatedModelRenderer leg5;
		private final AnimatedModelRenderer leg3;
		private final AnimatedModelRenderer leg2;
		private final AnimatedModelRenderer leg1;
		private final AnimatedModelRenderer leg0;
		private final AnimatedModelRenderer chest1;
		private final AnimatedModelRenderer chest0;
		private final AnimatedModelRenderer head;

	    public SuperSpiderModel()
	    {
	        textureWidth = 64;
	        textureHeight = 32;
	        Body = new AnimatedModelRenderer(this);
			Body.setRotationPoint(0.0F, 24.0F, 0.0F);
			
			Body.setModelRendererName("Body");
			this.registerModelRenderer(Body);

			leg7 = new AnimatedModelRenderer(this);
			leg7.setRotationPoint(-4.0F, -9.0F, -1.0F);
			Body.addChild(leg7);
			setRotationAngle(leg7, 0.0F, -0.2618F, -0.5236F);
			leg7.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -3.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			leg7.setModelRendererName("leg7");
			this.registerModelRenderer(leg7);

			leg6 = new AnimatedModelRenderer(this);
			leg6.setRotationPoint(4.0F, -9.0F, -1.0F);
			Body.addChild(leg6);
			setRotationAngle(leg6, 0.0F, 0.2618F, 0.5236F);
			leg6.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -3.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			leg6.setModelRendererName("leg6");
			this.registerModelRenderer(leg6);

			leg4 = new AnimatedModelRenderer(this);
			leg4.setRotationPoint(4.0F, -9.0F, 0.0F);
			Body.addChild(leg4);
			setRotationAngle(leg4, 0.0F, 0.0873F, 0.5236F);
			leg4.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			leg4.setModelRendererName("leg4");
			this.registerModelRenderer(leg4);

			leg5 = new AnimatedModelRenderer(this);
			leg5.setRotationPoint(-4.0F, -9.0F, 0.0F);
			Body.addChild(leg5);
			setRotationAngle(leg5, 0.0F, -0.0873F, -0.5236F);
			leg5.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			leg5.setModelRendererName("leg5");
			this.registerModelRenderer(leg5);

			leg3 = new AnimatedModelRenderer(this);
			leg3.setRotationPoint(-4.0F, -9.0F, 1.0F);
			Body.addChild(leg3);
			setRotationAngle(leg3, 0.0F, 0.0873F, -0.5236F);
			leg3.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, 1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			leg3.setModelRendererName("leg3");
			this.registerModelRenderer(leg3);

			leg2 = new AnimatedModelRenderer(this);
			leg2.setRotationPoint(4.0F, -9.0F, 1.0F);
			Body.addChild(leg2);
			setRotationAngle(leg2, 0.0F, -0.0873F, 0.5236F);
			leg2.setTextureOffset(18, 0).addBox(0.0F, -1.0F, 1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			leg2.setModelRendererName("leg2");
			this.registerModelRenderer(leg2);

			leg1 = new AnimatedModelRenderer(this);
			leg1.setRotationPoint(-4.0F, -9.0F, 1.0F);
			Body.addChild(leg1);
			setRotationAngle(leg1, -0.0873F, 0.3491F, -0.5236F);
			leg1.setTextureOffset(18, 0).addBox(-16.0F, -1.0F, 4.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			leg1.setModelRendererName("leg1");
			this.registerModelRenderer(leg1);

			leg0 = new AnimatedModelRenderer(this);
			leg0.setRotationPoint(4.0F, -9.0F, 2.0F);
			Body.addChild(leg0);
			setRotationAngle(leg0, 0.0873F, -0.3491F, 0.5236F);
			leg0.setTextureOffset(18, 0).addBox(0.0F, -1.0F, 3.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			leg0.setModelRendererName("leg0");
			this.registerModelRenderer(leg0);

			chest1 = new AnimatedModelRenderer(this);
			chest1.setRotationPoint(0.0F, -9.0F, 9.0F);
			Body.addChild(chest1);
			chest1.setTextureOffset(0, 12).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 8.0F, 12.0F, 0.0F, false);
			chest1.setModelRendererName("chest1");
			this.registerModelRenderer(chest1);

			chest0 = new AnimatedModelRenderer(this);
			chest0.setRotationPoint(0.0F, -9.0F, 0.0F);
			Body.addChild(chest0);
			chest0.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			chest0.setModelRendererName("chest0");
			this.registerModelRenderer(chest0);

			head = new AnimatedModelRenderer(this);
			head.setRotationPoint(0.0F, -9.0F, -3.0F);
			Body.addChild(head);
			head.setTextureOffset(32, 4).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			head.setModelRendererName("head");
			this.registerModelRenderer(head);

	    this.rootBones.add(Body);
	  }


	    @Override
	    public ResourceLocation getAnimationFileLocation()
	    {
	        return new ResourceLocation("hardmode", "animations/super_spider.json");
	    }

}