package me.sootysplash.shield.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
	@Inject(method = "getMaxRelativeHeadRotation", at = @At("HEAD"), cancellable = true)
	public void headRotationHook(CallbackInfoReturnable<Float> cir) {
		cir.setReturnValue(50.0f);
		cir.cancel();
	}
}