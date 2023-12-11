package name.modid.monsters.client;

import name.modid.monsters.custom.PizzaBoss;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class PizzaBossModel extends EntityModel<PizzaBoss> {
	private final ModelPart bb_main;
	public PizzaBossModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -8.0F, -20.0F, 16.0F, 8.0F, 40.0F, new Dilation(0.0F))
		.uv(56, 56).cuboid(8.0F, -8.0F, -8.0F, 12.0F, 8.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 56).cuboid(-20.0F, -8.0F, -8.0F, 12.0F, 8.0F, 16.0F, new Dilation(0.0F))
		.uv(32, 88).cuboid(-16.0F, -8.0F, -16.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 88).cuboid(8.0F, -8.0F, -16.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(72, 0).cuboid(8.0F, -8.0F, 8.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-16.0F, -8.0F, 8.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(40, 56).cuboid(-11.0F, -10.0F, 0.0F, 5.0F, 2.0F, 5.0F, new Dilation(0.0F))
		.uv(20, 31).cuboid(7.0F, -10.0F, -4.0F, 5.0F, 2.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 31).cuboid(-1.0F, -10.0F, -10.0F, 5.0F, 2.0F, 5.0F, new Dilation(0.0F))
		.uv(20, 24).cuboid(3.0F, -10.0F, 7.0F, 5.0F, 2.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 56).cuboid(-4.0F, -10.0F, 5.0F, 3.0F, 2.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 63).cuboid(-13.0F, -10.0F, -6.0F, 5.0F, 2.0F, 3.0F, new Dilation(0.0F))
		.uv(24, 0).cuboid(6.0F, -10.0F, -10.0F, 3.0F, 2.0F, 5.0F, new Dilation(0.0F))
		.uv(55, 56).cuboid(9.0F, -10.0F, 4.0F, 5.0F, 2.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 24).cuboid(-2.0F, -10.0F, -1.0F, 5.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(PizzaBoss entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

}