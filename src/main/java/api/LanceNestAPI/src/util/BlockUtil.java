package api.LanceNestAPI.src.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.core.BlockPos;

public class BlockUtil {
	public static final List<BlockPos> THREERADIUS = ((Supplier<List<BlockPos>>) () -> {
		List<BlockPos> p = new ArrayList<BlockPos>();
		for (int x = -1; x <= 1; x++)
			for (int y = -1; y <= 1; y++)
				for (int z = -1; z <= 1; z++)
					p.add(new BlockPos(x, y, z));

		return p;
	}).get();
}
