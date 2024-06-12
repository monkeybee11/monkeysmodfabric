package name.modid.throwing_things;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import java.util.function.Consumer;
import name.modid.monsters.ModEntities;
import name.modid.monsters.custom.BananaPeelEntity;


public class Banana_peel extends SnowballEntity {
	
	private final Consumer<Banana_peel> onCollide;
	
	public Banana_peel(World world, LivingEntity owner, Consumer<Banana_peel> onCollide) {
		super(world, owner);
		this.onCollide = onCollide;
	}

	@Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        BananaPeelEntity bananaEntityentity = new BananaPeelEntity(ModEntities.BANANAPEEL, this.getWorld());
        bananaEntityentity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), distanceTraveled, distanceTraveled);
        this.getWorld().spawnEntity(bananaEntityentity);
        
        onCollide.accept(this);
    }
}
