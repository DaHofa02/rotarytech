package xyz.dahofa.rotarytech.common.registry;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.dahofa.rotarytech.RotaryTech;

import java.util.function.Supplier;

public class RTItems {
    public static final DeferredRegister.Items BLOCKS = DeferredRegister.createItems(RotaryTech.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RotaryTech.MOD_ID);

    public static final DeferredItem<Item> STEEL_INGOT = registerItems("steel_ingot");
    public static final DeferredItem<Item> HSLA_STEEL_INGOT = registerItems("hsla_steel_ingot");

    public static <T extends Item> DeferredItem<T> registerItems(final String name, final Supplier<T> sup) {
        return ITEMS.register(name, sup);
    }

    public static Item.Properties defaultProps() {
        return new Item.Properties();
    }

    private static DeferredItem<Item> registerItems(final String name) {
        return registerItems(name, () -> new Item(RTItems.defaultProps()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
