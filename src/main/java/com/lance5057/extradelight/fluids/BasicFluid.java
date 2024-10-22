package com.lance5057.extradelight.fluids;

import java.util.function.Consumer;

import org.antlr.v4.runtime.misc.NotNull;
import org.joml.Vector3f;

import com.lance5057.extradelight.ExtraDelight;
import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;

public class BasicFluid extends FluidType {

	private final ResourceLocation STILL;
	private final ResourceLocation FLOW;
	private final ResourceLocation OVERLAY;
	private final ResourceLocation VIEW_OVERLAY;

	final int tint;
	final int overlay_tint;

	float far = 24f;
	float near = -48f;

	public BasicFluid(String name, int tint, int overlay, Properties properties) {
		super(properties);

		STILL = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "liquid/" + name + "_still");
		FLOW = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "liquid/" + name + "_flow");
		OVERLAY = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "liquid/" + name + "_still");
		VIEW_OVERLAY = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
				"textures/liquid/" + name + "_overlay.png");

		this.tint = tint;
		this.overlay_tint = overlay;
	}

	public BasicFluid(int tint, int overlay, Properties properties) {
		super(properties);

		STILL = ResourceLocation.withDefaultNamespace("block/water_still");
		FLOW = ResourceLocation.withDefaultNamespace("block/water_flow");
		OVERLAY = ResourceLocation.withDefaultNamespace("block/water_still");
		VIEW_OVERLAY = ResourceLocation.withDefaultNamespace("textures/block/water_still.png");

		this.tint = tint;
		this.overlay_tint = overlay;
	}

	public BasicFluid setFarDistance(float d) {
		far = d;
		return this;
	}

	public BasicFluid setNearDistance(float d) {
		near = d;
		return this;
	}

	@Override
	public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
		consumer.accept(new IClientFluidTypeExtensions() {

			@Override
			public ResourceLocation getStillTexture() {
				return STILL;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return FLOW;
			}

			@Override
			public ResourceLocation getOverlayTexture() {
				return OVERLAY;
			}

			@Override
			public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
				return VIEW_OVERLAY;
			}

			@Override
			public int getTintColor() {
				return tint;
			}

			public int getOverlayTint() {
				return overlay_tint;
			}

			public float getNearFog() {
				return near;
			}

			public float getFarFog() {
				return far;
			}

			@Override
			public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level,
					int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
				int color = this.getOverlayTint();
				return new Vector3f((color >> 16 & 0xFF) / 255F * 0.75f, (color >> 8 & 0xFF) / 255F * 0.75f, (color & 0xFF) / 255F * 0.75f);
			}

			@Override
			public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance,
					float partialTick, float nearDistance, float farDistance, FogShape shape) {
				nearDistance = getNearFog();
				farDistance = getFarFog();

				if (farDistance > renderDistance) {
					farDistance = renderDistance;
					shape = FogShape.CYLINDER;
				}

				RenderSystem.setShaderFogStart(nearDistance);
				RenderSystem.setShaderFogEnd(farDistance);
				RenderSystem.setShaderFogShape(shape);
			}
		});
	}
}
