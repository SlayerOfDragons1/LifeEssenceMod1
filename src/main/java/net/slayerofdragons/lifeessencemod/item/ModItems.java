package net.slayerofdragons.lifeessencemod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slayerofdragons.lifeessencemod.LifeEssenceMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LifeEssenceMod.MOD_ID);

        public static final RegistryObject<Item> LIFEESSENCEINGOT = ITEMS.register("lifeessenceingot",
                () ->  new Item(new Item.Properties().fireResistant().tab(ModCreativeModeTab.LIFE_ESSENCE_TAB)));



            public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
            }
}
