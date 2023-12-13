package name.modid.monsters.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SantaPigEntity extends PigEntity {


    public SantaPigEntity(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
        this.initGoals();
    }

    @Override
    protected void initGoals() {
        super.initGoals();
    }

    @Override
    public boolean isSaddled() {
        return true;
    }

    public static DefaultAttributeContainer.Builder createSantaPigAttributeBuilder() {
        return MobEntity.createMobAttributes()
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
    }

    @Override
    public void fall(double heightDifference, boolean onGround, BlockState landedState, BlockPos landedPosition) {
        // This will make the Santa Pig immune to fall damage
    } 
}