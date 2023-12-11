package name.modid.monsters.client;

import name.modid.monsters.pizzatopping.PizzaTopping;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PizzaToppingRenderer extends EntityRenderer<PizzaTopping> {
    private final Pizza_Topping_model model;

    public PizzaToppingRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new Pizza_Topping_model(context.getPart(ModModelLayer.PIZZA_TOPPING));
    }

    @Override
    public Identifier getTexture(PizzaTopping entity) {
        return new Identifier("monkeysmod", "textures/monsters/pizza_topping.png");
    }

    @Override
    public void render(PizzaTopping entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(this.getTexture(entity))), light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }
}

