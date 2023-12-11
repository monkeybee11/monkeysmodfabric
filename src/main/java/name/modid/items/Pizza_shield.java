package name.modid.items;

import name.modid.Monkeysmod;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

public class Pizza_shield extends ShieldItem {
    public static final int field_30918 = 5;
    public static final float MIN_DAMAGE_AMOUNT_TO_BREAK = 3.0f;

    public Pizza_shield(Settings settings) {
        super(settings.maxDamage(336));
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
        isDamageable();
        
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Monkeysmod.RAW_PIZZA) || super.canRepair(stack, ingredient);
    }

}
