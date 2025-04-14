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
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.block.Blocks;

public class Lighting_catcher extends Block {

    public static final IntProperty AGE = Properties.AGE_2;
    public static final VoxelShape Y_SHAPE = Block.createCuboidShape(6.5, 0.0, 6.5, 9.5, 16.0, 9.5);


    public Lighting_catcher(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(AGE, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Y_SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            ItemStack heldItem = player.getStackInHand(hand);
            int currentAge = state.get(Properties.AGE_2);
            // if the age is 0 then theres no bottle on the catcher
            //if the player has 4 or more bottles in there hand adds 4 bottles to the catcher
            if (currentAge == 0 && heldItem.getItem() == Items.GLASS_BOTTLE && player.getMainHandStack().getItem() == Items.GLASS_BOTTLE && heldItem.getCount() >= 4) {
                player.getMainHandStack().decrement(4);
                world.setBlockState(pos, state.with(Properties.AGE_2, 1));
                return ActionResult.SUCCESS;
            }

            if (currentAge == 2) {
                ItemStack stack = new ItemStack(Monkeysmod.LIGHTING_BOTTLE, 4);
                dropStack(world, pos, stack);
                world.setBlockState(pos, state.with(Properties.AGE_2, 0));
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        // Check if the neighbor above this block is a powered lightning rod
        if (neighborState.isOf(Blocks.LIGHTNING_ROD) && neighborState.get(Properties.POWERED) && direction == Direction.UP) {
            // Check if the current block's age is 1
            if (state.get(AGE) == 1) {
                // Schedule a tick to safely update the state
                if (world instanceof World) {
                    ((World) world).scheduleBlockTick(pos, this, 1);
                    return state.with(Properties.AGE_2, 2); // return the state of age2
                }
            }
        }
        return state; // Return the current state without modifying it directly
    }

}