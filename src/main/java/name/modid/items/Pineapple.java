package name.modid.items;

import name.modid.Monkeysmod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;



public class Pineapple extends Item {

    public Pineapple(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);
    
        if (state.getBlock() == Blocks.END_ROD && context.getSide() == Direction.UP) {
            if (!world.isClient) { // Make sure to only spawn items on the server side
                ItemEntity pineapple_cored = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Monkeysmod.PINEAPPLE_CORED));
                ItemEntity pineapple_stem = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Monkeysmod.PINEAPPLE_STEM));
                world.spawnEntity(pineapple_cored);
                world.spawnEntity(pineapple_stem);
                context.getStack().decrement(1);
            }
            return ActionResult.SUCCESS;
        }
    
        return super.useOnBlock(context);
    }
    
}
