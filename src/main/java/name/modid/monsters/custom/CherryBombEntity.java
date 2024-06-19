package name.modid.monsters.custom;

import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.particle.ParticleTypes;

public class CherryBombEntity extends CreeperEntity {

    private int currentFuseTime;
    private int fuseTime = 30;
    private int explosionRadius = 3;

    public CherryBombEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createCherryAttributeBuilder() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }

    @Override
    public void tick() {
        if (this.isAlive()) {
            int i;
            if (this.isIgnited()) {
                this.setFuseSpeed(1);
            }
            if ((i = this.getFuseSpeed()) > 0 && this.currentFuseTime == 0) {
                this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0f, 0.5f);
                this.emitGameEvent(GameEvent.PRIME_FUSE);
            }
            this.currentFuseTime += i;
            if (this.currentFuseTime < 0) {
                this.currentFuseTime = 0;
            }
            if (this.currentFuseTime >= this.fuseTime) {
                this.currentFuseTime = this.fuseTime;
                this.explode();
            }
        }
        super.tick();
    }

    private void explode() {
        float f = this.shouldRenderOverlay() ? 2.0f : 1.0f;
        this.dead = true;
        this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), (float)this.explosionRadius * f, World.ExplosionSourceType.MOB);
    
        // Spawn cherry blossom particles
        for (int i = 0; i < 100; i++) {
            double motionX = this.random.nextGaussian() * 4.90;
            double motionY = this.random.nextGaussian() * 4.90;
            double motionZ = this.random.nextGaussian() * 4.90;
    
            this.getWorld().addParticle(ParticleTypes.CHERRY_LEAVES,
                                        this.getX() + this.random.nextDouble() * this.getWidth() * 2.0 - this.getWidth(),
                                        this.getY() + this.getHeight() / 2.0 + this.random.nextDouble() * this.getHeight(),
                                        this.getZ() + this.random.nextDouble() * this.getWidth() * 2.0 - this.getWidth(),
                                        motionX, motionY, motionZ);

            this.getWorld().addParticle(ParticleTypes.FIREWORK, 
                                        this.getX(), 
                                        this.getY() + this.getHeight() / 2.0, 
                                        this.getZ(), 
                                        (this.random.nextDouble() - 0.5) * 2.0, 
                                        (this.random.nextDouble() - 0.5) * 2.0, 
                                        (this.random.nextDouble() - 0.5) * 2.0);
        }
        
        this.discard();
    }
    
}
