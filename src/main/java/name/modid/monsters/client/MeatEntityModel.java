package name.modid.monsters.client;

import name.modid.monsters.custom.MeatEntity;
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

public class MeatEntityModel extends EntityModel<MeatEntity> {
	private final ModelPart bb_main;
	public MeatEntityModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(12, 34).cuboid(-8.0F, -10.0F, -2.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(46, 37).cuboid(-8.0F, -11.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(46, 32).cuboid(-8.0F, -8.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 33).cuboid(6.0F, -10.0F, -2.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(8, 33).cuboid(6.0F, -11.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(12, 21).cuboid(6.0F, -8.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 17).cuboid(-6.0F, -10.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-4.0F, -14.0F, -4.0F, 8.0F, 9.0F, 8.0F, new Dilation(0.0F))
		.uv(20, 47).cuboid(-1.0F, -12.0F, -5.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 27).cuboid(-1.0F, -15.0F, -2.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(8, 40).cuboid(-1.0F, -5.0F, -2.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, -12.0F, 4.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 6).cuboid(-5.0F, -12.0F, 4.0F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(28, 27).cuboid(1.0F, -12.0F, 4.0F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(40, 0).cuboid(-5.0F, -15.0F, 3.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(34, 39).cuboid(1.0F, -15.0F, 3.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(22, 39).cuboid(-5.0F, -7.0F, 3.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 39).cuboid(1.0F, -7.0F, 3.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(10, 46).cuboid(-5.0F, -15.0F, 2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 45).cuboid(1.0F, -15.0F, 2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(39, 44).cuboid(-5.0F, -6.0F, 2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(29, 44).cuboid(1.0F, -6.0F, 2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 27).cuboid(-5.0F, -16.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(24, 0).cuboid(1.0F, -16.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(16, 21).cuboid(1.0F, -5.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 21).cuboid(-5.0F, -5.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(19, 44).cuboid(-5.0F, -6.0F, -3.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(38, 22).cuboid(-5.0F, -7.0F, -5.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(28, 17).cuboid(-5.0F, -12.0F, -6.0F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(38, 13).cuboid(-5.0F, -15.0F, -5.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(44, 8).cuboid(-5.0F, -15.0F, -3.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(42, 5).cuboid(1.0F, -6.0F, -3.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(36, 34).cuboid(1.0F, -7.0F, -5.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(16, 27).cuboid(1.0F, -12.0F, -6.0F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(24, 34).cuboid(1.0F, -15.0F, -5.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(40, 18).cuboid(1.0F, -15.0F, -3.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(MeatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}