package name.modid.items;

import java.util.Map;
import java.util.UUID;

import name.modid.PlayerDataManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Copy_of_santas_list extends Item {
    private final Map<UUID, Integer> playerData;

    public Copy_of_santas_list(Settings setting, Map<UUID, Integer> playerData) {
        super(setting);
        this.playerData = playerData;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (!world.isClient) {
            UUID uuid = playerEntity.getUuid();
            PlayerDataManager.loadPlayerData();
           playerData.clear();
            playerData.putAll(PlayerDataManager.getPlayerData()); // Update the playerData map
            if (playerData.containsKey(uuid)) {
                int karma = playerData.get(uuid);
                if (karma > 0) {
                    playerEntity.sendMessage(Text.of("You're on the nice list! Your nice score is " + karma), true);
                } else if (karma == 0) {
                    playerEntity.sendMessage(Text.of("Your in the middle your nice score is " + karma), true);
                } else {
                    playerEntity.sendMessage(Text.of("You're on the naughty list! Your nice score is " + karma), true);
                }
            } else {
                playerEntity.sendMessage(Text.of("Your score is not available."), true); // Default message
            }
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }
    
    
}
