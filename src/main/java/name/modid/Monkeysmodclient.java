package name.modid;

import name.modid.monsters.ModEntities;
import name.modid.monsters.client.AppleEntityModel;
import name.modid.monsters.client.AppleEntityRenderer;
import name.modid.monsters.client.BananaEntityModel;
import name.modid.monsters.client.BananaEntityRenderer;
import name.modid.monsters.client.ChristmasPigRenderer;
import name.modid.monsters.client.ChristmasTreeRenderer;
import name.modid.monsters.client.Christmas_pig_model;
import name.modid.monsters.client.Christmas_tree_model;
import name.modid.monsters.client.CoconutEntityModel;
import name.modid.monsters.client.CoconutEntityRenderer;
import name.modid.monsters.client.MeatEntityModel;
import name.modid.monsters.client.MeatEntityRenderer;
import name.modid.monsters.client.MincepieEntityRenderer;
import name.modid.monsters.client.Mincepie_model;
import name.modid.monsters.client.ModModelLayer;
import name.modid.monsters.client.PineappleEntityModel;
import name.modid.monsters.client.PineappleEntityRenderer;
import name.modid.monsters.client.PizzaBossModel;
import name.modid.monsters.client.PizzaBossRenderer;
import name.modid.monsters.client.PizzaToppingRenderer;
import name.modid.monsters.client.Pizza_Topping_model;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;


public class Monkeysmodclient implements ClientModInitializer {

    
    
    public static final EntityModelLayer MODEL_BANANA_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "banana_monster"), "main");
    public static final EntityModelLayer MODEL_APPLE_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "apple_monster"), "main");
    public static final EntityModelLayer MODEL_PINEAPPLE_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "pineapple_monster"), "main");
    public static final EntityModelLayer MODEL_COCONUT_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "coconut_monster"), "main");
    public static final EntityModelLayer MODEL_MEAT_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "meat_monster"), "main");
    public static final EntityModelLayer MODEL_MINCEPIE_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "mincepie_monster"), "main");
    public static final EntityModelLayer MODEL_PIZZA_BOSS_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "pizza_boss"), "main");
    public static final EntityModelLayer MODEL_PIZZA_TOPPING_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "pizza_topping"), "main");
    public static final EntityModelLayer MODEL_CHRISMAS_TREE_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "christmas_tree"), "main");
    public static final EntityModelLayer MODEL_SANTAPIG_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "santa_pig"), "main");
    

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.BANANAMONSTER, BananaEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.BANANAMONSTER, BananaEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.APPLEMONSTER, AppleEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.APPLEMONSTER, AppleEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.PINEAPPLEMONSTER, PineappleEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.PINEAPPLEMONSTER, PineappleEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.COOCNUTMONSTER, CoconutEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.COCONUTMONSTER, CoconutEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.MEATMONSTER, MeatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.MEATMONSTER, MeatEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.MINCEPIE, MincepieEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.MINCEPIE, Mincepie_model::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.PIZZABOSS, PizzaBossRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.PIZZABOSS, PizzaBossModel::getTexturedModelData);


        EntityRendererRegistry.register(ModEntities.PIZZA_TOPPING,(context) -> new PizzaToppingRenderer(context));
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.PIZZA_TOPPING, Pizza_Topping_model::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.CHRISTMAS_TREE, ChristmasTreeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.CHRISTMAS_TREE, Christmas_tree_model::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.SANTA_PIG, ChristmasPigRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.SANTA_PIG, Christmas_pig_model::getTexturedModelData);





        BlockRenderLayerMap.INSTANCE.putBlock(Monkeysmod.MEAT_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Monkeysmod.PINEAPPLE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Monkeysmod.COCONUT_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Monkeysmod.COOKIE_PLATE_WOOD, RenderLayer.getCutout());
    }
}
