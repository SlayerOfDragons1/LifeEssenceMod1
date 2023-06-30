package net.slayerofdragons.lifeessencemod.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.slayerofdragons.lifeessencemod.LifeEssenceMod;
import net.slayerofdragons.lifeessencemod.recipe.LifeEssenceCauldronRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin

public class JEILifeEssenceModPlugin implements IModPlugin {

    public static RecipeType<LifeEssenceCauldronRecipe> LIFE_ESSENCE_INFUSING_TYPE =
            new RecipeType<>(LifeEssenceCauldronRecipeCategory.UID, LifeEssenceCauldronRecipe.class);
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(LifeEssenceMod.MOD_ID, "jei plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                LifeEssenceCauldronRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<LifeEssenceCauldronRecipe> recipesInfusing = rm.getAllRecipesFor(LifeEssenceCauldronRecipe.Type.INSTANCE);
        registration.addRecipes(LIFE_ESSENCE_INFUSING_TYPE, recipesInfusing);
    }
}
