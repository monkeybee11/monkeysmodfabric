package name.modid.items;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class Grated_cheese extends Item {

    public Grated_cheese(Settings settings) {
        super(new Item.Settings().food((new FoodComponent.Builder().hunger(1).saturationModifier(0.1f)).snack().build()));
    }

}
