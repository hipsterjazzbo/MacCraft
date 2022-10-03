package hipsterjazzbo.maccraft.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({Minecraft.class})
public class MinecraftMixin {
    @Redirect(
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/entity/player/ClientPlayerEntity;drop(Z)Z"
            ),
            method = "handleKeybinds()V"
    )
    public boolean drop(ClientPlayerEntity instance, boolean p_108701_) {
        return instance.drop(Minecraft.ON_OSX ? Screen.hasAltDown() : Screen.hasControlDown());
    }
}
