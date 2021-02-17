package com.saita.hardmodemod.entities;

import com.saita.hardmodemod.util.HardmodeGameTimeConstant;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class PlayerAssassin extends MonsterEntity implements IAnimatedEntity {
	
private EntityAnimationManager manager = new EntityAnimationManager();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AnimationController controller = new EntityAnimationController(this, "moveController", 8,
			this::animationPredicate);

	public PlayerAssassin(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		registerAnimationControllers();
		this.experienceValue = 12;
		
	}
	
	
	@Override
	protected void registerGoals() {
		 super.registerGoals();   
		 this.goalSelector.addGoal(0, new SwimGoal(this));
		 this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2D, true));
		 this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
	     this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
	     this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 15.0F));
	     
	     this.applyEntityAI();

		
	}
	
	protected void applyEntityAI() {
		  
	      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
  
	   }
	
    
	@Override
	protected void registerAttributes() {
		
		  super.registerAttributes();
		  this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(70.0D);
		  this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
	      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
	      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
	}
	
	
	
	
	public void livingTick() {
	      if (this.isAlive()) {
	    	 
	    	//Instantly makes the mob despawn if Hardmode is off
	    	if(world.getGameTime() < HardmodeGameTimeConstant.HardmodeGameTime)
	      	{
	    		this.remove(addedToChunk);
	      	}
	    	
	    	//To make the assassin jump 3 blocks.
	    	this.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 2, false, false));
		    
	      }

	      super.livingTick();
	   }
	

	// Sounds
	  protected SoundEvent getAmbientSound() {
	      return null;
	   }

	   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	      return SoundEvents.ENTITY_PLAYER_HURT;
	   }

	   protected SoundEvent getDeathSound() {
	      return SoundEvents.ENTITY_PLAYER_DEATH;
	   }

	   protected SoundEvent getStepSound() {
	      return null;
	   }


	//Animations   
	@Override
	public EntityAnimationManager getAnimationManager() {

		return manager;
	}
	
	private <E extends PlayerAssassin> boolean animationPredicate(AnimationTestEvent<E> event) {
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
