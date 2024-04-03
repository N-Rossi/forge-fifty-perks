package net.nrnj.fiftyperks.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nrnj.fiftyperks.FiftyPerksMod;
import net.nrnj.fiftyperks.block.ModBlocks;
import net.nrnj.fiftyperks.block.custom.PerkFillingStationBlock;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FiftyPerksMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<PerkFillingStationBlockEntity>> PERK_FILLING_BE =
            BLOCK_ENTITIES.register("perk_filling_be", () ->
                    BlockEntityType.Builder.of(PerkFillingStationBlockEntity::new,
                            ModBlocks.PERK_FILLING_STATION.get()).build(null));

    public static void register(IEventBus eventBus)  {
        BLOCK_ENTITIES.register(eventBus);
    }
}
