package name.modid.monsters.client;


import name.modid.Monkeysmodclient;
import name.modid.monsters.custom.ChristmasTreeEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;


public class ChristmasTreeRenderer extends LivingEntityRenderer<ChristmasTreeEntity, Christmas_tree_model> {

    public ChristmasTreeRenderer(EntityRendererFactory.Context context) {
        super(context, new Christmas_tree_model(context.getPart(Monkeysmodclient.MODEL_CHRISMAS_TREE_LAYER)), 0.0f);
    }

    @Override
    public Identifier getTexture(ChristmasTreeEntity entity) {
        return new Identifier("monkeysmod" , "textures/not_a_monster/christmas_tree.png");
    }

    @Override
    public void render(ChristmasTreeEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
    
        Christmas_tree_model model = this.getModel();
    
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntitySolid(this.getTexture(entity)));

        if (!entity.getInventory().stream().noneMatch(stack -> stack.getItem() == Items.WHITE_WOOL)) {
            model.angel.render(matrices, vertexConsumer, light, getOverlay(entity, 0), 1.0F, 1.0F, 1.0F, 1.0F);
        }
        if (!entity.getInventory().stream().noneMatch(stack -> stack.getItem() == Items.GOLD_NUGGET)) {
            model.baulbaul.render(matrices, vertexConsumer, light, getOverlay(entity, 0), 1.0F, 1.0F, 1.0F, 1.0F);
        }
        if (!entity.getInventory().stream().noneMatch(stack -> stack.getItem() == Items.TORCH)) {
            model.torch.render(matrices, vertexConsumer, light, getOverlay(entity, 0), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    
        model.leaves.render(matrices, vertexConsumer, light, getOverlay(entity, 0), 1.0F, 1.0F, 1.0F, 1.0F);
        model.bb_main.render(matrices, vertexConsumer, light, getOverlay(entity, 0), 1.0F, 1.0F, 1.0F, 1.0F);
        model.pot.render(matrices, vertexConsumer, light, getOverlay(entity, 0), 1.0F, 1.0F, 1.0F, 1.0F);
    }
}
