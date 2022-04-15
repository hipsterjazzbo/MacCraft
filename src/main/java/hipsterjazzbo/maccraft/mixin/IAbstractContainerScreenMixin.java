package hipsterjazzbo.maccraft.mixin;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({AbstractContainerScreen.class})
public interface IAbstractContainerScreenMixin {
    @Invoker void callSlotClicked(Slot p_97778_, int p_97779_, int p_97780_, ClickType p_97781_);

    @Accessor Slot getHoveredSlot();
}
