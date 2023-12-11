package name.modid.monsters.pizzatopping;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import name.modid.monsters.ModEntities;



public class PizzaTopping extends ExplosiveProjectileEntity {

    public PizzaTopping(EntityType<? extends ExplosiveProjectileEntity> entityType, World world, double g, double h, double i) {
        super((EntityType<? extends ExplosiveProjectileEntity>)entityType, world);
    }

    public PizzaTopping(World world, LivingEntity owner, double directionX, double directionY, double directionZ) {
        super(ModEntities.PIZZA_TOPPING, world);
    }

    @Override
    public float getEffectiveExplosionResistance(Explosion explosion, BlockView world, BlockPos pos, BlockState blockState, FluidState fluidState, float max) {
        return max; // use the default explosion resistance
    }

    @Override
    public void setVelocity(double directionX, double directionY, double directionZ) {
        super.setVelocity(directionX, directionY, directionZ);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        if (entity instanceof Entity) {
            entity.damage(this.getDamageSources().magic(), 5.0f);
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        this.discard();
    }

    @Override
    protected void initDataTracker() {
    }
}

