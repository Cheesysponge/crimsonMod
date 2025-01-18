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

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SAPPHIRE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for(int i = 0; i< ModItems.armor.length; i++) {
            itemModelGenerator.registerArmor((ArmorItem) ModItems.armor[i]);
        }
        for(Item item : ModItems.items_for_textures) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
        for(Item tool : ModItems.tools){
            itemModelGenerator.register(tool, Models.HANDHELD);
        }
    }
}