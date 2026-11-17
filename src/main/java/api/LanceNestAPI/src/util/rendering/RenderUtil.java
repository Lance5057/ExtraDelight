package api.LanceNestAPI.src.util.rendering;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector4f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import api.LanceNestAPI.src.client.BlacklistedModel;
import api.LanceNestAPI.src.util.rendering.animation.floats.AnimationFloatTransform;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.renderable.BakedModelRenderable;
import net.neoforged.neoforge.client.model.renderable.IRenderable;

public class RenderUtil {
	public static Vector4f getUV(ResourceLocation rc) {
		TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(rc);
		return getUVFromSprite(sprite);
	}

	public static Vector4f getUVFromSprite(TextureAtlasSprite sprite) {
		return new Vector4f(sprite.getU0(), sprite.getU1(), sprite.getV0(), sprite.getV1());
	}

	public static Vector4f getUVFromSprite(TextureAtlasSprite sprite, float offsetX, float offsetY, float width,
			float height) {
		float uUnit = (sprite.getU1() - sprite.getU0()) / 16;
		float vUnit = (sprite.getV1() - sprite.getV0()) / 16;

		float start0 = sprite.getU0() + (uUnit * offsetX);
		float start1 = sprite.getV0() + (vUnit * offsetY);

		float end0 = ((uUnit * width)) + start0;
		float end1 = ((vUnit * height)) + start1;

		return new Vector4f(start0, end0, start1, end1);
	}

	public static Quaternionf createQuaternion(float x, float y, float z, boolean degrees) {
		if (degrees) {
			x *= (float) (Math.PI / 180.0);
			y *= (float) (Math.PI / 180.0);
			z *= (float) (Math.PI / 180.0);
		}

		float f = Mth.sin(0.5F * x);
		float g = Mth.cos(0.5F * x);
		float h = Mth.sin(0.5F * y);
		float i = Mth.cos(0.5F * y);
		float j = Mth.sin(0.5F * z);
		float k = Mth.cos(0.5F * z);

		return new Quaternionf(f * i * k + g * h * j, g * h * k - f * i * j, f * h * k + g * i * j,
				g * i * k - f * h * j);
	}

	public static void buildPlane(Vec3 pos1, Vec3 pos2, Vec3 pos3, Vec3 pos4, VertexConsumer vertexConsumer,
			Matrix4f mat, Matrix3f normal, int tint, Vector4f uv, Vec3i vec3i, int light, int packedOverlay,
			PoseStack poseStack) {
		vertexConsumer.addVertex(mat, (float) pos1.x, (float) pos1.y, (float) pos1.z).setColor(tint).setUv(uv.x, uv.w)
				.setOverlay(packedOverlay).setLight(light).setNormal(vec3i.getX(), vec3i.getY(), vec3i.getZ());

		vertexConsumer.addVertex(mat, (float) pos2.x, (float) pos2.y, (float) pos2.z).setColor(tint).setUv(uv.y, uv.w)
				.setOverlay(packedOverlay).setLight(light).setNormal(vec3i.getX(), vec3i.getY(), vec3i.getZ());

		vertexConsumer.addVertex(mat, (float) pos3.x, (float) pos3.y, (float) pos3.z).setColor(tint).setUv(uv.y, uv.z)
				.setOverlay(packedOverlay).setLight(light).setNormal(vec3i.getX(), vec3i.getY(), vec3i.getZ());

		vertexConsumer.addVertex(mat, (float) pos4.x, (float) pos4.y, (float) pos4.z).setColor(tint).setUv(uv.x, uv.z)
				.setOverlay(packedOverlay).setLight(light).setNormal(vec3i.getX(), vec3i.getY(), vec3i.getZ());
	}

	public static void loadModel(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn,
			int combinedOverlayIn, BlacklistedModel model, float timer) {

		if (model.isBlock()) {
			IRenderable<ModelData> bm = BakedModelRenderable.of(ModelResourceLocation.standalone(model.rc()))
					.withModelDataContext();
			blockModel(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, bm, model.transform(), timer);

		} else

		{
			Item item = BuiltInRegistries.ITEM.get(model.rc());
			itemModel(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, new ItemStack(item),
					model.transform(), timer);
		}
	}

