package api.LanceNestAPI.src;

import api.LanceNestAPI.src.AdvancedDisplay.AdvancedDisplayBlockRenderer;
import api.LanceNestAPI.src.AdvancedDisplay.AdvancedDisplayScreen;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

public class LanceNestAPIClient {
	public static void setTERenderers() {
		BlockEntityRenderers.register(LanceNestAPI.ADVANCED_DISPLAY_ENTITY.get(), AdvancedDisplayBlockRenderer::new);
	}

	public static void registerClient(RegisterMenuScreensEvent event) {
		event.register(LanceNestAPI.ADVANCED_DISPLAY_MENU.get(), AdvancedDisplayScreen::new);
	}
}
