package name.modid.items;

import name.modid.Monkeysmod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Peeled_banana extends Item {

    public Peeled_banana(Settings settings) {
        super(new Item.Settings().food((new FoodComponent.Builder().hunger(6).saturationModifier(.6f).snack().build())));
    }

    @Override
    public ItemStack finishUsing(ItemStack peeled_banana, World world, LivingEntity player) {
        if (player instanceof PlayerEntity) {
            PlayerEntity Player = (PlayerEntity)player;

            Player.getInventory().offerOrDrop(new ItemStack(Monkeysmod.BANANA_PEEL));

        }
        return super.finishUsing(peeled_banana, world, player);
    }
}

