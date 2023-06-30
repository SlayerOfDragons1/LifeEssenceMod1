package net.slayerofdragons.lifeessencemod.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.slayerofdragons.lifeessencemod.LifeEssenceMod;
import net.slayerofdragons.lifeessencemod.block.ModBlocks;
import net.slayerofdragons.lifeessencemod.recipe.LifeEssenceCauldronRecipe;

public class LifeEssenceCauldronRecipeCategory implements IRecipeCategory<LifeEssenceCauldronRecipe> {

    public final static ResourceLocation UID = new ResourceLocation(LifeEssenceMod.MOD_ID, "life_essence_infusing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(LifeEssenceMod.MOD_ID, "textures/gui/life_essence_cauldron_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public LifeEssenceCauldronRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.LIFE_ESSENCE_CAULDRON.get()));
    }

    @Override
    public RecipeType<LifeEssenceCauldronRecipe> getRecipeType() {
        return JEILifeEssenceModPlugin.LIFE_ESSENCE_INFUSING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Life Essence Cauldron");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, LifeEssenceCauldronRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 86, 15).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 60).addItemStack(recipe.getResultItem());
    }
}
