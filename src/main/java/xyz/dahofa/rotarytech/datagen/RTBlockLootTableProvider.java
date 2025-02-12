package xyz.dahofa.rotarytech.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import xyz.dahofa.rotarytech.common.registry.RTBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RTBlockLootTableProvider extends BlockLootSubProvider {
    protected RTBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        for (var holder : RTBlocks.BLOCKS.getEntries()) {
            Block b = holder.get();
            if (b.asItem() != Items.AIR) {
                dropSelf(b);
            }
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> l = new ArrayList<>();
        for (var holder : RTBlocks.BLOCKS.getEntries()) {
            if (BuiltInRegistries.ITEM.containsKey(holder.getId())) {
                l.add(holder.get());
            }
        }
        return l;
    }
}
