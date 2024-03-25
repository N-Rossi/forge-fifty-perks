package net.nrnj.fiftyperks.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nrnj.fiftyperks.FiftyPerksMod;
import net.nrnj.fiftyperks.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FiftyPerksMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
//        this.tag(ModTags.Blocks.moddedblocks)
//                .add(ModBlocks.TEST_BLOCK.get()).addTag(Tags.Blocks.ORES); // for custom tags

        // similar for all other mineable with tools
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.TEST_BLOCK.get(),
                        ModBlocks.BLOCK_OF_ELEMENT_115.get(),
                        ModBlocks.ELEMENT_115_ORE.get(),
                        ModBlocks.DEEPSLATE_ELEMENT_115_ORE.get()

                ); // can add more blocks inside add method

        // similar for all other NEEDS_X_TOOL level
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        ModBlocks.BLOCK_OF_ELEMENT_115.get(),
                        ModBlocks.ELEMENT_115_ORE.get(),
                        ModBlocks.DEEPSLATE_ELEMENT_115_ORE.get()
                );


        // similar for all other modded tool levels (gold, netherite, etc)
//        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
//                .add(
//                        ModBlocks.TEST_BLOCK.get()
//                );
    }
}
