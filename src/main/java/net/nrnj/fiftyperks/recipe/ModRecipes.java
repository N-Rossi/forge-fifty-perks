package net.nrnj.fiftyperks.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nrnj.fiftyperks.FiftyPerksMod;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, FiftyPerksMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<PerkFillingRecipe>> PERK_FILLING_SERIALIZER =
            SERIALIZERS.register("perk_filling", () -> PerkFillingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
