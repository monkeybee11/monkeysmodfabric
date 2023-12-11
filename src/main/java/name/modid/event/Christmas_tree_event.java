package name.modid.event;

import name.modid.monsters.ModEntities;
import name.modid.monsters.custom.ChristmasTreeEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class Christmas_tree_event implements ModInitializer {

    @Override
    public void onInitialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            ItemStack stack = player.getStackInHand(hand);

            if (player.isSneaking() && state.getBlock() == Blocks.DECORATED_POT && stack.getItem() == Items.SPRUCE_SAPLING) {
                // Remove the Decorated Pot and the Spruce Sapling from the player's inventory
                world.breakBlock(pos, false);
                stack.decrement(1);

                // Spawn the ChristmasTreeEntity
                ChristmasTreeEntity christmasTree = ModEntities.CHRISTMAS_TREE.create(world);
                if (christmasTree != null) {
                    christmasTree.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0.0F, 0.0F);
                    christmasTree.getInventory().set(0, new ItemStack(Items.SPRUCE_SAPLING));
                    christmasTree.getInventory().set(1, new ItemStack(Blocks.DECORATED_POT));
                    world.spawnEntity(christmasTree);
                }

                return ActionResult.SUCCESS;
            }

            return ActionResult.PASS;
        });
    }
    
}
