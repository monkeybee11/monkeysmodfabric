// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package name.modid.monsters.client;

import name.modid.monsters.custom.CherryBombEntity;
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
   
public class CherryBombEntityModel extends EntityModel<CherryBombEntity> {
	private final ModelPart bb_main;
	public CherryBombEntityModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 8).cuboid(-5.0F, -6.0F, -6.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.0F, -6.0F, -4.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(12, 0).cuboid(-1.25F, -10.0F, -4.25F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(12, 8).cuboid(-2.8F, -1.7F, 0.6F, 3.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -11.5F, -3.25F, -0.4608F, 0.1393F, 0.2727F));

		bb_main.addChild("cube_r2", ModelPartBuilder.create().uv(15, 15).cuboid(1.0F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -8.0F, -3.75F, -0.2618F, 0.0F, 0.5672F));

		bb_main.addChild("cube_r3", ModelPartBuilder.create().uv(0, 16).cuboid(-1.5F, -3.25F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, -6.75F, -2.5F, 0.1745F, 0.0F, -0.6109F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(CherryBombEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}