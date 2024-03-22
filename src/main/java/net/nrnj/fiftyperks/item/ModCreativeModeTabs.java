package net.nrnj.fiftyperks.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nrnj.fiftyperks.FiftyPerksMod;
import net.nrnj.fiftyperks.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FiftyPerksMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FIFTYPERKS_TAB = CREATIVE_MODE_TABS.register("fiftyperks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.EMPTY_PERK.get()))
                    .title(Component.translatable("creativetab.fiftyperks_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.EMPTY_PERK.get());
                        pOutput.accept(ModBlocks.TEST_BLOCK.get());
                        pOutput.accept(ModItems.VOLTAGE_VIAL_PERK.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
