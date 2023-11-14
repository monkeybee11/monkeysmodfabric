package name.modid.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class Raw_pizza extends Item {

    public Raw_pizza(Settings settings) {
        super(new Item.Settings().food((new FoodComponent.Builder().hunger(5).saturationModifier(0.6f)).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3f).meat().build()));
    }

}
