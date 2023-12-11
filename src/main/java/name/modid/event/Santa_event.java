package name.modid.event;

import name.modid.block.Cookie_plate_wood;
import name.modid.block.Stocking;
import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Santa_event {
    
    public static void register() {
        EntitySleepEvents.STOP_SLEEPING.register((livingEntity, sleepingPos) -> {
            if (livingEntity instanceof PlayerEntity) {
                PlayerEntity playerEntity = (PlayerEntity) livingEntity;
                World world = playerEntity.getEntityWorld();
                if (isCookiePlateNearby(world, playerEntity.getBlockPos(), playerEntity) && isStockingNearby(world, playerEntity.getBlockPos(), playerEntity)) {
                    updateCookiePlate(world, playerEntity.getBlockPos(), playerEntity);
                    updateStocking(world, playerEntity.getBlockPos(), playerEntity);
                }
            }
        });
    }

    private static boolean isCookiePlateNearby(World world, BlockPos playerPos, PlayerEntity playerEntity) {
        // Check for a cookie_plate_wooden block within a 20 block radius
        for (int dx = -20; dx <= 20; dx++) {
            for (int dy = -20; dy <= 20; dy++) {
                for (int dz = -20; dz <= 20; dz++) {
                    BlockPos pos = playerEntity.getBlockPos().add(dx, dy, dz);
                    BlockState state = world.getBlockState(pos);
                    if (state.getBlock() instanceof Cookie_plate_wood && state.get(Cookie_plate_wood.AGE) == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void updateCookiePlate(World world, BlockPos playerPos, PlayerEntity playerEntity) {
        // Update the age of the cookie_plate_wooden block to 2
        for (int dx = -20; dx <= 20; dx++) {
            for (int dy = -20; dy <= 20; dy++) {
                for (int dz = -20; dz <= 20; dz++) {
                    BlockPos pos = playerEntity.getBlockPos().add(dx, dy, dz);
                    BlockState state = world.getBlockState(pos);
                    if (state.getBlock() instanceof Cookie_plate_wood && state.get(Cookie_plate_wood.AGE) == 1) {
                        world.setBlockState(pos, state.with(Cookie_plate_wood.AGE, 2));
                    }
                }
            }
        }
    }

    private static boolean isStockingNearby(World world, BlockPos playerPos, PlayerEntity playerEntity) {
        // Check for a stocking block within a 20 block radius
        for (int dx = -20; dx <= 20; dx++) {
            for (int dy = -20; dy <= 20; dy++) {
                for (int dz = -20; dz <= 20; dz++) {
                    BlockPos pos = playerEntity.getBlockPos().add(dx, dy, dz);
                    BlockState state = world.getBlockState(pos);
                    if (state.getBlock() instanceof Stocking && state.get(Stocking.AGE) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void updateStocking(World world, BlockPos playerPos, PlayerEntity playerEntity) {
        // Update the age of the stocking block to 1
        for (int dx = -20; dx <= 20; dx++) {
            for (int dy = -20; dy <= 20; dy++) {
                for (int dz = -20; dz <= 20; dz++) {
                    BlockPos pos = playerEntity.getBlockPos().add(dx, dy, dz);
                    BlockState state = world.getBlockState(pos);
                    if (state.getBlock() instanceof Stocking && state.get(Stocking.AGE) == 0) {
                        world.setBlockState(pos, state.with(Stocking.AGE, 1));
                    }
                }
            }
        }
    }

}
