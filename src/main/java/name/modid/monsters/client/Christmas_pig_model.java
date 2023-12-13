package name.modid.monsters.client;

import name.modid.monsters.custom.SantaPigEntity;
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
public class Christmas_pig_model extends EntityModel<SantaPigEntity> {
	private final ModelPart body;

	public Christmas_pig_model(ModelPart root) {
		this.body = root.getChild("body");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 11.0F, 2.0F));

		body.addChild("body_r1", ModelPartBuilder.create().uv(28, 8).cuboid(-5.0F, -10.0F, -7.0F, 10.0F, 16.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(16, 16).cuboid(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, -8.0F));

		head.addChild("head_r1", ModelPartBuilder.create().uv(17, 20).mirrored().cuboid(-5.0F, -11.3F, -2.25F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.8815F, -2.9372F, 4.0052F, 0.4699F, -0.1925F, -0.3444F));

		head.addChild("head_r2", ModelPartBuilder.create().uv(21, 21).mirrored().cuboid(-2.3F, -7.6F, 7.75F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.8815F, -2.9372F, 4.0052F, 2.4771F, -1.094F, -2.1002F));

		head.addChild("head_r3", ModelPartBuilder.create().uv(21, 20).mirrored().cuboid(-5.0F, -8.8F, -6.0F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.8815F, -2.9372F, 4.0052F, -0.1409F, -0.1925F, -0.3444F));

		head.addChild("head_r4", ModelPartBuilder.create().uv(21, 23).mirrored().cuboid(-5.0F, -10.8F, -2.25F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0781F, -5.0319F, 4.5786F, 0.4094F, -0.3045F, -0.1001F));

		head.addChild("head_r5", ModelPartBuilder.create().uv(17, 20).cuboid(4.0F, -10.8F, -2.25F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0781F, -5.0319F, 4.5786F, 0.4094F, 0.3045F, 0.1001F));

		head.addChild("head_r6", ModelPartBuilder.create().uv(17, 20).cuboid(1.3F, -7.6F, 7.75F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.8815F, -2.9372F, 4.0052F, 2.4771F, 1.094F, 2.1002F));

		head.addChild("head_r7", ModelPartBuilder.create().uv(16, 20).cuboid(4.0F, -11.3F, -2.25F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.8815F, -2.9372F, 4.0052F, 0.4699F, 0.1925F, 0.3444F));

		head.addChild("head_r8", ModelPartBuilder.create().uv(21, 20).cuboid(4.0F, -8.8F, -6.0F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.8815F, -2.9372F, 4.0052F, -0.1409F, 0.1925F, 0.3444F));

		body.addChild("leg0", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 7.0F, 5.0F));

		body.addChild("leg1", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, 7.0F, 5.0F));

		body.addChild("leg2", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 7.0F, -7.0F));

		body.addChild("leg3", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, 7.0F, -7.0F));
		return TexturedModelData.of(modelData, 64, 32);
	}
	@Override
	public void setAngles(SantaPigEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}