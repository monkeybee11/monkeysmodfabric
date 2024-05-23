package name.modid.items;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class Coconut_food extends Item {

    public Coconut_food(Settings settings) {
        super(new Item.Settings().food((new FoodComponent.Builder().hunger(7).saturationModifier(0.6f)).snack().build()));
    }

}
