package name.crimson.datagen;

import name.crimson.blocks.ModBlocks;
import name.crimson.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.ItemTags;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.(ModBlocks.CRIMSON_CHOMPER_EYE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for(int i = 0; i< ModItems.items_for_textures.length; i++) {
            itemModelGenerator.register(ModItems.items_for_textures[i], Models.GENERATED);
        }
    }
}