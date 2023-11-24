package name.modid.block;

import name.modid.Monkeysmod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class Coconut_crop extends CropBlock {
    public static final int bottom_max_age = 7;
    public static final int top_max_age = 1;

    public static final IntProperty AGE = IntProperty.of("age", 0, 8);

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)};


    public Coconut_crop(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.SAND);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBaseLightLevel(pos, 0) >= 9) {
            int currentAge = this.getAge(state);
            if (currentAge < this.getMaxAge()) {
                if(currentAge == bottom_max_age) {
                    if(world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
                        world.setBlockState(pos.up(1), this.withAge( +1), 2);
                    }
                } else {
                    world.setBlockState(pos, this.withAge( +1), 2);
                }
            }
        }
    }

    @Override
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int nextAge = this.getAge(state) + this.getGrowthAmount(world);
        int maxAge = this.getMaxAge();
        if (nextAge > maxAge) {
            nextAge = maxAge;
        }

        if(this.getAge(state) ==  bottom_max_age && world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
            world.setBlockState(pos.up(1), this.withAge(nextAge), 2);
        } else {
            world.setBlockState(pos, this.withAge(nextAge - 1), 2);
        }

    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return super.canPlaceAt(state, world, pos) || (world.getBlockState(pos.down(1)).isOf(this) && world.getBlockState(pos.down(1)).get(AGE) == 7);
    }

    @Override
    public int getMaxAge() {
        return bottom_max_age + top_max_age;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return Monkeysmod.COCONUT_CROP;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
    
}
