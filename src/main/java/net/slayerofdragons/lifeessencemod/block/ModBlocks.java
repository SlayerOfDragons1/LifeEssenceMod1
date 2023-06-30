package net.slayerofdragons.lifeessencemod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slayerofdragons.lifeessencemod.LifeEssenceMod;
import net.slayerofdragons.lifeessencemod.block.custom.LifeEssenceCauldronBlock;
import net.slayerofdragons.lifeessencemod.item.ModCreativeModeTab;
import net.slayerofdragons.lifeessencemod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LifeEssenceMod.MOD_ID);

    public static final RegistryObject<Block> LIFE_ESSENCE_BLOCK = RegisterBlock("life_essence_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(8f).requiresCorrectToolForDrops()), ModCreativeModeTab.LIFE_ESSENCE_TAB);

    public static final RegistryObject<Block> LIFE_ESSENCE_CAULDRON = RegisterBlock("life_essence_cauldron",
            () -> new LifeEssenceCauldronBlock(BlockBehaviour.Properties.of(Material.METAL).strength(8f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.LIFE_ESSENCE_TAB);




    private static <T extends Block> RegistryObject<T> RegisterBlock(String name, Supplier<T>Block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, Block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
