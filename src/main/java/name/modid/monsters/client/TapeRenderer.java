package name.modid.monsters.client;

import name.modid.Monkeysmodclient;
import name.modid.monsters.custom.TapeEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class TapeRenderer extends LivingEntityRenderer<TapeEntity, TapeEntityModel> {

    public TapeRenderer(EntityRendererFactory.Context context) {
        super(context, new TapeEntityModel(context.getPart(Monkeysmodclient.MODEL_TAPE_LAYER)), 0.5f);

    }

    @Override
    public Identifier getTexture(TapeEntity entity) {
        return new Identifier("monkeysmod" , "textures/not_a_monster/tape_mesher.png");
    }

    @Override
    public void render(TapeEntity LivingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(LivingEntity, f ,g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    protected boolean hasLabel(TapeEntity entity) {
        return false;
    }

}