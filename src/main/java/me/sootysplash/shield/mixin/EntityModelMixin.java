package me.sootysplash.shield.mixin;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HumanoidModel.class)
public abstract class EntityModelMixin {
	@Inject(at = @At("HEAD"), method = "poseBlockingArm", cancellable = true)
	private void render(ModelPart arm, boolean rightArm, CallbackInfo info) {
		info.cancel();
		arm.xRot = arm.xRot * 0.5f - 0.9424779f;
		arm.yRot = (rightArm ? -30.0f : 30.0f) * ((float)Math.PI / 180);
	}
}