package com.saita.hardmodemod.entities;

import com.saita.hardmodemod.init.SoundInit;
import com.saita.hardmodemod.util.HardmodeGameTimeConstant;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class DemonEye extends PhantomEntity implements IAnimatedEntity {
	
private EntityAnimationManager manager = new EntityAnimationManager();

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private AnimationController controller = new EntityAnimationController(this, "moveController", 10,
		   this::animationPredicate);

     public DemonEye(EntityType<? extends PhantomEntity> type, World worldIn) {
	       super(type, worldIn);
	       registerAnimationControllers();
	       this.experienceValue = 16;
       }
     
     
    @Override
 	public boolean isEntityUndead() {
 		return true;
 	}
    

	@Override
	protected void registerAttributes() {
		
		  super.registerAttributes();
		  this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(75.0D);
	      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(13.5D);
	      this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
	}

	
	public void livingTick() {
	      if (this.isAlive()) {
	    	  
	    	//Instantly makes the mob despawn if Hardmode is off
	    	if(world.getGameTime() < HardmodeGameTimeConstant.HardmodeGameTime)
	      	{
	    		this.remove(addedToChunk);
	      	}
	    	
	    	//Instantly despawns when it's day time.
	    	if(world.isDaytime() && !world.isRemote)
	    	{
	    		this.remove(addedToChunk);
	    	}
		    
	      }

	      super.livingTick();
	   }
	

	// Sounds
	  protected SoundEvent getAmbientSound() {
	      return null;
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
	
	private <E extends DemonEye> boolean animationPredicate(AnimationTestEvent<E> event) {
		controller.setAnimation(new AnimationBuilder().addAnimation("animation.hardmode.fly").addAnimation("animation.hardmode.fly", true));	
		return true;		
	 		
	}
	
	private void registerAnimationControllers()
	{
		manager.addAnimationController(controller);
	}

}
