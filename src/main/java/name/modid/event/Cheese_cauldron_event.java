package name.modid.event;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import name.modid.Monkeysmod;

public class Cheese_cauldron_event implements ModInitializer {
    @Override
    public void onInitialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.getBlock() == Blocks.CAULDRON) {
                // Check if the player is holding a milk bucket
                if (player.getStackInHand(hand).getItem() == Items.MILK_BUCKET) {
                    // Replace the milk bucket with an empty bucket in the player's hand
                    player.setStackInHand(hand, new ItemStack(Items.BUCKET));

                    // Replace the cauldron with a milk cauldron block
                    world.setBlockState(pos, Monkeysmod.MILK_CAULDRON.getDefaultState());

                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.PASS;
        });
    }
}

