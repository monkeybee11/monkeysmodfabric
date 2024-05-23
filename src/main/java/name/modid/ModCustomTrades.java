package name.modid;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class ModCustomTrades {

    public static void registerCustomTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD, random.nextInt(10) + 1),
                new ItemStack(Monkeysmod.BANANA_PICKER, 1),
                6, 4, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD, random.nextInt(30) + 4),
                new ItemStack(Monkeysmod.CARROT_DRILL, 1),
                1, 4, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD, random.nextInt(2) +3),
                new ItemStack(Monkeysmod.SEED_WAND, 1),
                1, 4, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD, random.nextInt(30) + 4),
                new ItemStack(Monkeysmod.DIGGER, 1),
                1, 4, 0.05f
            ));
        });
    }
}


