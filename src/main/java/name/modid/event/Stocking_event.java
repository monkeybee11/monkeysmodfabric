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
import name.modid.block.Stocking;

public class Stocking_event implements ModInitializer {
    @Override
    public void onInitialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            Stocking stocking = Monkeysmod.STOCKING;
            if (state.getBlock() == Blocks.TRIPWIRE_HOOK) {
                
                if (player.getStackInHand(hand).getItem() == Items.LEATHER_BOOTS || player.getStackInHand(hand).getItem() == Items.IRON_BOOTS || player.getStackInHand(hand).getItem() == Items.CHAINMAIL_BOOTS || player.getStackInHand(hand).getItem() == Items.GOLDEN_BOOTS || player.getStackInHand(hand).getItem() == Items.DIAMOND_BOOTS || player.getStackInHand(hand).getItem() == Items.NETHERITE_BOOTS)   {

                    world.setBlockState(pos, Monkeysmod.STOCKING.getDefaultState());
                    stocking.getInventory().set(0, new ItemStack(Items.TRIPWIRE_HOOK));
                    stocking.getInventory().set(1, player.getStackInHand(hand));
                    //player.getMainHandStack().decrement(1);

                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.PASS;
        });
    }
}
