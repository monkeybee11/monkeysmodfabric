package name.modid.items;

import name.modid.monsters.ModEntities;
import name.modid.monsters.custom.TapeEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Tape extends Item {

    private BlockPos firstPos = null; // Store first click position
    private TapeEntity tapeEntityMarker = null; // Store reference to the custom TapeEntity

    public Tape(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        BlockPos pos = context.getBlockPos();

        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        if (firstPos == null) {
            // First click: Store the position and spawn the TapeEntity
            firstPos = pos;
            player.sendMessage(Text.literal("First position set at: " + pos.toShortString()), false);

            // Spawn TapeEntity as a marker at the first position
            tapeEntityMarker = new TapeEntity(ModEntities.TAPE, world); 
            tapeEntityMarker.setPosition(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
            world.spawnEntity(tapeEntityMarker); 

            world.playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        } else {
            // Second click: Measure distance, remove the entity, and reset
            BlockPos secondPos = pos;

            // Calculate Manhattan Distance
            int manhattanDistance = Math.abs(firstPos.getX() - secondPos.getX()) 
                                    + Math.abs(firstPos.getY() - secondPos.getY()) 
                                    + Math.abs(firstPos.getZ() - secondPos.getZ());

            // Send message with Manhattan distance
            player.sendMessage(Text.literal("Second position set at: " + secondPos.toShortString() + ". Distance: " + manhattanDistance + " blocks"), false);

            // Remove the TapeEntity if it's still valid
            if (tapeEntityMarker != null && tapeEntityMarker.isAlive()) {
                tapeEntityMarker.remove(Entity.RemovalReason.DISCARDED);
                tapeEntityMarker = null; // Clear the reference to the entity
            }

            // Reset for next use
            firstPos = null;
        }

        return ActionResult.SUCCESS;
    }
}
