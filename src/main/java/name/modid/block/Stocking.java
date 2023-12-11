package name.modid.block;

import java.util.ArrayList;
import java.util.Random;

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

public class Stocking extends Block {

    public static final IntProperty AGE = Properties.AGE_1;
    private static final VoxelShape SHAPE = VoxelShapes.fullCube();

    public Stocking(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(AGE, 0));
    }

        @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos , PlayerEntity player, Hand hand, BlockHitResult hit) {
        ArrayList<ItemStack> nicelist = new ArrayList<ItemStack>();
        
        nicelist.add(new ItemStack(Items.DIAMOND));
        nicelist.add(new ItemStack(Items.EMERALD));
        nicelist.add(new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE));
        nicelist.add(new ItemStack(Items.ECHO_SHARD));
        nicelist.add(new ItemStack(Items.ENCHANTED_GOLDEN_APPLE));
        nicelist.add(new ItemStack(Monkeysmod.HARM_BAT));

        Random rand = new Random();
        int santassack = rand.nextInt(nicelist.size());
        ItemStack santasgift = nicelist.get(santassack);
                
        if (state.get(AGE) == 1) {
            dropStack(world, pos, santasgift);
            world.setBlockState(pos, state.with(AGE, 0));
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }

    }
}

