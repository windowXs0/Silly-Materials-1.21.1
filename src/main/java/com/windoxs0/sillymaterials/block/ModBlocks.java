package com.windoxs0.sillymaterials.block;

import com.windoxs0.sillymaterials.Sillymaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block COLONTHREESIUM_DEPOSIT = registerBlock("colonthreesium_deposit",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,5),AbstractBlock.Settings.create().strength(5f)
                .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Sillymaterials.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Sillymaterials.MOD_ID, name),
                new BlockItem(block, new Item.Settings())
        );
    }
    public static void registerModBlocks() {
        Sillymaterials.LOGGER.info("Registering Mod Blocks for " + Sillymaterials.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.COLONTHREESIUM_DEPOSIT);
        });
    }
}
