package com.saita.hardmodemod.entities;

import com.saita.hardmodemod.util.HardmodeGameTimeConstant;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class SuperSpider extends CaveSpiderEntity implements IAnimatedEntity {
	
private EntityAnimationManager manager = new EntityAnimationManager();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AnimationController controller = new EntityAnimationController(this, "moveController", 10,
			this::animationPredicate);

	public SuperSpider(EntityType<? extends CaveSpiderEntity> type, World worldIn) {
		super(type, worldIn);
		registerAnimationControllers();
		this.experienceValue = 12;
		
	}
	
	//Negates fall damage
	@Override
	protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
			
		return 0;
	}
	
    
	@Override
	protected void registerAttributes() {
		
		  super.registerAttributes();
		  this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(65.0D);
		  this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
	      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.39D);
	      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(11.5D);
	}

	
	public void livingTick() {
	      if (this.isAlive()) {
	    	 
	    	//Instantly makes the mob despawn if Hardmode is off
	    	if(world.getGameTime() < HardmodeGameTimeConstant.HardmodeGameTime)
	      	{
	    	   this.remove(addedToChunk);
	      	}
		    
	      }

	      super.livingTick();
	   }
	

	// Sounds
	  protected SoundEvent getAmbientSound() {
	      return SoundEvents.ENTITY_SPIDER_AMBIENT;
	   }

	   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	      return SoundEvents.ENTITY_SPIDER_HURT;
	   }

	   protected SoundEvent getDeathSound() {
	      return SoundEvents.ENTITY_SPIDER_DEATH;
	   }

	   protected SoundEvent getStepSound() {
	      return SoundEvents.ENTITY_SPIDER_STEP;
	   }
	   
	   protected void playStepSound(BlockPos pos, BlockState blockIn) {
		      this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
	   }


	//Animations   
	@Override
	public EntityAnimationManager getAnimationManager() {

		return manager;
	}
	
	private <E extends SuperSpider> boolean animationPredicate(AnimationTestEvent<E> event) {
		if (event.isWalking()) {
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.hardmode.walk").addAnimation("animation.hardmode.walk", true));	
			return true;
		}
		return false; 		
	}
	
	private void registerAnimationControllers()
	{
		manager.addAnimationController(controller);
	}
}
