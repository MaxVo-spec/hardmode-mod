package com.saita.hardmodemod.entities;

import com.saita.hardmodemod.util.HardmodeGameTimeConstant;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.PathNodeType;
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

public class FireDemon extends MonsterEntity implements IAnimatedEntity {
	
	private EntityAnimationManager manager = new EntityAnimationManager();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AnimationController controller = new EntityAnimationController(this, "moveController", 15,
			this::animationPredicate);

	public FireDemon(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		registerAnimationControllers();
		this.setPathPriority(PathNodeType.WATER, -1.0F);
	    this.setPathPriority(PathNodeType.DANGER_FIRE, 0.0F);
	    this.setPathPriority(PathNodeType.DAMAGE_FIRE, 0.0F);
	    
		this.experienceValue = 16;
		
	}

	@Override
	public boolean isEntityUndead() {
		return true;
	}
	
	//Negates fall damage
	@Override
	protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
			
		return 0;
	}
	
	//Makes Fire Demon Bright
	@Override
	public float getBrightness() {
		
		return 1.0F;
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
		  
		  this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
	      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
  
	   }
	
	//Takes damage in water
	@Override
	protected void updateAITasks() {
		if (this.isInWaterRainOrBubbleColumn()) {
	         this.attackEntityFrom(DamageSource.DROWN, 1.0F);
		}
	}
	
    
	@Override
	protected void registerAttributes() {
		
		  super.registerAttributes();
		  this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(75.0D);
		  this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
	      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
	      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(14.5D);
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
	
	// Burns the entity it attacks
		@Override
		public boolean attackEntityAsMob(Entity entityIn) {
			if (super.attackEntityAsMob(entityIn)) {
		         if (entityIn instanceof LivingEntity) {
		        	 ((LivingEntity)entityIn).setFire(4);
		         }
		      }
			return super.attackEntityAsMob(entityIn);
		}
	

	// Sounds
	  protected SoundEvent getAmbientSound() {
	      return SoundEvents.ENTITY_BLAZE_AMBIENT;
	   }

	   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		   return SoundEvents.ENTITY_BLAZE_HURT;
	   }

	   protected SoundEvent getDeathSound() {
		   return SoundEvents.ENTITY_BLAZE_DEATH;
	   }

	   protected SoundEvent getStepSound() {
	      return SoundEvents.ENTITY_WITHER_SKELETON_STEP;
	   }
	   
	   protected void playStepSound(BlockPos pos, BlockState blockIn) {
		      this.playSound(this.getStepSound(), 0.15F, 1.0F);
	   }	
	   
	   //Animations
	   @Override
		public EntityAnimationManager getAnimationManager() {
			
			return manager;
		}	
		
		private <E extends FireDemon> boolean animationPredicate(AnimationTestEvent<E> event) {
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
