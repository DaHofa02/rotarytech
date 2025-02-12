package xyz.dahofa.rotarytech;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import xyz.dahofa.rotarytech.common.registry.RTBlocks;
import xyz.dahofa.rotarytech.common.registry.RTCreativeModeTabs;
import xyz.dahofa.rotarytech.common.registry.RTItems;

@Mod(xyz.dahofa.rotarytech.RotaryTech.MOD_ID)
public class RotaryTech {
    public static final String MOD_ID = "rotarytech";

    public RotaryTech(IEventBus modEventBus, ModContainer modContainer) {
        IEventBus forgeBus = NeoForge.EVENT_BUS;
        registerAllDeferredRegistryObjects(modEventBus);
    }

    private void registerAllDeferredRegistryObjects(IEventBus modBus) {
        RTBlocks.register(modBus);
        RTItems.register(modBus);
        RTCreativeModeTabs.register(modBus);
    }
}
