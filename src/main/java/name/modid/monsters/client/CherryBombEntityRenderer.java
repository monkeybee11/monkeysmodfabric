package name.modid.monsters.client;

import name.modid.Monkeysmodclient;
import name.modid.monsters.custom.CherryBombEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CherryBombEntityRenderer extends MobEntityRenderer<CherryBombEntity, CherryBombEntityModel> {

    public CherryBombEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CherryBombEntityModel(context.getPart(Monkeysmodclient.MODEL_CHERRYBOMB_LAYER)), 0.5f);

    }

    @Override
    public Identifier getTexture(CherryBombEntity entity) {
        return new Identifier("monkeysmod" , "textures/monsters/cherry_bomb.png");
    }

    @Override
    public void render(CherryBombEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        super.render(mobEntity, f ,g, matrixStack, vertexConsumerProvider, i);
    }

}
