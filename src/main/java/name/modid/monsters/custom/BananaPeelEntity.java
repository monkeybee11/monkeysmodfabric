package name.modid.monsters.custom;

import java.util.Collections;

import name.modid.Monkeysmod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer.Builder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BananaPeelEntity extends LivingEntity {

    public BananaPeelEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    public static Builder createBananaPeelAttributes() {
        return LivingEntity.createLivingAttributes();
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

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        this.remove(RemovalReason.KILLED);
        this.dropItem(Monkeysmod.BANANA_PEEL);
        player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);
        return ActionResult.success(dead);
    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        super.onPlayerCollision(player);
        // Increase the player's horizontal velocity to simulate slipping
        double slipSpeed = 9.0;  // Adjust this value to control the slip speed
        Vec3d velocity = player.getVelocity();
        player.setVelocity(velocity.x * slipSpeed, velocity.y, velocity.z * slipSpeed);
    }
}