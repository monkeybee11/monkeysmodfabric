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
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.ScoreboardPlayerScore;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class Stocking extends Block {

    public static final IntProperty AGE = Properties.AGE_1;
    private static final VoxelShape SHAPE = VoxelShapes.fullCube();
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

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
        // Check if we are on the server side
        if (!world.isClient) {
            ArrayList<ItemStack> nicelist = new ArrayList<ItemStack>();
            ArrayList<ItemStack> naughtylist = new ArrayList<ItemStack>();
        
            nicelist.add(new ItemStack(Items.DIAMOND));
            nicelist.add(new ItemStack(Items.EMERALD));
            nicelist.add(new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE));
            nicelist.add(new ItemStack(Items.ECHO_SHARD));
            nicelist.add(new ItemStack(Items.ENCHANTED_GOLDEN_APPLE));
            nicelist.add(new ItemStack(Monkeysmod.HARM_BAT));
        
            naughtylist.add(new ItemStack(Items.COAL));
            naughtylist.add(new ItemStack(Items.CHARCOAL));
        
            Random rand = new Random();
            int badsack = rand.nextInt(naughtylist.size());
            ItemStack badgift = naughtylist.get(badsack);
        
            int santassack = rand.nextInt(nicelist.size());
            ItemStack santasgift = nicelist.get(santassack);
        
            Scoreboard scoreboard = player.getServer().getScoreboard();
            ScoreboardObjective karmaObjective = scoreboard.getObjective("karma");
            ScoreboardPlayerScore karmaScore = scoreboard.getPlayerScore(player.getEntityName(), karmaObjective);
                    
            if (state.get(AGE) == 1) {
                if (karmaScore.getScore() >= 100) {
                    if (rand.nextInt(20) == 0) { // 1 in 20 chance
                        // Spawn SantaPig near the player
                        dropStack(world, pos, new ItemStack(Monkeysmod.SANTA_PIG_SPAWN_EGG));
                    } else {
                        dropStack(world,pos,santasgift);
                    }
                }
                else if (karmaScore.getScore() >= 0) {
                    dropStack(world, pos, santasgift);
                } else if (karmaScore.getScore() < 0) {
                    dropStack(world, pos, badgift);
                }
                world.setBlockState(pos, state.with(AGE, 0));
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.PASS;
            }
        }
        return ActionResult.PASS; // Add this line
    }

    public DefaultedList<ItemStack> getInventory() {
        return this.inventory;
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {

        for (ItemStack itemStack : this.getInventory()) {
            if (!itemStack.isEmpty()) {
                Stocking.dropStack((World) world, pos, itemStack);
            }
        }

        super.onBroken(world, pos, state);
    }

}

