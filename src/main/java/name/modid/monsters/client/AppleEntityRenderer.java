package name.modid.monsters.client;

import name.modid.Monkeysmodclient;
import name.modid.monsters.custom.AppleEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class AppleEntityRenderer extends MobEntityRenderer<AppleEntity, AppleEntityModel> {

    public AppleEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AppleEntityModel(context.getPart(Monkeysmodclient.MODEL_APPLE_LAYER)), 0.5f);

    }

    @Override
    public Identifier getTexture(AppleEntity entity) {
        return new Identifier("monkeysmod" , "textures/monsters/apple.png");
    }

    @Override
    public void render(AppleEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        super.render(mobEntity, f ,g, matrixStack, vertexConsumerProvider, i);
    }

}
