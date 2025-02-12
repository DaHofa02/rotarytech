package xyz.dahofa.rotarytech.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.DisplayItemsGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.dahofa.rotarytech.RotaryTech;
import xyz.dahofa.rotarytech.api.item.ICreativeTabStackProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RTCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RotaryTech.MOD_ID);

    public static final Supplier<CreativeModeTab> BLOCKS = TABS.register("blocks", RTCreativeModeTabs::buildBlocksTab);
    public static final Supplier<CreativeModeTab> ITEMS = TABS.register("items", RTCreativeModeTabs::buildItemsTab);

    private static CreativeModeTab buildBlocksTab() {
        return buildTab("itemGroup.rotarytech.blocks", RTBlocks.STEEL_BLOCK.get(), RTCreativeModeTabs::genDisplayBlocks);
    }

    private static CreativeModeTab buildItemsTab() {
        return buildTab("itemGroup.rotarytech.items", RTItems.STEEL_INGOT.get(), RTCreativeModeTabs::genDisplayItems);
    }

    private static void genDisplayBlocks(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output) {
        output.acceptAll(genDisplay(RTItems.BLOCKS));
    }

    private static void genDisplayItems(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output) {
        output.acceptAll(genDisplay(RTItems.ITEMS));
    }

    private static List<ItemStack> genDisplay(DeferredRegister.Items itemCategory) {
        return itemCategory.getEntries().stream()
                .flatMap(ro -> stacksForItem(ro.get()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static CreativeModeTab buildTab(String name, ItemLike icon, DisplayItemsGenerator itemsGenerator) {
        return CreativeModeTab.builder()
                .title(Component.translatable(name))
                .icon(() -> new ItemStack(icon))
                .displayItems(itemsGenerator)
                .build();
    }

    private static Stream<ItemStack> stacksForItem(Item item) {
        ItemStack stack = new ItemStack(item);
        switch (item) {
            case ICreativeTabStackProvider provider -> {
                return provider.getStacksForItem();
            }
            case BlockItem bi when bi.getBlock() instanceof ICreativeTabStackProvider provider -> {
                return provider.getStacksForItem();
            }
            default -> {
                return Stream.of(stack);
            }
        }
    }

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
