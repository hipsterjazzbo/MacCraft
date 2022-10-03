package hipsterjazzbo.maccraft.mixin;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({ContainerScreen.class})
public interface IHasContainerMixin {
    @Invoker
    void callSlotClicked(Slot p_97778_, int p_97779_, int p_97780_, ClickType p_97781_);

    @Accessor
    Slot getHoveredSlot();
}
