package name.modid.items;

import java.util.Random;

import name.modid.Monkeysmod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class Pineapple_cored extends Item {

    public Pineapple_cored(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);

        if (state.getBlock() == Blocks.STONECUTTER && context.getSide() == Direction.UP && context.getPlayer().isSneaking()) {
            if (!world.isClient) { // Make sure to only spawn items on the server side
                Random random = new Random();
                int pineapplerandom = 2 + random.nextInt(4);
                for (int i = 0; i < pineapplerandom; i++) {
                ItemEntity pineapple_ring = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Monkeysmod.PINEAPPLE_RING));
                world.spawnEntity(pineapple_ring);}
                context.getStack().decrement(1); // Decrease the item count by 1
            }
            return ActionResult.SUCCESS;
        }

        return super.useOnBlock(context);
    }
}