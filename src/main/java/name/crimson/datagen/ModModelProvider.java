package name.crimson.datagen;

import name.crimson.block.ModBlocks;
import name.crimson.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import static net.minecraft.data.server.recipe.RecipeProvider.getRecipeName;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);

        blockStateModelGenerator.registerParentedItemModel(ModBlocks.BLACKSTONE_FLOWER, Identifier.of("crimson","block/"+getRecipeName(ModBlocks.BLACKSTONE_FLOWER.asItem())));
        blockStateModelGenerator.registerParentedItemModel(ModBlocks.BIG_BLACKSTONE_FLOWER, Identifier.of("crimson","block/"+getRecipeName(ModBlocks.BIG_BLACKSTONE_FLOWER.asItem())));



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        for(int i = 0; i< ModItems.armor.length; i++) {
            itemModelGenerator.registerArmor((ArmorItem) ModItems.armor[i]);
        }
        for(Item item : ModItems.items_for_textures) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
        itemModelGenerator.register(Item.fromBlock(ModBlocks.BLACKSTONE_SPIKE), Models.GENERATED);

        for(Item tool : ModItems.tools){
            itemModelGenerator.register(tool, Models.HANDHELD);
        }
    }
}