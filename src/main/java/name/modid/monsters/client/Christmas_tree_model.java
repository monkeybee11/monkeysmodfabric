package name.modid.monsters.client;

import name.modid.monsters.custom.ChristmasTreeEntity;
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
public class Christmas_tree_model extends EntityModel<ChristmasTreeEntity> {

	public final ModelPart pot;
	public final ModelPart leaves;
	public final ModelPart torch;
	public final ModelPart baulbaul;
	public final ModelPart angel;
	public final ModelPart bb_main;
	
	public Christmas_tree_model(ModelPart root) {
		this.pot = root.getChild("pot");
		this.leaves = root.getChild("leaves");
		this.torch = root.getChild("torch");
		this.baulbaul = root.getChild("baulbaul");
		this.angel = root.getChild("angel");
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData pot = modelPartData.addChild("pot", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 38.0F, 0.0F));

		pot.addChild("cube_r1", ModelPartBuilder.create().uv(0, 26).cuboid(-4.0F, 12.0F, -4.0F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F))
		.uv(64, 15).cuboid(-4.0F, 11.0F, -5.0F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 40).cuboid(-5.0F, 11.0F, -5.0F, 1.0F, 1.0F, 10.0F, new Dilation(0.0F))
		.uv(36, 40).cuboid(4.0F, 11.0F, -5.0F, 1.0F, 1.0F, 10.0F, new Dilation(0.0F))
		.uv(60, 32).cuboid(-4.0F, 12.0F, 4.0F, 8.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(60, 47).cuboid(-4.0F, 12.0F, -5.0F, 8.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(14, 43).cuboid(-5.0F, 12.0F, -4.0F, 1.0F, 6.0F, 8.0F, new Dilation(0.0F))
		.uv(24, 49).cuboid(4.0F, 12.0F, -4.0F, 1.0F, 6.0F, 8.0F, new Dilation(0.0F))
		.uv(24, 47).cuboid(-4.0F, 11.0F, 4.0F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -20.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		ModelPartData leaves = modelPartData.addChild("leaves", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 38.0F, 0.0F));

		leaves.addChild("cube_r2", ModelPartBuilder.create().uv(12, 4).cuboid(-7.0F, -2.0F, -3.0F, 1.0F, 3.0F, 6.0F, new Dilation(0.0F))
		.uv(12, 4).cuboid(6.0F, -2.0F, -3.0F, 1.0F, 3.0F, 6.0F, new Dilation(0.0F))
		.uv(12, 8).cuboid(-3.0F, -2.0F, -7.0F, 6.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 8).cuboid(-3.0F, -2.0F, 6.0F, 6.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(64, 10).cuboid(-3.0F, 5.0F, 6.0F, 6.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(38, 65).cuboid(-3.0F, 5.0F, -8.0F, 6.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(56, 17).cuboid(-8.0F, 5.0F, -3.0F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F))
		.uv(12, 57).cuboid(6.0F, 5.0F, -3.0F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F))
		.uv(24, 43).cuboid(-4.0F, 5.0F, 5.0F, 8.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(34, 51).cuboid(-4.0F, 5.0F, -6.0F, 8.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 47).cuboid(-6.0F, 5.0F, -4.0F, 1.0F, 3.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 51).cuboid(5.0F, 5.0F, -4.0F, 1.0F, 3.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, 5.0F, -5.0F, 10.0F, 3.0F, 10.0F, new Dilation(0.0F))
		.uv(0, 6).cuboid(-2.0F, 3.0F, 6.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 19).cuboid(-2.0F, 3.0F, -7.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-7.0F, 3.0F, -2.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 13).cuboid(6.0F, 3.0F, -2.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(66, 17).cuboid(-3.0F, 3.0F, 5.0F, 6.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(66, 20).cuboid(-3.0F, 3.0F, -6.0F, 6.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 62).cuboid(-6.0F, 3.0F, -3.0F, 1.0F, 2.0F, 6.0F, new Dilation(0.0F))
		.uv(62, 61).cuboid(5.0F, 3.0F, -3.0F, 1.0F, 2.0F, 6.0F, new Dilation(0.0F))
		.uv(24, 27).cuboid(-4.0F, 3.0F, 4.0F, 8.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(64, 58).cuboid(-4.0F, 3.0F, -5.0F, 8.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(34, 55).cuboid(4.0F, 3.0F, -4.0F, 1.0F, 2.0F, 8.0F, new Dilation(0.0F))
		.uv(56, 0).cuboid(-5.0F, 3.0F, -4.0F, 1.0F, 2.0F, 8.0F, new Dilation(0.0F))
		.uv(30, 17).cuboid(-6.0F, 1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(36, 30).cuboid(5.0F, 1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(30, 5).cuboid(-2.0F, 1.0F, 5.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 40).cuboid(-2.0F, 1.0F, -6.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(66, 39).cuboid(-3.0F, 1.0F, 4.0F, 6.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(66, 42).cuboid(-3.0F, 1.0F, -5.0F, 6.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(22, 63).cuboid(-5.0F, 1.0F, -3.0F, 1.0F, 2.0F, 6.0F, new Dilation(0.0F))
		.uv(30, 65).cuboid(4.0F, 1.0F, -3.0F, 1.0F, 2.0F, 6.0F, new Dilation(0.0F))
		.uv(32, 5).cuboid(-4.0F, 1.0F, -4.0F, 8.0F, 4.0F, 8.0F, new Dilation(0.0F))
		.uv(24, 32).cuboid(-6.0F, -2.0F, -4.0F, 2.0F, 3.0F, 8.0F, new Dilation(0.0F))
		.uv(38, 29).cuboid(4.0F, -2.0F, -4.0F, 2.0F, 3.0F, 8.0F, new Dilation(0.0F))
		.uv(30, 0).cuboid(-4.0F, -2.0F, 4.0F, 8.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(50, 27).cuboid(-4.0F, -2.0F, -6.0F, 8.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, -2.0F, -5.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(6, 0).cuboid(-5.0F, -2.0F, 4.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 13).cuboid(4.0F, -2.0F, 4.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(6, 13).cuboid(4.0F, -2.0F, -5.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 18).cuboid(-4.0F, -3.0F, -4.0F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(48, 40).cuboid(-3.0F, -4.0F, -3.0F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(44, 58).cuboid(-2.0F, -8.0F, 2.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(52, 68).cuboid(-2.0F, -8.0F, -4.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(24, 30).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(66, 0).cuboid(-4.0F, -8.0F, -2.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(10, 66).cuboid(2.0F, -8.0F, -2.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(30, 17).cuboid(2.0F, -8.0F, 2.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(36, 17).cuboid(-3.0F, -8.0F, 2.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(36, 30).cuboid(-3.0F, -8.0F, -3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 40).cuboid(2.0F, -8.0F, -3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(52, 58).cuboid(-2.0F, -9.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -20.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		ModelPartData torch = modelPartData.addChild("torch", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 38.0F, 0.0F));

		torch.addChild("cube_r3", ModelPartBuilder.create().uv(57, 1).cuboid(3.0F, -5.0F, 1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(0.0F, -4.0F, -6.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(-4.0F, -2.0F, -7.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(-7.0F, -4.0F, -2.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(-6.0F, -3.0F, 4.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(-1.0F, -4.0F, 6.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(3.0F, -2.0F, 6.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(4.0F, 1.0F, 3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(7.0F, 3.0F, -3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(4.0F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(0.0F, 3.0F, -8.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(-4.0F, 4.0F, -7.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(-7.0F, 3.0F, -3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(-8.0F, 4.0F, 3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(-6.0F, 6.0F, 4.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(57, 1).cuboid(0.0F, 3.0F, 7.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -20.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		ModelPartData baulbaul = modelPartData.addChild("baulbaul", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 38.0F, 0.0F));

		baulbaul.addChild("cube_r4", ModelPartBuilder.create().uv(31, 6).cuboid(0.0F, 0.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(31, 6).cuboid(8.0F, 5.0F, -3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(31, 6).cuboid(3.0F, 2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(31, 6).cuboid(-1.0F, -4.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(31, 6).cuboid(-7.0F, 7.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(31, 6).cuboid(-5.0F, 1.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(31, 6).cuboid(-8.0F, 4.0F, 1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(31, 8).cuboid(4.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(31, 8).cuboid(5.0F, 2.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(31, 8).cuboid(4.0F, 5.0F, 5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(31, 8).cuboid(-3.0F, 5.0F, -9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(34, 3).cuboid(-7.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(34, 3).cuboid(0.0F, 7.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(34, 3).cuboid(2.0F, 4.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(34, 3).cuboid(-1.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(34, 3).cuboid(-4.0F, 2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(34, 3).cuboid(-4.0F, 4.0F, 5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -20.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		ModelPartData angel = modelPartData.addChild("angel", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 38.0F, 0.0F));

		angel.addChild("cube_r5", ModelPartBuilder.create().uv(15, 35).cuboid(1.5F, -16.0F, 0.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(15, 35).cuboid(-2.5F, -16.0F, 0.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(48, 18).cuboid(-1.75F, -14.5F, -1.75F, 3.5F, 1.0F, 3.5F, new Dilation(0.0F))
		.uv(24, 35).cuboid(-1.0F, -19.5F, -1.0F, 2.0F, 2.5F, 2.0F, new Dilation(0.0F))
		.uv(42, 7).cuboid(-1.5F, -17.0F, -1.5F, 3.0F, 2.5F, 3.0F, new Dilation(0.0F))
		.uv(42, 8).cuboid(-1.5F, -13.5F, -1.5F, 3.0F, 1.5F, 3.0F, new Dilation(0.0F))
		.uv(44, 7).cuboid(2.5F, -15.0F, -2.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(44, 7).cuboid(-4.5F, -15.0F, -2.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(44, 7).cuboid(1.5F, -19.0F, -2.5F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(44, 7).cuboid(-4.5F, -19.0F, -2.5F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 10).cuboid(-4.5F, -17.0F, -2.5F, 9.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 6).cuboid(-2.0F, -12.0F, -2.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -20.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 38.0F, 0.0F));

		bb_main.addChild("trunk_r1", ModelPartBuilder.create().uv(0, 26).cuboid(-1.0F, 8.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -20.0F, 0.0F, 3.1416F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(ChristmasTreeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		pot.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leaves.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		torch.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		baulbaul.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		angel.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}