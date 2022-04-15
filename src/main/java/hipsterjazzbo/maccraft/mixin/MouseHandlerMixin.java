package hipsterjazzbo.maccraft.mixin;

import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({MouseHandler.class})
public class MouseHandlerMixin {
    //Doubles and longs are counted twice, index 5 is vertical in onMouseScroll.
    @ModifyVariable(method = "onScroll", at = @At("HEAD"), index = 5, argsOnly = true)
    private double scrollFix(double vertical1, long window, double horizontal, double vertical2) {
        return vertical1 == 0 ? horizontal : vertical1;
    }
}
