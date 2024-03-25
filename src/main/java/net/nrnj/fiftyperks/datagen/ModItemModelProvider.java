package net.nrnj.fiftyperks.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.nrnj.fiftyperks.FiftyPerksMod;
import net.nrnj.fiftyperks.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FiftyPerksMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Perk Items
        simpleItem(ModItems.EMPTY_PERK);
        simpleItem(ModItems.VOLTAGE_VIAL_PERK);
        simpleItem(ModItems.JUGGERNOG_PERK);

        // Element 115 Items
        simpleItem(ModItems.RAW_ELEMENT_115);
        simpleItem(ModItems.ELEMENT_115_CRYSTAL);
    }

    /**
     * Custom add simple item method
     * @param item
     * @return
     */
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FiftyPerksMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
