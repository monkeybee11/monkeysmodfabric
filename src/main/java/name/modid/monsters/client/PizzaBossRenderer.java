package name.modid.monsters.client;

import name.modid.Monkeysmodclient;
import name.modid.monsters.custom.PizzaBoss;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PizzaBossRenderer extends MobEntityRenderer<PizzaBoss, PizzaBossModel>{
        public PizzaBossRenderer(EntityRendererFactory.Context context) {
        super(context, new PizzaBossModel(context.getPart(Monkeysmodclient.MODEL_PIZZA_BOSS_LAYER)), 0.5f);

    }

    @Override
    public Identifier getTexture(PizzaBoss entity) {
        return new Identifier("monkeysmod" , "textures/monsters/pizza_boss.png");
    }

    @Override
    public void render(PizzaBoss mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f ,g, matrixStack, vertexConsumerProvider, i);
    }
    
}
