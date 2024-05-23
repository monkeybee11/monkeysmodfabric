package name.modid.items;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Digger extends ShovelItem {

    public Digger(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, (p) -> {
                p.sendToolBreakStatus(miner.getActiveHand());
            });

            // Break blocks in a 3x3 grid
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    for (int z = -1; z <= 1; z++) {
                        BlockPos targetPos = pos.add(x, y, z);
                        BlockState targetState = world.getBlockState(targetPos);
                        if (this.isSuitableFor(targetState)) {
                            world.breakBlock(targetPos, true, miner);
                        }
                    }
                }
            }
        }

        return true;
    }
}