package xyz.dahofa.rotarytech.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.dahofa.rotarytech.RotaryTech;
import xyz.dahofa.rotarytech.common.registry.RTBlocks;

import java.util.concurrent.CompletableFuture;

public class RTBlockTagProvider extends BlockTagsProvider {
    public RTBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RotaryTech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(RTBlocks.STEEL_BLOCK.get())
                .add(RTBlocks.HSLA_STEEL_BLOCK.get());
    }
}
