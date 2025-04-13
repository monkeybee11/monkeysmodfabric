package name.modid.items;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Carrot_drill extends PickaxeItem {

    public Carrot_drill(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
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

    @Override
    public boolean isSuitableFor(BlockState state) {
        // Prevent the pickaxe from breaking blocks that are ores
        return !state.isIn(BlockTags.COAL_ORES) && !state.isIn(BlockTags.GOLD_ORES) && !state.isIn(BlockTags.IRON_ORES) && !state.isIn(BlockTags.LAPIS_ORES) && !state.isIn(BlockTags.COPPER_ORES) && !state.isIn(BlockTags.DIAMOND_ORES) && !state.isIn(BlockTags.EMERALD_ORES) && !state.isIn(BlockTags.REDSTONE_ORES) && super.isSuitableFor(state);
    }
}
