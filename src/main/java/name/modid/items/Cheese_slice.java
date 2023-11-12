package name.modid.items;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class Cheese_slice extends Item {

    public Cheese_slice(Settings settings) {
        super(new Item.Settings().food((new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)).snack().build()));
    }

}
