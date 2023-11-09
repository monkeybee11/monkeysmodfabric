package name.modid.monsters.client;

import name.modid.monsters.custom.BananaEntity;
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

public class BananaEntityModel extends EntityModel<BananaEntity> {
	private final ModelPart bb_main;
	public BananaEntityModel(ModelPart root) {
		
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -5.0F, -8.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 28).cuboid(-2.0F, -6.0F, -6.0F, 4.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 14).cuboid(-3.0F, -7.0F, -5.0F, 6.0F, 6.0F, 8.0F, new Dilation(0.0F))
		.uv(20, 14).cuboid(-2.0F, -7.0F, 3.0F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(20, 0).cuboid(-2.0F, -4.0F, -16.0F, 4.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(24, 24).cuboid(-1.0F, -3.0F, -18.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-3.0F, -5.0F, -15.0F, 6.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(BananaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}