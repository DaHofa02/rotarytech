package xyz.dahofa.rotarytech.api.item;

import net.minecraft.world.item.ItemStack;

import java.util.stream.Stream;

public interface ICreativeTabStackProvider {
    Stream<ItemStack> getStacksForItem();
}
