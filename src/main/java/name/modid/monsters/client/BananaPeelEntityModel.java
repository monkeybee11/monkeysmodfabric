package name.modid.monsters.client;

import name.modid.monsters.custom.BananaPeelEntity;
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


public class BananaPeelEntityModel extends EntityModel<BananaPeelEntity> {
	private final ModelPart bb_main;
	public BananaPeelEntityModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 6).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(7, 13).cuboid(-0.5F, -6.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(8, 7).cuboid(-1.8839F, 0.0303F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5F, 2.5F, -1.5708F, -0.7854F, 1.5708F));

		bb_main.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-0.1711F, -0.0163F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5F, 2.5F, -1.5708F, -1.1345F, 1.5708F));

		bb_main.addChild("cube_r3", ModelPartBuilder.create().uv(6, 10).cuboid(-1.8839F, 0.0303F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5F, -2.5F, 1.5708F, 0.7854F, 1.5708F));

		bb_main.addChild("cube_r4", ModelPartBuilder.create().uv(0, 3).cuboid(-0.1711F, -0.0163F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5F, -2.5F, 1.5708F, 1.1345F, 1.5708F));

		bb_main.addChild("cube_r5", ModelPartBuilder.create().uv(0, 11).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -1.75F, 0.0F, 0.0F, 0.0F, -0.7854F));

		bb_main.addChild("cube_r6", ModelPartBuilder.create().uv(12, 11).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -1.75F, 0.0F, 0.0F, 0.0F, 0.7854F));

		bb_main.addChild("cube_r7", ModelPartBuilder.create().uv(8, 1).cuboid(-1.5F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.5F, -0.5F, 0.0F, 0.0F, 0.0F, -0.4363F));

		bb_main.addChild("cube_r8", ModelPartBuilder.create().uv(8, 4).cuboid(-1.5F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.4363F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(BananaPeelEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}