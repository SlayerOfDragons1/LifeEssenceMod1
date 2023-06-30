package net.slayerofdragons.lifeessencemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab LIFE_ESSENCE_TAB = new CreativeModeTab("lifeessencetab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.LIFEESSENCEINGOT.get());
        }
    };
}
