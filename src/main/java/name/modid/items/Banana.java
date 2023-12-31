package name.modid.items;

import name.modid.Monkeysmod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Banana extends Item {

    public Banana(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack banana = player.getStackInHand(hand);
        banana.decrement(1);
        player.getInventory().offerOrDrop(new ItemStack(Monkeysmod.PEELED_BANANA));
        return new TypedActionResult<ItemStack>(ActionResult.PASS, player.getStackInHand(hand));

    }


}
