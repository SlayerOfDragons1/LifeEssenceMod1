package net.slayerofdragons.lifeessencemod.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slayerofdragons.lifeessencemod.LifeEssenceMod;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, LifeEssenceMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<LifeEssenceCauldronRecipe>> LIFE_ESSENCE_SERIALIZER =
            SERIALIZERS.register("life_essence_infusing", () -> LifeEssenceCauldronRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