	public static void blockModel(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn,
			int combinedOverlayIn, IRenderable<ModelData> bm, AnimationFloatTransform transform, float timer) {
		matrixStackIn.pushPose();
		{

			matrixStackIn.translate(
					(transform.getLocation().getX().getOffset() + transform.getLocation().getX().animate(timer) / 16),
					(transform.getLocation().getY().getOffset() + transform.getLocation().getY().animate(timer) / 16),
					(transform.getLocation().getZ().getOffset() + transform.getLocation().getZ().animate(timer) / 16));

			matrixStackIn.mulPose(createQuaternion(
					transform.getRotation().getX().getOffset() + transform.getRotation().getX().animate(timer),
					transform.getRotation().getY().getOffset() + transform.getRotation().getY().animate(timer),
					transform.getRotation().getZ().getOffset() + transform.getRotation().getZ().animate(timer), true));

			matrixStackIn.translate(
					(transform.getPivot().getX().getOffset() + transform.getPivot().getX().animate(timer) / 16),
					(transform.getPivot().getY().getOffset() + transform.getPivot().getY().animate(timer) / 16),
					(transform.getPivot().getZ().getOffset() + transform.getPivot().getZ().animate(timer) / 16));

			matrixStackIn.scale(transform.getScale().getX().animate(timer), transform.getScale().getY().animate(timer),
					transform.getScale().getZ().animate(timer));

			bm.render(matrixStackIn, bufferIn, texture -> RenderType.entityTranslucent(texture), combinedLightIn,
					combinedOverlayIn, timer, ModelData.EMPTY);

		}
		matrixStackIn.popPose();

	}

	public static void itemModel(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn,
			int combinedOverlayIn, ItemStack item, AnimationFloatTransform transform, float timer) {
		if (item != null && !item.isEmpty()) {
			matrixStackIn.pushPose();
			{
				ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
				BakedModel bakedmodel = itemRenderer.getModel(item, null, null, 0);

				matrixStackIn.translate(
						(transform.getLocation().getX().getOffset()
								+ transform.getLocation().getX().animate(timer) / 16),
						(transform.getLocation().getY().getOffset()
								+ transform.getLocation().getY().animate(timer) / 16),
						(transform.getLocation().getZ().getOffset()
								+ transform.getLocation().getZ().animate(timer) / 16));

				matrixStackIn.mulPose(createQuaternion(
						transform.getRotation().getX().getOffset() + transform.getRotation().getX().animate(timer),
						transform.getRotation().getY().getOffset() + transform.getRotation().getY().animate(timer),
						transform.getRotation().getZ().getOffset() + transform.getRotation().getZ().animate(timer),
						true));

				matrixStackIn.translate(
						(transform.getPivot().getX().getOffset() + transform.getPivot().getX().animate(timer) / 16),
						(transform.getPivot().getY().getOffset() + transform.getPivot().getY().animate(timer) / 16),
						(transform.getPivot().getZ().getOffset() + transform.getPivot().getZ().animate(timer) / 16));

				matrixStackIn.scale(transform.getScale().getX().animate(timer),
						transform.getScale().getY().animate(timer), transform.getScale().getZ().animate(timer));

				itemRenderer.render(item, ItemDisplayContext.NONE, false, matrixStackIn, bufferIn, combinedLightIn,
						combinedOverlayIn, bakedmodel);

//				IRenderable<ModelData> bm = BakedModelRenderable
//						.of(ModelResourceLocation
//								.standalone(ResourceLocation.fromNamespaceAndPath(Compendium.MOD_ID, "extra/pivot_gizmo")))
//						.withModelDataContext();
//				bm.render(matrixStackIn, bufferIn, texture -> RenderType.entityTranslucent(texture), combinedLightIn,
//						combinedOverlayIn, timer, ModelData.EMPTY);
			}

			matrixStackIn.popPose();
		}
	}
}
