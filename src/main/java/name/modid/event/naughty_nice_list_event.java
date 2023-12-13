package name.modid.event;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.ScoreboardPlayerScore;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

public class naughty_nice_list_event implements ModInitializer {
    private MinecraftServer server;
    public static final Map<UUID, Map<UUID, Long>> convertingZombieVillagers = new HashMap<>();


    @Override
    public void onInitialize() {

        ServerLifecycleEvents.SERVER_STARTED.register(server -> this.server = server);
        

        ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            if (entity instanceof PlayerEntity) {
                Scoreboard scoreboard = server.getScoreboard();
                ScoreboardObjective karmaObjective = scoreboard.getObjective("karma");
                if (karmaObjective == null) {
                    karmaObjective = scoreboard.addObjective("karma", ScoreboardCriterion.DUMMY, Text.of("Karma"), ScoreboardCriterion.RenderType.INTEGER);
                }
                ScoreboardPlayerScore karmaScore = scoreboard.getPlayerScore(entity.getName().getString(), karmaObjective);
                if (karmaScore.getScore() == 0) {
                    karmaScore.setScore(0); // Initialize karma to 0
                }
            }
        });

        // Register an event listener for the Cure zombie villager event
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient && entity instanceof ZombieVillagerEntity && player.getStackInHand(hand).getItem() == Items.GOLDEN_APPLE) {
                ZombieVillagerEntity zombieVillager = (ZombieVillagerEntity) entity;
                if (zombieVillager.hasStatusEffect(StatusEffects.WEAKNESS)) {
                    long currentTime = world.getTime();
                    convertingZombieVillagers.putIfAbsent(player.getUuid(), new HashMap<>());
                    Map<UUID, Long> playerMap = convertingZombieVillagers.get(player.getUuid());
                    if (!playerMap.containsKey(zombieVillager.getUuid()) || playerMap.get(zombieVillager.getUuid()) + 5*60*60 < currentTime) {
                        playerMap.put(zombieVillager.getUuid(), currentTime);
                        
                        Scoreboard scoreboard = player.getServer().getScoreboard();
                        ScoreboardObjective karmaObjective = scoreboard.getObjective("karma");
                        if (karmaObjective == null) {
                            karmaObjective = scoreboard.addObjective("karma", ScoreboardCriterion.DUMMY, Text.of("Karma"), ScoreboardCriterion.RenderType.INTEGER);
                        }
                        ScoreboardPlayerScore karmaScore = scoreboard.getPlayerScore(player.getEntityName(), karmaObjective);
                        karmaScore.setScore(karmaScore.getScore() + 1); // increase karma by 1

                        return ActionResult.SUCCESS;
                    }
                }
            }
            return ActionResult.PASS;
        });

        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
            if (!world.isClient && killedEntity instanceof PassiveEntity && entity instanceof PlayerEntity) {
                Scoreboard scoreboard = server.getScoreboard();
                ScoreboardObjective karmaObjective = scoreboard.getObjective("karma");
                if (karmaObjective == null) {
                    karmaObjective = scoreboard.addObjective("karma", ScoreboardCriterion.DUMMY, Text.of("Karma"), ScoreboardCriterion.RenderType.INTEGER);
                }
                ScoreboardPlayerScore karmaScore = scoreboard.getPlayerScore(entity.getName().getString(), karmaObjective);
                karmaScore.setScore(karmaScore.getScore() - 1); // Decrease karma by 1
            }else if (!world.isClient && killedEntity instanceof HostileEntity) {
                Scoreboard scoreboard = server.getScoreboard();
                ScoreboardObjective karmaObjective = scoreboard.getObjective("karma");
                if (karmaObjective == null) {
                    karmaObjective = scoreboard.addObjective("karma", ScoreboardCriterion.DUMMY, Text.of("Karma"), ScoreboardCriterion.RenderType.INTEGER);
                }
                ScoreboardPlayerScore karmaScore = scoreboard.getPlayerScore(entity.getName().getString(), karmaObjective);
                karmaScore.setScore(karmaScore.getScore() + 1); // increase karma by 1
            }
        });

		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
			ItemStack itemStack = player.getMainHandStack();
			if (state.getBlock() == Blocks.SPAWNER && !itemStack.isEmpty()) {
                Scoreboard scoreboard = server.getScoreboard();
                ScoreboardObjective karmaObjective = scoreboard.getObjective("karma");
                if (karmaObjective == null) {
                    karmaObjective = scoreboard.addObjective("karma", ScoreboardCriterion.DUMMY, Text.of("Karma"), ScoreboardCriterion.RenderType.INTEGER);
                }
                ScoreboardPlayerScore karmaScore = scoreboard.getPlayerScore(player.getName().getString(), karmaObjective);
                karmaScore.setScore(karmaScore.getScore() - 1); // Decrease karma by 1
			}
		});

    }
}
