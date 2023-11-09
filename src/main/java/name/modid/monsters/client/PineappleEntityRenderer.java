package name.modid.monsters.client;

import name.modid.Monkeysmodclient;
import name.modid.monsters.custom.PineappleEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PineappleEntityRenderer extends MobEntityRenderer<PineappleEntity, PineappleEntityModel> {

    public PineappleEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PineappleEntityModel(context.getPart(Monkeysmodclient.MODEL_PINEAPPLE_LAYER)), 0.5f);

    }

    @Override
    public Identifier getTexture(PineappleEntity entity) {
        return new Identifier("monkeysmod" , "textures/monsters/pineapple.png");
    }

    @Override
    public void render(PineappleEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        super.render(mobEntity, f ,g, matrixStack, vertexConsumerProvider, i);
    }

}