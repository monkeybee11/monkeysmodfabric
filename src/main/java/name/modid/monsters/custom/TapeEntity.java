package name.modid.monsters.custom;

import java.util.Collections;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer.Builder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class TapeEntity extends LivingEntity {


    public TapeEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return Collections.emptyList();
    }
    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return activeItemStack;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {
    }

    @Override
    public Arm getMainArm() {
        return Arm.LEFT;
    }

    public static Builder createTapeAttributeBuilder() {
        return LivingEntity.createLivingAttributes();
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        this.remove(RemovalReason.KILLED);
        return ActionResult.success(dead);
    }

    @Override
    public void tick() {
        super.tick(); // Call the parent tick method
    
        // Get the closest player
        PlayerEntity player = getWorld().getClosestPlayer(this, 100);
    
        if (player != null) {
            // Calculate the difference in positions
            double deltaX = player.getX() - this.getX();
            double deltaZ = player.getZ() - this.getZ();
            
            // Calculate the target yaw
            float targetYaw = (float) MathHelper.atan2(deltaZ, deltaX) * (180F / (float) Math.PI) - 100F; // -90 to align forward
            
            // Smoothly rotate towards the player
            this.setYaw(this.getYaw() + MathHelper.wrapDegrees(targetYaw - this.getYaw()) * 0.1F);
        }
    }
    
}