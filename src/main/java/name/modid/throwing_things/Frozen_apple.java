package name.modid.throwing_things;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import java.util.function.Consumer;

import org.joml.Random;

public class Frozen_apple extends SnowballEntity {
	
	private final int damage;
	private final Consumer<Frozen_apple> onCollide;
	
	public Frozen_apple(World world, LivingEntity owner, int damage, Consumer<Frozen_apple> onCollide) {
		super(world, owner);
		this.damage = damage;
		this.onCollide = onCollide;
	}
	
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        Random random = new Random();
        float randomDamage = 1 + random.nextFloat() * (3 - 1);
        int i;
        if (entity instanceof Entity) {
            i = damage + Math.round(randomDamage);
        } else if (entity instanceof BlazeEntity) {
            i = damage + 6;
        } else {
            i = damage;
        }
        entity.damage(entity.getWorld().getDamageSources().thrown(this, this.getOwner()), (float)i);
    }
    
	
	@Override
	protected void onCollision(HitResult hitResult) {
		onCollide.accept(this);
		super.onCollision(hitResult);
	}
}
