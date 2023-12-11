package name.modid.monsters.custom;

import com.google.common.base.Predicate;

import name.modid.monsters.ModEntities;
import name.modid.monsters.pizzatopping.PizzaTopping;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.FlyGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

public class PizzaBoss extends HostileEntity implements RangedAttackMob {
    private static final Predicate<LivingEntity> CAN_ATTACK_PREDICATE = entity -> entity.getGroup() != EntityGroup.UNDEAD && entity.isMobOrPlayer();

    public PizzaBoss(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 10, false);
    }

    @Override
    protected EntityNavigation createNavigation(World world) { //can fly now?
        BirdNavigation birdNavigation = new BirdNavigation(this, world);
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(true);
        birdNavigation.setCanEnterOpenDoors(true);
        return birdNavigation;
    }

    @Override
    protected void initGoals() //tell the brain what to do workshop
    {
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1.0, 40, 20.0f));
        this.goalSelector.add(5, new FlyGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new ActiveTargetGoal<LivingEntity>(this, LivingEntity.class, 0, false, false, CAN_ATTACK_PREDICATE));

    }


    public static DefaultAttributeContainer.Builder createPizzaBossAttributeBuilder() { //build a brain workshop
        return HostileEntity.createHostileAttributes()
        .add(EntityAttributes.GENERIC_MAX_HEALTH, 300.0)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6f)
        .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6f)
        .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40.0)
        .add(EntityAttributes.GENERIC_ARMOR, 4.0);
        
    }

        private double getHeadX(int headIndex) {
        if (headIndex <= 0) {
            return this.getX();
        }
        float f = (this.bodyYaw + (float)(180 * (headIndex - 1))) * ((float)Math.PI / 180);
        float g = MathHelper.cos(f);
        return this.getX() + (double)g * 1.3;
    }

    private double getHeadY(int headIndex) {
        if (headIndex <= 0) {
            return this.getY() + 3.0;
        }
        return this.getY() + 2.2;
    }

    private double getHeadZ(int headIndex) {
        if (headIndex <= 0) {
            return this.getZ();
        }
        float f = (this.bodyYaw + (float)(180 * (headIndex - 1))) * ((float)Math.PI / 180);
        float g = MathHelper.sin(f);
        return this.getZ() + (double)g * 1.3;
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        this.shootToppingsAt(0, target);
    }

        private void shootToppingsAt(int headIndex, LivingEntity target) {
        this.shootToppingsAt(headIndex, target.getX(), target.getY() + (double)target.getStandingEyeHeight() * 0.5, target.getZ(), headIndex == 0 && this.random.nextFloat() < 0.001f);
    }

    private void shootToppingsAt(int headIndex, double targetX, double targetY, double targetZ, boolean charged) {
        if (!this.isSilent()) {
            this.getWorld().syncWorldEvent(null, WorldEvents.WITHER_SHOOTS, this.getBlockPos(), 0);
        }
        double d = this.getHeadX(headIndex);
        double e = this.getHeadY(headIndex);
        double f = this.getHeadZ(headIndex);
        double g = targetX - d;
        double h = targetY - e;
        double i = targetZ - f;
        PizzaTopping pizzaTopping = new PizzaTopping(ModEntities.PIZZA_TOPPING, this.getWorld(), g, h, i);
        pizzaTopping.setVelocity(this.getRotationVector().multiply(1.0));
        pizzaTopping.setOwner(this);
        pizzaTopping.setPos(d, e, f);
        this.getWorld().spawnEntity(pizzaTopping);
    }

}
