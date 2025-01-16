package name.crimson.datagen;

import name.crimson.blocks.ModBlocks;
import name.crimson.entity.ModEntities;
import name.crimson.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        for(int i = 0; i < ModBlocks.items.length; i++) {
            addDrop(ModBlocks.items[i]);
            addDrop(ModBlocks.NETHER_SAPPHIRE_ORE, dropsWithSilkTouch(ModBlocks.NETHER_SAPPHIRE_ORE, this.applyExplosionDecay(ModBlocks.NETHER_SAPPHIRE_ORE, ItemEntry.builder(ModItems.SAPPHIRE).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1F, 2.0F))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))));
        }
    }
 }
