package name.modid.event;

import name.modid.Monkeysmod;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class Bubble_bottleing implements ModInitializer {

    @Override
    public void onInitialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            //player.sendMessage(Text.of("yep"), true);
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.getBlock() == Blocks.BUBBLE_COLUMN) {
                if (player.getStackInHand(hand).getItem() == Items.GLASS_BOTTLE) {
                    player.getMainHandStack().decrement(1);
                    player.getInventory().offerOrDrop(new ItemStack(Monkeysmod.BUBBLE_BOTTLE));
                    //player.sendMessage(Text.of("BUBBLES"), true);
                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.PASS;
        });
    }
}
