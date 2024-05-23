package name.modid.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Head_printer extends Block {
    public Head_printer(Settings settings){
        super(settings);
    }
    public static final VoxelShape printer_shape = createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 10.0D, 15.0D);


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return printer_shape;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            ItemStack mainHandItem = player.getMainHandStack();
            ItemStack offHandItem = player.getOffHandStack();

            if (mainHandItem.getItem() == Items.PLAYER_HEAD && offHandItem.getItem() == Items.NAME_TAG) {
                String nameTag = offHandItem.getName().getString();
                NbtCompound tag = mainHandItem.getOrCreateNbt();
                tag.putString("SkullOwner", nameTag);
                player.getOffHandStack().decrement(1);

                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

}
