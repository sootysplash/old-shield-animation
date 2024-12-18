package me.sootysplash.shield.mixin;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
public abstract class EntityModelMixin {
	@Inject(at = @At("HEAD"), method = "positionBlockingArm", cancellable = true)
	private void render(ModelPart arm, boolean rightArm, CallbackInfo info) {
		info.cancel();
		arm.pitch = arm.pitch * 0.5f - 0.9424779f;
		arm.yaw = (rightArm ? -30.0f : 30.0f) * ((float)Math.PI / 180);
	}
}