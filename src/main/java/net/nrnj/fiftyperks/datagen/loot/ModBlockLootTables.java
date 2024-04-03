package net.nrnj.fiftyperks.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.nrnj.fiftyperks.block.ModBlocks;
import net.nrnj.fiftyperks.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {


    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.TEST_BLOCK.get());
        this.dropSelf(ModBlocks.BLOCK_OF_ELEMENT_115.get());
        this.dropSelf(ModBlocks.PERK_FILLING_STATION.get());

        this.add(ModBlocks.DEEPSLATE_ELEMENT_115_ORE.get(),
                block -> createCustomOreDrops(ModBlocks.DEEPSLATE_ELEMENT_115_ORE.get(), ModItems.RAW_ELEMENT_115.get()));
        this.add(ModBlocks.ELEMENT_115_ORE.get(),
                block -> createCustomOreDrops(ModBlocks.ELEMENT_115_ORE.get(), ModItems.RAW_ELEMENT_115.get()));


        // for custom ores
//        this.add(ModBlocks.TEST_BLOCK.get(),
//                block -> createCustomOreDrops(ModBlocks.TEST_BLOCK.get(), ModItems.EMPTY_PERK.get()));
    }

    protected LootTable.Builder createCustomOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
