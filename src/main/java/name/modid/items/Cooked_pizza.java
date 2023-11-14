package name.modid.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class Cooked_pizza extends Item {

    public Cooked_pizza(Settings settings) {
        super(new Item.Settings().food((new FoodComponent.Builder().hunger(5).saturationModifier(1.2f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0f).build())));
    }

}
