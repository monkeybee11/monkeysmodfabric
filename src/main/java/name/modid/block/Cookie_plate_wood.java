package name.modid.block;


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
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Cookie_plate_wood extends Block {

    public static final IntProperty AGE = Properties.AGE_2;
    public static final VoxelShape SHAPE = VoxelShapes.fullCube();

    public Cookie_plate_wood(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(AGE, 0));
    }

        @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

        @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
    
    public Identifier getDropTableId() {
        return new Identifier("monkeysmod", "blocks/cookie_plate_wood");
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,BlockHitResult hit) {

        if (player.getMainHandStack().getItem() == Items.COOKIE && state.get(AGE) == 0) {
            player.getMainHandStack().decrement(1);
            world.setBlockState(pos, state.with(AGE, 1));
            return ActionResult.SUCCESS;
        }
        if (player.getMainHandStack().getItem() == Items.WET_SPONGE && player.getOffHandStack().getItem() == Items.MILK_BUCKET && state.get(AGE) == 2) {
            player.getMainHandStack().decrement(1);
            player.getOffHandStack().decrement(1);
            world.setBlockState(pos, state.with(AGE, 0));
            dropStack(world, pos, new ItemStack(Items.SPONGE));
            dropStack(world, pos, new ItemStack(Items.BUCKET));
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }
}
