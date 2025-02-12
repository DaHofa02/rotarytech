package xyz.dahofa.rotarytech.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import xyz.dahofa.rotarytech.RotaryTech;
import xyz.dahofa.rotarytech.common.registry.RTBlocks;

public class RTBlockStateProvider extends BlockStateProvider {

    public RTBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RotaryTech.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerBlocks();
    }

    private void registerBlocks() {
        ItemModelProvider itemModelProvider = itemModels();
        blockWithItem(RTBlocks.STEEL_BLOCK.get());
        blockWithItem(RTBlocks.HSLA_STEEL_BLOCK.get());
    }

    private void blockWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }
}
