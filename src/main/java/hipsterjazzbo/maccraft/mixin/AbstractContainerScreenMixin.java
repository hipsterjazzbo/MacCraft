package hipsterjazzbo.maccraft.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({AbstractContainerScreen.class})
public class AbstractContainerScreenMixin {
    @Redirect(
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;slotClicked(Lnet/minecraft/world/inventory/Slot;IILnet/minecraft/world/inventory/ClickType;)V",
                    ordinal = 1
            ),
            method = "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;keyPressed(III)Z"
    )
    public void slotClicked(AbstractContainerScreen instance, Slot p_97778_, int p_97779_, int p_97780_, ClickType p_97781_) {
        boolean hasMetaKeyDown = Minecraft.ON_OSX ? Screen.hasAltDown() : Screen.hasControlDown();

        ((IAbstractContainerScreenMixin) instance).callSlotClicked(
                ((IAbstractContainerScreenMixin) instance).getHoveredSlot(),
                ((IAbstractContainerScreenMixin) instance).getHoveredSlot().index,
                hasMetaKeyDown ? 1 : 0,
                ClickType.THROW
        );
    }
}
