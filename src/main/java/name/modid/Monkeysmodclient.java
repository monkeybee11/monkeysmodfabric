package name.modid;

import name.modid.monsters.ModEntities;
import name.modid.monsters.client.AppleEntityModel;
import name.modid.monsters.client.AppleEntityRenderer;
import name.modid.monsters.client.BananaEntityModel;
import name.modid.monsters.client.BananaEntityRenderer;
import name.modid.monsters.client.ModModelLayer;
import name.modid.monsters.client.PineappleEntityModel;
import name.modid.monsters.client.PineappleEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;


public class Monkeysmodclient implements ClientModInitializer {
    
    public static final EntityModelLayer MODEL_BANANA_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "banana_monster"), "main");
    public static final EntityModelLayer MODEL_APPLE_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "apple_monster"), "main");
    public static final EntityModelLayer MODEL_PINEAPPLE_LAYER = new EntityModelLayer(new Identifier("monkeysmod", "pineapple_monster"), "main");

    @Override
    public void onInitializeClient() {


        EntityRendererRegistry.register(ModEntities.BANANAMONSTER, BananaEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.BANANAMONSTER, BananaEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.APPLEMONSTER, AppleEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.APPLEMONSTER, AppleEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.PINEAPPLEMONSTER, PineappleEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.PINEAPPLEMONSTER, PineappleEntityModel::getTexturedModelData);



    }
}
