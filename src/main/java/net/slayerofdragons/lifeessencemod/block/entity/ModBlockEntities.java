package net.slayerofdragons.lifeessencemod.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slayerofdragons.lifeessencemod.LifeEssenceMod;
import net.slayerofdragons.lifeessencemod.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LifeEssenceMod.MOD_ID);


    public static final RegistryObject<BlockEntityType<LifeEssenceCauldronBlockEntity>> LIFE_ESSENCE_CAULDRON =
            BLOCK_ENTITIES.register("life_essence_cauldron", () ->
                    BlockEntityType.Builder.of(LifeEssenceCauldronBlockEntity::new,
                            ModBlocks.LIFE_ESSENCE_CAULDRON.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
