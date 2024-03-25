package net.nrnj.fiftyperks.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.nrnj.fiftyperks.FiftyPerksMod;
import net.nrnj.fiftyperks.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FiftyPerksMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TEST_BLOCK);
        blockWithItem(ModBlocks.BLOCK_OF_ELEMENT_115);
        blockWithItem(ModBlocks.ELEMENT_115_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ELEMENT_115_ORE);
        // add other modded blocks here
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
