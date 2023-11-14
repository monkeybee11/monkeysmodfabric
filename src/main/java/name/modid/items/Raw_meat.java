package name.modid.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class Raw_meat extends Item {
    public Raw_meat(Settings settings) {
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
            new ItemStack(Items.BEEF),
            new ItemStack(Items.PORKCHOP),
            new ItemStack(Items.CHICKEN),
            new ItemStack(Items.MUTTON),
            new ItemStack(Items.RABBIT),
            new ItemStack(Items.ROTTEN_FLESH)
        };
        Random random = new Random();
        int count = random.nextInt(3) + 1; // random number between 1 and 3
        ItemStack meatToDrop = meats[random.nextInt(meats.length)];
        meatToDrop.setCount(count);
        player.giveItemStack(meatToDrop);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.monkeysmod.raw_meat.tooltip"));
        } else {
            tooltip.add(Text.translatable("item.monkeysmod.item.tooltip"));
        }
    }
}
