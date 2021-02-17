package com.saita.hardmodemod.entities;

import com.saita.hardmodemod.init.SoundInit;
import com.saita.hardmodemod.util.HardmodeGameTimeConstant;

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
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Reaper extends MonsterEntity {

	public Reaper(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		this.experienceValue = 20;
		
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
		  this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(85.0D);
		  this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
	      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
	      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(19.5D);
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
	
	  // Reaper regenerates himself on attack
		@Override
		public boolean attackEntityAsMob(Entity entityIn) {
			if (super.attackEntityAsMob(entityIn)) {
			       if (entityIn instanceof LivingEntity) {
			         this.addPotionEffect(new EffectInstance(Effects.REGENERATION, 80, 3));
			        }
			     }
			return super.attackEntityAsMob(entityIn);
		}
	

	// Sounds
	  protected SoundEvent getAmbientSound() {
	      return SoundInit.REAPER_AMBIENT.get();
	   }

	   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	      return SoundInit.REAPER_HIT.get();
	   }

	   protected SoundEvent getDeathSound() {
	      return SoundInit.REAPER_DEATH.get();
	   }

	   protected SoundEvent getStepSound() {
	      return null;
	   }
	     
}
