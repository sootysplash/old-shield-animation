package me.sootysplash.shield.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerEntityMixin {
	@Inject(method = "getMaxHeadRotationRelativeToBody", at = @At("HEAD"), cancellable = true)
	public void headRotationHook(CallbackInfoReturnable<Float> cir) {
		cir.setReturnValue(50.0f);
		cir.cancel();
	}
}