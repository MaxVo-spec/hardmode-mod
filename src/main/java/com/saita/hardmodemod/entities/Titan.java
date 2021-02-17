package com.saita.hardmodemod.entities;

import com.saita.hardmodemod.init.SoundInit;
import com.saita.hardmodemod.util.HardmodeGameTimeConstant;

import net.minecraft.block.BlockState;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class Titan extends MonsterEntity implements IAnimatedEntity {
	
	private EntityAnimationManager manager = new EntityAnimationManager();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AnimationController controller = new EntityAnimationController(this, "moveController", 15,
			this::animationPredicate);

	public Titan(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		registerAnimationControllers();
		this.experienceValue = 80;
		
	}
	
	
	@Override
	protected void registerGoals() {
		 super.registerGoals();   
		 this.goalSelector.addGoal(0, new SwimGoal(this));
		 this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
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
		  this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(250.0D);
		  this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
	      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
	      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(26.0D);
	}
	
	
	
	
	public void livingTick() {
	      if (this.isAlive()) {
	    	 
	    	//Instantly makes the mob despawn if Hardmode is off
	    	if(world.getGameTime() < HardmodeGameTimeConstant.HardmodeGameTime)
	      	{
	    	  this.remove(addedToChunk);
	      	}
	    	
	    	// To make the Titan jump 5 blocks
	    	this.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 4, false, false));
		    
	      }

	      super.livingTick();
	   }
	

	// Sounds
	  protected SoundEvent getAmbientSound() {
	      return SoundInit.TITAN_AMBIENT.get();
	   }

	   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		   return SoundInit.TITAN_HIT.get();
	   }

	   protected SoundEvent getDeathSound() {
		   return SoundInit.TITAN_DEATH.get();
	   }

	   protected SoundEvent getStepSound() {
	      return SoundEvents.ENTITY_ZOMBIE_STEP;
	   }

	   protected void playStepSound(BlockPos pos, BlockState blockIn) {
	      this.playSound(this.getStepSound(), 0.15F, 1.0F);
	   }
	   
	   //Animations
	   @Override
		public EntityAnimationManager getAnimationManager() {
			
			return manager;
		}	
		
		private <E extends Titan> boolean animationPredicate(AnimationTestEvent<E> event) {
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
