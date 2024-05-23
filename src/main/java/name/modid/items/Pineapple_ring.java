package name.modid.items;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class Pineapple_ring extends Item {

    public Pineapple_ring(Settings settings) {
        super(new Item.Settings().food((new FoodComponent.Builder().hunger(6).saturationModifier(0.6f)).snack().build()));
    }

}
