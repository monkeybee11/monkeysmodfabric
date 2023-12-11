package name.modid.monsters.client;

import name.modid.monsters.pizzatopping.PizzaTopping;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports


public class Pizza_Topping_model extends EntityModel<PizzaTopping> {
	private final ModelPart bb_main;
	public Pizza_Topping_model(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(5, 6).cuboid(2.0F, -1.0F, -1.5F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 5).cuboid(-3.0F, -1.0F, -1.5F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(10, 5).cuboid(-1.5F, -1.0F, 2.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 10).cuboid(-1.5F, -1.0F, -3.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(PizzaTopping entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

}