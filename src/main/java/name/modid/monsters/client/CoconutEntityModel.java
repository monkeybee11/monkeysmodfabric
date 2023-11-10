

package name.modid.monsters.client;

import name.modid.monsters.custom.CoconutEntity;
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

public class CoconutEntityModel extends EntityModel<CoconutEntity> {
	private final ModelPart head;
	public CoconutEntityModel(ModelPart root) {
		this.head = root.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("head", ModelPartBuilder.create().uv(39, 19).cuboid(-3.0F, -4.0F, 3.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(20, 0).cuboid(-1.0F, -7.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F))
		.uv(30, 9).cuboid(-1.0F, -7.0F, -2.0F, 2.0F, 12.0F, 1.0F, new Dilation(0.0F))
		.uv(6, 26).cuboid(1.0F, -7.0F, -1.0F, 1.0F, 12.0F, 2.0F, new Dilation(0.0F))
		.uv(12, 26).cuboid(-1.0F, -7.0F, 1.0F, 2.0F, 12.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 26).cuboid(-2.0F, -7.0F, -1.0F, 1.0F, 12.0F, 2.0F, new Dilation(0.0F))
		.uv(18, 36).cuboid(-2.0F, -6.0F, -2.0F, 1.0F, 10.0F, 1.0F, new Dilation(0.0F))
		.uv(36, 9).cuboid(1.0F, -6.0F, -2.0F, 1.0F, 10.0F, 1.0F, new Dilation(0.0F))
		.uv(33, 33).cuboid(1.0F, -6.0F, 1.0F, 1.0F, 10.0F, 1.0F, new Dilation(0.0F))
		.uv(29, 33).cuboid(-2.0F, -6.0F, 1.0F, 1.0F, 10.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 25).cuboid(-2.0F, -6.0F, -3.0F, 4.0F, 10.0F, 1.0F, new Dilation(0.0F))
		.uv(20, 14).cuboid(-2.0F, -6.0F, 2.0F, 4.0F, 10.0F, 1.0F, new Dilation(0.0F))
		.uv(10, 0).cuboid(2.0F, -6.0F, -2.0F, 1.0F, 10.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-3.0F, -6.0F, -2.0F, 1.0F, 10.0F, 4.0F, new Dilation(0.0F))
		.uv(11, 39).cuboid(-3.0F, -5.0F, 2.0F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F))
		.uv(38, 0).cuboid(-3.0F, -5.0F, -3.0F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F))
		.uv(37, 33).cuboid(2.0F, -5.0F, -3.0F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F))
		.uv(22, 36).cuboid(2.0F, -5.0F, 2.0F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F))
		.uv(10, 14).cuboid(3.0F, -5.0F, -2.0F, 1.0F, 8.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 14).cuboid(-4.0F, -5.0F, -2.0F, 1.0F, 8.0F, 4.0F, new Dilation(0.0F))
		.uv(29, 24).cuboid(-2.0F, -5.0F, -4.0F, 4.0F, 8.0F, 1.0F, new Dilation(0.0F))
		.uv(28, 0).cuboid(-2.0F, -5.0F, 3.0F, 4.0F, 8.0F, 1.0F, new Dilation(0.0F))
		.uv(42, 0).cuboid(2.0F, -4.0F, 3.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 41).cuboid(3.0F, -4.0F, 2.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(41, 33).cuboid(3.0F, -4.0F, -3.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 9).cuboid(2.0F, -4.0F, -4.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 40).cuboid(-3.0F, -4.0F, -4.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 40).cuboid(-4.0F, -4.0F, -3.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(39, 26).cuboid(-4.0F, -4.0F, 2.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(CoconutEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}