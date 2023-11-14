package name.modid.monsters.client;

import name.modid.monsters.custom.MincepieEntity;
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

public class Mincepie_model extends EntityModel<MincepieEntity> {
	private final ModelPart bb_main;
	public Mincepie_model(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(20, 23).cuboid(-1.0F, -1.0F, -4.0F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(16, 15).cuboid(-4.0F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(16, 12).cuboid(1.0F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(10, 31).cuboid(1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(30, 15).cuboid(1.0F, -1.0F, 1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(30, 12).cuboid(-3.0F, -1.0F, 1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 30).cuboid(-3.0F, -1.0F, -3.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(16, 12).cuboid(-1.0F, -2.0F, -5.0F, 2.0F, 1.0F, 10.0F, new Dilation(0.0F))
		.uv(38, 30).cuboid(1.0F, -2.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(36, 5).cuboid(-5.0F, -2.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(20, 32).cuboid(-4.0F, -2.0F, 1.0F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 20).cuboid(-4.0F, -2.0F, -4.0F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(1.0F, -2.0F, -4.0F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 12).cuboid(1.0F, -2.0F, 1.0F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 12).cuboid(-1.0F, -4.0F, -6.0F, 2.0F, 2.0F, 12.0F, new Dilation(0.0F))
		.uv(28, 38).cuboid(1.0F, -4.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(14, 37).cuboid(-6.0F, -4.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(28, 32).cuboid(-4.0F, -4.0F, -5.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 5).cuboid(-5.0F, -4.0F, -4.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 37).cuboid(1.0F, -4.0F, -4.0F, 4.0F, 2.0F, 3.0F, new Dilation(0.0F))
		.uv(20, 28).cuboid(1.0F, -4.0F, -5.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(36, 0).cuboid(1.0F, -4.0F, 1.0F, 4.0F, 2.0F, 3.0F, new Dilation(0.0F))
		.uv(32, 23).cuboid(-4.0F, -4.0F, 1.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(10, 28).cuboid(1.0F, -4.0F, 4.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, -4.0F, 1.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
		.uv(40, 16).cuboid(-5.0F, -4.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 14).cuboid(4.0F, -4.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(11, 37).cuboid(-5.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 25).cuboid(4.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 12).cuboid(1.0F, -4.0F, 5.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 10).cuboid(-4.0F, -4.0F, 5.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(26, 4).cuboid(5.0F, -4.0F, 1.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(26, 0).cuboid(-6.0F, -4.0F, 1.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 26).cuboid(5.0F, -4.0F, -4.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(16, 18).cuboid(-6.0F, -4.0F, -4.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(38, 33).cuboid(1.0F, -4.0F, -6.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 29).cuboid(-4.0F, -4.0F, -6.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(30, 10).cuboid(5.0F, -5.0F, -4.0F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(10, 28).cuboid(-6.0F, -5.0F, -4.0F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(30, 19).cuboid(-4.0F, -5.0F, 5.0F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(10, 26).cuboid(-4.0F, -5.0F, -6.0F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 23).cuboid(-5.0F, -5.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(21, 18).cuboid(4.0F, -5.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(5, 5).cuboid(4.0F, -5.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(5, 0).cuboid(-5.0F, -5.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-4.0F, -6.0F, -5.0F, 8.0F, 2.0F, 10.0F, new Dilation(0.0F))
		.uv(26, 0).cuboid(4.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 26).cuboid(-5.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(MincepieEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}