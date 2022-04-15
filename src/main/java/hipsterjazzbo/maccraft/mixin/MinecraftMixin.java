package hipsterjazzbo.maccraft.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({Minecraft.class})
public class MinecraftMixin {
    @Redirect(
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/player/LocalPlayer;drop(Z)Z"
            ),
            method = "Lnet/minecraft/client/Minecraft;handleKeybinds()V"
    )
    public boolean drop(LocalPlayer instance, boolean p_108701_) {
        return instance.drop(Minecraft.ON_OSX ? Screen.hasAltDown() : Screen.hasControlDown());
    }
}
