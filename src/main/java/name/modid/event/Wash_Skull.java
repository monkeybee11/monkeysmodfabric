package name.modid.event;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;

public class Wash_Skull implements ModInitializer {

    @Override
    public void onInitialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            
            if (state.getBlock() == Blocks.WATER_CAULDRON) {
                int waterLevel = state.get(LeveledCauldronBlock.LEVEL);
                
                if (waterLevel > 0) {
                    if (player.getStackInHand(hand).getItem() == Items.WITHER_SKELETON_SKULL) {
                        player.getMainHandStack().decrement(1);
                        player.getInventory().offerOrDrop(new ItemStack(Items.SKELETON_SKULL));

                        world.setBlockState(pos, state.with(LeveledCauldronBlock.LEVEL, waterLevel - 1), 3);
                        world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                        
                        return ActionResult.SUCCESS;
                    }
                }
            }

            return ActionResult.PASS;
        });
    }
}
