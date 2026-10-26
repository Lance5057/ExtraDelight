package api.LanceNestAPI.src.data;

import api.LanceNestAPI.src.LanceNestAPI;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EnglishLoc extends LanguageProvider {

	public EnglishLoc(PackOutput output) {
		super(output, LanceNestAPI.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		this.add("button.widget.transform.copy", "Copy");
		this.add("button.widget.transform.paste", "Paste");
		this.add("button.widget.transform.delete", "Reset");

		this.add("button.widget.transform.copy.all", "Copy All");
		this.add("button.widget.transform.paste.all", "Paste All");

		this.add("tooltip.widget.transform.copy", "Copy to Clipboard");
		this.add("tooltip.widget.transform.paste", "Paste from Clipboard");
		this.add("tooltip.widget.transform.delete", "Reset to Default");

		this.add("tooltip.widget.transform.copy.all", "Copy All Transforms to Clipboard");
		this.add("tooltip.widget.transform.paste.all", "Paste All Transforms from Clipboard");

		this.add("tooltip.widget.vector.copy", "Copy Vector to Clipboard");
		this.add("tooltip.widget.vector.paste", "Paste Vector from Clipboard");
		this.add("tooltip.widget.vector.delete", "Reset Vector to Default");

		this.add("button.widget.advanced_display.switch", "Switch Screens");
		this.add("tooltip.widget.advanced_display.switch", "Switch between Editor and Inventory");

		this.add("widget.current", "Current");
		this.add("widget.origin", "Pivot Point");
		this.add("widget.rotation", "Rotation");
		this.add("widget.position", "Position");
		this.add("widget.scale", "Scale");

		this.add(LanceNestAPI.ADVANCED_DISPLAY_BLOCK.get(), "Advanced Item Display");
	}

}
