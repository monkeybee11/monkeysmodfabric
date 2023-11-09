// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package name.modid.monsters.client;

import name.modid.monsters.custom.PineappleEntity;
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

public class PineappleEntityModel extends EntityModel<PineappleEntity> {
	private final ModelPart bb_main;

	public PineappleEntityModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(42, 44).cuboid(-3.0F, -12.0F, -7.0F, 6.0F, 8.0F, 2.0F, new Dilation(0.0F))
		.uv(14, 52).cuboid(3.0F, -12.0F, -5.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
		.uv(10, 38).cuboid(5.0F, -12.0F, -3.0F, 2.0F, 8.0F, 6.0F, new Dilation(0.0F))
		.uv(6, 52).cuboid(3.0F, -12.0F, 3.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
		.uv(44, 32).cuboid(-3.0F, -12.0F, 5.0F, 6.0F, 8.0F, 2.0F, new Dilation(0.0F))
		.uv(52, 0).cuboid(-5.0F, -12.0F, 3.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
		.uv(28, 32).cuboid(-7.0F, -12.0F, -3.0F, 2.0F, 8.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 44).cuboid(-5.0F, -12.0F, -5.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-3.0F, -18.0F, -3.0F, 6.0F, 16.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 24).cuboid(-5.0F, -16.0F, -3.0F, 2.0F, 14.0F, 6.0F, new Dilation(0.0F))
		.uv(34, 16).cuboid(-3.0F, -16.0F, 3.0F, 6.0F, 14.0F, 2.0F, new Dilation(0.0F))
		.uv(18, 18).cuboid(3.0F, -16.0F, -3.0F, 2.0F, 14.0F, 6.0F, new Dilation(0.0F))
		.uv(24, 0).cuboid(-3.0F, -16.0F, -5.0F, 6.0F, 14.0F, 2.0F, new Dilation(0.0F))
		.uv(10, 24).cuboid(-1.0F, -19.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(40, 0).cuboid(-5.6F, -25.0F, -3.0F, 0.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		bb_main.addChild("cube_r2", ModelPartBuilder.create().uv(50, 14).cuboid(-3.0F, -26.0F, -5.5F, 6.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		bb_main.addChild("cube_r3", ModelPartBuilder.create().uv(26, 40).cuboid(7.1F, -25.0F, -3.0F, 0.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		bb_main.addChild("cube_r4", ModelPartBuilder.create().uv(50, 23).cuboid(-3.0F, -25.0F, 5.6F, 6.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(PineappleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}