package name.modid.items;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class Meat_mats implements ToolMaterial {

    private int maxDurability = 500;
    private int currentDurability = maxDurability; 
    public static final Meat_mats INSTANCE = new Meat_mats();



    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4.0f;
    }

    @Override //starts out with the attack dammage as a diamond sword but gets weaker as it gets dammaged
    public float getAttackDamage() {
        float maxAttackDamage = 7.0f; 
        return (currentDurability / (float) maxDurability) * maxAttackDamage;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 14;
    }

    @Override
    public Ingredient getRepairIngredient() {
        Item[] meats = new Item[]{
            Items.COOKED_BEEF,
            Items.COOKED_PORKCHOP,
            Items.COOKED_CHICKEN,
            Items.COOKED_MUTTON,
            Items.COOKED_RABBIT,
            Items.BEEF,
            Items.PORKCHOP,
            Items.CHICKEN,
            Items.MUTTON,
            Items.RABBIT,
            Items.ROTTEN_FLESH
        };
        return Ingredient.ofItems(meats);
    }




    
}
