package name.modid.block;


import name.modid.Monkeysmod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.state.property.Properties;


public class Coconut_crop extends CropBlock {

    public static final IntProperty AGE = Properties.AGE_2;
    public static final VoxelShape Y_SHAPE = createCuboidShape(3.0D, 6.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    public Coconut_crop(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState block = world.getBlockState(pos.offset(Direction.UP));
        return block.isIn(BlockTags.LEAVES);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Y_SHAPE;
    }

    @Override
    public boolean canGrow(World minecraft, Random random, BlockPos pos, BlockState state) {
        return super.canGrow(minecraft, random, pos, state);
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }
 
    @Override
    public int getMaxAge() {
        return 2;
    }



    @Override
    public void onBreak(World world_1, BlockPos blockPos_1, BlockState blockState_1, PlayerEntity playerEntity_1) {
        super.onBreak(world_1, blockPos_1, blockState_1, playerEntity_1);
    }


    @Override
     protected ItemConvertible getSeedsItem() {
        return Monkeysmod.COCONUT_CROP;
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos , PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (getAge(state) >= 2) {
            ItemStack stack = new ItemStack(Monkeysmod.COCONUT_SHELL, world.random.nextInt(6) + 1);
            dropStack(world, pos, stack);
            world.setBlockState(pos, state.with(AGE, 0));
        }
        return ActionResult.SUCCESS;
    }
    
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}