package name.modid.block;

import name.modid.Monkeysmod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class Mince_pie_crop extends CropBlock {

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]
    {
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)
    };

    public Mince_pie_crop(Settings settings) {
        super(settings.nonOpaque());
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return Monkeysmod.MINCE_PIE_CROP;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }

    
    public Identifier getDropTableId() {
        return new Identifier("monkeysmod", "blocks/mincepie_crop");
    }
    

}