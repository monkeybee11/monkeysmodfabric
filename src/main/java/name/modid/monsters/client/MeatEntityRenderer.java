package name.modid.monsters.client;

import name.modid.Monkeysmodclient;
import name.modid.monsters.custom.MeatEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MeatEntityRenderer extends MobEntityRenderer<MeatEntity, MeatEntityModel> {

    public MeatEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new MeatEntityModel(context.getPart(Monkeysmodclient.MODEL_MEAT_LAYER)), 0.5f);

    }

    @Override
    public Identifier getTexture(MeatEntity entity) {
        return new Identifier("monkeysmod" , "textures/monsters/meat.png");
    }

    @Override
    public void render(MeatEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        super.render(mobEntity, f ,g, matrixStack, vertexConsumerProvider, i);
    }

}