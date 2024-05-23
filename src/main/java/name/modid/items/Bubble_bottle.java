package name.modid.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Bubble_bottle extends Item {

    public Bubble_bottle(Settings settings) {
        super(new Item.Settings().food((new FoodComponent.Builder().hunger(0).saturationModifier(0)).alwaysEdible().build()));
    }


    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.setAir(user.getMaxAir());
        return super.finishUsing(stack, world, user);
    }
    
}
