package com.saita.hardmodemod.entities;

import javax.annotation.Nullable;

import com.saita.hardmodemod.init.SoundInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class EyeOfCthulhu extends VexEntity implements IAnimatedEntity {
	
private EntityAnimationManager manager = new EntityAnimationManager();
private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS));

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private AnimationController controller = new EntityAnimationController(this, "moveController", 10,
		   this::animationPredicate);
    
    public EyeOfCthulhu(EntityType<? extends VexEntity> p_i50190_1_, World p_i50190_2_) {
		super(p_i50190_1_, p_i50190_2_);
		registerAnimationControllers();
	    this.experienceValue = 1600;
	
	}


	@Override
	protected void registerAttributes() {
		
		  super.registerAttributes();
		  this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3500.0D);
	      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(29.0D); 
	      this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
	      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.2D);
	      this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
	}
	

	@Override
 	public boolean isEntityUndead() {
 		return true;
 	}
	
	//Can't despawn	
	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		
	return false;
	}
    
	
	//Boss Info Update
	protected void updateAITasks() {
    	super.updateAITasks();
    	this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }
     
	//Is Boss
	@Override
	public boolean isNonBoss() {
			
	return false;
	}
	
	//Boss Bar Name
	public void setCustomName(@Nullable ITextComponent name) {
	      super.setCustomName(name);
	      this.bossInfo.setName(this.getDisplayName());
	}
	
	//Boss Bar Display
	@Override
	public void addTrackingPlayer(ServerPlayerEntity player) {
	      super.addTrackingPlayer(player);
	      this.bossInfo.addPlayer(player);
	 }
	
	public void removeTrackingPlayer(ServerPlayerEntity player) {
	      super.removeTrackingPlayer(player);
	      this.bossInfo.removePlayer(player);
	   }

	
	//Eye of Cthulhu is much stronger during day and also gets a strength Boost if below half HP.
	public void livingTick() {
	      if (this.isAlive())
	      {
	    	  if(this.isInDaylight())
	    	  {
	    	  this.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 400, 3));
	    	  this.addPotionEffect(new EffectInstance(Effects.STRENGTH, 400, 5));
	    	  }
	    	  if(this.getHealth() <= 512.0F) //For some reason this.getHealth returns 1024.0F, so let's just half that
	    	  {
	    		  this.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 2));
	    	  }
	      }

	      super.livingTick();
	   }
	
	  // Blinds the entity it attacks + heals itself
	  @Override
	  public boolean attackEntityAsMob(Entity entityIn) {
		   if (super.attackEntityAsMob(entityIn)) {
			       if (entityIn instanceof LivingEntity) {
			        ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 150, 0));
			        this.heal(50);
			       }
			    }
			return super.attackEntityAsMob(entityIn);
		}
    
	

	// Sounds
	  protected SoundEvent getAmbientSound() {
	      return SoundInit.EYE_OF_CTHULHU_SCREAM.get();
	   }

	   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	      return SoundInit.EYE_HIT.get();
	   }

	   protected SoundEvent getDeathSound() {
	      return SoundInit.EYE_DEATH.get();
	   }

	   protected SoundEvent getStepSound() {
	      return null;
	   }
	   

	//Animations   
	@Override
	public EntityAnimationManager getAnimationManager() {

		return manager;
	}
	
	private <E extends EyeOfCthulhu> boolean animationPredicate(AnimationTestEvent<E> event) {
		controller.setAnimation(new AnimationBuilder().addAnimation("animation.hardmode.fly").addAnimation("animation.hardmode.fly", true));	
		return true;		
	 		
	}
	
	private void registerAnimationControllers()
	{
		manager.addAnimationController(controller);
	}

}
