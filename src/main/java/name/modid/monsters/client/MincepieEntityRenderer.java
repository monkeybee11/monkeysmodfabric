package name.modid.monsters.client;

import name.modid.Monkeysmodclient;
import name.modid.monsters.custom.MincepieEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MincepieEntityRenderer extends MobEntityRenderer<MincepieEntity, Mincepie_model> {

    public MincepieEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new Mincepie_model(context.getPart(Monkeysmodclient.MODEL_MINCEPIE_LAYER)), 0.5f);

    }

    @Override
    public Identifier getTexture(MincepieEntity entity) {
        return new Identifier("monkeysmod" , "textures/monsters/mince_pie.png");
    }

    @Override
    public void render(MincepieEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        super.render(mobEntity, f ,g, matrixStack, vertexConsumerProvider, i);
    }

}