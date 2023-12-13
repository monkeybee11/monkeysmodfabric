package name.modid.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.ScoreboardPlayerScore;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Copy_of_santas_list extends Item {

    public Copy_of_santas_list(Settings setting) {
        super(setting);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (!world.isClient) {
            MinecraftServer server = world.getServer();
            if (server != null) {
                Scoreboard scoreboard = server.getScoreboard();
                ScoreboardObjective karmaObjective = scoreboard.getObjective("karma");
                if (karmaObjective != null) {
                    ScoreboardPlayerScore karmaScore = scoreboard.getPlayerScore(playerEntity.getName().getString(), karmaObjective);
                    int karma = karmaScore.getScore();
                    if (karma > 0) {
                        playerEntity.sendMessage(Text.of("You're on the nice list! Your nice score is " + karma), true);
                    } else if (karma == 0) {
                        playerEntity.sendMessage(Text.of("You're in the middle. Your nice score is " + karma), true);
                    } else {
                        playerEntity.sendMessage(Text.of("You're on the naughty list! Your nice score is " + karma), true);
                    }
                } else {
                    playerEntity.sendMessage(Text.of("Your score is not available."), true); // Default message
                }
            }
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }
    
}
