package dev.chemthunder.northstar.init;

import dev.chemthunder.northstar.Northstar;
import dev.chemthunder.northstar.item.custom.AssemblyItem;
import dev.chemthunder.northstar.item.weaponry.GlaiveItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

import static net.acoyt.acornlib.api.util.ItemUtils.modifyItemNameColor;

public interface NorthItems {

   Item LUMIUM_INGOT = create("lumium_ingot", Item::new, new Item.Settings()
           .fireproof()
           );

   Item STEELBOUND_GLAIVE = create("steelbound_glaive", GlaiveItem::new, new Item.Settings()
           .maxCount(1)
           .fireproof()
           .sword(ToolMaterial.NETHERITE, 2, -2.1f)
           );

   Item CROSSFIRE_ASSEMBLY = create("crossfire_assembly", AssemblyItem::new, new Item.Settings()
           .maxCount(1)
           .fireproof());





    static Item create(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return Items.register(RegistryKey.of(RegistryKeys.ITEM, Northstar.id(name)), factory, settings);
    }

    static void init() {
        modifyItemNameColor(STEELBOUND_GLAIVE, 0x9999999);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(NorthItems::addCombatEntries);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(NorthItems::addIngredientEntries);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(NorthItems::addFoodEntries);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(NorthItems::addToolsEntries);




    }


    private static void addCombatEntries(FabricItemGroupEntries entries) {
        entries.add(STEELBOUND_GLAIVE);
    }



    private static void addToolsEntries(FabricItemGroupEntries entries) {
    }

    private static void addIngredientEntries(FabricItemGroupEntries entries) {
        entries.add(LUMIUM_INGOT);
    }

    private static void addFoodEntries(FabricItemGroupEntries entries) {
    }
}
