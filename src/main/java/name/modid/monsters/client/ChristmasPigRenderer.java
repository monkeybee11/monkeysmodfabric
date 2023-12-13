
package name.modid.monsters.client;

import name.modid.Monkeysmodclient;
import name.modid.monsters.custom.SantaPigEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ChristmasPigRenderer extends MobEntityRenderer<SantaPigEntity, Christmas_pig_model> {

    public ChristmasPigRenderer(EntityRendererFactory.Context context) {
        super(context, new Christmas_pig_model(context.getPart(Monkeysmodclient.MODEL_SANTAPIG_LAYER)), 0.5f);

    }

    @Override
    public Identifier getTexture(SantaPigEntity entity) {
        return new Identifier("monkeysmod" , "textures/not_a_monster/chrismas_pig.png");
    }

    @Override
    public void render(SantaPigEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        super.render(mobEntity, f ,g, matrixStack, vertexConsumerProvider, i);
    }

}
