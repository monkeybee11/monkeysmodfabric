package name.modid.monsters.client;

import name.modid.Monkeysmodclient;
import name.modid.monsters.custom.CoconutEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CoconutEntityRenderer extends MobEntityRenderer<CoconutEntity, CoconutEntityModel> {

    public CoconutEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CoconutEntityModel(context.getPart(Monkeysmodclient.MODEL_COCONUT_LAYER)), 0.5f);
    }


    @Override
    public Identifier getTexture(CoconutEntity entity) {
        return new Identifier("monkeysmod" , "textures/monsters/coconut.png");
    }

    @Override
    public void render(CoconutEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        super.render(mobEntity, f ,g, matrixStack, vertexConsumerProvider, i);
    }

}