package name.modid.block;

import name.modid.Monkeysmod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Cheese_block extends Block {

    public static final IntProperty LAYERS = Properties.LAYERS;

    public Cheese_block(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(LAYERS, 8));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        // Adjust the height of the hitbox based on the number of layers
        return VoxelShapes.cuboid(0.0D, 0.0D, 0.0D, 1.0D, state.get(LAYERS) / 8.0D, 1.0D);
    }



    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos , PlayerEntity player, Hand hand, BlockHitResult hit) {
        // Check if the player is holding a stick
        if (player.getMainHandStack().getItem() == Items.STICK) {
            // If the Cheese_block has more than one layer
            if (state.get(LAYERS) > 1) {
                // Decrease the number of layers by one
                world.setBlockState(pos, state.with(LAYERS, state.get(LAYERS) - 1));
                dropStack(world, pos, new ItemStack(Monkeysmod.CHEESE_SLICE));
                return ActionResult.SUCCESS;
            } else {
                dropStack(world, pos, new ItemStack(Monkeysmod.CHEESE_SLICE));
                // Destroy the block
                world.breakBlock(pos, true);
                return ActionResult.SUCCESS;
            }

        } else if (player.getMainHandStack().getItem() == Items.IRON_BARS) {

            if (state.get(LAYERS) > 1) {
                world.setBlockState(pos, state.with(LAYERS, state.get(LAYERS)- 1));

                dropStack(world, pos, new ItemStack(Monkeysmod.GRATED_CHEESE));
                return ActionResult.CONSUME;
            } else {
            // If the player is holding iron bars
            // Drop a carrot
            dropStack(world, pos, new ItemStack(Monkeysmod.GRATED_CHEESE));
            // Destroy the block
            world.breakBlock(pos, true);
            return ActionResult.CONSUME;
        }
    }
        return ActionResult.FAIL;
    }
    
    
}
