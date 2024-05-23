package name.modid.items;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class Mince_pie_item extends Item {

    public Mince_pie_item(Settings settings) {
        super(new Item.Settings().food((new FoodComponent.Builder().hunger(8).saturationModifier(0.8f)).snack().build()));
    }

}
