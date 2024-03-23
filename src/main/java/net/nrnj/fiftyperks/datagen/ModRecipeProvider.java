package net.nrnj.fiftyperks.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.nrnj.fiftyperks.FiftyPerksMod;
import net.nrnj.fiftyperks.block.ModBlocks;
import net.nrnj.fiftyperks.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> ELEMENT_115_SMELTABLES = List.of(ModItems.RAW_ELEMENT_115.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // smelting (for future ore use)
        oreSmelting(pWriter,
                ELEMENT_115_SMELTABLES,
                RecipeCategory.MISC,
                ModItems.ELEMENT_115_CRYSTAL.get(),
                0.25F, 100, "element_115");
        oreBlasting(pWriter,
                ELEMENT_115_SMELTABLES,
                RecipeCategory.MISC,
                ModItems.ELEMENT_115_CRYSTAL.get(),
                0.25F, 50, "element_115");

        /** Shaped Recipes */
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMPTY_PERK.get())
                .pattern(" X ")
                .pattern("X X")
                .pattern("XXX")
                .define('X', Blocks.GLASS.asItem())
                .unlockedBy(getHasName(Blocks.GLASS), has(Blocks.GLASS))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_ELEMENT_115.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.ELEMENT_115_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.ELEMENT_115_CRYSTAL.get()), has(ModItems.ELEMENT_115_CRYSTAL.get()))
                .save(pWriter);

        // Shapeless Recipe
        // TODO Shapeless recipe for block -> crystal not working
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ELEMENT_115_CRYSTAL.get(), 9)
                .requires(ModBlocks.BLOCK_OF_ELEMENT_115.get())
                .unlockedBy(getHasName(ModBlocks.BLOCK_OF_ELEMENT_115.get()), has(ModBlocks.BLOCK_OF_ELEMENT_115.get()));
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, FiftyPerksMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}