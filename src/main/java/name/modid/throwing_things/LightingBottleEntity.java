package name.modid.throwing_things;

import java.util.function.Consumer;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class LightingBottleEntity extends SnowballEntity {
	
	private final Consumer<LightingBottleEntity> onCollide;
	
	public LightingBottleEntity(World world, LivingEntity owner, Consumer<LightingBottleEntity> onCollide) {
		super(world, owner);
		this.onCollide = onCollide;
	}

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);

        if (!this.getWorld().isClient) {
            LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, this.getWorld());
            lightningEntity.refreshPositionAfterTeleport(this.getX(), this.getY(), this.getZ());
            this.getWorld().spawnEntity(lightningEntity);
        }

        onCollide.accept(this);

        this.discard();
    }
}
