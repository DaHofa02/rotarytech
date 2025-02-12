package xyz.dahofa.rotarytech.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.dahofa.rotarytech.RotaryTech;
import xyz.dahofa.rotarytech.common.registry.RTItems;

public class RTItemModelProvider extends ItemModelProvider {
    public RTItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RotaryTech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerItems(RTItems.ITEMS);
    }

    private void registerItems(DeferredRegister.Items items) {
        for (var holder : items.getEntries()) {
            Item i = holder.get();
            if (i.asItem() != Items.AIR) {
                basicItem(i);
            }
        }
    }
}
