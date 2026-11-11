package dev.enderdevelopment.sharpness250;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class Sharpness250BookMod implements ModInitializer {
    public static final String MOD_ID = "sharpness250book";
    public static final Item SHARPNESS_250_BOOK = Registry.register(
            Registries.ITEM,
            new Identifier(MOD_ID, "sharpness_250_book"),
            new Sharpness250BookItem(new Item.Settings().maxCount(1))
    );

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register(entries -> entries.add(SHARPNESS_250_BOOK));
    }
}
