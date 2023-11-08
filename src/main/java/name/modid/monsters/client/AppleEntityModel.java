package name.modid.monsters.client;

import name.modid.monsters.custom.AppleEntity;
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

public class AppleEntityModel extends EntityModel<AppleEntity> {
	private final ModelPart bb_main;
	public AppleEntityModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 20).cuboid(-4.0F, -3.0F, -4.0F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, -13.0F, -5.0F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F))
		.uv(40, 1).cuboid(5.0F, -5.0F, -4.0F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(34, 27).cuboid(5.0F, -12.0F, -5.0F, 1.0F, 7.0F, 10.0F, new Dilation(0.0F))
		.uv(22, 37).cuboid(-6.0F, -5.0F, -4.0F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(34, 10).cuboid(-6.0F, -12.0F, -5.0F, 1.0F, 7.0F, 10.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, -20.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 20).cuboid(-1.0F, -20.0F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(36, 44).cuboid(-1.0F, -22.0F, -5.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(22, 20).cuboid(5.0F, -12.0F, -5.0F, 1.0F, 7.0F, 10.0F, new Dilation(0.0F))
		.uv(12, 29).cuboid(5.0F, -5.0F, -4.0F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 29).cuboid(-6.0F, -12.0F, -5.0F, 1.0F, 7.0F, 10.0F, new Dilation(0.0F))
		.uv(30, 0).cuboid(-6.0F, -5.0F, -4.0F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(AppleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}