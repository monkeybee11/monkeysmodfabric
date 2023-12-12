package name.modid.event;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import name.modid.PlayerDataManager;

import java.util.*;

public class naughty_nice_list_event implements ModInitializer {


    static HashMap<UUID, Integer> playerData = new HashMap<>();    

    @Override
    public void onInitialize() {

        // Load player data from file
        PlayerDataManager.loadPlayerData();

        // Simulate a player joining the game
        UUID playerUUID = UUID.randomUUID();
        playerJoined(playerUUID);

        // Save player data to file
        PlayerDataManager.savePlayerData();

        // Register an event listener for the CureZombieVillagerEvent
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient && entity.getType() == EntityType.ZOMBIE_VILLAGER && ((ZombieVillagerEntity) entity).isConverting()) {
                PlayerDataManager.loadPlayerData();
                UUID uuid = player.getUuid();
                if (playerData.containsKey(uuid)) {
                    playerData.put(uuid, playerData.get(uuid) + 1);
                    PlayerDataManager.savePlayerData();
                }
            }
            return ActionResult.PASS;

        });

        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
            if (!world.isClient && killedEntity instanceof PassiveEntity && entity instanceof PlayerEntity) {
                PlayerDataManager.loadPlayerData();
                UUID uuid = entity.getUuid();
                if (playerData.containsKey(uuid)) {
                    playerData.put(uuid, playerData.get(uuid) - 1);
                    PlayerDataManager.savePlayerData();
                }
            }
        });
    }

    public static void playerJoined(UUID playerUUID) {
        if (!playerData.containsKey(playerUUID)) {
            playerData.put(playerUUID, 0);
        }
    }
    
}
