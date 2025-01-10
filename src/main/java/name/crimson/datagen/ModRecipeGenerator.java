package name.crimson.datagen;

import name.crimson.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        OneItemShapelessRecipeGenerator(Items.NETHER_WART,3,ModItems.NETHER_WART_BREAD,exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CRIMSON_EYE, 1)
                .input(Items.ENDER_EYE)
                .input(Items.GOLD_INGOT)
                .input(Items.NETHER_WART_BLOCK,4)
                .input(Items.CRIMSON_HYPHAE,3)
                .criterion(FabricRecipeProvider.hasItem(Items.ENDER_EYE),
                        FabricRecipeProvider.conditionsFromItem(Items.ENDER_EYE))
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(ModItems.CRIMSON_EYE)));
    }

    public void TwoItemShapelessRecipeGenerator(Item First,Item Second, Item output, Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .input(First)
                .input(Second)
                .criterion(FabricRecipeProvider.hasItem(First),
                        FabricRecipeProvider.conditionsFromItem(First))
                .criterion(FabricRecipeProvider.hasItem(Second),
                        FabricRecipeProvider.conditionsFromItem(Second))
                .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(output)));
    }
    public void OneItemShapelessRecipeGenerator(Item First,int count, Item output, Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .input(First, count)
                .criterion(FabricRecipeProvider.hasItem(First),
                        FabricRecipeProvider.conditionsFromItem(First))

                .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(output)));
    }
}
