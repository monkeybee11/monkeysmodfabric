package name.modid.block;

import name.modid.Monkeysmod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Pizza_block extends Block {

    public static final IntProperty SLICE = IntProperty.of("slice", 0 , 3);
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D); // Adjust these values to fit your model

    public Pizza_block(Settings settings) {
        super(settings.nonOpaque()); // This makes the block transparent
        setDefaultState(getStateManager().getDefaultState().with(SLICE, 3));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SLICE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE; // This sets the bounding box to the shape we defined
    }

@Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos , PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(SLICE) >= 1) { //check if slice is biggerraw then 1
            world.setBlockState(pos, state.with(SLICE, state.get(SLICE) - 1)); //remove 1 slice from the pizza
            dropStack(world, pos, new ItemStack(Monkeysmod.COOKED_PIZZA)); //drops the slice for hte player to pick up
            return ActionResult.SUCCESS; //YAY!!!!
        } else { //the only else woud be if slice == 1 right?
            dropStack(world, pos, new ItemStack(Monkeysmod.COOKED_PIZZA)); //drops the last slice for player to pick up
            world.breakBlock(pos, true);// brakes hte block
            return ActionResult.SUCCESS; //YAY!!!!
        }
    }
}
