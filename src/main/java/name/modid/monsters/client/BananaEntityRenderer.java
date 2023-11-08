package name.modid.monsters.client;

import name.modid.Monkeysmodclient;
import name.modid.monsters.custom.BananaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BananaEntityRenderer extends MobEntityRenderer<BananaEntity, BananaEntityModel> {

    public BananaEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BananaEntityModel(context.getPart(Monkeysmodclient.MODEL_BANANA_LAYER)), 0.5f);

    }

    @Override
    public Identifier getTexture(BananaEntity entity) {
        return new Identifier("monkeysmod" , "textures/monsters/banana.png");
    }

    @Override
    public void render(BananaEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        super.render(mobEntity, f ,g, matrixStack, vertexConsumerProvider, i);
    }

}
