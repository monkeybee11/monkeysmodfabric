package name.modid.items;

import name.modid.Monkeysmod;
import name.modid.monsters.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Seed_wand extends Item {

    public Seed_wand(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
    
        if(!user.getWorld().isClient()) {
            EntityType<?> enetitytype = entity.getType();
    
            if (enetitytype.equals(ModEntities.MEATMONSTER)) {

                World world = user.getWorld();
                Vec3d pos = entity.getPos();

                ItemEntity meat_seed = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Monkeysmod.MEAT_CROP));
                world.spawnEntity(meat_seed);
    
                entity.remove(Entity.RemovalReason.KILLED);
    
                if (!user.getAbilities().creativeMode) {
                    stack.damage(1, user, (player) -> player.sendToolBreakStatus(hand));
                }
    
                return ActionResult.success(user.getWorld().isClient());
            } else if (enetitytype.equals(ModEntities.BANANAMONSTER)) {

                World world = user.getWorld();
                Vec3d pos = entity.getPos();

                ItemEntity banana_bunch = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Monkeysmod.BANANA_BUNCH));
                world.spawnEntity(banana_bunch);
    
                entity.remove(Entity.RemovalReason.KILLED);
    
                if (!user.getAbilities().creativeMode) {
                    stack.damage(1, user, (player) -> player.sendToolBreakStatus(hand));
                }
    
                return ActionResult.success(user.getWorld().isClient());
            } else if (enetitytype.equals(ModEntities.APPLEMONSTER)) {

                World world = user.getWorld();
                Vec3d pos = entity.getPos();

                ItemEntity apple_seed = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Monkeysmod.APPLEBLOCK));
                world.spawnEntity(apple_seed);
    
                entity.remove(Entity.RemovalReason.KILLED);
    
                if (!user.getAbilities().creativeMode) {
                    stack.damage(1, user, (player) -> player.sendToolBreakStatus(hand));
                }
    
                return ActionResult.success(user.getWorld().isClient());
            } else if (enetitytype.equals(ModEntities.COOCNUTMONSTER)) {

                World world = user.getWorld();
                Vec3d pos = entity.getPos();

                ItemEntity coconut_seed = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Monkeysmod.COCONUT_SHELL));
                world.spawnEntity(coconut_seed);

                entity.remove(Entity.RemovalReason.KILLED);

                if (!user.getAbilities().creativeMode) {
                    stack.damage(1, user, (player) -> player.sendToolBreakStatus(hand));
                }

                return ActionResult.success(user.getWorld().isClient());
            } else if (enetitytype.equals(ModEntities.MINCEPIE)) {

                World world = user.getWorld();
                Vec3d pos = entity.getPos();

                ItemEntity mincepie_seed = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Monkeysmod.MINCE_PIE_CROP));
                world.spawnEntity(mincepie_seed);

                entity.remove(Entity.RemovalReason.KILLED);

                if (!user.getAbilities().creativeMode) {
                    stack.damage(1, user, (player) -> player.sendToolBreakStatus(hand));
                }

                return ActionResult.success(user.getWorld().isClient());
            } else if (enetitytype.equals(ModEntities.PINEAPPLEMONSTER)) {

                World world = user.getWorld();
                Vec3d pos = entity.getPos();

                ItemEntity pineapple_seed = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Monkeysmod.PINEAPPLE_CROP));
                world.spawnEntity(pineapple_seed);

                entity.remove(Entity.RemovalReason.KILLED);

                if (!user.getAbilities().creativeMode) {
                    stack.damage(1, user, (player) -> player.sendToolBreakStatus(hand));
                }

                return ActionResult.success(user.getWorld().isClient());
            }
        }
        return ActionResult.PASS;
    }
    
    
}
