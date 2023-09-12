package com.lance5057.extradelight.util;

import org.apache.commons.lang3.ArrayUtils;

public class MathUtil {

	public static float blockAngles[] = { 0, 22.5f, 45, 67.5f, 90, 112.5f, 135, 157.5f, 180, 202.5f, 225, 247.5f, 270,
			292.5f, 315, 337.5f };

	public static float clamp(float value, float min, float max) {
		return Math.max(min, Math.min(max, value));
	}

	public static float search(float value) {

		if (value < blockAngles[0]) {
			return blockAngles[0];
		}
		if (value > blockAngles[blockAngles.length - 1]) {
			return blockAngles[blockAngles.length - 1];
		}

		int lo = 0;
		int hi = blockAngles.length - 1;

		while (lo <= hi) {
			int mid = (hi + lo) / 2;

			if (value < blockAngles[mid]) {
				hi = mid - 1;
			} else if (value > blockAngles[mid]) {
				lo = mid + 1;
			} else {
				return blockAngles[mid];
			}
		}
		// lo == hi + 1
		return (blockAngles[lo] - value) < (value - blockAngles[hi]) ? blockAngles[lo] : blockAngles[hi];
	}
	
	public static int getAngleIndex(float value)
	{
		return ArrayUtils.indexOf(blockAngles, value);
	}
}
