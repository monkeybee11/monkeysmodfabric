package name.modid.throwing_things;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import java.util.function.Consumer;
import org.joml.Random;

public class Coconut_Shell extends SnowballEntity {
	
	private final int damage;
	private final Consumer<Coconut_Shell> onCollide;
	
	public Coconut_Shell(World world, LivingEntity owner, int damage, Consumer<Coconut_Shell> onCollide) {
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

