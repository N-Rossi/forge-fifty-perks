package net.nrnj.fiftyperks.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nrnj.fiftyperks.FiftyPerksMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FiftyPerksMod.MOD_ID);

    public static final RegistryObject<Item> EMPTY_PERK = ITEMS.register("empty_perk",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ELEMENT_115 = ITEMS.register("raw_element_115",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELEMENT_115_CRYSTAL = ITEMS.register("element_115_crystal",
            () -> new Item(new Item.Properties()));

    /** Perks */
    public static final RegistryObject<Item> VOLTAGE_VIAL_PERK = ITEMS.register("voltage_vial_perk", () -> new Item(new Item.Properties().food(ModFoods.VOLTAGE_VIAL_PERK)));

    public static final RegistryObject<Item> JUGGERNOG_PERK = ITEMS.register("juggernog_perk", () -> new Item(new Item.Properties().food(ModFoods.JUGGERNOG_PERK)));
    public static final RegistryObject<Item> QUICK_REVIVE_PERK = ITEMS.register("quick_revive_perk", () -> new Item(new Item.Properties().food(ModFoods.QUICK_REVIVE_PERK)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
