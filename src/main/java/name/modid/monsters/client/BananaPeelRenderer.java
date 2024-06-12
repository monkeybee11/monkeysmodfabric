package name.modid.monsters.client;

import name.modid.Monkeysmodclient;
import name.modid.monsters.custom.BananaPeelEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BananaPeelRenderer extends LivingEntityRenderer<BananaPeelEntity, BananaPeelEntityModel> {

    public BananaPeelRenderer(EntityRendererFactory.Context context) {
        super(context, new BananaPeelEntityModel(context.getPart(Monkeysmodclient.MODEL_BANANAPEEL_LAYER)), 0.0f);
    }

    @Override
    public Identifier getTexture(BananaPeelEntity entity) {
        return new Identifier("monkeysmod" , "textures/not_a_monster/banana_peel.png");
    }

    @Override
    public void render(BananaPeelEntity LivingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        super.render(LivingEntity, f ,g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    protected boolean hasLabel(BananaPeelEntity entity) {
        return false;
    }

}
