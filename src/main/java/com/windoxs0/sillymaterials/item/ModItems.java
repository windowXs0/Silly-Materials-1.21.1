package com.windoxs0.sillymaterials.item;

import com.windoxs0.sillymaterials.Sillymaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COLONTHREESIUM = registerItem("colonthreesium", new Item(new Item.Settings()));
    public static final Item COLONTHREESIUM_NUGGETS = registerItem("colonthreesium_nuggets", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Sillymaterials.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Sillymaterials.LOGGER.info("Registering Mod Items for " + Sillymaterials.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(COLONTHREESIUM);
            entries.add(COLONTHREESIUM_NUGGETS);
        });
    }
}
