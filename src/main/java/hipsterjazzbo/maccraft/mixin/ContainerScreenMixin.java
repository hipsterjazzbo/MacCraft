package hipsterjazzbo.maccraft.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({ContainerScreen.class})
public class ContainerScreenMixin {
    @Redirect(
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screen/inventory/ContainerScreen;slotClicked(Lnet/minecraft/inventory/container/Slot;IILnet/minecraft/inventory/container/ClickType;)V",
                    ordinal = 1
            ),
            method = "keyPressed(III)Z"
    )
    public void slotClicked(ContainerScreen instance, Slot p_184098_1_, int p_184098_2_, int p_184098_3_, ClickType p_184098_4_) {
        boolean hasMetaKeyDown = Minecraft.ON_OSX ? Screen.hasAltDown() : Screen.hasControlDown();

        ((IHasContainerMixin) instance).callSlotClicked(
                ((IHasContainerMixin) instance).getHoveredSlot(),
                ((IHasContainerMixin) instance).getHoveredSlot().index,
                hasMetaKeyDown ? 1 : 0,
                ClickType.THROW
        );
    }
}
