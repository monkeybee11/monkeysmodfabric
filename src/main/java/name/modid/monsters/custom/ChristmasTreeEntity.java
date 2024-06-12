package name.modid.monsters.custom;

import java.util.Collections;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer.Builder;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class ChristmasTreeEntity extends LivingEntity {
    private final World world;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10, ItemStack.EMPTY);

    public ChristmasTreeEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
        this.world = world;
    }

    public static Builder createChristmasTreeAttributeBuilder() {
        return LivingEntity.createLivingAttributes();
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return Collections.emptyList();
    }

    public DefaultedList<ItemStack> getInventory() {
    return this.inventory;
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        int inventorySlot = slot.getEntitySlotId();
        return inventorySlot < this.inventory.size() ? this.inventory.get(inventorySlot) : ItemStack.EMPTY;
    }

    @Override
    protected void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
        super.dropEquipment(source, lootingMultiplier, allowDrops);

        // Drop all items in the inventory
        for (ItemStack itemStack : this.getInventory()) {
            if (!itemStack.isEmpty()) {
                this.dropStack(itemStack);
            }
        }
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {
        this.inventory.set(slot.getEntitySlotId(), stack);
    }

    @Override
    public Arm getMainArm() {
        return Arm.RIGHT;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void pushAway(Entity entity) {
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        boolean alreadyHasItem = this.inventory.stream().anyMatch(stack -> stack.getItem() == itemStack.getItem());
        if (!alreadyHasItem) {
            if (itemStack.getItem() == Items.GOLD_NUGGET || itemStack.getItem() == Items.WHITE_WOOL || itemStack.getItem() == Items.TORCH) {
                int openSlot = getInventory().indexOf(ItemStack.EMPTY);
                if (openSlot != -1) {
                    this.inventory.set(openSlot, new ItemStack(itemStack.getItem()));
                    itemStack.decrement(1);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }
    
    public World getWorld() {
        return this.world;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);

        // Write inventory to NBT
        NbtList inventoryList = new NbtList();
        for (int i = 0; i < this.inventory.size(); i++) {
            if (!this.inventory.get(i).isEmpty()) {
                NbtCompound itemNbt = new NbtCompound();
                itemNbt.putByte("Slot", (byte)i);
                this.inventory.get(i).writeNbt(itemNbt);
                inventoryList.add(itemNbt);
            }
        }
        nbt.put("Inventory", inventoryList);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);

        // Read inventory from NBT
        NbtList inventoryList = nbt.getList("Inventory", 10);
        for (int i = 0; i < inventoryList.size(); i++) {
            NbtCompound itemNbt = inventoryList.getCompound(i);
            int slot = itemNbt.getByte("Slot");
            if (slot >= 0 && slot < this.inventory.size()) {
                this.inventory.set(slot, ItemStack.fromNbt(itemNbt));
            }
        }
    }
}
