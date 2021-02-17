package com.saita.hardmodemod.entities;

import com.saita.hardmodemod.init.SoundInit;
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
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
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

public class Werewolf extends MonsterEntity implements IAnimatedEntity {
	
private EntityAnimationManager manager = new EntityAnimationManager();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AnimationController controller = new EntityAnimationController(this, "moveController", 10,
			this::animationPredicate);
	
	public Werewolf(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		registerAnimationControllers();
		this.experienceValue = 16;
		
	}
	
	protected boolean shouldBurnInDay() {
	      return true;
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
		  this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(90.0D);
		  this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
	      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30D);
	      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
	}
	
	
	
	
	public void livingTick() {
	      if (this.isAlive()) {
	    	 
	    	//Instantly makes the mob despawn if Hardmode is off
	    	if(world.getGameTime() < HardmodeGameTimeConstant.HardmodeGameTime)
	      	{
	    	  this.remove(addedToChunk);
	      	}
	    	
	    	//To make the werewolf jump 2 blocks.
	    	this.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 1, false, false));
	    	
	    	 //Burns at day
	         boolean flag = this.shouldBurnInDay() && this.isInDaylight();
	         if (flag) {
	            ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.HEAD);
	            if (!itemstack.isEmpty()) {
	               if (itemstack.isDamageable()) {
	                  itemstack.setDamage(itemstack.getDamage() + this.rand.nextInt(2));
	                  if (itemstack.getDamage() >= itemstack.getMaxDamage()) {
	                     this.sendBreakAnimation(EquipmentSlotType.HEAD);
	                     this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
	                  }
	               }

	               flag = false;
	            }

	            if (flag) {
	               this.setFire(8);
	            }
	         }
		    
	      }

	      super.livingTick();
	   }
	
	// Gives Hunger to entity it attacks
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
	         if (entityIn instanceof LivingEntity) {
	        	 ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.HUNGER, 150, 1));
	         }
	      }
		return super.attackEntityAsMob(entityIn);
	}
	

	// Sounds
	  protected SoundEvent getAmbientSound() {
	      return SoundInit.WEREWOLF_AMBIENT.get();
	   }

	   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	      return SoundInit.WEREWOLF_HIT.get();
	   }

	   protected SoundEvent getDeathSound() {
	      return SoundInit.WEREWOLF_DEATH.get();
	   }

	   protected SoundEvent getStepSound() {
	      return SoundEvents.ENTITY_WOLF_STEP;
	   }

	   protected void playStepSound(BlockPos pos, BlockState blockIn) {
	      this.playSound(this.getStepSound(), 0.15F, 1.0F);
	   }	
	   
	   //Animations
	   @Override
	 		public EntityAnimationManager getAnimationManager() {
	 			
	 			return manager;
	 		}	
	 		
	 		private <E extends Werewolf> boolean animationPredicate(AnimationTestEvent<E> event) {
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
