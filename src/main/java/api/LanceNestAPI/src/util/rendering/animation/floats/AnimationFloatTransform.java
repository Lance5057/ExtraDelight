package api.LanceNestAPI.src.util.rendering.animation.floats;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class AnimationFloatTransform {
	public static final Codec<AnimationFloatTransform> CODEC = RecordCodecBuilder.create(inst -> inst
			.group(AnimatedFloatVector3.CODEC.fieldOf("location").forGetter(a -> a.loc),
					AnimatedFloatVector3.CODEC.fieldOf("scale").forGetter(a -> a.scale),
					AnimatedFloatVector3.CODEC.fieldOf("rotation").forGetter(a -> a.rot),
					AnimatedFloatVector3.CODEC.fieldOf("pivot").forGetter(a -> a.pivot))
			.apply(inst, AnimationFloatTransform::new));

	public static final StreamCodec<RegistryFriendlyByteBuf, AnimationFloatTransform> STREAM_CODEC = StreamCodec
			.of(AnimationFloatTransform::write, AnimationFloatTransform::read);

	AnimatedFloatVector3 loc = AnimatedFloatVector3.ZERO;
	AnimatedFloatVector3 scale = AnimatedFloatVector3.ZERO;
	AnimatedFloatVector3 rot = AnimatedFloatVector3.ZERO;
	AnimatedFloatVector3 pivot = AnimatedFloatVector3.ZERO;

	public static AnimationFloatTransform ZERO = new AnimationFloatTransform(AnimatedFloatVector3.ZERO,
			AnimatedFloatVector3.ONE, AnimatedFloatVector3.ZERO, AnimatedFloatVector3.ZERO);
	public static AnimationFloatTransform ONE = new AnimationFloatTransform(AnimatedFloatVector3.ONE,
			AnimatedFloatVector3.ONE, AnimatedFloatVector3.ONE, AnimatedFloatVector3.ONE);

	public AnimationFloatTransform() {
//		loc = AnimatedFloatVector3.ZERO;
//		rot = AnimatedFloatVector3.ZERO;
//		scale = AnimatedFloatVector3.ONE;
//		pivot = AnimatedFloatVector3.ZERO;
	}

	public AnimationFloatTransform(AnimatedFloatVector3 l, AnimatedFloatVector3 s, AnimatedFloatVector3 r,
			AnimatedFloatVector3 p) {
		loc = l;
		scale = s;
		rot = r;
		pivot = p;
	}

	public void animate(float time) {
		loc.animate(time);
		scale.animate(time);
		rot.animate(time);
		pivot.animate(time);
	}

	public AnimationFloatTransform setLocation(AnimatedFloatVector3 in) {
		loc = in;

		return this;
	}

	public AnimationFloatTransform setLocation(float x, float y, float z) {
		loc = new AnimatedFloatVector3(x, y, z);

		return this;
	}

	public AnimationFloatTransform setRotation(AnimatedFloatVector3 in) {
		rot = in;

		return this;
	}

	public AnimationFloatTransform setRotation(float x, float y, float z) {
		rot = new AnimatedFloatVector3(x, y, z);

		return this;
	}

	public AnimationFloatTransform setScale(AnimatedFloatVector3 in) {
		scale = in;

		return this;
	}

	public AnimationFloatTransform setScale(float in) {
		scale = new AnimatedFloatVector3(in);

		return this;
	}

	public AnimationFloatTransform setPivot(AnimatedFloatVector3 in) {
		pivot = in;

		return this;
	}

	public AnimatedFloatVector3 getLocation() {
		return loc;
	}

	public AnimatedFloatVector3 getScale() {
		return scale;
	}

	public AnimatedFloatVector3 getRotation() {
		return rot;
	}

	public AnimatedFloatVector3 getPivot() {
		return pivot;
	}

	private static AnimationFloatTransform read(RegistryFriendlyByteBuf buffer) {
		AnimatedFloatVector3 l = AnimatedFloatVector3.STREAM_CODEC.decode(buffer);
		AnimatedFloatVector3 r = AnimatedFloatVector3.STREAM_CODEC.decode(buffer);
		AnimatedFloatVector3 s = AnimatedFloatVector3.STREAM_CODEC.decode(buffer);
		AnimatedFloatVector3 p = AnimatedFloatVector3.STREAM_CODEC.decode(buffer);
		return new AnimationFloatTransform(l, s, r, p);
	}

	private static void write(RegistryFriendlyByteBuf buffer, AnimationFloatTransform af) {
		AnimatedFloatVector3.STREAM_CODEC.encode(buffer, af.loc);
		AnimatedFloatVector3.STREAM_CODEC.encode(buffer, af.rot);
		AnimatedFloatVector3.STREAM_CODEC.encode(buffer, af.scale);
		AnimatedFloatVector3.STREAM_CODEC.encode(buffer, af.pivot);
	}

	public String clipboardData() {
		String s = "new AnimationFloatTransform()";
		if (!this.rot.equals(AnimatedFloatVector3.ZERO))
			s += String.format(".setRotation(%s)", this.rot.clipboardData());
		if (!this.loc.equals(AnimatedFloatVector3.ZERO))
			s += String.format(".setLocation(%s)", this.loc.clipboardData());
		if (!this.scale.equals(AnimatedFloatVector3.ZERO))
			s += String.format(".setScale(%s)", this.scale.clipboardData());
		if (!this.pivot.equals(AnimatedFloatVector3.ZERO))
			s += String.format(".setPivot(%s)", this.pivot.clipboardData());
		return s + ")";
	}
}
