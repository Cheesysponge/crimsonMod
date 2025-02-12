package name.crimson.datagen;

import name.crimson.Crimson;
import name.crimson.block.ModBlocks;
import name.crimson.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
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
    public void generate(RecipeExporter exporter) {
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

        for(Item tool : ModItems.tools) {
            ingotRecipeGenerator(exporter,tool);
        }
        for(Item armor : ModItems.armor) {
            ingotRecipeGenerator(exporter,armor);
        }
        ingotRecipeGenerator(exporter, Item.fromBlock(ModBlocks.SAPPHIRE_BLOCK));
    }

    public void TwoItemShapelessRecipeGenerator(Item First,Item Second, Item output, RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .input(First)
                .input(Second)
                .criterion(FabricRecipeProvider.hasItem(First),
                        FabricRecipeProvider.conditionsFromItem(First))
                .criterion(FabricRecipeProvider.hasItem(Second),
                        FabricRecipeProvider.conditionsFromItem(Second))
                .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(output)));
    }
    public void OneItemShapelessRecipeGenerator(Item First,int count, Item output, RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .input(First, count)
                .criterion(FabricRecipeProvider.hasItem(First),
                        FabricRecipeProvider.conditionsFromItem(First))

                .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(output)));
    }
    public void ingotRecipeGenerator(RecipeExporter exporter, Item Output){

        Item First = Items.BARRIER;
        String OutName = getRecipeName(Output);
        Crimson.LOGGER.info("Out: " + OutName);

        if(OutName.contains("sapphire")) {
            First = ModItems.SAPPHIRE;
        }
        else if(OutName.contains("ruby")) {
            First = ModItems.RUBY;
        }
        else{
            First = Items.BARRIER;
        }

        if(getRecipeName(Output).contains("sword")){
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("#")
                    .pattern("#")
                    .pattern("I")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("saber")){
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern("###")
                    .pattern(" I ")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("_axe")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("##")
                    .pattern("I#")
                    .pattern("I ")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("pickaxe")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern(" I ")
                    .pattern(" I ")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("hoe")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("##")
                    .pattern("I ")
                    .pattern("I ")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("shovel")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("#")
                    .pattern("I")
                    .pattern("I")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("chestplate")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("# #")
                    .pattern("###")
                    .pattern("###")
                    .input('#', First)


                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("leggings")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern("# #")
                    .pattern("# #")
                    .input('#', First)


                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("boots")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("# #")
                    .pattern("# #")
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("helmet")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern("# #")
                    .input('#', First)


                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }

        if(getRecipeName(Output).contains("block")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern("###")
                    .pattern("###")
                    .input('#', First)


                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, First)
                    .input(Output)
                    .criterion(FabricRecipeProvider.hasItem(Output),
                            FabricRecipeProvider.conditionsFromItem(Output))
                    .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(First)));
        }

    }

}
