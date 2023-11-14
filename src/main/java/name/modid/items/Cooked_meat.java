package name.modid.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class Cooked_meat extends Item {
    public Cooked_meat(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();

        if (!world.isClient && player != null && world.getBlockState(pos).getBlock() == Blocks.STONECUTTER && player.isSneaking()) {
            ItemStack stack = player.getStackInHand(hand);
            if (stack.getItem() == this && stack.getCount() > 0) {
                stack.decrement(1);
                dropRandomMeat(player);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    private void dropRandomMeat(PlayerEntity player) {
        ItemStack[] meats = new ItemStack[]{
            new ItemStack(Items.COOKED_BEEF),
            new ItemStack(Items.COOKED_PORKCHOP),
            new ItemStack(Items.COOKED_CHICKEN),
            new ItemStack(Items.COOKED_MUTTON),
            new ItemStack(Items.COOKED_RABBIT)
        };
        Random random = new Random();
        int count = random.nextInt(3) + 1; // random number between 1 and 3
        ItemStack meatToDrop = meats[random.nextInt(meats.length)];
        meatToDrop.setCount(count);
        player.giveItemStack(meatToDrop);
    }
}
